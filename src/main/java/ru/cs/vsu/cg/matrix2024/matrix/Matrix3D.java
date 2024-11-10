package ru.cs.vsu.cg.matrix2024.matrix;

/**
 * Матрица 3D
 */
public class Matrix3D {
    private Matrix matrix;

    /**
     * Конструктор Матрицы 3*3
     *
     * @param base тело матрицы
     */
    public Matrix3D(double[] base) {
        matrix = new Matrix(3, 3, base);
    }

    /**
     * Конструктор Матрица -> Матрица 3*3
     *
     * @param matrix матрица (3*3)
     */
    private Matrix3D(Matrix matrix) {
        setMatrix(new Matrix(matrix));
    }

    /**
     * Конструктор Матрицы 3*3 на основе другой матрицы...
     *
     * @param matrix3D матрица 3*3
     */
    private Matrix3D(Matrix3D matrix3D) { //Возможно пригодится....
        setMatrix(new Matrix(matrix3D.getMatrix()));
    }

    /**
     * Конструктор нулевой матрицы 3*3
     */
    public Matrix3D() {
        matrix = new Matrix(3, 3);
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
        return 3; //getMatrix().getRows()
    }

    /**
     * Получить количество столбцов для данной матрицы
     *
     * @return количество столбцов [>0]
     */
    public int getCols() {
        return 3; //getMatrix().getCols()
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
    public Matrix3D transposed() {
        return new Matrix3D(getMatrix().transposed());
    }

    /**
     * Перемножение матриц 3*3
     *
     * @param matrix3D матрица-множитель
     * @return результат перемножения матриц (матрица3*3)
     */
    public Matrix3D multiply(Matrix3D matrix3D) {
        return new Matrix3D(getMatrix().multiply(matrix3D.getMatrix()));
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

    //TODO Перемножение матрицы 3D с вектором 3D

    /**
     * Умножение матрицы на число
     *
     * @param number множитель
     * @return матрицу, результат перемножения числа и матрицы
     */
    public Matrix3D multiply(double number) {
        return new Matrix3D(getMatrix().multiply(number));
    }

    /**
     * Деление матрицы на число
     *
     * @param number делитель
     * @return матрицу, результат деления
     */
    public Matrix3D divide(double number) {
        return new Matrix3D(getMatrix().divide(number));
    }

    /**
     * Сложение двух матриц 3*3
     *
     * @param matrix3D матрица-слагаемое
     * @return результат сложения двух матриц
     */
    public Matrix3D add(Matrix3D matrix3D) {
        return new Matrix3D(getMatrix().add(matrix3D.getMatrix()));
    }

    /**
     * Вычитание двух матриц
     *
     * @param matrix3D матрица-вычитаемое
     * @return результат вычитания двух матриц
     */
    public Matrix3D subtract(Matrix3D matrix3D) {
        return new Matrix3D(getMatrix().subtract(matrix3D.getMatrix()));
    }

    //TODO определитель 3-х мерной
//    public double determinant() {
//        double[] base = getMatrix().getBase();
//        return base[0] * base[3] - base[1] * base[2];
//    }

}
