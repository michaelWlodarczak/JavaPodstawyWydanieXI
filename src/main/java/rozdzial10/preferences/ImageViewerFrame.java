package rozdzial10.preferences;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.prefs.Preferences;

public class ImageViewerFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private String image;

    public ImageViewerFrame(){
        Preferences root = Preferences.userRoot();
        Preferences node = root.node("/com.horstman/corejava/ImageViewer");
        //pobranie pozycji, rozmiaru i tytulu preferencji
        int left = node.getInt("left",0);
        int top = node.getInt("top",0);
        int width = node.getInt("width",DEFAULT_WIDTH);
        int height = node.getInt("height",DEFAULT_HEIGHT);
        setBounds(left,top,width,height);
        image = node.get("image",null);
        var label = new JLabel();
        if (image != null) label.setIcon(new ImageIcon(image));

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent event){
                node.putInt("left",getX());
                node.putInt("top",getY());
                node.putInt("width",getWidth());
                node.putInt("height",getHeight());
                node.put("image",image);
            }
        });

        //uzycie etykiety do wyswietlania obrazow
        add(label);

        //element wyboru pliku
        var chooer = new JFileChooser();
        chooer.setCurrentDirectory(new File("."));

        //pasek menu
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        var menu = new JMenu("Plik");
        menuBar.add(menu);

        var openItem = new JMenuItem("Otworz");
        menu.add(openItem);
        openItem.addActionListener(event -> {
            //wyswietla okno dialogowe wyboru pliku
            int result = chooer.showOpenDialog(null);

            //jesli plik zostanie wybrany, ustawiago jako ikone etykiety
            if(result==JFileChooser.APPROVE_OPTION){
                image = chooer.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(image));
            }
        });

        var exitItem = new JMenuItem("Zamknij");
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));
    }
}
