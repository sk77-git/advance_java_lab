package lab1.ques10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

//10.	Write a program to show implementation event handling using FocusListener.
public class FocusListenerExample extends JFrame {
    public FocusListenerExample() {
        setTitle("Focus Listener Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        JTextField textField1 = new JTextField(15);
        JTextField textField2 = new JTextField(15);
        FocusListener focusListener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                JTextField textField = (JTextField) e.getSource();
                textField.setBackground(Color.YELLOW);
            }

            @Override
            public void focusLost(FocusEvent e) {
                JTextField textField = (JTextField) e.getSource();
                textField.setBackground(Color.WHITE);
            }
        };
        textField1.addFocusListener(focusListener);
        textField2.addFocusListener(focusListener);
        add(new JLabel("Text Field 1:"));
        add(textField1);
        add(new JLabel("Text Field 2:"));
        add(textField2);
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FocusListenerExample();
            }
        });
    }
}

