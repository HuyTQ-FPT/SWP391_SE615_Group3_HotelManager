package controller;

import dao.DeviceDAO;
import dao.ImageDAO;
import dao.RoomDAO;
import dao.impl.DevicesDAOImpl;
import dao.impl.ImageDAOImpl;
import dao.impl.RoomDAOImpl;
import entity.Device;
import entity.Image;
import entity.Room;
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

/**
 *
 * @author Minh Hiếu
 */
@WebServlet(name = "CompareTwoController", urlPatterns = {"/CompareTwoController"})
public class CompareTwoController extends HttpServlet {

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
        try {
            RoomDAO daoR = new RoomDAOImpl();
            ImageDAO daoI = new ImageDAOImpl();
            DeviceDAO daoD = new DevicesDAOImpl();
            String service = request.getParameter("do");

            if (service.equals("CompareTwoRoom")) { // so sánh 2 phòng
                int RoomID = Integer.parseInt(request.getParameter("Roomid").trim());
                int RoomID1 = Integer.parseInt(request.getParameter("Roomid1").trim());
                String cateID = request.getParameter("cateID").trim();

                Image img = daoR.searchRoomidAndImage(RoomID);
                Image img1 = daoR.searchRoomidAndImage(RoomID1);
                Room rooom = daoR.getOneRoom(RoomID);
                Room rooom1 = daoR.getOneRoom(RoomID1);
                Vector<Device> vectorD = daoD.getDevicebycateroom(cateID);

                request.setAttribute("Rooom", rooom);
                request.setAttribute("Rooom1", rooom1);
                request.setAttribute("img", img);
                request.setAttribute("img1", img1);
                request.setAttribute("cateid", cateID);
                request.setAttribute("vectorD", vectorD);
                request.getRequestDispatcher("compareFinal.jsp").forward(request, response);

            }

        }catch (Exception ex) {
            Logger.getLogger(CompareTwoController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("errorMess", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
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
            Logger.getLogger(CompareTwoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CompareTwoController.class.getName()).log(Level.SEVERE, null, ex);
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
