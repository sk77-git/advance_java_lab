<%@ page import="java.sql.*" %>
<%
    String companyName = request.getParameter("companyName");
    String city = request.getParameter("city");
    String zipCode = request.getParameter("zipCode");
    String url = "jdbc:mysql://localhost:3306/your_database_name";
    String username = "your_username";
    String password = "your_password";
    Connection conn = null;
    PreparedStatement pstmt = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, username, password);
        String sql = "INSERT INTO company (company_name, city, zip_code) VALUES (?, ?, ?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, companyName);
        pstmt.setString(2, city);
        pstmt.setString(3, zipCode);
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
        response.sendRedirect("success.html"); // Redirect to a success page
    } catch (Exception e) {
        e.printStackTrace();
        response.sendRedirect("error.html"); // Redirect to an error page
    }
%>
