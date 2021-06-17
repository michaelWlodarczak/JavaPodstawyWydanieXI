package rozdzial5.inheritance;

public class Manager extends Employee {
    private double bonus;

    // konstruktor
    public Manager(String name, String surname, double salary, int year, int month, int day, double bonus) {
        super(name, surname, salary, year, month, day);
        this.bonus = bonus;
    }
    /*
    W tym miejscu slowo kluczowe 'super' oznacza:
    Instrukcja: super(name, surname, salary, year, month, day);
    mowi: 'wykonaj konstruktor nadklasy 'Employee' z parametrami
     */

    //setter (mutator)
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    //nadpisanie metody
    @Override
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary += bonus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "bonus=" + bonus +
                "} " + super.toString();
    }

    public static void main(String[] args) {
        Manager boss = new Manager("Klaudia", "Rydza", 25000, 1995, 4, 26, 800);
        //  boss.setBonus(800);
        System.out.println(boss);

        //tablica trzech pracownikow:
        Employee[] staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("Henryk", "Kwiatek", 5000, 1985, 3, 3);
        staff[2] = new Employee("Artur", "Kwiatkowski", 4000, 1990, 6, 30);

        for (Employee e : staff)
            System.out.println("Name " + e.getName() + " " +"salary: " + e.getSalary());

        /*
        Mozliwosc odwolania sie przez obiekty (jak zmienna e) do wielu roznych typow nosi nazwe POLIMORFIZMU - Polymorphism
        Automatyczny wybor odpowiednich metod w trakcie dzialania programu nazywa sie WIAZANIEM DYNAMICZNYM - Dynamic binding
         */



    }


}
