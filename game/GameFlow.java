package game;

import biuoop.GUI;
import game.gameObjects.observers.Counter;
import setting.AnimationRunner;
import setting.EndGameLose;
import setting.EndGameWin;

import java.util.List;

/**
 * @author David Shnaiderov - 209198308
 * Responsible for the game flow
 * User ID - shnaidd1
 */
public class GameFlow {

    private final GUI gui;
    private final AnimationRunner animationRunner;
    private final Counter scoreCounter;
    private boolean win = true;

    /**
     * Constructor.
     * @param ar Animation Runner
     * @param gui GUI
     */
    public GameFlow(AnimationRunner ar, GUI gui) {
        //new GUI("Arkanoid", GameEnvironment.SCREEN_WIDTH, GameEnvironment.SCREEN_HEIGHT);
        this.animationRunner = ar;
        this.gui = gui;
        this.scoreCounter = new Counter();

    }

    /**
     * Runs the levels.
     * @param levels list of levels
     */
    public void runLevels(List<LevelInformation> levels) {
        // ...
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.gui, this.animationRunner, scoreCounter);

            level.initialize();

            while (level.shouldStop()) {
                level.run();
                if (level.shouldStop()) {
                    break;
                }
            }

            if (level.getBallCounter().getValue() == 0) {
                animationRunner.run(new EndGameLose(gui.getKeyboardSensor(), scoreCounter));
                win = false;
                break;
            }

        }
        if (win) {
            animationRunner.run(new EndGameWin(gui.getKeyboardSensor(), scoreCounter));
        }
    }
}
