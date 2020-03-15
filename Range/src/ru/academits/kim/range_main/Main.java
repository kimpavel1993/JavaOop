package ru.academits.kim.range_main;

import ru.academits.kim.range.Range;

public class Main {
    public static void main(String[] args) {
        Range firstRange = new Range(4, 5);
        Range secondRange = new Range(3, 7);

        firstRange.print();
        secondRange.print();

        System.out.println("Пересечение:");

        Range intersection = Range.getIntersection(firstRange, secondRange);
        if (intersection != null) {
            intersection.print();
        } else {
            System.out.println("null");
        }

        System.out.println("Объединение:");

        Object union = Range.getUnion(firstRange, secondRange);
        if (union instanceof Range) {
            Range unionRange = (Range) union;
            unionRange.print();
        } else if (union instanceof Range[]) {
            Range[] unionArrayRange = (Range[]) union;

            for (int i = 0; i < unionArrayRange.length; i++) {
                unionArrayRange[i].print();
            }
        } else {
            System.out.println("null");
        }

        System.out.println("Разность:");

        Object difference = Range.getDifference(firstRange, secondRange);
        if (difference instanceof Range) {
            Range differenceRange = (Range) difference;
            differenceRange.print();
        } else if (difference instanceof Range[]) {
            Range[] differenceArrayRange = (Range[]) difference;

            for (int i = 0; i < differenceArrayRange.length; i++) {
                differenceArrayRange[i].print();
            }
        } else {
            System.out.println("null");
        }

        System.out.println("Попадание в числовой диапазон: " + firstRange.isInside(2));
        System.out.println("Длина диапазона: " + firstRange.getLength());

        firstRange.setFrom(3);
        System.out.println("Первое число нового диапазона: " + firstRange.getFrom());

        firstRange.setTo(7);
        System.out.println("Последнее число нового диапазона: " + firstRange.getTo());

        System.out.printf("Новый диапазон: (%s, %s)%n", firstRange.getFrom(), firstRange.getTo());
        System.out.println("Попадание в новый числовой диапазон: " + firstRange.isInside(6));
        System.out.println("Длина нового диапазона: " + firstRange.getLength());
    }
}