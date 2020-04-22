package ru.academits.kim.shape;

public class Triangle implements Shape {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    private static double getSideLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    @Override
    public double getPerimeter() {
        return getSideLength(x1, y1, x2, y2) + getSideLength(x2, y2, x3, y3) + getSideLength(x3, y3, x1, y1);
    }

    @Override
    public double getArea() {
        return 0.5 * Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1));
    }

    @Override
    public String toString() {
        return "Треугольник: [Координаты вершин: [(" + x1 + ", " + y1 + "); " + "(" + x2 + ", " + y2 + "); " + "(" + x3 + ", " + y3 + ")]" +
                ", Ширина: " + getWidth() + ", Высота: " + getHeight() +
                ", Площадь: " + getArea() + ", Периметр: " + getPerimeter() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return false;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Triangle p = (Triangle) o;

        return x1 == p.x1 && x2 == p.x2 && x3 == p.x3 && y1 == p.y1 && y2 == p.y2 && y3 == p.y3;
    }

    @Override
    public int hashCode() {
        int prime = 17;
        int hash = 1;

        hash = hash * prime + Double.hashCode(x1);
        hash = hash * prime + Double.hashCode(x2);
        hash = hash * prime + Double.hashCode(x3);
        hash = hash * prime + Double.hashCode(y1);
        hash = hash * prime + Double.hashCode(y2);
        hash = hash * prime + Double.hashCode(y3);

        return hash;
    }
}