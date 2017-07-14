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
//FIXME Java class should use camel case naming convention
@WebServlet("/RegEmployee")
public class Register_employees_server extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("employeenumber") != null && request.getParameter("employeename") != null && request.getParameter("position") != null) {
            String employeeNumber = request.getParameter("employeenumber");
            String employeeName = request.getParameter("employeename");
            String position = request.getParameter("position");

            Connection con = new DBConnector().getConnection();
            try {
                Statement stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO employees(employee_no,employee_name,position) VALUES ('" + employeeNumber + "','" + employeeName + "','" + position + "')");
                JOptionPane.showMessageDialog(null, "Employee successfully registered");
                stmt.close();
                con.close();

            } catch (Exception e) {

                throw new ServletException("Error in registration", e);

            }
        }

        response.sendRedirect("Register_employees.jsp");
    }

}



