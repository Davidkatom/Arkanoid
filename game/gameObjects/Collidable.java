package game.gameObjects;

import game.gameObjects.primitives.Point;
import game.gameObjects.primitives.Rectangle;
import game.gameObjects.primitives.Velocity;


/**
 * @author David Shnaiderov - 209198308
 * GameLevel.GameObjects.Collidable interface
 * User ID - shnaidd1
 */
public interface Collidable {

    /**
     * Return the "collision shape" of the object.
     * @return GameLevel.GameObjects.Primitives.Rectangle
     */
    Rectangle getCollisionRectangle();

    /**
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     * The return is the new velocity expected after the hit (based on
     * the force the object inflicted on us).
     * @param collisionPoint - GameLevel.GameObjects.Primitives.Point
     * @param currentVelocity - GameLevel.GameObjects.Primitives.Velocity
     * @param hitter - The ball hitting
     * @return GameLevel.GameObjects.Primitives.Velocity
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);

}