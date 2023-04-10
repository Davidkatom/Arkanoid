package game.gameObjects.primitives;

/**
 * @author David Shnaiderov - 209198308
 * GameLevel.GameObjects.Primitives.Velocity
 * User ID - shnaidd1
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * Constructor.
     *
     * @param angle - received angle
     * @param speed - received speed
     * @return - GameLevel.GameObjects.Primitives.Velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double radians = Math.toRadians(angle);
        double dy = speed * Math.cos(radians) * -1;
        double dx = speed * Math.sin(radians);
        return new Velocity(dx, dy);
    }

    /**
     * Constructor.
     *
     * @param dx - velocity x component
     * @param dy - velocity y component
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Applies velocity to GameLevel.GameObjects.Primitives.Point.
     *
     * @param p - point
     * @return - new point
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     * Gets dx value.
     *
     * @return dx
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * Gets dy value.
     *
     * @return dy
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * Sets dx value.
     *
     * @param newDx - new value
     */
    @SuppressWarnings("unused")
    public void setDx(double newDx) {
        this.dx = newDx;
    }

    /**
     * Sets dy value.
     *
     * @param newDy - new value
     */
    @SuppressWarnings("unused")
    public void setDy(double newDy) {
        this.dy = newDy;
    }
}
