package rozdzial10.checkBox;

import rozdzial10.preferences.ImageViewerFrame;

import javax.swing.*;
import java.awt.*;

public class CheckBoxFrameTest {
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            var frame = new CheckBoxFrame();
            frame.setTitle("Check Box Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

