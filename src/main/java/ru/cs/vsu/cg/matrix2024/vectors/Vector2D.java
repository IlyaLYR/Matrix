package ru.cs.vsu.cg.matrix2024.vectors;

import ru.cs.vsu.cg.matrix2024.matrix.Matrix;

public class Vector2D extends VectorWrapper<Vector2D> {
    /**
     * Конструктор Матрица -> Вектор 2D
     *
     * @param matrix основная матрица
     */
    private Vector2D(Matrix matrix) {
        super(2, matrix.getBase());
    }

    /**
     * Конструктор нулевой вектора 2D
     */
    public Vector2D() {
        super(2);
    }

    /**
     * Конструктор Вектора 2D
     *
     * @param base данные в виде двумерного массива
     */
    public Vector2D(double[] base) {
        super(2, base);
    }

    /**
     * Метод-обертка для общей реализации
     *
     * @param matrix основная матрица
     * @return Вектор N
     */
    @Override
    public Vector2D newMatrix(Matrix matrix) {
        return new Vector2D(matrix);
    }
}
