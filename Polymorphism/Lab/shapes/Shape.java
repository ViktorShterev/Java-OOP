package Polymorphism.Lab.shapes;

public abstract class Shape {

    private Double perimeter;
    private Double area;


    public abstract Double calculatePerimeter();
    public abstract Double calculateArea();

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setArea(Double area) {
        this.area = area;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    public Double getArea() {
        return area;
    }
}
