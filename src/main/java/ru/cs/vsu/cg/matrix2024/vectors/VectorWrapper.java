package ru.cs.vsu.cg.matrix2024.vectors;

import ru.cs.vsu.cg.matrix2024.matrix.Matrix;
import ru.cs.vsu.cg.matrix2024.matrix.MatrixWrapper;

public abstract class VectorWrapper<T extends VectorWrapper<T>> extends MatrixWrapper<VectorWrapper<T>> {

    private VectorWrapper(Matrix matrix) {
        super(matrix.getRows(), 1, matrix.getBase());
    }

    public VectorWrapper(int row, double[] base) {
        super(row, 1, base);
    }

    public VectorWrapper(int row) {
        super(row, 1);
    }

    @Override
    public abstract VectorWrapper<T> newMatrix(Matrix matrix);

    /**
     * Вычислить длину вектора
     *
     * @return длинна вектора
     */
    public double length() {
        double sum = 0;
        for (double i : getBase()) {
            sum += i * i;
        }
        return Math.sqrt(sum);
    }

    /**
     * Нормализация текущего вектора
     */
    public void normalizeVector() {
        double length = length();
        for (int i = 0; i < getBase().length; i++) {
            getBase()[i] = getBase()[i] / length;
        }
    }
}