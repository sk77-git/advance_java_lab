package lab1.ques3;

import javax.swing.*;
import java.awt.*;

//3.	Draw line, rectangle, circle using graphics in swing.
public class Shapes extends JFrame {
    public Shapes() {
        setTitle("Shapes Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Shapes();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawLine(50, 50, 200, 50);
        g.drawRect(50, 100, 150, 100);
        g.drawOval(50, 250, 150, 100);
    }
}
