class MyStack {
    private static class Node { //Static Inner Class
        int data;
        Node next;

        Node(int d, Node n) {
            data = d;
            next = n;
        }
    }

    private Node top;

    public MyStack() {
        top = null;
    }

    public void push(int d) {
        top = new Node(d, top);
    }

    public int pop() {
        int d = top.data;
        top = top.next;
        return d;
    }

    public boolean empty() {
        return top == null;
    }
}

public class Task13 {
    public static void main(String[] args) {
        MyStack stInt = new MyStack();
        for (int i = 5; i > 0; i--) {
            stInt.push(i);
        }
        while (!stInt.empty())
            System.out.print(stInt.pop() + " ");
        System.out.println();
    }
}
