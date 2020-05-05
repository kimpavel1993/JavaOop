package ru.academits.kim.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть > 0");
        }

        components = new double[n];
    }

    public Vector(Vector clone) {
        components = Arrays.copyOf(clone.components, clone.getSize());
    }

    public Vector(double[] components) {
        if (components.length <= 0) {
            throw new IllegalArgumentException("Размерность вектора должна быть > 0");
        }

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

    private void maxLengthArray(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }
    }

    public Vector getSum(Vector vector) {
        maxLengthArray(vector);

        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }

        return this;
    }

    public Vector getDifference(Vector vector) {
        maxLengthArray(vector);

        for (int i = 0; i < vector.components.length; i++) {
            components[i] -= vector.components[i];
        }

        return this;
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < getSize(); i++) {
            components[i] *= scalar;
        }
    }

    public void turn() {
        multiplyByScalar(-1);
    }

    public double getLength() {
        int sum = 0;

        for (double e : components) {
            sum += Math.pow(e, 2);
        }

        return Math.sqrt(sum);
    }

    public double getComponentByIndex(int index) {
        return components[index];
    }

    public void setComponentByIndex(int index, double component) {
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

        if (components.length != p.components.length) {
            return false;
        }

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