package lab1.ques9;

import javax.swing.*;
import java.awt.*;

//9.	Write a program to use any five components in swing.
public class SwingComponentsExample extends JFrame {
    public SwingComponentsExample() {
        setTitle("Swing Components Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        // JLabel
        JLabel label = new JLabel("Enter your name:");
        add(label);
        // JTextField
        JTextField textField = new JTextField(15);
        add(textField);
        // JButton
        JButton button = new JButton("Submit");
        add(button);
        // JCheckBox
        JCheckBox checkBox = new JCheckBox("I agree to the terms and conditions");
        add(checkBox);
        // JTextArea
        JTextArea textArea = new JTextArea(5, 20);
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingComponentsExample();
            }
        });
    }
}