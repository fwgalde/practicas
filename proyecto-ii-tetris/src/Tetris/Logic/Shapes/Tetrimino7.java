package Tetris.Logic.Shapes;

import Tetris.Logic.Point2D;
import java.awt.Color;

public class Tetrimino7 implements Shape {
    private static final int N_ROTATIONS = 4;
    private Color fillColor;
    private Color borderColor;
    private int nTiles;
    private Point2D[][] rotation;
    private int currentRotationIndex;

    public Tetrimino7() {
        this.nTiles = 4;
        this.fillColor = new Color(240, 0, 0);
        this.borderColor = new Color(250, 186, 186);
        this.currentRotationIndex = 0;
        this.rotation = new Point2D[Tetrimino7.N_ROTATIONS][this.nTiles];
 
        // Rotate 0 degrees 
        this.rotation[0] = new Point2D[] {
            new Point2D(0, 0),
            new Point2D(1, 0),
            new Point2D(1, 1),
            new Point2D(2, 1)
        };
        // Rotate 90 degrees 
        this.rotation[1] = new Point2D[]{
            new Point2D(1, 0),
            new Point2D(1, 1),
            new Point2D(0, 1),
            new Point2D(0, 2)
        };
        // Rotate 180 degrees 
        this.rotation[2] = new Point2D[]{
            new Point2D(0, 0),
            new Point2D(1, 0),
            new Point2D(1, 1),
            new Point2D(2, 1)
        };
        // Rotate 270 degrees
        this.rotation[3] = new Point2D[]{
            new Point2D(1, 0),
            new Point2D(1, 1),
            new Point2D(0, 1),
            new Point2D(0, 2)
        };
    }

    public void rotateRigth() {
        this.currentRotationIndex = (this.currentRotationIndex + 1) % Tetrimino7.N_ROTATIONS;
    }

    public void rotateLeft() {
        this.currentRotationIndex = (Tetrimino7.N_ROTATIONS + this.currentRotationIndex - 1) % Tetrimino7.N_ROTATIONS;
    }

    public Point2D[] getInitialShape() {
        // Used to clone the points
        return this.move(new Point2D());
    }

    public Point2D[] move(Point2D dxy) {
        Point2D[] newLocation = new Point2D[this.nTiles];
        for (int i = 0; i < newLocation.length; i++) {
            newLocation[i] = this.rotation[this.currentRotationIndex][i].add(dxy);
        }

        return newLocation;
    }

    public Color getFillColor(){
        return this.fillColor;
    }

    public Color getBorderColor(){
        return this.borderColor;
    }

    public void reset() {
        this.currentRotationIndex = 0;
    }
}
