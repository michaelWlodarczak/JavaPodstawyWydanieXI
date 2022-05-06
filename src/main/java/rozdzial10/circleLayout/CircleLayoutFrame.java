package rozdzial10.circleLayout;

import javax.swing.*;

public class CircleLayoutFrame extends JFrame {

    public CircleLayoutFrame(){
        setLayout(new CircleLayout());
        add(new JButton("Yellow"));
        add(new JButton("Blue"));
        add(new JButton("Red"));
        add(new JButton("Green"));
        add(new JButton("Orange"));
        add(new JButton("Purple"));
        add(new JButton("Pink"));
        pack();
    }
}
