package game.gameObjects.observers;

import game.GameLevel;
import game.gameObjects.Sprite;
import game.gameObjects.primitives.Point;
import game.gameObjects.primitives.Rectangle;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author David Shnaiderov - 209198308
 * Keeps track and displays the score
 * User ID - shnaidd1
 */

public class ScoreKeeper implements Sprite {
    private final Rectangle rectangle;
    private final Counter scoreCounter;
    private final Counter ballCounter;
    private final String levelName;

    /**
     * Constructor.
     *
     * @param width       Width
     * @param height      Height
     * @param score       GameLevel.Counter object
     * @param ballCounter Number of balls
     * @param levelName   Level name
     */
    public ScoreKeeper(int width, int height, Counter score, Counter ballCounter, String levelName) {
        rectangle = new Rectangle(new Point(0, 0), width, height);
        this.scoreCounter = score;
        this.ballCounter = ballCounter;
        this.levelName = levelName;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.lightGray);
        d.fillRectangle(0, 0, (int) rectangle.getWidth(), (int) rectangle.getHeight());
        d.setColor(Color.black);
        d.drawText((int) rectangle.getWidth() / 2, (int) rectangle.getHeight() / 2 + 5,
                "Score: " + scoreCounter.getValue(), 15);
        d.drawText((int) rectangle.getWidth() / 4, (int) rectangle.getHeight() / 2 + 5,
                "Lives: " + ballCounter.getValue(), 15);
        d.drawText((int) rectangle.getWidth() / 4 * 3, (int) rectangle.getHeight() / 2 + 5,
                "Level Name: " + levelName, 15);
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
