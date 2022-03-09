package rozdzial9.treeSet;

import java.util.Objects;
import java.util.*;

public class Item {
    private String description;
    private int partNumber;

    public Item(String aDescription, int aPartNumber) {
        description = aDescription;
        partNumber = aPartNumber;
    }

//    public Item(String description, int partNumber) {
//        this.description = description;
//        this.partNumber = partNumber;
//    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", partNumber=" + partNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return partNumber == item.partNumber && description.equals(item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, partNumber);
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Item)) return false;
//        Item item = (Item) o;
//        return partNumber == item.partNumber && getDescription().equals(item.getDescription());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getDescription(), partNumber);
//    }

    public int compareTo(Item other){
        int diff = Integer.compare(partNumber,other.partNumber);
        return diff !=0 ? diff : description.compareTo(other.description);
    }
}
