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

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Media> mediaList = MediaDAO.getAllMedia();
        request.setAttribute("mediaList", mediaList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("catalog.jsp");
        dispatcher.forward(request, response);

       
     
    }
}


