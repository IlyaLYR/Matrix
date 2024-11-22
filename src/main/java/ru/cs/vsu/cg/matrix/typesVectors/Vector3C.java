package ru.cs.vsu.cg.matrix.typesVectors;

import ru.cs.vsu.cg.matrix.core.VectorWrapperC;
import ru.cs.vsu.cg.matrix.types.VectorC;

public class Vector3C extends VectorWrapperC<Vector3C> {
    @Override
    public Vector3C newMatrix(VectorC vector) {
        return new Vector3C(vector.getBase());
    }

    public Vector3C() {
        super(3);
    }

    public Vector3C(double[] base) {
        super(3, base);
    }

}
