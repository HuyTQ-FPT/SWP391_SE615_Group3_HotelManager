/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.impl.OrderDAOImpl;
import Dao.impl.ReservationDAOImpl;
import Dao.impl.ServiceDAOImpl;
import Entity.Reservation;
import Entity.Service;
import context.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {

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
            String service = request.getParameter("do");
            DBContext db = new DBContext();
            OrderDAOImpl dao = new OrderDAOImpl();
            ReservationDAOImpl dao1= new ReservationDAOImpl();
            ServiceDAOImpl daos= new ServiceDAOImpl();
            HttpSession session=request.getSession();
            if (service == null) {
                String i = request.getParameter("id"); 
                int id = Integer.parseInt(i);
                Vector<Service> vector= daos.getServiceList();
                ResultSet rs = db.getData("select* from Room r\n"
                        + " inner join Image i on r.RoomimgaeID=i.RoomimgaeID \n"
                        + "join CateRoom c on \n"
                        + "r.RoomcateID =c.RoomcateID \n"
                        + "where RoomID="+id);
                request.setAttribute("vector", vector);
                request.setAttribute("rs", rs);
                request.setAttribute("id", id);
                request.getRequestDispatcher("BillHotel.jsp").forward(request, response);
            }if(service.equalsIgnoreCase("infor")){
                Vector<Reservation> vector =new Vector<>();
                
                String i = request.getParameter("id");
                String money = request.getParameter("price");
                String firstname = request.getParameter("firstname");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                String phone = request.getParameter("phone");
                String checkin = request.getParameter("check-in");
                String checkout = request.getParameter("check-out");
                String adult= request.getParameter("Adult");
                String child= request.getParameter("Child");
                
                int a= Integer.parseInt(adult)+ Integer.parseInt(child);
                int id = Integer.parseInt(i);
                
                SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
                Date date1 = (Date) format.parse(checkin);
                java.sql.Date sDate = new java.sql.Date(date1.getTime());
                
                Date date2 = (Date) format.parse(checkout);
                java.sql.Date cDate = new java.sql.Date(date2.getTime());
                
                Reservation re = new Reservation(1, id, firstname,email, address,phone, a, sDate, cDate, 1000, 1,sDate );
                vector.add(re);
                int n= dao1.addReservation(re);
                request.setAttribute("vector", vector);
                request.getRequestDispatcher("Confirm.jsp").forward(request, response);
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
