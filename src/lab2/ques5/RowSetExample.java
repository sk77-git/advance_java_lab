package lab2.ques5;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;


//5.	Write a program to implement RowSet.
public class RowSetExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl(url);
            rowSet.setUsername(username);
            rowSet.setPassword(password);
            rowSet.setCommand("SELECT * FROM employees");
            rowSet.execute();
            while (rowSet.next()) {
                int id = rowSet.getInt("id");
                String name = rowSet.getString("name");
                String email = rowSet.getString("email");
                double salary = rowSet.getDouble("salary");
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email + ", Salary: " + salary);
            }
            rowSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
