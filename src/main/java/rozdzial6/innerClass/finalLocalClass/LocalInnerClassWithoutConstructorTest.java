package rozdzial6.innerClass.finalLocalClass;

import javax.swing.*;

public class LocalInnerClassWithoutConstructorTest {
    public static void main(String[] args) {
        LocalTalkingClockWithoutConstructor localTalkingClockWithoutConstructor = new LocalTalkingClockWithoutConstructor();
        localTalkingClockWithoutConstructor.start(1000,true);

        JOptionPane.showMessageDialog(null,"Zamknij program");

    }
}
