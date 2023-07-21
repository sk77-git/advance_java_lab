package lab4.ques1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FactorialServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the entered number from the request parameter
        int number = Integer.parseInt(request.getParameter("number"));

        // Calculate the factorial of the number
        int factorial = calculateFactorial(number);

        // Set the factorial as an attribute in the request
        request.setAttribute("factorial", factorial);

        // Forward the request and response to the result.jsp page
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    private int calculateFactorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        } else {
            return number * calculateFactorial(number - 1);
        }
    }
}

