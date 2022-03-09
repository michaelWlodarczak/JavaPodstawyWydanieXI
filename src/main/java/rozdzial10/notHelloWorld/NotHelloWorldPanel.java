package rozdzial10.notHelloWorld;

import javax.swing.*;
import java.awt.*;

public class NotHelloWorldPanel extends JComponent {

    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;

    public void paintComponent(Graphics g){
        g.drawString("To nie jest program ,,Witaj Swiecie''",MESSAGE_X,MESSAGE_Y);
    }

    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}
