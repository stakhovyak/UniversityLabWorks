package labs.tech.lab3;

import java.awt.*;

/**
 * A class representing a colored point in 2D space.
 */
public class ColoredPoint extends Point implements Colorable {
    private Color color;

    /**
     * Constructor for creating a ColoredPoint with a specified x, y, and color.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     * @param color the color of the point
     */
    public ColoredPoint(double x, double y, Color color) {
        super(x, y);
        this.color = color;
    }

    /**
     * Set the color of the point to the specified color.
     *
     * @param color the new color for the point
     */
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    /**
     * Draw the colored point with the given Graphics2D object and radius.
     *
     * @param g the Graphics2D object to use for drawing
     * @param r the radius of the point
     */
    public void draw(Graphics2D g, double r) {
        g.setColor(this.color);
        super.draw(g, r);
    }
}
