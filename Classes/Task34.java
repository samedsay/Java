import java.util.*;

public class Task34 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Sue");
        list.add("Lea");
        list.add("Ann");
        list.add("Kim");
        list.add("Lea");
        list.add(1, "Amy"); // inefficient!

        System.out.println("First 'Lea' under index " +
                list.indexOf("Lea"));
        System.out.println("Last  'Lea' under index " +
                list.lastIndexOf("Lea"));
        System.out.println("Does the list contain 'Sue': " +
                list.contains("Sue"));
        System.out.println("Does the list contain 'Bea': " +
                list.contains("Bea"));
        System.out.println("Size of list: " + list.size());
        //Traditional Loop
        System.out.print("With get():  ");
        for (int i = 0; i < list.size(); i++)
            System.out.print(" " + list.get(i));
        //Foreach Loop
        System.out.print("\nAnother way: ");
        for (String s : list)
            System.out.print(" " + s);
        //Iterators
        System.out.print("\nnow iterator:");
        Iterator<String> iter = list.iterator();
        while (iter.hasNext())
            System.out.print(" " + iter.next());

        //Sorting and Sublists
        Collections.sort(list);
        System.out.println("\nSorted:      " + list);
        List<String> sub1 = list.subList(1, 4);
        System.out.println("Sublist:     " + sub1);

        //HashSet
        Set<String> hSet = new HashSet<>(list);
        System.out.println("Hash set:    " + hSet);
        Set<String> tSet = new TreeSet<>(list);
        System.out.println("Tree set:    " + tSet);
        System.out.println("Does the tSet contain 'Sue': " +
                tSet.contains("Sue"));
        tSet.add("Zoe");
        tSet.remove("Lea");
        System.out.println("tSet now:    " + tSet);

    }
}
