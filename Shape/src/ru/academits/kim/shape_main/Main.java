package ru.academits.kim.shape_main;

import ru.academits.kim.shape.*;

import java.util.Arrays;

public class Main {
    private static void findMaxArea(Shape[] shapes) {
        AreaComparator areaComparator = new AreaComparator();
        Arrays.sort(shapes, areaComparator);

        System.out.println("Фигура с максимальной площадью - " + shapes[shapes.length - 1]);
    }

    private static void findSecondMaxPerimeter(Shape[] shapes) {
        PerimeterComparator perimeterComparator = new PerimeterComparator();
        Arrays.sort(shapes, perimeterComparator);

        System.out.println("Фигура со вторым по величине периметром - " + shapes[shapes.length - 2]);
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];

        shapes[0] = new Square(3);
        shapes[1] = new Square(3);
        shapes[2] = new Triangle(8, 2, 3, 4, 5, 6);
        shapes[3] = new Rectangle(4, 5);
        shapes[4] = new Circle(5);

        findMaxArea(shapes);
        findSecondMaxPerimeter(shapes);
    }
}