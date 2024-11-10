package ru.cs.vsu.cg.matrix2024.vectors;

import ru.cs.vsu.cg.matrix2024.matrix.Matrix;

/**
 * Вектор
 */
public class Vector {
    private Matrix matrix;
    private boolean isColumnVector = true;

    /**
     * Конструктор Вектора
     *
     * @param base значения
     */
    public Vector(double[] base) {
        matrix = new Matrix(base.length, 1, base);
    }

    public Vector(int rows, double[] base){
        matrix = new Matrix(rows, 1, base);
    }
    /**
     * Конструктор нулевого вектора
     */
    public Vector(int rows) {
        matrix = new Matrix(rows, 1);
    }

    private Vector(Matrix matrix) {
        setMatrix(matrix);
    }

    /*
      Геттеры и сеттеры
     */

    /**
     * Получить основную матрицу
     *
     * @return основная матрица
     */
    public Matrix getMatrix() {
        return matrix;
    }

    /**
     * Изменить основную матрицу
     *
     * @param matrix новая основная матрица
     */
    private void setMatrix(Matrix matrix) {
        this.matrix = new Matrix(matrix);
    }

    /**
     * Получить количество строк для данной матрицы
     *
     * @return количество строк [>0]
     */
    public int getRows() {
        return getMatrix().getRows();
    }

    /**
     * Получить количество столбцов для данной матрицы
     *
     * @return количество столбцов [>0]
     */
    public int getCols() {
        return getMatrix().getCols();
    }

    /**
     * Получить тело матрицы
     *
     * @return double[] тело матрицы
     */
    public double[] getBase() {
        return getMatrix().getBase();
    }

    public boolean isColumnVector() {
        return isColumnVector;
    }

    public void setColumnVector(boolean columnVector) {
        isColumnVector = columnVector;
    }

    /**
     * Вывод вектора в консоль в виде
     * [A11, A12,
     * A21, A22]
     */
    public void print() {
        getMatrix().print();
    }

    /**
     * Транспонировать текущий вектор
     */
    public void transpose() {
        getMatrix().transpose();
        setColumnVector(!isColumnVector());
    }

    /**
     * Перемножение Векторов
     *
     * @param vector вектор-множитель
     * @return результат перемножения векторов
     */
    public Vector multiply(Vector vector) {
        return new Vector(getMatrix().multiply(vector.getMatrix()));
    }

    /**
     * Умножение вектора на число
     *
     * @param number множитель
     * @return вектор, результат перемножения числа и вектора
     */
    public Vector multiply(double number) {
        return new Vector(getMatrix().multiply(number));
    }

    /**
     * Деление вектора на число
     *
     * @param number делитель
     * @return вектор, результат деления
     */
    public Vector divide(double number) {
        return new Vector(getMatrix().divide(number));
    }

    /**
     * Сложение Векторов
     *
     * @param vector вектор-слагаемое
     * @return результат сложения двух векторов
     */
    public Vector add(Vector vector) {
        return new Vector(getMatrix().add(vector.getMatrix()));
    }

    /**
     * Вычитание двух векторов
     *
     * @param vector вектор-вычитаемое
     * @return результат вычитания двух векторов
     */
    public Vector subtract(Vector vector) {
        return new Vector(getMatrix().subtract(vector.getMatrix()));
    }


    /**
     * Вычислить длину вектора
     *
     * @return длинна вектора
     */
    public double length() {
        double sum = 0;
        for (double i : getBase()) {
            sum += i * i;
        }
        return Math.sqrt(sum);
    }

    /**
     * Нормализация вектора
     *
     * @return нормализованный вектор
     */
    public Vector normalizedVector() {
        double[] base = new double[getBase().length];
        double length = length();
        for (int i = 0; i < getBase().length; i++) {
            base[i] = getBase()[i] / length;
        }
        return new Vector(base);
    }

    /**
     * Нормализация текущего вектора
     */
    public void normalizeVector() {
        double length = length();
        for (int i = 0; i < getBase().length; i++) {
            getBase()[i] = getBase()[i] / length;
        }
    }
}
