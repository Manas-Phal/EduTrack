import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class DeleteStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM students WHERE id=?"
            );
            ps.setInt(1, id);
            ps.executeUpdate();

            res.sendRedirect("viewStudents");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}