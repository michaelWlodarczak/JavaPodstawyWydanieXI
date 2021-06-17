package rozdzial6.clone;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable{
    private String name;
    private double salary;
    private Date hireDate;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.hireDate = new Date();
    }

    public Employee clone() throws CloneNotSupportedException{
        //wywolanie metody Object.clone();
        Employee cloned = (Employee) super.clone();
        //klonowanie pol zmiennych
        cloned.hireDate = (Date) hireDate.clone();
        return cloned;
    }
    /*
    Ustawia date zatrudnienia na podany dzien
     */
    public void setHireDate(int year, int month, int day){
        Date newHireDate = new GregorianCalendar(year,month,day).getTime();
        //przyklad zmiany pola obiektowego
        hireDate.setTime(newHireDate.getTime());
    }
    public void raiseSalary(double byPercent){
        double raise = salary*byPercent/100;
        salary+=raise;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                '}';
    }
}
