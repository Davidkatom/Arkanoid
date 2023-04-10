package game;

import biuoop.KeyboardSensor;
import game.gameObjects.Ball;
import game.gameObjects.Block;
import game.gameObjects.Paddle;
import game.gameObjects.Collidable;
import game.gameObjects.Sprite;

import game.gameObjects.observers.BallRemover;
import game.gameObjects.observers.BlockRemover;
import game.gameObjects.observers.Counter;
import game.gameObjects.observers.ScoreKeeper;
import game.gameObjects.observers.ScoreTrackingListener;

import game.gameObjects.primitives.Point;
import biuoop.GUI;
import biuoop.DrawSurface;
import setting.Animation;
import setting.GameEnvironment;
import setting.SpriteCollection;
import setting.AnimationRunner;
import setting.CountdownAnimation;
import setting.PauseScreen;

import java.awt.Color;

/**
 * @author David Shnaiderov - 209198308
 * GameLevel Template class
 * User ID - shnaidd1
 */
public class GameLevel implements Animation {
    private static final int RADIUS = 5;
    public static final int MARGIN = 20;
    private final GUI gui;
    private final GameEnvironment environment;
    private final SpriteCollection sprites;
    private final Counter counter;
    private final Counter ballCounter;
    private final Counter scoreCounter;
    private final BlockRemover remover;
    private final BallRemover ballRemover;
    private final ScoreTrackingListener scoreListener;
    private final AnimationRunner runner;
    private boolean running;
    private final KeyboardSensor keyboard;
    private final LevelInformation levelInformation;


    /**
     * Constructor.
     *
     * @param levelInformation - level information
     * @param gui              - GUI
     * @param animationRunner  Animation Runner
     * @param scoreCounter     Score Counter
     */
    public GameLevel(LevelInformation levelInformation, GUI gui,
                     AnimationRunner animationRunner, Counter scoreCounter) {
        environment = new GameEnvironment();
        this.sprites = new SpriteCollection();
        this.gui = gui;
        this.counter = new Counter();
        this.ballCounter = new Counter();
        this.scoreCounter = scoreCounter;
        this.remover = new BlockRemover(this, counter);
        this.ballRemover = new BallRemover(this, ballCounter);
        this.scoreListener = new ScoreTrackingListener(scoreCounter);
        this.runner = animationRunner;
        this.keyboard = gui.getKeyboardSensor();
        this.levelInformation = levelInformation;

    }


    /**
     * Returns level information.
     *
     * @return Level Information
     */
    public LevelInformation getLevelInformation() {
        return this.levelInformation;
    }

    /**
     * Initialize a new game: create the Blocks and GameLevel.GameObjects.Ball (and GameLevel.Paddle)
     * and add them to the game.
     */
    public void initialize() {
        defaultArr();
        ScoreKeeper scoreKeeper = new ScoreKeeper(GameEnvironment.SCREEN_WIDTH, MARGIN, scoreCounter,
                ballCounter, levelInformation.levelName());
        scoreKeeper.addToGame(this);

        int ballCount = getLevelInformation().numberOfBalls();
        ballCounter.increase(ballCount);

        for (int i = 0; i < ballCount; i++) {
            Ball ball = new Ball(GameEnvironment.SCREEN_WIDTH / (ballCount + 1.0) * (i + 1),
                    GameEnvironment.SCREEN_HEIGHT - 4 * MARGIN, RADIUS, Color.white, environment);
            ball.setVelocity(getLevelInformation().initialBallVelocities().get(i));
            ball.addToGame(this);
        }


        Paddle paddle = new Paddle(gui,
                new Point(GameEnvironment.SCREEN_WIDTH / 2.0 - this.getLevelInformation().paddleWidth() / 2.0,
                        GameEnvironment.SCREEN_HEIGHT - 2 * MARGIN - 1), getLevelInformation().paddleSpeed(),
                getLevelInformation().paddleWidth());


        paddle.addToGame(this);
        createBorders();


    }


    //d.setColor(new Color(0x16E0B6));
    //d.fillRectangle(0, 0, GameEnvironment.SCREEN_WIDTH, GameEnvironment.SCREEN_HEIGHT);

    /*
    Color[] color = {new Color(0x0D4057), new Color(0x12597A), new Color(0x166C94),
                new Color(0x1875A1), new Color(0x22A4E0), new Color(0x5BCAFF)};
        for (int i = 0; i < 6; i++) {
            for (int j = i; j < 13; j++) {
                Block b = new Block(new Point(130 + j * MARGIN * 2.5, 50 + i * MARGIN),
                        2.5 * MARGIN, MARGIN, color[i]);
                addToGame(remover, b);
            }
        }
     */

    /**
     * Default block arrangement.
     */
    private void defaultArr() {

        sprites.addSprite(this.getLevelInformation().getBackground());
        for (Block block : this.getLevelInformation().blocks()) {
            addToGame(remover, block);
        }

    }

    /**
     * Returns BallCounter.
     *
     * @return BallCounter
     */
    public Counter getBallCounter() {
        return this.ballCounter;
    }

    /**
     * Adds a block to the game.
     *
     * @param bRemover - blockRemover
     * @param b        - block
     */
    private void addToGame(BlockRemover bRemover, Block b) {
        b.addToGame(this);
        b.addHitListener(bRemover);
        b.addHitListener(scoreListener);
        if (!b.getBoundaries()) {
            counter.increase(1);
        }
    }

    /**
     * Determines if animation should stop.
     * @return Boolean
     */
    public boolean shouldStop() {
        return !this.running;
    }


    /**
     * Setter.
     *
     * @param bool boolean
     */
    private void setRunning(boolean bool) {
        this.running = bool;
    }

    /**
     * Animates one frame.
     * @param d Drawsurface
     */
    public void doOneFrame(DrawSurface d) {
        if (counter.getValue() == levelInformation.numberOfBlocksToRemove()) {
            scoreCounter.increase(100);
            //gui.close();
            setRunning(false);
        }
        if (ballCounter.getValue() == 0) {
            //gui.close();
            setRunning(false);
        }

        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

        if (this.keyboard.isPressed("p")) {
            this.runner.run(new PauseScreen(this.keyboard));
        }

    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, sprites));
        setRunning(true);
        this.runner.run(this);
    }


    /**
     * Adds GameLevel.GameObjects.Collidable to array.
     *
     * @param c - GameLevel.GameObjects.Collidable
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * Removes GameLevel.GameObjects.Collidable to array.
     *
     * @param c - GameLevel.GameObjects.Collidable
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * Removes GameLevel.GameObjects.Sprite to array.
     *
     * @param s - GameLevel.GameObjects.Sprite
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);

    }


    /**
     * Adds GameLevel.GameObjects.Sprite to array.
     *
     * @param s - GameLevel.GameObjects.Sprite
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Creates 4 blocks which act as barriers.
     */
    private void createBorders() {
        Block top = new Block(new Point(0, MARGIN), GameEnvironment.SCREEN_WIDTH - MARGIN, MARGIN);
        Block right = new Block(new Point(GameEnvironment.SCREEN_WIDTH - MARGIN, MARGIN),
                MARGIN, GameEnvironment.SCREEN_HEIGHT - MARGIN);
        Block bottom = new Block(new Point(MARGIN, GameEnvironment.SCREEN_HEIGHT - MARGIN),
                GameEnvironment.SCREEN_WIDTH - 2 * MARGIN, MARGIN, Color.white);
        Block left = new Block(new Point(0, MARGIN), MARGIN, GameEnvironment.SCREEN_HEIGHT);
        top.setFloorOrBoundaries(false);
        right.setFloorOrBoundaries(false);
        bottom.setFloorOrBoundaries(true);
        left.setFloorOrBoundaries(false);

        addToGame(remover, top);
        addToGame(remover, right);
        addToGame(remover, bottom);
        this.removeSprite(bottom);
        bottom.addHitListener(ballRemover);
        addToGame(remover, left);
    }


}
