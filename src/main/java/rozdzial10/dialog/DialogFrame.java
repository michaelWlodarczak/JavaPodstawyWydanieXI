package rozdzial10.dialog;

import javax.swing.*;

/*
Ramka z menu, ktorego Plik/O programie wyswietla okno dialogowe
 */
public class DialogFrame extends JFrame{

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private AboutDialog dialog;

    public DialogFrame(){

        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        //Tworzenie menu Plik

        var manuBar = new JMenuBar();
        setJMenuBar(manuBar);
        var fileMenu = new JMenu("Plik");
        manuBar.add(fileMenu);

        //Tworzenie elementow O progamie i Zamknij

        //Element O programmie wyswietla okno dialogowe O programie

        var aboutItem = new JMenuItem("O programie");
        aboutItem.addActionListener(event -> {
            if (dialog==null) //pierwszy raz
                dialog = new AboutDialog(DialogFrame.this);
            dialog.setVisible(true); //wyskakujace okno dialogowe
        });
        fileMenu.add(aboutItem);

        //Element Zamknij powoduje zamkniecie programu

        var exitItem = new JMenuItem("Zamknij");
        exitItem.addActionListener(event -> System.exit(0));
        fileMenu.add(exitItem);
    }
}
