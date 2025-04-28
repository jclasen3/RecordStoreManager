package northofnola.data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnection() throws SQLException {
        try {
            // Ensure the driver is loaded
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // DB URL 
            String dbUrl = "jdbc:mysql://localhost:3306/record_store_db?useSSL=false&serverTimezone=UTC";
            
            // Connection with credentials
            return DriverManager.getConnection(dbUrl, "root", "pcm2017"); 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

