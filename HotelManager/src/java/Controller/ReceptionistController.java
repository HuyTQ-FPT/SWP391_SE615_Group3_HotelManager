/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.impl.ReceptionistDAOImpl;
import Dao.impl.RoomDAOImpl;
import Dao.impl.UserDAOImpl;
import Entity.Account;
import Entity.Room;
import Entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ReceptionistController", urlPatterns = {"/ReceptionistController"})
public class ReceptionistController extends HttpServlet {

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
            ReceptionistDAOImpl dao = new ReceptionistDAOImpl();
            RoomDAOImpl daoR = new RoomDAOImpl();
            UserDAOImpl daoU = new UserDAOImpl();
            String service = request.getParameter("do");
            HttpSession session = request.getSession();
            if (service == null) {
                service = "Room";
            }
            if (service.equalsIgnoreCase("Room")) { //view List All Room

                Vector<Room> vectorR = daoR.getRoomListAll("select*from Room");
                request.setAttribute("vectorR", vectorR);
                request.getRequestDispatcher("ManagerRoom.jsp").forward(request, response);

            }

            if (service.equals("updateStatus")) { // cập nhật trạng thái phòng
                String rId = request.getParameter("rid");
                String status = request.getParameter("status");
                int Rid = Integer.parseInt(rId);
                int status1 = Integer.parseInt(status);
                daoR.updateStatus(Rid, status1);
                response.sendRedirect("ReceptionistController");
            }
            if (service.equalsIgnoreCase("Cus")) { //View List All Customer
                Vector<User> vectorU = dao.getCustomerListByReceptionist();
                request.setAttribute("vectorU", vectorU);
                request.getRequestDispatcher("ManagerCustomer.jsp").forward(request, response);
            }
            if (service.equalsIgnoreCase("profile")) { // view profile

                Account ac = (Account) session.getAttribute("login");

                User u = daoU.getUser(ac.getAccountID());
                request.setAttribute("u", u);
                request.getRequestDispatcher("profileReceptionist.jsp").forward(request, response);
            }
            if (service.equalsIgnoreCase("ViewupdateRecept")) { // update profile 
                Account ac = (Account) session.getAttribute("login");
                User u = daoU.getUser(ac.getAccountID());
                session.setAttribute("u", u);
                request.setAttribute("a", u);
                request.getRequestDispatcher("updateProfileReceptionist.jsp").forward(request, response);

            }
            if (service.equalsIgnoreCase("updateRecept")) {

                String uID = (String) request.getParameter("uid");
                String username = (String) request.getParameter("Username");
                String uEmail = (String) request.getParameter("EmailAddress").trim();
                String uCMT = (String) request.getParameter("inputCMT").trim();
                String uAddress = (String) request.getParameter("inputAddress").trim();
                String uPhone = (String) request.getParameter("inputPhone").trim();
                String birthday = (String) request.getParameter("birthday").trim();

                //convert
                int id = Integer.parseInt(uID);

                if (uEmail.length() < 5 || uCMT.length() < 5 || uAddress.length() < 5 || uPhone.length() < 5) {
                    String err = "Requires input greater than 5 characters";
                    request.setAttribute("err", err);
                    request.getRequestDispatcher("updateProfileReceptionist.jsp").forward(request, response);

                } else if (!uEmail.trim().matches("^[a-zA-Z]\\w+@gmail.com$")) {
                    String err = "Example: hieu1@gmail.com";
                    request.setAttribute("err", err);
                    request.getRequestDispatcher("updateProfileReceptionist.jsp").forward(request, response);
                } else if (!uCMT.trim().matches("^[0-9]{12}$")) {
                    String err = "Requires input number and  equal to 12 characters";
                    request.setAttribute("err", err);
                    request.getRequestDispatcher("updateProfileReceptionist.jsp").forward(request, response);

                } else if (uAddress.trim().length() > 100) {
                    String err = "Requires input less than 100 characters";
                    request.setAttribute("err", err);
                    request.getRequestDispatcher("updateProfileReceptionist.jsp").forward(request, response);

                } else if (!uPhone.trim().matches("^(09|03)+[0-9]{8}$")) {

                    String err = "Start 03|09 and 10 characters";
                    request.setAttribute("err", err);
                    request.getRequestDispatcher("updateProfileReceptionist.jsp").forward(request, response);
                } else {
                    daoU.updateUser(new User(id, username, uPhone, uEmail, birthday, uAddress, uCMT));
                    String mess = "Update success";
                    request.setAttribute("mess", mess);
                    request.getRequestDispatcher("updateProfileReceptionist.jsp").forward(request, response);
                }
            }

            if (service.equalsIgnoreCase("searchStatus")) {
                int status = Integer.parseInt(request.getParameter("status"));

                Vector<Room> vectorR = daoR.selectRoom(status);

                request.setAttribute("vectorR", vectorR);
                session.setAttribute("status1", status);

                request.getRequestDispatcher("ManagerRoom.jsp").forward(request, response);
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
            Logger.getLogger(ReceptionistController.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ReceptionistController.class
                    .getName()).log(Level.SEVERE, null, ex);
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
