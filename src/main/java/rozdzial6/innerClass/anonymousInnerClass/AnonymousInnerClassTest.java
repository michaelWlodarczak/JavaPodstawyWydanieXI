package rozdzial6.innerClass.anonymousInnerClass;

import javax.swing.*;

public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        var talkingClock = new TalkingClock();
        talkingClock.start(1000, true);

        JOptionPane.showMessageDialog(null,"Zamknij program");
    }
}
