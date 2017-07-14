package sample.servlets;

import sample.dao.daoImpl.ItemDaoImpl;
import sample.dto.ItemDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaliya on 7/14/17.
 */

/**
 * show the current free items
 */
@WebServlet("/ShowFreeItems")
public class ShowFreeItems extends HttpServlet {

    /**
     * get the database output from the dao layer and pass it to the front-end
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            ItemDaoImpl itemDao1 = new ItemDaoImpl();


            ResultSet rs1 = itemDao1.showFreeItem();


            List<ItemDto> list2 = new ArrayList<ItemDto>();

            while(rs1.next()){

                String str1 = rs1.getString(1);
                String str2 = rs1.getString(2);
                String str3 = rs1.getString(3);
                ItemDto item1 = new ItemDto(str1,str2,str3);

                list2.add(item1);
            }

            String url="/Show_free_items.jsp";

            ServletContext sc2 = getServletContext();
            RequestDispatcher rd2 = sc2.getRequestDispatcher(url);
            request.setAttribute("accountListFree", list2 );
            rd2.forward(request, response);

        } catch (Exception e) {

            throw new ServletException("Error in showing current assignation", e);

        }

    }
}


