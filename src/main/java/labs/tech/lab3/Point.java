package labs.tech.lab3;

import math.geom2d.GeometricObject2D;
import math.geom2d.Point2D;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Represents a point in a two-dimensional space with coordinates (x, y).
 */
public class Point implements GeometricObject2D, Drawable, Cloneable {
    private final double x;
    private final double y;

    /**
     * Constructs a new Point with the specified x and y.
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate of the point
     * @return the x-coordinate of the point
     */
    public double x() {
        return x;
    }

    /**
     * Returns the y-coordinate of the point
     * @return the y-coordinate of the point
     */
    public double y() {
        return y;
    }

    /**
     * Compares this point with the specified object for equality.
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Point) obj;
        return Double.doubleToLongBits(this.x) == Double.doubleToLongBits(that.x) &&
                Double.doubleToLongBits(this.y) == Double.doubleToLongBits(that.y);
    }

    /**
     * Returns a string representation of the point.
     * @return a string representation of the point
     */
    @Override
    public String toString() {
        return "Point[" +
                "x=" + x + ", " +
                "y=" + y + ']';
    }

    /**
     * Draws the point on a graphics context with a default radius of 1.0.
     * @param g the graphics context to draw on
     */
    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        this.draw(g, 1.0);
    }

    /**
     * Draws the point on a graphics context with a specified radius.
     * @param g2 the graphics context to draw on
     * @param r the radius of the point
     */
    public void draw(Graphics2D g2, double r) {
        g2.fill(new Ellipse2D.Double(this.x - r, this.y - r, 2.0 * r, 2.0 * r));
    }

    /**
     * Checks if this point is almost equal to the specified geometric object within a given epsilon.
     * @param obj the geometric object to compare with
     * @param eps the epsilon value for comparison
     * @return true if the objects are almost equal, false otherwise
     */
    public boolean almostEquals(GeometricObject2D obj, double eps) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Point2D p)) {
            return false;
        } else {
            if (Math.abs(this.x - p.x()) > eps) {
                return false;
            } else {
                return !(Math.abs(this.y - p.y()) > eps);
            }
        }
    }

    /**
     * Creates and returns a copy of this Point object.
     * @return a copy of this Point object
     * @throws CloneNotSupportedException if cloning is not supported
     */
    @Override
    public Point clone() throws CloneNotSupportedException {
        return (Point) super.clone();
    }
}
