import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class AddStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String course = req.getParameter("course");
        int fee = Integer.parseInt(req.getParameter("fee"));

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO students(name, course, fee) VALUES(?,?,?)"
            );

            ps.setString(1, name);
            ps.setString(2, course);
            ps.setInt(3, fee);

            ps.executeUpdate();
            res.sendRedirect("viewStudents");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}