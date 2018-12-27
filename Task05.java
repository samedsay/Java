import java.util.Scanner;

public class Task05 {
    public  static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        // Problem 1

        System.out.println("Enter a, b, c and d values between [-5, 5] : ");
        System.out.println("We assume that a < b and c < d !");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();

        int max = 5;
        int min = -5;

        boolean state1;
        boolean state2;
        boolean state3;
        boolean state4;
        boolean state5;

        for(int i = min ; i <= max; i++){

            state1 = (i >= a) && (i <= b);
            state2 = (i >= c) && (i <= d);
            state3 = (state1 || state2);
            state4 = (state1 && state2);
            state5 = (state3 ^ state4);

            System.out.println(i + ": inSum? " + state3 +
            "; inIntersect? " + state4 + "; inSymDiff? " + state5 );
        }
    }
}
