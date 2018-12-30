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
        
        // Problem 2

        System.out.println("Enter an int");
        int n = scan.nextInt();
        boolean is7thBitSet = false;
        is7thBitSet = (n & 128) == 128;
        System.out.println("Is 7th bit set? " + is7thBitSet);

        int numberOf1s = 0;
        int remainder = 0;
        long total = 0;
        int exponent = 0;
        int mostSignificant = -1;
        int firstNumber = n;
        int swapped = 0;
        int leastByte1 = 0;
        int leastByte2 = 0;


        for (int i = 0, j = 31; i < 32; i++, j--) {
            if (((n >>> i) & 1) == 1) {
                numberOf1s++;
            }
        }

        System.out.println("No. of 1s is " + numberOf1s);

        while (n > 0) {
            remainder = n % 2;
            total += remainder * Math.pow(10, exponent);
            n /= 2;
            exponent++;
        }

        if (n < 0) {

            for (int i = 0, j = 31; i < 32; i++, j--) {
                if (((n >>> j) & 1) == 1) {
                    total += 1 * Math.pow(10, exponent);
                }
                exponent++;
            }
        }
        if (firstNumber != 0) {
            mostSignificant = exponent - 1;
        }

        System.out.println("Most significant bit set: " + mostSignificant);

        if (firstNumber < 0) {

            leastByte1 = firstNumber << 24;
            leastByte1 = leastByte1 >> 16;
            leastByte2 = firstNumber << 16;
            leastByte2 = leastByte2 >> 24;
            swapped = (leastByte1 | leastByte2);

        } else {

            leastByte1 = firstNumber << 24;
            leastByte1 = leastByte1 >>> 16;
            leastByte2 = firstNumber << 16;
            leastByte2 = leastByte2 >>> 24;
            swapped = (leastByte1 | leastByte2);
        }


        System.out.println("With 2 least significant bytes" + " swapped: " + swapped);

    }
}
