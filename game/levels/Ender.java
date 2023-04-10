package game.levels;

import game.LevelInformation;
import game.gameObjects.Background;
import game.gameObjects.Block;
import game.gameObjects.Sprite;
import game.gameObjects.primitives.Velocity;
import setting.GameEnvironment;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * @author David Shnaiderov - 209198308
 * Ender - level
 * User ID - shnaidd1
 */
public class Ender implements LevelInformation {
    private static final int PADDLE_WIDTH = 100;
    private static final int PADDLE_SPEED = 5;
    private final List<Velocity> velocities;

    /**
     * Constructor.
     */
    public Ender() {
        this.velocities = new LinkedList<>();
        velocities.add(new Velocity(-1, -4));
        velocities.add(new Velocity(2, -2));

    }


    @Override
    public int numberOfBalls() {
        return velocities.size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    @Override
    public String levelName() {
        return "Ender";
    }

    @Override
    public Sprite getBackground() {
        Background background = new Background();
        Color color = new Color(0x2C1A50);
        Sprite backgroundColor = new Block(new game.gameObjects.primitives.Point(0, 0), GameEnvironment.SCREEN_WIDTH,
                GameEnvironment.SCREEN_HEIGHT, color);
        background.addToObjects(backgroundColor);


        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new LinkedList<>();

        //Blue Blocks
        for (int i = 1; i < 9; i++) {
            Block b = new Block(new game.gameObjects.primitives.Point(220 + i * 38, 100),
                    38, 38, new Color(0x130F10));
            blocks.add(b);
        }

        for (int i = 1; i < 9; i++) {
            Color[] color = {new Color(0x130F10), new Color(0x373439), new Color(0x373439),
                    new Color(0x130F10), new Color(0x130F10), new Color(0x373439), new Color(0x373439),
                    new Color(0x130F10)};

            Block b = new Block(new game.gameObjects.primitives.Point(220 + i * 38, 138),
                    38, 38, color[i - 1]);
            blocks.add(b);
        }

        for (int i = 1; i < 9; i++) {
            Color[] color = {new Color(0x373439), new Color(0x130F10), new Color(0x130F10),
                    new Color(0x373439), new Color(0x373439), new Color(0x130F10), new Color(0x130F10),
                    new Color(0x373439)};

            Block b = new Block(new game.gameObjects.primitives.Point(220 + i * 38, 176),
                    38, 38, color[i - 1]);
            blocks.add(b);
        }

        for (int i = 1; i < 9; i++) {
            Color[] color = {new Color(0xFBC2EB), new Color(0xE17DC7), new Color(0xFBC2EB),
                    new Color(0x373439), new Color(0x373439), new Color(0xFBC2EB), new Color(0xE17DC7),
                    new Color(0xFBC2EB)};

            Block b = new Block(new game.gameObjects.primitives.Point(220 + i * 38, 214),
                    38, 38, color[i - 1]);
            blocks.add(b);
        }

        for (int i = 1; i < 9; i++) {
            Color[] color = {new Color(0x130F10), new Color(0x130F10), new Color(0x373439),
                    new Color(0x373439), new Color(0x373439), new Color(0x373439), new Color(0x130F10),
                    new Color(0x130F10)};

            Block b = new Block(new game.gameObjects.primitives.Point(220 + i * 38, 252),
                    38, 38, color[i - 1]);
            blocks.add(b);
        }


        for (int i = 1; i < 9; i++) {
            Color[] color = {new Color(0x36353A), new Color(0x130F10), new Color(0x373439),
                    new Color(0x373439), new Color(0x373439), new Color(0x373439), new Color(0x130F10),
                    new Color(0x36353A)};

            Block b = new Block(new game.gameObjects.primitives.Point(220 + i * 38, 290),
                    38, 38, color[i - 1]);
            blocks.add(b);
        }

        for (int i = 1; i < 9; i++) {
            Color[] color = {new Color(0x130F10), new Color(0x373439), new Color(0x373439),
                    new Color(0x130F10), new Color(0x130F10), new Color(0x373439), new Color(0x373439),
                    new Color(0x130F10)};

            Block b = new Block(new game.gameObjects.primitives.Point(220 + i * 38, 328),
                    38, 38, color[i - 1]);
            blocks.add(b);
        }
        for (int i = 1; i < 9; i++) {
            Color[] color = {new Color(0x130F10), new Color(0x373439), new Color(0x130F10),
                    new Color(0x130F10), new Color(0x130F10), new Color(0x130F10), new Color(0x373439),
                    new Color(0x130F10)};

            Block b = new Block(new game.gameObjects.primitives.Point(220 + i * 38, 366),
                    38, 38, color[i - 1]);
            blocks.add(b);
        }


        return blocks;


    }


    @Override
    public int numberOfBlocksToRemove() {
        return 0;
    }
}


