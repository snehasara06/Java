import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/cars",
                "root", "");
                Statement stmt = com.createStatement();) {

            String q1 = "select * from kia";
            ResultSet rset1 = stmt.executeQuery(q1);
            PrintWriter out = resp.getWriter();

            out.println("<html><body>");
            out.println("<h3> KIA TABLE </h3>");
            out.println("<table border='1' style='border-collapse: collapse;'>");
            out.println("<tr><th>ID</th><th>NAME</th><th>TYPE</th><th>FUEL</th><th>PRICE</th><th>SEATER</th></tr>");
            while (rset1.next()) {
                int id = rset1.getInt("id");
                String name = rset1.getString("name");
                String type = rset1.getString("type");
                String fuel = rset1.getString("fuel");
                String price = rset1.getString("price");
                int seater = rset1.getInt("seater");

                out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + type + "</td><td>" + fuel + "</td><td>"
                        + price + "</td><td>" + seater + "</td></tr>");
            }
            out.println("</table>");
            out.println("</body></html>");

            // System.out.println("QUERY 1 : " + q1 + "\n");

            String q2 = "update kia set price ='65.95 Lakh' where id=5";
            System.out.println("QUERY 2 : " + q2 + "\n");

            String q3 = "select * from kia where id=5";
            System.out.println("QUERY 3 : " + q3 + "\n");

            // System.out.println("Kia cars name with price");

            // int rowCount = 0;
            // out.print("<h4>KIA CARS WITH NAME & PRICE</h4>");
            // while (rset1.next()) {
            // resp.setContentType("text/html");

            // String name = rset1.getString("name");

            // String price = rset1.getString("price");

            // out.print("<br>" + name + " - " + price + "<br>");
            // System.out.println(name + " - " + price);
            // ++rowCount;
            // }
            rset1.close();

            // System.out.println("QUERY 2 : " + q2 + "\n");

            int count1 = stmt.executeUpdate(q2);
            System.out.println(count1 + " rows updated\n");

            ResultSet rset2 = stmt.executeQuery(q3);
            // System.out.println("Total number of car = " + rowCount);

            // out.print("<b>&nbsp;&nbsp;ID &nbsp;&nbsp;NAME &nbsp; TYPE &nbsp; FUEL &nbsp;
            // PRICE &nbsp; SEATER</b>");
            // out.print("<br>"+id+"&nbsp;"+name+"&nbsp;"+type+"&nbsp;"+fuel+"&nbsp;"+price+"&nbsp;"+seater+"<br>");
            out.print("<h3>UPDATE PRICE (ID=5)</h3>");

            out.println("<html><body>");
            out.println("<table border='1' style='border-collapse: collapse;'>");
            out.println("<tr><th>ID</th><th>NAME</th><th>TYPE</th><th>FUEL</th><th>PRICE</th><th>SEATER</th></tr>");
            while (rset2.next()) {
                int id = rset2.getInt("id");
                String name = rset2.getString("name");
                String type = rset2.getString("type");
                String fuel = rset2.getString("fuel");
                String price = rset2.getString("price");
                int seater = rset2.getInt("seater");
                out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + type + "</td><td>" + fuel + "</td><td>"
                        + price + "</td><td>" + seater + "</td></tr>");
            }
            out.println("</table>");
            out.println("</body></html>");
            rset2.close();

            String q5 = "delete from kia where name='seltos'";
            int count2 = stmt.executeUpdate(q5);
            System.out.println(count2 + " row deleted");
            out.println("<h3> DELETED ROW (NAME=SELTOS)");

            out.println("<html><body>");
            out.println("<table border='1' style='border-collapse: collapse;'>");
            out.println("<tr><th>ID</th><th>NAME</th><th>TYPE</th><th>FUEL</th><th>PRICE</th><th>SEATER</th></tr>");
            ResultSet rs = stmt.executeQuery(q1);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                String fuel = rs.getString("fuel");
                String price = rs.getString("price");
                int seater = rs.getInt("seater");
                out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + type + "</td><td>" + fuel + "</td><td>"
                        + price + "</td><td>" + seater + "</td></tr>");
            }
            out.println("</table>");
            out.println("</body></html>");
            rs.close();
            String q6 = "insert into kia values(id,'Sonet Facelift','Manual','Diesel','8.04 Lakh',5)";
            int count3 = stmt.executeUpdate(q6);
            System.out.println(count3 + " row inserted");
            ResultSet rset3 = stmt.executeQuery(q1);
            out.print("<h3>INSERT ONE ROW</h3>");

            out.println("<html><body>");
            out.println("<table border='1' style='border-collapse: collapse;'>");
            out.println("<tr><th>ID</th><th>NAME</th><th>TYPE</th><th>FUEL</th><th>PRICE</th><th>SEATER</th></tr>");
            while (rset3.next()) {
                int id = rset3.getInt("id");
                String name = rset3.getString("name");
                String type = rset3.getString("type");
                String fuel = rset3.getString("fuel");
                String price = rset3.getString("price");
                int seater = rset3.getInt("seater");
                out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + type + "</td><td>" + fuel + "</td><td>"
                        + price + "</td><td>" + seater + "</td></tr>");
            }
            out.println("</table>");
            out.println("</body></html>");
            rset3.close();

            q6 = "insert into kia values"
                    + "(id,'EV6','Automatic','Electric','60.95 Lakh',5),"
                    + "(id,'EV9','Automatic','Electric','90 Lakh',7)";
            System.out.println("\nMultiple insert: " + q6);
            count3 = stmt.executeUpdate(q6);
            System.out.println(count3 + " rows inserted.\n");

            // out.println("<h3>INSERT MULTIPLE ROWS</h3>");
            // ResultSet rset4 = stmt.executeQuery(q6);
            // out.println("<html><body>");
            // out.println("<table border='1' style='border-collapse: collapse;'>");
            // out.println("<tr><th>ID</th><th>NAME</th><th>TYPE</th><th>FUEL</th><th>PRICE</th><th>SEATER</th></tr>");
            // while (rset4.next()) {
            //     int id = rset4.getInt("id");
            //     String name = rset4.getString("name");
            //     String type = rset4.getString("type");
            //     String fuel = rset4.getString("fuel");
            //     String price = rset4.getString("price");
            //     int seater = rset4.getInt("seater");
            //     out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + type + "</td><td>" + fuel + "</td><td>"
            //             + price + "</td><td>" + seater + "</td></tr>");
            // }
            // out.println("</table>");
            // out.println("</body></html>");
            // rset4.close();

            String partialQuery = "insert into kia (id,name) values(id,'Rio')";
            System.out.println("PARTIAL QUERY: " + partialQuery);
            count3 = stmt.executeUpdate(partialQuery);
            System.out.println(count3 + " rows inserted");
            out.println("<h3>PARTIAL INSERT</h3>");

            // String q7 = "select * from kia";
            ResultSet rset5 = stmt.executeQuery(q1);
            out.println("<html><body>");
            out.println("<table border='1' style='border-collapse: collapse;'>");
            out.println("<tr><th>ID</th><th>NAME</th><th>TYPE</th><th>FUEL</th><th>PRICE</th><th>SEATER</th></tr>");
            while (rset5.next()) {
                int id = rset5.getInt("id");
                String name = rset5.getString("name");
                String type = rset5.getString("type");
                String fuel = rset5.getString("fuel");
                String price = rset5.getString("price");
                int seater = rset5.getInt("seater");
                out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + type + "</td><td>" + fuel + "</td><td>"
                        + price + "</td><td>" + seater + "</td></tr>");
            }
            out.println("</table>");
            out.println("</body></html>");
            rset5.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
