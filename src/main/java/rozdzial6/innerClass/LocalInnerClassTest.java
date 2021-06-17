package rozdzial6.innerClass;

import javax.swing.*;

public class LocalInnerClassTest {
    public static void main(String[] args) {
        LocalTalkingClock localTalkingClock = new LocalTalkingClock(1000,true);
        localTalkingClock.start();

        JOptionPane.showMessageDialog(null,"Zamnknij program");
    }
}
