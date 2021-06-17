package rozdzial5.abstractClasses;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Jan Kowalski", 2500, 2015,5,23);
        Employee employee2 = new Employee("Janusz Nowak", 4500, 2005,2,17);
        Student student1 = new Student("Alicja Maj", "Historia");

        System.out.println(employee1.getDescription());
        System.out.println(student1.getDescription() + "\n");

        Person[] people = new Person[3];
        people[0] = new Employee("Jan Kowalski", 2500, 2015,5,23);
        people[1] = new Employee("Janusz Nowak", 4500, 2005,2,17);
        people[2] = new Student("Alicja Maj", "Historia");
        for (Person p : people)
            System.out.println(p.getName() + " " + p.getDescription());

        /*
        Zmienna 'p' nie odwoluje sie NIGDY do obiektu klasy 'Person', poniewaz nie mozna utworzyc obiektu klasy abstrakcyjnej
        Zmienna 'p' zawsze odwoluje sie do obiektu konkretnej podklasy, jak 'Employee' czy 'Student'
        Dla tych obiektow metoda 'getDescription' jest zdefiniowana.
         */
    }
}
