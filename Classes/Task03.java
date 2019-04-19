class Task03 {

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

    public Task03() {
        show("   constructor");
    }

    public static void show(String mes) {
        System.out.println(mes + ":" +
                " sino=" + sino +
                " siyes=" + siyes +
                " fin=" + fin);
    }

    public static void main(String[] args) {

        Task03 e = new Task3();
    }
}
