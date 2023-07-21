<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Exception Handling</title>
</head>
<body>
    <h2>Exception Handling</h2>

    <%-- Perform some operation that may throw an exception --%>
    <%
        try {
            // Simulating an exception by dividing by zero
            int result = 10 / 0;
            out.println("Result: " + result);
        } catch (ArithmeticException e) {
            out.println("<p>An error occurred: " + e.getMessage() + "</p>");
        }
    %>
</body>
</html>
