/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.impl.AccountDAOImpl;
import Dao.impl.UserDAOImpl;
import Entity.Account;
import Entity.User;
import context.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            AccountDAOImpl dao = new AccountDAOImpl();
            UserDAOImpl dao2 = new UserDAOImpl();
            DBContext dao1 = new DBContext();
            String service = request.getParameter("do");
            if (service == null) {
                service = "Profile";
            }
            if (service.equals("Profile")) { //vào trang profile user
                Account a = (Account) session.getAttribute("login");
                ResultSet rs = dao.getData("select u.* from Account a join [User] u\n"
                        + "on a.AccountID=u.AccountID\n"
                        + "where [User]='" + a.getUser() + "' and [password]='" + a.getPassword() + "'");
                request.setAttribute("profile", rs);
                request.getRequestDispatcher("Profile.jsp").forward(request, response);
            }
            if (service.equals("Viewupdateprofile")) { // vào trang updateprofile
                String s = "";
                if (request.getParameter("er") != null) {
                    request.setAttribute("error", request.getParameter("er"));
                } else {
                    request.setAttribute("error", s);
                }
                System.out.println(request.getAttribute("error") + "okeee");
                Account a = (Account) session.getAttribute("login");
                ResultSet rs = dao.getData("select * from Account a join [User] u\n"
                        + "on a.AccountID=u.AccountID\n"
                        + "where [User]='" + a.getUser() + "' and [password]='" + a.getPassword() + "'");
                request.setAttribute("viewupdateprofile", rs);
                request.getRequestDispatcher("UpdateProfile.jsp").forward(request, response);
            }
            if (service.equals("Updateprofile")) { //cập nhập thông tin profile thay đổi
                System.out.println("oke");
                int uid = Integer.parseInt(request.getParameter("uid"));
                String user = request.getParameter("username");
                String pass = request.getParameter("password");
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                int gender = Integer.parseInt(request.getParameter("gender"));
                String bod = request.getParameter("bod");
                System.out.println(bod);
                String cmt = request.getParameter("cmt");
                ResultSet rs = dao.getData("select u.* from Account a join [User] u\n"
                        + "on a.AccountID=u.AccountID\n"
                        + "where [User]='" + user + "' and [password]='" + pass + "'");
                // điều kiện update thành công
                if (!name.equals("") && (gender == 1 || gender == 0) && !bod.equals("") && !email.equals("") && !phone.equals("") && !address.equals("") && !cmt.equals("")) {
                    dao2.updateUser(new User(uid, name, phone, email, gender, bod, address, cmt));
                    Cookie mess = new Cookie("mess", "mess");
                    mess.setMaxAge(5);
                    response.addCookie(mess);
                    response.sendRedirect("UserController");
                } else { //update thất bại
                    response.sendRedirect("UserController?do=Viewupdateprofile&er=1");

                }
            }
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
