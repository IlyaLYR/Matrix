package ru.cs.vsu.cg.matrix.types;

import ru.cs.vsu.cg.matrix.core.VectorsActions;
import ru.cs.vsu.cg.matrix.core.AbstractMatrix;

public class VectorR extends AbstractMatrix<VectorR> implements VectorsActions {

    public VectorR(int n) {
        super(1, n);
    }

    public VectorR(int n, double[] base) {
        super(1, n, base);
    }

    @Override
    public double[] getVector() {
        return getMatrix().getBase();
    }
}
