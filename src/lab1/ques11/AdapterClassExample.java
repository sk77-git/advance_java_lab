package lab1.ques11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//11.	Write a program to show implementation of Adapter Class.
public class AdapterClassExample extends JFrame {
    private JLabel label;

    public AdapterClassExample() {
        setTitle("Adapter Class Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel("Click me!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label);
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    label.setText("Left Clicked!");
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    label.setText("Right Clicked!");
                }
            }
        };
        label.addMouseListener(mouseAdapter);
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AdapterClassExample();
            }
        });
    }
}

