package rozdzial10.notHelloWorld;

import javax.swing.*;

public class NotHelloWorldFrame extends JFrame {

    public NotHelloWorldFrame(){
        add(new NotHelloWorldPanel());
        pack();
    }
}
