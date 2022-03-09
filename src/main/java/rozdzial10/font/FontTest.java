package rozdzial10.font;

import javax.swing.*;
import java.awt.*;

public class FontTest {
    public static void main(String[] args) {

        EventQueue.invokeLater(() ->
        {
            var frame = new FontFrame();
            frame.setTitle("FontTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
