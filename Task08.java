import java.util.Arrays;

public class werner08 {
    public static void main(String[] args) {

        // Problem 1

        int[][] arr1 = {{1, 3, 2}, {3, 4, 8}, {2, 6, 8}, {1, 8, 5}};

        function1(arr1);
        System.out.println();

        // Problem 2

        int[][] arr2 = {{1, 3}, {3, 4, 5, 8}, {6, 8}, {1, 9, 6}};

        int temp[] = function2(arr2);

        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println("\n");

        // Problem 3

        int[][] arr3 = {{1, 2, 3, 4, 5}, {1, 9}, {3, 1, 8}};

        function3(arr3);
        System.out.println();

        // Problem 4

        int[][] a = {{1, 2, 3, 4, 5, 6},
                {2, 3, 4, 5, 6, 7},
                {3, 4, 5, 6, 7, 8},
                {4, 5, 6, 7, 8, 9}};
        for (int[] r : a)
            System.out.println(Arrays.toString(r));

        System.out.println();

        for (int[] r : inner(a))
            System.out.println(Arrays.toString(r));
    }

    public static int[][] inner(int[][] arr) {

        int[][] temp = new int[arr.length - 2][arr[0].length - 2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if (!((i == 0) || (j == 0) || (i == arr.length - 1) || (j == arr[i].length - 1))) {

                    temp[i - 1][j - 1] = arr[i][j];
                }
            }
        }
        return temp;
    }

    public static void function3(int[][] arr) {
        int even = 0, odd = 0;
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if (arr[i][j] % 2 == 0)
                    even++;
                else
                    odd++;
            }
        }
        System.out.println("Even: " + even + "; odd: " + 7);
    }

    public static int[] function2(int[][] arr) {

        int[] temp = new int[arr.length];
        int biggest = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if (biggest < arr[i][j]) {
                    biggest = arr[i][j];
                    temp[i] = biggest;
                }
            }
            biggest = 0;
        }
        return temp;
    }

    public static void function1(int[][] arr) {

        int row = 0, col = 0, biggestRow = 0, biggestCol = 0;
        int indexRow = 0, indexCol = 0;
        int[][] tempArr = new int[arr[col].length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                row += arr[i][j];
            }
            if (biggestRow <= row) {
                biggestRow = row;
                indexRow = i;
            }
            row = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                tempArr[j][i] = arr[i][j];
            }
        }
        for (int i = 0; i < tempArr.length; i++) {
            for (int j = 0; j < tempArr[i].length; j++) {
                col += tempArr[i][j];
            }
            if (biggestCol <= col) {
                biggestCol = col;
                indexCol = i;
            }
            col = 0;
        }
        System.out.println(indexRow + " " + indexCol);
    }
}
