public class TStopThread {
    static volatile boolean canRun = true;

    public static void main(String[] args) {
        Thread runner = new Thread(() -> {
            while (canRun) {
                System.out.println("still running...");

                try {
                    Thread.sleep(750);
                } catch (InterruptedException ignored) {
                }
            }
            System.out.println("INTERRUPTED!");
        });
        runner.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {
        }
        canRun = false;
    }
}
