package sample.servlets;

import sample.dao.EmployeeDao;
import sample.dao.daoImpl.EmployeeDaoImpl;
import sample.dto.EmployeeDto;
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
 * used to register employees by getting employee inputs from the front-end and save them in the database
 */
@WebServlet("/RegEmployee")
public class RegisterEmployees extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("employeenumber") != null && request.getParameter("employeename") != null && request.getParameter("position") != null) {

            String employeeNumber = request.getParameter("employeenumber");
            String employeeName = request.getParameter("employeename");
            String position = request.getParameter("position");

            EmployeeDto employeeDto = new EmployeeDto(employeeNumber,employeeName,position);
            EmployeeDao itemDao = new EmployeeDaoImpl();
            itemDao.createEmployee(employeeDto);

            response.sendRedirect("Register_employees.jsp");
    }

  }

}



