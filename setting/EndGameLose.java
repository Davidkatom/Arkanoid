package setting;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import game.gameObjects.observers.Counter;

/**
 * @author David Shnaiderov - 209198308
 * End Game loose screen
 * User ID - shnaidd1
 */
public class EndGameLose extends KeyPressStoppableAnimation {

    private final Counter score;

    /**
     * Constructor.
     * @param k keyboard
     * @param score score
     */
    public EndGameLose(KeyboardSensor k, Counter score) {
        super(k, KeyboardSensor.SPACE_KEY);
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        super.doOneFrame(d);
        d.drawText(10, d.getHeight() / 2, "Game Over! Your score is: " + score.getValue(), 32);

    }

    @Override
    public boolean shouldStop() {
        return super.shouldStop();
    }
}