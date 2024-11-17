package ru.cs.vsu.cg.matrix.typesMatrix;

import ru.cs.vsu.cg.matrix.types.SquareMatrix;

public class Matrix4D extends SquareMatrix {
    public Matrix4D(double[] base) {
        super(4, base);
    }

    public Matrix4D(double[][] base) {
        super(4, base);
    }

    public Matrix4D() {
        super(2);
    }

    public Matrix4D(boolean unit) {
        super(4, unit);
    }
}
