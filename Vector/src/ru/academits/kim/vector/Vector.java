package ru.academits.kim.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть > 0");
        }

        this.components = new double[n];
    }

    public Vector(Vector clone) {
        this.components = Arrays.copyOf(clone.components, clone.getSize());
    }

    public Vector(double[] components) {
        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int n, double[] components) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть > 0");
        }

        this.components = Arrays.copyOf(components, n);
    }

    public int getSize() {
        return components.length;
    }

    public double[] getMaxLengthArray1(Vector vector) {
        if (components.length < vector.components.length) {
            return Arrays.copyOf(components, vector.components.length);
        }

        return components;
    }

    public double[] getMaxLengthArray2(Vector vector) {
        if (vector.components.length <= components.length) {
            return Arrays.copyOf(vector.components, components.length);
        }

        return vector.components;
    }

    public Vector getSum(Vector vector) {
        double[] array1 = getMaxLengthArray1(vector);
        double[] array2 = getMaxLengthArray2(vector);

        for (int i = 0; i < getSize(); i++) {
            array1[i] += array2[i];
        }

        return this;
    }

    public Vector getDifference(Vector vector) {
        double[] array1 = getMaxLengthArray1(vector);
        double[] array2 = getMaxLengthArray2(vector);

        for (int i = 0; i < getSize(); i++) {
            array1[i] -= array2[i];
        }

        return this;
    }

    public Vector getMultiplyByScalar(double scalar) {
        for (int i = 0; i < getSize(); i++) {
            components[i] *= scalar;
        }

        return this;
    }

    public Vector getTurn() {
        for (int i = 0; i < getSize(); i++) {
            components[i] *= -1;
        }

        return this;
    }

    public double getLength() {
        int sum = 0;

        for (double e : components) {
            sum += Math.pow(e, 2);
        }

        return Math.sqrt(sum);
    }

    public double getIndex(int index) {
        return components[index];
    }

    public void setIndex(int index, double component) {
        components[index] = component;
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
            scalarProduct += vector1.components[i] * vector2.components[i];
        }

        return scalarProduct;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{");

        for (int i = 0; i < getSize(); i++) {
            stringBuilder.append(components[i]).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return false;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Vector p = (Vector) o;

        for (int i = 0; i < getSize(); i++) {
            if (components[i] != p.components[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int prime = 17;
        int hash = 1;

        hash = hash * prime + Arrays.hashCode(components);

        return hash;
    }
}