package ru.cs.vsu.cg.matrix.types;

import ru.cs.vsu.cg.matrix.core.VectorsActions;
import ru.cs.vsu.cg.matrix.core.AbstractMatrix;

public class VectorC extends AbstractMatrix<VectorC> implements VectorsActions {
    public VectorC(int n) {
        super(n, 1);
    }

    public VectorC(int n, double[] base) {
        super(n, 1, base);
    }

    @Override
    public double[] getVector() {
        return getMatrix().getBase();
    }
}
