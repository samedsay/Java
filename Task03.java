import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {

        // Problem 1

        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int first = number;
        int times = 0;
        int biggest = 0;
        int last = 0;

        while (number != 0) {

            if (first == number)
                times++;
            else {
                if (biggest <= times) {
                    biggest = times;
                    last = first;
                }
                first = number;
                times = 1;
            }

            number = scan.nextInt();

        }
        if (biggest <= times) {
            biggest = times;
            last = first;
        }

        System.out.println(biggest + " times " + last);

        // Problem 2

        System.out.println("Enter n to triangle: ");
        int n = scan.nextInt();
        int space = n;

        for (int i = 0; i < n; i += 2) {
            for (int j = 0; j < i; j++)
                System.out.print(" ");
            for (int k = 0; k < space; k++)
                System.out.print("* ");

            System.out.println();
            space -= 2;

        }

        // Problem 3

        System.out.println("-------------------------------------------------------");
        System.out.println("Enter wide and high to quadliteral: ");
        int wide = scan.nextInt();
        int high = scan.nextInt();

        for (int i = 0; i < high; i++) {
            for (int j = 0; j < wide; j++) {
                if ((i == 0) || (i == high - 1) || (j == 0) || (j == wide - 1))
                    System.out.print("*");
                else
                    System.out.print(" ");

            }
            System.out.print("\n");
        }

        // Problem 4

        System.out.println("Enter a number: ");
        int num1 = scan.nextInt();
        System.out.println("One more please: ");
        int num2 = scan.nextInt();

        int gcd;

        while (num1 != num2) {

            if (num1 > num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }

        }
        gcd = num1;
        System.out.println(gcd);


        // Problem 5

        System.out.println("Enter two numbers : ");
        first = scan.nextInt();
        int second = scan.nextInt();

        for (int i = 1; i <= first; i++) {
            for (int j = 1; j <= second; j++) {
                System.out.print((i * j) + "\t");
            }
            System.out.println();
        }
    }
}
