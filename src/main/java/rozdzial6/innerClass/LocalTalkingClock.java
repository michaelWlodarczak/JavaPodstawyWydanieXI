package rozdzial6.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class LocalTalkingClock {
    private int interval;
    private boolean beep;

    public LocalTalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    //Lokalna klasa wewnetrzna
    //klasa wewnatrz metody

    public void start(){
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
