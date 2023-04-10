package setting;

import game.gameObjects.Sprite;
import biuoop.DrawSurface;
import java.util.LinkedList;
import java.util.List;

/**
 * @author David Shnaiderov - 209198308
 * Stores Sprites
 * User ID - shnaidd1
 */
public class SpriteCollection {
    private final List<Sprite> sprites = new LinkedList<>();

    /**
     * Adds GameLevel.GameObjects.Sprite to game.
     *
     * @param s GameLevel.GameObjects.Sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * Removes GameLevel.GameObjects.Sprite to game.
     *
     * @param s GameLevel.GameObjects.Sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spritesTemp = new LinkedList<>(this.sprites);
        for (Sprite s : spritesTemp) {
            s.timePassed();
        }
    }

    /**
     * call drawOn(d) on all sprites.
     * @param d - DrawSurface
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : this.sprites) {
            s.drawOn(d);
        }
    }
}
