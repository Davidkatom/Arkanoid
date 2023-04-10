package game.gameObjects.observers;

import game.GameLevel;
import game.gameObjects.Ball;
import game.gameObjects.Block;
import game.gameObjects.HitListener;

/**
 * @author David Shnaiderov - 209198308
 * a GameLevel.BlockRemover is in charge of removing blocks from the gameLevel, as well as keeping count
 * of the number of blocks that remain
 * User ID - shnaidd1
 */
public class BlockRemover implements HitListener {
    private final GameLevel gameLevel;
    private final Counter remainingBlocks;

    /**
     * Constructor.
     * @param gameLevel - GameLevel Object
     * @param removedBlocks - GameLevel.Counter
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }


    /**
     *  Blocks that are hit should be removed
     *  from the gameLevel. Remember to remove this listener from the block
     *  that is being removed from the gameLevel.
     * @param beingHit A block being hit
     * @param hitter Hitter
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        if (!beingHit.getFloor() && !beingHit.getBoundaries()) {
            removeBlock(beingHit);
        }
    }

    /**
     * Removes a block.
     * @param block GameLevel.GameObjects.Block to remove
     */
    private void removeBlock(Block block) {
        block.removeHitListener(this);
        block.removeFromGame(this.gameLevel);
        this.remainingBlocks.decrease(1);
    }
}