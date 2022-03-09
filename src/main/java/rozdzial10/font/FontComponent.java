package rozdzial10.font;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class FontComponent extends JComponent {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    public void paintComponent(Graphics g){

        var g2 = (Graphics2D) g;

        var message = "Witaj Swiecie!";

        var f = new Font("Serif",Font.BOLD,36);
        g2.setFont(f);

        //Sprawdzenie rozmiaru tekstu.

        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = f.getStringBounds(message,context);

        // set (x, y) = lewy gorny rog tekstu

        double x = (getWidth() - bounds.getWidth())/2;
        double y = (getHeight() - bounds.getHeight())/2;

        //Dodanie wydluzenia gornego do y w celu siegniecia do linii bazowej.

        double ascent = -bounds.getY();
        double baseY = y + ascent;

        //Rysowanie komunikatu

        g2.drawString(message,(int)x,(int)baseY);
        g2.setPaint(Color.MAGENTA);

        //Rysowanie linii bazowej.

        g2.draw(new Line2D.Double(x,baseY,x+bounds.getWidth(),baseY));

        //Rysowanie prostokata otaczajacego tekst

        var rect = new Rectangle2D.Double(x,y,bounds.getWidth(),bounds.getHeight());
        g2.draw(rect);

    }

    public Dimension getPreferredSize(){
        return new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT);
    }
}
