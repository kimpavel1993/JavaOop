package ru.academits.kim.range_main;

import ru.academits.kim.range.Range;

import java.util.Arrays;

public class Main {
    public static void printArray(Range[] array) {
        for (Range range : array) {
            System.out.println(range);
        }
    }

    public static void main(String[] args) {
        Range range1 = new Range(1, 10);
        Range range2 = new Range(4, 5);

        System.out.println("Первый диапазон: " + range1);
        System.out.println("Второй диапазон: " + range2);

        Range intersection = range1.getIntersection(range2);

        if (intersection != null) {
            System.out.println("Пересечение: " + intersection);
        } else {
            System.out.println("Пересечение: null");
        }

        System.out.println("Объединение:");

        Range[] union = range1.getUnion(range2);
        printArray(union);

        System.out.println("Разность:");

        Range[] difference = range1.getDifference(range2);
        if (difference.length == 0) {
            System.out.println("[]");
        } else {
            printArray(difference);
        }

        System.out.println("Попадание в числовой диапазон: " + range1.isInside(2));
        System.out.println("Длина диапазона: " + range1.getLength());

        range1.setFrom(3);
        System.out.println("Первое число нового диапазона: " + range1.getFrom());

        range1.setTo(7);
        System.out.println("Последнее число нового диапазона: " + range1.getTo());

        System.out.println("Новый диапазон:" + range1);
        System.out.println("Попадание в новый числовой диапазон: " + range1.isInside(6));
        System.out.println("Длина нового диапазона: " + range1.getLength());
    }
}