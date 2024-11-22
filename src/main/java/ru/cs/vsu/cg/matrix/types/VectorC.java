package ru.cs.vsu.cg.matrix.types;

import ru.cs.vsu.cg.matrix.core.AbstractMatrix;

/**
 * Вектор-столбец
 */
public class VectorC extends AbstractMatrix<VectorC> {
    /**
     * Конструктор нулевого вектора-столбца
     *
     * @param n количество элементов
     */
    public VectorC(int n) {
        super(n, 1);
    }

    /**
     * Конструктор вектор-столбца
     *
     * @param n    количество элементов
     * @param base элементы вектора
     */
    public VectorC(int n, double[] base) {
        super(n, 1, base);
    }


    /**
     * Вспомогательный метод для корректной работы AbstractMatrix
     *
     * @param matrix основная матрица
     * @return вектор-столбец
     */
    @Override
    protected VectorC newMatrix(Matrix matrix) {
        return new VectorC(matrix);
    }

    /**
     * Конструктор вектор-столбец
     *
     * @param matrix общая матрица
     */
    protected VectorC(Matrix matrix) {
        super(matrix.getRows(), matrix.getCols(), matrix.getBase());
        validateSquare(matrix.getRows(), matrix.getCols());
    }

    /**
     * Проверка корректности значений
     *
     * @param row строки
     * @param col столбцы
     */
    private void validateSquare(int row, int col) {
        if (col != 1) {
            throw new IllegalArgumentException("Некорректное значение для количества столбцов");
        }
    }

    /**
     * Перемножение вектор-столбца и вектор-строки
     *
     * @param vector вектор-множитель
     * @return прямоугольная матрица
     */
    public RecMatrix multiplied(VectorR vector) {
        Matrix result = getMatrix().multiplied(new Matrix(vector.getRows(), vector.getCols(), vector.getBase()));
        return new RecMatrix(result);
    }


    public VectorC normalize() {
        return new VectorC(getMatrix().normalize());
    }

    public double getLength() {
        return getMatrix().getLength();
    }

    public VectorC crossProduct(VectorC vector) {
        return new VectorC(getMatrix().crossProduct(vector.getMatrix()));
    }
}
