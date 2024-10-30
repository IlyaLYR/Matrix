package ru.cs.vsu.cg.matrix2024;

public class Main {
    public static void main(String[] args) {
        Matrix2D m1 = new Matrix2D(new double[]{1,2,3,4});
        Matrix2D m2 = new Matrix2D(new double[]{1,2,3,4});

        Matrix m = Matrix.multiplication(m1,m2, m1.multiply(544));
        m.print();
    }
}
