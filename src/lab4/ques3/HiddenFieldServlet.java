package lab4.ques3;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class HiddenFieldServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        session.setAttribute("name", name);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Hidden Field - Session Tracking</title></head><body>");
        out.println("<h2>Hidden Field - Session Tracking</h2>");
        out.println("<form action='displayDataServlet' method='post'>");
        out.println("<input type='hidden' name='name' value='" + name + "'>");
        out.println("<input type='submit' value='Display Data'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}

