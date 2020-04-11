package ru.academits.kim.shape;

public class Rectangle implements Shape {
    private double sideLength1;
    private double sideLength2;

    public Rectangle(double sideLength1, double sideLength2) {
        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
    }

    @Override
    public double getWidth() {
        return sideLength1;
    }

    @Override
    public double getHeight() {
        return sideLength2;
    }

    @Override
    public double getArea() {
        return sideLength1 * sideLength2;
    }

    @Override
    public double getPerimeter() {
        return (sideLength1 + sideLength2) * 2;
    }

    @Override
    public String toString() {
        return "Прямоугольник: [Ширина: " + getWidth() + ", Высота: " + getHeight() +
                ", Площадь: " + getArea() + ", Периметр: " + getPerimeter() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return false;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Rectangle p = (Rectangle) o;

        return sideLength1 == p.sideLength1 && sideLength2 == p.sideLength2;
    }

    @Override
    public int hashCode() {
        int prime = 17;
        int hash = 1;

        hash = hash * prime + Double.hashCode(sideLength1);
        hash = hash * prime + Double.hashCode(sideLength2);

        return hash;
    }
}