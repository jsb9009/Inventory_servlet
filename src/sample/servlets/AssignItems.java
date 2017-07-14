package sample.servlets;

import sample.dao.daoImpl.ItemDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jaliya on 7/13/17.
 */

/**
 * used to assign each item to an employee and save the assignation to the database
 */
@WebServlet("/AssignItem")
public class AssignItems extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("employeenumber")!=null && request.getParameter("itemnumber")!=null) {


            String employeeNumber = request.getParameter("employeenumber");
            String itemNumber = request.getParameter("itemnumber");

            ItemDaoImpl itemDaoImpl = new ItemDaoImpl();
            itemDaoImpl.assignItem(employeeNumber, itemNumber);

            response.sendRedirect("Assign_items.jsp");
        }



    }

}
