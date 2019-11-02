import java.util.Scanner;

public class Task02 {

    public static int smallestFunc(int[] array){
        int smallest = array[0];
        for(int i = 1; i < array.length; i++){
            if(smallest > array[i])
                smallest = array[i];
        }
        return smallest;
    }
    public static int biggestFunc(int[] array){
        int biggest = array[0];
        for(int i = 1; i < array.length; i++){
            if(biggest < array[i])
                biggest = array[i];
        }
        return biggest;
    }
    public static void sortingFunc(int[] array){

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                if(array[i] < array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for(int x : array)
            System.out.print(x + " ");
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter array size:");
        int size = scan.nextInt();
        int[] array = new int[size];
        for(int i = 0; i < array.length; i++){
            array[i] = scan.nextInt();
        }

        sortingFunc(array);

        System.out.println("Smallest: " + smallestFunc(array) + "\nBiggest: " + biggestFunc(array));
    }

}
