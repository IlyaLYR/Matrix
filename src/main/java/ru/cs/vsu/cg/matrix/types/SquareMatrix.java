package ru.cs.vsu.cg.matrix.types;

import ru.cs.vsu.cg.matrix.core.AbstractMatrix;

/**
 * Квадратная матрица
 */
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
     * Конструктор из общей матрицы
     *
     * @param matrix общая матрица
     */
    protected SquareMatrix(Matrix matrix) {
        super(matrix.getRows(), matrix.getCols(), matrix.getBase());
        validateSquare(matrix.getRows(), matrix.getCols());
    }

    /**
     * Метод New Matrix -> для корректной работы AbstractMatrix
     *
     * @param matrix основная матрица
     * @return Квадратная матрица
     */
    @Override
    protected SquareMatrix newMatrix(Matrix matrix) {
        return new SquareMatrix(matrix);
    }

    /**
     * Транспонирование квадратной матрицы
     */
    public void transpose() {
        setMatrix(getMatrix().transposed());
    }


    /**
     * Транспонировать матрицу
     *
     * @return квадратная матрица
     */
    public SquareMatrix transposed() {
        return newMatrix(getMatrix().transposed());
    }


    /**
     * Возведение матрицы в степень
     *
     * @param n степень
     * @return квадратная матрица
     */
    public SquareMatrix pows(int n) {
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

    /**
     * Умножение квадратной матрицы
     *
     * @param matrix матрица-множитель
     */
    public void multiply(SquareMatrix matrix) {
        setMatrix(getMatrix().multiplied(matrix.getMatrix()));
    }

    /**
     * Умножение квадратной матрицы
     *
     * @param matrix матрица-множитель
     * @return квадратная матрица
     */
    public SquareMatrix multiplied(SquareMatrix matrix) {
        return newMatrix(getMatrix().multiplied(matrix.getMatrix()));
    }


    /**
     * Умножение квадратной матрицы на вектор-столбец
     *
     * @param vector вектор-множитель
     * @return вектор-столбец
     */
    public VectorC multiplied(VectorC vector) {
        Matrix result = getMatrix().multiplied(new Matrix(vector.getRows(), vector.getCols(), getBase()));
        return new VectorC(result);
    }

    /**
     * Умножение на прямоугольную матрицу
     *
     * @param matrix матрица-множитель
     * @return прямоугольная матрица
     */
    public RecMatrix multiplied(RecMatrix matrix) {
        Matrix result = getMatrix().multiplied(new Matrix(matrix.getRows(), matrix.getCols(), getBase()));
        return new RecMatrix(result);
    }

    /**
     * Проверка корректности значений
     *
     * @param row строки
     * @param col столбцы
     */
    private void validateSquare(int row, int col) {
        if (row == 1 || col == 1) {
            throw new IllegalArgumentException("Размеры квадратной матрицы должны быть больше 1x1. или вы пытаетесь ввести вектор?!");
        }
        if (row != col) {
            throw new IllegalArgumentException("Некорректные значения строк и столбцов");
        }
    }

//    public double determinant() {} //TODO на будущее - можно реализовать определитель, обратная матрица, и другое
}
