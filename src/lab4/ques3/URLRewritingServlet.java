package lab4.ques3;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class URLRewritingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");

        HttpSession session = request.getSession();
        session.setAttribute("name", name);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>URL Rewriting - Session Tracking</title></head><body>");
        out.println("<h2>URL Rewriting - Session Tracking</h2>");
        out.println("<a href='displayDataServlet'>Display Data</a>");
        out.println("</body></html>");
    }
}

