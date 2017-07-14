package sample.dao.daoImpl;

import sample.dao.ItemDao;
import sample.dto.ItemDto;
import sample.util.DBConnector;
import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Created by jaliya on 7/14/17.
 */

/**
 * Implementing the ItemDao interface
 */
public class ItemDaoImpl implements ItemDao {

    DBConnector db = new DBConnector();
    Connection con = db.getConnection();

    /**
     * user's employee inputs are gathered and they are persisted to the database
     *
     * @param itemDto
     * @return null
     */

    @Override
    public ItemDto createItem(ItemDto itemDto) {

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO items (item_no,item_name,item_type) VALUES ('" + itemDto.getItemNumber() + "','" + itemDto.getItemName() + "','" + itemDto.getItemType() + "')");    //polymorphism   //encapsulation
            JOptionPane.showMessageDialog(null, "Item successfully registered");    //polymorphism

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return null;

    }

    /**
     * persist the assignation of an item with the item number and the employee number
     *
     * @param employeeNumber
     * @param itemNumber
     */
    public void assignItem(String employeeNumber, String itemNumber) {

        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("update items set assignation=(select index_no from employees where employee_no='" + employeeNumber + "') where item_no='" + itemNumber + "'");
            JOptionPane.showMessageDialog(null, "Item successfully assigned");
            stmt.close();
            con.close();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

        }

    }

    /**
     * show the current assigned items with their corresponding employees from the database
     * @return
     */
    public ResultSet showItem() {

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select item_no,item_type,employee_no from items,employees where items.assignation=employees.index_no");
            return rs;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

            return null;
        }
    }

    /**
     * show the current free items which can be assigned from database
     * @return
     */
    public ResultSet showFreeItem() {

        try {
            Statement stmt = con.createStatement();
            ResultSet rs1 = stmt.executeQuery("select item_no,item_name,item_type from items where assignation IS NULL");

            return rs1;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
