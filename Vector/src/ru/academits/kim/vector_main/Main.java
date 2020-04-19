package ru.academits.kim.vector_main;

import ru.academits.kim.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[] vector = {1, 2, 3, 4};

        Vector vector1 = new Vector(2);
        Vector vector2 = new Vector(vector1);
        Vector vector3 = new Vector(vector);
        Vector vector4 = new Vector(9, vector);

        System.out.println("Первый вектор: " + vector1);
        System.out.println("Второй вектор: " + vector2);
        System.out.println("Третий вектор: " + vector3);
        System.out.println("Четвертый вектор: " + vector4);

        System.out.println("Сумма векторов:");

        System.out.println(vector4.getSum(vector3));
        System.out.println(Vector.getSum(vector4, vector3));

        System.out.println("Разность векторов:");

        System.out.println(vector3.getDifference(vector2));
        System.out.println(Vector.getDifference(vector4, vector3));

        System.out.println("Скалярное произведение векторов: " + Vector.getScalarProduct(vector3, vector4));
        System.out.println("Длина вектора: " + vector3.getSize());
        System.out.println("Умножение вектора на скаляр: " + vector3.getMultiplyByScalar(3));
        System.out.println("Разворот вектора: " + vector3.getTurn());
        System.out.println("Длина вектора: " + vector4.getLength());
        System.out.println("Значение индекса: " + (vector4.getIndex(3)));

        vector1.setIndex(1, 10);

        System.out.println("Первый вектор с обновленным индексом: " + vector1);
    }
}