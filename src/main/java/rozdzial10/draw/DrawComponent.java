package rozdzial10.draw;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/*
KOMPONENT WYSWIETLAJACY PROSTOKATY I ELIPSY
 */

public class DrawComponent extends JComponent {

    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    public void paintComponent(Graphics g){

        var g2 = (Graphics2D) g;

        //Rysowanie prostokąta

        double leftX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;

        var rect = new Rectangle2D.Double(leftX,topY,width,height);
        //wypelnianie prostokata kolorem
        //g2.setPaint(Color.RED); //dostepnych jest 13 domyslnych kolorow
        //g2.setPaint(new Color (0,150,255)); //ustawianie koloru niestandardowego RGB zakres 0-255
        //g2.fill(rect);
        g2.draw(rect);

        //Rysowanie elipsy

        var ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.draw(ellipse);

        //Rysowanie przekatnej

        g2.draw(new Line2D.Double(leftX,topY,leftX + width,topY + height));

        //Rysowanie kola z takim samym srodkiem

        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        double radius = 150;

        var circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX,centerY,centerX + radius,centerY + radius);
        g2.draw(circle);


    }

    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}
