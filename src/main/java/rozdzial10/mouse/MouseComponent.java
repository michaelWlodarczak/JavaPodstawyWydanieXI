package rozdzial10.mouse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/*
Komponent z dzialaniami myszy, do ktorego mozna dodawac (lub z ktorego mozna usuwac) kwadraty
 */
public class MouseComponent extends JComponent {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private static final int SIDELENGHT = 10;
    private ArrayList<Rectangle2D> squares;
    private Rectangle2D current; //kwadrat zawierajacy kursor

    public MouseComponent(){
        squares = new ArrayList<>();
        current = null;
    }

    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }

    public void paintComponent(Graphics g){
        var g2 = (Graphics2D) g;

        //Rysowanie wszystkich kwadratiow
        for(Rectangle2D r : squares)
            g2.draw(r);
    }

    /**
    *Znajduje pierwszy kwadrat zawierajacy punkt.
     * @param p punkt
     * @return pierwszy kwadrat zawierajacy punkt p
     */
    public Rectangle2D find(Point2D p){
        for(Rectangle2D r : squares){
            if(r.contains(p)) return r;
        }
        return null;
    }

    /**
     * Dodaje kwadrat do zbioru
     * @param p srodek kwadratu
     */
    public void add(Point2D p){
        double x = p.getX();
        double y = p.getY();

        current = new Rectangle2D.Double(x - SIDELENGHT/2,y - SIDELENGHT/2,SIDELENGHT,SIDELENGHT);
        squares.add(current);
        repaint();
    }

    /**
     * Uwuwa kwadrat ze zbioru
     * @param s kwadratu, ktory ma byc usuniety
     */
    public void remove(Rectangle2D s){
        if (s == null) return;
        if (s == current) current = null;
        squares.remove(s);
        repaint();
    }

    private class MouseHandler extends MouseAdapter{

        public void mousePressed(MouseEvent event){
            //Dodawanie nowego kwadratu, jesli kursor nie jest wewnatrz innego kwadratu
            current = find(event.getPoint());
            if (current == null) add(event.getPoint());
        }

        public void mouseClicked(MouseEvent event){
            //Usuniecie kwadratu w wyniku jego dwukrotnego klikniecia
            current = find(event.getPoint());
            if (current != null && event.getClickCount() >= 2) remove(current);
        }
    }

    private class MouseMotionHandler implements MouseMotionListener{

        public void mouseMoved(MouseEvent event){
            //Ustawianie kursora na krzyzyk, jesli znajduje sie wewnatrz kwadratu
            if(find(event.getPoint()) == null) setCursor(Cursor.getDefaultCursor());
            else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }

        public void mouseDragged(MouseEvent event){
            if(current != null){
                int x = event.getX();
                int y = event.getY();
                //Przeciaganie aktualnego kwadratu w celu wysrodkowania go w punkcie (x, y)
                current.setFrame(x - SIDELENGHT/2, y - SIDELENGHT/2, SIDELENGHT,SIDELENGHT);
                repaint();
            }
        }
    }
}
