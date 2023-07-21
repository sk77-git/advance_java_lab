package lab2.ques3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//3.	Write a program to show record insertion in employee table using PreparedStatement.
public class JDBCRecordInsertion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO employees (name, email, salary) VALUES ( ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "John Doe");
            preparedStatement.setString(2, "johndoe@example.com");
            preparedStatement.setDouble(3, 50000.0);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Record inserted successfully.");
            } else {
                System.out.println("Failed to insert record.");
            }
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

