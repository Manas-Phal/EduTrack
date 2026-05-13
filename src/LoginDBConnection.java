import java.sql.Connection;
import java.sql.DriverManager;

public class LoginDBConnection {

    public static Connection getConnection() {

        Connection con = null;

        try {

            Class.forName("org.sqlite.JDBC");

            con = DriverManager.getConnection(
                    "jdbc:sqlite:C:/Users/manas/IdeaProjects/EduTrack/login.db"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}