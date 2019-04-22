import java.lang.reflect.Method;

public class Task23<F, S> {
    private static int count = 0;
    private F first;
    private S second;

    public Task23(F f, S s) {
        count++;
        first = f;
        second = s;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    public void setFirst(F f) {
        first = f;
    }

    public void setSecond(S s) {
        second = s;
    }

    public String toString() {
        return first + " " + second;
    }

    public static void main(String[] args) {

        Task23<String, Integer> p1 = new Task23<>("A", 1);
        Task23<String, String> p2 = new Task23<>("C", "D");
        System.out.println("Class of p1: " + p1.getClass() + "" +
                "; Class of p2: " + p2.getClass());

        for (Method m : p1.getClass().getDeclaredMethods())
            if (!m.getName().equals("main"))
                System.out.println(m);
        System.out.println(p1.count + " " + p2.count);
        p1.setSecond(2);

        int i = p1.getSecond();

        String s = p2.getFirst();
        System.out.println("p1.second = " + i);
        System.out.println("p2.first = " + s);

    }
}
