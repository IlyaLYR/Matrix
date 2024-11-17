package ru.cs.vsu.cg.matrix.core;

public interface VectorsActions {
    double[] getVector();

    int getRows();

    int getCols();

    // Получить длину вектора
    default double getLength() {
        double[] vector = getVector();
        double sum = 0;
        for (double v : vector) {
            sum += v * v;
        }
        return Math.sqrt(sum);
    }

    // Нормализовать вектор (привести к единичной длине)
    default AbstractMatrix<?> normalize() {
        double length = getLength();
        if (length == 0) {
            throw new ArithmeticException("Невозможно нормализовать нулевой вектор.");
        }
        double[] vector = getVector();
        double[] normalized = new double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            normalized[i] = vector[i] / length;
        }
        return MatrixFactory.createMatrix(getRows(), getCols(), normalized);
    }
}
