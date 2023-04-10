package setting;

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * @author David Shnaiderov - 209198308
 * Countdown animation at the start of every level.
 * User ID - shnaidd1
 */
public class CountdownAnimation implements Animation {
    private final double numOfSeconds;
    private final int countFrom;
    private final SpriteCollection gameScreen;
    private boolean startGame = false;
    private final long startTime;

    /**
     * Constructor.
     *
     * @param numOfSeconds for how long
     * @param countFrom    start from
     * @param gameScreen   Background
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        startTime = System.currentTimeMillis();

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        long usedTime = System.currentTimeMillis() - startTime;
        if (usedTime > numOfSeconds * 1000) {
            startGame = true;
        }

        this.gameScreen.drawAllOn(d);
        d.setColor(Color.white);
        d.drawText(d.getWidth() / 2, d.getHeight() / 2,
                Integer.toString((int) (countFrom - (countFrom / numOfSeconds) * usedTime / 1000) + 1), 50);

    }


    @Override
    public boolean shouldStop() {
        return startGame;
    }
}
