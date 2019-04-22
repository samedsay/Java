interface Func<T, R> {
    R apply(T e);

    default <S> S compos(T arg, Func<R, S> g) {
        return g.apply(apply(arg));
    }
}

public class Task22 {
    public static void main(String[] args) {
        Func<String, Integer> f = s -> s.length();
        System.out.println("g(f(\"abc\")) = " +
                f.compos("abc", v -> v * Math.PI));
    }
}
