package rozdzial10.preferences;

import javax.swing.*;
import java.awt.*;


public class ImageViewer {
    public static void main(String[] args) {

        EventQueue.invokeLater(()->{
            var frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
