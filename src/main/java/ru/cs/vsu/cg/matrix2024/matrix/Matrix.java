package ru.cs.vsu.cg.matrix2024.matrix;

/**
 * Класс Matrix (основная логика в данном классе)
 *
 * @author IlyaLYR
 */

public class Matrix {
    private int rows;
    private int cols;
    private double[] base;


    /**
     * Основной конструктор Матрицы N*M
     *
     * @param rows количество строк
     * @param cols количество столбцов
     * @param base тело матрицы
     */
    public Matrix(int rows, int cols, double[] base) {
        setRows(rows);
        setCols(cols);
        setBase(base.clone());
    }

    /**
     * Конструктор нулевой матрицы
     *
     * @param rows количество строк
     * @param cols количество столбцов
     */
    public Matrix(int rows, int cols) { //Нулевая матрица
        setRows(rows);
        setCols(cols);
        setBase(new double[rows * cols]);
    }


    /**
     * Новая матрица на основе старой
     *
     * @param matrix матрица родитель
     */
    public Matrix(Matrix matrix) {
        setRows(matrix.getRows());
        setCols(matrix.getCols());
        setBase(matrix.getBase().clone());
    }

    /*
    Геттеры и сеттеры
     */
    public Matrix clone() { //вспомогательный метод клонирования матрицы
        return new Matrix(this);
    }

    /**
     * Получить количество строк для данной матрицы
     *
     * @return количество строк [>0]
     */
    public int getRows() {
        return rows;
    }

    /**
     * Получить количество столбцов для данной матрицы
     *
     * @return количество столбцов [>0]
     */
    public int getCols() {
        return cols;
    }

    /**
     * Получить тело матрицы
     *
     * @return double[] тело матрицы
     */
    public double[] getBase() {
        return base;
    }

    /**
     * Установить значение строк в матрице
     *
     * @param rows количество строк [>0]
     */
    private void setRows(int rows) {
        if (rows <= 0) { //Обработка некорректных значений
            throw new IllegalArgumentException("Incorrect arguments for rows");
        }
        this.rows = rows;
    }

    /**
     * Установить значение столбцов в матрице
     *
     * @param cols количество столбцов [>0]
     */
    private void setCols(int cols) {
        if (cols <= 0) {
            throw new IllegalArgumentException("Incorrect arguments for cols");
        }
        this.cols = cols;
    }

    /**
     * Изменение тела матрицы (новый массив)
     *
     * @param base новый массив
     */
    private void setBase(double[] base) {
        if (base.length != (rows * cols)) {
            throw new IllegalArgumentException("Incorrect array size in " + this.getClass().getSimpleName());
        }
        this.base = base;
    }

    /**
     * Вывод матрицы в консоль в виде
     * [A11, A12,
     * A21, A22]
     */
    public void print() {
        System.out.print("[");
        for (int i = 0; i < getBase().length - 1; i++) {
            System.out.printf("%s, ", getBase()[i]);
            if ((i + 1) % getCols() == 0 && i != getBase().length - 1) {
                System.out.println();
                System.out.print(" ");
            }
        }
        System.out.print(getBase()[getBase().length - 1] + "]\n");
        System.out.printf("row - %S, col - %S \n", getRows(), getCols());
    }

    /**
     * Транспонировать текущую матрице
     */
    public void transpose() {
        double[] transposed = new double[getCols() * getRows()];
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                transposed[j * getRows() + i] = getBase()[i * getCols() + j];
            }
        }
        int curr = getRows();
        setBase(transposed);
        setRows(getCols());
        setCols(curr);
    }

    /**
     * Транспонировать матрицу, текущая матрица остается без изменений.
     *
     * @return новая матрица (транспонированная на основе старой)
     */
    public Matrix transposed() {
        Matrix copy = this.clone();
        copy.transpose();
        return copy;
    }

    /**
     * Перемножение двух матриц
     *
     * @param matrix матрица-множитель
     */


    public void multiply(Matrix matrix) {
        if (getCols() != matrix.getRows()) {
            throw new IllegalArgumentException("The number of rows and columns is incorrect for matrix multiplication");
        }
        double[] result = new double[getRows() * matrix.getCols()];

        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                double sum = 0;
                for (int k = 0; k < getCols(); k++) {
                    sum += getBase()[i * getCols() + k] * matrix.getBase()[k * matrix.getCols() + j];
                }
                result[i * matrix.getCols() + j] = sum;
            }
        }
        setCols(matrix.getCols());
        setBase(result);
    }

    /**
     * Перемножение двух матриц
     *
     * @param matrix матрица-множитель
     * @return результат перемножения двух матриц в новой матрице
     */
    public Matrix multiplied(Matrix matrix) {
        Matrix copy = this.clone();
        copy.multiply(matrix);
        return copy;
    }

    /**
     * Умножение матрицы на число
     *
     * @param number множитель
     * @return матрицу, результат перемножения числа и матрицы
     */
    public Matrix multiplied(double number) {
        double[] newMatrix = new double[getRows() * getCols()];
        for (int i = 0; i < getBase().length; i++) {
            newMatrix[i] = getBase()[i] * number;
        }
        return new Matrix(getRows(), getCols(), newMatrix);
    }


    /**
     * Сложение двух матриц
     *
     * @param matrix матрица-слагаемое
     * @return результат сложения двух матриц
     */
    public Matrix add(Matrix matrix) {
        if (getRows() != matrix.getRows() || getCols() != matrix.getCols()) {
            throw new IllegalArgumentException("The number of rows and columns is incorrect for matrix addition");
        }
        double[] result = new double[getRows() * getCols()];
        for (int i = 0; i < getBase().length; i++) {
            result[i] = getBase()[i] + matrix.getBase()[i];
        }
        return new Matrix(getRows(), getCols(), result);
    }

    /**
     * Деление матрицы на число
     *
     * @param number делитель
     * @return матрицу, результат деления
     */
    public Matrix divide(double number) {
        if (number == 0) {
            throw new IllegalArgumentException("You can't divide by zero!");
        }
        return multiplied(1 / number);
    }

    /**
     * Вычитание двух матриц
     *
     * @param matrix матрица-вычитаемое
     * @return результат вычитания двух матриц
     */
    public Matrix subtract(Matrix matrix) {
        return add(matrix.multiplied(-1));
    }

    /**
     * Создание нулевой матрицы на основе текущей
     *
     * @return нулевая матрица
     */
    public Matrix createZeroMatrix() {
        return new Matrix(getRows(), getCols(), new double[getRows() * getCols()]);
    }

    /**
     * Создание единичной матрицы на основе текущей
     *
     * @return единичная матрица
     */
    public Matrix createUnitMatrix() {
        if (this.getRows() != this.getCols()) {
            throw new IllegalArgumentException("The number of rows and columns does not match");
        }
        double[] unitMatrix = new double[getRows() * getCols()];
        for (int i = 0; i < getCols(); i++) {
            unitMatrix[i * getRows() + i] = 1;
        }
        return new Matrix(getRows(), getCols(), unitMatrix);
    }
}
