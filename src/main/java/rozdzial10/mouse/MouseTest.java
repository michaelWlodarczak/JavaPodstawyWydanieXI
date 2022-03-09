package rozdzial10.mouse;

import rozdzial10.font.FontFrame;

import javax.swing.*;
import java.awt.*;

public class MouseTest {
    public static void main(String[] args) {

        EventQueue.invokeLater(() ->
        {
            var frame = new MouseFrame();
            frame.setTitle("MouseTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });

    }
}
