package ru.cs.vsu.cg.matrix2024;

public class Vector extends Matrix {
    private String type = "Vector-column";

    Vector(double[] base) {
        super(base.length, 1, base);
    }

    protected Vector(int row, double[] base) {
        super(row, 1, base);
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    @Override
    public void transpose() {
        super.transpose();
        switch (type) {
            case "Vector-column": {
                setType("Vector-row");
                break;
            }
            case "Vector-row":
                setType("Vector-column");
        }
    }

    @Override
    public void print() {
        super.print();
        System.out.print(getType() + "\n");
    }

    public double length() {
        double sum = 0;
        for (double i : getBase()) {
            sum += i * i;
        }
        return Math.sqrt(sum);
    }

    public Vector normalizedVector() {
        double[] base = new double[getBase().length];
        double length = length();
        for (int i = 0; i < getBase().length; i++) {
            base[i] = getBase()[i] / length;
        }
        return new Vector(base);
    }

    public void normalizeVector() {
        double length = length();
        for (int i = 0; i < getBase().length; i++) {
            getBase()[i] = getBase()[i] / length;
        }
    }

    public double scalarProduct(Vector v, double angle) {
        return v.length() * this.length() * Math.cos(angle);
    }

    public static double scalarProduct(Vector v1, Vector v2, double angle) {
        return v1.length() * v2.length() * Math.cos(angle);
    }
}
