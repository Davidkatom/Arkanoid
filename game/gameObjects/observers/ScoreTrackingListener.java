package game.gameObjects.observers;

import game.gameObjects.Ball;
import game.gameObjects.Block;
import game.gameObjects.HitListener;

/**
 * @author David Shnaiderov - 209198308
 * GameLevel.ScoreTrackingListener Listener
 * User ID - shnaidd1
 */

public class ScoreTrackingListener implements HitListener {
    private final Counter currentScore;

    /**
     * Constructor.
     * @param scoreCounter GameLevel.Counter object
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        if (!beingHit.getBoundaries()) {
            currentScore.increase(5);
        }
    }
}