public class Task06 {
    public static void main(String[] args) {

        // Problem 1

        double a = 2, b = 3, c = 1;

        System.out.println("(a, b, c,)=(" + a + ", " + b + ", " + c + "): hasTwoRoots? " + hasTwoRoots(a, b, c));

        a = 0;
        b = 2;
        c = 1;
        System.out.println("(a, b, c,)=(" + a + ", " + b + ", " + c + "): hasTwoRoots? " + hasTwoRoots(a, b, c));

        a = 2;
        b = 1;
        c = -1;
        System.out.println("(a, b, c,)=(" + a + ", " + b + ", " + c + "): monot? " + monot(a, b, c));

        a = 2;
        b = 1;
        c = 2;
        System.out.println("(a, b, c,)=(" + a + ", " + b + ", " + c + "): monot? " + monot(a, b, c));

        a = 2;
        b = 1;
        c = 2;
        System.out.println("(a, b, c,)=(" + a + ", " + b + ", " + c + "):maxEl = " + maxEl(a, b, c));
        a = 2;
        b = 2;
        c = 4;
        System.out.println("(a, b, c,)=(" + a + ", " + b + ", " + c + "):maxEl = " + maxEl(a, b, c));

        a = -2;
        b = 1;
        c = -3;
        System.out.println("(a, b, c,)=(" + a + ", " + b + ", " + c + "):numPos = " + numPos(a, b, c));
        a = -2;
        b = 1;
        c = 3;
        System.out.println("(a, b, c,)=(" + a + ", " + b + ", " + c + "):numPos = " + numPos(a, b, c));

        System.out.println("\n");

        // Problem 2

        int x = 2, y = 3, z = 1;

        System.out.println("Max of " + x + ", " + y + ", " + z + " is " + maxOfThree(x, y, z));

        for (int i = 12; i < 16; ++i) {       // We defined variable 'a' before that is why I define new variable 'i'
            System.out.println("Greatest divisor of " + i + " is " + greatestDivisor(i));
        }

        for (int m = 11, n = 5; m >= 3; m -= 2, n += 2) {
            if (areRelativelyPrime(m, n)) {
                System.out.println(m + " and " + n + " are relatively prime");
            }
        }

        for (int m = 2; m <= 100; ++m) {
            if (isPerfect(m)) {
                System.out.println(m + " is perfect");
            }
        }

    }

    // Problem 1 Classes

    public static boolean hasTwoRoots(double a, double b, double c) {
        double discriminant = ((b * b) - (4 * a * c));

        if (discriminant <= 0)
            return false;
        else
            return true;
    }

    public static boolean monot(double a, double b, double c) {

        if ((a > b && b > c) || (a < b && b < c))
            return true;
        else
            return false;
    }

    public static double maxEl(double a, double b, double c) {

        if ((a > b) && (a > c))
            return a;
        else if ((b > a) && (b > c))
            return b;
        else
            return c;

    }

    public static int numPos(double a, double b, double c) {

        int counter = 0;
        if (a > 0)
            counter++;
        if (b > 0)
            counter++;
        if (c > 0)
            counter++;

        return counter;
    }

    // Problem 2 Classes

    static int maxOfThree(int a, int b, int c) {

        if ((a > b) && (a > c))
            return a;
        else if ((b > a) && (b > c))
            return b;
        else
            return c;
    }

    static int greatestDivisor(int n) {

        int gcd = 0;

        for (int i = 1; i < n; i++) {
            if (n % i == 0)
                gcd = i;
        }
        return gcd;
    }

    static boolean areRelativelyPrime(int a, int b) {

        int gcd = 0;

        for (int i = 1; i < (a > b ? a : b); i++) {
            if ((a % i == 0) && (b % i == 0))
                gcd++;
        }

        if (gcd == 1)
            return true;
        else
            return false;

    }

    static boolean isPerfect(int n) {

        int perfect = 0;

        for (int i = 1; i < n; i++) {
            if (n % i == 0)
                perfect += i;
        }

        if (perfect == n)
            return true;
        else
            return false;

    }
}
