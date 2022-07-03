/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.DevicesDAOImpl;
import dao.impl.RoomCategoryDAOImpl;
import dao.impl.RoomDAOImpl;
import dao.impl.ServiceDAOImpl;
import entity.Device;
import entity.Room;
import entity.RoomCategory;
import entity.Service;
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
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String doo = request.getParameter("do");
            String ServiceID = request.getParameter("ServiceID");
            RoomDAOImpl daos = new RoomDAOImpl();
            ServiceDAOImpl dao = new ServiceDAOImpl();
            DevicesDAOImpl daoss = new DevicesDAOImpl();
            RoomCategoryDAOImpl roomcate = new RoomCategoryDAOImpl();
            String cateroom = request.getParameter("cateroom");
            if (cateroom == null) {
                cateroom = "1";
            }
            String Mess = request.getParameter("Mess");
            if (Mess == null) {
                Mess = "";
            }
            String Messs = (String) session.getAttribute("Mess");
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
                Room rooom = daos.getRooms(cateroom);
                Vector<RoomCategory> romcate = roomcate.getRoomCategoryList("select * from CateRoom");
                Vector<Device> de = daoss.searchDevicebyname(Mess, cateroom);
                request.setAttribute("de", de);
                request.setAttribute("romcate", romcate);
                request.setAttribute("rooom", rooom);
                session.setAttribute("Mess", Mess);
//                request.setAttribute("devices", "devices");
//              out.println("<h1>Servlet RoomcategoryController at " + de +"va"+ cateroom+ "</h1>");
                request.getRequestDispatcher("editroomdevice.jsp").forward(request, response);
            }
            if (doo.equals("deleteroom")) {
                String DeviceID = request.getParameter("DeviceID");
                String RoomcateID = request.getParameter("RoomcateID");
                daoss.deleteDevice(RoomcateID, DeviceID);
                response.sendRedirect("ServiceController?do=getdeviceroom&cateroom=" + RoomcateID + "&Mess=" + Messs + "");
//                out.println("<h1>Servlet RoomcategoryController at " + DeviceID +"va"+ RoomcateID+ "</h1>");
            }
            if (doo.equals("updateroomdevice")) {
                String DeviceID = request.getParameter("DeviceID");
                String RoomcateID = request.getParameter("RoomcateID");
                String DeviceName = request.getParameter("DeviceName");
                String Price = request.getParameter("Price");
                String Status = request.getParameter("Status");
                String Quantity = request.getParameter("Quantity");
                daoss.updateDeviceinfor(DeviceName, Price, Status, DeviceID);
                daoss.updateDeviceQuan(Quantity, DeviceID, RoomcateID);
//                out.println("<h1>Servlet RoomcategoryController at " + DeviceID + "va" + RoomcateID + "va" + DeviceName + "va" + Quantity + "</h1>");
                response.sendRedirect("ServiceController?do=getdeviceroom&cateroom=" + RoomcateID + "&Mess=" + Messs + "");
            }
            if (doo.equals("insertdeviceroom")) {
                String RoomcateID = request.getParameter("RoomcateID");
                String DeviceName = request.getParameter("DeviceName");
                String Price = request.getParameter("Price");
                String Status = request.getParameter("Status");
                String Quantity = request.getParameter("Quantity");
                Room rooom = daos.getRooms(cateroom);
                request.setAttribute("rooom", rooom);
                daoss.insertDevice(DeviceName, Price, Status, RoomcateID, Quantity);
//                out.println("<h1>Servlet RoomcategoryController at " + DeviceName + "DeviceName" + RoomcateID + "RoomcateID" + Price + "Price" + Quantity + "Quantity" + Status + "Status" + "</h1>");
                response.sendRedirect("ServiceController?do=getdeviceroom&cateroom=" + RoomcateID + "");
            }
            if (doo.equals("insertRoomCategory")) {
                String Roomcatename = request.getParameter("Roomcatename");
//                roomcate.insertRoomCategory(Roomcatename);
                Vector<RoomCategory> romcate = roomcate.getRoomCategoryList("select * from CateRoom");
                request.setAttribute("romcate", romcate);
                out.println("<h1>Servlet RoomcategoryController at " + Roomcatename+ "</h1>");
                System.out.println(Roomcatename);
//                response.sendRedirect("ServiceController?do=getdeviceroom&cateroom=" + romcate.lastElement().getRoomcateID() + "");
            }
            if (doo.equals("deletetRoomCategory")) {
                roomcate.deleteRoomCategory(cateroom);
                response.sendRedirect("ServiceController?do=getdeviceroom");
            }
            if (doo.equals("updatetRoomCategory")) {
                String Roomcatename = request.getParameter("Roomcatename");
                roomcate.updateRoomCategory(cateroom, Roomcatename);
                response.sendRedirect("ServiceController?do=getdeviceroom&cateroom=" + cateroom + "&Mess=" + Messs + "");
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
