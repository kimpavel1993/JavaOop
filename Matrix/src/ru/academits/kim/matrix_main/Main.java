package ru.academits.kim.matrix_main;

import ru.academits.kim.matrix.Matrix;
import ru.academits.kim.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(3, 5);

        System.out.println(matrix1);

        double[][] array1 = {{1}, {4, 50}, {23, 4, 5, 6, 88}};

        Matrix matrix2 = new Matrix(array1);

        Matrix matrix3 = new Matrix(matrix2);

        double[] vector = {1, 2, 3, 4, 5};

        Vector vector1 = new Vector(vector);
        Vector vector2 = new Vector(8, vector);
        Vector vector3 = new Vector(3);

        Vector[] arrayVectors = {vector1, vector2, vector3};

        Matrix matrix4 = new Matrix(arrayVectors);

        System.out.println(matrix4);

        System.out.println("Количество строк в матрице: " + matrix4.getLinesNumber());
        System.out.println("Количество столбцов в матрице: " + matrix4.getColumnsNumber());
        System.out.println("Получение вектора-строки по индексу: " + matrix3.getLineByIndex(1));

        matrix2.setLineByIndex(2, vector1);
        System.out.println("Задание вектора-строки по индексу: " + matrix2);

        System.out.println("Получение вектора-столбца по индексу: " + matrix2.getColumnByIndex(1));
        System.out.println("Матрица до транспонирования: " + matrix2);

        matrix2.transpose();
        System.out.println("Транспонирование матрицы: " + matrix2);

        matrix2.multiplyByScalar(2);
        System.out.println("Умножение матрицы на скаляр: " + matrix2);

        matrix2.add(matrix2);
        System.out.println("Сложение матриц: " + matrix2);

        double[][] array2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};

        Matrix matrix5 = new Matrix(array2);

        matrix2.subtract(matrix5);
        System.out.println("Разность матриц: " + matrix2);

        System.out.println("Сложение матриц: " + Matrix.getSum(matrix2, matrix2));
        System.out.println("Разность матриц: " + Matrix.getDifference(matrix2, matrix5));
    }
}