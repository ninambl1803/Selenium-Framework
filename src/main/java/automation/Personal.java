package automation;

import java.util.Arrays;
import java.util.List;

public class Personal {
    private String name;
    private int height;
    private int mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;

    public Personal(String name, int height, int mass, String hair_color, String skin_color, String eye_color, String birth_year, String gender) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hair_color;
        this.skin_color = skin_color;
        this.eye_color = eye_color;
        this.birth_year = birth_year;
        this.gender = gender;
    }

    public void info(){
        System.out.printf("name: %s\n",this.name);
        System.out.printf("height: %d\n",this.height);
        System.out.printf("mass: %d\n",this.mass);
        System.out.printf("hair_color: %s\n",this.hair_color);
        System.out.printf("skin_color: %s\n",this.skin_color);
        System.out.printf("eye_color: %s\n",this.eye_color);
        System.out.printf("birth_year: %s\n",this.birth_year);
        System.out.printf("gender: %s\n",this.gender);
        System.out.println("--------------------------");
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getMass() {
        return mass;
    }

    public String getHair_color() {
        return hair_color;
    }

    public String getSkin_color() {
        return skin_color;
    }

    public String getEye_color() {
        return eye_color;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public String getGender() {
        return gender;
    }

    public static void main(String[] args) {
        Personal person1 = new Personal("Luke Skywalker", 172, 77, "blond", "fair", "blue", "19BBY", "male");
        Personal person2 = new Personal("Darth Vader", 202, 136, "none", "white", "yellow", "41.9BBY", "male");
        Personal person3 = new Personal("Leia Organa", 150, 49, "brown", "light", "brown", "19BBY", "female");
        Personal person4 = new Personal("Owen Lars", 178, 120, "brown, grey", "light", "blue", "52BBY", "male");
        Personal person5 = new Personal("Beru Whitesun lars", 165, 75, "brown", "light", "blue", "47BBY", "female");
        Personal person6 = new Personal("Biggs Darklighter", 183, 84, "black", "light", "brown", "24BBY", "male");
        Personal person7 = new Personal("Obi-Wan Kenobi", 182, 77, "auburn, white", "fair", "blue-gray", "57BBY", "male");

        //Convert JSON ARRAY TO ARRAY OBJECT
        List<Personal> characters = Arrays.asList(person1, person2, person3, person4, person5, person6, person7);
        characters.forEach(Personal::info);
    }
}

