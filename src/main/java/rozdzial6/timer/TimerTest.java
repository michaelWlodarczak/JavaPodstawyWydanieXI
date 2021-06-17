package rozdzial6.timer;

//Interfejsy i wywolania zwrotne

import javax.swing.*;

public class TimerTest {
    public static void main(String[] args) {
        TimePrinter listener = new TimePrinter();

        //utworzenie zegara wywolujacego obiekt nasluchujacy co sekunde
        Timer timer = new Timer(1000, listener); //strona 288
        timer.start();
        
        //program ma dzialac, dopoki uzytkownik nie nacisnie przycisku OK
        JOptionPane.showMessageDialog(null,"Zamknac program");
        System.exit(0);
    }
}
