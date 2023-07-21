package lab1.ques7;

import javax.swing.*;
import java.awt.*;

//7.	Write a program to show implementation of border layout.
public class BorderLayoutLab extends JFrame {
    public BorderLayoutLab() {
        setTitle("Border Layout Lab");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel with BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Create buttons and add them to the panel
        JButton northButton = new JButton("North");
        JButton southButton = new JButton("South");
        JButton eastButton = new JButton("East");
        JButton westButton = new JButton("West");
        JButton centerButton = new JButton("Center");

        panel.add(northButton, BorderLayout.NORTH);
        panel.add(southButton, BorderLayout.SOUTH);
        panel.add(eastButton, BorderLayout.EAST);
        panel.add(westButton, BorderLayout.WEST);
        panel.add(centerButton, BorderLayout.CENTER);

        // Add the panel to the frame
        add(panel);

        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BorderLayoutLab();
            }
        });
    }
}

