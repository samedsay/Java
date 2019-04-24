// Intoduction to Collections

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Task33 {
    public static void main(String[] args) {

        Iterable<Integer> iterable1 = new IterableRange(3, 7);
        Iterator<Integer> iter = iterable1.iterator();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");
        System.out.println("\nand now foreach:");
        for (Integer i : new IterableRange(3, 7))
            System.out.print(i + " ");
        System.out.println();

    }
}

class IterableRange implements Iterable<Integer> {
    private int a, b;

    IterableRange(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Iterator<Integer> iterator() {
        return new RangeIterator(a, b);
    }
}

class RangeIterator implements Iterator<Integer> {
    private int a, b;
    private int curr;

    RangeIterator(int a, int b) {
        this.a = a;
        this.b = b;
        curr = a;
    }

    public boolean hasNext() {
        return curr <= b;
    }

    public Integer next() {
        if (!hasNext())
            throw new NoSuchElementException();
        return curr++;
    }
}
