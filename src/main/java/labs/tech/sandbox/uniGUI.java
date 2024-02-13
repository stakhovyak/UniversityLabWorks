package labs.tech.sandbox;

import javax.swing.*;
import java.awt.*;
public class uniGUI extends JPanel {
    public static void main(String[] args) {
        // Create a frame.
        var frame = new JFrame("Universal GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Creating the MenuBar and adding components
        var menuBar = new JMenuBar();
        var fileMenu = new JMenu("file");
        var helpMenu = new JMenu("help");
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        var openOption = new JMenuItem("Open");
        var saveAsOption = new JMenuItem("Save as");
        fileMenu.add(openOption).add(saveAsOption);

        // Creating the panel at bottom and adding components
        var panel = new JPanel(); // The panel is not visible in output
        var label = new JLabel("Your input sir..");
        var textField = new JTextField(200); // Accepts up to 200 characters
        var enterButton = new JButton("Enter");
        panel.add(label);
        panel.add(textField);
        panel.add(enterButton);

        // Let it be on center
        var textArea = new JTextArea();

        // Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, textArea);
        frame.setVisible(true);
    }
}