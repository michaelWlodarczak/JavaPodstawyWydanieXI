package rozdzial10.radioButton;

import rozdzial10.checkBox.CheckBoxFrame;

import javax.swing.*;
import java.awt.*;

public class RadioButtonFrameTest {
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            var frame = new RadioButtonFrame();
            frame.setTitle("Radio Button Frame Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}
