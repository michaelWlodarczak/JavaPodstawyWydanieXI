package rozdzial9.map;

import rozdzial5.inheritance.Employee;

import java.util.HashMap;

public class MapTest {
    public static void main(String[] args) {
        var staff = new HashMap<String, Employee>();
        staff.put("144-25-5464",new Employee("Anna", "Kowalska",2500,2019,10,14));
        staff.put("567-24-2546",new Employee("Henryk","Kwaiatek",5500,2018,12,15));
        staff.put("157-62-7935",new Employee("Marcin", "Nowak",3900,2017,12,9));
        staff.put("456-62-5527",new Employee("Franciszek", "Frankowski",4300,2021,1,25));

        //wydruk wszystkich pozycji NIE W KOLEJNOSCI DODAWANIA
        System.out.println(staff + "\n");

        //usuniecie wartosci za pomoca klucza
        staff.remove("144-25-5464");
        System.out.println(staff + "\n");

        //podmiana wartosci
        staff.put("567-24-2546",new Employee("Weronika", "Lewandowska", 5400,2021,5,25));
        System.out.println(staff + "\n");

        //wyszukanie wartosci po kluczu
        System.out.println(staff.get("157-62-7935"));

        //iteracja przez wszystkie pozycje
        staff.forEach((k,v) -> System.out.println("Key: " + k + ", Value: " + v));


    }
}
