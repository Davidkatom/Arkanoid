package game.gameObjects.primitives;

import java.util.ArrayList;

/**
 * @author David Shnaiderov - 209198308
 * GameLevel.GameObjects.Primitives.Rectangle class
 * User ID - shnaidd1
 */
public class Rectangle {
    private static final int LEFT_Y = 0;
    private static final int RIGHT_Y = 1;
    private static final int TOP_X = 2;
    private static final int BOTTOM_X = 3;
    private final java.util.List<Line> boundaries = new ArrayList<>();


    /**
     * Returns left wall.
     *
     * @return Left GameLevel.GameObjects.Primitives.Line
     */
    public Line getLeftY() {
        return boundaries.get(LEFT_Y);
    }

    /**
     * Returns right wall.
     *
     * @return Right GameLevel.GameObjects.Primitives.Line
     */
    public Line getRightY() {
        return boundaries.get(RIGHT_Y);
    }

    /**
     * Returns Top Wall.
     *
     * @return Top GameLevel.GameObjects.Primitives.Line
     */
    public Line getTopX() {
        return boundaries.get(TOP_X);
    }

    /**
     * Returns Bottom Wall.
     *
     * @return Bottom GameLevel.GameObjects.Primitives.Line
     */
    public Line getBottomX() {
        return boundaries.get(BOTTOM_X);
    }


    /**
     * Create a new rectangle with location and width/height.
     *
     * @param upperLeft - Origin point.
     * @param width     - Width
     * @param height    - Height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        Point upperRight = new Point(upperLeft.getX() + width, upperLeft.getY());
        Point downLeft = new Point(upperLeft.getX(), upperLeft.getY() + height);
        Point downRight = new Point(upperLeft.getX() + width, downLeft.getY());

        boundaries.add(new Line(downLeft, upperLeft));
        boundaries.add(new Line(downRight, upperRight));
        boundaries.add(new Line(upperLeft, upperRight));
        boundaries.add(new Line(downLeft, downRight));
    }


    /**
     * Return a (possibly empty) List of intersection points
     * with the specified line.
     *
     * @param line - GameLevel.GameObjects.Primitives.Line for intersection.
     * @return List of intersection Points
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        java.util.List<Point> list = new ArrayList<>();
        for (Line l : boundaries) {
            Point intersection = l.intersectionWith(line);
            if (intersection != null) {
                list.add(intersection);
            }
        }

        return list;
    }


    /**
     * Return the width of the rectangle.
     *
     * @return double Width
     */
    public double getWidth() {
        return boundaries.get(TOP_X).length();
    }

    /**
     * Return the height of the rectangle.
     *
     * @return double Height
     */
    public double getHeight() {
        return boundaries.get(LEFT_Y).length();
    }


    /**
     * Returns the upper-left point of the rectangle.
     *
     * @return GameLevel.GameObjects.Primitives.Point - origin GameLevel.GameObjects.Primitives.Point
     */
    @SuppressWarnings("unused")
    public Point getUpperLeft() {
        return boundaries.get(TOP_X).start();
    }


}

