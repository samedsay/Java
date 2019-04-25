import javax.swing.*;

class MyThread extends Thread {
    volatile boolean stopped = false;
    volatile boolean suspended = false;

    public void run() {
        int num = 0;
        while (!stopped) {
            try {
                synchronized (this) {
                    while (suspended)
                        wait();
                }
            } catch (InterruptedException exc) {
                System.out.println("Interrupted on wait");
            }
            if (suspended)
                System.out.println("Still suspended");
            else
                System.out.println(++num);
        }
    }

    public void stopThread() {
        stopped = true;
    }

    public void suspendThread() {
        suspended = true;
    }

    public boolean isSusp() {
        return suspended;
    }

    public boolean isStop() {
        return stopped;
    }

    public void resumeThread() {
        suspended = false;
        synchronized (this) {
            notify();
        }
    }
}

public class TSuspResum {
    public static void main(String[] args) {
        String msg = "I = interrupt\n" +
                "E = end\n" +
                "S = suspend\n" +
                "R = resume\n" +
                "N = new start";
        MyThread t = new MyThread();
        t.start();
        while (true) {
            String cmd = JOptionPane.showInputDialog(msg);
            if (cmd == null)
                break;
            if (cmd.trim().length() == 0)
                continue;
            char c = Character.toUpperCase(cmd.charAt(0));
            switch (c) {
                case 'I':
                    t.interrupt();
                    break;
                case 'E':
                    t.stopThread();
                    break;
                case 'S':
                    t.suspendThread();
                    break;
                case 'R':
                    t.resumeThread();
                    break;
                case 'N':
                    if (t.isAlive())
                        JOptionPane.showMessageDialog(null, "Thread alive!!!");
                    else {
                        t = new MyThread();
                        t.start();
                    }
                    break;
                default:
                    break;
            }
            JOptionPane.showMessageDialog(null,
                    "Command " + cmd + " executed.\n" +
                            "Thread alive? " +
                            (t.isAlive() ? "Y\n" : "N\n") +
                            "Thread interrupted? " +
                            (t.isInterrupted() ? "Y\n" : "N\n") +
                            "Thread suspended? " +
                            (t.isSusp() ? "Y\n" : "N\n") +
                            "Thread stopped? " +
                            (t.isStop() ? "Y\n" : "N\n"));
        }
        System.exit(0);
    }
}
