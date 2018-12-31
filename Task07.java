import java.util.Scanner;

public class werner07 {
    public static void main(String[] args) {

        // Problem 1

        Scanner scan = new Scanner(System.in);

        int odd = 0, even = 0, temp = 0, oddIndex = 0, evenIndex = 0;
        int flag1 = 0;
        int flag2 = 0;


        System.out.println("Enter size of array: ");
        int size = scan.nextInt();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = scan.nextInt();
        }
        for (int i = 0; i < size; i++) {
            if (array[i] % 2 == 0) {
                even++;
            }
            if (array[i] % 2 == 1) {
                odd++;
            }
        }

        if ((odd < 1) || (even < 1)) {
            System.out.println("Please at least odd or even number: ");
        }

        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            if ((array[i] % 2 == 1) && (flag1 != 1)) {
                oddIndex = i;
                odd = array[i];
                flag1 = 1;
                break;
            }
        }
        for (int i = size - 1; i >= 0; i--) {
            if ((array[i] % 2 == 0) && (flag2 != 1)) {
                evenIndex = i;
                even = array[i];
                flag2 = 1;
            }
        }
        temp = array[oddIndex];
        array[oddIndex] = array[evenIndex];
        array[evenIndex] = temp;

        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "  ");
        }

        System.out.println("\n");

        // Problem 2

        int biggest = 0;

        System.out.println("Enter size of histogram: ");
        int size2 = scan.nextInt();
        int[] histogram = new int[size2];
        for (int i = 0; i < size2; i++) {
            histogram[i] = scan.nextInt();
            if (histogram[i] > biggest)
                biggest = histogram[i];
        }

        int pointer = 0;

        for (int i = 0; i < biggest; i++) {


            for (int j = 0; j < size2; j++) {
                if (pointer < (biggest - histogram[j]))
                    System.out.print(" ");
                else
                    System.out.print("*");

            }
            pointer++;

            System.out.println();
        }

        System.out.println("\n");

        // Problem 3

        for (int i = 0; i < size2; i++) {
            System.out.print(histogram[i]);
        }
        int temp3 = histogram[0];
        int temp2;
        for (int i = 0; i < size2 - 1; i++) {
            temp2 = histogram[i];
            histogram[i] = histogram[i + 1];
        }
        System.out.println();
        histogram[size2 - 1] = temp3;
        for (int i = 0; i < size2; i++) {
            System.out.print(histogram[i]);
        }

        System.out.println("\n");

        // Problem 4

        int[] arr = {4, 3, 4, 3, 6, 7, 4, 8, 2, 9};
        int[] brr = {2, 3, 6, 8, 1, 5};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < brr.length; j++) {
                if (arr[i] == brr[j]) {
                    arr[i] = 0;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {

            int counter = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    counter++;
                    if (counter > 1) {
                        arr[i] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0)
                System.out.print(arr[i] + " ");
        }
    }
}
