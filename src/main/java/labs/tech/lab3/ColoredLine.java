package labs.tech.lab3;

import java.awt.*;

/**
 * A class representing a colored line that can be drawn on a graphics object.
 */
public class ColoredLine extends Line implements Drawable, Colorable {

    private Color color;


    public ColoredLine(ColoredPoint point1, ColoredPoint point2) {
        super(point1, point2);
        this.color = point1.getColor();
    }

    /**
     * Constructs a ColoredLine object with the specified points and color.
     *
     * @param point1 The starting point of the line.
     * @param point2 The ending point of the line.
     * @param color The color of the line.
     */
    public ColoredLine(Point point1, Point point2, Color color) {
        super(point1, point2);
        this.color = color;
    }

    /**
     * Set the color of the line.
     *
     * @param color The color to set.
     */
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Draw the colored line on the specified Graphics2D object.
     *
     * @param g The Graphics2D object on which to draw the line.
     */
    @Override
    public void draw(Graphics2D g) {
        g.setColor(this.color);
        g.drawLine((int) super.getPoint1().x(), (int) super.getPoint1().y(),
                (int) super.getPoint2().x(), (int) super.getPoint2().y());
    }
}
