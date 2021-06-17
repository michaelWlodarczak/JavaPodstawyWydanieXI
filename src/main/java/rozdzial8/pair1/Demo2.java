package rozdzial8.pair1;

import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) {
//        String s="Today is the happiest day of my life";
//        String[] word = s.split(" ");
        String[] word = {"Definicja","prostej","klasy","generycznej"};
        String shortest = word[0];
        String longest= word[0]; //String longes= " ";
        for(int i=0;i<word.length;i++){
            if(word[i].length()<shortest.length()) shortest=word[i];
            if(word[i].length()>=longest.length()) longest=word[i];
        }
        System.out.println(Arrays.toString(word));
        System.out.println("shortest word:  " + shortest);
        System.out.println("shortest word lenght: " +shortest.length());
        System.out.println("longest word: " + longest);
        System.out.println("longest word lenght: " + longest.length());
    }
}
