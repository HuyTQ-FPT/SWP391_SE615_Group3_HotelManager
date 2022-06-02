/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.AccountDAO;
import Dao.impl.AccountDAOImpl;
import Entity.Account;
import Entity.SendMail;
import context.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
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
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            AccountDAOImpl dao = new AccountDAOImpl();
            DBContext dao1 = new DBContext();
            String service = request.getParameter("do");
            if (service == null) {
                service = "Login";
            }
            if (service.equals("Login")) {
                Cookie c[] = request.getCookies();
                for (Cookie o : c) {
                    if (o.getName().equals("user")) {
                        request.setAttribute("user", o.getValue());
                    }
                    if (o.getName().equals("pass")) {
                        request.setAttribute("pass", o.getValue());
                    }
                }
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
            if (service.equals("CheckLogin")) {
                System.out.println(service);
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                System.out.println(username);
                System.out.println(password);
                ResultSet rs = dao1.getData("select * from Account where [user]='" + username + "' and [password]='" + password + "'");
                if (rs.next() == true) {
                    if (request.getParameterValues("remember") != null) {
                        Cookie user = new Cookie("user", username);
                        Cookie pass = new Cookie("pass", password);
                        user.setMaxAge(60 * 60 * 24 * 7);
                        pass.setMaxAge(60 * 60 * 24 * 7);
                        response.addCookie(pass);
                        response.addCookie(user);
                    }
                    session.setAttribute("login", "login");
                    System.out.println(rs.getString(2));
                    if (rs.getString(2).equals("1")) {
                        response.sendRedirect("HomeController");
                    } else if (rs.getString(2).equals("2")) {
                        request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("indexAdmin.html").forward(request, response);
                    }
                } else {
                    String error = "Incorrect username or Password";
                    request.setAttribute("error", error);
                    response.sendRedirect("LoginController");
                }
            }
            if (service.equals("CheckRegister")) {
                String email = request.getParameter("email");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String re_password = request.getParameter("re_password");
                String name = request.getParameter("name");

                if (name.length() < 1) {
                    String error = "YourName must not emty";
                    request.setAttribute("errorpass", error);
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                }
                if (email.length() < 1) {
                    String error = "Email must not emty";
                    request.setAttribute("errorpass", error);
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                }
                if (username.length() < 4 || password.length() < 8) {
                    String error = "Passwords and Username more than 8 characters";
                    request.setAttribute("errorpass", error);
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                }
                if (!password.equalsIgnoreCase(re_password)) {
                    String error = "Re-Passwords incorrect";
                    request.setAttribute("errorpass", error);
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                }
                int n = dao.Register(new Account(1, username, password), name, email);
                if (n > 0) {
                    response.sendRedirect("Login.jsp");
                } else {
                    String error = "Username already exists";
                    request.setAttribute("error", error);
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                }
            }
            if (service.equals("ForgetPassword")) {
                String user = request.getParameter("name");
                String email = request.getParameter("email");
                if (dao.checkAccount(user) == null) {
                    String error = "User not exited!!";
                    request.setAttribute("error", error);

                    request.getRequestDispatcher("ForgetPassword.jsp").forward(request, response);

                } else {

                    SendMail sm = new SendMail();
                    String newPass = sm.randomAlphaNumeric(8);
                    request.setAttribute("newpass", newPass);

                    String message = "Mật khẩu mới của bạn là:" + newPass + "\n"
                            + "Nếu bạn muốn đổi mật khẩu click vào link này:" + "http://localhost:8080/HotelManager/ChangePassword.jsp";
                    sm.send(email, "Your new pass word!!!!", message, sm.getFromEmail(), sm.getPassword());
                    dao.updateAccount(user, newPass);
                    String mess = "Send gmail sucsess!!!";
                    request.setAttribute("mess", mess);
                    request.getRequestDispatcher("ForgetPassword.jsp").forward(request, response);
                }
            }
            if (service.equals("ChangePassword")) {
                String error = "";
                String username = request.getParameter("name");
                String oldpassword = request.getParameter("oldpassword");
                String newpassword = request.getParameter("password");
                String re_password = request.getParameter("re_password");
                ResultSet rs = dao1.getData("select * from Account where [user]='" + username + "' and [password]='" + oldpassword + "'");
                if (rs.next() == true) {
                    if (newpassword.equals(re_password)) {
                        dao.updateAccount(rs.getString(3), re_password);
                        response.sendRedirect("LoginController");
                    } else {
                        error = "re_password not same new_password";
                        request.setAttribute("errorpass", error);
                        request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
                    }
                } else {
                    error = "username or password incorrect";
                    request.setAttribute("errorpass", error);
                    request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
                }
            }
            if (service.equals("logout")) {
                Cookie user = new Cookie("user", "");
                Cookie pass = new Cookie("pass", "");
                user.setMaxAge(0);
                pass.setMaxAge(0);
                response.addCookie(pass);
                response.addCookie(user);
                session.removeAttribute("login");
                response.sendRedirect("HomeController");
            }
            if (service.equals("CheckForgetPassword")) {
                request.getRequestDispatcher("Login.jsp").forward(request, response);
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
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
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
