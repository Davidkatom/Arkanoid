package game.levels;

import game.LevelInformation;
import game.gameObjects.Background;
import game.gameObjects.Block;
import game.gameObjects.Sprite;
import game.gameObjects.primitives.Point;
import game.gameObjects.primitives.Velocity;
import setting.GameEnvironment;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * @author David Shnaiderov - 209198308
 * Tardis - level
 * User ID - shnaidd1
 */
public class Tardis implements LevelInformation {
    private static final int PADDLE_WIDTH = 50;
    private static final int PADDLE_SPEED = 8;
    private final List<Velocity> velocities;

    /**
     * Constructor.
     */
    public Tardis() {
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
        return "Tardis";
    }

    @Override
    public Sprite getBackground() {
        Background background = new Background();
        Color color = new Color(0xC8C9D0);
        Sprite backgroundColor = new Block(new game.gameObjects.primitives.Point(0, 0), GameEnvironment.SCREEN_WIDTH,
                GameEnvironment.SCREEN_HEIGHT, color);
        background.addToObjects(backgroundColor);

        backgroundColor = new Block(new Point(330, 190), 177,
                320, new Color(0x3E79C9));

        background.addToObjects(backgroundColor);

        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new LinkedList<>();

        //Blue Blocks
        Block b = new Block(new Point(350, 350),
                50, 60, new Color(0x33499C));
        blocks.add(b);

        b = new Block(new Point(430, 350),
                50, 60, new Color(0x33499C));
        blocks.add(b);

        b = new Block(new Point(350, 420),
                50, 60, new Color(0x33499C));
        blocks.add(b);

        b = new Block(new Point(430, 420),
                50, 60, new Color(0x33499C));
        blocks.add(b);

        b = new Block(new Point(430, 280),
                50, 60, new Color(0x33499C));
        blocks.add(b);

        b = new Block(new Point(350, 280),
                50, 60, new Color(0xF6E5C4));
        blocks.add(b);

        //Windows
        b = new Block(new Point(345, 205),
                18, 30, new Color(0xE4E1F2));
        blocks.add(b);

        b = new Block(new Point(367, 205),
                18, 30, new Color(0xE4E1F2));
        blocks.add(b);

        b = new Block(new Point(389, 205),
                18, 30, new Color(0xE4E1F2));
        blocks.add(b);

        b = new Block(new Point(345, 239),
                18, 30, new Color(0xE4E1F2));
        blocks.add(b);

        b = new Block(new Point(367, 239),
                18, 30, new Color(0xE4E1F2));
        blocks.add(b);

        b = new Block(new Point(389, 239),
                18, 30, new Color(0xE4E1F2));
        blocks.add(b);

        //
        b = new Block(new Point(425, 205),
                18, 30, new Color(0xE4E1F2));
        blocks.add(b);

        b = new Block(new Point(447, 205),
                18, 30, new Color(0xE4E1F2));
        blocks.add(b);

        b = new Block(new Point(469, 205),
                18, 30, new Color(0xE4E1F2));
        blocks.add(b);

        b = new Block(new Point(425, 239),
                18, 30, new Color(0xE4E1F2));
        blocks.add(b);

        b = new Block(new Point(447, 239),
                18, 30, new Color(0xE4E1F2));
        blocks.add(b);

        b = new Block(new Point(469, 239),
                18, 30, new Color(0xE4E1F2));
        blocks.add(b);


        //Frame

        b = new Block(new Point(303, 510), 225,
                10, new Color(0x33499C));
        blocks.add(b);

        b = new Block(new Point(315, 190), 25,
                320, new Color(0x33499C));
        blocks.add(b);

        b = new Block(new Point(492, 190), 25,
                320, new Color(0x33499C));
        blocks.add(b);

        b = new Block(new Point(310, 170), 210,
                25, new Color(0x33499C));
        blocks.add(b);

        b = new Block(new Point(325, 173),
                180, 16, new Color(0x000000));
        blocks.add(b);

        b = new Block(new Point(330, 157), 168,
                13, new Color(0x33499C));
        blocks.add(b);

        b = new Block(new Point(350, 143), 126,
                13, new Color(0x33499C));
        blocks.add(b);

        b = new Block(new Point(380, 130), 70,
                13, new Color(0x33499C));
        blocks.add(b);

        b = new Block(new Point(400, 122), 30,
                8, new Color(0x33499C));
        blocks.add(b);

        b = new Block(new Point(406, 100),
                17, 22, new Color(0xF6E5C4));
        blocks.add(b);

        b = new Block(new Point(404, 92), 20,
                8, new Color(0x33499C));
        blocks.add(b);
        return blocks;


    }


    @Override
    public int numberOfBlocksToRemove() {
        return 0;
    }
}
