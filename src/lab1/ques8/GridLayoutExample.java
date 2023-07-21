package lab1.ques8;

import javax.swing.*;
import java.awt.*;

public class GridLayoutExample extends JFrame {
    public GridLayoutExample() {
        setTitle("Grid Layout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel with GridLayout
        JPanel panel = new JPanel(new GridLayout(3, 3));

        // Create buttons and add them to the panel
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton("Button " + i);
            panel.add(button);
        }

        // Add the panel to the frame
        add(panel);

        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GridLayoutExample();
            }
        });
    }
}

