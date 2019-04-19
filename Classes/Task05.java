import java.awt.*;

class Point {
    protected int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x) {
        this(x, 0);
    }

    public Point() {
        this(0, 0);
    }

    public Point translate(int dx, int dy) {
        x += dx;
        y += dy;
        return this;
    }

    public Point scale(int sx, int sy) {
        x *= sx;
        y *= sy;
        return this;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "[" + x + "," + y + "]";
    }
}

class Pixel extends Point {
    private Color color;

    public Pixel(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    public Pixel(int x, int y) {
        this(x, y, Color.BLACK);
    }

    public Pixel(Color color) {
        this(0, 0, color);
    }

    public Pixel() {
        this(0, 0, Color.BLACK);
    }

    public Color getColor() {
        return color;
    }

    public String toString() {
        return super.toString() + "(r=" + color.getRed() +
                ",g=" + color.getGreen() + ",b=" +
                color.getBlue() + ")";
    }
}

public class Task05 {
    public static void main(String[] args) {

        Point pp = new Point(2, 1);
        Point pt = new Pixel(1, 2);
        Pixel px = new Pixel(new Color(255, 51, 102));
        System.out.println("is 'pp' a Point? " +
                (pp instanceof Point));
        System.out.println("is 'pp' a Pixel? " +
                (pp instanceof Pixel));
        System.out.println("is 'pt' a Point? " +
                (pt instanceof Point));
        System.out.println("is 'pt' a Pixel? " +
                (pt instanceof Pixel));
        System.out.println("is 'px' a Point? " +
                (px instanceof Point));
        System.out.println("is 'px' Pixel? " +
                (px instanceof Pixel));
        System.out.println("class of pp: " +
                pp.getClass().getName());
        System.out.println("class of pt: " +
                pt.getClass().getName());
        System.out.println("class of px: " +
                px.getClass().getName());

        px.translate(5, 4).scale(2, 3).translate(-1, -3);
        System.out.println("pp: " + pp);
        System.out.println("pt: " + pt);
        System.out.println("px: " + px);
        System.out.println("Color px : " + px.getColor());
        System.out.println("Color pt : " + ((Pixel) pt).getColor());
        
    }
}
