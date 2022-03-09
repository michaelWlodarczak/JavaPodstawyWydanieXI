package rozdzial10.simpleFrame;

import javax.swing.*;
import java.awt.*;

public class SimpleFrameTest {
    public static void main(String[] args) {

        EventQueue.invokeLater(() ->
        {
            var frame = new SimpleFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            /*
                okreslamy co ma sie stac kiedy uzytkownik zamknie ramke aplikac
                w tym przypadku chcemy aby program zostal zamkniety
              */
            frame.setVisible(true);
            /*
            aby wyswietlic ramke, metoda main wywoluje na jej rzecz metode setVisible
             */
        });
    }
}
