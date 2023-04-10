package game.levels;

import game.GameLevel;
import game.LevelInformation;
import game.gameObjects.Background;
import game.gameObjects.Block;
import game.gameObjects.Sprite;
import game.gameObjects.primitives.Circle;
import game.gameObjects.primitives.Line;
import game.gameObjects.primitives.Point;
import game.gameObjects.primitives.Velocity;
import setting.GameEnvironment;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * @author David Shnaiderov - 209198308
 * Final Hour - level
 * User ID - shnaidd1
 */
public class FinalHour implements LevelInformation {
    private static final int PADDLE_WIDTH = 100;
    private static final int PADDLE_SPEED = 4;
    private final List<Velocity> velocities;

    /**
     * Constructor.
     */
    public FinalHour() {
        this.velocities = new LinkedList<>();
        velocities.add(new Velocity(-1, -4));
        velocities.add(new Velocity(2, -2));
        velocities.add(new Velocity(1, -1));

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
        return "Final Hour";
    }

    @Override
    public Sprite getBackground() {
        Background background = new Background();
        Color color = new Color(0x1788D0);
        Sprite backgroundColor = new Block(new Point(0, 0), GameEnvironment.SCREEN_WIDTH,
                GameEnvironment.SCREEN_HEIGHT, color);
        background.addToObjects(backgroundColor);

        backgroundColor = new Line(170, 400, 145, 600);
        background.addToObjects(backgroundColor);

        backgroundColor = new Line(160, 400, 135, 600);
        background.addToObjects(backgroundColor);

        backgroundColor = new Line(150, 400, 125, 600);
        background.addToObjects(backgroundColor);

        backgroundColor = new Line(140, 400, 115, 600);
        background.addToObjects(backgroundColor);

        backgroundColor = new Line(130, 400, 105, 600);
        background.addToObjects(backgroundColor);

        backgroundColor = new Line(120, 400, 95, 600);
        background.addToObjects(backgroundColor);

        backgroundColor = new Line(110, 400, 85, 600);
        background.addToObjects(backgroundColor);

        backgroundColor = new Line(100, 400, 75, 600);
        background.addToObjects(backgroundColor);

        backgroundColor = new Line(90, 400, 65, 600);
        background.addToObjects(backgroundColor);

        backgroundColor = new Line(80, 400, 55, 600);
        background.addToObjects(backgroundColor);


        backgroundColor = new Circle(new Point(83, 382), 20,
                new Color(0xCCCCCC), true);
        background.addToObjects(backgroundColor);

        backgroundColor = new Circle(new Point(105, 406), 20,
                new Color(0xCCCCCC), true);
        background.addToObjects(backgroundColor);

        backgroundColor = new Circle(new Point(119, 372), 30,
                new Color(0xBBBBBB), true);
        background.addToObjects(backgroundColor);

        backgroundColor = new Circle(new Point(162, 380), 30,
                new Color(0xAAAAAA), true);
        background.addToObjects(backgroundColor);

        backgroundColor = new Circle(new Point(143, 400), 20,
                new Color(0xAAAAAA), true);
        background.addToObjects(backgroundColor);


        backgroundColor = new Line(680, 500, 655, 600);
        background.addToObjects(backgroundColor);

        backgroundColor = new Line(670, 500, 645, 600);
        background.addToObjects(backgroundColor);

        backgroundColor = new Line(660, 500, 635, 600);
        background.addToObjects(backgroundColor);

        backgroundColor = new Line(650, 500, 625, 600);
        background.addToObjects(backgroundColor);

        backgroundColor = new Line(640, 500, 615, 600);
        background.addToObjects(backgroundColor);

        backgroundColor = new Line(630, 500, 605, 600);
        background.addToObjects(backgroundColor);

        backgroundColor = new Line(620, 500, 595, 600);
        background.addToObjects(backgroundColor);

        backgroundColor = new Line(610, 500, 585, 600);
        background.addToObjects(backgroundColor);

        backgroundColor = new Line(600, 500, 575, 600);
        background.addToObjects(backgroundColor);

        backgroundColor = new Line(590, 500, 565, 600);
        background.addToObjects(backgroundColor);

        backgroundColor = new Circle(new Point(583, 482), 20,
                new Color(0xCCCCCC), true);
        background.addToObjects(backgroundColor);

        backgroundColor = new Circle(new Point(605, 506), 20,
                new Color(0xCCCCCC), true);
        background.addToObjects(backgroundColor);

        backgroundColor = new Circle(new Point(619, 472), 30,
                new Color(0xBBBBBB), true);
        background.addToObjects(backgroundColor);

        backgroundColor = new Circle(new Point(662, 480), 30,
                new Color(0xAAAAAA), true);
        background.addToObjects(backgroundColor);

        backgroundColor = new Circle(new Point(643, 500), 20,
                new Color(0xAAAAAA), true);
        background.addToObjects(backgroundColor);

        return background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new LinkedList<>();

        //Blue Blocks
        Color[] color = {new Color(0x0D4057), new Color(0x12597A), new Color(0x166C94),
                new Color(0x1875A1), new Color(0x22A4E0), new Color(0x5BCAFF)};
        for (int i = 0; i < 6; i++) {
            for (int j = i; j < 13; j++) {
                Block b = new Block(new Point(130 + j * GameLevel.MARGIN * 2.5, 50 + i * GameLevel.MARGIN),
                        2.5 * GameLevel.MARGIN, GameLevel.MARGIN, color[i]);
                blocks.add(b);
            }
        }


        return blocks;


    }


    @Override
    public int numberOfBlocksToRemove() {
        return 0;
    }

}
