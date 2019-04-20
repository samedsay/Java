class Animal {
    protected String name;
    protected double weight;

    public Animal(String n, double w) {
        name = n;
        weight = w;
    }

    public String getVoice() {
        return "?";
    }

    public static void voices(Animal[] animals) {
        for (Animal a : animals)
            System.out.println(a + " " + a.getVoice());
    }

    public String toString() {
        return name + "(" + weight + ")";
    }
}

class Dog extends Animal {
    Dog(String name, double weight) {
        super(name, weight);
    }

    public String getVoice() {
        return "Bow-Wow";
    }

    public String toString() {
        return "Dog " + super.toString();
    }
}

class Cat extends Animal {
    Cat(String name, double weight) {
        super(name, weight);
    }

    public String getVoice() {
        return "Miaou-Miaou";
    }

    public String toString() {
        return "Cat " + super.toString();
    }
}

public class Task06 {
    public static void main(String[] args) {

        Animal[] animals = {new Animal("Animal X", 100),
                new Dog("Max", 15), new Cat("Batty", 3.5),
                new Dog("Ajax", 5), new Cat("Minnie", 4)
        };
        Animal.voices(animals);

    }
}
