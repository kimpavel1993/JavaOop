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
        System.out.println(Vector.getSum(vector3, vector4));

        System.out.println("Разность векторов:");

        System.out.println(vector1.getDifference(vector4));
        System.out.println(Vector.getDifference(vector3, vector2));

        System.out.println("Скалярное произведение векторов: " + Vector.getScalarProduct(vector3, vector4));
        System.out.println("Длина вектора: " + vector3.getSize());
        System.out.println("Умножение вектора на скаляр: " + vector4.getScalarMultiplication(3));
        System.out.println("Разворот вектора: " + vector4.getVectorSpread());
        System.out.println("Длина вектора: " + vector4.getVectorLength());
        System.out.println("Значение индекса: " + (vector4.getVectorIndex(3)));
        System.out.println("Новый массив с замененным индексом: " + (vector3.setVectorIndex(1, 10)));
    }
}