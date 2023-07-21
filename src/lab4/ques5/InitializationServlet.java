package lab4.ques5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InitializationServlet extends HttpServlet {
    private String databaseUrl;
    private String username;
    private String password;

    @Override
    public void init() throws ServletException {
        // Read the initialization parameters from web.xml
        databaseUrl = getServletContext().getInitParameter("databaseUrl");
        username = getServletContext().getInitParameter("username");
        password = getServletContext().getInitParameter("password");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Initialization Parameters</title></head><body>");
        out.println("<h2>Initialization Parameters</h2>");
        out.println("<p>Database URL: " + databaseUrl + "</p>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<p>Password: " + password + "</p>");
        out.println("</body></html>");
    }
}
