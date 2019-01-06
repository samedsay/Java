public class Task08 {
    public static void main(String[] args) {

        // Problem 1

        int[][] arr = {{1, 3, 2}, {3, 4, 8}, {2, 6, 8}, {1, 8, 5}};

        int row = 0, col = 0, biggestRow = 0, biggestCol = 0;
        int indexRow = 0, indexCol = 0;
        int[][] tempArr = new int[arr[col].length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0, k = 0; j < arr[i].length; j++) {
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

        System.out.print(indexRow + " " + indexCol);

        // Problem 2


    }
}
