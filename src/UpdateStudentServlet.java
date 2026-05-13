import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class UpdateStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String course = request.getParameter("course");
            int fee = Integer.parseInt(request.getParameter("fee"));

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(
                    "UPDATE students SET name=?, course=?, fee=? WHERE id=?"
            );

            ps.setString(1, name);
            ps.setString(2, course);
            ps.setInt(3, fee);
            ps.setInt(4, id);

            ps.executeUpdate();

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("viewStudents");
    }
}