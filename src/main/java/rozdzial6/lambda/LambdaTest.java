package rozdzial6.lambda;

import javax.swing.*;
import java.awt.*;
import java.time.Instant;
import java.util.Arrays;

public class LambdaTest {
    public static void main(String[] args) {
        var planets = new String[] {"Merkury","Wenus","Ziemia","Mars","Jowisz","Saturn","Uran","Neptun"};

        System.out.println(Arrays.toString(planets) + "\n");
        System.out.println("Sortowanie alfabetyczne");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets) + "\n");
        System.out.println("Sortowanie wedlug dlugosci");
        Arrays.sort(planets,(first,second) -> first.length()-second.length());  //LAMBDA
        System.out.println(Arrays.toString(planets) + "\n");

//        Timer timer = new Timer(1000, event ->
//                System.out.println("Jest godzina " + new Date()));
//        timer.start();
//        //Utzymuje program w dzialaniu, az uzytkownik kliknie przycisk OK
//        JOptionPane.showMessageDialog(null,"Zamknac program");
//        System.exit(0);

        var t = new Timer(1000, e ->{
                System.out.println("Kiedy uslyszysz dzwiek, bedzie godzina: " + Instant.ofEpochMilli(e.getWhen()));
        Toolkit.getDefaultToolkit().beep();
        });
        t.start();
        JOptionPane.showMessageDialog(null, "Zamknac program");
        System.exit(0);

    }
}
