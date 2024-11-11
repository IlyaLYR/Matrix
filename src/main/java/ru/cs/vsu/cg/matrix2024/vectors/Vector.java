package ru.cs.vsu.cg.matrix2024.vectors;

import ru.cs.vsu.cg.matrix2024.matrix.Matrix;

public class Vector extends VectorWrapper<Vector> {
    /**
     * Конструктор Матрица -> Вектор N
     *
     * @param matrix основная матрица
     */
    private Vector(Matrix matrix) {
        super(matrix.getBase().length, matrix.getBase());
    }

    /**
     * Конструктор нулевой вектора N
     *
     * @param row количество строк
     */
    public Vector(int row) {
        super(row);
    }

    /**
     * Конструктор Вектора N
     *
     * @param base данные в виде двумерного массива
     */
    public Vector(double[] base) {
        super(base.length, base);
    }

    /**
     * Метод-обертка для общей реализации
     *
     * @param matrix основная матрица
     * @return Вектор N
     */
    @Override
    public Vector newMatrix(Matrix matrix) {
        return new Vector(matrix);
    }
}
