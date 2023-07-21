package lab1.ques4;

import javax.swing.*;
import java.awt.*;

//4.	Demonstrate color and shape with color filled inside using swing.
public class ColorAndShape extends JFrame {
    public ColorAndShape() {
        setTitle("Shapes and Color Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ColorAndShape();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(50, 100, 150, 100);
        g.setColor(Color.BLUE);
        g.fillRect(50, 100, 150, 100);
        g.drawOval(50, 250, 150, 100);
        g.setColor(Color.RED);
        g.fillOval(50, 250, 150, 100);
    }
}
