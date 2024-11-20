package ru.cs.vsu.cg.matrix.core;

import ru.cs.vsu.cg.matrix.types.RecMatrix;
import ru.cs.vsu.cg.matrix.types.SquareMatrix;
import ru.cs.vsu.cg.matrix.types.VectorC;
import ru.cs.vsu.cg.matrix.types.VectorR;
import ru.cs.vsu.cg.matrix.typesMatrix.Matrix3D;
import ru.cs.vsu.cg.matrix.typesMatrix.Matrix4D;
import ru.cs.vsu.cg.matrix.typesVectors.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MatrixFactory {

    // Хранилище для фиксированных матриц (например, 5x5)
    private static final Map<String, Function<double[], AbstractMatrix<?>>> fixedMatrixRegistry = new HashMap<>();

    static {
        registerFixedMatrix("3x3", Matrix3D::new);
        registerFixedMatrix("4x4", Matrix4D::new);
        registerFixedMatrix("2row", Vector2R::new);
        registerFixedMatrix("3row", Vector3R::new);
        registerFixedMatrix("4row", Vector4R::new);
        registerFixedMatrix("2col", Vector2C::new);
        registerFixedMatrix("3col", Vector3C::new);
        registerFixedMatrix("4col", Vector4C::new);
    }

    /**
     * Регистрация новой фиксированной матрицы.
     */
    public static void registerFixedMatrix(String key, Function<double[], AbstractMatrix<?>> creator) {
        fixedMatrixRegistry.put(key, creator);
    }

    public static AbstractMatrix<?> createMatrix(int rows, int cols, double[] base) {
        String fixedKey = rows + "x" + cols;
        if (fixedMatrixRegistry.containsKey(fixedKey)) {
            return fixedMatrixRegistry.get(fixedKey).apply(base);
        }
        if (rows == cols) {
            return new SquareMatrix(rows, base);
        }
        if (cols == 1) {
            return new VectorC(rows, base);
        } else if (rows == 1) {
            return new VectorR(cols, base);
        }
        return new RecMatrix(rows, cols, base);
    }
}
