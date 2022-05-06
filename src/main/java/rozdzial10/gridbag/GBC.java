package rozdzial10.gridbag;

import java.awt.*;

/*
Ta klasa upraszcza korzystanie z klasy GridBagConstrains
 */
public class GBC extends GridBagConstraints {

    /*
    Tworzy obiekt typu GBC z podanymi wartosciami gridx i gridy oraz wszystkimi pozostalymi
    parametrami ustawionymi na wartosci domyslne
    @param gridx wspolrzedna gridx
    @param gridy wspolrzedna gridy
     */
    public GBC(int gridx, int gridy){
        this.gridx = gridx;
        this.gridy = gridy;
    }

    /*
    Tworzy obiekt typu GBC z podanymi wartosciami gridx, gridy, gridwidth, gridheight oraz wszystkimi pozostalymi
    parametrami ustawionymi na wartosci domyslne
    @param gridx wspolrzedna gridx
    @param gridy wspolrzedna gridy
    @param gridwidth liczba zajmowanych komorek w poziomie
    @param gridheight liczba zajmowanych komorek w pionie.
     */
    public GBC(int gridx, int gridy, int gridWidth, int gridHeight){
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridwidth = gridWidth;
        this.gridheight = gridHeight;
    }

    /*
    Ustwia parametr anchor
    @param anchor wartosc parametru anchor
    @return this obiekt do dalszej modyfikacji
     */
    public GBC setAnchor(int anchor){
        this.anchor=anchor;
        return this;
    }

    /*
    Ustawia kierunek zapelnienia
    @param fill kierunek zapelnienia
    @return this obiekt do dalszej modyfikacji
     */
    public GBC setFill(int fill){
        this.fill=fill;
        return this;
    }

    /*
    Ustawia parametry weight komorek
    @param weightx parametr weight w poziomie
    @param weighty parametr weight w pionie
    @return this obiekt do dalszej modyfikacji
     */
    public GBC setWeight(double weightx, double weighty){
        this.weightx=weightx;
        this.weighty=weighty;
        return this;
    }

    /*
    Ustawia dodatkowa pusta przestrzen w komorce
    @param distance dopelnienie w ewszystkich kierunkach
    @return this obiekt do dalszej modyfikacji
     */
    public GBC setInsets(int distance){
        this.insets = new Insets(distance,distance,distance,distance);
        return this;
    }

    /*
    Ustawia dopelnienia w komorce
    @param top odstep od gornej krawedzi
    @param left odstep od lewej krawedzi
    @param bottom odstep od dolnej krawedzi
    @param right odstep od prawej krawedzi
    @return this obiekt do dalszej modyfikacji
     */
    public GBC setInsets(int top, int left, int bottom, int right){
        this.insets = new Insets(top,left,bottom,right);
        return this;
    }

    /*
    Ustawia dopelnienie wewnetrzne
    @param ipadx dopelnienie wewnetrzne poziome
    @param ipady dopelnienie wewnetrzne pionowe
    @return this obiekt do dalszej modyfikacji
     */
    public GBC setIpad(int ipadx, int ipady){
        this.ipadx=ipadx;
        this.ipady=ipady;
        return this;
    }
}
