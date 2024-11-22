package ru.cs.vsu.cg.matrix.core;

public class MatrixUtils {

    public static <T extends VectorWrapperC<T>> double dotProduct(T v1, T v2, double angle) {
        return v1.getLength() * v2.getLength() * Math.cos(angle);
    }
    @SafeVarargs
    public static <T extends VectorWrapperC<T>> T add(T... vectors) {
        T vector = vectors[0];
        for (int i = 1; i < vectors.length; i++) {
            vector.add(vectors[i]);
        }
        return vector;
    }

    @SafeVarargs
    public static <T extends MatrixWrapper<T, ?>> T multiplied(T... matrix) {
        T result = matrix[0];
        for (int i = 1; i < matrix.length; i++) {
            result.multiply(matrix[i]);
        }
        return result;
    }
}
