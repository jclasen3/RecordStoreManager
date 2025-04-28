package northofnola.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import northofnola.models.Media;

public class MediaDAO {
    /**
     * Retrieves all media records from the database.
     * 
     * @return List of Media objects representing all records in the media table.
     */
    public static List<Media> getAllMedia() {
        List<Media> mediaList = new ArrayList<>(); // List to hold media records
        String sql = "SELECT * FROM media"; // SQL query to select all media
        // Try-with-resources ensures the connection, statement, and result set are closed
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
                
            // Iterate over each row in the result set
            while (rs.next()) {
                Media media = new Media(); // Create a new Media object
                
                // Populate media fields from the result set
                media.setId(rs.getInt("id"));
                media.setTitle(rs.getString("title"));
                media.setArtist(rs.getString("artist"));
                media.setFormat(rs.getString("format"));
                media.setPrice(rs.getBigDecimal("price"));
                // Add the media object to the list
                mediaList.add(media);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mediaList;
    }
    
    /**
     * Searches media records by keyword in the title or artist (case-insensitive).
     *
     * @param keyword The search keyword entered by the user.
     * @return List of matching Media objects.
     */
    public static List<Media> searchMedia(String keyword) {
        List<Media> mediaList = new ArrayList<>();
        String sql = "SELECT * FROM media WHERE LOWER(title) LIKE ? OR LOWER(artist) LIKE ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Format the search term with wildcards and convert to lowercase
            String searchTerm = "%" + keyword.toLowerCase() + "%";
            // Bind parameters for title and artist fields
            stmt.setString(1, searchTerm);
            stmt.setString(2, searchTerm);

            try (ResultSet rs = stmt.executeQuery()) {
                // Iterate through the result set and map results to Media objects
                while (rs.next()) {
                    Media media = new Media();
                    media.setId(rs.getInt("id"));
                    media.setTitle(rs.getString("title"));
                    media.setArtist(rs.getString("artist"));
                    media.setFormat(rs.getString("format"));
                    media.setPrice(rs.getBigDecimal("price"));
                    mediaList.add(media);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mediaList;
    }

    /**
     * Retrieves a single media item from the database by its ID.
     *
     * @param id The unique ID of the media item.
     * @return The corresponding Media object, or null if not found.
     */
    public static Media getMediaById(int id) {
        Media media = null;
        String sql = "SELECT * FROM media WHERE id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Bind the media ID to the query
            stmt.setInt(1, id);
            
             // If the record exists, populate the Media object
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    media = new Media();
                    media.setId(rs.getInt("id"));
                    media.setTitle(rs.getString("title"));
                    media.setArtist(rs.getString("artist"));
                    media.setFormat(rs.getString("format"));
                    media.setPrice(rs.getBigDecimal("price"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return media;
    }
}

