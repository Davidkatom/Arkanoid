package setting;

import game.gameObjects.Collidable;
import game.gameObjects.primitives.Line;
import game.gameObjects.primitives.Point;

/**
 * @author David Shnaiderov - 209198308
 * Calculates and stores collisions
 * User ID - shnaidd1
 */
public class CollisionInfo {
    private final Line trajectory;
    private final GameEnvironment environment;
    private Collidable collidingWith;
    private final Point collisionPoint;

    /**
     * Constructor.
     *
     * @param t - trajectory
     * @param e - game environment
     */
    public CollisionInfo(Line t, GameEnvironment e) {
        trajectory = t;
        environment = e;
        collisionPoint = collisionPoint();
    }

    /**
     * Gets Trajectory.
     *
     * @return - GameLevel.GameObjects.Primitives.Line
     */
    @SuppressWarnings("unused")
    public Line getTrajectory() {
        return trajectory;
    }

    /**
     * Gets Collision GameLevel.GameObjects.Primitives.Point.
     *
     * @return GameLevel.GameObjects.Primitives.Point
     */
    public Point getCollisionPoint() {
        return collisionPoint;
    }

    /**
     * Finds Collision GameLevel.GameObjects.Primitives.Point.
     *
     * @return GameLevel.GameObjects.Primitives.Point
     */
    public Point collisionPoint() {
        double distance = Double.MAX_VALUE;
        Point point = null;
        Collidable collidable = null;
        for (Collidable c : environment.getCollidbles()) {
            Point pointTemp = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            if (pointTemp == null) {
                continue;
            }
            double distTemp = trajectory.getValuable().distance(pointTemp);
            if (distTemp < distance) {
                distance = distTemp;
                point = pointTemp;
                collidable = c;
            }
        }
        setCollidingWith(collidable);

        return point;
    }

    /**
     * Sets Collision.
     *
     * @param c GameLevel.GameObjects.Collidable
     */
    public void setCollidingWith(Collidable c) {
        collidingWith = c;
    }

    /**
     * the collidable object involved in the collision.
     *
     * @return GameLevel.GameObjects.Collidable
     */
    public Collidable collisionObject() {
        return collidingWith;
    }
}
