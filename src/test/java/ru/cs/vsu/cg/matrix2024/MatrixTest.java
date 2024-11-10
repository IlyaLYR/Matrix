package ru.cs.vsu.cg.matrix2024;

import org.junit.jupiter.api.Test;
import ru.cs.vsu.cg.matrix2024.matrix.Matrix;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {


    @Test
    void getRows() {
        final Matrix m = new Matrix(2, 3, new double[]{1, 2, 3, 4, 5, 6});
        assertEquals(2, m.getRows());
    }

    @Test
    void getCols() {
        final Matrix m = new Matrix(2, 3, new double[]{1, 2, 3, 4, 5, 6});
        assertEquals(3, m.getCols());
    }

    @Test
    void transpose() {
        final Matrix start1 = new Matrix(2, 4, new double[]{1, 2, 3, 4, 5, 6, 7, 8});
        start1.transpose();
        final Matrix result1 = new Matrix(4, 2, new double[]{1, 5, 2, 6, 3, 7, 4, 8});
        assertArrayEquals(start1.getBase(), result1.getBase());
        assertEquals(start1.getRows(), result1.getRows());
        assertEquals(start1.getCols(), result1.getCols());
    }



    @Test
    void transposed() {
        final Matrix start1 = new Matrix(2, 4, new double[]{1, 2, 3, 4, 5, 6, 7, 8});
        start1.transpose();
        final Matrix result1 = new Matrix(4, 2, new double[]{1, 5, 2, 6, 3, 7, 4, 8});
        assertArrayEquals(start1.getBase(), result1.getBase());
        assertEquals(start1.getRows(), result1.getRows());
        assertEquals(start1.getCols(), result1.getCols());
    }

    @Test
    void multiplication() {
    }

    @Test
    void multiply() {
    }

    @Test
    void testMultiply() {
    }

    @Test
    void addition() {
    }

    @Test
    void add() {
    }
}