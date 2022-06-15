/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.impl.SendFeedbackDAOIpml;
import Entity.sendFeedback;
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
@WebServlet(name = "SendFeedbackController", urlPatterns = {"/SendFeedbackController"})
public class SendFeedbackController extends HttpServlet {

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

            SendFeedbackDAOIpml daoS = new SendFeedbackDAOIpml();
            HttpSession session = request.getSession();
            String service = request.getParameter("do");
            if (service == null) {
                try {
                    String email = request.getParameter("email");
                    String title = request.getParameter("title");
                    String message = request.getParameter("message");

                    daoS.insert(new sendFeedback(title, email, message));
                    String mEss = "Gửi yêu cầu thành công.";
                    request.setAttribute("mEss", mEss);
                    request.getRequestDispatcher("contact.jsp").forward(request, response);
                } catch (Exception e) {
                }

            }
            if (service.equalsIgnoreCase("listMessFeedBack")) {
                try {
                    Vector<sendFeedback> vectorS = new Vector<>();
                    Vector<sendFeedback> vectorS1 = new Vector<>();
                    vectorS = daoS.getMessage();
                    vectorS1= daoS.getMessageUnread();
                    request.setAttribute("vetorS", vectorS);
                    request.setAttribute("vetorS1", vectorS1);

                    request.getRequestDispatcher("requestMessage.jsp").forward(request, response);
                } catch (Exception e) {
                }

            }
            if(service.equalsIgnoreCase("SeenMessage")){
                try {
                    int id = Integer.parseInt(request.getParameter("mid"));
                    sendFeedback s = daoS.getMessageById(id);
                    daoS.updateRead(id, s.getIsRead());
                    request.setAttribute("s", s);
                    request.getRequestDispatcher("viewRequest.jsp").forward(request, response);
                } catch (Exception e) {
                }
            }
            if (service.equalsIgnoreCase("deleteMessage")) {
                try {
                    int id = Integer.parseInt(request.getParameter("mId"));
                    System.out.println(id);
                    daoS.delete(id);
                    String Mess = "Xoá thành công.";
                    request.setAttribute("Mess", Mess);
                    request.getRequestDispatcher("SendFeedbackController?do=listMessFeedBack").forward(request, response);

                } catch (Exception e) {
                }

            }
            if (service.equalsIgnoreCase("updateIsRead")) {
                try {

                    int id = Integer.parseInt(request.getParameter("mID"));
                    String isRead = request.getParameter("isRead");
                    System.out.println(isRead);
                    daoS.updateRead(id, isRead);
                    request.getRequestDispatcher("SendFeedbackController?do=listMessFeedBack").forward(request, response);
                } catch (Exception e) {
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
            Logger.getLogger(SendFeedbackController.class
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
            Logger.getLogger(SendFeedbackController.class
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
