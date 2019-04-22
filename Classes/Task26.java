class GenArr<T extends Comparable<T>> {
    private T[] arr;
    private T min, max;

    public GenArr(T[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException();
        min = arr[0];
        max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(min) < 0) min = arr[i];
            if (arr[i].compareTo(max) > 0) max = arr[i];
        }
    }

    public T getMin() {
        return min;
    }

    public T getMax() {
        return max;
    }
}

public class Task26 {
    public static void main(String[] args) {

        GenArr<Integer> mnmxI =
                new GenArr<>(new Integer[]{3, -2, -7, 2});
        GenArr<String> mnmxS =
                new GenArr<>(new String[]{"A", "Z", "C"});
        System.out.println("I - min " + mnmxI.getMin() +
                "\nI - max = " + mnmxI.getMax());
        System.out.println("S - min = " + mnmxS.getMin() +
                "\nS- max = " + mnmxS.getMax()
        );

    }
}
