package rozdzial10.slider;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Hashtable;

public class SliderFrame extends JFrame {

    private JPanel sliderPanel;
    private JTextField textField;
    private ChangeListener listener;

    public SliderFrame(){

        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridBagLayout());

        //Wspolny nasluciwacz wszystkich suwakow
        listener = event -> {
          //Aktualizacja pola tekstowego w odpowiedzi na zmiane wartosci suwaka
          JSlider source = (JSlider) event.getSource();
          textField.setText("" + source.getValue());
        };

        //Zwykly suwak
        var slider = new JSlider();
        addSlider(slider, "Zwykly");

        //Suwak z podzialka
        slider = new JSlider();
        slider.setPaintTicks(true); //podzialka
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Podzialka");

        //Suwak z dosuwaniem galki do najblizszej kreski
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true); //dosuwanie
        slider.setMinorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Dosuwany");

        //Suwak bez prowadnicy
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTrack(false); //prowadnica
        addSlider(slider, "Bez prowadnicy");

        //Suwak o odwroconym dzialaniu
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setInverted(true); //odwrocenie
        addSlider(slider, "Odwrocony");

        //Suwak z etykietami liczbowymi
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintLabels(true); //etykiety
        addSlider(slider, "Etykiety");

        //Suwak z etykietami literowymi
        slider = new JSlider();
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        var labelTable = new Hashtable<Integer,Component>();
        labelTable.put(0, new JLabel("A"));
        labelTable.put(20, new JLabel("B"));
        labelTable.put(40, new JLabel("C"));
        labelTable.put(60, new JLabel("D"));
        labelTable.put(80, new JLabel("E"));
        labelTable.put(100, new JLabel("F"));

        slider.setLabelTable(labelTable);
        addSlider(slider, "Niestandardowe etykiety");

        //Suwak z etykietami ikonowymi
        slider = new JSlider();
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        labelTable = new Hashtable<Integer, Component>();

        //Dodawanie obrazow kart

        labelTable.put(0, new JLabel(new ImageIcon("nine.gif")));
        labelTable.put(20, new JLabel(new ImageIcon("ten.gif")));
        labelTable.put(40, new JLabel(new ImageIcon("jack.gif")));
        labelTable.put(60, new JLabel(new ImageIcon("queen.gif")));
        labelTable.put(80, new JLabel(new ImageIcon("king.gif")));
        labelTable.put(1000, new JLabel(new ImageIcon("ace.gif")));

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
