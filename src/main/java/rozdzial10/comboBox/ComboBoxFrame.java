package rozdzial10.comboBox;

import javax.swing.*;
import java.awt.*;

public class ComboBoxFrame extends JFrame {

    private JComboBox<String> faceCombo;
    private JLabel label;
    private static final int DEFAULT_SIZE = 24;

    public ComboBoxFrame(){

        //Dodanie tekstu etykiety

        label = new JLabel("Christopher sleep tight with his teddy bear after long walk.");
        label.setFont(new Font("Serif", Font.PLAIN,DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);

        //Tworzenie listy rozwijalnej i dodawanie nazw czcionek

        faceCombo = new JComboBox<>();
        faceCombo.addItem("Serif");
        faceCombo.addItem("SansSerif");
        faceCombo.addItem("Monospaced");
        faceCombo.addItem("Dialog");
        faceCombo.addItem("DialogInput");

        //Nasluchiwacz listy rozwijalnej zmienia kroj pisma etykiety na czcionke wybrana przez urzytkownika

        faceCombo.addActionListener(event->
                label.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()),
                Font.PLAIN, DEFAULT_SIZE)));

        //Dodawanie listy rozwijalnej do panelu znajdujacego sie przy poludniowej krawedzi ramki

        var comboPanel = new JPanel();
        comboPanel.add(faceCombo);
        add(comboPanel,BorderLayout.SOUTH);
        pack();
    }
}
