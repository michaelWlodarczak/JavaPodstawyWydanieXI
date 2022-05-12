package rozdzial10.dataExchange;

import rozdzial10.dialog.DialogFrame;

import javax.swing.*;
import java.awt.*;

public class DataExchangeFrameTest {
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            var frame = new DataExchangeFrame();
            frame.setTitle("Data Exchange Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

