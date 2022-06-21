/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.DevicesDAOImpl;
import dao.impl.ImageDAOImpl;
import dao.impl.RoomDAOImpl;
import dao.impl.ServiceDAOImpl;
import entity.Device;
import entity.Image;
import entity.Room;
import entity.RoomByDate;
import entity.Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
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
                RequestDispatcher dispatch = request.getRequestDispatcher("testRoom.jsp");
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
                if (Integer.parseInt(room) > Integer.parseInt(adult)) {
                    String err = "Phòng không thể nhiều hơn số người lớn";
                    out.print("<h3 style='font size:15px;'>Phòng không thể nhiều hơn số người lớn </h3>");
                    return;
//                    request.setAttribute("err", err);
//                    response.sendRedirect("HomeController");
                }
                int n = (Integer.parseInt(adult) + Integer.parseInt(children)) / Integer.parseInt(room);
                String a = "";
                a += n;
                if (n % 2 != 0) {
                    n++;
                }
                Vector<RoomByDate> vector = dao.seachRoom(a, checkin, checkout);
                request.setAttribute("vector", vector);
                RequestDispatcher dispatch = request.getRequestDispatcher("searchRoom.jsp");
                dispatch.forward(request, response);
            }
            if (service.equals("roomdetail")) {
                ServiceDAOImpl dao1 = new ServiceDAOImpl();
                DevicesDAOImpl daode = new DevicesDAOImpl();
                String RoomID = request.getParameter("roomid");
                String cateroom = request.getParameter("cateroom");
                Vector<Image> img = daos.getImageByid(RoomID);
                Vector<Device> de = daode.getDevicebycateroom(cateroom);
                Vector<Service> vector3 = dao1.getServiceListbyran();
                Room rooom = dao.getRoom(RoomID);
                Vector<Room> getroomlist = dao.getRoomList(""
                        + "select top (4) * from Room INNER JOIN Image on Image.RoomimgaeID= Room.RoomimgaeID\n"
                        + "JOIN CateRoom on Room.RoomcateID = CateRoom.RoomcateID\n"
                        + "where Room.Status =0 and Room.RoomcateID = " + cateroom + "\n"
                        + "ORDER BY NEWID()");
                request.setAttribute("Room", rooom);
                request.setAttribute("vector3", vector3);
                request.setAttribute("de", de);
                request.setAttribute("img", img);
                request.setAttribute("getroomlist", getroomlist);
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
                request.getRequestDispatcher("SortByCate.jsp").forward(request, response);
            }
            if (service.equals("sortByPriceMax")) {
                int n = dao.getPage();
                String page = request.getParameter("page");
                Vector<Room> vector = dao.getRoomByPriceMax(Integer.parseInt(page));
                request.setAttribute("vector", vector);
                request.setAttribute("n1", n);
                RequestDispatcher dispatch = request.getRequestDispatcher("testRoom.jsp");
                dispatch.forward(request, response);
            }
            if (service.equals("sortByPriceMin")) {
                int n = dao.getPage();
                String page = request.getParameter("page");
                Vector<Room> vector = dao.getRoomByPriceMin(Integer.parseInt(page));
                request.setAttribute("vector", vector);
                request.setAttribute("n2", n);
                RequestDispatcher dispatch = request.getRequestDispatcher("testRoom.jsp");
                dispatch.forward(request, response);
            }
            if (service.equals("sortByRate")) {
                int n = dao.getPage();
                String page = request.getParameter("page");
                Vector<Room> vector = dao.getRoomByRate(Integer.parseInt(page));
                request.setAttribute("vector", vector);
                request.setAttribute("n3", n);
                RequestDispatcher dispatch = request.getRequestDispatcher("testRoom.jsp");
                dispatch.forward(request, response);
            }
            if (service.equals("sortByPriceBetween")) {
                String price1 = request.getParameter("price1");
                String price2 = request.getParameter("price2");
                int pri1 = Integer.parseInt(price1);
                int pri2 = Integer.parseInt(price2);

                int n = dao.getPageByPrice(pri1, pri2);
                String page = request.getParameter("page");

                Vector<Room> vector = dao.getRoomListbyPrice(Integer.parseInt(page), pri1, pri2);
                request.setAttribute("n4", n);
                request.setAttribute("vector", vector);
                RequestDispatcher dispatch = request.getRequestDispatcher("testRoom.jsp");
                dispatch.forward(request, response);
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
