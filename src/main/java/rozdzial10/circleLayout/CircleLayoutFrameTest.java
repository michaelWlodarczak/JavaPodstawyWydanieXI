package rozdzial10.circleLayout;

import rozdzial10.menu.MenuFrame;

import javax.swing.*;
import java.awt.*;

public class CircleLayoutFrameTest {
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            var frame = new CircleLayoutFrame();
            frame.setTitle("Circle Layout Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
