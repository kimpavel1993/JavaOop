package ru.academits.kim.shape_main;

import ru.academits.kim.shape.*;

import java.util.Arrays;

public class Main {
    public static void findShape(Shape[] shapes) {
        AreaComparator areaComparator = new AreaComparator();
        Arrays.sort(shapes, areaComparator);

        System.out.println("Фигура с максимальной площадью: " + shapes[4]);

        PerimeterComparator perimeterComparator = new PerimeterComparator();
        Arrays.sort(shapes, perimeterComparator);

        System.out.println("Фигура со вторым по величине периметром: " + shapes[3]);
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];

        Shape shape1 = new Square(3);
        Shape shape2 = new Square(3);
        Shape shape3 = new Triangle(1, 2, 3, 4, 5, 6);
        Shape shape4 = new Rectangle(4, 5);
        Shape shape5 = new Circle(5);

        shapes[0] = shape1;
        shapes[1] = shape2;
        shapes[2] = shape3;
        shapes[3] = shape4;
        shapes[4] = shape5;

        findShape(shapes);
    }
}