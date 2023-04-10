package game.gameObjects;

import game.GameLevel;
import game.gameObjects.primitives.Point;
import game.gameObjects.primitives.Rectangle;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import game.gameObjects.primitives.Velocity;

/**
 * @author David Shnaiderov - 209198308
 * GameLevel.GameObjects.Block Class
 * User ID - shnaidd1
 */

public class Block implements Collidable, Sprite, HitNotifier {
    private final Rectangle rectangle;
    private final Color color;
    private final List<HitListener> hitListeners = new ArrayList<>();
    private Boolean isFloor = false;
    private Boolean isBoundaries = false;

    /**
     * Constructor.
     *
     * @param upperLeft - origin point
     * @param width     - width
     * @param height    - height
     * @param color     - color
     */
    public Block(Point upperLeft, double width, double height, Color color) {
        rectangle = new Rectangle(upperLeft, width, height);
        this.color = color;

    }


    /**
     * Constructor.
     *
     * @param upperLeft - origin point
     * @param width     - width
     * @param height    - height
     */
    public Block(Point upperLeft, double width, double height) {
        this(upperLeft, width, height, Color.black);
    }

    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        if ((rectangle.getTopX().pointOnLine(collisionPoint) && currentVelocity.getDy() > 0)
                || (rectangle.getBottomX().pointOnLine(collisionPoint) && currentVelocity.getDy() < 0)) {
            return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * -1);
        }
        if ((rectangle.getLeftY().pointOnLine(collisionPoint) && currentVelocity.getDx() > 0)
                || ((rectangle.getRightY().pointOnLine(collisionPoint)) && currentVelocity.getDx() < 0)) {
            return new Velocity(currentVelocity.getDx() * -1, currentVelocity.getDy());
        }
        return currentVelocity;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        Point origin = this.rectangle.getTopX().start();
        d.fillRectangle((int) origin.getX(), (int) origin.getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
        if (!this.isFloor) {
            d.setColor(Color.black);
            d.drawRectangle((int) origin.getX(), (int) origin.getY(),
                    (int) rectangle.getWidth(), (int) rectangle.getHeight());
        }
    }

    @Override
    public void timePassed() {

    }

    /**
     * Set the properties of the block.
     *
     * @param floor bool isFloor
     */
    public void setFloorOrBoundaries(boolean floor) {
        this.isFloor = floor;
        this.isBoundaries = true;
    }

    /**
     * @return floor
     */
    public Boolean getFloor() {
        return isFloor;
    }

    /**
     * @return boundaries
     */
    public Boolean getBoundaries() {
        return isBoundaries;
    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);

    }

    /**
     * Removes a block from game.
     *
     * @param g game to remove from.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
        g.removeCollidable(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * Notifies listeners that a hitter had hit the block.
     *
     * @param hitter ball
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
