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
@WebServlet(name = "CompareRoomController", urlPatterns = {"/CompareRoomController"})
public class CompareRoomController extends HttpServlet {

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

            if (service.equals("ViewCompare")) { // xem thông tin phòng

                String RoomID = request.getParameter("roomid").trim();
                String cateroom = request.getParameter("cateroom").trim();
                int roomid = Integer.parseInt(RoomID);
                Image img = daoR.searchRoomidAndImage(roomid);
                Room rooom = daoR.getOneRoom(roomid);
                Vector<Device> vectorD = daoD.getDevicebycateroom(cateroom);

                request.setAttribute("Rooom", rooom);
                request.setAttribute("img", img);
                request.setAttribute("roomid", RoomID);
                request.setAttribute("cateid", cateroom);
                request.setAttribute("vectorD", vectorD);
                request.getRequestDispatcher("compare.jsp").forward(request, response);

            }
            if (service.equalsIgnoreCase("searchRoomname")) { // tìm kiếm tên phòng
                String name = request.getParameter("txt").trim();
                int RoomID = Integer.parseInt(request.getParameter("RoomID").trim());
                int cateID = Integer.parseInt(request.getParameter("cateID").trim());

                Vector<Room> vectorR = daoR.searchRoomNamebyAjax(name, cateID);

                PrintWriter out = response.getWriter();

                if (name.isEmpty()) {
                    out.print("");
                } else if (vectorR.size() == 0) {
                    out.print("<p style=\"padding:20px\">Không tìm thấy kết quả cho từ khoá: <span style=\"color:red\">" + name + "</span><p>");
                } else {
                    out.print(" <div class=\"manufactury\">");
                    for (Room room : vectorR) {
                        Image image = daoR.searchRoomidAndImage(room.getRoomID());
                        if (room.getRoomID() != RoomID) {

                            out.print("  <li style=\"list-style: none\">\n"
                                    + "                                    <a href=\"CompareTwoController?do=CompareTwoRoom&Roomid=" + RoomID + "&Roomid1=" + room.getRoomID() + "&cateID=" + cateID + "\">  <span style=\"margin-left: 120px\">Tên Phòng:" + room.getRoomname() + "</span> </a><br>\n"
                                    + "                                    <a href=\"CompareTwoController?do=CompareTwoRoom&Roomid=" + RoomID + "&Roomid1=" + room.getRoomID() + "&cateID=" + cateID + "\"> <img src=\"images/anhphong/" + image.getImage1() + "\" style=\"width: 100px; height: 100px\"></a>   <a href=\"CompareTwoController?do=CompareTwoRoom&Roomid=" + RoomID + "&Roomid1=" + room.getRoomID() + "&cateID=" + cateID + "\"><span style=\"margin-left: 15px\" >Tiền:" + room.getRoomprice() + "</span></a> <br>\n"
                                    + "\n"
                                    + "                                    <a href=\"CompareTwoController?do=CompareTwoRoom&Roomid=" + RoomID + "&Roomid1=" + room.getRoomID() + "&cateID=" + cateID + "\"><span style=\"margin-left: 240px\">Thêm vào so sánh</span></a> <br>  \n"
                                    + "        \n"
                                    + "                                </li> ");
                        } else {
                            out.print("  <li style=\"list-style: none\">\n"
                                    + "                                      <span style=\"margin-left: 120px\">Tên Phòng:" + room.getRoomname() + "</span> <br>\n"
                                    + "                                     <img src=\"images/anhphong/" + image.getImage1() + "\" style=\"width: 100px; height: 100px\">  <span style=\"margin-left: 15px\" >Tiền:" + room.getRoomprice() + "</span> <br>\n"
                                    + "\n"
                                    + "                                    <span style=\"margin-left: 240px\">Không thể so sánh</span><br>  \n"
                                    + "          \n"
                                    + "                                </li> ");
                        }
                    }

                    out.print(" </div >");
                }

            }

        } catch (Exception ex) {
            Logger.getLogger(CompareRoomController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CompareRoomController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CompareRoomController.class.getName()).log(Level.SEVERE, null, ex);
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