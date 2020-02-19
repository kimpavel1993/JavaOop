package ru.academits.kim.range_main;

import ru.academits.kim.range.Range;

public class    Main {
    public static void main(String[] args) {
        Range range = new Range(1, 3);
        range.print();

        System.out.println("Попадание в числовой диапазон: " + range.isInside(2));
        System.out.println("Длина диапазона: " + range.getLength());
    }
}
