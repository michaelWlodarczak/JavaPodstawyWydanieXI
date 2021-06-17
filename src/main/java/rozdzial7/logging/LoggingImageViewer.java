package rozdzial7.logging;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingImageViewer {
    public static void main(String[] args) {

        if (System.getProperty("java.util.rozdzial7.stackTrace.logging.config.class") == null &&
                System.getProperty("java.util.rozdzial7.stackTrace.logging.config.file") == null) {
            try {
                Logger.getLogger("C:\\Users\\Michal\\IdeaProjects\\JavaPodstawyWydanieXI\\logger.txt")
                        .setLevel(Level.ALL);
                final int LOG_ROTATION_COUNT = 10;
                var handler = new FileHandler("%h/LoggingImageViewer.log", 0, LOG_ROTATION_COUNT);
                Logger.getLogger("C:\\Users\\Michal\\IdeaProjects\\JavaPodstawyWydanieXI\\logger.txt").addHandler(handler);
            } catch (IOException e) {
                Logger.getLogger("C:\\Users\\Michal\\IdeaProjects\\JavaPodstawyWydanieXI\\logger.txt")
                        .log(Level.SEVERE, "Nie mozna utworzyc obiektu obslugi pliku dziennika");
            }
        }
        EventQueue.invokeLater(() -> {
            var windowHandler = new WindowHandler();
            windowHandler.setLevel(Level.ALL);
            Logger.getLogger("C:\\Users\\Michal\\IdeaProjects\\JavaPodstawyWydanieXI\\logger.txt")
                    .addHandler(windowHandler);

            var frame = new ImageViewerFrame();
            frame.setTitle("LoggingImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Logger.getLogger("C:\\Users\\Michal\\IdeaProjects\\JavaPodstawyWydanieXI\\logger.txt")
                    .fine("Wyswietlanie ramki");
            frame.setVisible(true);
        });
    }
}
