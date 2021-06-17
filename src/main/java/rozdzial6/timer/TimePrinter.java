package rozdzial6.timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class TimePrinter implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        System.out.println("Kiedy uslyszysz dzwiek, bedzie godzina " + Instant.ofEpochMilli(event.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }
}
