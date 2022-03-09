package rozdzial9.map;

import rozdzial5.inheritance.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class Przedzialy {
    public static void main(String[] args) {
        //Wyodrebniamy elementy z listy za pomoca subListy
        List<String>names=List.of("Krzys","Hania","Michal","Krystian","Ania","Martyna","Adam");
        List<String>group2=names.subList(0,3); //indeks '3' jest wykluczony z subListy
        System.out.println(group2);
        System.out.println(names);

        //group2.clear();  - UnsupportedOperationException
        System.out.println(group2);


    }
}
