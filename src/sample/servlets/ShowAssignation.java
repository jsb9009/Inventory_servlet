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
 * Created by jaliya on 7/13/17.
 */

/**
 * show the current assigned items
 */
@WebServlet("/ShowAssignation")
public class ShowAssignation extends HttpServlet {

    /**
     * get the database output from the dao layer and pass it to the front-end
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            ItemDaoImpl itemDao = new ItemDaoImpl();

            ResultSet rs = itemDao.showItem();

            List<ItemDto> list1 = new ArrayList<ItemDto>();

            while(rs.next()){

                String str1 = rs.getString(1);
                String str2 = rs.getString(2);
                String str3 = rs.getString(3);
                ItemDto item = new ItemDto(str1,str2,str3);

                list1.add(item);
            }


            String url="/Show_assignation.jsp";

            ServletContext sc1 = getServletContext();
            ServletContext sc2 = getServletContext();
            RequestDispatcher rd1 = sc1.getRequestDispatcher(url);
            RequestDispatcher rd2 = sc2.getRequestDispatcher(url);

            request.setAttribute("accountList", list1 );
            rd1.forward(request, response);

            request.setAttribute("accountListFree", list1 );
            rd2.forward(request, response);

        } catch (Exception e) {

            throw new ServletException("Error in showing current assignation", e);

        }

    }
}
