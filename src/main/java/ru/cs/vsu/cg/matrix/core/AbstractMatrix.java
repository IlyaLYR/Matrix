/**
 * * Пакет абстракций для библиотеки Matrix
 */
package ru.cs.vsu.cg.matrix.core;

import java.util.Arrays;
import java.util.Objects;

/**
 * Класс обертка для основных типов ->Прямоугольная, Квадратная, Вектор-строка, Вектор-столбец
 *
 * @param <T>
 */
public abstract class AbstractMatrix<T extends AbstractMatrix<T>> {

    /**
     * Объект Matrix - основой исполнитель
     */
    protected Matrix matrix;

    /**
     * Нулевая матрица
     *
     * @param row количество строк
     * @param col количество столбцов
     */
    public AbstractMatrix(int row, int col) {
        matrix = new Matrix(row, col);
    }

    /**
     * Конструктор абстрактной матрицы
     *
     * @param row  строки
     * @param col  столбцы
     * @param base одномерный массив - тело матрицы
     */
    public AbstractMatrix(int row, int col, double[] base) {
        matrix = new Matrix(row, col, base);
    }

    /**
     * Конструктор абстрактной матрицы
     *
     * @param row  строки
     * @param col  столбцы
     * @param base двумерный массив - тело матрицы
     */
    public AbstractMatrix(int row, int col, double[][] base) {
        matrix = new Matrix(row, col, base);
    }

    /**
     * Конструктор единичной матрицы
     *
     * @param row  строки
     * @param col  столбцы
     * @param unit flag
     */
    public AbstractMatrix(int row, int col, boolean unit) {
        matrix = new Matrix(row, col, unit);
    }

    /**
     * Класс Matrix (основная логика в данном классе)
     *
     * @author IlyaLYR
     */

    protected static class Matrix {
        /**
         * Строки
         */
        private int rows;
        /**
         * Столбцы
         */
        private int cols;
        /**
         * Значения в матрице
         */
        private double[] base;


        /**
         * Метод инициализации параметров матрицы
         *
         * @param rows строки
         * @param cols столбцы
         * @param base значения
         */
        public void initialize(int rows, int cols, double[] base) {
            setRows(rows);
            setCols(cols);
            setBase(base);
        }

        /**
         * Основной конструктор Матрицы N*M
         *
         * @param rows количество строк
         * @param cols количество столбцов
         * @param base тело матрицы
         */
        public Matrix(int rows, int cols, double[] base) {
            initialize(rows, cols, base);

        }
        //Что-то сгенерировала IDEA

        /**
         * Сравнение полей двух матриц
         *
         * @param o сравниваемый объект
         * @return true or false
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Matrix matrix = (Matrix) o;
            return rows == matrix.rows && cols == matrix.cols && Arrays.equals(base, matrix.base);
        }

        /**
         * HASH-код
         *
         * @return значение
         */
        @Override
        public int hashCode() {
            return Objects.hash(rows, cols, Arrays.hashCode(base));
        }

        /**
         * Красивый вывод матрицы
         *
         * @return Текст
         */
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[\n");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    sb.append(String.format("%10.2f ", get(i, j)));
                }
                sb.append("\n");
            }
            sb.append("]");
            return sb.toString();
        }

        /**
         * Основной конструктор Матрицы N*M
         *
         * @param rows количество строк
         * @param cols количество столбцов
         * @param base тело матрицы (двумерный массив)
         */
        public Matrix(int rows, int cols, double[][] base) {
            initialize(rows, cols, unwrap(base));
        }

        /**
         * Конструктор нулевой матрицы
         *
         * @param rows количество строк
         * @param cols количество столбцов
         */
        public Matrix(int rows, int cols) { //Нулевая матрица
            initialize(rows, cols, new double[rows * cols]);
        }

        /**
         * Конструктор единичной матрицы
         *
         * @param rows количество строк
         * @param cols количество столбцов
         */
        public Matrix(int rows, int cols, boolean unit) {//Единичная матрица
            this(rows, cols);
            if (unit) {
                this.setBase(this.createUnitMatrix().getBase());
            }
        }

        /*
        Геттеры и сеттеры
         */

        /**
         * Получение элемента матрицы по индексам
         *
         * @param row строка
         * @param col столбец
         * @return значение
         */
        public double get(int row, int col) {
            validateIndex(row, col);
            return base[row * cols + col];
        }

        /**
         * Изменение элемента матрицы по индексам
         *
         * @param row   строка
         * @param col   столбец
         * @param value значение
         */

        public void set(int row, int col, double value) {
            validateIndex(row, col);
            base[row * cols + col] = value;
        }

        /**
         * Метод проверки корректности индексов
         *
         * @param row строка
         * @param col столбец
         */
        private void validateIndex(int row, int col) {
            if (row < 0 || row >= rows || col < 0 || col >= cols) {
                throw new IndexOutOfBoundsException("Invalid index");
            }
        }

        /**
         * Получить количество строк для данной матрицы
         *
         * @return количество строк [>0]
         */
        public int getRows() {
            return rows;
        }

        /**
         * Получить количество столбцов для данной матрицы
         *
         * @return количество столбцов [>0]
         */
        public int getCols() {
            return cols;
        }

        /**
         * Получить тело матрицы
         *
         * @return double[] тело матрицы
         */
        public double[] getBase() {
            return base.clone();
        }

        /**
         * Установить значение строк в матрице
         *
         * @param rows количество строк [>0]
         */
        private void setRows(int rows) {
            if (rows <= 0) { //Обработка некорректных значений
                throw new IllegalArgumentException("Incorrect arguments for rows");
            }
            this.rows = rows;
        }

        /**
         * Установить значение столбцов в матрице
         *
         * @param cols количество столбцов [>0]
         */
        private void setCols(int cols) {
            if (cols <= 0) {
                throw new IllegalArgumentException("Incorrect arguments for cols");
            }
            this.cols = cols;
        }

        /**
         * Изменение тела матрицы (новый массив)
         *
         * @param base новый массив
         */
        private void setBase(double[] base) {
            if (base.length != (rows * cols)) {
                throw new IllegalArgumentException("Incorrect array size in " + this.getClass().getSimpleName());
            }
            this.base = base.clone();
        }

        /**
         * Вывод матрицы в консоль в виде <p>
         * <p>[A11, A12,<p>
         * A21, A22]
         */
        public void print() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.printf("%10.2f ", base[i * cols + j]);
                }
                System.out.println();
            }
            System.out.printf("Rows: %d, Cols: %d\n", rows, cols);
        }

        /**
         * Метод для транспонирования матрицы
         *
         * @return транспонированная матрица
         */
        public Matrix transposed() {
            double[] transposed = new double[getCols() * getRows()];
            for (int i = 0; i < getRows(); i++) {
                for (int j = 0; j < getCols(); j++) {
                    transposed[j * getRows() + i] = get(i, j);
                }
            }
            return new Matrix(getCols(), getRows(), transposed);
        }

        /**
         * Метод для перемножения матриц
         *
         * @param matrix матрица-множитель
         * @return произведение матриц
         */
        public Matrix multiplied(Matrix matrix) {
            if (getCols() != matrix.getRows()) {
                throw new IllegalArgumentException("Количество столбцов первой матрицы должно совпадать с количеством строк второй.");
            }
            double[] result = new double[getRows() * matrix.getCols()];
            for (int i = 0; i < getRows(); i++) {
                for (int j = 0; j < matrix.getCols(); j++) {
                    double sum = 0;
                    for (int k = 0; k < getCols(); k++) {
                        sum += get(i, k) * matrix.get(k, j);
                    }
                    result[i * matrix.getCols() + j] = sum;
                }
            }
            return new Matrix(getRows(), matrix.getCols(), result);
        }

        /**
         * Умножение матрицы на число
         *
         * @param number множитель
         * @return результат умножения - матрица
         */
        public Matrix multiplied(double number) {
            double[] newMatrix = new double[getRows() * getCols()];
            for (int i = 0; i < getBase().length; i++) {
                newMatrix[i] = getBase()[i] * number;
            }
            return new Matrix(getRows(), getCols(), newMatrix);
        }

        /**
         * Сложение матриц
         *
         * @param matrix слагаемое
         * @return результат сложения
         */
        public Matrix added(Matrix matrix) {
            if (getRows() != matrix.getRows() || getCols() != matrix.getCols()) {
                throw new IllegalArgumentException("Матрицы должны быть одинакового размера для сложения.");
            }
            double[] result = new double[getRows() * getCols()];
            for (int i = 0; i < getBase().length; i++) {
                result[i] = getBase()[i] + matrix.getBase()[i];
            }
            return new Matrix(getRows(), getCols(), result);
        }

        /**
         * Вычитание матриц
         *
         * @param matrix вычитаемое
         * @return результат вычитания - матрица
         */
        public Matrix subtracted(Matrix matrix) {
            return added(matrix.multiplied(-1));
        }

        /**
         * Деление матрицы на число
         *
         * @param number делитель
         * @return результат матрица
         */
        public Matrix divided(double number) {
            if (number == 0) {
                throw new IllegalArgumentException("Деление на ноль недопустимо.");
            }
            return multiplied(1 / number);
        }

        /**
         * Создание единичной матрицы на основе текущей
         *
         * @return единичная матрица
         */
        public Matrix createUnitMatrix() {
            if (this.getRows() != this.getCols()) {
                throw new IllegalArgumentException("The number of rows and columns does not match");
            }
            double[] unitMatrix = new double[getRows() * getCols()];
            for (int i = 0; i < getCols(); i++) {
                unitMatrix[i * getRows() + i] = 1;
            }
            return new Matrix(getRows(), getCols(), unitMatrix);
        }

        /**
         * Приватный метод для преобразования двумерного массива в одномерный
         *
         * @param base двумерный массив
         * @return одномерный массив
         */
        private static double[] unwrap(double[][] base) {
            double[] result = new double[base.length * base[0].length];
            int i = 0;
            for (double[] doubles : base) {
                for (double aDouble : doubles) {
                    result[i] = aDouble;
                    i++;
                }
            }
            return result;
        }

        /**
         * Метод для возведения матрицы в степень
         *
         * @param n степень, в которую нужно возвести матрицу
         * @return матрица, возведённая в степень
         */
        public Matrix pows(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Степень не может быть отрицательной.");
            }
            if (n == 0) {
                return createUnitMatrix(); // A^0 = I (единичная матрица)
            }
            if (n == 1) {
                return this; // A^1 = A
            }

            Matrix result = createUnitMatrix();
            Matrix base = new Matrix(this.getRows(), this.getCols(), this.getBase());

            while (n > 0) {
                if (n % 2 == 1) { // Если степень нечётная
                    result = result.multiplied(base);
                }
                base = base.multiplied(base); // Квадрат матрицы
                n /= 2;
            }
            return result;
        }

    }

    //Геттеры сеттеры

    /**
     * Получить количество строк
     *
     * @return значение
     */
    public int getRows() {
        return matrix.getRows();
    }

    /**
     * Получить количество столбцов
     *
     * @return значение
     */
    public int getCols() {
        return matrix.getCols();
    }

    /**
     * Получит тело матрицы
     *
     * @return матрица - базовый объект
     */
    protected Matrix getMatrix() {
        return matrix;
    }

    /**
     * Изменить тело матрицы
     */
    protected void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    /**
     * Получить элементы по индексу
     *
     * @param row строка
     * @param col столбец
     * @return значение
     */
    public double get(int row, int col) {
        return matrix.get(row, col);
    }


    /**
     * Изменить значение по индексу
     *
     * @param row   строка
     * @param col   столбец
     * @param value значение
     */
    public void set(int row, int col, double value) {
        matrix.set(row, col, value);
    }

    /**
     * Вывод матрицы
     */
    public void print() {
        matrix.print();
    }

    /**
     * Метод -> обращение к фабрике для создания матрицы
     *
     * @param matrix основная матрица
     * @return конкретный объект матрицу
     */
    protected AbstractMatrix<?> newMatrix(Matrix matrix) {
        return MatrixFactory.createMatrix(matrix.rows, matrix.cols, matrix.base);
    }

    /**
     * Сложение матриц
     *
     * @param other слагаемое
     */
    public void add(T other) {
        setMatrix(matrix.added(other.getMatrix()));
    }

    /**
     * Сложение матриц
     *
     * @param other слагаемое
     * @return новая матрица - результат
     */
    public AbstractMatrix<?> added(T other) {
        return newMatrix(matrix.added(other.getMatrix()));
    }

    /**
     * Вычитание матриц
     *
     * @param other вычитаемое
     */
    public void subtract(T other) {
        setMatrix(matrix.subtracted(other.getMatrix()));
    }

    /**
     * Вычитание матриц
     *
     * @param other вычитаемое
     * @return новая матрица - результат
     */
    public AbstractMatrix<?> subtracted(T other) {
        return newMatrix(matrix.subtracted(other.getMatrix()));
    }

    /**
     * Умножение матрицы на число
     *
     * @param number множитель
     */
    public void multiply(double number) {
        setMatrix(matrix.multiplied(number));
    }

    /**
     * Умножение матрицы на число
     *
     * @param number множитель
     * @return новая матрица - результат
     */
    public AbstractMatrix<?> multiplied(double number) {
        return newMatrix(matrix.multiplied(number));
    }

    /**
     * Деление матрицы на число
     *
     * @param number делитель
     */
    public void divide(double number) {
        setMatrix(matrix.divided(number));
    }

    /**
     * Деление матрицы на число
     *
     * @param number делитель
     * @return новая матрица - результат
     */
    public AbstractMatrix<?> divided(double number) {
        return newMatrix(matrix.divided(number));
    }

    /**
     * Умножение матрицы на матрицу
     *
     * @param matrix множитель
     * @return новая матрица(возможна смена самого объекта)
     */
    public AbstractMatrix<?> multiplied(AbstractMatrix<?> matrix) {
        Matrix result = getMatrix().multiplied(matrix.getMatrix());
        return MatrixFactory.createMatrix(result.rows, result.cols, result.base); //Можно подавить матрицу в фабрику... сделаю.....
    }

    /**
     * Транспонирование матрицы
     *
     * @return транспонированная матрица
     */
    public AbstractMatrix<?> transposed() {
        Matrix result = getMatrix().transposed();
        return MatrixFactory.createMatrix(result.rows, result.cols, result.base);
    }

    /**
     * Вывод в консоль объекта
     *
     * @return текст
     */
    @Override
    public String toString() {
        return matrix.toString();
    }
}
