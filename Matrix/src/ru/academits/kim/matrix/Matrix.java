package ru.academits.kim.matrix;

import ru.academits.kim.vector.Vector;

public class Matrix {
    private Vector[] arrayVectors;

    public Matrix(int n, int m) {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("Неверные входные данные. Необходимо, чтобы размерность столбцов и строк была > 0. Размерность строк: "
                    + n + "Размерность столбцов: " + m);
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

    public int getNumberRows() {
        return arrayVectors.length;
    }

    public int getNumberColumns() {
        return arrayVectors[0].getSize();
    }

    public Vector getLineByIndex(int index) {
        if (index < 0 || index >= getNumberRows()) {
            throw new IndexOutOfBoundsException("Индекс не должен быть меньше 0, а так же равен или больше значения, равному "
                    + arrayVectors.length + ". Текущее значение индекса:  " + index);
        }

        return new Vector(arrayVectors[index]);
    }

    private void checkVectorSize(Vector vector) {
        if (vector.getSize() != getNumberColumns()) {
            throw new IllegalArgumentException("У вставляемого вектора некорректная длина. Текущая длина: "
                    + vector.getSize() + "; Необходимая длина: " + getNumberColumns());
        }
    }

    public void setRowByIndex(int index, Vector vector) {
        if (index < 0 || index >= arrayVectors.length) {
            throw new IndexOutOfBoundsException("Индекс не должен быть меньше 0, а так же равен или больше значения, равному "
                    + arrayVectors.length + ". Текущее значение индекса:  " + index);
        }

        checkVectorSize(vector);

        arrayVectors[index] = new Vector(vector);
    }

    public Vector getColumnByIndex(int index) {
        if (index < 0 || index >= getNumberColumns()) {
            throw new IndexOutOfBoundsException("Индекс не должен быть меньше 0, а так же равен или больше значения, равному "
                    + arrayVectors.length + ". Текущее значение индекса:  " + index);
        }

        Vector vector = new Vector(getNumberRows());

        for (int i = 0; i < getNumberRows(); i++) {
            vector.setComponentByIndex(i, arrayVectors[i].getComponentByIndex(index));
        }

        return vector;
    }

    public void transpose() {
        Vector[] newColumns = new Vector[getNumberColumns()];

        for (int i = 0; i < getNumberColumns(); i++) {
            newColumns[i] = this.getColumnByIndex(i);
        }

        arrayVectors = newColumns;
    }

    public void multiplyByScalar(double scalar) {
        for (Vector e : arrayVectors) {
            e.multiplyByScalar(scalar);
        }
    }

    public Vector multiplyByVector(Vector vector) {
        if (getNumberColumns() != vector.getSize()) {
            throw new IllegalArgumentException("Количество столбцов матрицы должно совпадать с размерностью вектора. " +
                    "Количество столбцов матрицы: " + getNumberColumns() + ", размерность вектора: " + vector.getSize());
        }

        Vector result = new Vector(getNumberRows());

        for (int i = 0; i < getNumberRows(); i++) {
            result.setComponentByIndex(i, Vector.getScalarProduct(arrayVectors[i], vector));
        }

        return result;
    }

    private void checkMatrixSize(Matrix matrix) {
        if (matrix.getNumberColumns() != getNumberColumns() || matrix.getNumberRows() != getNumberRows()) {
            throw new IllegalArgumentException("Некорректные размеры матриц. У первой матрицы размерность строк: "
                    + getNumberRows() + ", столбцов: " + getNumberColumns() + ". " +
                    "У второй матрицы размерность строк: " + matrix.getNumberRows() + ", столбцов: " + matrix.getNumberColumns());
        }
    }

    public Matrix add(Matrix matrix) {
        checkMatrixSize(matrix);

        for (int i = 0; i < getNumberRows(); i++) {
            arrayVectors[i].add(matrix.arrayVectors[i]);
        }

        return this;
    }

    public Matrix subtract(Matrix matrix) {
        checkMatrixSize(matrix);

        for (int i = 0; i < getNumberRows(); i++) {
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

    public static Matrix getMultiply(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getNumberColumns() != matrix2.getNumberRows()) {
            throw new IllegalArgumentException("Размерность столбцов матрицы должна совпадать с размерность строк другой матрицы. " +
                    "У первой матрицы размерность столбцов: " + matrix1.getNumberColumns() +
                    ", размерность строк второй матрицы: " + matrix2.getNumberRows());
        }

        Matrix result = new Matrix(matrix1.getNumberRows(), matrix2.getNumberColumns());

        for (int i = 0; i < matrix1.getNumberRows(); i++) {
            for (int j = 0; j < matrix2.getNumberColumns(); j++) {

                result.arrayVectors[i].setComponentByIndex(j, Vector.getScalarProduct(matrix1.getLineByIndex(i), matrix2.getColumnByIndex(j)));
            }
        }

        return result;
    }

    private int getIndexMaxValue(int index) {
        Vector column = getColumnByIndex(index);

        double maxValue = 0;
        int maxIndex = index;

        for (int i = index; i < getNumberRows(); ++i) {
            if (Math.abs(column.getComponentByIndex(i)) > maxValue) {
                maxValue = Math.abs(column.getComponentByIndex(i));
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public double calculateDeterminant() {
        if (getNumberRows() == 0) {
            return 0;
        }

        if (getNumberRows() != getNumberColumns()) {
            throw new IllegalArgumentException("Определителя не существует. Размерность строк и столбцов не совпадает. " +
                    "Текущее значение строк: " + getNumberRows() + ", значение столбцов: " + getNumberColumns());
        }

        if (getNumberRows() == 1) {
            return arrayVectors[0].getComponentByIndex(0);
        }

        int numberPermutationsRows = 0;

        for (int i = 0; i < getNumberRows() - 1; i++) {
            for (int j = i + 1; j < getNumberColumns(); j++) {
                if (getIndexMaxValue(i) != i) {
                    Vector vector = arrayVectors[i];
                    arrayVectors[i] = arrayVectors[j];
                    arrayVectors[j] = vector;

                    numberPermutationsRows++;
                }

                double number = arrayVectors[j].getComponentByIndex(i) / arrayVectors[i].getComponentByIndex(i);

                for (int k = i; k < getNumberColumns(); k++) {
                    arrayVectors[j].setComponentByIndex(k, arrayVectors[j].getComponentByIndex(k) -
                            arrayVectors[i].getComponentByIndex(k) * number);
                }
            }
        }

        double determinant = 1;

        for (int i = 0; i < getNumberColumns(); ++i) {
            determinant *= Math.pow(-1, numberPermutationsRows) * arrayVectors[i].getComponentByIndex(i);
        }

        return determinant;
    }

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