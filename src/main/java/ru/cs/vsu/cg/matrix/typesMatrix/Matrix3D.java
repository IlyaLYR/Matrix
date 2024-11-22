package ru.cs.vsu.cg.matrix.typesMatrix;

import ru.cs.vsu.cg.matrix.core.MatrixWrapper;
import ru.cs.vsu.cg.matrix.types.SquareMatrix;
import ru.cs.vsu.cg.matrix.typesVectors.Vector3C;

public class Matrix3D extends MatrixWrapper<Matrix3D, Vector3C> {
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

    @Override
    protected Matrix3D newMatrix(SquareMatrix matrix) {
        return new Matrix3D(matrix.getBase());
    }
}
