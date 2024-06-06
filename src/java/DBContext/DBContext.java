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

/**
 *
 * @author Admin
 */
public class DBContext {
    Connection connection;

    public Connection getConnection() {
        try {
            String user = "sa";
            String pass = "123";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=EShopper";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
    public static void main(String[] args){
        DAO dao = new DAO();
        System.out.println(dao.getAllCategory());
        System.out.println(dao.getProductByFID("1"));
        System.out.println(dao.getAllAccount());
        System.out.println(dao.getProductListByName("ring"));
        System.out.println(dao.getAllCartProduct("1"));
    }
}
