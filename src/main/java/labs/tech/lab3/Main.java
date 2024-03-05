package labs.tech.lab3;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        var p1 = new Point(30.0, 40.0);
        var p2 = new Point(50.0, 60.0);
        var colP1 = new ColoredPoint(20.4, 100.0, Color.RED);
        var colP2 = new ColoredPoint(70.9, 100.0, Color.YELLOW);

        var p3 = p1.clone();
        var colP3 = new ColoredPoint(90.0, 120.5, Color.BLUE);
        var line1 = new Line(p3, colP3);
        var line2 = new Line(200.0, 200.0, 300.0, 250.0);

        var p4 = new Point(300.0, 350.0);
        var colP5 = new ColoredPoint(180.0, 160.0, Color.GREEN);
        var line3 = new ColoredLine(p4, colP5, Color.green);
        var line4 = new ColoredLine(colP5, colP1);

        System.out.println("Clone of p1: " + p3);

        System.out.println("Point p1: " + p1);
        System.out.println("Point p2: " + p2);

        System.out.println("X coordinate of p1: " + p1.x());
        System.out.println("Y coordinate of p1: " + p1.y());

        System.out.println("Is p1 equal to p2? " + p1.equals(p2));
        System.out.println("Is p1 equal to p1? " + p1.equals(p1));

        System.out.println("Does p1 almost equals p2 with eps=0.1? " + p1.almostEquals(p2, 0.1));

        // Drawing on JPanel
        JFrame frame = new JFrame();
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                p1.draw(g2, 10.0);
                p2.draw(g2, 5.0);
                colP1.draw(g2, 4.0);
                colP2.draw(g2, 10.0);
                line1.draw(g2);
                colP3.draw(g2, 2);
                line2.draw(g2);
                line3.draw(g2);
                colP5.draw(g2, 5);
                p4.draw(g2, 3);
                line4.draw(g2);
            }
        };

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

