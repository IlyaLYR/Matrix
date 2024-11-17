package ru.cs.vsu.cg.matrix.types;

import ru.cs.vsu.cg.matrix.core.AbstractMatrix;

public class RecMatrix extends AbstractMatrix<RecMatrix> {
    public RecMatrix(int row, int col) {
        super(row, col);
        validateNonSquare(row, col);
    }

    public RecMatrix(int row, int col, double[] base) {
        super(row, col, base);
        validateNonSquare(row, col);
    }

    public RecMatrix(int row, int col, double[][] base) {
        super(row, col, base);
        validateNonSquare(row, col);
    }

    private void validateNonSquare(int row, int col) {
        if (row == col) {
            throw new IllegalArgumentException("Матрица не должна быть квадратной. Строки и столбцы должны быть разного размера.");
        }
        if (row == 1 || col == 1) {
            throw new IllegalArgumentException("Размеры прямоугольной матрицы должны быть больше 1x1. или вы пытаетесь ввести вектор");
        }
    }

    /**
     * Транспонирование матрицы
     */
    public void transpose() {
        setMatrix(getMatrix().transposed());
    }
}
