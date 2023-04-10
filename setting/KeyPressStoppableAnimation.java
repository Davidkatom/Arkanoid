package setting;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author David Shnaiderov - 209198308
 * Animation which can be stopped with keyboard
 * User ID - shnaidd1
 */
public class KeyPressStoppableAnimation implements Animation {
    private final KeyboardSensor keyboardSensor;
    private final String key;
    private boolean stop = false;
    private boolean isAlreadyPressed = true;


    /**
     * Constructor.
     *
     * @param keyboard keyboard
     * @param key      key
     */
    public KeyPressStoppableAnimation(KeyboardSensor keyboard, String key) {
        this.key = key;
        this.keyboardSensor = keyboard;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.keyboardSensor.isPressed(key) && !isAlreadyPressed) {
            this.stop = true;
        } else if (!this.keyboardSensor.isPressed(key)) {
            isAlreadyPressed = false;
        }
    }


    @Override
    public boolean shouldStop() {
        return stop;
    }
}
