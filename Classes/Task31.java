//Fields, constructors and methods in enumerations

public class Task31 {

    enum Season {
        SPRING("nice", 2) {
            public String getDesc() {
                return name() + ": " + desc;
            }
        },
        SUMMER("hot", 3) {
            public String getDesc() {
                return desc + " in " + name();
            }
        },
        FALL("so, so", 4) {
            public String getDesc() {
                return name() + "? Well, " + desc;
            }
        },
        WINTER("cold", 3) {
            public String getDesc() {
                return name() + "! very " + desc;
            }
        };  // <--semicolon after the last value!

        // fields and constructors are private anyway
        String desc;
        int numOfMonths;

        Season(String d, int i) {
            desc = d;
            numOfMonths = i;
        }

        public int getNumb() {
            return numOfMonths;
        }

        public abstract String getDesc();
    }

    ;

    public static void main(String[] args) {
        for (Season s : Season.values())
            System.out.println(s.getNumb() +
                    " months - " + s.getDesc());
    }
}
