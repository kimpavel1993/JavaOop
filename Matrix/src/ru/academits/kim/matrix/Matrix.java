package ru.academits.kim.matrix;

import ru.academits.kim.vector.Vector;

public class Matrix {
    private Vector[] arrayVectors;

    public Matrix(int n, int m) {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("Неверные входные данные. Необходимо, чтобы размерность столбцов и строк была > 0. Размерность строк: " + n + "Размерность столбцов: " + m);
        }

        arrayVectors = new Vector[n];

        for (int i = 0; i < n; i++) {
            arrayVectors[i] = new Vector(m);
        }
    }

    public Matrix(Matrix clone) {
        arrayVectors = new Vector[clone.arrayVectors.length];

        for (int i = 0; i < clone.arrayVectors.length; i++) {
            arrayVectors[i] = new Vector(clone.arrayVectors[i]);
        }
    }

    public Matrix(double[][] array) {
        arrayVectors = new Vector[array.length];

        int maxLength = 0;

        for (double[] e : array) {
            if (e.length > maxLength) {
                maxLength = e.length;
            }
        }

        for (int i = 0; i < array.length; i++) {
            arrayVectors[i] = new Vector(maxLength, array[i]);
        }
    }

    private double[] getArray(Vector vector) {
        double[] array = new double[vector.getSize()];

        for (int i = 0; i < vector.getSize(); i++) {
            array[i] = vector.getComponentByIndex(i);
        }

        return array;
    }

    public Matrix(Vector[] vectors) {
        arrayVectors = new Vector[vectors.length];

        int maxLength = 0;

        for (Vector e : vectors) {
            if (getArray(e).length > maxLength) {
                maxLength = getArray(e).length;
            }
        }

        for (int i = 0; i < vectors.length; i++) {
            arrayVectors[i] = new Vector(maxLength, getArray(vectors[i]));
        }
    }

    public int getLinesNumber() {
        return arrayVectors.length;
    }

    public int getColumnsNumber() {
        return arrayVectors[0].getSize();
    }

    public Vector getLineByIndex(int index) {
        if (index < 0 || index >= getLinesNumber()) {
            throw new IndexOutOfBoundsException("Индекс не должен быть меньше 0, а так же равен или больше значения, равному " + arrayVectors.length + ". Текущее значение индекса:  " + index);
        }

        return new Vector(arrayVectors[index]);
    }

    private void checkVectorSize(Vector vector) {
        if (vector.getSize() != getColumnsNumber()) {
            throw new IllegalArgumentException("У вставляемого вектора некорректная длина. Текущая длина: " + vector.getSize() + "; Необходимая длина: " + getColumnsNumber());
        }
    }

    public void setLineByIndex(int index, Vector vector) {
        if (index < 0 || index >= arrayVectors.length) {
            throw new IndexOutOfBoundsException("Индекс не должен быть меньше 0, а так же равен или больше значения, равному " + arrayVectors.length + ". Текущее значение индекса:  " + index);
        }

        checkVectorSize(vector);

        arrayVectors[index] = new Vector(vector);
    }

    public Vector getColumnByIndex(int index) {
        if (index < 0 || index >= getColumnsNumber()) {
            throw new IndexOutOfBoundsException("Индекс не должен быть меньше 0, а так же равен или больше значения, равному " + arrayVectors.length + ". Текущее значение индекса:  " + index);
        }

        Vector vector = new Vector(getLinesNumber());

        for (int i = 0; i < getLinesNumber(); i++) {
            vector.setComponentByIndex(i, arrayVectors[i].getComponentByIndex(index));
        }

        return vector;
    }

    public void transpose() {
        Vector[] newColumns = new Vector[getColumnsNumber()];

        for (int i = 0; i < getColumnsNumber(); i++) {
            newColumns[i] = this.getColumnByIndex(i);
        }

        arrayVectors = newColumns;
    }

    public void multiplyByScalar(double scalar) {
        for (Vector e : arrayVectors) {
            e.multiplyByScalar(scalar);
        }
    }

    private void checkMatrixSize(Matrix matrix) {
        if (matrix.getColumnsNumber() != getColumnsNumber() || matrix.getLinesNumber() != getLinesNumber()) {
            throw new IllegalArgumentException("Некорректные размеры матриц. У первой матрицы размерность строк: " + getLinesNumber() + ", столбцов: " + getColumnsNumber() + ". У второй матрицы размерность строк: " + matrix.getLinesNumber() + ", столбцов: " + matrix.getColumnsNumber());
        }
    }

    public Matrix add(Matrix matrix) {
        checkMatrixSize(matrix);

        for (int i = 0; i < getLinesNumber(); i++) {
            arrayVectors[i].add(matrix.arrayVectors[i]);
        }

        return this;
    }

    public Matrix subtract(Matrix matrix) {
        checkMatrixSize(matrix);

        for (int i = 0; i < getLinesNumber(); i++) {
            arrayVectors[i].subtract(matrix.arrayVectors[i]);
        }

        return this;
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        Matrix matrix = new Matrix(matrix1);

        return matrix.add(matrix2);
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        Matrix matrix = new Matrix(matrix1);

        return matrix.subtract(matrix2);
    }

  /*  public static Matrix getMultiply(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsNumber() != matrix2.getLinesNumber()) {
            throw new IllegalArgumentException("Размерность столбцов матрицы должна совпадать с размерность строк другой матрицы. У первой матрицы размерность столбцов: " + matrix1.getColumnsNumber() + ", размерность строк второй матрицы: " + matrix2.getLinesNumber());
        }
    }*/


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");

        for (Vector e : arrayVectors) {
            stringBuilder.append(e).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}