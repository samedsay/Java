public class TBadThreads extends Thread {
    private long number = 0L;

    public static void main(String[] args) {
        new TBadThreads().start();
    }

    public TBadThreads() {
        final int MAXNUM = 40;
        for (int i = 0; i < MAXNUM; i++)
            new Thread(new MyRunner(this), "" + i).start();
        System.err.println(MAXNUM + " THREADS STARTED");
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
        System.err.println("Killing program");
        System.exit(0);
    }
}

class MyRunner implements Runnable {
    private final TBadThreads bad;

    public MyRunner(TBadThreads bad) {
        this.bad = bad;
    }

    public void run() {
        String name = Thread.currentThread().getName();
        while (true) {
            long n = bad.getNumber();
            if (n != 0) {
                System.err.println("n = " + n + " in thread " + name);
                break;
            }
        }
    }
}
