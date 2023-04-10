package game.gameObjects.observers;

import game.GameLevel;
import game.gameObjects.Ball;
import game.gameObjects.Block;
import game.gameObjects.HitListener;

/**
 * @author David Shnaiderov - 209198308
 * GameLevel.BallRemover class - removes the ball when it hits the Death Zone
 * User ID - shnaidd1
 */

public class BallRemover implements HitListener {
    private final GameLevel gameLevel;
    private final Counter remainingBalls;

    /**
     * Constructor.
     *
     * @param gameLevel - GameObject
     * @param removedBlocks - counter
     */
    public BallRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBalls = removedBlocks;
    }
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getFloor()) {
            gameLevel.removeSprite(hitter);
            remainingBalls.decrease(1);
        }
    }
}
