
package northofnola.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import northofnola.models.User;
import northofnola.data.UserDAO;

@WebServlet("/register")// Maps this servlet to handle form submissions to "/register"
public class RegisterServlet extends HttpServlet {
     /**
     * Handles POST requests from the registration form.
     * It creates a User object from the form data, saves it using UserDAO,
     * and then redirects to the account.jsp page.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create a new User object and populate it with form data
        User user = new User();
        user.setFirstName(request.getParameter("firstName"));// Get first name from form
        user.setLastName(request.getParameter("lastName")); // Get last name from form
        user.setEmail(request.getParameter("email")); // Get email from form
        user.setPassword(request.getParameter("password"));// Get password from form
        // Insert the new user into the database
        UserDAO.insert(user);
        response.sendRedirect("account.jsp");
    }
}
