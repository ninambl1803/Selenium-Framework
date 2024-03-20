package automation;
import java.util.HashMap;
import java.util.Map;
public class Characters {
        private static void printLast4Chars(String str){
            int size = str.length();
            int counter = size-4;
            for(int i = counter; i<size; i++)
            {
                System.out.print(str.charAt(i));
            }
        }
        private static String removeSpecialCharacters(String str){
            String newStr = str.replaceAll("[%^#$()!_+@]", "");
            return newStr;
        }
        private static void returnFirstAlphabet(String string){
            String word = "";
            String [] split = string.split(" ");

            for(int i=0; i<split.length; i++){
                word = split[i];
                System.out.print(word.charAt(0));
            }
        }
        private static String removeWhiteSpace(String str){
            String newStr = str.replaceAll("\\s", "");
            return newStr;
        }
        private static void printSentenceWithoutDuplicates(String str){
            String [] strSplit = str.split("\\s");
            Map<String, Integer> map = new HashMap<>();
            int counter = 1;

            for(int i=0; i<strSplit.length; i++){
                if(map.containsKey(strSplit[i])){
                    map.put(strSplit[i], map.get(strSplit[i])+1);
                }else{
                    map.put(strSplit[i], counter);
                }
            }
            for(Map.Entry<String,Integer> entryMap: map.entrySet()){
                if(entryMap.getValue()>1){
                    System.out.print(entryMap.getKey()+" ");
                }
            }
        }
    public static void main (String[] args){
        String a = "MachBaoLien";
        printLast4Chars(a);

        String b = "Hello My name is Lien";
        returnFirstAlphabet(b);

        String c = "Hello^^%#$(L!i)e_+n M@ach";
        System.out.print(removeSpecialCharacters(c));

        String d = "         Hell o              Ba     o         ";
        System.out.print(removeWhiteSpace(d));

        String e = "Hello I am Lien Lien en";
        printSentenceWithoutDuplicates(e);
    }
}
