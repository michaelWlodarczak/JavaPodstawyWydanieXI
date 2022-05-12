package rozdzial10.dialog;

import javax.swing.*;
import java.awt.*;

/*
Przykladowe medialne okno dialogowe wyswietlajace komunikat i oczekujace na klikniecie przycisku OK
 */
public class AboutDialog extends JDialog {

    public AboutDialog(JFrame owner) {
        super(owner, "Test okna O programie", true);


        //Dodanie etykiety HTML

        add(new JLabel(
                        "<html><h1><i>Core Java</i></h1><hr> By Cay Horstmann</html>"),
                BorderLayout.CENTER);

        //Przycisk OK zamyka okno

        var ok = new JButton("OK");
        ok.addActionListener(event -> setVisible(false));

        //Dodanie przycisku OK przy krawedzi poludniowej

        var panel = new JPanel();
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);
        pack();
    }
}


