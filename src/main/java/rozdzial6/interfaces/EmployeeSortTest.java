package rozdzial6.interfaces;

import rozdzial6.interfaces.Employee;

import java.util.Arrays;

public class EmployeeSortTest {
    public static void main(String[] args) {
        try {
            //Employee[] staff = new Employee[4];
            var staff = new Employee[4];
            staff[0] = new Employee("Jan Mucha", 3500);
            staff[1] = new Employee("Ola Dusza", 2900);
            staff[2] = new Employee("Krzysztof Dzik", 5000);
            staff[3] = new Employee("Michal Red", 1500);
           // staff[4] = new Employee("Hania Red", 1600);

            Arrays.sort(staff);

            for (Employee e : staff)
                System.out.println("Name: " + e.getName() + " Salary: " + e.getSalary());
        } catch (Exception e) {
            System.out.println(e.getMessage() + " Za mala tablica na podana ilosc pracownikow, zmień dlugosc tablicy");

        }
    }
}
