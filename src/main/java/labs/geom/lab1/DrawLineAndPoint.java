package labs.geom.lab1;

import labs.geom.test.JavaGeomDemo;
import math.geom2d.Box2D;
import math.geom2d.Point2D;
import math.geom2d.line.StraightLine2D;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DrawLineAndPoint extends JPanel {
    public void drawComponent(Graphics g) {
        var graph2d = (Graphics2D) g;

        var rand = new Random();

        // Creating points
        var point1 = new Point2D(rand.nextDouble(), rand.nextDouble());
        var point2= new Point2D(rand.nextDouble(), rand.nextDouble());
        var point3 = new Point2D(rand.nextDouble(), rand.nextDouble());

        // Draw the point with radius of 5 pixels
        point1.draw(graph2d, 5);

        // Creating a line
        var line1 = new StraightLine2D(point2, point3);

        // Drawing the line, clipping it. (wtf)
        var box = new Box2D(0, 250, 0, 250);
        line1.clip(box).draw(graph2d);
    }

    public static void main(String[] args) {
        var panel = new DrawLineAndPoint();
        var frame = new JFrame("First lab work!");
        frame.setContentPane(panel);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
