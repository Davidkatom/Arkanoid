package setting;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * @author David Shnaiderov - 209198308
 * Animation Controller
 * User ID - shnaidd1
 */
public class AnimationRunner {
    private static final int FRAMES = 60;
    private final GUI gui;
    private final int framesPerSecond;


    /**
     * Constructor.
     *
     * @param gui GUI
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        framesPerSecond = FRAMES;
    }

    /**
     * Run the game -- start the animation loop.
     *
     * @param animation animation to run.
     */
    public void run(Animation animation) {
        Sleeper sleeper = new Sleeper();
        int millisecondsPerFrame = 1000 / framesPerSecond;

        while (!animation.shouldStop()) { // shouldStop() is in charge of stopping condition.
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d); // doOneFrame(DrawSurface) is in charge of the logic.

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }


    }
}
