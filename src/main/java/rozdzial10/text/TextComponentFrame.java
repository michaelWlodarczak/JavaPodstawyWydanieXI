package rozdzial10.text;

import javax.swing.*;
import java.awt.*;

/*
Ramka z przykładowymi komponentmi tekstowymi (Sample frame with text components)
 */

public class TextComponentFrame extends JFrame {

    public static final int TEXTAREA_ROWS = 8;
    public static final int TEXTAREA_COLUMNS = 20;

    public TextComponentFrame(){
        var textField = new JTextField();
        var passwordField = new JPasswordField();

        var northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2,2));
        northPanel.add(new JLabel("Nazwa uzytkownika: ", SwingConstants.RIGHT));
        northPanel.add(textField);
        northPanel.add(new JLabel("Haslo: ", SwingConstants.RIGHT));
        northPanel.add(passwordField);
        
        add(northPanel, BorderLayout.NORTH);

        var textArea = new JTextArea(TEXTAREA_ROWS,TEXTAREA_COLUMNS);
        var scrollPane = new JScrollPane(textArea);

        add(scrollPane, BorderLayout.CENTER);

        //Dodawanie przyciusku wstawiajacego tekst do obszaru tekstowego

        var southPanel = new JPanel();

        var inserButton = new JButton("Wstaw");
        southPanel.add(inserButton);
        inserButton.addActionListener(event ->
                textArea.append("Nazwa uzytkownika: " + textField.getText() + " Haslo: "
                + new String(passwordField.getPassword()) + "\n"));

        add(scrollPane, BorderLayout.SOUTH);
        pack();
    }

}
