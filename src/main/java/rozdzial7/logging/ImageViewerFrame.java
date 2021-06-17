package rozdzial7.logging;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImageViewerFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;

    private JLabel label;
    public static Logger logger = Logger.getLogger("C:\\Users\\Michal\\IdeaProjects\\JavaPodstawyWydanieXI\\logger.txt");

    public ImageViewerFrame(){
        logger.entering("ImageVieverFrame","<init>");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);

        //Pasek menu
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        var menu = new JMenu("Plik");
        menuBar.add(menu);

        var openItem = new JMenuItem("Otworz");
        menu.add(openItem);
        openItem.addActionListener(new FileOpenListener());

        var exitItem = new JMenuItem("Zamknij");
        menu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logger.fine("Zamykanie");
                System.exit(0);
            }
        });

        //Etykieta
        label = new JLabel();
        add(label);
        logger.exiting("ImageViewerFrame","<init>");
    }

    private class FileOpenListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event) {
            logger.entering("ImageViewerFrame.FileOpenListener","actionPerformed",event);

            //Okno wyboru plikow
            var chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(".")); //??

            //Akceptowanie wyszystkich plikow z rozszerzeniem .gif
            chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
                }

                @Override
                public String getDescription() {
                    return "Obrazy GIF";
                }
            });

            //Wyswietlanie okna dialogowego wyboru pliku
            int r = chooser.showOpenDialog(ImageViewerFrame.this);

            //Jesli plik obrazu zostal zaakceptowany, jest on ustawiony jako ikona etykiety
            if (r == JFileChooser.APPROVE_OPTION){
                String name = chooser.getSelectedFile().getPath();
                logger.log(Level.FINE,"Wczytywanie pliku {0}",name);
                label.setIcon(new ImageIcon(name));
            }else {
                logger.fine("Anulowano okno otwierania pliku");
                logger.exiting("ImageViewerFrame.FileOpenListener","actionPerformed");
            }
        }
    }
}
