import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TBlockQ {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Cons c = new Cons(queue, 0);
        c.start();
        Prod p1 = new Prod(queue, 10);
        Prod p2 = new Prod(queue, 20);
        p1.start();
        p2.start();
    }

    static class Prod extends Thread {
        private final BlockingQueue<Integer> queue;
        private final int low;

        Prod(BlockingQueue<Integer> queue, int low) {
            this.queue = queue;
            this.low = low;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    int d = low + (int) (10 * Math.random());
                    System.err.println("Try to put " + d);
                    queue.put(d);
                    System.err.println("     put " + d);
                    sleep(500 + (int) (300 * Math.random()));
                } catch (InterruptedException ignore) {
                }


            }
            try {
                queue.put(-1);
            } catch (InterruptedException ignore) {
            }
        }
    }

    static class Cons extends Thread {
        private final BlockingQueue<Integer> queue;
        private final int poison;

        Cons(BlockingQueue<Integer> queue, int poison) {
            this.queue = queue;
            this.poison = poison;
        }

        public void run() {
            int pills = 0;
            while (pills < 2) {
                try {
                    System.out.println("taking");
                    int d = queue.take();
                    System.err.println(" taken " + d);
                    if (d < poison) {
                        System.out.println("Poison pill received");
                        ++pills;
                    }
                    sleep(700 + (int) (300 * Math.random()));

                } catch (InterruptedException ignore) {
                }
            }
        }
    }
}
