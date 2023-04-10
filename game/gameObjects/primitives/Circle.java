package game.gameObjects.primitives;

import biuoop.DrawSurface;
import game.GameLevel;
import game.gameObjects.Sprite;

import java.awt.Color;

/**
 * @author David Shnaiderov - 209198308
 * Circle Sprite
 * User ID - shnaidd1
 */
public class Circle implements Sprite {
    private final Point center;
    private final int radius;
    private final Color color;
    private final boolean isFullCircle;

    /**
     * Constructor.
     * @param center center point
     * @param radius radius
     * @param color color
     * @param isFullCircle circle outline or a full circle
     */
    public Circle(Point center, int radius, Color color, boolean isFullCircle) {
        this.center = center;
        this.radius = radius;
        this.color = color;
        this.isFullCircle = isFullCircle;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        if (isFullCircle) {
            d.fillCircle((int) center.getX(), (int) center.getY(), radius);
        } else {
            d.drawCircle((int) center.getX(), (int) center.getY(), radius);
        }
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
