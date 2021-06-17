package rozdzial5.abstractClasses;

public abstract class Person {
    /*
    Klase mozna zdefiniowac jako abstrakcyjna, nawet jesli nie ma zadnych metod abstrakcyjnych

    Nie mozna twozyc obiektow klas abstrakcyjnych. To znaczy, ze jesli w klasie jest slowo 'abstract',
    nie moze miec obiektow. Np. wyrazenie:

    new Person("Juliusz Slowacki")

    jest BLEDNE. Mozna natomiast tworzyc obiekty podklas konkretnych
     */
    //pole
    private String name;

    public Person(String name) {
        this.name = name;
    }
    public abstract String getDescription();
    public String getName() {
        return name;
    }
}
