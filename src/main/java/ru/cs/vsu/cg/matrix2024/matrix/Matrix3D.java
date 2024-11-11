package ru.cs.vsu.cg.matrix2024.matrix;

public class Matrix3D extends MatrixWrapper<Matrix3D> {
    /**
     * Конструктор Матрица -> Матрица 3*3
     *
     * @param matrix основная матрица
     */
    private Matrix3D(Matrix matrix) {
        super(3, 3, matrix.getBase());
    }

    /**
     * Конструктор нулевой матрицы 3*3
     */
    public Matrix3D() {
        super(3, 3);
    }

    /**
     * Конструктор матрицы 3*3
     *
     * @param base данные в виде двумерного массива
     */
    public Matrix3D(double[][] base) {
        super(3, 3, base);
    }

    /**
     * Конструктор матрицы 3*3
     *
     * @param base данные в виде одномерного массива
     */
    public Matrix3D(double[] base) {
        super(3, 3, base);
    }

    @Override
    public Matrix3D newMatrix(Matrix matrix) {
        return new Matrix3D(matrix);
    }
}