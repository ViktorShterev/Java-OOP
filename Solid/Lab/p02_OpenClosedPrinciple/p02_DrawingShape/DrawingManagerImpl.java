package Solid.Lab.p02_OpenClosedPrinciple.p02_DrawingShape;


import Solid.Lab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingManager;
import Solid.Lab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

public class DrawingManagerImpl implements DrawingManager {


    @Override
    public void draw(Shape shape) {
        if (shape instanceof Circle)
        {
            this.drawCircle((Circle)shape);
        }
            else if (shape instanceof Rectangle)
        {
            this.drawRectangle(((Rectangle)shape));
        }
    }
    public void drawCircle(Circle circle)
    {
        // Draw Circle
    }

    public void drawRectangle(Rectangle rectangle)
    {
        // Draw Rectangle
    }
}
