package ru.academits.kim.shape;

public class Square implements Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return Math.pow(sideLength, 2);
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLength;
    }

    @Override
    public String toString() {
        return "Квадрат: [Ширина: " + getWidth() + ", Высота: " + getHeight() +
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

        Square p = (Square) o;

        return sideLength == p.sideLength;
    }

    @Override
    public int hashCode() {
        int prime = 17;
        int hash = 1;

        hash = hash * prime + Double.hashCode(sideLength);

        return hash;
    }
}