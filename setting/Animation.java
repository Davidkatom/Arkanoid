package setting;

import biuoop.DrawSurface;

/**
 * @author David Shnaiderov - 209198308
 * Animation Interface
 * User ID - shnaidd1
 */
public interface Animation {
    /**
     * Draw one frame.
     *
     * @param d Drawsurface
     */
    void doOneFrame(DrawSurface d);

    /**
     * Stopping conditions.
     *
     * @return bool
     */
    boolean shouldStop();
}
