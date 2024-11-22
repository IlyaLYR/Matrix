package ru.cs.vsu.cg.matrix.typesMatrix;

import ru.cs.vsu.cg.matrix.core.MatrixWrapper;
import ru.cs.vsu.cg.matrix.types.SquareMatrix;
import ru.cs.vsu.cg.matrix.typesVectors.Vector4C;

public class Matrix4D extends MatrixWrapper<Matrix4D, Vector4C> {
    public Matrix4D(double[][] base) {
        super(4, base);
    }

    public Matrix4D(double[] base) {
        super(4, base);
    }

    public Matrix4D() {
        super(4);
    }

    public Matrix4D(boolean unit) {
        super(4, unit);
    }

    @Override
    protected Matrix4D newMatrix(SquareMatrix matrix) {
        return new Matrix4D(matrix.getBase());
    }
}
