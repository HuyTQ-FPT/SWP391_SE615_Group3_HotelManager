/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.impl.RoomDAOImpl;
import Dao.impl.ServiceDAOImpl;
import Entity.Account;
import Entity.Room;
import Entity.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
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
@WebServlet(name = "HomeController", urlPatterns = {"/HomeController"})
public class HomeController extends HttpServlet {
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
            HttpSession session = request.getSession();
            RoomDAOImpl dao = new RoomDAOImpl();
            ServiceDAOImpl dao1 = new ServiceDAOImpl();
            String service = request.getParameter("do");
            if (service == null) {
                //danh sách phòng
                Vector<Room> vector = dao.getRoomList("select top (6) * from Room INNER JOIN Image on Image.RoomimgaeID= Room.RoomimgaeID \n"
                        + "JOIN CateRoom on Room.RoomcateID = CateRoom.RoomcateID\n"
                        + "where Room.Status =0 \n");
                // thông tin phòng--> ALl
                Vector<Room> vector2 = dao.getRoomList("select * from Room INNER JOIN Image on Image.RoomimgaeID= Room.RoomimgaeID \n"
                        + "JOIN CateRoom on Room.RoomcateID = CateRoom.RoomcateID\n"
                        + "where Room.Status =0\n");
                // tính năng
                Vector<Service> vector3 = dao1.getServiceList();
                // phân trang phòng trống
                Vector<Room> vector4 = null;
                int n = dao.getPageByPageStatus();
                String page = request.getParameter("page");
                if (page == null) {
                    vector4 = dao.getRoomByPageStatus(1);
                } else {
                    vector4 = dao.getRoomByPageStatus(Integer.parseInt(page));
                }
                request.setAttribute("n", n);
                request.setAttribute("vector", vector);
                request.setAttribute("vector2", vector2);
                request.setAttribute("vector3", vector3);
                request.setAttribute("vector4", vector4);
                RequestDispatcher dispath = request.getRequestDispatcher("index.jsp");
                dispath.forward(request, response);
            }
        }catch(Exception ex){
            ex.printStackTrace();
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
