package northofnola.controllers;

import jakarta.servlet.annotation.WebServlet;
import northofnola.models.Record;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/catalog")
public class CatalogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Hardcoded list of records
        List<Record> records = new ArrayList<>();
        records.add(new Record("Days Before Rodeo", "Travis Scott", 29.99));
        records.add(new Record("Noah Kahan(Live From Fenway)", "Noah Kahan", 49.99));
        records.add(new Record("Automatic", "The Lumineers", 24.99));

        // Send the records list to catalog.jsp
        request.setAttribute("records", records);
        request.getRequestDispatcher("catalog.jsp").forward(request, response);
    }
}

