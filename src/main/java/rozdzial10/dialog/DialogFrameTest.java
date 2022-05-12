package rozdzial10.dialog;

import rozdzial10.comboBox.ComboBoxFrame;

import javax.swing.*;
import java.awt.*;

public class DialogFrameTest {
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            var frame = new DialogFrame();
            frame.setTitle("Dialog Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

