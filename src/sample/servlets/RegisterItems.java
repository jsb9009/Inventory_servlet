package sample.servlets;

import sample.dao.ItemDao;
import sample.dao.daoImpl.ItemDaoImpl;
import sample.dto.ItemDto;
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
 * used to register items by getting item inputs from the front-end and save them in the database
 */
@WebServlet("/RegItem")
public class RegisterItems extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        if(request.getParameter("itemnumber")!=null && request.getParameter("itemname")!=null && request.getParameter("itemtype")!=null) {

            String itemNumber = request.getParameter("itemnumber");
            String itemName = request.getParameter("itemname");
            String itemType = request.getParameter("itemtype");

            ItemDto itemDto = new ItemDto(itemNumber,itemName,itemType);
            ItemDao itemDao = new ItemDaoImpl();
            itemDao.createItem(itemDto);

            response.sendRedirect("Register_items.jsp");
        }


    }
}



