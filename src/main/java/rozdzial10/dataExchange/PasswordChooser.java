package rozdzial10.dataExchange;

import javax.swing.*;
import java.awt.*;

/*
Elementy sluzace do podania hasla, ktore widac w oknie dialogowym
 */
public class PasswordChooser extends JPanel {

    private JTextField username;
    private JPasswordField password;
    private JButton okButton;
    private boolean ok;
    private JDialog dialog;

    public PasswordChooser() {

        setLayout(new BorderLayout());

        //Utworzenie panelu z polami nazwy uzytkownika i hasla

        var panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(new JLabel("User name: "));
        panel.add(username = new JTextField(""));
        panel.add(new JLabel("Password: "));
        panel.add(password = new JPasswordField(""));
        add(panel, BorderLayout.CENTER);

        //Utworzenie przyciskow OK i Anuluj, ktore zamykaja okno dialogowe

        okButton = new JButton("OK");
        okButton.addActionListener(event -> {
            ok = true;
            dialog.setVisible(false);
        });

        var cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(event -> dialog.setVisible(false));

        //Dodawanie przyciskow w poblizu poludniowej krawedzi

        var buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /*
    Ustawia watrosc domyslnie okna dialogowego
    @param u domyslnie informacje uzytkownika
     */
    public void setUser(User u){
        username.setText(u.getName());
    }

    /*
    Pobiera dane podane w oknie dialogowym
    @return a obiekt typu User, ktorego stan reprezentuje dane wprowadzone w oknie dialogowym
     */
    public User getUser(){
        return new User(username.getText(),password.getPassword());
    }

    /*
    Wyswietla panel z elementami przyjmujacymi dane od uzytkownika w oknie dialogowym
    @param parent komponent w ramce nadrzednej lub wartosc null
    @param title tytul okna dialogowego
     */
    public boolean showDialog(Component parent, String title){
        ok = false;
        //Lokalizacja ramki nadrzednej

        Frame owner = null;
        if (parent instanceof Frame)
            owner = (Frame) parent;
        else
            owner = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);

        //Jesli jest to pierwszy raz lub zmienil sie uzytkownik, utworzenie nowego okna dialogowego

        if(dialog == null || dialog.getOwner() != owner){
            dialog = new JDialog(owner,true);
            dialog.add(this);
            dialog.getRootPane().setDefaultButton(okButton);
            dialog.pack();
        }

        //Ustawianie tytulu i wyswietlenie okna dialogowego
        dialog.setTitle(title);
        dialog.setVisible(true);
        return ok;

    }
}
