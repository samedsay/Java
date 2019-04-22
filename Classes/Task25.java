import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Operat<T> {
    T oper(T lhs, T rhs);
}

class Tools {
    public static <T> T foldl(
            Operat<T> op, List<T> list, T id) {
        T acc = id;
        for (T e : list)
            acc = op.oper(acc, e);
        return acc;
    }

    public static <T> List<T> combine(
            Operat<T> op, List<T> l1, List<T> l2) {
        List<T> res = new ArrayList<T>();
        int size = Math.min(l1.size(), l2.size());
        for (int i = 0; i < size; i++) {
            res.add(op.oper(l1.get(i), l2.get(i)));
        }
        return res;
    }
}

public class Task25 {
    public static void main(String[] args) {

        Operat<Integer> operInt = new Operat<Integer>() {
            public Integer oper(Integer lhs, Integer rhs) {
                return lhs + rhs;
            }
        };

        Operat<String> operStr = new Operat<String>() {
            @Override
            public String oper(String lhs, String rhs) {
                return lhs + rhs;
            }
        };
        List<Integer> listInt1 = Arrays.asList(1, 2, 3, 4),
                listInt2 = Arrays.asList(5, 6, 7, 8);

        List<Integer> intRes =
                Tools.combine(operInt, listInt1, listInt2);
        System.out.println("intRes = " + intRes);
        List<String> listStr1 = Arrays.asList("a", "b", "c"),
                listStr2 = Arrays.asList("1", "2", "3");
        List<String> strRes =
                Tools.combine(operStr, listStr1, listStr2);
        System.out.println("strRes = " + strRes);

        int intFold = Tools.foldl(operInt, intRes, 0);

        System.out.println("intFold = " + intFold);

        String strFold = Tools.foldl(operStr, strRes, "");
        System.out.println("strFold = " + strFold);
    }
}
