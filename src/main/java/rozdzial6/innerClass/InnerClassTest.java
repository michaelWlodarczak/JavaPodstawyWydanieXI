package rozdzial6.innerClass;

import javax.swing.*;

public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock talkingClock = new TalkingClock(1000,true);
        talkingClock.start();

        //program dziala dopoki urzytkownik wcinie przycisk OK
        JOptionPane.showMessageDialog(null,"Zamknac program");
    }
}
