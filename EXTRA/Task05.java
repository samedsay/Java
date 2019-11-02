import java.lang.Math;
import java.util.Scanner;

public class Task05 {

    public static void checkNumber(int targetNum, int number) {

        char[] target = String.valueOf(targetNum).toCharArray();
        char[] num = String.valueOf(number).toCharArray();
        int counter = 0;
        int rightPlace = 0;
        int[] same = new int[4];
        int sameNum = 0;
        int total = 0;

        for (int i = 0; i < target.length; i++) {
            System.out.println(target[i] + " " + num[i]);
        }

        if (number == targetNum)
            System.out.println("Congratulations! You win!");
        else {

            for (int i = 0; i < target.length; i++) {
                /*if (target[i] != num[i] && (num[i] == 'X')){
                    rightPlace++;
                }*/
                for (int j = 0; j < num.length; j++) {
                    if (target[i] == num[j] && target[i] != num[i])
                        rightPlace++;
                }
            }

            for (int i = 0; i < target.length; i++) {
                for (int j = 0; j < num.length; j++) {

                    if (target[i] == target[j]) {
                        same[i] = sameNum++;

                    }

                    if (target[i] == num[j] && (num[j] != 'X')) {
                        counter++;
                        num[j] = 'X';
                        break;
                    }
                }
                total += same[i];
                sameNum = 0;
            }

            for (int i = 0; i < target.length; i++) {
                System.out.println(same[i] + " - " + total);
            }


            if (counter > 0)
                System.out.print(counter + " numbers are true but ");

            if ((rightPlace) > 0)
                System.out.println((rightPlace /*- (total > 1 ? 2 : 1)*/) + " of them is not in right place.");
            
        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int targetNumber = ((int) (Math.random() * 10000));
        while (targetNumber < 1000 || targetNumber > 9999) {
            targetNumber = ((int) (Math.random() * 10000));
        }
        System.out.println(targetNumber);
        System.out.println("You have 8 chance to estimate the number: ");
        int rights = 1;
        int number;

        while (rights <= 8) {
            System.out.println("Enter " + rights + ". number: ");
            number = scanner.nextInt();
            checkNumber(targetNumber, number);
            rights++;
        }

    }
}
