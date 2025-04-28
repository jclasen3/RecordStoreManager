package northofnola.data;

import northofnola.models.User;
import java.sql.*;

public class UserDAO {
    
    /**
     * Inserts a new user record into the database.
     *
     * @param user A User object containing first name, last name, email, and password.
     */
    public static void insert(User user) {
        String sql = "INSERT INTO users (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();// Establish database connection
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Bind user data to the SQL query placeholders
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Validates a user's login credentials by checking if email and password match a record.
     *
     * @param email    The user's email address.
     * @param password The user's password.
     * @return A User object if credentials are valid; otherwise, null.
     */
    public static User validate(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Bind email and password to the SQL statement
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            
            // If a record is found, populate and return a User object
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(email);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

