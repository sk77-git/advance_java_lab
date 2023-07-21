<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>HTML Form Data Processing</title>
</head>
<body>
    <h2>HTML Form Data Processing</h2>

    <%-- Check if the form is submitted --%>
    <% if (request.getMethod().equalsIgnoreCase("POST")) {
        // Retrieve form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        // Perform data processing or validation
        // For this example, we simply display the submitted data
    %>
    <p>Submitted Data:</p>
    <p>Name: <%= name %></p>
    <p>Email: <%= email %></p>
    <p>Message: <%= message %></p>
    <% } %>

    <form method="post" action="">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="message">Message:</label><br>
        <textarea id="message" name="message" rows="4" cols="30" required></textarea><br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
