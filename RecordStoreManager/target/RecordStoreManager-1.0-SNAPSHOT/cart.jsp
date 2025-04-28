<%@ page import="java.util.*, northofnola.models.CartItem" %>
<%@ include file="header.jsp" %>

<main class="container my-5">
    <h2 class="mb-4">Your Cart</h2>

    <%
        // Retrieve the cart from the session
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        // Check if cart is empty or doesn't exist
        if (cart == null || cart.isEmpty()) {
    %>
        <p>Your cart is empty.</p>
    <%
        } else {
    %>
        <!-- Table displaying cart items -->
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Artist</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            <%
                // Total cost for all cart items
                double total = 0;
                // Loop through each item in the cart
                for (CartItem item : cart) {
                    // Calculate total for each item
                    double itemTotal = item.getMedia().getPrice().doubleValue() * item.getQuantity();
                    total += itemTotal;
            %>
                <tr>
                    <!-- Display media details -->
                    <td><%= item.getMedia().getTitle() %></td>
                    <td><%= item.getMedia().getArtist() %></td>
                    <td>$<%= item.getMedia().getPrice() %></td>
                    <td><%= item.getQuantity() %></td>
                    <td>$<%= String.format("%.2f", itemTotal) %></td>
                    <td>
                        <!-- Form to remove item from cart -->
                        <form action="remove-from-cart" method="post">
                            <input type="hidden" name="mediaId" value="<%= item.getMedia().getId() %>">
                            <button type="submit" class="btn btn-danger btn-sm">Remove</button>
                        </form>
                    </td>
                </tr>
            <%
                }
            %>
                <!-- Display total cost for all items -->
                <tr>
                    <td colspan="4" class="text-end"><strong>Total:</strong></td>
                    <td colspan="2"><strong>$<%= String.format("%.2f", total) %></strong></td>
                </tr>
            </tbody>
        </table>
    <%
        }
    %>
</main>

<%@ include file="footer.jsp" %>


