package ru.cs.vsu.cg.matrix2024;

public class Matrix2D {
    Matrix matrix;

    public Matrix2D(double[] base) {
        matrix = new Matrix(2, 2, base);
    }

    private Matrix2D(Matrix matrix) {
        this.matrix = matrix;
    }

    public Matrix2D(Matrix2D matrix2D) { //Возможно пригодится....
        this.matrix = matrix2D.matrix;
    }

    public Matrix2D() {
        matrix = new Matrix(2, 2);
    }

    public Matrix2D add(Matrix2D matrix2D) {
        return new Matrix2D(matrix.add(matrix2D.matrix));
    }

    public Matrix2D subtract(Matrix2D matrix2D) {
        return new Matrix2D(matrix.subtract(matrix2D.matrix));
    }
}
