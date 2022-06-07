/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.impl.ImageDAOImpl;
import Dao.impl.RoomDAOImpl;
import Dao.impl.ServiceDAOImpl;
import Entity.Image;
import Entity.Room;
import Entity.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;
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
@WebServlet(name = "RoomController", urlPatterns = {"/RoomController"})
public class RoomController extends HttpServlet {

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
            ImageDAOImpl daos = new ImageDAOImpl();
            String service = request.getParameter("do");
            if (service == null) {
                int n = dao.getPage();
                String page = request.getParameter("page");
                Vector<Room> vector = dao.getRoomByPage(Integer.parseInt(page));
                request.setAttribute("vector", vector);
                request.setAttribute("n", n);
                RequestDispatcher dispatch = request.getRequestDispatcher("Room.jsp");
                dispatch.forward(request, response);
            }
            if (service.equals("searchRoom")) {
                String checkin = request.getParameter("check-in");
                String checkout = request.getParameter("check-out");
                String adult = request.getParameter("adult");
                String room = request.getParameter("room");
                String children = request.getParameter("children");
                if (adult.isEmpty()) {
                    adult = "1";
                }
                if (children.isEmpty()) {
                    children = "0";
                }
                if (room.isEmpty()) {
                    room = "1";
                }
                int n = (Integer.parseInt(adult) + Integer.parseInt(children)) / 2;

                Vector<Room> vector = dao.getRoomList("select * from Room INNER JOIN Image on Image.RoomimgaeID= Room.RoomimgaeID \n"
                        + "JOIN CateRoom on Room.RoomcateID = CateRoom.RoomcateID\n"
                        + "where NumberPerson>= " + n);
                request.setAttribute("vector", vector);
                RequestDispatcher dispatch = request.getRequestDispatcher("searchRoom.jsp");
                dispatch.forward(request, response);
            }
            if (service.equals("roomdetail")) {
                ServiceDAOImpl dao1 = new ServiceDAOImpl();
                String RoomID = request.getParameter("roomid");
                Vector<Image> img = daos.getImageByid(RoomID);
//        out.println("<h1>Servlet PostController at " + RoomID + "</h1>");
                Vector<Service> vector3 = dao1.getServiceListbyran();
                Room rooom = dao.getRoom(RoomID);
                request.setAttribute("Room", rooom);
                request.setAttribute("vector3", vector3);
                request.setAttribute("img", img);
                session.setAttribute("isroomde", "isroomde");
                request.getRequestDispatcher("viewRoom.jsp").forward(request, response);
                session.removeAttribute("isroomde");
            }
            if (service.equals("CateRoom")) {
                String cateid = request.getParameter("cate");
                int id = Integer.parseInt(cateid);
                Vector<Room> vector = dao.getRoomList("select * from Room Inner JOIN Image on Image.RoomimgaeID= Room.RoomimgaeID \n"
                        + "JOIN CateRoom on Room.RoomcateID = CateRoom.RoomcateID\n"
                        + "where Room.RoomcateID= " + id);
                request.setAttribute("vector", vector);
                request.getRequestDispatcher("Sort.jsp").forward(request, response);
            }
        } catch (Exception ex) {
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
