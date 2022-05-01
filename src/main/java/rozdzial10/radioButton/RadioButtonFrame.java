package rozdzial10.radioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//Ramka z przykladowa etykieta i przelacznikami sluzacymi do wyboru rozmiaru czcionki
//Frame with a sample label and switches for selecting the font size
public class RadioButtonFrame extends JFrame{

    private JPanel buttonPanel;
    private ButtonGroup group;
    private JLabel label;
    private static final int DEFAULT_SIZE = 36;

    public RadioButtonFrame(){

        //Dodawanie przykladowej etykiety tekstowej

        label = new JLabel(" The sex of the child is not important, it is more important that it is born healthy");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);

        //Dodanie przelacznikow

        buttonPanel = new JPanel();
        group = new ButtonGroup();

        addRadioButton("Small", 8);
        addRadioButton("Medium", 12);
        addRadioButton("Large", 18);
        addRadioButton("Very Large", 36);

        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    /*
    Tworzy przelacznik ustawiajacy rozmiar czcionki przykladowego tekstu.
   @param name lancuch identyfikujacy przelacznik
   @param size rozmiar czcionki ustawiamy przez ten przelacznik
     */

    public void addRadioButton(String name, final int size){
        boolean selected = size == DEFAULT_SIZE;
        var button = new JRadioButton(name, selected);
        group.add(button);
        buttonPanel.add(button);

        //Ten nasluchiwac ustawia rozmiar czcionki etykiety

        ActionListener listener = event -> label.setFont(new Font("Serif", Font.PLAIN, size));

        button.addActionListener(listener);
    }
}
