package rozdzial10.text;

import rozdzial10.preferences.ImageViewerFrame;

import javax.swing.*;
import java.awt.*;

public class TextComponentFrameTest {
    public static void main(String[] args) {

        EventQueue.invokeLater(()->{
            var frame = new TextComponentFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
