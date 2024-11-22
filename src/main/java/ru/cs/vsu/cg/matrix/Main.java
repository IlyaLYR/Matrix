package ru.cs.vsu.cg.matrix;

import ru.cs.vsu.cg.matrix.typesMatrix.Matrix2D;
import ru.cs.vsu.cg.matrix.typesMatrix.Matrix3D;
import ru.cs.vsu.cg.matrix.typesMatrix.Matrix4D;

public class Main {

    public static void main(String[] args) {
        Matrix2D matrix = new Matrix2D(true);
        Matrix3D matrix3d = new Matrix3D(true);
        Matrix4D matrix4D = new Matrix4D(true);
        matrix.print();
        matrix3d.print();
        matrix4D.print();

    }
}
