public class Task30 {

    enum Season {
        SPRING {
            public String toString() {
                return "Printemps";
            }
        },
        SUMMER {
            public String toString() {
                return "\u00c9t\u00e9";
            }
        },
        FALL {
            public String toString() {
                return "Automne";
            }
        },
        WINTER {
            public String toString() {
                return "Hiver";
            }
        }
    }

    ;

    public static void main(String[] args) {
        Season[] seasons = Season.values();
        for (Season s : seasons)
            System.out.print(s + " ");
        System.out.println();
        for (Season s : seasons)
            System.out.print(s.name() + " ");
        System.out.println();
    }
}

/*
    We can see that the compiler created distinct classes for each constant. This is quite
obvious: they cannot be objects of the same class, as it would be impossible to have in
one class several implementations of the same method toString! Now, when we print
s (in line //+2), the overridden version of toString will be used. Still, however, the
original ‘true’ name of enum constant may be retrieved by method name() (//+3), as
we can see from the output.
*/
