package ru.cs.vsu.cg.matrix2024.matrix;

/**
 * Абстрактный клас для реализации подклассов основанных на основной логике матриц
 *
 * @param <T> название класса "обертки"
 */
public abstract class MatrixWrapper<T extends MatrixWrapper<T>> {
    private Matrix matrix; //основная матрица

    /**
     * Конструктор класса обертки (одномерный массив)
     *
     * @param row  количество строк
     * @param col  количество столбцов
     * @param base массив элементов матрицы
     */
    public MatrixWrapper(int row, int col, double[] base) {
        matrix = new Matrix(row, col, base);
    }

    /**
     * Конструктор класса обертки (двумерный массив)
     *
     * @param row  количество строк
     * @param col  количество столбцов
     * @param base массив элементов матрицы
     */
    public MatrixWrapper(int row, int col, double[][] base) {
        double[] result = new double[base.length * base[0].length];
        int i = 0;
        for (double[] doubles : base) {
            for (double aDouble : doubles) {
                result[i] = aDouble;
                i++;
            }
        }
        matrix = new Matrix(row, col, result);

    }

    /**
     * Конструктор нулевой матрицы
     *
     * @param row количество строк
     * @param col количество столбцов
     */
    public MatrixWrapper(int row, int col) {
        matrix = new Matrix(row, col);
    }

    /**
     * Преобразовать матрицу -> матрицу обертку
     * <p>
     * ДАННЫЙ МЕТОД НЕОБХОДИМО ПЕРЕОПРЕДЕЛИТЬ В НАСЛЕДНИКЕ
     *
     * @param matrix основная матрица
     * @return матрица обертка
     */
    public abstract T newMatrix(Matrix matrix);

    /*
    Геттеры сеттеры
     */

    /**
     * Получить количество строк для данной матрицы
     *
     * @return количество строк [>0]
     */
    public int getCols() {
        return getMatrix().getCols();
    }

    /**
     * Получить количество столбцов для данной матрицы
     *
     * @return количество столбцов [>0]
     */
    public int getRows() {
        return getMatrix().getRows();
    }

    /**
     * Получить тело матрицы
     *
     * @return double[] тело матрицы
     */
    public double[] getBase() {
        return getMatrix().getBase();
    }

    /**
     * Метод для получения основной матрицы
     *
     * @return основная матрица
     */
    protected Matrix getMatrix() {
        return matrix;
    }

    /**
     * Метод для изменения основной матрицы
     *
     * @param matrix основная матрица
     */
    private void setMatrix(Matrix matrix) {
        if (matrix.getRows() != getRows() || matrix.getCols() != getCols()) {
            throw new IllegalArgumentException("The number of rows and columns is incorrect!!! (setMatrix)");
        }
        this.matrix = matrix;
    }


    /**
     * Вывод матрицы в консоль в виде <p>
     * <p>[A11, A12,<p>
     * A21, A22]
     */
    public void print() {
        getMatrix().print();
    }

    public void transpose() {
        getMatrix().transpose();
    }

    public T multiply(T other) {
        return newMatrix(getMatrix().multiplied(other.getMatrix()));
    }


    public Matrix multiply(Matrix other) {
        return getMatrix().multiplied(other);
    }


    public T multiply(double number) {
        return newMatrix(getMatrix().multiplied(number));
    }

    public T divide(double number) {
        return newMatrix(getMatrix().divide(number));
    }

    public T add(T other) {
        return newMatrix(getMatrix().add(other.getMatrix()));
    }


    public T subtract(T other) {
        return newMatrix(getMatrix().subtract(other.getMatrix()));
    }
}
