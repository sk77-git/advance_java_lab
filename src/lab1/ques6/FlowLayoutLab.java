package lab1.ques6;

import javax.swing.*;
import java.awt.*;

//6.	Write a program to show implementation of flow layout.
public class FlowLayoutLab extends JFrame {
    public FlowLayoutLab() {
        setTitle("Flow Layout Lab");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel with FlowLayout
        JPanel panel = new JPanel(new FlowLayout());

        // Create buttons and add them to the panel
        for (int i = 1; i <= 5; i++) {
            JButton button = new JButton("Button " + i);
            panel.add(button);
        }

        // Add the panel to the frame
        add(panel);

        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FlowLayoutLab();
            }
        });
    }
}
