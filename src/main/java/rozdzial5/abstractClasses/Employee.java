package rozdzial5.abstractClasses;

import java.time.LocalDate;

public class Employee extends Person{
    private double salary;
    private LocalDate hireDay;

    //konstruktor z polem z klasy super
    public Employee(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        hireDay = LocalDate.of(year,month,day);
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public String getDescription() {
        //return String.format("Pracownik zarabiajacy %.2f PLN" + salary);
        return String.format("Pracownik zarabiajacy: " + salary + " PLN");
    }

    public void raiseSalary(double byPercent){
        double raise = salary*byPercent/100;
        salary += raise;
    }

//    @Override
//    public String toString() {
//        return "Employee{" +
//                "salary=" + salary +
//                ", hireDay=" + hireDay +
//                "} " + super.toString();
//    }
}
