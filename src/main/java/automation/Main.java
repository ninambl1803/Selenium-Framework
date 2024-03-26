package automation;

import java.util.Arrays;

public class Main {
    public static boolean kiem_tra_password(String password){
        String test =  "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{8,20})";
        return (password.matches(test));

//        return isGreater8length(password) && isContainLowerCase(password) && isContainNumber(password) && isContainSpecialChars(password) && isContainUpperCase(password);
    }

    public static boolean isGreater8length(String password){
        return password.length() >=8;
    }
    public static boolean isContainLowerCase(String password){
        boolean check =  false;
        for(int i =0;i<password.length();i++){
            if (Character.isLowerCase(password.charAt(i))){
                check = true;
                break;
            };
        }
        return check;
    }
    public static boolean isContainUpperCase(String password){
        boolean check =  false;
        for(int i =0;i<password.length();i++){
            if (Character.isUpperCase(password.charAt(i))){
                check = true;
                break;
            };
        }
        return check;
    }

    public static boolean isContainNumber(String password){
        boolean check =  false;
        for(int i =0;i<password.length();i++){
            if (Character.isDigit(password.charAt(i))){
                check = true;
                break;
            };
        }
        return check;
    }

    public static boolean isContainSpecialChars(String password){
        return  password.contains("@") || password.contains("%");
    }

    public static boolean kiem_tra_nguyen_am(String letter){
        if(letter.length()!=1) throw new IllegalArgumentException("vui long nhap 1 ky tu chu cai");
        return letter.contains("u") || letter.contains("e") || letter.contains("o") || letter.contains("a") || letter.contains("i");
    }

    public static void main(String[] args) {
        System.out.println(kiem_tra_nguyen_am("ai"));
    }

    public static int phan_tu_lon_nhat_trong_mang(int [] array) {
        int max=0;
        for(int i=1; i<array.length;i++){
            if(array[i]>array[max]){
                max=i;
            }
        }
        return max;
    }
    public static int[] swap(int[] array, int index1, int index2){
        array[index1]=array[index1]+array[index2];
        array[index2]=array[index1]-array[index2];
        array[index1]=array[index1]-array[index2];
        return array;
    }
}