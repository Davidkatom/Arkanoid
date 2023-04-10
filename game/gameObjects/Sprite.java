package game.gameObjects;

import biuoop.DrawSurface;
import game.GameLevel;
/**
 * @author David Shnaiderov - 209198308
 * GameLevel.GameObjects.Sprite Interface - Controlls graphics
 * User ID - shnaidd1
 */
public interface Sprite {

    /**
     * draw the sprite to the screen.
     *
     * @param d DrawSurface
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * Adds object to game.
     *
     * @param g GameLevel
     */
    void addToGame(GameLevel g);
}
