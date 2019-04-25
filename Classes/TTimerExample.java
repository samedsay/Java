import javax.swing.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TTimerExample {
    static int total = 0, correct = 0;

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(correct + "/" +
                        total + " correct answers.");
                System.exit(0);
            }
        }, 20 * 1000);

        Random rand = new Random();
        while (true) {
            int a = rand.nextInt(10) + 1;
            int b = rand.nextInt(10) + 1;
            String oper = a + " x " + b + " is?";
            int expected = a * b;
            Timer timer = new Timer();
            timer.schedule(new Prompt(a, b), 1000, 2000);
            String s = JOptionPane.showInputDialog(
                    null, oper, "Higher math drill",
                    JOptionPane.QUESTION_MESSAGE
            );
            if (s == null)
                System.exit(1);
            int ans = 0;
            try {
                ans = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                timer.cancel();
                continue;
            }
            ++total;
            if (ans == expected) {
                ++correct;
                System.out.println("OK");
            } else
                System.out.println("Wrong!!!");
            timer.cancel();
        }
    }
}

class Prompt extends TimerTask {
    private String oper;
    long start = System.currentTimeMillis();

    public Prompt(int a, int b) {
        oper = a + " x " + b + " is so easy... ";
    }

    @Override
    public void run() {
        long time = System.currentTimeMillis() - start;
        System.out.println(oper + "you've been thinking for " +
                (System.currentTimeMillis() - start) + " ms");
    }
}
