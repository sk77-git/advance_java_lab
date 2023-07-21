package lab2.ques4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

//4.	Write a program to create registration form using different JComponents.
// When the user clicks submit button, the entered data should store in database
// and on click of show button the data should be shown in JTable.
public class JdbcJTableForm extends JFrame {
    private JTextField nameField;
    private JPasswordField passwordField;
    private JComboBox<String> countryComboBox;
    private JButton submitButton;
    private JButton showButton;
    private JTable dataTable;

    private Connection connection;
    private Statement statement;

    public JdbcJTableForm() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        setTitle("Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        nameField.setPreferredSize(new Dimension(200, 25));

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);
        passwordField.setPreferredSize(new Dimension(200, 25));

        JLabel countryLabel = new JLabel("Country:");
        String[] countries = {"USA", "Canada", "UK"};
        countryComboBox = new JComboBox<>(countries);
        countryComboBox.setPreferredSize(new Dimension(200, 25));

        submitButton = new JButton("Submit");
        showButton = new JButton("Show Data");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String password = new String(passwordField.getPassword());
                String country = (String) countryComboBox.getSelectedItem();
                insertData(name, password, country);
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retrieveAndDisplayData();
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(countryLabel);
        panel.add(countryComboBox);
        panel.add(submitButton);
        panel.add(showButton);

        add(panel);
        setVisible(true);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JdbcJTableForm();
            }
        });
    }

    private void insertData(String name, String password, String country) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
            String query = "INSERT INTO registration (name, password, country) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, country);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Data inserted successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to insert data.");
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void retrieveAndDisplayData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
            String query = "SELECT * FROM registration";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("ID");
            tableModel.addColumn("Name");
            tableModel.addColumn("Password");
            tableModel.addColumn("Country");
            while (resultSet.next()) {
                Object[] row = new Object[4];
                row[0] = resultSet.getInt("id");
                row[1] = resultSet.getString("name");
                row[2] = resultSet.getString("password");
                row[3] = resultSet.getString("country");
                tableModel.addRow(row);
            }
            dataTable = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(dataTable);
            JFrame displayFrame = new JFrame("Data Display");
            displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            displayFrame.add(scrollPane);
            displayFrame.pack();
            displayFrame.setVisible(true);
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
