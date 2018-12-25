import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {

        // Problem 1

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter two number: ");
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        System.out.println("Which operation you want to make ('*','-','+','/')");
        String operation = scan.next();
        switch (operation) {
            case "*":
                System.out.println(a + " * " + b + " = " + (a * b));
                break;
            case "-":
                System.out.println(a + " - " + b + " = " + (a - b));
                break;
            case "+":
                System.out.println(a + " + " + b + " = " + (a + b));
                break;
            case "/":
                System.out.println(a + " / " + b + " = " + (a / b));
                break;
                default:
                    System.out.println("Invalid input!");
        }

        System.out.println("-------------------------------------------");

        // Problem 2

        System.out.println("Enter 4 integers to find largest difference");

        int largest = 0;
        int smallest = 0;
        System.out.println("Enter 4 number: ");
        int number = scan.nextInt();
        smallest = number;
        largest = number;

        for (int i = 0; i < 3; i++) {

            number = scan.nextInt();

            if (number >= largest)
                largest = number;
            else if (number <= smallest)
                smallest = number;
        }
        System.out.println(largest + " - " + smallest + " = " + (largest - smallest));


    }

}
