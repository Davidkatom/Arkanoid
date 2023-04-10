package game.gameObjects.primitives;

import biuoop.DrawSurface;
import game.GameLevel;
import game.gameObjects.Sprite;

import java.awt.Color;
import java.util.Arrays;

/**
 * @author David Shnaiderov - 209198308
 * GameLevel.GameObjects.Primitives.Line
 * GameLevel.GameObjects.Primitives.Line Class
 * User ID - shnaidd1
 */

public class Line implements Sprite {
    private static final double EPSILON = 0.1;
    private double m;
    private double b;
    private boolean isPoint;
    private final Point start;
    private final Point end;
    private Color color = Color.white;


    private Point valuable = null;

    /**
     * Constructor.
     * @param start Start point
     * @param end End point
     * @param color Color
     */
    public Line(Point start, Point end, Color color) {
        this(start, end, false);
        this.color = color;
    }

    /**
     * Constructor.
     *
     * @param start - start point
     * @param end   - end point
     */
    public Line(Point start, Point end) {
        this(start, end, false);
    }

    /**
     * Constructor.
     *
     * @param start - start point
     * @param end   - end point
     * @param ray   - is ray
     */
    public Line(Point start, Point end, Boolean ray) {
        if (start.getX() <= end.getX()) {
            this.start = start;
            this.end = end;
        } else {
            this.start = end;
            this.end = start;
        }
        if (ray) {
            valuable = start;
        }
        func();
    }

    /**
     * Gets the valuable point.
     *
     * @return GameLevel.GameObjects.Primitives.Point
     */
    public Point getValuable() {
        return valuable;
    }

    /**
     * Constructor.
     *
     * @param x1 - Start x position
     * @param y1 - Start y position
     * @param x2 - End x position
     * @param y2 - End y position
     */
    @SuppressWarnings("unused")
    public Line(double x1, double y1, double x2, double y2) {
        if (x1 <= x2) {
            this.start = new Point(x1, y1);
            this.end = new Point(x2, y2);
        } else {
            this.start = new Point(x2, y2);
            this.end = new Point(x1, y1);
        }
        func();
    }

    /**
     * Checks if the line has the same start and end points.
     *
     * @return True or False
     */
    public Boolean getIsPoint() {
        return this.isPoint;
    }

    /**
     * Finds the GameLevel.GameObjects.Primitives.Line function and determines parameters.
     */
    private void func() {
        if (this.start().equals(this.end())) {
            isPoint = true;
            m = Double.MAX_VALUE;
            b = Double.MAX_VALUE;
            return;
        } else {
            isPoint = false;
        }

        if (this.start.getX() == this.end.getX()) {
            m = Double.MAX_VALUE;
            b = Double.MAX_VALUE;
            return;
        }
        this.m = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
        b = this.start.getY() - this.m * this.start.getX();
    }

    /**
     * Gets slope value.
     *
     * @return - Gets M value
     */
    public Double getM() {
        return this.m;
    }

    /**
     * Gets b value.
     *
     * @return - Gets b value
     */
    public Double getB() {
        return this.b;
    }


    /**
     * Return the length of the line.
     *
     * @return - line Length
     */
    public double length() {
        return start.distance(end);
    }


    /**
     * Returns the middle point of the line.
     *
     * @return - middle GameLevel.GameObjects.Primitives.Point.
     */
    @SuppressWarnings("unused")
    public Point middle() {
        double x = (start.getX() + end.getX()) / 2;
        double y = (start.getY() + end.getY()) / 2;
        return new Point(x, y);
    }

    /**
     * Returns the start point of the line.
     *
     * @return - Start GameLevel.GameObjects.Primitives.Point
     */
    public Point start() {
        return start;
    }

    /**
     * Returns the end point of the line.
     *
     * @return - End GameLevel.GameObjects.Primitives.Point
     */
    public Point end() {
        return end;
    }

    /**
     * Checks if a line Contains another line.
     *
     * @param other - other line
     * @return - True or False
     */
    public boolean checkIfContains(Line other) {
        double thisYStart = Math.min(this.start.getY(), this.end.getY());
        double thisYEnd = Math.max(this.start.getY(), this.end.getY());
        double otherYStart = Math.min(other.start.getY(), other.end.getY());
        double otherYEnd = Math.max(other.start.getY(), other.end.getY());

        if (this.getM().equals(other.getM()) && this.getB().equals(other.getB())) {
            if (this.getM() != Double.MAX_VALUE) {
                return !(this.end().getX() < other.start().getX()) && !(this.start().getX() > other.end().getX());
            } else {
                return this.start().getX() == other.start().getX()
                        && !(thisYEnd < otherYStart) && !(thisYStart > otherYEnd);
            }
        }
        return false;
    }

    /**
     * Returns true if the lines intersect, false otherwise.
     *
     * @param other - Other line
     * @return - True or False
     */
    @SuppressWarnings("unused")
    public boolean isIntersecting(Line other) {
        if (checkIfContains(other)) {
            return true;
        }
        return intersectionWith(other) != null;
    }


    /**
     * Checks if lines are points and if one of the points is on a line.
     *
     * @param other     - other line
     * @param intervalX - X interval
     * @return :-1 - no intersections.
     * 0 - lines are not points.
     * 1 - found intersection - this.
     * 2 - found intersection - other.
     */
    private int linesArePoints(Line other, double[] intervalX) {
        if (this.getIsPoint() && other.getIsPoint()) {
            if (this.start().equals(other.start())) {
                return 1;
            } else {
                return -1;
            }
        }
        if (this.getIsPoint()) {
            if (pointOnLine(this.start(), other, intervalX)) {
                return 1;
            } else {
                return -1;
            }
        }
        if (other.getIsPoint()) {
            if (pointOnLine(other.start(), this, intervalX)) {
                return 2;
            } else {
                return -1;
            }
        }
        return 0;
    }

    /**
     * Returns the intersection point if the lines intersect,
     * and null otherwise.
     *
     * @param other - Other GameLevel.GameObjects.Primitives.Line
     * @return - Intersection GameLevel.GameObjects.Primitives.Point
     */
    public Point intersectionWith(Line other) {
        double x;
        double y;

        double[] intervalX = {Math.max(this.start().getX(), other.start().getX()),
                Math.min(this.end().getX(), other.end().getX())};

        double[] yPoints = {this.start().getY(), this.end.getY(), other.end().getY(), other.start().getY()};
        Arrays.sort(yPoints);
        double[] intervalY = new double[2];
        System.arraycopy(yPoints, 1, intervalY, 0, 2);

        //Check if lines don't share X values
        if (this.end().getX() < other.start().getX() || other.end.getX() < this.start().getX()) {
            return null;
        }

        //Check if lines don't share Y values
        if ((Math.max(this.start().getY(), this.end().getY()) < Math.min(other.start().getY(), other.end().getY()))
                || (Math.min(this.start().getY(), this.end().getY())
                > Math.max(other.start().getY(), other.end().getY()))) {
            return null;
        }

        //Checks if lines are points and if one of the points is on a line.
        int value = linesArePoints(other, intervalX);
        switch (value) {
            case -1:
                return null;
            case 1:
                return this.start();
            case 2:
                return other.start();
            default:
                break;
        }
        //In case the lines are parallel
        if (this.getM().equals(other.getM())) {
            return checkForContinuation(other);
        }
        //In case the lines are vertical
        if (this.getM().equals(Double.MAX_VALUE)) {
            x = this.start().getX();
            y = other.getM() * x + other.getB();
        } else if (other.getM().equals(Double.MAX_VALUE)) {
            x = other.start().getX();
            y = this.getM() * x + this.getB();

        } else {
            x = (other.getB() - this.getB()) / (this.getM() - other.getM());
            y = other.getM() * x + other.getB();
        }
        //Checks if inside interval
        if (!inInterval(intervalX, x) || !inInterval(intervalY, y)) {
            return null;
        }

        return new Point(x, y);
    }

    /**
     * Checks if x value in Interval.
     *
     * @param interval - value interval
     * @param a        - value
     * @return - True or False
     */
    private boolean inInterval(double[] interval, double a) {
        return !(a < Math.min(interval[1], interval[0]) - EPSILON)
                && !(a > Math.max(interval[1], interval[0]) + EPSILON);
    }

    /**
     * Checks if a point is on a given line.
     *
     * @param point    - received GameLevel.GameObjects.Primitives.Point
     * @param line     - received GameLevel.GameObjects.Primitives.Line
     * @param interval - x value interval
     * @return - True or False
     */
    public boolean pointOnLine(Point point, Line line, double[] interval) {
        if (!line.getM().equals(Double.MAX_VALUE)) {
            double y = line.getM() * point.getX() + line.getB();
            return Math.abs(point.getY() - y) < EPSILON
                    && inInterval(interval, point.getX());
        } else {
            return Math.abs(point.getX() - line.start().getX()) < EPSILON
                    && line.inInterval(interval, point.getY());
        }
    }

    /**
     * Checks if a GameLevel.GameObjects.Primitives.Point is on a line.
     *
     * @param point GameLevel.GameObjects.Primitives.Point
     * @return Boolean
     */
    public boolean pointOnLine(Point point) {
        double[] intervalX = {this.start().getX(), this.end.getX()};
        double[] intervalY = {Math.min(this.start().getY(), this.end.getY()),
                Math.max(this.start().getY(), this.end.getY())};
        if (!this.getM().equals(Double.MAX_VALUE)) {
            return pointOnLine(point, this, intervalX);
        } else {
            return pointOnLine(point, this, intervalY);
        }
    }

    /**
     * Checks if this line is a continuation of a given line.
     *
     * @param other - given line
     * @return - Intersection GameLevel.GameObjects.Primitives.Point
     */
    public Point checkForContinuation(Line other) {
        if (this.equals(other)) {
            return null;
        }
        if (this.end().equals(other.start())) {
            return this.end();
        }
        if (this.start().equals(other.end())) {
            return this.start();
        }
        return null;
    }

    /**
     * return the closest intersection point to the
     * start of the line in a rectangle.
     *
     * @param rect - given rectangle
     * @return - null or closest point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        java.util.List<Point> list = rect.intersectionPoints(this);
        return closestIntersectionToStartOfLine(list);

    }

    /**
     * return the closest intersection point to the
     * start of the line.
     *
     * @param list - given colidbles
     * @return - null or closest point
     */
    public Point closestIntersectionToStartOfLine(java.util.List<Point> list) {
        if (list.isEmpty()) {
            return null;
        }

        Point closestPoint = null;
        double distance = Double.MAX_VALUE;
        for (Point point : list) {
            double tempDist = point.distance(this.valuable);
            if (distance > tempDist) {
                distance = tempDist;
                closestPoint = point;
            }
        }
        return closestPoint;
    }

    /**
     * return true is the lines are equal, false otherwise.
     *
     * @param other - other GameLevel.GameObjects.Primitives.Line
     * @return - True or False
     */
    public boolean equals(Line other) {
        return (other.start().equals(this.start()) && other.end().equals(this.end()));
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.drawLine((int) this.start.getX(), (int) this.start.getY(), (int) this.end.getX(), (int) this.end.getY());
    }

    @Override
    public void timePassed() {

    }

    @Override
    public void addToGame(GameLevel g) {

    }
}