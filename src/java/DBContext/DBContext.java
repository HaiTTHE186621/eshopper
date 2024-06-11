/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBContext;

import DAO.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext {

    // Create a logger instance for DBContext
    private static final Logger logger = Logger.getLogger(DBContext.class.getName());

    public Connection getConnection() {
        Connection connection = null;
        try {
            String user = System.getenv("sa");
            String pass = System.getenv("123");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=EShopper";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            logger.log(Level.SEVERE, "Failed to establish connection", ex);
        }
        return connection;
    }

    public static void main(String[] args) {
        DBContext dbContext = new DBContext();
        Connection connection = dbContext.getConnection();
        if (connection != null) {
            logger.log(Level.INFO, "Connection established successfully!");
        } else {
            logger.log(Level.WARNING, "Failed to establish connection.");
        }
    }
}
