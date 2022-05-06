package rozdzial10.menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 300;
    private Action saveAction;
    private Action saveAsAction;
    private JCheckBoxMenuItem readOnlyItem;
    private JPopupMenu popup;

    //Przykladowa akcja, ktora drukuje nazde akcji
    class TestAction extends AbstractAction{

        public TestAction(String name){
            super(name);
        }

        public void actionPerformed(ActionEvent event){
            System.out.println("Wybrano: " + getValue(Action.NAME));
        }
    }

    public MenuFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        var fileMenu = new JMenu("File");
        fileMenu.add(new TestAction("New"));

        //Akceleratory
        var openItem = fileMenu.add(new TestAction("Open"));
        openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));

        fileMenu.addSeparator();

        saveAction = new TestAction("Save");
        JMenuItem saveItem = fileMenu.add(saveAction);
        saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

        saveAction = new TestAction("Save As");
        fileMenu.add(saveAsAction);
        fileMenu.addSeparator();

        fileMenu.add(new AbstractAction("End") {
            public void actionPerformed(ActionEvent event){
                System.exit(0);
            }
        });

        //Menu z polem wyboru i przelacznikami
        readOnlyItem = new JCheckBoxMenuItem("Read only");
        readOnlyItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                boolean saveOK = !readOnlyItem.isSelected();
                saveAction.setEnabled(saveOK);
                saveAsAction.setEnabled(saveOK);
            }
        });

        var group = new ButtonGroup();
        var insertItem = new JRadioButtonMenuItem("Insert");
        insertItem.setSelected(true);
        var overTypeItem = new JRadioButtonMenuItem("Overwrite");

        group.add(insertItem);
        group.add(overTypeItem);

        //Ikony
        var cutAction = new TestAction("Cut");
        cutAction.putValue(Action.SMALL_ICON, new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaPodstawyWydanieXI\\src\\main\\java\\rozdzial10\\menu\\cut.jpg"));
        var copyAction = new TestAction("Copy");
        copyAction.putValue(Action.SMALL_ICON, new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaPodstawyWydanieXI\\src\\main\\java\\rozdzial10\\menu\\copy.jpg"));
        var pasteAction = new TestAction("Paste");
        pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("C:\\Users\\user\\IdeaProjects\\JavaPodstawyWydanieXI\\src\\main\\java\\rozdzial10\\menu\\paste.jpg"));

        var editMenu = new JMenu("Edit");
        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);

        //Zagniezdzone menu
        var optionMenu = new JMenu("Options");

        optionMenu.add(readOnlyItem);
        optionMenu.addSeparator();
        optionMenu.add(insertItem);
        optionMenu.add(overTypeItem);

        editMenu.addSeparator();
        editMenu.add(optionMenu);

        //Mnemoniki
        var helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('P');

        var indexItem = new JMenuItem("Index");
        indexItem.setMnemonic('I');
        helpMenu.add(indexItem);

        //Mnemoniki mozna takze dodawac do akcji
        var aboutAction = new TestAction("About program");
        aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('A'));
        helpMenu.add(indexItem);

        //Dodanie wszystkich menu najwyzszego rzedu do pasku menu
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        //Menu kontekstowe
        popup = new JPopupMenu();
        popup.add(cutAction);
        popup.add(copyAction);
        popup.add(pasteAction);

        var panel = new JPanel();
        panel.setComponentPopupMenu(popup);
        add(panel);
    }
}
