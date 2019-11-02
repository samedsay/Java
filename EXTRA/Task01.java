import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int counter = 0;

        System.out.println("Enter size of A!");
        int aSize = scan.nextInt();
        int[] a = new int[aSize];
        System.out.println("Enter elements of A!");
        for (int i = 0; i < aSize; i++) {
            a[i] = scan.nextInt();                                    // Input Section
        }
        System.out.println("Enter size of B");
        int bSize = scan.nextInt();
        int[] b = new int[bSize];
        System.out.println("Enter elements of B");
        for (int i = 0; i < bSize; i++) {
            b[i] = scan.nextInt();
        }

        int[] c = new int[b.length];

        for (int i = 0; i < bSize; i++) {
            for (int j = 0; j < aSize; j++) {
                if (b[i] == a[j]) {
                    counter++;                                        // Find the how many numbers are equal in both A and B.
                    c[i] = counter;
                }
            }
            counter = 0;

            for (int k = 0; k < bSize; k++) {                         // Check the equal numbers in B and set the value '-1'.
                if ((b[i] == b[k]) && (k < i)) {
                    c[i] = -1;
                }
            }
        }

        for (int i = 0; i < c.length; i++)                            // Printing Section
            System.out.print("B[" + i + "] = " + c[i] + ",");
    }
}
