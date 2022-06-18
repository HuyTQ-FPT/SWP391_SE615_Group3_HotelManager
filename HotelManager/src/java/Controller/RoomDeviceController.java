/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.impl.RoomDAOImpl;
import Entity.Room;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "RoomNameController", urlPatterns = {"/RoomsController"})
public class RoomDeviceController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            String dos = request.getParameter("do");
            RoomDAOImpl dao = new RoomDAOImpl();
            if (dos == null) {
                String RoomId = request.getParameter("roomID");
                int n = dao.getPage();
                Vector<Room> listroom = dao.getRoomList1("select * from "
                        + "room  join CateRoom  on Room.RoomcateID = CateRoom.RoomcateID");
                int page = dao.getPage("select Count(*) from Room");
//                out.println("<h1>Servlet RoomcategoryController at " + listroom + ""
//                        + "va" + page + "</h1>");
                request.setAttribute("devicesss", "devicesss");
                request.getRequestDispatcher("editroomdevice.jsp").forward(request, response);
                
            }
        }
    }
//                out.println("<h1>Servlet RoomcategoryController at " + request.getContextPath() + "</h1>");

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
