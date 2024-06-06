/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBContext.DBContext;
import Models.Account;
import Models.Cart;
import Models.Category;
import Models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM Product";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7)));
            }

        } catch (Exception e) {
        }

        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM Category";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }

        } catch (Exception e) {
        }

        return list;
    }

    public List<Product> getProductByFID(String forId) {
        List<Product> list = new ArrayList<>();
        String sql = "select *\n"
                + "from Product p\n"
                + "join [For] f on p.forid = f.forid\n"
                + "where f.forid = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, forId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7)));
            }

        } catch (Exception e) {
        }

        return list;
    }

    public List<Product> getProductListByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String sql = "select *\n"
                + "from Product p\n"
                + "join Category c on p.cid = c.cid\n"
                + "where c.cid = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7)));
            }

        } catch (Exception e) {
        }

        return list;
    }

    public Product getProductByPID(String pid) {
        Product p = new Product();
        String sql = "select *"
                + " from Product"
                + " where pid = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7));
            }

        } catch (Exception e) {
        }

        return p;
    }

    public List<Product> getProductListByName(String name) {
        List<Product> list = new ArrayList<>();
        String sql = "select *\n"
                + "from Product p\n"
                + "where p.[name] like ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7)));
            }

        } catch (Exception e) {
        }

        return list;
    }

    public List<Cart> getAllCartProduct(String id) {
        List<Cart> list = new ArrayList<>();
        String sql = "select amount, p.pid, p.name, p.image, p.price, p.des,\n"
                + "p.cid, p.forid\n"
                + "from Cart c\n"
                + "join Product p on c.pid = p.pid\n"
                + "where uid = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getInt(8));

                list.add(new Cart(p, rs.getInt(1)));
            }

        } catch (Exception e) {
        }

        return list;
    }

    public void removeCartItem(String pid, String uid) {
        String sql = "delete from Cart\n"
                + "where pid= ? and uid= ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, pid);
            ps.setString(2, uid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addCartItem(String pid, String uid, String amount) {
        String sql = "insert into Cart\n"
                + "Values(?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, pid);
            ps.setString(2, uid);
            ps.setString(3, amount);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void deleteProduct(String pid) {
        String sql = "delete from Product\n"
                + "where pid=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM Accounts";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt("uid"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getInt("roleid")));
            }

        } catch (Exception e) {
        }

        return list;
    }

    public void signup(String user, String pass) {
        String sql = "insert into Accounts\n"
                + "values(?,?,2)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addProduct(String name, String image, String price,
            String description, String category, String forid) {
        String sql = "insert into Product\n"
                + "values(?,?,?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, description);
            ps.setString(5, category);
            ps.setString(6, forid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateProduct(String name, String image, String price,
            String description, String category, String forid, String pid) {
        String sql = "update Product\n"
                + "set [name]=?,\n"
                + "[image]=?,\n"
                + "price =?,\n"
                + "[des] =?,\n"
                + "cid =?,\n"
                + "forid =?\n"
                + "where pid=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setString(3, price);
            ps.setString(4, description);
            ps.setString(5, category);
            ps.setString(6, forid);
            ps.setString(7, pid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
