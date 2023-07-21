package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//12.	Write a program to read two numbers from text field and sum and display in dialog box when button pressed.
public class TextFieldSumExample extends JFrame {
    private JTextField textField1;
    private JTextField textField2;

    public TextFieldSumExample() {
        setTitle("Text Field Sum Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        JButton sumButton = new JButton("Calculate Sum");
        ActionListener sumButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text1 = textField1.getText();
                String text2 = textField2.getText();
                try {
                    int num1 = Integer.parseInt(text1);
                    int num2 = Integer.parseInt(text2);
                    int sum = num1 + num2;
                    JOptionPane.showMessageDialog(TextFieldSumExample.this,
                            "The sum is: " + sum, "Sum Result", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(TextFieldSumExample.this,
                            "Invalid input! Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        sumButton.addActionListener(sumButtonListener);
        add(new JLabel("Number 1:"));
        add(textField1);
        add(new JLabel("Number 2:"));
        add(textField2);
        add(sumButton);
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TextFieldSumExample();
            }
        });
    }
}

