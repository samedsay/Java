class MyQueue<E> {
    private class Node {
        E data;
        Node next = null;

        Node(E d) {
            data = d;
        }
    }

    private Node head, tail;

    public MyQueue() {
        head = tail = null;
    }

    public void enqueue(E d) {
        if (head == null)
            head = tail = new Node(d);
        else
            tail = tail.next = new Node(d);
    }

    public E dequeue() {
        E d = head.data;
        if ((head = head.next) == null) tail = null;
        return d;
    }

    public boolean empty() {
        return head == null;
    }
}

public class Task24 {
    public static void main(String[] args) {
        MyQueue<String> queueS = new MyQueue<>();
        MyQueue<Double> queueD = new MyQueue<>();
        for (double d = 0.5; d < 5; d += 1) {
            queueS.enqueue(String.valueOf(d));
            queueD.enqueue(d);
        }
        while (!queueS.empty() && !queueD.empty()) {
            String s = queueS.dequeue();
            double d = queueD.dequeue();
            System.out.println(
                    "String: " + s + " " + "Double: " + d);
        }
    }
}
