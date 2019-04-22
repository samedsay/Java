import java.util.ArrayList;
import java.util.List;

interface MyBiOpInterface<T> {
    T apply(T a, T b);
}

class Mult implements MyBiOpInterface<Double> {
    public Double apply(Double a, Double b) {
        return a * b;
    }
}

public class Task19 {
    public static void main(String[] args) {
        List<MyBiOpInterface<Double>> opers = new ArrayList<>();
        opers.add(Double::sum);
        opers.add(new MyBiOpInterface<Double>() {
            @Override
            public Double apply(Double a, Double b) {
                return a - b;
            }
        });
        opers.add(new Mult());
        opers.add((a, b) -> a / b);
        int shift = 10;
        opers.add((a, b) -> a / b + shift);

        for (MyBiOpInterface<Double> op : opers)
            System.out.println(op.apply(10.5, 3.5));
    }
}
