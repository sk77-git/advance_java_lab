<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Print KCT 10 Times</title>
</head>
<body>
    <h2>Printing "KCT" 10 Times</h2>
    <%
        for (int i = 1; i <= 10; i++) {
            out.println("KCT ");
        }
    %>
</body>
</html>
