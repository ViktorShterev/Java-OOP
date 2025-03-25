package Polymorphism.Lab.shapes;

public class Circle extends Shape {

    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculatePerimeter() {
        if (super.getPerimeter() == null) {
            super.setPerimeter(2 * Math.PI * this.radius);
        }
        return super.getPerimeter();
    }

    @Override
    public Double calculateArea() {
        if (super.getArea() == null) {
            super.setArea(Math.PI * Math.pow(this.radius, 2));
        }
        return super.getArea();
    }

    public final Double getRadius() {
        return radius;
    }
}
