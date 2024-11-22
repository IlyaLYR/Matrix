package ru.cs.vsu.cg.matrix.typesVectors;

import ru.cs.vsu.cg.matrix.core.VectorWrapperC;
import ru.cs.vsu.cg.matrix.types.VectorC;

public class Vector2C extends VectorWrapperC<Vector2C> {
    public Vector2C() {
        super(2);
    }

    public Vector2C(double[] base) {
        super(2, base);
    }

    @Override
    public Vector2C newMatrix(VectorC vector) {
        return new Vector2C(vector.getBase());
    }
}
