import java.util.Arrays;
import java.util.Locale;

abstract class Figure implements Comparable<Figure> {
    abstract public double getArea();

    abstract public double getPerimeter();

    static public Figure getFigMaxArea(Figure[] figs) {
        double maxarea = 0;
        Figure maxfig = null;
        for (Figure f : figs) {
            double area = f.getArea();
            if (area > maxarea) {
                maxarea = area;
                maxfig = f;
            }
        }
        return maxfig;
    }

    public String toString() {
        return " area: " + String.format("%6.3f", getArea())
                + "; perimeter: " + String.format("%6.3f", getPerimeter());
    }

    public int compareTo(Figure f) {
        double diff = getPerimeter() - f.getPerimeter();
        if (diff < 0)
            return -1;
        else if (diff > 0)
            return +1;
        else
            return 0;
    }
}

class Circle extends Figure {

    private double r;

    public Circle(double r) {
        this.r = r;
    }

    public double getArea() {
        return Math.PI * r * r;
    }

    public double getPerimeter() {
        return 2 * Math.PI * r;
    }

    public String toString() {
        return "Circle    (   r = " + r + "    )" + super.toString();
    }
}

class Rectangle extends Figure {

    private double a, b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getArea() {
        return a * b;
    }

    public double getPerimeter() {
        return 2 * (a + b);
    }

    public String toString() {
        return "Rectangle (a=" + a + " b=" + b + "   )" + super.toString();
    }
}

public class Task07 {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Figure[] figs = {
                new Circle(2), new Rectangle(9, 1),
                new Rectangle(4, 3), new Circle(4)
        };
        Figure fig = Figure.getFigMaxArea(figs);
        System.out.println("\nLargest area: \n" + fig);

        Arrays.sort(figs);
        System.out.println("\nSorted by circumference");
        for (Figure f : figs)
            System.out.println(f);

    }
}
