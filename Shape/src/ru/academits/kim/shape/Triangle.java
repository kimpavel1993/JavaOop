package ru.academits.kim.shape;

public class Triangle implements Shape {
    private double x1;
    private double x2;
    private double x3;
    private double y1;
    private double y2;
    private double y3;

    public Triangle(double x1, double x2, double x3, double y1, double y2, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.max(x1, x2), x3);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.max(y1, y2), y3);
    }

    @Override
    public double getArea() {
        return 0.5 * getWidth() * getHeight();
    }

    @Override
    public double getPerimeter() {
        double sideLength1 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double sideLength2 = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
        double sideLength3 = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));

        return sideLength1 + sideLength2 + sideLength3;
    }

    @Override
    public String toString() {
        return "[Ширина треугольника: " + getWidth() + ", Высота треугольника: " + getHeight() + ", Площадь треугольника: " + getArea() + ", Периметр треугольника: " + getPerimeter() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return false;
        }

        if (o == null || o.getClass() != this.getClass()) {
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