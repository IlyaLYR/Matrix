# Matrix Library

## Описание

Эта библиотека предоставляет удобный интерфейс для работы с матрицами и векторами различных размеров. Поддерживаются как
стандартные операции (сложение, умножение, транспонирование), так и специализированные, такие как нормализация и
вычисление длины векторов.

Библиотека структурирована так, чтобы обеспечить модульность, расширяемость и удобство использования.

---

## Основные классы

### 1. **`Matrix2D`, `Matrix3D`, `Matrix4D`**

Классы для работы с матрицами фиксированной размерности (2x2, 3x3, 4x4).

#### Основные методы:

- **`transpose()`**  
  Транспонирует матрицу.
- **`pows(int n)`**  
  Возводит матрицу в степень `n`.
- **`multiplied(Matrix other)`**  
  Умножает текущую матрицу на другую.
- **`added(Matrix other)`**  
  Складывает текущую матрицу с другой.
- **`subtracted(Matrix other)`**  
  Вычитает другую матрицу из текущей.

#### Конструкторы:

- `Matrix2D(double[][] base)` — создание матрицы из двумерного массива.
- `Matrix2D(boolean unit)` — создание единичной матрицы.

---

### 2. **`SquareMatrix`**

Класс для работы с квадратными матрицами.

#### Основные методы:

- **`transpose()`**  
  Транспонирует квадратную матрицу.
- **`multiplied(SquareMatrix matrix)`**  
  Умножает квадратную матрицу на другую квадратную матрицу.
- **`pows(int n)`**  
  Возводит квадратную матрицу в степень `n`.

#### Конструкторы:

- `SquareMatrix(int size, double[][] base)` — создание квадратной матрицы из массива заданного размера.
- `SquareMatrix(int size, boolean unit)` — создание единичной матрицы.

---

### 3. **`RecMatrix`**

Класс для работы с прямоугольными матрицами.

#### Основные методы:

- **`transpose()`**  
  Транспонирует прямоугольную матрицу.
- **`multiplied(RecMatrix matrix)`**  
  Умножает текущую матрицу на другую прямоугольную матрицу.

#### Конструкторы:

- `RecMatrix(int rows, int cols, double[][] base)` — создание прямоугольной матрицы из массива.
- `RecMatrix(int rows, int cols, boolean unit)` — создание матрицы с заданным количеством строк и столбцов.

---

### 4. **`VectorC`, `VectorR`**

Классы для работы с векторами-столбцами (`VectorC`) и векторами-строками (`VectorR`).

#### Основные методы:

- **`normalize()`**  
  Нормализует вектор (приводит длину к единице).
- **`getLength()`**  
  Возвращает длину вектора.
- **`multiplied(Vector other)`**  
  Выполняет умножение вектора на матрицу или другой вектор (скалярное произведение для вектора-столбца и строки).

#### Конструкторы:

- `VectorC(int size, double[] base)` — создание вектора-столбца.
- `VectorR(int size, double[] base)` — создание вектора-строки.

---

## Пример использования

```java
import ru.cs.vsu.cg.matrix.types.*;
import ru.cs.vsu.cg.matrix.typesMatrix.*;

public class Main {
    public static void main(String[] args) {
        // Создание 3x3 квадратной матрицы
        SquareMatrix matrix = new SquareMatrix(3, new double[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        // Транспонирование матрицы
        SquareMatrix transposed = matrix.transposed();
        System.out.println("Transposed Matrix: \n" + transposed);

        // Создание вектора-столбца
        VectorC vector = new VectorC(3, new double[]{1, 2, 3});

        // Умножение матрицы на вектор
        VectorC resultVector = matrix.multiplied(vector);
        System.out.println("Result Vector: \n" + resultVector);

        // Нормализация вектора
        VectorC normalized = vector.normalize();
        System.out.println("Normalized Vector: \n" + normalized);
    }
}
```

## Документация

Полное описание доступных классов и методов можно найти в [документации]().


