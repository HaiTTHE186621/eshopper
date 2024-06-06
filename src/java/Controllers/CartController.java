/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAO.DAO;
import Models.Account;
import Models.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class CartController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        List<Cart> list = new ArrayList<>();
        DAO dao = new DAO();
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        HttpSession session = request.getSession();
        Account acc = new Account();
        acc = (Account) session.getAttribute("acc");
        String uid = Integer.toString(acc.getUid());
        int sum = 0;

        list = dao.getAllCartProduct(uid);
        for (Cart a : list) {
            sum += a.getProduct().getPprice() * a.getAmount();
        }
        
        if (action.equals("delete")) {
            String pid = request.getParameter("pid");
            uid = request.getParameter("uid");
            dao.removeCartItem(pid, uid);

            list = dao.getAllCartProduct(uid);
            sum = 0;
            for (Cart a : list) {
                sum += a.getProduct().getPprice() * a.getAmount();
            }
            request.setAttribute("sum", sum);
            request.setAttribute("list", list);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
            return;
        }
        
        if (action.equals("add")){
            String pid = request.getParameter("pid");
            uid = request.getParameter("uid");
            String amount = request.getParameter("amount");
//            int amount = Integer.parseInt(amountr);

            dao.addCartItem(pid, uid, amount);
            list = dao.getAllCartProduct(uid);
            sum = 0;
            for (Cart a : list) {
                sum += a.getProduct().getPprice() * a.getAmount();
            }
            request.setAttribute("sum", sum);
            request.setAttribute("list", list);
            request.getRequestDispatcher("cart.jsp").forward(request, response);
            return;
           
        }
        
        request.setAttribute("sum", sum);
        request.setAttribute("list", list);
        request.getRequestDispatcher("cart.jsp").forward(request, response);

//        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
