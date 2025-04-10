<%@ page import="java.util.List" %>
<%@ page import="northofnola.models.Media" %>
<%@ include file="header.jsp" %>

<main>
    <h2>Our Collection</h2>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Artist</th>
            <th>Format</th>
            <th>Price</th>
        </tr>
        <%
            List<Media> mediaList = (List<Media>) request.getAttribute("mediaList");
            if (mediaList != null) {
                for (Media media : mediaList) {
        %>
        <tr>
            <td><%= media.getTitle() %></td>
            <td><%= media.getArtist() %></td>
            <td><%= media.getFormat() %></td>
            <td>$<%= media.getPrice() %></td>
        </tr>
        <%
                }
            }
        %>
    </table>
</main>

<%@ include file="footer.jsp" %>



