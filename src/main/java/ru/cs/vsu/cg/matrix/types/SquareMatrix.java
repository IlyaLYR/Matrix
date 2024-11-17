package ru.cs.vsu.cg.matrix.types;

import ru.cs.vsu.cg.matrix.core.AbstractMatrix;

public class SquareMatrix extends AbstractMatrix<SquareMatrix> {

    /**
     * Конструктор квадратной матрицы
     *
     * @param n    количество строк и столбцов
     * @param base тело матрицы (одномерный массив)
     */
    public SquareMatrix(int n, double[] base) {
        super(n, n, base);
    }

    /**
     * Конструктор квадратной матрицы
     *
     * @param n    количество строк и столбцов
     * @param base тело матрицы (двумерный массив)
     */
    public SquareMatrix(int n, double[][] base) {
        super(n, n, base);
    }

    /**
     * Конструктор нулевой матрицы
     *
     * @param n количество строк и столбцов
     */
    public SquareMatrix(int n) {
        super(n, n);
    }

    /**
     * Единичная квадратная матрица
     *
     * @param n    количество строк и столбцов
     * @param unit переменная flag
     */
    public SquareMatrix(int n, boolean unit) {
        super(n, n, unit);
    }

    /**
     * Квадратная матрица из общей матрицы
     *
     * @param n    количество строк
     * @param m    количество столбцов
     * @param base данные матрицы
     */
    private SquareMatrix(int n, int m, double[] base) {
        super(n, m, base);

    }

    /**
     * Транспонирование квадратной матрицы
     */
    public void transpose() {
        setMatrix(getMatrix().transposed());
    }


    /**
     * Возведение матрицы в степень
     *
     * @param n степень
     * @return квадратная матрица
     */
    public AbstractMatrix<?> pows(int n) {
        return newMatrix(getMatrix().pows(n));
    }

    /**
     * Возведение матрицы в степень
     *
     * @param n степень
     */

    public void pow(int n) {
        setMatrix(getMatrix().pows(n));
    }
    public void multiply(SquareMatrix matrix) {
        setMatrix(getMatrix().multiplied(matrix.getMatrix()));
    }
}
