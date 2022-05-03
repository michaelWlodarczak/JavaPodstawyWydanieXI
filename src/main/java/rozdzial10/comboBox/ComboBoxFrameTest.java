package rozdzial10.comboBox;

import rozdzial10.checkBox.CheckBoxFrame;

import javax.swing.*;
import java.awt.*;

public class ComboBoxFrameTest {
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            var frame = new ComboBoxFrame();
            frame.setTitle("Combo Box Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

