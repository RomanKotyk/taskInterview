package task4;

import java.util.Comparator;

public abstract class Shape implements Comparable<Shape> {
    public abstract double calculateArea();

    @Override
    public int compareTo(Shape o) {
        return this.calculateArea()<o.calculateArea()?-1:1;
    }
}
