package task4;

public class Square extends Shape{
    private double side;

    public Square(double side){
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side*side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}
