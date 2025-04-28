package northofnola.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/logout")// Maps this servlet to handle requests at /logout
public class LogoutServlet extends HttpServlet {
    /**
     * Handles GET requests to log out the user.
     * It invalidates the current session and redirects the user to the homepage.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate(); 
        // Redirect the user to the homepage
        response.sendRedirect("index.jsp");
    }
}
