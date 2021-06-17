package rozdzial6.clone;

public class CloneTest2 {
    public static void main(String[] args) throws CloneNotSupportedException{
        var orginal = new Employee("Jan Kowalski", 4000);
        orginal.setHireDate(2019,0,14);
        // ustawia miesiac jak indeksy w tablicy lub liscie 0 - january, 11 - december,
        //jak w miesiacu wpisze 12, data przeskakuje na styczen 2020

        Employee copy = orginal.clone();
        Employee copy2 = orginal;

        System.out.println("orginal: " + orginal);
        System.out.println("copy: " + copy);
        System.out.println("copy2: " + copy2 + "\n");

//        copy.raiseSalary(5);
//        copy2.raiseSalary(10);
//        System.out.println("orginal: " + orginal);
//        System.out.println("copy: " + copy);
//        System.out.println("copy2: " + copy2 + "\n");

        copy.setHireDate(2021,6,25);
        copy2.setHireDate(2018,0,15); // nie zmienia daty w kopi plytkiej
        orginal.setHireDate(2018,11,14);
        System.out.println("orginal: " + orginal);
        System.out.println("copy: " + copy);
        System.out.println("copy2: " + copy2 + "\n");

    }
}
