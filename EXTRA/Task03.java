import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int number = scan.nextInt();
        int remainder;
        int counter = 1;
        int i = 0;
        int temp = number;

        while (temp != 0) {
            temp /= 10;
            i++;
        }

        int[] array = new int[i];

        while (number != 0) {
            i--;
            remainder = number % 10;
            array[i] = remainder;
            number /= 10;
            counter *= 10;

        }
        for (i = 0; i < array.length; i++) {
            counter /= 10;
            System.out.println(counter + " ler basamağı : " + array[i]);
        }
    }
}
