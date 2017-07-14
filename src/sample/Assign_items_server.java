package sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by jaliya on 7/13/17.
 */

//TODO move servelets to a new package called servelets
@WebServlet("/AssignItem")
public class Assign_items_server extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO move DB operations to DAO level
        if(request.getParameter("employeenumber")!=null && request.getParameter("itemnumber")!=null) {


            String employeeNumber = request.getParameter("employeenumber");
            String itemNumber = request.getParameter("itemnumber");


            Connection con = new DBConnector().getConnection();
            try {
                Statement stmt = con.createStatement();
                stmt.executeUpdate("update items set assignation=(select index_no from employees where employee_no='" + employeeNumber + "') where item_no='" + itemNumber + "'");
                JOptionPane.showMessageDialog(null, "Item successfully assigned");
                stmt.close();
                con.close();

            } catch (Exception e) {

                throw new ServletException("Error in assignation", e);

            }

            response.sendRedirect("Assign_items.jsp");
        }



    }

}
