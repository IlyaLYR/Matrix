package ru.cs.vsu.cg.matrix.types;

import ru.cs.vsu.cg.matrix.core.AbstractMatrix;

/**
 * Вектор-строка
 */
public class VectorR extends AbstractMatrix<VectorR> {
    /**
     * Конструктор нулевого вектора
     *
     * @param n количество элементов
     */
    public VectorR(int n) {
        super(1, n);
    }

    /**
     * Конструктор вектор-строки
     *
     * @param n    количество элементов
     * @param base элементы вектора
     */
    public VectorR(int n, double[] base) {
        super(1, n, base);
    }

    /**
     * Вспомогательный метод для AbstractMatrix
     *
     * @param matrix основная матрица
     * @return вектор-строка
     */
    @Override
    protected VectorR newMatrix(Matrix matrix) {
        return new VectorR(matrix);
    }

    /**
     * Конструктор из общей матрицы
     *
     * @param matrix общая матрица
     */
    protected VectorR(Matrix matrix) {
        super(matrix.getRows(), matrix.getCols(), matrix.getBase());
        validateSquare(matrix.getRows(), matrix.getCols());
    }

    /**
     * Перемножение вектор-строки и квадратной матрица
     *
     * @param matrix квадратная матрица
     * @return вектор-строка
     */
    public VectorR multiplied(SquareMatrix matrix) {
        Matrix result = getMatrix().multiplied(new Matrix(matrix.getRows(), matrix.getCols(), matrix.getBase()));
        return new VectorR(result);
    }

    /**
     * Перемножение вектор-строки и прямоугольной матрица
     *
     * @param matrix прямоугольная матрица
     * @return вектор-строка
     */
    public VectorR multiplied(RecMatrix matrix) {
        Matrix result = getMatrix().multiplied(new Matrix(matrix.getRows(), matrix.getCols(), matrix.getBase()));
        return new VectorR(result);
    }

    /**
     * Перемножение вектор-строки и вектор-столбца
     *
     * @param vector вектор-столбец
     * @return скаляр
     */
    public double multiplied(VectorC vector) {
        Matrix result = getMatrix().multiplied(new Matrix(vector.getRows(), vector.getCols(), vector.getBase()));
        return result.getBase()[0];
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

    public double getLength() {
        return getMatrix().getLength();
    }

    public VectorR normalize() {
        return new VectorR(getMatrix().normalize());
    }

}
