package setting;

import game.gameObjects.Collidable;
import game.gameObjects.primitives.Line;

import java.util.LinkedList;
import java.util.List;

/**
 * @author David Shnaiderov - 209198308
 * Stores important game details
 * User ID - shnaidd1
 */
public class GameEnvironment {
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;

    private final List<Collidable> collidbles;

    /**
     * Constructor.
     */
    public GameEnvironment() {
        collidbles = new LinkedList<>();
    }

    /**
     * Gets GameLevel.GameObjects.Collidable.
     *
     * @return GameLevel.GameObjects.Collidable
     */
    public List<Collidable> getCollidbles() {
        return collidbles;
    }


    /**
     * Adds GameLevel.GameObjects.Collidable.
     *
     * @param c GameLevel.GameObjects.Collidable
     */
    public void addCollidable(Collidable c) {
        collidbles.add(c);
    }

    /**
     * Removes GameLevel.GameObjects.Collidable.
     *
     * @param c GameLevel.GameObjects.Collidable
     */
    public void removeCollidable(Collidable c) {
        collidbles.remove(c);
    }

    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.

    /**
     * return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory - GameLevel.GameObjects.Primitives.Line
     * @return GameSetting.CollisionInfo
     */
    @SuppressWarnings("unused")
    public CollisionInfo getClosestCollision(Line trajectory) {
        return new CollisionInfo(trajectory, this);
    }

}
