package ru.cs.vsu.cg.matrix2024;

public class Matrix {
    private int rows;
    private int cols;
    private double[] base;

    public Matrix(int rows, int cols, double[] base) {

        if (base.length != (rows * cols)) {
            throw new IllegalArgumentException("Incorrect array size in " + this.getClass().getSimpleName());
        } else if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Incorrect arguments for rows or columns");
        }
        this.rows = rows;
        this.cols = cols;
        this.base = base.clone();
    }

    public Matrix(int rows, int cols) { //Нулевая матрица
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Incorrect arguments for rows or columns");
        }
        this.rows = rows;
        this.cols = cols;
        this.base = new double[rows * cols];
    }


    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public double[] getBase() {
        return base;
    }

    private void setRows(int rows) {
        this.rows = rows;
    }

    private void setCols(int cols) {
        this.cols = cols;
    }

    private void setBase(double[] base) {
        this.base = base;
    }

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

    public void transpose() {
        double[] transposed = new double[cols * rows];
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

    public Matrix transposed() {
        double[] transposed = new double[getCols() * getRows()];
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                transposed[j * getRows() + i] = getBase()[i * getCols() + j];
            }
        }
        return new Matrix(getCols(), getRows(), transposed);
    }

    public static Matrix multiplication(Matrix... m) {
        Matrix start = m[0];
        for (int i = 1; i < m.length; i++) {
            start = start.multiply(m[i]);
        }
        return start;
    }

    public Matrix multiply(Matrix matrix) {
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

        return new Matrix(getRows(), matrix.getCols(), result);
    }

    public Matrix multiply(double n) {
        double[] newMatrix = new double[getRows() * getCols()];
        for (int i = 0; i < getBase().length; i++) {
            newMatrix[i] = getBase()[i] * n;
        }
        return new Matrix(getRows(), getCols(), newMatrix);
    }

    public static Matrix addition(Matrix... m) {
        Matrix start = m[0];
        for (int i = 1; i < m.length; i++) {
            start = start.add(m[i]);
        }
        return start;
    }

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

    public Matrix divide(double n) {
        if (n == 0) {
            throw new IllegalArgumentException("You can't divide by zero!");
        }
        return multiply(1 / n);
    }

    public Matrix subtraction(Matrix... m) {
        Matrix start = m[0];
        for (int i = 1; i < m.length; i++) {
            start = start.subtract(m[i]);
        }
        return start;

    }

    public Matrix subtract(Matrix matrix) {
        return add(matrix.multiply(-1));
    }

    public Matrix createZeroMatrix() {
        return new Matrix(getRows(), getCols(), new double[getRows() * getCols()]);
    }

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

    public double determinant() { //TODO доделать определитель n-го порядка
        if (this.rows != this.cols) {
            throw new IllegalArgumentException("Incorrect matrix");
        }
        return 0;
    }
}
