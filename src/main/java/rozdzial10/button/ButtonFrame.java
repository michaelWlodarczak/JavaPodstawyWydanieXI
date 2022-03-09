package rozdzial10.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Ramka z panelem zawierajacym przyciski
 */
public class ButtonFrame extends JFrame {

    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ButtonFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //Tworzenie przyciskow
        var yellowButton = new JButton("Yellow");
        var blueButton = new JButton("Blue");
        var redButton = new JButton("Red");

        //Dodanie przyciskow do panelu
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        //Dodanie panelu do ramki
        add(buttonPanel);

        //Utworzenie akcji przyciskow
        var yellowAction = new ColorAction(Color.YELLOW);
        var blueAction = new ColorAction(Color.BLUE);
        var redAction = new ColorAction(Color.RED);

        //Powiazanie akcji z przyciskami
        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);

    }

    private class ColorAction implements ActionListener{

        private Color backgroundColor;

        public ColorAction(Color c){
            backgroundColor = c;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            buttonPanel.setBackground(backgroundColor);
        }
    }
}
