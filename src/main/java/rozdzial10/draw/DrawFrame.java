package rozdzial10.draw;

import javax.swing.*;

/*
RAMKA ZAWIERAJACA OKIENO Z RYSUNKAMI
 */
public class DrawFrame extends JFrame {

    public DrawFrame(){
        add(new DrawComponent());
        pack();
    }
}
