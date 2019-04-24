import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Task35 {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("Sue", 167);
        map.put("Ann", 173);
        map.put("Lea", 170);
        map.put("Kim", 173);

        Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            int val = map.get(key);    //auto (un)boxing
            System.out.print(key + ": " + val + " ");
            if (val == 170)
                iter.remove();

        }
        System.out.print("\nWe can print a map: " + map);
        map.putIfAbsent("Lea", 169);
        map.replace("Lea", 170);

        System.out.print("\nIs there a key 'Lea'? " +
                map.containsKey("Lea"));
        System.out.print("\nIs there a key 'Zoe'? " +
                map.containsKey("Zoe"));

        //Inefficient
        System.out.println("\nIs any girl 170 cm tall? " +
                map.containsValue(170));

        Integer was = map.remove("Ann");
        if (was != null)
            System.out.println("Ann removed, she was " +
                    was + " cm tall");
        was = map.remove("Zoe");
        if (was == null)
            System.out.println("There was no 'Zoe'!");
        System.out.println("getOrDefault: 'Zoe'->" +
                map.getOrDefault("Zoe", -1));
        System.out.println("getOrDefault: 'Lea'->" +
                map.getOrDefault("Lea", -1));
        System.out.print("Iterating over 'keySet': ");
        for (String s : map.keySet())
            System.out.print(s + "->" + map.get(s) + "  ");
        System.out.print("\nMore efficient way: ");
        for (Map.Entry<String, Integer> e : map.entrySet())
            System.out.print(e.getKey() + "->" +
                    e.getValue() + "  ");
        System.out.println();

    }
}
