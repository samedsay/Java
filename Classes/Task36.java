import java.util.HashMap;
import java.util.Map;

class Person {
    private String name;
    private String idNumber;

    public Person(String name, String idNumber) {
        this.name = name;
        this.idNumber = idNumber;
    }

    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass())
            return false;
        Person p = (Person) other;
        return idNumber.equals(p.idNumber) && name.equals(p.name);
    }

    public int hashCode() {
        return 17 * name.hashCode() + idNumber.hashCode();
    }

    public String toString() {
        return name + "(" + idNumber + ")";
    }
}

public class Task36 {
    public static void main(String[] args) {
        Map<Person, String> map = new HashMap<>();
        map.put(new Person("Sue", "123456"), "Sue");
        Person sue = new Person("Sue", "123456");
        if (map.containsKey(sue))
            System.out.println(sue + " has been found");
        else
            System.out.println(sue + " has NOT been found");
    }
}
