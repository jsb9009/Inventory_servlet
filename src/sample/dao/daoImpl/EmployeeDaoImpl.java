package sample.dao.daoImpl;

import sample.dao.EmployeeDao;
import sample.dto.EmployeeDto;
import sample.dto.ItemDto;
import sample.util.DBConnector;
import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by jaliya on 7/14/17.
 */

/**
 * Implementing the EmployeeDao interface
 */
public class EmployeeDaoImpl implements EmployeeDao {

    DBConnector db = new DBConnector();
    Connection con = db.getConnection();

    /**
     * user's item inputs are gathered and they are persisted to the database
     *
     * @param employeeDto
     * @return null
     */
    public ItemDto createEmployee(EmployeeDto employeeDto) {

        try {
            Statement stmt = con.createStatement();           //inheritance
            stmt.executeUpdate("INSERT INTO employees (employee_no,employee_name,position) VALUES ('" + employeeDto.getEmployeeNumber() + "','" + employeeDto.getEmployeeName() + "','" + employeeDto.getEmployeePosition() + "')");  //polymorphism  //encapsulation
            JOptionPane.showMessageDialog(null, "Employee successfully registered");
            con.close();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        return null;
    }

}
