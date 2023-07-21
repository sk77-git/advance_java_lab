<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Odd or Even Number</title>
</head>
<body>
    <h2>Odd or Even Number</h2>

    <%-- Check if the form is submitted --%>
    <% if (request.getMethod().equalsIgnoreCase("POST")) {
        // Retrieve form data
        int number = Integer.parseInt(request.getParameter("number"));
        String result = number % 2 == 0 ? "even" : "odd";
    %>
    <p>The number <%= number %> is <%= result %>.</p>
    <% } %>

    <form method="post" action="">
        <label for="number">Enter a number:</label>
        <input type="text" id="number" name="number" required><br><br>

        <input type="submit" value="Check">
    </form>
</body>
</html>
