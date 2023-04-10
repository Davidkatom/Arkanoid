package game.gameObjects;

import java.awt.Color;

import setting.GameEnvironment;
import setting.CollisionInfo;
import game.gameObjects.primitives.Line;
import game.gameObjects.primitives.Point;
import game.gameObjects.primitives.Velocity;
import biuoop.DrawSurface;
import game.GameLevel;

/**
 * @author David Shnaiderov - 209198308
 * GameLevel.GameObjects.Ball Class
 * User ID - shnaidd1
 */

public class Ball implements Sprite {
    private static final int MARGIN = 7;
    private Point center;
    private final int radius;
    private final Color color;
    private Velocity velocity = new Velocity(0, 0);
    private final GameEnvironment environment;
    private CollisionInfo info;

    /**
     * Constructor.
     *
     * @param center      - Center GameLevel.GameObjects.Primitives.Point
     * @param r           - Radius.
     * @param color       - Color to paint
     * @param environment - GameLevel environment
     */
    public Ball(Point center, int r, java.awt.Color color, GameEnvironment environment) {
        this.center = center;
        this.radius = r;
        this.color = color;
        this.environment = environment;
        this.info = findCollision();


    }

    /**
     * Constructor.
     *
     * @param x           - x value
     * @param y           - y value
     * @param r           - Radius.
     * @param color       - Color to paint
     * @param environment - GameLevel environment
     */
    public Ball(double x, double y, int r, Color color, GameEnvironment environment) {
        this(new Point(x, y), r, color, environment);
    }

    /**
     * Gets x value.
     *
     * @return x value
     */
    public int getX() {
        return (int) center.getX();
    }

    /**
     * Gets y value.
     *
     * @return y value
     */
    public int getY() {
        return (int) center.getY();
    }


    /**
     * Gets color.
     *
     * @return color value
     */
    public java.awt.Color getColor() {
        return color;
    }

    /**
     * draw the ball on the given DrawSurface.
     *
     * @param surface - Surface to drawn on
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(getColor());
        surface.fillCircle(this.getX(), this.getY(), radius);
        surface.setColor(Color.black);
        surface.drawCircle(this.getX(), this.getY(), radius);
    }

    @Override
    public void timePassed() {
        moveOneStep();
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * Change velocity.
     *
     * @param v - new velocity
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * Change velocity.
     *
     * @param dx - x velocity
     * @param dy - y velocity
     */
    @SuppressWarnings("unused")
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * Returns velocity value.
     *
     * @return velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * Moves the ball one step in a given direction according to internal velocity.
     * <p>
     * value for screen
     */
    public void moveOneStep() {
        if (checkBoundaries()) {
            return;
        }
        if (info.getCollisionPoint() != null) {
            if (info.getCollisionPoint().distance(center) < MARGIN) {
                this.setVelocity(info.collisionObject().hit(this, info.getCollisionPoint(), getVelocity()));
            }
        }

        this.info = findCollision();
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * Checks if ball about to exit screen.
     *
     * @return true or false
     */
    private Boolean checkBoundaries() {
        if (this.center.getX() + velocity.getDx() < MARGIN
                || this.center.getX() + velocity.getDx() > GameEnvironment.SCREEN_WIDTH - MARGIN) {
            this.velocity = new Velocity(this.velocity.getDx() * (-1), this.velocity.getDy());
            return true;
        }
        if (this.center.getY() + velocity.getDy() < MARGIN
                || this.center.getY() + velocity.getDy() > GameEnvironment.SCREEN_HEIGHT - MARGIN) {
            this.velocity = new Velocity(this.velocity.getDx(), this.velocity.getDy() * (-1));
            return true;
        }
        return false;
    }

    /**
     * Finds next collision.
     * @return - GameSetting.CollisionInfo
     */
    public CollisionInfo findCollision() {
        Point a = center;
        double x = velocity.getDx() * GameEnvironment.SCREEN_WIDTH;
        double y = velocity.getDy() * GameEnvironment.SCREEN_WIDTH;
        Point b = new Point(this.getX() + x, this.getY() + y);
        Line trajectory = new Line(a, b, true);
        return new CollisionInfo(trajectory, environment);
    }

}