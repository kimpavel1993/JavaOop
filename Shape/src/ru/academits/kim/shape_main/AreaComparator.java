package ru.academits.kim.shape_main;

import ru.academits.kim.shape.Shape;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {
    public int compare(Shape area1, Shape area2) {
        return Double.compare(area1.getArea(), area2.getArea());
    }
}
