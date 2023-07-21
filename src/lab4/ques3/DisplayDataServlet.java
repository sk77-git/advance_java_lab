package lab4.ques3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class DisplayDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = (String) session.getAttribute("name");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Display Data - Session Tracking</title></head><body>");
        out.println("<h2>Display Data - Session Tracking</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("</body></html>");
    }
}

