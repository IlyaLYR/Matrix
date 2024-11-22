package ru.cs.vsu.cg.matrix.core;

import ru.cs.vsu.cg.matrix.types.SquareMatrix;
import ru.cs.vsu.cg.matrix.types.VectorC;

/**
 * Класс обертка для квадратных матриц заданного размера
 * <p>
 *     Содержит методы применимые к квадратной матрице
 * </p>
 * @param <T> конкретный класс квадратной матрицы с заданным размером
 * @param <E> конкретный класс вектора-столбца с заданным размером
 */
public abstract class MatrixWrapper<T extends MatrixWrapper<T, E>, E extends VectorWrapperC<E>> {
    /**
     * Квадратная матрица
     */
    SquareMatrix matrix;


    /**
     * Конструктор квадратной матрицы
     *
     * @param n    количество строк и столбцов
     * @param base тело матрицы (одномерный массив)
     */
    public MatrixWrapper(int n, double[] base) {
        matrix = new SquareMatrix(n, base);
    }

    /**
     * Конструктор квадратной матрицы
     *
     * @param n    количество строк и столбцов
     * @param base тело матрицы (двумерный массив)
     */
    public MatrixWrapper(int n, double[][] base) {
        matrix = new SquareMatrix(n, base);
    }

    /**
     * Конструктор нулевой матрицы
     *
     * @param n количество строк и столбцов
     */
    public MatrixWrapper(int n) {
        matrix = new SquareMatrix(n);
    }

    /**
     * Единичная квадратная матрица
     *
     * @param n    количество строк и столбцов
     * @param unit переменная flag
     */
    public MatrixWrapper(int n, boolean unit) {
        matrix = new SquareMatrix(n, unit);
    }
    //Геттеры сеттеры

    /**
     * Получить значения матрицы
     * @return одномерный массив со всеми значениями матрицы
     */
    public double[] getBase() {
        return matrix.getBase();
    }


    /**
     * Получить количество строк
     *
     * @return значение
     */
    public int getRows() {
        return matrix.getRows();
    }

    /**
     * Получить количество столбцов
     *
     * @return значение
     */
    public int getCols() {
        return matrix.getCols();
    }

    /**
     * Получит тело матрицы
     *
     * @return матрица - базовый объект
     */
    protected SquareMatrix getMatrix() {
        return matrix;
    }

    /**
     * Изменить тело матрицы
     */
    protected void setMatrix(SquareMatrix matrix) {
        this.matrix = matrix;
    }

    /**
     * Получить элементы по индексу
     *
     * @param row строка
     * @param col столбец
     * @return значение
     */
    public double get(int row, int col) {
        return matrix.get(row, col);
    }


    /**
     * Изменить значение по индексу
     *
     * @param row   строка
     * @param col   столбец
     * @param value значение
     */
    public void set(int row, int col, double value) {
        matrix.set(row, col, value);
    }

    /**
     * Вывод матрицы
     */
    public void print() {
        matrix.print();
    }


    /**
     * Вспомогательный метод
     * @param matrix квадратная матрица
     * @return матрицу с ограниченным значением
     */
    protected abstract T newMatrix(SquareMatrix matrix);

    /**
     * Сложение матриц
     *
     * @param other слагаемое
     */
    public void add(T other) {
        setMatrix(matrix.added(other.getMatrix()));
    }

    /**
     * Сложение матриц
     *
     * @param other слагаемое
     * @return новая матрица - результат
     */
    public T added(T other) {
        return newMatrix(matrix.added(other.getMatrix()));
    }

    /**
     * Вычитание матриц
     *
     * @param other вычитаемое
     */
    public void subtract(T other) {
        setMatrix(matrix.subtracted(other.getMatrix()));
    }

    /**
     * Вычитание матриц
     *
     * @param other вычитаемое
     * @return новая матрица - результат
     */
    public T subtracted(T other) {
        return newMatrix(matrix.subtracted(other.getMatrix()));
    }

    /**
     * Умножение матрицы на число
     *
     * @param number множитель
     */
    public void multiply(double number) {
        setMatrix(matrix.multiplied(number));
    }

    /**
     * Умножение матрицы на число
     *
     * @param number множитель
     * @return новая матрица - результат
     */
    public T multiplied(double number) {
        return newMatrix(matrix.multiplied(number));
    }

    /**
     * Деление матрицы на число
     *
     * @param number делитель
     */
    public void divide(double number) {
        setMatrix(matrix.divided(number));
    }

    /**
     * Деление матрицы на число
     *
     * @param number делитель
     * @return новая матрица - результат
     */
    public T divided(double number) {
        return newMatrix(matrix.divided(number));
    }

    /**
     * Вывод в консоль объекта
     *
     * @return текст
     */
    @Override
    public String toString() {
        return matrix.toString();
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
    public T transposed() {
        return newMatrix(getMatrix().transposed());
    }

    /**
     * Возведение матрицы в степень
     *
     * @param n степень
     * @return квадратная матрица
     */
    public T pows(int n) {
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
    public void multiply(T matrix) {
        setMatrix(getMatrix().multiplied(matrix.getMatrix()));
    }

    /**
     * Умножение квадратной матрицы
     *
     * @param matrix матрица-множитель
     * @return квадратная матрица
     */
    public T multiplied(T matrix) {
        return newMatrix(getMatrix().multiplied(matrix.getMatrix()));
    }

    /**
     * Умножение квадратной матрицы на вектор-столбец
     *
     * @param vector вектор-множитель
     * @return вектор-столбец
     */
    public E multiplied(E vector) {
        VectorC result = matrix.multiplied(new VectorC(vector.getRows(), vector.getBase()));
        return vector.newMatrix(result);
    }
}
