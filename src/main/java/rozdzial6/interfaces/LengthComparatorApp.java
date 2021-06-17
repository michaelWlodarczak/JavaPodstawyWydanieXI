package rozdzial6.interfaces;

import rozdzial6.interfaces.LengthComparator;

public class LengthComparatorApp {
    public static void main(String[] args) {
        String word1 = "Michal";
        String word2 = "Krzysztof";
        String word3 = "Hanna";

        System.out.println(word1.length() - word2.length() + "\n");

        var comparator = new LengthComparator();
        System.out.println(comparator.compare(word1, word2) + "\n");
        if (comparator.compare(word1, word2)>0){
            System.out.println("1");
        }else if (comparator.compare(word1,word2)==0){
            System.out.println("0");
        }else {
            System.out.println("-1");
        }

        System.out.println(word2.compareTo(word3));

    }
}

