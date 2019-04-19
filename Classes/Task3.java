class Task3 {

    private static int sino;
    private static int siyes = 2;
    private static final int fin;

    {
        show("nonstatic init");
        sino = 1;
    }

    static {
        show("   static init");
        fin = 3;
    }

    public Task3() {
        show("   constructor");
    }

    public static void show(String mes) {
        System.out.println(mes + ":" +
                " sino=" + sino +
                " siyes=" + siyes +
                " fin=" + fin);
    }

    public static void main(String[] args) {

        Task3 e = new Task3();
    }
}
