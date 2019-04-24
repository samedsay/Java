public class TBetterThreads extends Thread {
    private long number = 0L;

    public static void main(String[] args) {
        new TBetterThreads().start();
    }

    public TBetterThreads() {
        final int MAXNUM = 40;
        for (int i = 0; i < MAXNUM; i++)
            new Thread(new MyRunner(this), "" + i).start();
        System.out.println(MAXNUM + " THREADS STARTED");
    }

    public long getNumber() {
        if (number < 1)
            number = number + 1;
        number = number - 1;
        return number;
    }

    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ignored) {
        }
        System.out.print("Killing program");
        System.exit(0);
    }
}

class MyRunner implements Runnable {
    private final TBetterThreads better;

    public MyRunner(TBetterThreads better) {
        this.better = better;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        long n;
        while (true) {
            synchronized (better) {
                n = better.getNumber();
            }
            if (n != 0) {
                System.out.println("n = " + n + " in thread " + name);
            }
        }
    }
}
