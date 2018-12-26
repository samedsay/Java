import javax.swing.*;
import java.util.Scanner;

public class Task04 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // Problem 1

        System.out.println("Enter a natural number: ");
        int natural = scan.nextInt();
        boolean flag = false;

        String message = String.format("Nontrivial divisors of " + natural + ": ");

        for (int i = 2; i < natural; i++) {
            if (natural % i == 0) {
                flag = true;
            }
        }
        if (flag == false) {
            System.out.println("Number is prime!");
        } else {
            for (int i = 2; i < natural; i++) {
                if (natural % i == 0) {
                    message += String.format(i + " ");
                }
            }
        }

        JOptionPane.showMessageDialog(null, message);

        // Problem 2

        System.out.println("Please enter a decimal number: ");
        int number = scan.nextInt();
        int remainder = 0;
        int total = 0;
        int exponent = 0;

        while (number > 0) {
            remainder = number % 2;
            total += remainder * Math.pow(10, exponent);
            number /= 2;
            exponent++;
        }
        System.out.println(total);
        while (total > 0) {
            System.out.print((total % 10) + ", ");
            total /= 10;
        }

        System.out.println();

        // Problem 3

        System.out.print("enter a natural number (0 if done): ");
        number = scan.nextInt();
        System.out.println();
        int temporaryNumber = 0;
        int maxDig = 0;
        int biggestNumber = 0;

        while (number != 0) {
            temporaryNumber = number;
            total = 0;
            while (temporaryNumber > 0) {
                remainder = temporaryNumber % 10;
                total += remainder;
                temporaryNumber /= 10;
            }
            if (total >= maxDig) {
                maxDig = total;
                biggestNumber = number;
            }

            System.out.print("enter a natural number (0 if done): ");
            number = scan.nextInt();
            System.out.println();
        }

        System.out.println("Max sum of digits was " + maxDig + " for " + biggestNumber);

        // Problem 4

        System.out.println("Please hold one number in your mind between 0 to 1 000 000! ");
        System.out.println("'s' if number is smaller than the chosen number; ");
        System.out.println("'b' if number is bigger than the chosen number; ");
        System.out.println("'y' if number is equal the chosen number; ");

        char equal;
        int max = 1_000_000;
        int min = 0;
        int diff = 0;
        int chosen = max / 2;
        flag = true;

        while (flag) {
            System.out.println("Is this " + chosen + "?");
            equal = scan.next().charAt(0);
            switch (equal) {
                case 's':
                    max = chosen;
                    diff = (max - min) / 2;
                    chosen -= diff;
                    break;

                case 'b':
                    min = chosen;
                    diff = (max - min) / 2;
                    chosen += diff;
                    break;
                case 'y':
                    System.out.println("Your number is " + chosen + "!");
                    flag = false;
                    break;
            }
        }
    }
}
