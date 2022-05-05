package rozdzial10.menu;

import rozdzial10.slider.SliderFrameIcon;

import javax.swing.*;
import java.awt.*;

public class MenuFrameTest {
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            var frame = new MenuFrame();
            frame.setTitle("Menu Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
