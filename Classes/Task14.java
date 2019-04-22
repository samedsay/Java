interface BiIntOperator {
    int apply(int i, int j);
}

class AddAndMult implements BiIntOperator {
    int seed;

    AddAndMult(int seed) {
        this.seed = seed;
    }

    AddAndMult() {
        this(1);
    }

    public int apply(int i, int j) {
        return seed * (i + j);
    }
}

class MultAndAdd implements BiIntOperator {
    int seed;

    MultAndAdd(int seed) {
        this.seed = seed;
    }

    MultAndAdd() {
        this(1);
    }

    public int apply(int i, int j) {
        return seed + i * j;
    }
}

public class Task14 {
    public static void main(String[] args) {
        BiIntOperator[] opers = {
                new AddAndMult(2), new MultAndAdd(5),
                new BiIntOperator() {
                    @Override
                    public int apply(int i, int j) {
                        return i * i + j * j;
                    }
                },
                new MultAndAdd(3) {
                    @Override
                    public int apply(int i, int j) {
                        return seed * (i * i + j * j);
                    }
                }
        };
        int a = 1, b = 2;
        for (BiIntOperator op : opers)
            System.out.print(op.apply(a, b) + " ");
        System.out.println();
    }
}
