package rozdzial5.enums;

import java.util.Scanner;

public class EnumTest {
    public static void main(String[] args) {
        /*Program dodatkowo lapie wyjatek
        gdyby nie bylo try-catch, to po wpisaniu np. extra large bez podkreslenia wyskoczylby wyjatek
        zamykajac program
         */
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Podaj rozmiar: (SMALL, MEDIUM, LARGE, EXTRA_LARGE)");
            String input = in.next().toUpperCase();
            Size size = Enum.valueOf(Size.class, input);
            System.out.println("Rozmiar " + size);
            System.out.println("Skrot: " + size.getAbbreviation());
            if (size == Size.EXTRA_LARGE)
                System.out.println("Dobra robota -- nie pominales znaku podkreslenia _extra large");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
