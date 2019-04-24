import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TThreadPool extends Thread {
    ExecutorService pool = null;

    public static void main(String[] args) {
        new TThreadPool().start();
    }

    TThreadPool() {
        Runnable[] runs = {
                new Fibo(40L), new Fibo(39L),
                new Fibo(41L), new Fibo(38L),
                new Fibo(37L), new Fibo(42L),
        };
        // pool for 3 concurrent threads
        pool = Executors.newFixedThreadPool(4);

        //submitting six threads...
        for (Runnable r : runs)
            pool.execute(r);
        //no other threads will be added
        pool.shutdown();
        System.err.println("Shutdown executed");
    }

    public void run() {
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
            System.err.println("Still running...");
        }
        System.err.println("All done");
    }
}

class Fibo implements Runnable {
    private final long arg;

    Fibo(long n) {
        arg = n;
    }

    static long fibon(long n) {
        return (n < 2) ? n : fibon(n - 2) + fibon(n - 1);
    }

    public void run() {
        System.err.println("Fibo(" + arg + ") starts");
        long res = fibon(arg);
        System.err.println("Fibo(" + arg + ") completed " +
                "with res = " + res);
    }

}
