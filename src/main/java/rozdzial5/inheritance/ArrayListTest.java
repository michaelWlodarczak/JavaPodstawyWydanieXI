package rozdzial5.inheritance;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        var staff = new ArrayList<Employee>();

        staff.add(new Employee("Ola", "Dusza", 3000, 2015, 7, 15));
        staff.add(new Employee("Ala", "Stalowa", 4500, 2016, 3, 25));
        staff.add(new Employee("Ula", "Zaba", 5000, 2014, 2, 1));

        System.out.println(staff); // wypisanie w linii wszystkich pracownikow

        //zwiekszenie wszystkim pracownikom pensji o 5%
        for (Employee e : staff)
            e.raiseSalary(5);
        //wypisanie na nowo wszystkich pracownikow ze zwiekszona pensja
        System.out.println(staff);
        //wypisanie po kolei wszystkich informacji dotyczacych pracownikow
        for (Employee e : staff)
            System.out.println("Name: " + e.getName() + "\n" +
                    "Surname: " + e.getSurname() + "\n" +
                    "Salary: " + e.getSalary() + "\n" +
                    "Hire date: " + e.getHireDay());

        System.out.println();
        System.out.println(staff.size() + "\n");
        //Aby dodac element w srodku listy, nalezy uzyc metody 'add' z parametrem okreslajacym index
        staff.add(1,new Employee("Krzysztof","Dzik",5000,2019,10,14));
        for (Employee e : staff)
            System.out.println(e);
    }
}
