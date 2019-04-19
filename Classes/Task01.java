public class Task01 {

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

        Task01.setRate(4.1);
        Task01 sa = new Task01(10);
        Task01 sb = new Task01(16);
        Task01 sc = new Task01(20);
        System.out.println(sa + "\n" + sb + "\n" + sc);


    }
}
