import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class PaymentsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<String[]> paymentList = new ArrayList<>();

        int paidCount = 0;
        int pendingCount = 0;
        int totalRevenue = 0;

        try {

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs =
                    st.executeQuery("SELECT * FROM students");

            while(rs.next()){

                String id =
                        String.valueOf(rs.getInt("id"));

                String name =
                        rs.getString("name");

                String course =
                        rs.getString("course");

                String fee =
                        rs.getString("fee");

                String status =
                        rs.getString("status");

                if(status == null){
                    status = "Pending";
                }

                paymentList.add(
                        new String[]{
                                id,
                                name,
                                course,
                                fee,
                                status
                        }
                );

                int f = Integer.parseInt(fee);

                if(status.equalsIgnoreCase("Paid")){

                    paidCount++;

                    totalRevenue += f;

                }else{

                    pendingCount++;
                }
            }

            con.close();

        } catch(Exception e){

            e.printStackTrace();
        }

        request.setAttribute("payments", paymentList);

        request.setAttribute("paidCount", paidCount);

        request.setAttribute("pendingCount", pendingCount);

        request.setAttribute("revenue", totalRevenue);

        RequestDispatcher rd =
                request.getRequestDispatcher("payments.jsp");

        rd.forward(request, response);
    }
}