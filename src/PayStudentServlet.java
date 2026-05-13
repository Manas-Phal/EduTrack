import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/payStudent")
public class PayStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String id = req.getParameter("id");

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE students SET status='Paid' WHERE id=?");
            ps.setInt(1, Integer.parseInt(id));

            ps.executeUpdate();

        } catch(Exception e){ e.printStackTrace(); }

        res.sendRedirect("viewStudents");
    }
}