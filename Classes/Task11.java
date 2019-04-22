import java.util.Arrays;
import java.util.Comparator;

class Person implements Comparable<Person> {
    private String name;
    private int year;

    public Person(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public int compareTo(Person other) {
        int diff = year - other.year;
        if (diff != 0)
            return diff;
        else
            return name.compareTo(other.name);
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

class CompPerson implements Comparator<Person> {
    public static enum Comp {BY_NAME, BY_YEAR, BY_NAMERev, BY_YEARRev}

    ;
    private Comp comp;

    public CompPerson(Comp comp) {
        this.comp = comp;
    }

    public int compare(Person p1, Person p2) {
        int rYear = p1.getYear() - p2.getYear();
        int rName = p1.getName().compareTo(p2.getName());

        int result = 0;

        switch (comp) {
            case BY_NAME:
                result = rName != 0 ? rName : rYear;
                break;
            case BY_NAMERev:
                result = rName != 0 ? -rName : rYear;
                break;
            case BY_YEAR:
                result = rYear != 0 ? rYear : rName;
                break;
            case BY_YEARRev:
                result = rYear != 0 ? -rYear : rName;
                break;
        }
        return result;
    }
}

public class Task11 {
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

        Arrays.sort(persons);
        Person.show(persons, "Natural order: " +
                "by year, then by name");
        Arrays.sort(persons, new CompPerson(CompPerson.Comp.BY_NAME));
        Person.show(persons, "Order BY_NAME: " +
                "by name, then by year");
        Arrays.sort(persons, new CompPerson(CompPerson.Comp.BY_NAMERev));
        Person.show(persons, "Order BY_NAMERev: " +
                "by name reversed, then by year");
        Arrays.sort(persons, new CompPerson(CompPerson.Comp.BY_YEAR));
        Person.show(persons, "Order BY_YEAR: " +
                "by year, then by name");
        Arrays.sort(persons, new CompPerson(CompPerson.Comp.BY_YEARRev));
        Person.show(persons, "Order BY_YEARREV: " +
                "by year reversed, the by name");
        Arrays.sort(persons, (f, s) -> s.getYear() - f.getYear());
        Person.show(persons, "Order by lambda : " +
                "by year ");

    }
}
