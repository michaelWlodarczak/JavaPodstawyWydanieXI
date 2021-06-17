package rozdzial5.abstractClasses;

public class Student extends Person{
    /*
    Jako przyklad zdefiniujemy klase 'Student', ktora rozszerza klase abstrakcyjana 'Person'
    i implementuje metode 'getDescription'. Poniewaz zadna z metod klasy 'Student' nie jest abstrakcyjna,
    ta klasa rowniez nie musi byc abstrakcyjna.
     */
    private String major;

    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return "Student specjalizacji: " + major;
    }
}
