package ru.academits.kim.range_main;

import ru.academits.kim.range.Range;

import java.util.Arrays;

public class Main {
    public static void getArray(Range[] array) {
        if (array != null) {
            for (Range range : array) {
                System.out.println(range.toString());
            }
        } else {
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Range firstRange = new Range(5, 1);
        Range secondRange = new Range(6, 4);

        System.out.println("Первый диапазон: " + firstRange.toString());
        System.out.println("Второй диапазон: " + secondRange.toString());

        Range intersection = firstRange.getIntersection(secondRange);

        if (intersection != null) {
            System.out.println("Пересечение: " + intersection.toString());
        } else {
            System.out.println("Пересечение: null");
        }

        System.out.println("Объединение:");

        Range[] union = firstRange.getUnion(secondRange);
        getArray(union);

        System.out.println("Разность:");

        Range[] difference = firstRange.getDifference(secondRange);
        if (Arrays.equals(firstRange.getDifference(secondRange), secondRange.getDifference(firstRange))) {
            System.out.println("Диапазон равен 0");
        } else {
            getArray(difference);
        }

        System.out.println("Попадание в числовой диапазон: " + firstRange.isInside(2));
        System.out.println("Длина диапазона: " + firstRange.getLength());

        firstRange.setFrom(3);
        System.out.println("Первое число нового диапазона: " + firstRange.getFrom());

        firstRange.setTo(7);
        System.out.println("Последнее число нового диапазона: " + firstRange.getTo());

        System.out.println("Новый диапазон:" + firstRange.toString());
        System.out.println("Попадание в новый числовой диапазон: " + firstRange.isInside(6));
        System.out.println("Длина нового диапазона: " + firstRange.getLength());
    }
}