package rozdzial6.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        TimePrinter listener = new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    public class TimePrinter implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            System.out.println("Kiedy uslyszysz dzwiek bedzie godzina: " +
                    Instant.ofEpochMilli(event.getWhen()));
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}
