package rozdzial10.checkBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/*
ramka z przykladowa etykieta tekstowa i polami wyboru
reprezentujacymi rozneatrybuty czcionki
 */
public class CheckBoxFrame extends JFrame {

    private JLabel label;
    private JCheckBox bold;
    private JCheckBox italic;
    private static final int FONTSIZE = 24;

    public CheckBoxFrame(){
        //dodanie przykladowej etykiety
        label = new JLabel(" What will be the sex of the second child?");
        label.setFont(new Font("Serif", Font.BOLD, FONTSIZE));
        add(label, BorderLayout.CENTER);

        //nasluchiwacz ustawiajacy atrybuty czcionki
        //etykiety zgodnie z ustawieniami pol wyboru

        ActionListener listener = event -> {
          int mode = 0;
          if (bold.isSelected()) mode += Font.BOLD;
          if (italic.isSelected()) mode += Font.ITALIC;
          label.setFont(new Font("Serif", mode, FONTSIZE));
        };

        //dodawanie pol wyboru

        var buttonPanel = new JPanel();

        bold = new JCheckBox("Bold");
        bold.addActionListener(listener);
        bold.setSelected(true);
        buttonPanel.add(bold);

        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);
        buttonPanel.add(italic);

        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }
}
