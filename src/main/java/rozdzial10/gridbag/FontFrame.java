package rozdzial10.gridbag;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FontFrame extends JFrame {

    public static final int TEXT_ROWS = 10;
    public static final int TEXT_COLUMNS = 20;

    private JComboBox<String> face;
    private JComboBox<Integer> size;
    private JCheckBox bold;
    private JCheckBox italic;
    private JTextArea sample;

    /*
    Ramka zawierajaca komponenty ustawiajace wlasnosci czcionki w rozkladzie GridBagLayout
     */
    public FontFrame() {
        var layout = new GridBagLayout();
        setLayout(layout);

        ActionListener listener = event -> updateSample();

        //Tworzenie komponentow
        var faceLebel = new JLabel("Krój: ");
        face = new JComboBox<>(new String[]{"Serif", "SanSerif", "Monospaced", "Dialog", "DialogInput"});

        face.addActionListener(listener);

        var sizeLabel = new JLabel("Rozmiar: ");
        size = new JComboBox<>(new Integer[]{8, 10, 12, 15, 18, 24, 36, 48});

        size.addActionListener(listener);

        bold = new JCheckBox("Bold");
        bold.addActionListener(listener);

        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);

        sample = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        sample.setText("Everything will be fine with this baby");
        sample.setEnabled(false);
        sample.setLineWrap(true);
        sample.setBorder(BorderFactory.createEtchedBorder());

        //Dodawanie komponentow do siatki przy uzyciu klasy pomocniczej GBC

        add(faceLebel, new GBC(0, 0).setAnchor(GBC.EAST));
        add(faceLebel, new GBC(1, 0).setFill(GBC.HORIZONTAL)
                .setWeight(100, 0).setInsets(1));
        add(faceLebel, new GBC(0, 1).setAnchor(GBC.EAST));
        add(faceLebel, new GBC(1, 1).setFill(GBC.HORIZONTAL)
                .setWeight(100, 0).setInsets(1));
        add(bold, new GBC(0, 2, 2, 1).setAnchor(GBC.CENTER)
                .setWeight(100, 100));
        add(italic, new GBC(0, 3, 2, 1).setAnchor(GBC.CENTER)
                .setWeight(100, 100));
        add(sample, new GBC(2, 0, 1, 4).setFill(GBC.BOTH)
                .setWeight(100, 100));
        pack();
        updateSample();
    }

    public void updateSample() {
        var fontFace = (String) face.getSelectedItem();
        int fontStyle = (bold.isSelected() ? Font.BOLD : 0)
                + (italic.isSelected() ? Font.ITALIC : 0);
        int fontSize = size.getItemAt(size.getSelectedIndex());
        var font = new Font(fontFace, fontStyle, fontSize);
        sample.setFont(font);
        sample.repaint();
    }
}
