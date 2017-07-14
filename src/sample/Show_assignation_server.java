package sample;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by jaliya on 7/13/17.
 */

@WebServlet("/ShowAssignation")
public class Show_assignation_server extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = new DBConnector().getConnection();

        try {
            String query = "select item_no,item_type,employee_no from items,employees where items.assignation=employees.index_no";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // List ll = new LinkedList();

            List<ItemDto> ll = new ArrayList<ItemDto>();


            while(rs.next()){

                String str1 = rs.getString(1);
                String str2 = rs.getString(2);
                String str3 = rs.getString(3);
                ItemDto item = new ItemDto(str1,str2,str3);

                ll.add(item);
            }

            String url="/Show_assignation.jsp";

            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher(url);

            request.setAttribute("accountList", ll );
            rd.forward(request, response);

        } catch (Exception e) {

            throw new ServletException("Error in showing current assignation", e);

        }

    }
}
