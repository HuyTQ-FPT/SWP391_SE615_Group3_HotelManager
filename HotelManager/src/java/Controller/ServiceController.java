/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.impl.DeviceDAOImpl;
import Dao.impl.RoomCategoryDAOImpl;
import Dao.impl.RoomDAOImpl;
import Dao.impl.ServiceDAOImpl;
import Entity.Device;
import Entity.Room;
import Entity.RoomCategory;
import Entity.Service;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Vector;
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
@WebServlet(name = "ServiceController", urlPatterns = {"/ServiceController"})
public class ServiceController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String doo = request.getParameter("do");
            String ServiceID = request.getParameter("ServiceID");
            RoomDAOImpl daos = new RoomDAOImpl();
            ServiceDAOImpl dao = new ServiceDAOImpl();
            DeviceDAOImpl daoss = new DeviceDAOImpl();
            if (doo.equals("servicedetail")) {
                Vector<Room> getroomlist = daos.getRoomList("select top (5) * from Room INNER JOIN Image on Image.RoomimgaeID= Room.RoomimgaeID\n"
                        + "                        JOIN CateRoom on Room.RoomcateID = CateRoom.RoomcateID\n"
                        + "                        where Room.Status =0 \n"
                        + "			   ORDER BY NEWID()");
                Vector<Room> getroomlist2 = daos.getRoomList("select top (4) * from Room INNER JOIN Image on Image.RoomimgaeID= Room.RoomimgaeID\n"
                        + "                        JOIN CateRoom on Room.RoomcateID = CateRoom.RoomcateID\n"
                        + "                        where Room.Status =0 \n"
                        + "			   ORDER BY NEWID()");
                Service se = dao.getServicedetail(ServiceID);
                request.setAttribute("se", se);
                request.setAttribute("vector", getroomlist);
                request.setAttribute("getroomlist2", getroomlist2);
                request.getRequestDispatcher("viewRoom.jsp").forward(request, response);
            }
            if (doo.equals("getdeviceroom")) {
                String cateroom = request.getParameter("cateroom");
                if (cateroom == null) {
                    cateroom = "1";
                }
                Room rooom = daos.getRooms(cateroom);
                RoomCategoryDAOImpl roomcate = new RoomCategoryDAOImpl();
                Vector<RoomCategory> romcate = roomcate.getRoomCategoryList("select * from CateRoom");
                Vector<Device> de = daoss.getDevicebycateroom(cateroom);
                request.setAttribute("de", de);
                request.setAttribute("romcate", romcate);
                request.setAttribute("rooom", rooom);
                request.getRequestDispatcher("editroomdevice.jsp").forward(request, response);

            }
            if (doo.equals("deleteroom")) {
                String DeviceID = request.getParameter("DeviceID");
                String RoomcateID = request.getParameter("RoomcateID");
                daoss.deleteDevice(RoomcateID, DeviceID);
                response.sendRedirect("ServiceController?do=getdeviceroom");
//                out.println("<h1>Servlet RoomcategoryController at " + DeviceID +"va"+ RoomcateID+ "</h1>");

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
