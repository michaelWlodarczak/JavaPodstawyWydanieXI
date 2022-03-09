package rozdzial10.button;

import javax.swing.*;
import java.awt.*;


//TODO NULLPOINTEREXCEPTION
public class ButtonTest {
    public static void main(String[] args) {

        EventQueue.invokeLater(() ->
        {

            var frame = new ButtonFrame();
            frame.setTitle("ButtonTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });

    }
}
