package Tetris.Logic;

public class Point2D {
    private int x;
    private int y;

    public Point2D() {
        this(0, 0);
    }
    
    public Point2D(int x, int y) {
        this.x = x;
	this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
	this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /*
     * Regresa un nuevo punto en donde el resultado es la suma coordenada
     * a coordenada del objecto que invoca y de la instacia other.
     */
    public Point2D add(Point2D other) {
        int xOther = other.getX();
	int yOther = other.getY();
	return new Point2D(x + xOther, y + yOther);
    }
}
