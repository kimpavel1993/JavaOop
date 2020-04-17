package ru.academits.kim.shape;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
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

        return width == p.width && height == p.height;
    }

    @Override
    public int hashCode() {
        int prime = 17;
        int hash = 1;

        hash = hash * prime + Double.hashCode(width);
        hash = hash * prime + Double.hashCode(height);

        return hash;
    }
}