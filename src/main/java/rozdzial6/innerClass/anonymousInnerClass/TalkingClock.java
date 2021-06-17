package rozdzial6.innerClass.anonymousInnerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class TalkingClock {
    public void start(int interval, boolean beep) {
        var listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("Kiedy uslyszysz dzwiek, bedzie godzina: " +
                        Instant.ofEpochMilli(event.getWhen()));
                if (beep) Toolkit.getDefaultToolkit().beep();
            }

            //            public void actionPerformer(ActionEvent event){
//                System.out.println("Kiedy uslyszysz dzwiek, bedzie godzina: " +
//                        Instant.ofEpochMilli(event.getWhen()));
//                if (beep) Toolkit.getDefaultToolkit().beep();
//            }
//        };

        };
        var timer = new Timer(interval, listener);
        timer.start();
    }
}
