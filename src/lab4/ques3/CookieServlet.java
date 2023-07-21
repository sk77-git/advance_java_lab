package lab4.ques3;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");

        Cookie cookie = new Cookie("name", name);
        response.addCookie(cookie);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Cookie - Session Tracking</title></head><body>");
        out.println("<h2>Cookie - Session Tracking</h2>");
        out.println("<form action='displayDataServlet' method='post'>");
        out.println("<input type='submit' value='Display Data'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}

