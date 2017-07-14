package sample.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by jaliya on 7/12/17.
 */

/**
 * providing the database connectivity to the project
 */
public class DBConnector {
    private final static String Driver = "com.mysql.jdbc.Driver";
    private final static String Url = "jdbc:mysql://localhost:3306/inventory_servlet";
    private final static String Username = "root";
    private final static String Password = "";
    Connection con;

    public Connection getConnection() {
        try {
            Class.forName(Driver);
            con = DriverManager.getConnection(Url, Username, Password);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error in DBConnector");
        }
        return con;
    }
}
