package rozdzial6.interfaces;

//Klasa Employee implementuje interfejs 'Comparable'

public class Employee implements Comparable<Employee>{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPersent) {
        double raise = salary * byPersent / 100;
        salary += raise;
    }
/*
porownuje pacownikow wedlug wysokosci pensji
parametr 'other' inny obiekt klasy 'Employee'
'return' wartosc ujemna, jesli pacownik ma nizsza pensje niz inny (other) pracownik
0, jesli pensje sa rowne, w przeciwnym razie liczba dodatnia
  */
    public int compareTo(Employee other){
        return Double.compare(salary,other.salary);
    }
}
