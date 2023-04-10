package game.gameObjects;

/**
 * @author David Shnaiderov - 209198308
 * GameLevel.GameObjects.HitListener interface
 * User ID - shnaidd1
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the GameLevel.GameObjects.Ball that's doing the hitting.
      * @param beingHit GameLevel.GameObjects.Block being hit
     * @param hitter The ball that is hitting
     */
    void hitEvent(Block beingHit, Ball hitter);
}
