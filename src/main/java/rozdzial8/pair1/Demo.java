package rozdzial8.pair1;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        int[] tablicaIntow = {100, 5, 9, 23, 45};
        int min;
        int max;
        min = tablicaIntow[0];
        max = 0;

        //System.out.println(tablicaIntow.length);

        for (int i = 0; i < tablicaIntow.length; i++) {
            if (tablicaIntow[i] < min) min = tablicaIntow[i];
            if (tablicaIntow[i] > max) max = tablicaIntow[i];
        }
        System.out.println("min: " + min);
        System.out.println("max: " + max);

    }
}
