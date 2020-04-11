package ru.academits.kim.vector;

import java.util.Arrays;

public class Vector {
    private int n;
    private double[] arrayVector;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть > 0");
        }

        this.n = n;
    }

    public Vector(Vector clone) {
        this.n = clone.n;
        this.arrayVector = clone.arrayVector;
    }

    public Vector(double[] arrayVector) {
        this.arrayVector = arrayVector;
    }

    public Vector(int n, double[] arrayVector) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть > 0");
        }

        this.n = n;
        this.arrayVector = arrayVector;
    }

    public int getSize() {
        if (this.arrayVector != null) {
            return Math.max(n, arrayVector.length);
        }

        int size = 0;

        for (int i = 0; i < n; i++) {
            size++;
        }

        return size;
    }

    public double[] getArray() {
        if (this.arrayVector != null) {
            if (n > arrayVector.length) {
                return Arrays.copyOf(arrayVector, n);
            }

            return arrayVector;
        }

        return new double[n];
    }

    public double[] maxLengthArray1(Vector vector) {
        if (getArray().length < vector.getArray().length) {
            return Arrays.copyOf(getArray(), vector.getArray().length);
        }

        return getArray();
    }

    public double[] maxLengthArray2(Vector vector) {
        if (vector.getArray().length <= getArray().length) {
            return Arrays.copyOf(vector.getArray(), getArray().length);
        }

        return vector.getArray();
    }

    public Vector getSum(Vector vector) {
        double[] array1 = maxLengthArray1(vector);
        double[] array2 = maxLengthArray2(vector);

        for (int i = 0; i < array1.length; i++) {
            array1[i] += array2[i];
        }

        return new Vector(array1);
    }

    public Vector getDifference(Vector vector) {
        double[] array1 = maxLengthArray1(vector);
        double[] array2 = maxLengthArray2(vector);

        for (int i = 0; i < array1.length; i++) {
            array1[i] -= array2[i];
        }

        return new Vector(array1);
    }

    public Vector getScalarMultiplication(double scalar) {
        double[] array = new double[getSize()];

        for (int i = 0; i < getSize(); i++) {
            array[i] = scalar * getArray()[i];
        }

        return new Vector(array);
    }

    public Vector getVectorSpread() {
        double[] array = new double[getSize()];

        for (int i = 0; i < getSize(); i++) {
            array[i] = -1 * getArray()[i];
        }

        return new Vector(array);
    }

    public double getVectorLength() {
        int sum = 0;

        for (int i = 0; i < getSize(); i++) {
            sum += Math.pow(getArray()[i], 2);
        }

        return Math.sqrt(sum);
    }

    public double getVectorIndex(int index) {
        return getArray()[index];
    }

    public Vector setVectorIndex(int index, double component) {
        getArray()[index] = component;

        return new Vector(getArray());
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vector = new Vector(vector1);

        return vector.getSum(vector2);
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector vector = new Vector(vector1);

        return vector.getDifference(vector2);
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;
        int arrayLength = Math.min(vector1.getSize(), vector2.getSize());

        for (int i = 0; i < arrayLength; i++) {
            scalarProduct += vector1.getArray()[i] * vector2.getArray()[i];
        }

        return scalarProduct;
    }

    @Override
    public String toString() {
        String result = Arrays.toString(getArray());
        result = result.replace("[", "{");
        result = result.replace("]", "}");

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return false;
        }

        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }

        Vector p = (Vector) o;

        return n == p.n && arrayVector == p.arrayVector;
    }

    @Override
    public int hashCode() {
        int prime = 17;
        int hash = 1;

        hash = hash * prime + n;
        hash = hash * prime + Arrays.hashCode(arrayVector);

        return hash;
    }
}