/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.AccountDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Account;
import entity.User;
import context.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            AccountDAOImpl dao = new AccountDAOImpl();
            UserDAOImpl daoU = new UserDAOImpl();
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
                String m= "";
                if (request.getParameter("er") != null) {
                    request.setAttribute("error", request.getParameter("er"));
                    request.setAttribute("messerror", request.getParameter("me"));
                } else {
                    request.setAttribute("error", s);
                    request.setAttribute("meserror", m);
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
<<<<<<< Updated upstream:HotelManager/src/java/controller/UserController.java
                System.out.println("oke");
                int n = 0;
=======
                int n=0;
>>>>>>> Stashed changes:HotelManager/src/java/Controller/UserController.java
                int uid = Integer.parseInt(request.getParameter("uid"));
                String name = request.getParameter("name").trim();
                String email = request.getParameter("email").trim();
                String phone = request.getParameter("phone").trim();
                String address = request.getParameter("address").trim();
                int gender = Integer.parseInt(request.getParameter("gender"));
                Date bod = Date.valueOf(request.getParameter("bod").trim());
                System.out.println(bod);
                String cmt = request.getParameter("cmt").trim();
                // điều kiện update thành công
<<<<<<< Updated upstream:HotelManager/src/java/controller/UserController.java
                boolean checkemail = false;
                boolean checkphone = false;
                boolean checkcmnd = false;
                if (phone.length() == 10 && dao2.isNumeric(cmt) && dao2.isNumeric(phone)) {
                    n = dao2.updateUser(new User(uid, name, phone, email, gender, bod, address, cmt));
                } else { //update thất bại
                    response.sendRedirect("UserController?do=Viewupdateprofile&er=1");
=======

                if (phone.trim().length()==10 && cmt.trim().length()==12 && dao2.isNumeric(cmt) && dao2.isNumeric(phone)) {
                    n=dao2.updateUser(new User(uid, name, phone, email, gender, bod, address, cmt));                    
>>>>>>> Stashed changes:HotelManager/src/java/Controller/UserController.java
                }
                if (n > 0) {
                    Cookie mess = new Cookie("mess", "mess");
                    mess.setMaxAge(3);
                    response.addCookie(mess);
                    response.sendRedirect("UserController");
                }else{
                    session.setAttribute("email", email);
                    session.setAttribute("name", name);
                    session.setAttribute("phone", phone);
                    session.setAttribute("address", address);
                    session.setAttribute("bod", bod);
                    session.setAttribute("cmt", cmt);
                    session.setAttribute("gender", gender);
                    
                }
                if (phone.trim().length()!=10) {
                    String messerror="So dien thoai chi duoc 10 so";
                    response.sendRedirect("UserController?do=Viewupdateprofile&er="+messerror+"&me=1");
                } else if (cmt.trim().length()!=12) { 
                    String messerror="CMND chi duoc 12 so";
                    response.sendRedirect("UserController?do=Viewupdateprofile&er="+messerror+"&me=1");
                } else if (!dao2.isNumeric(cmt)) {
                    String messerror="CMND chi gom cac ky tu tu 0-9";
                    response.sendRedirect("UserController?do=Viewupdateprofile&er="+messerror+"&me=1");
                } else if (dao2.isNumeric(phone)) {
                    String messerror="SDT chi gom cac ky tu tu 0-9";
                    response.sendRedirect("UserController?do=Viewupdateprofile&er=1"+messerror+"me=1");
                }
                
            }
            if(service.equals("Viewfeedback")){
                Account ac = (Account) session.getAttribute("login");
                User u = daoU.getUser(ac.getAccountID());
                request.setAttribute("Fname", u.getUserName());
                request.getRequestDispatcher("Feedback.jsp").forward(request, response);
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