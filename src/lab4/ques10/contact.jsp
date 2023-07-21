<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contact Manager</title>
</head>
<body>
    <h2>Contact Manager</h2>

    <%-- Display contacts --%>
    <% for (Contact contact : contacts) { %>
        <p>Name: <%= contact.getName() %></p>
        <p>Email: <%= contact.getEmail() %></p>
        <p>Phone: <%= contact.getPhone() %></p>
        <hr>
    <% } %>

    <%-- Add contact form --%>
    <h3>Add Contact</h3>
    <form method="post" action="contact">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" required><br><br>

        <input type="submit" value="Add Contact">
    </form>
</body>
</html>
