package task4;

public class Rectangle extends Shape{
    private double height;
    private double width;

    public Rectangle(double height, double width){
        this.height = height;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return height*width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}
