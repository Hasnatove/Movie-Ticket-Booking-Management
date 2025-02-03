import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    public static Connection connectDb() {
        try {
            String url = "jdbc:mysql://localhost:3306/moviebook"; // ডাটাবেজের নাম দিন
            String user = "root"; // আপনার MySQL ইউজারনেম
            String password = ""; // যদি পাসওয়ার্ড না থাকে, ফাঁকা রাখুন

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("❌ Database Connection Failed!");
            e.printStackTrace();
            return null;
        }
    }
}
