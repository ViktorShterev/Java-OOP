package WorkingWithAbstraction.Lab.PointInRectangle;

public class Rectangle {
    private final Point A;
    private final Point C;

    public Rectangle(Point A, Point C) {
        this.A = A;
        this.C = C;
    }
    public boolean isInside(Point p) {
        return p.isGreaterOrEqual(A) && p.isLessOrEqual(C);
    }
}
