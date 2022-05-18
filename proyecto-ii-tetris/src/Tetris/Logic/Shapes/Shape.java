package Tetris.Logic.Shapes;

import Tetris.Logic.Point2D;
import java.awt.Color;

public interface Shape {
    public Point2D[] move(Point2D dxy);
    public Point2D[] getInitialShape();
    public void rotateRigth();
    public void rotateLeft();
    public Color getFillColor();
    public Color getBorderColor();
    public void reset();
}
