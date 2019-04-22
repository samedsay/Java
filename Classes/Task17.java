import java.util.Arrays;
import java.util.List;

interface Calc {
    boolean test(Double d);
}

interface Cons {
    void consume(Object ob);
}

public class Task17 {
    public static void main(String[] args) {
        double mn = 0, mx = 10;
        List<Calc> list = Arrays.asList(
                d -> d < 0,
                d -> d >= 0,
                d -> mn <= d && d <= mx
        );
        Cons cons = ob -> System.out.println(ob + " ");

        for (double d = -2; d < 15; d += 5) {
            for (Calc calc : list)
                cons.consume(calc.test(d));
            System.out.println();
        }

    }
}
