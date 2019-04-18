class Task2 {

    //Prints array elements with recursive.
    static void printArr(int[] arr, int from) {
        if (from == arr.length) {
            System.out.println();
            return;
        }
        System.out.print(arr[from] + " ");
        printArr(arr, from + 1);
    }

    static void revArr(int[] arr, int from, int to) {
        if (to - from <= 1) return;
        int temp = arr[from];
        arr[from] = arr[to - 1];
        arr[to - 1] = temp;
        revArr(arr, from + 1, to - 1);
    }

    static void selSort(int[] arr, int from) {
        if (from == arr.length - 1) return;
        int indmin = from;
        for (int i = from + 1; i < arr.length; i++) {
            if (arr[i] < arr[indmin])
                indmin = i;
        }
        int temp = arr[from];
        arr[from] = arr[indmin];
        arr[indmin] = temp;
        selSort(arr, from + 1);
    }

    static void printArrReverse(int[] arr, int from) {
        if (from == arr.length)
            return;
        printArrReverse(arr, from + 1);
        System.out.print(arr[from] + " ");
        if (from == 0)
            System.out.println();
    }

    static int maxElem(int[] arr, int from) {
        if (from == arr.length - 1)
            return arr[arr.length - 1];
        return Math.max(arr[from], maxElem(arr, from + 1));
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int fact(int n) {
        return n <= 1 ? 1 : n * fact(n - 1);
    }

    static boolean isPrime(int n, int k) {
        if (k * k > n)
            return true;
        if (n % k == 0)
            return false;
        return isPrime(n, k + 1);
    }

    static long counter = 0;

    static long fibo(int n) {
        ++counter;
        return n < 1 ? (long) n : fibo(n - 2) + fibo(n - 1);
    }

    public static void main(String[] args) {

        int[] array = {13, 3, 55, 7, 9, 11};
        printArr(array, 0);
        revArr(array, 0, array.length);
        printArr(array, 0);
        selSort(array, 0);
        printArr(array, 0);
        printArrReverse(array, 0);
        System.out.println("Max. in array: " + maxElem(array, 0));
        System.out.println("Greates common divisor of 5593 and 11067 is " + gcd(5593, 11067));

        // FACTORIAL NUMBERS
        System.out.println("10! = " + fact(10));
        System.out.println("12! = " + fact(12));
        // NO ERROR BUT WRONG!!
        System.out.println("13! = " + fact(13));


        // PRIME NUMBERS
        System.out.println("Primes up to 100");
        for (int n = 2; n <= 100; n++) {
            if (isPrime(n, 2))
                System.out.print(n + " ");
        }
        System.out.println();

        // FIBONACCI NUMBERS
        for (int n = 40; n <= 46; n += 2) {
            counter = 0;
            long r = fibo(n);
            System.out.println("Fibo(" + n + ") = " + r + "; counter = " + counter);
        }
    }
}
