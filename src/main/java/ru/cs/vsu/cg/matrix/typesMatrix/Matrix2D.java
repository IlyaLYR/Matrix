package ru.cs.vsu.cg.matrix.typesMatrix;

import ru.cs.vsu.cg.matrix.core.MatrixWrapper;
import ru.cs.vsu.cg.matrix.types.SquareMatrix;
import ru.cs.vsu.cg.matrix.typesVectors.Vector2C;

public class Matrix2D extends MatrixWrapper<Matrix2D, Vector2C> {
    public Matrix2D(double[][] base) {
        super(2, base);
    }

    public Matrix2D(double[] base) {
        super(2, base);
    }

    public Matrix2D() {
        super(2);
    }

    public Matrix2D(boolean unit) {
        super(2, unit);
    }

    @Override
    protected Matrix2D newMatrix(SquareMatrix matrix) {
        return new Matrix2D(matrix.getBase());
    }
}
