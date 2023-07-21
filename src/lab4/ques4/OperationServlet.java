package lab4.ques4;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OperationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operation = request.getParameter("operation");

        if (operation.equals("include")) {
            includeOperation(request, response);
        } else if (operation.equals("forward")) {
            forwardOperation(request, response);
        } else if (operation.equals("redirect")) {
            redirectOperation(request, response);
        } else {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Operation</title></head><body>");
            out.println("<h2>Invalid operation specified!</h2>");
            out.println("</body></html>");
        }
    }

    private void includeOperation(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Include Operation</title></head><body>");
        out.println("<h2>Included Content</h2>");

        // Include another servlet's output
        RequestDispatcher rd = request.getRequestDispatcher("/includedServlet");
        rd.include(request, response);

        out.println("<h2>Include Operation Completed</h2>");
        out.println("</body></html>");
    }

    private void forwardOperation(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward the request to another servlet
        RequestDispatcher rd = request.getRequestDispatcher("/forwardedServlet");
        rd.forward(request, response);
    }

    private void redirectOperation(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirect the request to another URL
        response.sendRedirect(request.getContextPath() + "/redirectedServlet");
    }
}

