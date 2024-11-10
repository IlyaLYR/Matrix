package ru.cs.vsu.cg.matrix2024.matrix;

/**
 * Матрица 2D
 */
public class Matrix2D {
    private Matrix matrix;

    /**
     * Конструктор Матрицы 2*2
     *
     * @param base тело матрицы
     */
    public Matrix2D(double[] base) {
        matrix = new Matrix(2, 2, base);
    }

    /**
     * Конструктор Матрица -> Матрица 2*2
     *
     * @param matrix матрица N*M
     */
    private Matrix2D(Matrix matrix) {
        setMatrix(new Matrix(matrix));
    }

    /**
     * Конструктор Матрицы 2*2 на основе другой матрицы...
     *
     * @param matrix2D матрица 2*2
     */
    private Matrix2D(Matrix2D matrix2D) { //Возможно пригодится....
        setMatrix(new Matrix(matrix2D.getMatrix()));
    }

    /**
     * Конструктор нулевой матрицы 2*2
     */
    public Matrix2D() {
        matrix = new Matrix(2, 2);
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
        return 2; //getMatrix().getRows()
    }

    /**
     * Получить количество столбцов для данной матрицы
     *
     * @return количество столбцов [>0]
     */
    public int getCols() {
        return 2; //getMatrix().getCols()
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
    public Matrix2D transposed() {
        return new Matrix2D(getMatrix().transposed());
    }

    /**
     * Перемножение матриц 2*2
     *
     * @param matrix2D матрица-множитель
     * @return результат перемножения матриц (матрица2*2)
     */
    public Matrix2D multiply(Matrix2D matrix2D) {
        return new Matrix2D(getMatrix().multiply(matrix2D.getMatrix()));
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

    //TODO Перемножение матрицы 2D с вектором 2D

    /**
     * Умножение матрицы на число
     *
     * @param number множитель
     * @return матрицу, результат перемножения числа и матрицы
     */
    public Matrix2D multiply(double number) {
        return new Matrix2D(getMatrix().multiply(number));
    }

    /**
     * Деление матрицы на число
     *
     * @param number делитель
     * @return матрицу, результат деления
     */
    public Matrix2D divide(double number) {
        return new Matrix2D(getMatrix().divide(number));
    }

    /**
     * Сложение двух матриц 2*2
     *
     * @param matrix2D матрица-слагаемое
     * @return результат сложения двух матриц
     */
    public Matrix2D add(Matrix2D matrix2D) {
        return new Matrix2D(getMatrix().add(matrix2D.getMatrix()));
    }

    /**
     * Вычитание двух матриц
     *
     * @param matrix матрица-вычитаемое
     * @return результат вычитания двух матриц
     */
    public Matrix2D subtract(Matrix2D matrix) {
        return new Matrix2D(getMatrix().subtract(matrix.getMatrix()));
    }

    public double determinant() {
        double[] base = getMatrix().getBase();
        return base[0] * base[3] - base[1] * base[2];
    }

}
