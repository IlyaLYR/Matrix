package ru.cs.vsu.cg.matrix2024.matrix;

public class Matrix2D extends MatrixWrapper<Matrix2D> {

    /**
     * Конструктор Матрица -> Матрица 2*2
     *
     * @param matrix основная матрица
     */
    private Matrix2D(Matrix matrix) {
        super(2, 2, matrix.getBase());
    }

    /**
     * Конструктор нулевой матрицы 2*2
     */
    public Matrix2D() {
        super(2, 2);
    }

    /**
     * Конструктор матрицы 2*2
     *
     * @param base данные в виде двумерного массива
     */
    public Matrix2D(double[][] base) {
        super(2, 2, base);
    }

    /**
     * Конструктор матрицы 2*2
     *
     * @param base данные в виде одномерного массива
     */
    public Matrix2D(double[] base) {
        super(2, 2, base);
    }

    /**
     * Метод-обертка для общей реализации
     *
     * @param matrix основная матрица
     * @return Матрица 2*2
     */
    @Override
    public Matrix2D newMatrix(Matrix matrix) {
        return new Matrix2D(matrix);
    }
}