package ru.cs.vsu.cg.matrix.typesMatrix;

import ru.cs.vsu.cg.matrix.types.SquareMatrix;

public class Matrix2D extends SquareMatrix {
    public Matrix2D(double[] base) {
        super(2, base);
    }

    public Matrix2D(double[][] base) {
        super(2, base);
    }

    public Matrix2D() {
        super(2);
    }

    public Matrix2D(boolean unit) {
        super(2, unit);
    }
}
