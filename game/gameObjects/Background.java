package game.gameObjects;

import biuoop.DrawSurface;
import game.GameLevel;

import java.util.LinkedList;
import java.util.List;
/**
 * @author David Shnaiderov - 209198308
 * Background Sprite
 * User ID - shnaidd1
 */
public class Background implements Sprite {
    private final List<Sprite> objects = new LinkedList<>();


    /**
     * Adds to object list.
     * @param sprite Sprite to add
     */
    public void addToObjects(Sprite sprite) {
        objects.add(sprite);
    }

    @Override
    public void drawOn(DrawSurface d) {
        for (Sprite sprite : objects) {
            sprite.drawOn(d);
        }
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {
        for (Sprite sprite : objects) {
            sprite.addToGame(g);
        }
    }
}
