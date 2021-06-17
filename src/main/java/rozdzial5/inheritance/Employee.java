package rozdzial5.inheritance;

import java.time.LocalDate;

public class Employee {
private String name;
private String surname;
private double salary;
private LocalDate hireDay;

    public Employee(String name, String surname, double salary, int year, int month, int day) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.hireDay = LocalDate.of(year,month,day);
    }
//gettery (akcesor)
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    @Override
    public String toString() {
        return "inheritance.Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", hireDay=" + hireDay +
                '}';
    }

    //method which is rising salary by percent
    public double raiseSalary(double byPercent){
        double raise = salary * byPercent/100;
        salary += raise; // salary = salary + raise;
        return raise;
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Krzysztof","Dzik",21000,1985,11,25);
        Employee employee2 = new Employee("Hanna","Gwiazda",2500,1989,07,17);
        Employee employee3 = new Employee("Michal","Zagiel",21000,1987,12,15);
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);
        employee1.raiseSalary(10);
        System.out.println(employee1);

    }
}
