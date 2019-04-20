
public class Task08 {
    public static void main(String[] args) {

        testStack(new MyStackArr(10));
        testStack(new MyStackList());
    }

    public static void testStack(IMyStack stack) {
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}

interface IMyStack {
    int pop();

    void push(int i);

    boolean empty();
}

class MyStackArr implements IMyStack {
    int[] arr;
    int top;

    public MyStackArr(int size) {
        arr = new int[size];
        top = 0;
    }

    public int pop() {
        return arr[--top];
    }

    public void push(int i) {
        arr[top++] = i;
    }

    public boolean empty() {
        return top == 0;
    }
}

class MyStackList implements IMyStack {
    private static class Node {
        int data;
        Node next;

        Node(int d, Node n) {
            data = d;
            next = n;
        }

        Node(int d) {
            this(d, null);
        }
    }

    private Node head = null;

    public int pop() {
        int d = head.data;
        head = head.next;
        return d;
    }

    public void push(int d) {
        head = new Node(d, head);
    }

    public boolean empty() {
        return head == null;
    }
}
