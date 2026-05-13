import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");

            // 🔴 CHANGE PATH if needed
            conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/manas/IdeaProjects/EduTrack/students.db");

            System.out.println("DB Connected Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}