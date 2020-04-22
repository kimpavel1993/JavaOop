package ru.academits.kim.shape;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return radius * 2;
    }

    @Override
    public double getHeight() {
        return radius * 2;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Окружность: [Радиус: " + radius + ", Ширина: " + getWidth() + ", Высота: " + getHeight() +
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

        Circle p = (Circle) o;

        return radius == p.radius;
    }

    @Override
    public int hashCode() {
        int prime = 17;
        int hash = 1;

        hash = hash * prime + Double.hashCode(radius);

        return hash;
    }
}