package ru.academits.kim.matrix;

import ru.academits.kim.vector.Vector;

public class Matrix {
    private Vector[] rows;

    public Matrix(int rowsQuantity, int columnsQuantity) {
        if (rowsQuantity <= 0 || columnsQuantity <= 0) {
            throw new IllegalArgumentException("Неверные входные данные. Необходимо, чтобы количество столбцов и строк была > 0. Количество строк: "
                    + rowsQuantity + "Количество столбцов: " + columnsQuantity);
        }

        rows = new Vector[rowsQuantity];

        for (int i = 0; i < rowsQuantity; i++) {
            rows[i] = new Vector(columnsQuantity);
        }
    }

    public Matrix(Matrix matrix) {
        rows = new Vector[matrix.rows.length];

        for (int i = 0; i < matrix.rows.length; i++) {
            rows[i] = new Vector(matrix.rows[i]);
        }
    }

    public Matrix(double[][] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Неверные входные данные. Необходимо, чтобы размерность матрицы была > 0");
        }

        rows = new Vector[array.length];

        int maxLength = 0;

        for (double[] e : array) {
            if (e.length > maxLength) {
                maxLength = e.length;
            }
        }

        for (int i = 0; i < array.length; i++) {
            rows[i] = new Vector(maxLength, array[i]);
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
        if (vectors.length == 0) {
            throw new IllegalArgumentException("Неверные входные данные. Необходимо, чтобы размерность матрицы была > 0");
        }

        rows = new Vector[vectors.length];

        int maxLength = 0;

        for (Vector e : vectors) {
            if (getArray(e).length > maxLength) {
                maxLength = getArray(e).length;
            }
        }

        for (int i = 0; i < vectors.length; i++) {
            rows[i] = new Vector(maxLength, getArray(vectors[i]));
        }
    }

    public int getRowsQuantity() {
        return rows.length;
    }

    public int getColumnsQuantity() {
        return rows[0].getSize();
    }

    private void checkRowNumber(int index) {
        if (index < 0 || index >= getRowsQuantity()) {
            throw new IndexOutOfBoundsException("Индекс не должен быть меньше 0, а так же равен или больше значения, равному "
                    + getRowsQuantity() + ". Текущее значение индекса:  " + index);
        }
    }

    public Vector getRowByIndex(int index) {
        checkRowNumber(index);

        return new Vector(rows[index]);
    }

    public void setRowByIndex(int index, Vector vector) {
        checkRowNumber(index);

        if (vector.getSize() != getColumnsQuantity()) {
            throw new IllegalArgumentException("У вставляемого вектора некорректная длина. Текущая длина: "
                    + vector.getSize() + "; Необходимая длина: " + getColumnsQuantity());
        }

        rows[index] = new Vector(vector);
    }

    public Vector getColumnByIndex(int index) {
        if (index < 0 || index >= getColumnsQuantity()) {
            throw new IndexOutOfBoundsException("Индекс не должен быть меньше 0, а так же равен или больше значения, равному "
                    + getColumnsQuantity() + ". Текущее значение индекса:  " + index);
        }

        Vector vector = new Vector(getRowsQuantity());

        for (int i = 0; i < getRowsQuantity(); i++) {
            vector.setComponentByIndex(i, rows[i].getComponentByIndex(index));
        }

        return vector;
    }

    public void transpose() {
        Vector[] newRows = new Vector[getColumnsQuantity()];

        for (int i = 0; i < getColumnsQuantity(); i++) {
            newRows[i] = getColumnByIndex(i);
        }

        rows = newRows;
    }

    public void multiplyByScalar(double scalar) {
        for (Vector e : rows) {
            e.multiplyByScalar(scalar);
        }
    }

    public Vector multiplyByVector(Vector vector) {
        if (getColumnsQuantity() != vector.getSize()) {
            throw new IllegalArgumentException("Количество столбцов матрицы должно совпадать с размерностью вектора. " +
                    "Количество столбцов матрицы: " + getColumnsQuantity() + ", размерность вектора: " + vector.getSize());
        }

        Vector result = new Vector(getRowsQuantity());

        for (int i = 0; i < getRowsQuantity(); i++) {
            result.setComponentByIndex(i, Vector.getScalarProduct(rows[i], vector));
        }

        return result;
    }

    private void checkMatrixSize1(Matrix matrix) {
        if (matrix.getColumnsQuantity() != getColumnsQuantity() || matrix.getRowsQuantity() != getRowsQuantity()) {
            throw new IllegalArgumentException("Некорректные размеры матриц. У первой матрицы количество строк: "
                    + getRowsQuantity() + ", столбцов: " + getColumnsQuantity() + ". " +
                    "У второй матрицы количествор строк: " + matrix.getRowsQuantity() + ", столбцов: " + matrix.getColumnsQuantity());
        }
    }

    public Matrix add(Matrix matrix) {
        checkMatrixSize1(matrix);

        for (int i = 0; i < getRowsQuantity(); i++) {
            rows[i].add(matrix.rows[i]);
        }

        return this;
    }

    public Matrix subtract(Matrix matrix) {
        checkMatrixSize1(matrix);

        for (int i = 0; i < getRowsQuantity(); i++) {
            rows[i].subtract(matrix.rows[i]);
        }

        return this;
    }

    private static void checkMatrixSize2(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsQuantity() != matrix2.getColumnsQuantity() || matrix1.getRowsQuantity() != matrix2.getRowsQuantity()) {
            throw new IllegalArgumentException("Некорректные размеры матриц. У первой матрицы количество строк: "
                    + matrix1.getRowsQuantity() + ", столбцов: " + matrix1.getColumnsQuantity() + ". " +
                    "У второй матрицы количествор строк: " + matrix2.getRowsQuantity() + ", столбцов: " + matrix2.getColumnsQuantity());
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        checkMatrixSize2(matrix1, matrix2);

        Matrix matrix = new Matrix(matrix1);

        return matrix.add(matrix2);
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        checkMatrixSize2(matrix1, matrix2);

        Matrix matrix = new Matrix(matrix1);

        return matrix.subtract(matrix2);
    }

    public static Matrix getProduct(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsQuantity() != matrix2.getRowsQuantity()) {
            throw new IllegalArgumentException("Количество столбцов матрицы должна совпадать с количеством строк другой матрицы. " +
                    "У первой матрицы количество столбцов: " + matrix1.getColumnsQuantity() +
                    ", количество строк второй матрицы: " + matrix2.getRowsQuantity());
        }

        Matrix result = new Matrix(matrix1.getRowsQuantity(), matrix2.getColumnsQuantity());

        for (int i = 0; i < matrix1.getRowsQuantity(); i++) {
            for (int j = 0; j < matrix2.getColumnsQuantity(); j++) {
                result.rows[i].setComponentByIndex(j, Vector.getScalarProduct(matrix1.rows[i], matrix2.getColumnByIndex(j)));
            }
        }

        return result;
    }

    private int getIndexMaxValue(int index) {
        Vector column = getColumnByIndex(index);

        double maxValue = 0;
        int maxIndex = index;

        for (int i = index; i < getRowsQuantity(); ++i) {
            if (Math.abs(column.getComponentByIndex(i)) > maxValue) {
                maxValue = Math.abs(column.getComponentByIndex(i));
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public double calculateDeterminant() {
        if (getRowsQuantity() != getColumnsQuantity()) {
            throw new ArithmeticException("Определителя не существует. Размерность строк и столбцов не совпадает. " +
                    "Текущее значение строк: " + getRowsQuantity() + ", значение столбцов: " + getColumnsQuantity());
        }

        if (getRowsQuantity() == 1) {
            return rows[0].getComponentByIndex(0);
        }

        int numberPermutationsRows = 0;

        for (int i = 0; i < getRowsQuantity() - 1; i++) {
            for (int j = i + 1; j < getColumnsQuantity(); j++) {
                if (getIndexMaxValue(i) != i) {
                    Vector vector = rows[i];
                    rows[i] = rows[j];
                    rows[j] = vector;

                    numberPermutationsRows++;
                }

                double number = rows[j].getComponentByIndex(i) / rows[i].getComponentByIndex(i);

                for (int k = i; k < getColumnsQuantity(); k++) {
                    rows[j].setComponentByIndex(k, rows[j].getComponentByIndex(k) -
                            rows[i].getComponentByIndex(k) * number);
                }
            }
        }

        double determinant = 1;

        for (int i = 0; i < getColumnsQuantity(); ++i) {
            determinant *= Math.pow(-1, numberPermutationsRows) * rows[i].getComponentByIndex(i);
        }

        return determinant;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");

        for (Vector e : rows) {
            stringBuilder.append(e).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}