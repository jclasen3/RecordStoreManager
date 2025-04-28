package northofnola.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import northofnola.models.User;
import northofnola.data.UserDAO;

@WebServlet("/login") // Maps this servlet to the "/login" URL
public class LoginServlet extends HttpServlet {
    /**
     * Handles POST requests for user login.
     * Authenticates the user with the provided email and password.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve email and password parameters from the login form
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
         // Validate credentials using UserDAO
        User user = UserDAO.validate(email, password);

        if (user != null) {
             // If user exists and credentials are valid, create a session and store the user object
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            // Redirect to homepage after successful login
            response.sendRedirect("index.jsp");
        } else {
             // If login fails, redirect back to account.jsp with an error flag
            response.sendRedirect("account.jsp?error=true");
        }
    }
}

