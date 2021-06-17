package rozdzial6.innerClass.staticInnerClass;

import java.util.Arrays;

public class StaticInnerClassTest {
    public static void main(String[] args) {
        //tworze tablice 20-sto elemetowa
       var values = new double[20];

       //wypelnial tablice losowymi liczbami z zakresu 0 - 99
        for (int i = 0; i < values.length; i++)
            values[i] = 100*Math.random();

        //Wywoluje statyczna metode 'minmax()
        ArrayAlg.Pair p = ArrayAlg.minmax(values);

        //Wyswietlenie wartosci tablicy
        System.out.println(Arrays.toString(values) +"\n");
        System.out.println("min: " + p.getFirst() + "\n");
        System.out.println("max: " + p.getSecond());

    }
}
