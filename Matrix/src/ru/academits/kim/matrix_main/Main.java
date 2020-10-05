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

        double[] componentsVector1 = {1, 2, 3, 4, 5};

        Vector vector1 = new Vector(componentsVector1);
        Vector vector2 = new Vector(8, componentsVector1);
        Vector vector3 = new Vector(3);

        Vector[] arrayVectors = {vector1, vector2, vector3};

        Matrix matrix4 = new Matrix(arrayVectors);

        System.out.println(matrix4);
        System.out.println("Количество строк в матрице: " + matrix4.getRowsQuantity());
        System.out.println("Количество столбцов в матрице: " + matrix4.getColumnsQuantity());
        System.out.println("Получение вектора-строки по индексу: " + matrix3.getRowByIndex(1));

        matrix2.setRowByIndex(2, vector1);
        System.out.println("Матрица с заданным вектором-строкой по индексу: " + matrix2);
        System.out.println("Получение вектора-столбца по индексу: " + matrix2.getColumnByIndex(1));
        System.out.println("Матрица до транспонирования: " + matrix2);

        matrix2.transpose();
        System.out.println("Транспонирование матрицы: " + matrix2);

        matrix2.multiplyByScalar(2);
        System.out.println("Умножение матрицы на скаляр: " + matrix2);

        double[] componentsVector2 = {4, 5, 6};

        Vector vector4 = new Vector(componentsVector2);

        double[][] array2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};

        Matrix matrix5 = new Matrix(array2);

        System.out.println("Умножение матрицы на вектор: " + matrix5.multiplyByVector(vector4));

        matrix2.add(matrix2);
        System.out.println("Сложение матриц: " + matrix2);

        matrix2.subtract(matrix5);
        System.out.println("Разность матриц: " + matrix2);

        double[][] array3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Matrix matrix6 = new Matrix(array3);

        System.out.println("Сложение матриц: " + Matrix.getSum(matrix6, matrix6));
        System.out.println("Разность матриц: " + Matrix.getDifference(matrix6, matrix6));
        System.out.println("Произведение матриц: " + Matrix.getProduct(matrix6, matrix6));

        double[][] array4 = {{2, 4, 1, 1}, {0, 2, 1, 0}, {2, 1, 1, 3}, {4, 0, 2, 3}};

        Matrix matrix7 = new Matrix(array4);

        System.out.println("Определитель матрицы: " + matrix7.getDeterminant());
    }
}