package rozdzial6.clone;

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException{
        var orginal = new Employee("Jan Kowalski", 4000);
        orginal.setHireDate(2019,10,14);

        /*Zadana z metod zmieniajacych 'raiseSalary' i 'setHireDate'
        nie ma wplywu na obiekt oryginalny, poniewaz metoda 'clone()'
        wykonuje kopiowanie glebokie
        */

        Employee copy = orginal.clone();

        System.out.println("orginal: " + orginal);
        System.out.println("copy: " + copy + "\n");

        copy.raiseSalary(5);
        copy.setHireDate(2021,5,25);

        System.out.println("orginal: " + orginal);
        System.out.println("copy: " + copy);

    }
}
