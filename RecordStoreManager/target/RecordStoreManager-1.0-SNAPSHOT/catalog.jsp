<%@ page import="java.util.List" %>
<%@ page import="northofnola.models.Media" %>
<%@ include file="header.jsp" %>

<main class="container mt-4">
    <h2 class="mb-4 text-center">Our Collection</h2>
    
    <!-- Search form for filtering media by title or artist -->
    <form action="catalog" method="get" class="mb-4">
        <div class="input-group">
            <input type="text" name="query" class="form-control" placeholder="Search by title or artist..." value="<%= request.getParameter("query") != null ? request.getParameter("query") : ""%>">
            <button class="btn btn-outline-secondary" type="submit">Search</button>
        </div>
    </form>

    <table class="table table-striped table-bordered">
        <thead class="table-dark">
            <tr>
                <th>Title</th>
                <th>Artist</th>
                <th>Format</th>
                <th>Price</th>
            </tr>
        </thead>
        <tbody>
            <%
                // Retrieve media list from request attribute set by CatalogServlet
                List<Media> mediaList = (List<Media>) request.getAttribute("mediaList");
                // Check if the list is empty
                if (mediaList != null && !mediaList.isEmpty()) {
                    for (Media media : mediaList) {
            %>
            <tr>
                <td><%= media.getTitle()%></td>
                <td><%= media.getArtist()%></td>
                <td><%= media.getFormat()%></td>
                <td>
                    $<%= media.getPrice()%>
                    <form action="add-to-cart" method="post" class="d-inline ms-3">
                        <input type="hidden" name="mediaId" value="<%= media.getId()%>">
                        <button type="submit" class="btn btn-sm btn-outline-primary">Add to Cart</button>
                    </form>
                </td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="4" class="text-center">No results found.</td>
            </tr>
            <%
            }
        %>
        </tbody>
    </table>
</main>

<%@ include file="footer.jsp" %>





