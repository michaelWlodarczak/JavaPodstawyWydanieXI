package rozdzial6.innerClass.finalLocalClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class LocalTalkingClockWithoutConstructor {

/*
Klasy lokalne maja jeszcze jedna ceche, ktora wyroznia je na tle pozostalych klas wewnetrznych
Maja one dostep nie tylko do pol klas je otaczajacych, ale rowniez do zmiennych lokalnych.
Zmienne te musza byc jednak FAKTYCZNIE FINALNE. To znaczy, ze ich wartosc po pierwszym przypisaniu nie
moze sie juz zmienic.
 */

    public void start(int interval, boolean beep){
        class TimePrinter implements ActionListener{
            public void actionPerformed(ActionEvent event){
                System.out.println("Kiedy uslyszysz dzwiek bedzie godzina: " +
                        Instant.ofEpochMilli(event.getWhen()));
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }
        var listener = new TimePrinter();
        var timer = new Timer(interval,listener);
        timer.start();
    }

}
