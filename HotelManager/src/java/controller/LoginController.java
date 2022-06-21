<<<<<<< Updated upstream:HotelManager/src/java/controller/LoginController.java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
=======

package Controller;
>>>>>>> Stashed changes:HotelManager/src/java/Controller/LoginController.java

import dao.AccountDAO;
import dao.impl.AccountDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Account;
import util.SendMail;
import util.randomPassword;
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

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            AccountDAOImpl dao = new AccountDAOImpl();
            UserDAOImpl daoU = new UserDAOImpl();
            DBContext dao1 = new DBContext();
            String service = request.getParameter("do");
            if (service == null) {
                service = "Login";
            }
            if (service.equals("Login")) { // Set thông tin username, password vào trang login
                Cookie c[] = request.getCookies();
                for (Cookie o : c) {
                    if (o.getName().equals("user")) {
                        request.setAttribute("user", o.getValue());
                    }
                    if (o.getName().equals("pass")) {
                        request.setAttribute("pass", o.getValue());
                    }
                }
                String s = "";
                if (request.getParameter("mess") != null) {
                    request.setAttribute("mess", request.getParameter("mess"));
                } else {
                    request.setAttribute("mess", s);
                }
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
            if (service.equals("CheckLogin")) { // kiểm tra username/password => đăng nhập thành công hay không
                String username = request.getParameter("username").trim();
                String password = request.getParameter("password").trim();
                ResultSet rs = dao1.getData("select * from Account where [user]='" + username + "' and [password]='" + password + "'");
                if (rs.next() == true) {
                    if (request.getParameterValues("remember") != null) {
                        Cookie user = new Cookie("user", username);
                        Cookie pass = new Cookie("pass", password);
                        user.setMaxAge(60 * 60 * 24 * 7);
                        pass.setMaxAge(60 * 60 * 24 * 7);
                        response.addCookie(pass);
                        response.addCookie(user);
                    } else{
                        Cookie user = new Cookie("user", "");
                        Cookie pass = new Cookie("pass", "");
                        user.setMaxAge(0);
                        pass.setMaxAge(0);
                        response.addCookie(pass);
                        response.addCookie(user);
                    }
                    System.out.println(rs.getString(2));
                    if (rs.getString(2).equals("1")) {
                        session.setAttribute("login", new Account(rs.getInt(1), rs.getInt(2), username, password));
                        response.sendRedirect("HomeController");
                    } else if (rs.getString(2).equals("2")) {
                        session.setAttribute("login", new Account(rs.getInt(1), rs.getInt(2), username, password));
//                        response.sendRedirect("ReceptionistController");
                        response.sendRedirect("HomeController");
                    } else {
                        session.setAttribute("login", new Account(rs.getInt(1), rs.getInt(2), username, password));
                        response.sendRedirect("AdminController");
                    }
                } else {
                    String error = "Tài khoản hoặc mật khẩu không chính xác";
                    request.setAttribute("error", error);
                    request.setAttribute("mess", "");
                    request.setAttribute("username", username);
                    request.setAttribute("password", password);
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
            }
            if (service.equals("CheckRegister")) { // kiểm tra đăng ký thành công hay không
                String email = request.getParameter("email").trim();
                String username = request.getParameter("username").trim();
                String password = request.getParameter("password").trim();
                String re_password = request.getParameter("re_password").trim();
                String name = request.getParameter("name").trim();
                ResultSet rs = dao.getData("select * from Account");

                boolean user = true;
                boolean checkemail = true;
                int count = 0;
                while (rs.next()) {
                    if (rs.getString(3).equals(username)) {
                        user = false;
                        break;
                    }
                }
                while (rs.next()) {
                    if (rs.getString(3).equals(username)) {
                        checkemail = false;
                        break;
                    }
                }
                if (!user) {
                    request.setAttribute("name", name);
                    request.setAttribute("username", username);
                    request.setAttribute("password", password);
                    request.setAttribute("re_password", re_password);
                    request.setAttribute("email", email);
                    String error = "Tên đăng nhập đã tồn tại";
                    request.setAttribute("errorpass", error);
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                }else if(!checkemail){
                    request.setAttribute("name", name);
                    request.setAttribute("username", username);
                    request.setAttribute("password", password);
                    request.setAttribute("re_password", re_password);
                    request.setAttribute("email", email);
                    String error = "Tên email đã tồn tại";
                    request.setAttribute("errorpass", error);
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                }
                    else if (username.length() < 4 || password.length() < 8) {
                    request.setAttribute("name", name);
                    request.setAttribute("username", username);
                    request.setAttribute("password", password);
                    request.setAttribute("re_password", re_password);
                    request.setAttribute("email", email);
                    String error = "Mật khẩu lớn hơn 8 ký tự và tên dăng nhập lớn hơn 4 ký tự";
                    request.setAttribute("errorpass", error);
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                } else if (!password.equalsIgnoreCase(re_password)) {
                    request.setAttribute("name", name);
                    request.setAttribute("username", username);
                    request.setAttribute("password", password);
                    request.setAttribute("re_password", re_password);
                    request.setAttribute("email", email);
                    String error = "Nhập lại mật khẩu không chính xác";
                    request.setAttribute("errorpass", error);
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                } else {
                    count = dao.Register(new Account(1, username, password), name, email);

                }
                if (count > 0) {
                    session.setAttribute("login", new Account(1, 1, username, password));
                    response.sendRedirect("LoginController?do=Login&mess=register");
                } else {
                    request.setAttribute("name", name);
                    request.setAttribute("username", username);
                    request.setAttribute("password", password);
                    request.setAttribute("re_password", re_password);
                    request.setAttribute("email", email);
                    String error = "Lỗi hệ thống";
                    request.setAttribute("errorpass", error);
                    request.getRequestDispatcher("Register.jsp").forward(request, response);
                }
            }
            if (service.equals("ForgetPassword")) {// Gửi mật khẩu mới qua gamil
                try {
                    String email = request.getParameter("email");

                    if (daoU.checkUser(email.trim()) == null) { // Check đầu vào cho email
                        if (!email.trim().matches("^[a-zA-Z]\\w+@gmail.com$")) {
                            String eEmail = "Email không đúng định dạng!";
                            String exampleEmail = "Example: SWPGroup3@gmail.com";
                            request.setAttribute("eEmail", eEmail);
                            request.setAttribute("exampleEmail", exampleEmail);
                            request.setAttribute("email1", email);
                            request.getRequestDispatcher("ForgetPassword.jsp").forward(request, response);
                        } else {
                            String error = "Không tìm thấy Email đã đăng kí. Vui lòng nhập lại.";
                            request.setAttribute("error", error);
                            request.setAttribute("email1", email);
                            request.getRequestDispatcher("ForgetPassword.jsp").forward(request, response);

                        }

                    } else {
                        SendMail sm = new SendMail();
                        randomPassword rdP = new randomPassword();
                        String newPass = rdP.randomAlphaNumeric(8);
                        String message = "Mật khẩu mới của bạn là:" + newPass + "\n"
                                + "Nếu bạn muốn đổi mật khẩu click vào link này:" + "http://localhost:8080/HotelManager/LoginController";
                        sm.send(email, "Your new pass word!!!!", message, sm.getFromEmail(), sm.getPassword());
                        int n = dao.updateAccountAndUser(newPass, email);
                        String mess = "Gửi email thành công.";
                        request.setAttribute("mess", mess);
                        request.getRequestDispatcher("ForgetPassword.jsp").forward(request, response);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                    request.setAttribute("errorMess", ex.toString());
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
            }
            if (service.equals("ForgetPassword1")) { // vào trang quên mật khẩu
                request.getRequestDispatcher("ForgetPassword.jsp").forward(request, response);
            }
            if (service.equals("ChangePassword1")) { // vào trang đổi mật khẩu
                request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
            }
            if (service.equals("ChangePassword")) { // đổi mật khẩu 
                String error = "";
                Account a = (Account) session.getAttribute("login");
                String oldpassword = request.getParameter("oldpassword").trim();
                String newpassword = request.getParameter("password").trim();
                String re_password = request.getParameter("re_password").trim();
                ResultSet rs = dao1.getData("select * from Account where [user]='" + a.getUser().trim() + "' and [password]='" + oldpassword + "'");
                if (!a.getPassword().equals(oldpassword)) {
                    error = "Mật khẩu cũ không chính xác";
                    request.setAttribute("errorpass", error);
                    request.setAttribute("oldpassword", oldpassword);
                    request.setAttribute("newpassword", newpassword);
                    request.setAttribute("re_password", re_password);
                    request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
                }
                if (rs.next() == true) {

                    if (newpassword.trim().length() >= 8) {
                        if (newpassword.equals(re_password)) {
                            dao.updateAccount(rs.getString(3), re_password);
                            response.sendRedirect("LoginController?do=Login&mess=change");
                        } else if (!newpassword.equals(re_password)) {
                            error = "Mật khẩu mới không khớp nhau";
                            request.setAttribute("errorpass", error);
                            request.setAttribute("oldpassword", oldpassword);
                            request.setAttribute("newpassword", newpassword);
                            request.setAttribute("re_password", re_password);
                            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
                        } else {
                            error = "Mật khẩu mới giống với mật khẩu cũ";
                            request.setAttribute("errorpass", error);
                            request.setAttribute("oldpassword", oldpassword);
                            request.setAttribute("newpassword", newpassword);
                            request.setAttribute("re_password", re_password);
                            request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
                        }

                    } else {
                        error = "Mật khẩu mới lớn hơn 8 ký tự";
                        request.setAttribute("errorpass", error);
                        request.setAttribute("oldpassword", oldpassword);
                        request.setAttribute("newpassword", newpassword);
                        request.setAttribute("re_password", re_password);
                        request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
                    }
                } else {
                    error = "Đổi mật khẩu thất bại(Lỗi hệ thống)";
                    request.setAttribute("oldpassword", oldpassword);
                    request.setAttribute("newpassword", newpassword);
                    request.setAttribute("re_password", re_password);
                    request.setAttribute("errorpass", error);
                    request.getRequestDispatcher("ChangePassword.jsp").forward(request, response);
                }
            }
            if (service.equals("logout")) { // xử lý đăng xuất
                Cookie user = new Cookie("user", "");
                Cookie pass = new Cookie("pass", "");
                Cookie mess = new Cookie("mess", "");
                user.setMaxAge(0);
                pass.setMaxAge(0);
                mess.setMaxAge(0);
                response.addCookie(pass);
                response.addCookie(user);
                response.addCookie(mess);
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
        } catch (Exception ex) {
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
        } catch (Exception ex) {
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
