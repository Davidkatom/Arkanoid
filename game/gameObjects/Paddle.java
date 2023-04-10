package game.gameObjects;

import game.GameLevel;
import setting.GameEnvironment;
import game.gameObjects.primitives.Point;
import game.gameObjects.primitives.Rectangle;
import game.gameObjects.primitives.Velocity;
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * @author David Shnaiderov - 209198308
 * Controlls the GameLevel.Paddle
 * User ID - shnaidd1
 */
public class Paddle implements Sprite, Collidable {

    private static final int HEIGHT = 20;
    private static final int RATIO = 20;

    private static final int ANGLE = 30;

    private final int width;
    private final double speed;
    private final biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private final Color color;
    private Point location;


    /**
     * Constructor.
     *
     * @param gui   Gui
     * @param point Origin
     * @param speed Paddle speed
     * @param width Paddle width
     */
    public Paddle(GUI gui, Point point, int speed, int width) {
        this.keyboard = gui.getKeyboardSensor();
        location = point;
        color = new Color(0x940F20);
        rectangle = new Rectangle(location, width, HEIGHT);
        this.speed = speed;
        this.width = width;
    }

    /**
     * Moves left.
     */
    public void moveLeft() {
        if (location.getX() - GameLevel.MARGIN - speed < 0) {
            this.location = new Point(GameLevel.MARGIN, location.getY());
        }
        this.move(new Point(location.getX() - speed, location.getY()));
    }

    /**
     * Moves GameLevel.Paddle.
     *
     * @param point Origin
     */
    private void move(Point point) {
        this.location = point;
        this.rectangle = new Rectangle(location, width, HEIGHT);
    }

    /**
     * Moves right.
     */
    public void moveRight() {
        if (location.getX() + speed + width >= GameEnvironment.SCREEN_WIDTH - GameLevel.MARGIN) {
            this.location = new Point(GameEnvironment.SCREEN_WIDTH - width - GameLevel.MARGIN, location.getY());
        }
        this.move(new Point(location.getX() + speed, location.getY()));
    }

    /**
     * Receives Input.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * Draws GameLevel.Paddle.
     *
     * @param d DrawSurface
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) location.getX(), (int) location.getY(), width, HEIGHT);
        d.setColor(Color.black);
        d.drawRectangle((int) location.getX(), (int) location.getY(), width, HEIGHT);
    }

    /**
     * Gets Collision GameLevel.GameObjects.Primitives.Rectangle.
     *
     * @return GameLevel.GameObjects.Primitives.Rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * Change ball velocity.
     *
     * @param collisionPoint  - GameLevel.GameObjects.Primitives.Point
     * @param currentVelocity - GameLevel.GameObjects.Primitives.Velocity
     * @param hitter - GameLevel.GameObjects.Ball hitting
     * @return new GameLevel.GameObjects.Primitives.Velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (rectangle.getTopX().pointOnLine(collisionPoint) && currentVelocity.getDy() > 0) {
            int zone = getZone(collisionPoint);
            if (zone == 2) {
                return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * -1);
            } else {
                double absVel = Math.sqrt(Math.pow(currentVelocity.getDx(), 2) + Math.pow(currentVelocity.getDy(), 2));
                return Velocity.fromAngleAndSpeed(-ANGLE * 2 + zone * ANGLE, absVel);
            }
        }
        if (rectangle.getTopX().pointOnLine(collisionPoint)) {
            return new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy());
        }

        if (Math.abs(rectangle.getLeftY().start().getX() - collisionPoint.getX()) < ANGLE
                && currentVelocity.getDx() > 0) {
            return new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy());
        }
        if (Math.abs(rectangle.getRightY().start().getX() - collisionPoint.getX()) < ANGLE
                && currentVelocity.getDx() < 0) {
            return new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy());

        }
        return currentVelocity;
    }

    /**
     * Gets collision Zone.
     *
     * @param collisionPoint GameLevel.GameObjects.Primitives.Point
     * @return int
     */
    private int getZone(Point collisionPoint) {
        return (int) (collisionPoint.getX() - rectangle.getLeftY().start().getX()) / RATIO;
    }

    /**
     * Add this paddle to the game.
     *
     * @param g GameLevel
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

}