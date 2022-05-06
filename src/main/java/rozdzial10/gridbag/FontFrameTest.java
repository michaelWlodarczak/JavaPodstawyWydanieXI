package rozdzial10.gridbag;

import rozdzial10.menu.MenuFrame;

import javax.swing.*;
import java.awt.*;

public class FontFrameTest {
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            var frame = new FontFrame();
            frame.setTitle("Font Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
