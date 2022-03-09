package rozdzial10.draw;

import javax.swing.*;
import java.awt.*;

public class DrawTest {
    public static void main(String[] args) {

        EventQueue.invokeLater(() ->
                {
                 var frame = new DrawFrame();
                 frame.setTitle("Draw Test");
                 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 frame.setVisible(true);
                });
    }
}
