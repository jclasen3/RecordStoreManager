package northofnola.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import northofnola.models.Media;
import northofnola.models.CartItem;
import northofnola.data.MediaDAO;

import java.io.IOException;
import java.util.*;

@WebServlet("/add-to-cart")// Maps requests to /add-to-cart URL to this servlet

/**
 * Handles POST requests to add a media item to the user's shopping cart.
 */
public class AddToCartServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the media ID from the form/request parameter
        int mediaId = Integer.parseInt(request.getParameter("mediaId"));
        
        // Retrieve the Media object from the database using the mediaId
        Media media = MediaDAO.getMediaById(mediaId);

        if (media != null) {
            // Get or create a session for the user
            HttpSession session = request.getSession();
            // Try to get the cart from session
            List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
            
            // If no cart exists in the session, create a new one and store it
            if (cart == null) {
                cart = new ArrayList<>();
                session.setAttribute("cart", cart);
            }
            
            
            boolean found = false;
            // Check if the item is already in the cart
            for (CartItem item : cart) {
                if (item.getMedia().getId() == media.getId()) {
                    item.setQuantity(item.getQuantity() + 1);
                    found = true;
                    break;
                }
            }
            
             // If the item was not found in the cart, add it as a new CartItem
            if (!found) {
                CartItem newItem = new CartItem();
                newItem.setMedia(media);
                newItem.setQuantity(1);
                cart.add(newItem);
            }
        }

        response.sendRedirect("cart.jsp");
    }
}

