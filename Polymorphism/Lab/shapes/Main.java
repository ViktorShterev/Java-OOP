package Polymorphism.Lab.shapes;;

public class Main {
    public static void main(String[] args) {

        Shape rectangle = new Rectangle(2.0, 2.0);
        Shape circle = new Circle(2.5);

        printShape(rectangle);
        printShape(circle);
    }

    private static void printShape(Shape shape) {
        System.out.println(shape.calculateArea());
        System.out.println(shape.calculatePerimeter());
    }
}
