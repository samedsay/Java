public class Task1 {

    private static double rate = 1;
    private static char ID = 'A';

    private double amount;
    private char id;

    public static void setRate(double r){ rate = r;}
    public static double getRate(){return rate;}

    Task1(double a){
        id = ID++;
        amount = a;
    }
    public String toString(){
        return "I am " + id + ", I have $" + amount +
                " = " + rate * amount + " PLN";
    }

    public static void main(String[] args) {

        Task1.setRate(4.1);
        Task1 sa = new Task1(10);
        Task1 sb = new Task1(16);
        Task1 sc = new Task1(20);
        System.out.println(sa + "\n" + sb + "\n" + sc);


    }
}
