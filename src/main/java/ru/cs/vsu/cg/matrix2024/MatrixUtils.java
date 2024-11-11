//package ru.cs.vsu.cg.matrix2024;
//
//public class MatrixUtils {
//
//
//    /**
//     * Статический метод для перемножения нескольких матриц и векторов одной размерности
//     *
//     * @param matrix множество матриц (векторов) которые необходимо перемножить
//     * @return матрица результат перемножения всех матриц
//     */
//    @SafeVarargs
//    public static <T extends Solver<T>> T multiplication(T... matrix) {
//        T start = matrix[0];
//        for (int i = 1; i < matrix.length; i++) {
//            start = start.multiply(matrix[i]);
//        }
//        return start;
//    }
//
//    /**
//     * Статический метод для сложения нескольких матриц и векторов одной размерности
//     *
//     * @param matrix множество матриц (векторов) которые необходимо сложить
//     * @return матрица результат сложения всех матриц
//     */
//    @SafeVarargs
//    public static <T extends Solver<T>> T addition(T... matrix) {
//        T start = matrix[0];
//        for (int i = 1; i < matrix.length; i++) {
//            start = start.add(matrix[i]);
//        }
//        return start;
//    }
//
//    /**
//     * Статический метод для вычитания нескольких матриц и векторов одной размерности
//     *
//     * @param matrix множество матриц (векторов)
//     * @return матрица результат вычитания всех матриц
//     */
//    @SafeVarargs
//    public static <T extends Solver<T>> T subtraction(T... matrix) {
//        T start = matrix[0];
//        for (int i = 1; i < matrix.length; i++) {
//            start = start.subtract(matrix[i]);
//        }
//        return start;
//    }
//
//
//}
