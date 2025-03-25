package Polymorphism.Lab.shapes;

public class Rectangle extends Shape {

    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public Double calculatePerimeter() {
        if (super.getPerimeter() == null) {
            super.setPerimeter(2 * (this.height + this.width));
        }
        return super.getPerimeter();
    }

    @Override
    public Double calculateArea() {
        if (super.getArea() == null) {
            super.setArea(this.height * this.width);
        }
        return super.getArea();
    }

    public final Double getHeight() {
        return height;
    }

    public final Double getWidth() {
        return width;
    }
}
