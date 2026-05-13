import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class AnalyticsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        // Store course-wise student count
        Map<String, Integer> courseMap = new HashMap<>();

        // Payment stats
        int paid = 0;
        int pending = 0;
        int totalRevenue = 0;

        try {

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs =
                    st.executeQuery("SELECT * FROM students");

            while(rs.next()) {

                String course =
                        rs.getString("course");

                String fee =
                        rs.getString("fee");

                String status =
                        rs.getString("status");

                if(status == null ||
                        status.trim().isEmpty()) {

                    status = "Pending";
                }

                // Count students per course
                courseMap.put(
                        course,
                        courseMap.getOrDefault(course, 0) + 1
                );

                // Payment stats
                int f =
                        Integer.parseInt(fee);

                if(status.equalsIgnoreCase("Paid")) {

                    paid++;
                    totalRevenue += f;

                } else {

                    pending++;
                }
            }

            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        // Send data to analytics.jsp
        request.setAttribute(
                "courseMap",
                courseMap
        );

        request.setAttribute(
                "paid",
                paid
        );

        request.setAttribute(
                "pending",
                pending
        );

        request.setAttribute(
                "revenue",
                totalRevenue
        );

        // Forward to analytics page
        RequestDispatcher rd =
                request.getRequestDispatcher(
                        "analytics.jsp"
                );

        rd.forward(
                request,
                response
        );
    }
}