/**
 * Пакет для основных типов матриц
 */
package ru.cs.vsu.cg.matrix.types;

import ru.cs.vsu.cg.matrix.core.AbstractMatrix;

/**
 * Прямоугольная матрица
 */
public class RecMatrix extends AbstractMatrix<RecMatrix> {
    /**
     * Конструктор нулевой прямоугольной матрицы
     *
     * @param row строки
     * @param col столбцы
     */
    public RecMatrix(int row, int col) {
        super(row, col);
        validateNonSquare(row, col);
    }

    /**
     * Конструктор из общей матрицы
     *
     * @param matrix общая матрица
     */
    protected RecMatrix(Matrix matrix) {
        super(matrix.getRows(), matrix.getCols(), matrix.getBase());
        validateNonSquare(matrix.getRows(), matrix.getCols());
    }

    /**
     * Конструктор прямоугольной матрицы
     *
     * @param row  строки
     * @param col  столбцы
     * @param base одномерный массив
     */
    public RecMatrix(int row, int col, double[] base) {
        super(row, col, base);
        validateNonSquare(row, col);
    }

    /**
     * Конструктор прямоугольной матрицы
     *
     * @param row  строки
     * @param col  столбцы
     * @param base двумерный массив
     */
    public RecMatrix(int row, int col, double[][] base) {
        super(row, col, base);
        validateNonSquare(row, col);
    }


    /**
     * Проверка корректности значений
     *
     * @param row строки
     * @param col столбцы
     */
    private void validateNonSquare(int row, int col) {
        if (row == 1 || col == 1) {
            throw new IllegalArgumentException("Размеры прямоугольной матрицы должны быть больше 1x1. или вы пытаетесь ввести вектор?!");
        }
    }

    /**
     * Транспонирование матрицы
     */
    public void transpose() {
        setMatrix(getMatrix().transposed());
    }

    /**
     * Транспонировать матрицу
     *
     * @return прямоугольная матрица
     */
    public RecMatrix transposed() {
        return newMatrix(getMatrix().transposed());
    }


    /**
     * Метод New Matrix -> для корректной работы AbstractMatrix
     *
     * @param matrix основная матрица
     * @return Прямоугольная матрица
     */
    @Override
    protected RecMatrix newMatrix(Matrix matrix) {
        return new RecMatrix(matrix);
    }

    /**
     * Перемножение прямоугольных матриц
     *
     * @param matrix прямоугольная матрица
     */
    public void multiply(RecMatrix matrix) {
        setMatrix(getMatrix().multiplied(matrix.getMatrix()));
    }

    /**
     * Перемножение прямоугольных матриц
     *
     * @param matrix прямоугольная матрица
     * @return прямоугольная матрица
     */
    public RecMatrix multiplied(RecMatrix matrix) {
        return newMatrix(getMatrix().multiplied(matrix.getMatrix()));
    }

    /**
     * Перемножение прямоугольной и квадратной матрицы
     *
     * @param matrix матрица-множитель
     * @return прямоугольная матрица
     */
    public RecMatrix multiplied(SquareMatrix matrix) {
        Matrix result = getMatrix().multiplied(new Matrix(matrix.getRows(), matrix.getCols(), matrix.getBase()));
        return new RecMatrix(result);
    }

    /**
     * Перемножение прямоугольной матрицы и вектора-столбца
     *
     * @param vector вектор-множитель
     * @return вектор-столбец
     */
    public VectorC multiplied(VectorC vector) {
        Matrix result = getMatrix().multiplied(new Matrix(vector.getRows(), vector.getCols(), vector.getBase()));
        return new VectorC(result);
    }
}
