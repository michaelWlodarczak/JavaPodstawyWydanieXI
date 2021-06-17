package rozdzial6.proxy;

/*
Klasy Posredniczace
TODO - Wrocic do tego jak bede madrzejszy xD poki co totalnie tego nie rozumiem
 */

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {
    public static void main(String[] args) {
        var elements = new Object[1000];

        //Wstawienie do tablicy obiektow posredniczacych liczb calkowitych z przedzialu 1 - 1000

        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            var handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(
                    ClassLoader.getSystemClassLoader(),
                    new Class[]{Cloneable.class}, handler);
            elements[i] = proxy;
        }

        //Tworzenie losowej liczby calkowitej
        Integer key = new Random().nextInt(elements.length) + 1;

        //Szukanie liczby
        int result = Arrays.binarySearch(elements,key);

        //Drukowanie dopasowanej wartosci, jesli zostanie znaleziona
        if (result >= 0)
            System.out.println(elements[result]);
    }
}


