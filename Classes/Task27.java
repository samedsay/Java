public class Task26 {

    static <T extends Comparable<T>> T getMax(T[] arr) {
        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException();
        T max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i].compareTo(max) > 0)
                max = arr[i];
        return max;
    }

    public static void main(String[] args) {

        int mxi = getMax(new Integer[]{3, -2, -7, 2});
        String mxs = Task26.<String>getMax(
                new String[]{"A", "Z", "C"});
        System.out.println("I - max = " + mxi);
        System.out.println("S - max = " + mxs);
    }
}
