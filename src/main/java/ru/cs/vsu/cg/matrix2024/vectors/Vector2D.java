package ru.cs.vsu.cg.matrix2024.vectors;


/**
 * Вектор 2D
 */
public class Vector2D {
    private Vector vector;

    /**
     * Конструктор Вектора2D
     *
     * @param base значения
     */
    public Vector2D(double[] base) {
        vector = new Vector(2, base);
    }

    /**
     * Конструктор нулевого вектора
     */
    public Vector2D() {
        vector = new Vector(2);
    }


    /**
     * Конструктор Вектора2D на основе общего вектора
     * @param vector основной вектор
     */
    private Vector2D(Vector vector) {
        setVector(vector);
    }

    /*
      Геттеры и сеттеры
     */

    /**
     * Получить основной вектор
     *
     * @return основная вектор
     */
    public Vector getVector() {
        return vector;
    }

    /**
     * Изменить основной вектор
     *
     * @param vector новый основной вектор
     */
    private void setVector(Vector vector) {
        this.vector = new Vector(vector.getBase());
    }

    /**
     * Количество строк в векторе
     * @return количество строк
     */
    public int getRows(){
        return getVector().getRows();
    }

    /**
     * Количество столбцов векторе
     * @return количество столбцов
     */
    public int getColumns(){
        return getVector().getCols();
    }

    /**
     * Вывод вектора в консоль в виде
     * [A11, A12,
     * A21, A22]
     */
    public void print() {
        getVector().print();
    }
    /**
     * Транспонировать текущий вектор
     */
    public void transpose() {
        getVector().transpose();
    }

    /**
     * Перемножение Векторов
     *
     * @param vector вектор-множитель
     * @return результат перемножения векторов
     */
    public Vector2D multiply(Vector vector) {
        return new Vector2D(getVector().multiply(vector));
    }
    /**
     * Умножение вектора на число
     *
     * @param number множитель
     * @return вектор, результат перемножения числа и вектора
     */
    public Vector2D multiply(double number) {
        return new Vector2D(getVector().multiply(number));
    }
    /**
     * Сложение Векторов
     *
     * @param vector вектор-слагаемое
     * @return результат сложения двух векторов
     */
    public Vector2D add(Vector vector) {
        return new Vector2D(getVector().add(vector));
    }

    /**
     * Вычитание двух векторов
     *
     * @param vector вектор-вычитаемое
     * @return результат вычитания двух векторов
     */
    public Vector2D subtract(Vector vector) {
        return new Vector2D(getVector().subtract(vector));
    }

    /**
     * Вычислить длину вектора
     *
     * @return длинна вектора
     */
    public double length() {
        return getVector().length();
    }

    /**
     * Нормализация вектора
     *
     * @return нормализованный вектор
     */
    public Vector2D normalizedVector() {
        return new Vector2D(getVector().normalizedVector());
    }

    /**
     * Нормализация текущего вектора
     */
    public void normalizeVector() {
        setVector(getVector().normalizedVector());
    }
}