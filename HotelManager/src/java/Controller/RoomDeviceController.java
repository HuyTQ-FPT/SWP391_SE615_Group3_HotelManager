/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.impl.DeviceDAOImpl;
import Dao.impl.RoomCategoryDAOImpl;
import Dao.impl.RoomDAOImpl;
import Entity.Device;
import Entity.Room;
import Entity.RoomCategory;
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
            RoomDAOImpl daos = new RoomDAOImpl();
            RoomCategoryDAOImpl roomcate = new RoomCategoryDAOImpl();
            String cateroom = request.getParameter("cateroom");
            String mess;
            if (cateroom == null) {
                cateroom = "1";
                mess = ""; 
            }
            else{
                mess = "(Room.RoomcateID="+cateroom+") and";
            }
            if (dos.equals("listroom")) {
                String RoomId = request.getParameter("roomID");
                int n = dao.getPage();
                Vector<Room> listroom
                        = dao.getRoomList1("select * from room  join CateRoom  on Room.RoomcateID = CateRoom.RoomcateID \n"
                                + "				where "+mess+" (Roomdesc like'%%' or Roomprice like'%%')\n"
                                + "				order by Room.RoomID desc");
                int page = dao.getPage("select Count(*) from Room");
                request.setAttribute("devicesss", "devicesss");
                request.setAttribute("listroom", listroom);
                request.setAttribute("page", page);
                Room rooom = daos.getRooms(cateroom);
                Vector<RoomCategory> romcate = roomcate.getRoomCategoryList("select * from CateRoom");
                request.setAttribute("romcate", romcate);
                request.setAttribute("rooom", rooom);
//                out.println("<h1>Servlet RoomcategoryController at " + listroom + ""
//                        + "va" + page + "</h1>");
                out.println("<h1>Servlet RoomcategoryController at " + listroom +"</h1>");
//                request.getRequestDispatcher("editroom.jsp").forward(request, response);
            }
//            if (dos.equals("getroom")) {
//
//            }
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
