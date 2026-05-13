import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String user = request.getParameter("username");
        String pass = request.getParameter("password");

        try {

            Connection con = LoginDBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM users WHERE username=? AND password=?"
            );

            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                HttpSession session = request.getSession();

                session.setAttribute("user", user);

                response.sendRedirect("dashboard.jsp");

            } else {

                request.setAttribute("error",
                        "Invalid Username or Password");

                RequestDispatcher rd =
                        request.getRequestDispatcher("login.jsp");

                rd.forward(request, response);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}