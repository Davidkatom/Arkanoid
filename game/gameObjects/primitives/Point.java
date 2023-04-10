package game.gameObjects.primitives;

/**
 * @author David Shnaiderov - 209198308
 * GameLevel.GameObjects.Primitives.Point
 * User ID - shnaidd1
 */
public class Point {
    private static final double EPSILON = 10E-3;

    private final double x;
    private final double y;

    /**
     * Constructor.
     *
     * @param x - x point
     * @param y - y point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    /**
     * return the distance of this
     * point to the other point.
     *
     * @param other - the other point for the distance
     * @return distance to point
     */
    public double distance(Point other) {
        double xDist = Math.pow(this.x - other.getX(), 2);
        double yDist = Math.pow(this.y - other.getY(), 2);
        return Math.sqrt(xDist + yDist);
    }

    /**
     * return true is the points are equal, false otherwise.
     *
     * @param other - GameLevel.GameObjects.Primitives.Point to compare to
     * @return - true or false
     */
    public boolean equals(Point other) {
        return Math.abs(other.getX() - this.getX()) <= EPSILON && Math.abs(other.getY() - this.getY()) <= EPSILON;
    }

    /**
     * Return the x value of this point.
     *
     * @return x value
     */
    public double getX() {
        return this.x;
    }

    /**
     * Return the y value of this point.
     *
     * @return t value
     */
    public double getY() {
        return this.y;
    }

}