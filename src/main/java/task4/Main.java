package task4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int side = 3;
        int radius = 1;
        int base = 5;
        int height = 2;
        ArrayList<Shape> shapes = new ArrayList<>();

        shapes.add(new Square(side));
        shapes.add(new Circle(radius));
        shapes.add(new Triangle(base, height));

        Collections.sort(shapes);

        for(Shape shape : shapes){
            System.out.println(shape);
        }
    }
}
