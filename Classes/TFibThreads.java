public class TFibThreads {
    private int counter;

    public static void main(String[] args) {
        new TFibThreads();
    }

    TFibThreads() {
        Runnable[] runs = {
                new Fibo(7L, this), new Fibo(44L, this),
                new Fibo(46L, this), new Fibo(45L, this),
                new Fibo(45L, this), new Fibo(45L, this),
        };
        counter = runs.length;

        for (Runnable r : runs)
            new Thread(r).start();
        System.out.println("Exiting from \"main\"");
    }

    synchronized void finished(long arg, long res) {
        counter = counter - 1;
        System.out.println("Fib(" + arg + ") = " + res + ". Still running:" + counter);
    }

}

class Fibo implements Runnable {
    private final long arg;
    private final TFibThreads parent;


    static long fibon(long n) {
        return (n < 2) ? n : fibon(n - 2) + fibon(n - 1);
    }

    Fibo(long n, TFibThreads w) {
        arg = n;
        parent = w;
    }

    public void run() {
        System.out.println("Fibo(" + arg + ") starting");
        long res = fibon(arg);
        parent.finished(arg, res);
    }
}
