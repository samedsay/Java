public class Task28 {

    public enum Season {SPRING, SUMMER, FALL, WINTER};

    public static void main(String[] args) {

        Season[] seasons = Season.values();
        for (Season s : seasons)
            System.out.print(s + " ");
        System.out.println();

        System.out.println(Season.WINTER + " is the " +
                (Season.WINTER.ordinal() + 1) + "th season");
        Season f = Season.valueOf("FALL");
        System.out.println("FALL is " + f + "...");
        System.out.println("Is f equal to FALL? " +
                (f == Season.FALL));
        for (Season s : seasons)
            System.out.print(german(s) + " ");
        System.out.println();
    }

    private static String german(Season s) {
        switch (s) {
            case SPRING:
                return "Fr\u00fchling";
            case SUMMER:
                return "Sommer";
            case FALL:
                return "Herbst";
            case WINTER:
                return "Winter";
        }
        return "Cannot happen";
    }
}
