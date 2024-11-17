package ru.cs.vsu.cg.matrix.typesMatrix;

import ru.cs.vsu.cg.matrix.types.SquareMatrix;

public class Matrix3D extends SquareMatrix {
    public Matrix3D(double[] base) {
        super(3, base);
    }

    public Matrix3D(double[][] base) {
        super(3, base);
    }

    public Matrix3D() {
        super(3);
    }

    public Matrix3D(boolean unit) {
        super(3, unit);
    }
}
