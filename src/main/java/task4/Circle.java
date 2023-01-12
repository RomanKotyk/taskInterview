package task4;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return radius*radius*Math.PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
