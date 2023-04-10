import biuoop.GUI;
import game.GameFlow;
import game.LevelInformation;
import game.levels.DirectHit;
import game.levels.Ender;
import game.levels.FinalHour;
import game.levels.Tardis;
import setting.AnimationRunner;
import setting.GameEnvironment;

import java.util.LinkedList;
import java.util.List;

/**
 * @author David Shnaiderov - 209198308
 * Main Class to start the game.
 * User ID - shnaidd1
 */
public class Ass6Game {
    private static final int MAX_LEVEL = 4;

    /**
     * Main.
     *
     * @param args Arguments (empty)
     */
    public static void main(String[] args) {

        Ass6Game game = new Ass6Game();
        List<LevelInformation> levels = game.getAttributes(args);

        GUI gui = new GUI("Arkanoid", GameEnvironment.SCREEN_WIDTH, GameEnvironment.SCREEN_HEIGHT);
        AnimationRunner runner = new AnimationRunner(gui);

        GameFlow gameFlow = new GameFlow(runner, gui);
        gameFlow.runLevels(levels);
        gui.close();
    }

    /**
     * Creates a list with requested levels.
     *
     * @param args - Main args
     * @return List of levels
     */
    private List<LevelInformation> getAttributes(String[] args) {
        List<LevelInformation> levels = new LinkedList<>();
        LevelInformation[] levelOptions = {new DirectHit(), new Tardis(), new Ender(), new FinalHour()};

        for (String num : args) {
            if (!isInteger(num) || Integer.parseInt(num) > MAX_LEVEL) {
                continue;
            }
            levels.add(levelOptions[Integer.parseInt(num) - 1]);
        }

        if (levels.size() == 0) {
            levels.add(levelOptions[0]);
            levels.add(levelOptions[1]);
            levels.add(levelOptions[2]);
            levels.add(levelOptions[3]);
        }
        return levels;
    }

    /**
     * Checks if a given string is an int.
     *
     * @param s string to check
     * @return Boolean
     */
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

}
