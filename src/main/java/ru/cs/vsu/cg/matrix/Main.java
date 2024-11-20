package ru.cs.vsu.cg.matrix;

import ru.cs.vsu.cg.matrix.core.AbstractMatrix;
import ru.cs.vsu.cg.matrix.core.MatrixFactory;
import ru.cs.vsu.cg.matrix.types.SquareMatrix;

public class Main {

    public static void main(String[] args) {
        SquareMatrix a = new SquareMatrix(5, true);
        a.print();
        AbstractMatrix<?> abstractMatrix = MatrixFactory.createMatrix(2, 2, new double[]{1, 2, 3, 4});

    }
}
