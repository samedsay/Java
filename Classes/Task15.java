abstract class Animal {
    String name;
    double weight;

    public Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    abstract public String speak();

    @Override
    public String toString() {
        return name + "(" + weight + ")" + speak();
    }
}

public class Task15 {
    public static void main(String[] args) {
        Animal max = new Animal("Max", 15) {
            @Override
            public String speak() {
                return "bow - bow";
            }
        };

        Animal[] animals = {
                max,
                new Animal("Batty", 3.5) {
                    @Override
                    public String speak() {
                        return "miaou - miaou";
                    }
                }
        };
        for (Animal a : animals)
            System.out.println(a);
    }
}
