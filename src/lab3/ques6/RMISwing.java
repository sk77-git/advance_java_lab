package lab3.ques6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


//6.	Write a program using RMI and swing. Only use add, subtract, multiply and divide.
interface RemoteCalculator extends Remote {
    double add(double num1, double num2) throws RemoteException;

    double subtract(double num1, double num2) throws RemoteException;

    double multiply(double num1, double num2) throws RemoteException;

    double divide(double num1, double num2) throws RemoteException;
}


class RemoteCalculatorImpl extends UnicastRemoteObject implements RemoteCalculator {
    protected RemoteCalculatorImpl() throws RemoteException {
        super();
    }

    public double add(double num1, double num2) throws RemoteException {
        return num1 + num2;
    }

    public double subtract(double num1, double num2) throws RemoteException {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) throws RemoteException {
        return num1 * num2;
    }

    public double divide(double num1, double num2) throws RemoteException {
        return num1 / num2;
    }
}

class RMIServerSwing {
    public static void main(String[] args) {
        try {
            RemoteCalculator remoteCalculator = new RemoteCalculatorImpl();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("RemoteCalculator", remoteCalculator);

            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class RMIClientSwing extends JFrame implements ActionListener {
    private final JButton addButton;
    private final JButton subtractButton;
    private final JButton multiplyButton;
    private final JButton divideButton;
    private final JTextField num1Field;
    private final JTextField num2Field;
    private final JTextField resultField;

    private RemoteCalculator remoteCalculator;

    public RMIClientSwing() {
        setTitle("RMI Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Number 1:"));
        num1Field = new JTextField();
        panel.add(num1Field);

        panel.add(new JLabel("Number 2:"));
        num2Field = new JTextField();
        panel.add(num2Field);

        addButton = new JButton("Add");
        addButton.addActionListener(this);
        panel.add(addButton);

        subtractButton = new JButton("Subtract");
        subtractButton.addActionListener(this);
        panel.add(subtractButton);

        multiplyButton = new JButton("Multiply");
        multiplyButton.addActionListener(this);
        panel.add(multiplyButton);

        divideButton = new JButton("Divide");
        divideButton.addActionListener(this);
        panel.add(divideButton);

        panel.add(new JLabel("Result:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        panel.add(resultField);

        add(panel);
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            RemoteCalculator remoteCalculator = (RemoteCalculator) registry.lookup("RemoteCalculator");

            RMIClientSwing client = new RMIClientSwing();
            client.setRemoteCalculator(remoteCalculator);
            client.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(num1Field.getText());
            double num2 = Double.parseDouble(num2Field.getText());

            if (e.getSource() == addButton) {
                double result = remoteCalculator.add(num1, num2);
                resultField.setText(String.valueOf(result));
            } else if (e.getSource() == subtractButton) {
                double result = remoteCalculator.subtract(num1, num2);
                resultField.setText(String.valueOf(result));
            } else if (e.getSource() == multiplyButton) {
                double result = remoteCalculator.multiply(num1, num2);
                resultField.setText(String.valueOf(result));
            } else if (e.getSource() == divideButton) {
                double result = remoteCalculator.divide(num1, num2);
                resultField.setText(String.valueOf(result));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input! Please enter numeric values.");
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(this, "Error communicating with the server.");
        }
    }

    public void setRemoteCalculator(RemoteCalculator remoteCalculator) {
        this.remoteCalculator = remoteCalculator;
    }
}
