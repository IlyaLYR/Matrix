package ru.cs.vsu.cg.matrix2024.matrix;

public class Matrix4D extends MatrixWrapper<Matrix4D> {

    /**
     * Конструктор Матрица -> Матрица 4*4
     *
     * @param matrix основная матрица
     */
    private Matrix4D(Matrix matrix) {
        super(4, 4, matrix.getBase());
    }

    /**
     * Конструктор нулевой матрицы 4*4
     */
    public Matrix4D() {
        super(4, 4);
    }

    /**
     * Конструктор матрицы 4*4
     *
     * @param base данные в виде двумерного массива
     */
    public Matrix4D(double[][] base) {
        super(4, 4, base);
    }

    /**
     * Конструктор матрицы 4*4
     *
     * @param base данные в виде одномерного массива
     */
    public Matrix4D(double[] base) {
        super(4, 4, base);
    }

    @Override
    public Matrix4D newMatrix(Matrix matrix) {
        return new Matrix4D(matrix);
    }
}
