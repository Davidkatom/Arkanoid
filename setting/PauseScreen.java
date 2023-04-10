package setting;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author David Shnaiderov - 209198308
 * Pause Screen
 * User ID - shnaidd1
 */
public class PauseScreen extends KeyPressStoppableAnimation {

    /**
     * Constructor.
     * @param k keyboard
     */
    public PauseScreen(KeyboardSensor k) {
        super(k, KeyboardSensor.SPACE_KEY);

    }


    @Override
    public void doOneFrame(DrawSurface d) {
        super.doOneFrame(d);
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    @Override
    public boolean shouldStop() {
        return super.shouldStop();
    }
}
