package rozdzial10.slider;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Hashtable;

public class SliderFrameIcon extends JFrame {

    private JPanel sliderPanel;
    private JTextField textField;
    private ChangeListener listener;

    public SliderFrameIcon(){

        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridBagLayout());

        //Wspolny nasluciwacz wszystkich suwakow
        listener = event -> {
          //Aktualizacja pola tekstowego w odpowiedzi na zmiane wartosci suwaka
          JSlider source = (JSlider) event.getSource();
          textField.setText("" + source.getValue());
        };

        var slider = new JSlider();
        var labelTable = new Hashtable<Integer,Component>();

        //Suwak z etykietami ikonowymi
        slider = new JSlider();
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        labelTable = new Hashtable<Integer, Component>();

        //Dodawanie obrazow kart

        labelTable.put(0, new JLabel(new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaPodstawyWydanieXI\\src\\main\\java\\rozdzial10\\slider\\nine.jpg")));
        labelTable.put(20, new JLabel(new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaPodstawyWydanieXI\\src\\main\\java\\rozdzial10\\slider\\ten.jpg")));
        labelTable.put(40, new JLabel(new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaPodstawyWydanieXI\\src\\main\\java\\rozdzial10\\slider\\jack.jpg")));
        labelTable.put(60, new JLabel(new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaPodstawyWydanieXI\\src\\main\\java\\rozdzial10\\slider\\queen.jpg")));
        labelTable.put(80, new JLabel(new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaPodstawyWydanieXI\\src\\main\\java\\rozdzial10\\slider\\king.jpg")));
        labelTable.put(1000, new JLabel(new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaPodstawyWydanieXI\\src\\main\\java\\rozdzial10\\slider\\ace.jpg")));

        slider.setLabelTable(labelTable);
        addSlider(slider, "Ikony");

        //Dodawanie pola tekstowego, ktore wyswietla wartosc ustawiona na suwaku

        textField = new JTextField();
        add(sliderPanel, BorderLayout.CENTER);
        add(textField, BorderLayout.SOUTH);
        pack();
    }

    /*
    Dodaje suwak do panelu suwakow i dowiazuje nasluchiwacz
    @param slider suwak
    @param description opis suwaka
     */

    public void addSlider(JSlider slider, String decription){
        slider.addChangeListener(listener);
        var panel = new JPanel();
        panel.add(slider);
        panel.add(new JLabel(decription));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        var gbc = new GridBagConstraints();
        gbc.gridy = sliderPanel.getComponentCount();
        gbc.anchor = GridBagConstraints.WEST;
        sliderPanel.add(panel,gbc);
    }
}
