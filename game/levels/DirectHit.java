package game.levels;

import game.GameLevel;
import game.LevelInformation;
import game.gameObjects.Background;
import game.gameObjects.Block;
import game.gameObjects.Sprite;
import game.gameObjects.primitives.Velocity;
import game.gameObjects.primitives.Point;
import game.gameObjects.primitives.Circle;
import game.gameObjects.primitives.Line;

import setting.GameEnvironment;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * @author David Shnaiderov - 209198308
 * Direct Hit - level
 * User ID - shnaidd1
 */
public class DirectHit implements LevelInformation {
    private static final int PADDLE_WIDTH = 100;
    private static final int PADDLE_SPEED = 3;
    private final List<Velocity> velocities;

    /**
     * Constructor.
     */
    public DirectHit() {
        this.velocities = new LinkedList<>();
        velocities.add(new Velocity(0, -4));

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
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        Background background = new Background();
        Color color = Color.black;
        Sprite backgroundColor = new Block(new Point(0, 0), GameEnvironment.SCREEN_WIDTH,
                GameEnvironment.SCREEN_HEIGHT, color);
        background.addToObjects(backgroundColor);
        color = Color.blue;
        Point center = new Point(GameEnvironment.SCREEN_WIDTH / 2.0, GameEnvironment.SCREEN_WIDTH / 5.0);
        for (int i = 0; i < 4; i++) {
            Sprite circle = new Circle(center, 45 * i, color, false);
            background.addToObjects(circle);
        }

        Sprite line = new Line(new Point(center.getX() - 200, center.getY()),
                new Point(center.getX() + 200, center.getY()), color);
        background.addToObjects(line);

        line = new Line(new Point(center.getX(), center.getY() - 200),
                new Point(center.getX(), center.getY() + 200), color);
        background.addToObjects(line);


        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new LinkedList<>();
        Block b = new Block(new Point(GameEnvironment.SCREEN_WIDTH / 2.0 - GameLevel.MARGIN,
                GameEnvironment.SCREEN_WIDTH / 5.0 - GameLevel.MARGIN),
                2 * GameLevel.MARGIN, 2 * GameLevel.MARGIN, Color.red);
        blocks.add(b);
        blocks.add(b);
        return blocks;

    }


    @Override
    public int numberOfBlocksToRemove() {
        return 0;
    }
}
