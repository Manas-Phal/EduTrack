import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class ViewStudentsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<String[]> list = new ArrayList<>();

        Map<String, Integer> courseFees =
                new HashMap<>();

        int totalFee = 0;
        int count = 0;
        int pending = 0;

        String search =
                request.getParameter("search");

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM students";

            if(search != null &&
                    !search.trim().isEmpty()) {

                query += " WHERE name LIKE ?";
            }

            PreparedStatement ps =
                    con.prepareStatement(query);

            if(search != null &&
                    !search.trim().isEmpty()) {

                ps.setString(
                        1,
                        "%" + search + "%"
                );
            }

            ResultSet rs =
                    ps.executeQuery();

            while(rs.next()) {

                String id =
                        rs.getString("id");

                String name =
                        rs.getString("name");

                String course =
                        rs.getString("course");

                String fee =
                        rs.getString("fee");

                String status =
                        rs.getString("status");

                // DEFAULT STATUS

                if(status == null ||
                        status.trim().isEmpty()) {

                    status = "Pending";
                }

                list.add(new String[] {
                        id,
                        name,
                        course,
                        fee,
                        status
                });

                int f = 0;

                try {
                    f = Integer.parseInt(fee);
                }
                catch(Exception e) {
                    f = 0;
                }

                count++;

                // ONLY PAID COUNTED IN REVENUE

                if(status.equalsIgnoreCase("Paid")) {

                    totalFee += f;
                }
                else {

                    pending++;
                }

                // COURSE ANALYTICS

                courseFees.put(
                        course,
                        courseFees.getOrDefault(course,0) + f
                );
            }

            con.close();

        }
        catch(Exception e) {

            e.printStackTrace();
        }

        // SEND DATA TO JSP

        request.setAttribute("data", list);

        request.setAttribute(
                "courseFees",
                courseFees
        );

        request.setAttribute(
                "totalFee",
                totalFee
        );

        request.setAttribute(
                "count",
                count
        );

        request.setAttribute(
                "pending",
                pending
        );

        // FOR PAYMENTS PAGE

        request.setAttribute(
                "payments",
                list
        );

        RequestDispatcher rd =
                request.getRequestDispatcher(
                        "viewStudents.jsp"
                );

        rd.forward(request,response);
    }
}