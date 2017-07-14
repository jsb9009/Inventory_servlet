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

@WebServlet("/RegItem")
public class Register_items_server extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if(request.getParameter("itemnumber")!=null && request.getParameter("itemname")!=null && request.getParameter("itemtype")!=null) {

            String itemNumber = request.getParameter("itemnumber");
            String itemName = request.getParameter("itemname");
            String itemType = request.getParameter("itemtype");

            Connection con = new DBConnector().getConnection();
            try {
                Statement stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO items(item_no,item_name,item_type) VALUES ('" + itemNumber + "','" + itemName + "','" + itemType + "')");
                JOptionPane.showMessageDialog(null, "Item successfully registered");
                stmt.close();
                con.close();

            } catch (Exception e) {

                throw new ServletException("Error in registration", e);

            }

            response.sendRedirect("Register_items.jsp");
        }


    }
}



