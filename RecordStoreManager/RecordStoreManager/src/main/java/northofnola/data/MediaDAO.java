package northofnola.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import northofnola.models.Media;

public class MediaDAO {
    public static List<Media> getAllMedia() {
        List<Media> mediaList = new ArrayList<>();
        String sql = "SELECT * FROM media";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Media media = new Media();
                media.setId(rs.getInt("id"));
                media.setTitle(rs.getString("title"));
                media.setArtist(rs.getString("artist"));
                media.setFormat(rs.getString("format"));
                media.setPrice(rs.getBigDecimal("price"));
                mediaList.add(media);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mediaList;
    }
}
