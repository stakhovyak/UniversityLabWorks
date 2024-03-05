package labs.tech.lab3;

import math.geom2d.GeometricObject2D;
import java.awt.*;

/**
 * Represents a line connecting two points in 2D space.
 */
public class Line implements GeometricObject2D, Drawable, Cloneable {

    private final Point point1;
    private final Point point2;

    /**
     * Constructs a new Line object with provided start and end points.
     * @param point1 The start point of the line.
     * @param point2 The end point of the line.
     */
    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    /**
     * Constructs a new Line object with provided coordinates.
     * @param x1 The x-coordinate of the start point.
     * @param y1 The y-coordinate of the start point.
     * @param x2 The x-coordinate of the end point.
     * @param y2 The y-coordinate of the end point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.point1 = new Point(x1, y1);
        this.point2 = new Point(x2, y2);
    }

    /**
     * Returns the start point of the line.
     * @return The start point of the line.
     */
    public Point getPoint1() {
        return point1;
    }

    /**
     * Returns the end point of the line.
     * @return The end point of the line.
     */
    public Point getPoint2() {
        return point2;
    }

    /**
     * Compares this Line object with another object for equality.
     * @param obj The object to be compared with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * Compares this Line object with another object for equality within a specified epsilon value.
     * @param obj The object to be compared with.
     * @param eps The epsilon value for comparison.
     * @return True if the objects are almost equal, false otherwise.
     */
    @Override
    public boolean almostEquals(GeometricObject2D obj, double eps) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Line edge)) {
            return false;
        } else {
            return this.point1.almostEquals(edge.point1, eps) && this.point2.almostEquals(edge.point2, eps);
        }
    }

    /**
     * Calculates and returns the length of the line.
     * @return The length of the line.
     */
    public double length() {
        return Math.sqrt(Math.pow((this.point2.x() - this.point1.x()), 2)
                + Math.pow((this.point2.y() - this.point1.y()), 2));
    }

    /**
     * Creates and returns a clone of this Line object.
     * @return A clone of this Line object.
     */
    @Override
    public Line clone() throws CloneNotSupportedException {
        return new Line(this.point1.clone(), this.point2.clone());
    }

    /**
     * Draws the Line object on a specified Graphics2D object.
     * @param g The Graphics2D object on which the line will be drawn.
     */
    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawLine((int) point1.x(), (int) point1.y(), (int) point2.x(), (int) point2.y());
    }
}
