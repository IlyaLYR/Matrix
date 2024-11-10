package ru.cs.vsu.cg.matrix2024.matrix;

/**
 * Матрица 4D
 */
public class Matrix4D {
    private Matrix matrix;

    /**
     * Конструктор Матрицы 4*4
     *
     * @param base тело матрицы
     */
    public Matrix4D(double[] base) {
        matrix = new Matrix(4, 4, base);
    }

    /**
     * Конструктор Матрица -> Матрица 4*4
     *
     * @param matrix матрица (4*4)
     */
    private Matrix4D(Matrix matrix) {
        setMatrix(new Matrix(matrix));
    }

    /**
     * Конструктор Матрицы 4*4 на основе другой матрицы...
     *
     * @param matrix4D матрица 4*4
     */
    private Matrix4D(Matrix4D matrix4D) { //Возможно пригодится....
        setMatrix(new Matrix(matrix4D.getMatrix()));
    }

    /**
     * Конструктор нулевой матрицы 4*4
     */
    public Matrix4D() {
        matrix = new Matrix(4, 4);
    }

    /*
      Геттеры и сеттеры
     */

    /**
     * Получить основную матрицу
     *
     * @return основная матрица
     */
    private Matrix getMatrix() {
        return matrix;
    }

    /**
     * Изменить основную матрицу
     *
     * @param matrix новая основная матрица
     */
    private void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    /**
     * Получить количество строк для данной матрицы
     *
     * @return количество строк [>0]
     */
    public int getRows() {
        return 4; //getMatrix().getRows()
    }

    /**
     * Получить количество столбцов для данной матрицы
     *
     * @return количество столбцов [>0]
     */
    public int getCols() {
        return 4; //getMatrix().getCols()
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
     * Вывод матрицы в консоль в виде
     * [A11, A12,
     * A21, A22]
     */
    public void print() {
        getMatrix().print();
    }

    /**
     * Транспонировать текущую матрице
     */
    public void transpose() {
        getMatrix().transpose();
    }

    /**
     * Транспонировать матрицу, текущая матрица остается без изменений.
     *
     * @return новая матрица (транспонированная на основе старой)
     */
    public Matrix4D transposed() {
        return new Matrix4D(getMatrix().transposed());
    }

    /**
     * Перемножение матриц 4*4
     *
     * @param matrix4D матрица-множитель
     * @return результат перемножения матриц (матрица4*4)
     */
    public Matrix4D multiply(Matrix4D matrix4D) {
        return new Matrix4D(getMatrix().multiply(matrix4D.getMatrix()));
    }

    /**
     * Перемножение двух матриц
     *
     * @param matrix матрица-множитель
     * @return результат перемножения двух матриц
     */
    public Matrix multiply(Matrix matrix) {
        return getMatrix().multiply(matrix);
    }

    //TODO Перемножение матрицы 4D с вектором 4D

    /**
     * Умножение матрицы на число
     *
     * @param number множитель
     * @return матрицу, результат перемножения числа и матрицы
     */
    public Matrix4D multiply(double number) {
        return new Matrix4D(getMatrix().multiply(number));
    }

    /**
     * Деление матрицы на число
     *
     * @param number делитель
     * @return матрицу, результат деления
     */
    public Matrix4D divide(double number) {
        return new Matrix4D(getMatrix().divide(number));
    }

    /**
     * Сложение двух матриц 4*4
     *
     * @param matrix4D матрица-слагаемое
     * @return результат сложения двух матриц
     */
    public Matrix4D add(Matrix4D matrix4D) {
        return new Matrix4D(getMatrix().add(matrix4D.getMatrix()));
    }

    /**
     * Вычитание двух матриц
     *
     * @param matrix4D матрица-вычитаемое
     * @return результат вычитания двух матриц
     */
    public Matrix4D subtract(Matrix4D matrix4D) {
        return new Matrix4D(getMatrix().subtract(matrix4D.getMatrix()));
    }
}
