import java.util.Arrays;

class Person {
    private String name;
    private int year;

    public Person(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        return name + "(" + year + ")";
    }

    static void show(Person[] persons, String message) {
        System.out.println(message);
        for (Person person : persons)
            System.out.println(person + " ");
        System.out.println();
    }
}

public class Task16 {
    public static void main(String[] args) {
        Person[] persons = {
                new Person("Mary", 1990),
                new Person("Joan", 1992),
                new Person("Suzy", 1992),
                new Person("Beth", 1992),
                new Person("Suzy", 1980),
                new Person("Katy", 1982),
        };
        Person.show(persons, "At the beginning:");
        Arrays.sort(persons, (p1, p2) -> p1.getYear() - p2.getYear());
        Person.show(persons, "Ordered by age");
        Arrays.sort(persons, (p1, p2) ->
        {
            int d = p1.getName().compareTo(p2.getName());
            if (d != 0) {
                return d;
            }
            return p1.getYear() - p2.getYear();
        });
        Person.show(persons, "Ordered by name then age");
    }
}
