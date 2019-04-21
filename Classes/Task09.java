interface MyCompar {
    boolean lt(int lhs, int rhs);

    default boolean gt(int lhs, int rhs) {
        return lt(rhs, lhs);
    }

    default boolean ge(int lhs, int rhs) {
        return !lt(lhs, rhs);
    }

    default boolean le(int lhs, int rhs) {
        return !lt(rhs, lhs);
    }

    default boolean eq(int lhs, int rhs) {
        return !lt(lhs, rhs) && !lt(rhs, lhs);
    }

    default boolean ne(int lhs, int rhs) {
        return !eq(lhs, rhs);
    }

}

class CompVal implements MyCompar {
    public boolean lt(int lhs, int rhs) {
        return lhs < rhs;
    }
}

class CompDigits implements MyCompar {
    public boolean lt(int lhs, int rhs) {
        return sumOfDigs(lhs) < sumOfDigs(rhs);
    }

    private static int sumOfDigs(int n) {
        int sum = 0;
        n = n < 0 ? -n : n;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}

class CompValRev implements MyCompar {
    public boolean lt(int lhs, int rhs) {
        return lhs > rhs;
    }
}

public class Task09 {
    public static void main(String[] args) {

        MyCompar cmpVal = new CompVal();
        MyCompar cmpSum = new CompDigits();
        MyCompar cmpVaR = new CompValRev();

        compare("cmpVal - BY VALUE", cmpVal,
                10, 2, 3, 12, 5, 22);
        compare("cmpSum - BY SUM OF DIGITS", cmpSum,
                10, 2, 3, 12, 5, 22);
        compare("cmpVaR - BY VALUE REVERSED", cmpVaR,
                10, 2, 3, 12, 5, 22);
    }

    private static void compare(String message, MyCompar cmp, int... pairs) {
        System.out.println("\n========= " + message);
        for (int k = 0; k < pairs.length; k += 2) {
            int a = pairs[k], b = pairs[k + 1];
            System.out.println("** (" + a + "," + b + "): " +
                    "lt->" + cmp.lt(a, b) + ", " +
                    "le->" + cmp.le(a, b) + ", " +
                    "gt->" + cmp.gt(a, b) + ", " +
                    "ge->" + cmp.ge(a, b) + ", " +
                    "eq->" + cmp.eq(a, b) + ", " +
                    "ne->" + cmp.ne(a, b));
        }
    }
}
