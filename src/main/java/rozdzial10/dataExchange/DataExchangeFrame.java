package rozdzial10.dataExchange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataExchangeFrame extends JFrame{

    public static final int TEXT_ROWS = 20;
    public static final int TEXT_COLUMNS = 40;
    private PasswordChooser dialog = null;
    private JTextArea textArea;

    public DataExchangeFrame() {

        //Tworzenie menu Plik
        var mbar = new JMenuBar();
        setJMenuBar(mbar);
        var fileMenu = new JMenu("File");
        mbar.add(fileMenu);

        //Tworzenie elementow menu Polacz i Zamknij
        var connectItem = new JMenuItem("Connect");
        connectItem.addActionListener(new ConnectAction());
        fileMenu.add(connectItem);

        //Opcja Zamknij zamyka program
        var exitItem = new JMenuItem("Close");
        exitItem.addActionListener(event -> System.exit(0));
        fileMenu.add(exitItem);

        textArea = new JTextArea(TEXT_ROWS,TEXT_COLUMNS);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        pack();
    }

    /*
    Akcja Connect wyswietla okno dialogowe z polem hasla
     */

    private class ConnectAction implements ActionListener{

        public void actionPerformed(ActionEvent event){

            //Jesli to pierwszy raz, tworzy okno dialogowe
            if(dialog==null) dialog = new PasswordChooser();

            //Ustawianie wartosci domyslnych
            dialog.setUser(new User("Your name", null));

            //Wyswietlenie okna dialogowego
            if(dialog.showDialog(DataExchangeFrame.this, "Connect")){

                //Pobranie danych uzytkownika w przypadku zatwierdzenia
                User u = dialog.getUser();
                textArea.append("user name = " + u.getName() + ", password = "
                + (new String(u.getPassword())) + "\n");
            }
        }
    }
}
