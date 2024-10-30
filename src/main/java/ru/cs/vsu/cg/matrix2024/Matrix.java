package ru.cs.vsu.cg.matrix2024;

public class Matrix {
    private int rows;
    private int cols;
    private double[] base;

    public Matrix(int rows, int cols, double[] base) {

        if (base.length != (rows * cols)) {
            throw new IllegalArgumentException("Incorrect array size in " + this.getClass().getSimpleName());
        }
        this.rows = rows;
        this.cols = cols;
        this.base = base;
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
        for (int i = 0; i < base.length - 1; i++) {
            System.out.printf("%s, ", base[i]);
            if ((i + 1) % cols == 0 && i != base.length - 1) {
                System.out.println();
                System.out.print(" ");
            }
        }
        System.out.print(base[base.length - 1] + "]\n");
        System.out.printf("row - %S, col - %S \n", rows, cols);
    }

    public void transpose() {
        double[] transposed = new double[cols * rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j * rows + i] = base[i * cols + j];
            }
        }
        base = transposed;
        int curr = rows;
        rows = cols;
        cols = curr;
    }

    public Matrix transposed() {
        double[] transposed = new double[cols * rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j * rows + i] = base[i * cols + j];
            }
        }
        return new Matrix(cols, rows, transposed);
    }

    public static Matrix multiplication(Matrix... m) {
        Matrix start = m[0];
        for (int i = 1; i < m.length; i++) {
            start = start.multiply(m[i]);
        }
        return start;
    }

    public Matrix multiply(Matrix matrix) {
        if (cols != matrix.getRows()) {
            throw new IllegalArgumentException("The number of rows and columns is incorrect for matrix multiplication");
        }
        double[] result = new double[rows * matrix.getCols()];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix.getCols(); j++) {
                double sum = 0;
                for (int k = 0; k < cols; k++) {
                    sum += base[i * cols + k] * matrix.getBase()[k * matrix.getCols() + j];
                }
                result[i * matrix.getCols() + j] = sum;
            }
        }

        return new Matrix(rows, matrix.getCols(), result);
    }

    public Matrix multiply(double n) {
        double[] newMatrix = new double[rows * cols];
        for (int i = 0; i < base.length; i++) {
            newMatrix[i] = base[i] * n;
        }
        return new Matrix(rows, cols, newMatrix);
    }


}
