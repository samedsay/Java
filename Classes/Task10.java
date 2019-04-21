import java.util.*;

class Person implements Comparable<Person> {
    final static int currentYear =
            java.util.Calendar.getInstance().get(Calendar.YEAR);
    String name;
    int birthYear;
    int height;

    Person(String n, int y, int h) {
        name = n;
        birthYear = y;
        height = h;
    }

    public int compareTo(Person o) {
        int k = name.compareToIgnoreCase(o.name);
        if (k != 0)
            return k;
        k = o.birthYear - birthYear;
        if (k != 0)
            return k;
        return height - o.birthYear;
    }

    public String toString() {
        return name + "(" + (currentYear - birthYear) +
                "/" + height + ")";
    }
}

class Comp1 implements Comparator<Person> {
    public int compare(Person o1, Person o2) {
        int k = o1.height - o2.height;
        if (k != 0)
            return k;
        k = o2.birthYear - o1.birthYear;
        if (k != 0)
            return k;
        return o1.name.compareToIgnoreCase(o2.name);
    }
}

class Comp2 implements Comparator<Person> {
    public int compare(Person o1, Person o2) {
        int k = o2.birthYear - o1.birthYear;
        if (k != 0)
            return k;
        k = o1.name.compareToIgnoreCase(o2.name);
        if (k != 0)
            return k;
        return o1.height - o2.height;
    }
}

public class Task10 {
    public static void main(String[] args) {
        new Task10();
    }

    Task10() {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("K", 1980, 165));
        list.add(new Person("B", 1986, 171));
        list.add(new Person("K", 1980, 168));
        list.add(new Person("H", 1980, 171));
        list.add(new Person("M", 1980, 171));
        list.add(new Person("K", 1980, 169));
        list.add(new Person("B", 1979, 171));
        list.add(new Person("G", 1975, 171));

        Collections.sort(list);
        writeL(list, "Natural: name, age, height");

        Collections.sort(list, new Comp1());
        writeL(list, "Comp1:   height, age, name");

        Comparator<Person> comp2 = new Comp2();
        Collections.sort(list, comp2);
        writeL(list, "Comp2:   age, name, height");

        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person p, Person q) {
                int k = p.name.compareToIgnoreCase(q.name);
                if (k != 0)
                    return k;
                k = p.height - q.height;
                if (k != 0)
                    return k;
                return q.birthYear - p.birthYear;
            }
        });

        writeL(list, "Anonym:  name, height, age");

        Collections.sort(list, (f, s) -> f.height - s.height);
        writeL(list, "Lambda:  name, height, age");

    }

    static void writeL(List<Person> list, String header) {
        System.out.println('\n' + header);
        for (Person p : list)
            System.out.print(p + " ");
        System.out.println();
    }
}
