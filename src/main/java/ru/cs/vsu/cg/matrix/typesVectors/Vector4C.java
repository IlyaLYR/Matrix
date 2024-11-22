package ru.cs.vsu.cg.matrix.typesVectors;

import ru.cs.vsu.cg.matrix.core.VectorWrapperC;
import ru.cs.vsu.cg.matrix.types.VectorC;

public class Vector4C extends VectorWrapperC<Vector4C> {
    public Vector4C() {
        super(4);
    }

    public Vector4C(double[] base) {
        super(4, base);
    }

    @Override
    public Vector4C newMatrix(VectorC vector) {
        return new Vector4C(vector.getBase());
    }
}
