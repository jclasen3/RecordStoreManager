package northofnola.controllers;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import northofnola.models.Media;
import northofnola.data.MediaDAO;

@WebServlet("/catalog")// Maps requests with URL "/catalog" to this servlet
public class CatalogServlet extends HttpServlet {

    /**
     * Handles HTTP GET requests to display the media catalog. Supports optional
     * search functionality using a "query" parameter.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Retrieve the 'query' parameter from the request (used for search input)
        String query = request.getParameter("query");
        List<Media> mediaList;
        
        // If query is present and not empty, perform a search in the database
        if (query != null && !query.trim().isEmpty()) {
            mediaList = MediaDAO.searchMedia(query.trim()); // Search by title or artist
        } else {
            mediaList = MediaDAO.getAllMedia();
        }
        
        // Attach the media list to the request scope to make it available in the JSP
        request.setAttribute("mediaList", mediaList);
         // Forward the request and response to catalog.jsp for rendering
        RequestDispatcher dispatcher = request.getRequestDispatcher("catalog.jsp");
        dispatcher.forward(request, response);
    }
}



