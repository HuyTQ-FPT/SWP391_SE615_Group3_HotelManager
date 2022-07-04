/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.RoomCategoryDAOImpl;
import dao.impl.RoomDAOImpl;
import entity.Room;
import entity.RoomCategory;
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
@WebServlet(name = "RoomcategoryController", urlPatterns = {"/RoomcategoryController"})
public class RoomcategoryController extends HttpServlet {

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
            String doo = request.getParameter("do");
            RoomCategoryDAOImpl roomcatedao = new RoomCategoryDAOImpl();
            RoomDAOImpl roomdao = new RoomDAOImpl();
            if (doo.equals(null) || doo.equals("")) {
                out.println("<h1>Lỗi Trang</h1>");

            }
            if (doo.equals("getroombycategori")) {
                String page = request.getParameter("i");

//                String page = request.getParameter("i");
                int j = 0;
                if (page == null) {
                    j = 1;
                } else {
                    j = Integer.parseInt(page);
                }
                int n = roomcatedao.getPage("select count (*) from CateRoom");
                int begin = 1;
                int end = 3;
                for (int i = 2; i <= j; i++) {
                    begin += 3;
                    end += 3;
                }
                System.out.println(j);
//                System.out.println();
                Vector<RoomCategory> romcate = roomcatedao.getRoomCategoryList("with t as(select *, ROW_NUMBER() OVER (order by CateRoom.RoomCateID)\n"
                        + "                AS RowNum from CateRoom )\n"
                        + "				select * from t \n"
                        + "				Where RowNum between " + begin + " AND " + end + "");
                request.setAttribute("romcate", romcate);
                request.setAttribute("n", n);
                request.setAttribute("j", j);
                request.getRequestDispatcher("editroomdevice.jsp").forward(request, response);
            }
            if (doo.equals("deleteRoomCategori")) {
                String cateroom = request.getParameter("cateroomid");
//                dao.deleteRoomCategory(cateroom);
                out.println("<h1>Servlet RoomcategoryController at " + cateroom + "</h1>");
//                response.sendRedirect("RoomcategoryController?do=getroombycategori");
//                System.out.println("đến đây");
//                request.setAttribute("update", "update");
//                request.getRequestDispatcher("RoomcategoryController?do=getroombycategori").forward(request, response);
//                response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
//                response.setHeader("Location", "RoomcategoryController?do=getroombycategori");
            }

            if (doo.equals("listroombycate")) {
                String cateroom = request.getParameter("cateroomid");
                String cate;
                if (cateroom == null) {
                    cateroom = "1";
                    cate = "";
                } else {
                    cate = "(Room.RoomcateID=" + cateroom + ") and";
                }
                Vector<Room> listroom
                        = roomdao.getRoomList1("select * from room  join CateRoom  on Room.RoomcateID = CateRoom.RoomcateID join [Image] on Room.RoomimgaeID = [Image].RoomimgaeID\n"
                                + "                             	where " + cate + " (Roomdesc like'%" + "" + "%' or Roomprice like'%" + "" + "%') \n"
                                + "                               	order by Room.RoomID asc");
                request.setAttribute("listroom", listroom);
//                out.println("<h1>Servlet RoomcategoryController at " + cate + "</h1>");
                request.getRequestDispatcher("AdListRom.jsp").forward(request, response);
            }
            if (doo.equals("insetroomcate")) {
                String RoomNumber = request.getParameter("RoomNumber");
                String Description = request.getParameter("Description");
                roomcatedao.insertRoomCategory(RoomNumber, Description);
                request.setAttribute("update", "update");
//                out.println("<h1>Servlet RoomcategoryController at " + RoomNumber + Description+ "</h1>");
                response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
                response.setHeader("Location", "RoomcategoryController?do=getroombycategori&i=3");
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
