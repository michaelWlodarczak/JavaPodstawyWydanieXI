package rozdzial10.slider;

import rozdzial10.comboBox.ComboBoxFrame;

import javax.swing.*;
import java.awt.*;

public class SliderFrameTest {
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            var frame = new SliderFrame();
            frame.setTitle("Slider Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

