package northofnola.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import northofnola.models.CartItem;

import java.io.IOException;
import java.util.*;

@WebServlet("/remove-from-cart")
public class RemoveFromCartServlet extends HttpServlet {

    /**
     * Handles POST requests to remove an item from the cart.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the media ID from the request
        int mediaId = Integer.parseInt(request.getParameter("mediaId"));
        HttpSession session = request.getSession();
         // Retrieve the cart from the session
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        
        // If the cart exists, remove the item with the matching media ID
        if (cart != null) {
            cart.removeIf(item -> item.getMedia().getId() == mediaId);
        }

        response.sendRedirect("cart.jsp");
    }
}
