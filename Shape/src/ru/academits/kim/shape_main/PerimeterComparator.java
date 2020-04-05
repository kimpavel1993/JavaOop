package ru.academits.kim.shape_main;

import ru.academits.kim.shape.Shape;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Shape> {
    public int compare(Shape perimeter1, Shape perimeter2) {
        return Double.compare(perimeter1.getPerimeter(), perimeter2.getPerimeter());
    }
}