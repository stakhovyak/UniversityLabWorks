package labs.geom.lab1;

import math.geom2d.Point2D;
import math.geom2d.Shape2D;
import math.geom2d.ShapeArray2D;
import math.geom2d.line.Line2D;

import javax.swing.*;
import java.awt.*;

public class ShapeSet extends ShapeArray2D<Shape2D> {
    public void paintComponent(Graphics g) {
        for (Shape2D obj : this) {
            if (obj instanceof Line2D) {
                g.setColor(Color.RED);
                g.drawLine((int) ((Line2D) obj).getX1(), (int) ((Line2D) obj).getY1(),
                        (int) ((Line2D) obj).getX2(), (int) ((Line2D) obj).getY2());
            }

            if (obj instanceof Point2D) {
                g.setColor(Color.BLUE);
                g.fillOval((int) ((Point2D) obj).x(), (int) ((Point2D) obj).y(), 6, 6);
            }
        }
    }
    public static void main(String[] args) {
        var shSet = new ShapeSet();
        var point1 = new Point2D(10, 10);
        var point2 = new Point2D(300, 450);
        var point3 = new Point2D(500, 500);
        var point4 = new Point2D(100, 100);
        var line = new Line2D(point1, point2);
        var line1 = new Line2D(point4, point3);
        shSet.add(point2);
        shSet.add(point3);
        shSet.add(point4);
        shSet.add(line1);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                shSet.paintComponent(g);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }
}
