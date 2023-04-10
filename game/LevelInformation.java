package game;

import game.gameObjects.Block;
import game.gameObjects.Sprite;
import game.gameObjects.primitives.Velocity;

import java.util.List;
/**
 * @author David Shnaiderov - 209198308
 * Level information
 * User ID - shnaidd1
 */
public interface LevelInformation {
    /**
     * Gets the initial number of balls.
     *
     * @return number of balls
     */
    int numberOfBalls();


    /**
     * The initial velocity of each ball.
     *
     * @return List of velocities
     */
    List<Velocity> initialBallVelocities();

    /**
     * Paddle speed.
     * @return speed.
     */
    int paddleSpeed();

    /**
     * Paddle width.
     * @return width
     */
    int paddleWidth();

    /**
     * the level name will be displayed at the top of the screen.
     * @return Name
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     * @return Background sprite
     */
    Sprite getBackground();


    /**
     * The Blocks that make up this level, each block contains
     * its size, color and location.
     * @return list of blocks
     */
    List<Block> blocks();

    /**
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * @return number of blocks to remove.
     */
    int numberOfBlocksToRemove();
}