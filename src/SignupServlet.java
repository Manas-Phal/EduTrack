import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class SignupServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        try {

            Connection con =
                    LoginDBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(
                            "INSERT INTO users(username,password) VALUES(?,?)"
                    );

            ps.setString(1, user);
            ps.setString(2, pass);

            int rows = ps.executeUpdate();

            con.close();

            if(rows > 0){
                response.sendRedirect("login.jsp");
            }

        } catch(Exception e) {
            e.printStackTrace();
            response.getWriter().println(
                    "Error: " + e.getMessage()
            );
        }
    }
}