import javax.swing.*;
import java.util.Scanner;

public class Task01{
    public static void main(String[] args) {

        // Problem 1

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your height: ");
        double a = scan.nextDouble();
        System.out.println("Enter your weight:");
        double b = scan.nextDouble();
        double calculation = (b / (a * a));
        String message = String.format("Your BMI is %f", calculation);
        JOptionPane.showMessageDialog(null, message);

        // Problem 2

        System.out.println("Enter three numbers: ");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();

        if (num1 == num2 && num1 == num3)
            System.out.println("Not Working!");
        else if(num1 != num2 && num1 != num3 && num2 != num3)
            System.out.println("Not Working!");
        else
            System.out.println("Working!");


        // Problem 3

        if ((num1 == num2) && (num1 == num3))
            System.out.println(num1 + " = " + num2 + " = " + num3);
        else if (num1 == num2) {
            if (num1 > num3)
                System.out.println(num1 + " = " + num2 + " > " + num3);
            else
                System.out.println(num3 + " > " + num2 + " = " + num1);
        } else if (num1 == num3) {
            if (num1 > num2)
                System.out.println(num1 + " = " + num3 + " > " + num2);
            else
                System.out.println(num2 + " > " + num1 + " = " + num3);
        } else if (num2 == num3) {
            if (num2 > num1)
                System.out.println(num2 + " = " + num3 + " > " + num1);
            else
                System.out.println(num1 + " > " + num2 + " = " + num3);
        } else if ((num1 > num2) && (num1 > num3)) {
            if (num2 > num3)
                System.out.println(num1 + " > " + num2 + " > " + num3);
            else
                System.out.println(num1 + " > " + num3 + " > " + num2);

        } else if ((num2 > num1) && (num2 > num3)) {
            if (num1 > num3)
                System.out.println(num2 + " > " + num1 + " > " + num3);
            else
                System.out.println(num2 + " > " + num3 + " > " + num1);
        } else if ((num3 > num1) && (num3 > num2)) {
            if (num1 > num2)
                System.out.println(num3 + " > " + num1 + " > " + num2);
            else
                System.out.println(num3 + " > " + num2 + " > " + num1);

        }

        // Problem 4

        System.out.println("Enter three numbers: ");
        int first = scan.nextInt();
        int second = scan.nextInt();
        int third = scan.nextInt();

        if (((first + second) > third) && ((first + third) > second) && ((second + third) > first))
            System.out.println("It's OK!");
        else
            System.out.println("It's not OK!");

        // Problem 5
        int middle = 0;

        if (first > second && first > third) {
            if (second > third)
                middle = second;
            else
                middle = third;
        }
        if (second > first && second > third) {
            if (first > third)
                middle = first;
            else
                middle = third;
        }
        if (third > first && third > second) {
            if (first > second)
                middle = first;
            else
                middle = second;
        }

        System.out.println("Middle number is " + middle);

        // Problem 6

        System.out.println("Enter a,b and c to find the root of ax^2 + bx + c :");

        double discriminant = (second * second) - (4 * first * third);
        double root1 = 0, root2 = 0;

        if (discriminant > 0) {
            root1 = (-second + Math.sqrt(discriminant)) / (2 * first);
            root2 = (-second - Math.sqrt(discriminant)) / (2 * first);
            System.out.println("root1 = " + root1 + ", root2 = " + root2);
        } else if (discriminant == 0) {
            root1 = (-1.0)* (second) / (2 * first);
            root2 = root1;
            System.out.println("root1 = " + root1 + ", root2 = " + root2);
        } else {
            discriminant *= -1;
            root1 = ((-1.0)*(second) + Math.sqrt(discriminant)) / (2 * first);
            root2 = ((-1.0)*(second) - Math.sqrt(discriminant)) / (2 * first);
            System.out.println("root1 = " + root1 + "i, root2 = " + root2 + "i");

        }
    }
}


