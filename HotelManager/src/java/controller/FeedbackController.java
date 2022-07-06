
package controller;

import dao.impl.AccountDAOImpl;
import dao.impl.MessageDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Room;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "FeedbackController", urlPatterns = {"/FeedbackController"})
public class FeedbackController extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            MessageDAOImpl dao =new MessageDAOImpl();
            UserDAOImpl dao1 =new UserDAOImpl();
            AccountDAOImpl dao2 =new AccountDAOImpl();
            String service = request.getParameter("do");
            HttpSession session = request.getSession();
            if (service == null) {
                service = "Viewfeedback";
            }
            if (service.equals("Viewfeedback")) { //In ra tất cả các comment
                ArrayList vector =dao.getAllComment();
                ArrayList listAccount =dao2.getAccountList();
                
                request.setAttribute("vector", vector);
                request.setAttribute("listAccount", listAccount);
                request.getRequestDispatcher("managerFeedback.jsp").forward(request, response);
            }
            if (service.equals("Deletefeedback")) { //In ra tất cả các comment
                int mid =Integer.parseInt(request.getParameter("mID").toString());
                dao.deleteMessage(mid);
                response.sendRedirect("FeedbackController");
            }
            if (service.equals("ReportAccount")) { //In ra tất cả các comment
                int mid =Integer.parseInt(request.getParameter("mID").toString());
                int aid =Integer.parseInt(request.getParameter("aID").toString());                
                Cookie aID = new Cookie(request.getParameter("aID"), request.getParameter("mID"));
                aID.setMaxAge(60 * 60 * 24 * 7);
                response.addCookie(aID);
                response.sendRedirect("FeedbackController");
            }
            if (service.equals("ExitReport")) { //In ra tất cả các comment
                int mid =Integer.parseInt(request.getParameter("mID").toString());
                int aid =Integer.parseInt(request.getParameter("aID").toString());    
                Cookie aID = new Cookie(request.getParameter("aID"), request.getParameter("mID"));
                aID.setMaxAge(0);
                response.addCookie(aID);
                response.sendRedirect("FeedbackController");
            }
        }catch(Exception ex){
            ex.printStackTrace();
            request.getRequestDispatcher("Filter.jsp").forward(request, response);
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
