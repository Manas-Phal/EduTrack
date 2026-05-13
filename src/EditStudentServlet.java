import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class EditStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "SELECT * FROM students WHERE id=?"
            );

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                request.setAttribute("id", rs.getInt("id"));
                request.setAttribute("name", rs.getString("name"));
                request.setAttribute("course", rs.getString("course"));
                request.setAttribute("fee", rs.getInt("fee"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("editStudent.jsp");
        rd.forward(request, response);
    }
}