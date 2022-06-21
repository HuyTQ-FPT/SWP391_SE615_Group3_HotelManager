/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.DateOfRoomImpl;
import dao.impl.OrderDAOImpl;
import dao.impl.ReservationDAOImpl;
import dao.impl.ServiceDAOImpl;
import entity.DateOfRoom;
import entity.Reservation;
import entity.Service;
import dao.impl.OrderDAOImpl;
import dao.impl.ReservationDAOImpl;
import dao.impl.ServiceDAOImpl;
import entity.Service;
import context.DBContext;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            ReservationDAOImpl dao1 = new ReservationDAOImpl();
            DateOfRoomImpl dao2 = new DateOfRoomImpl();

            ServiceDAOImpl daos = new ServiceDAOImpl();
            HttpSession session = request.getSession();
            if (service == null) {
                String i = request.getParameter("id");
                int id = Integer.parseInt(i);
                Vector<Service> vector = daos.getServiceList();
                ResultSet rs = db.getData("select* from Room r\n"
                        + " inner join Image i on r.RoomimgaeID=i.RoomimgaeID \n"
                        + "join CateRoom c on \n"
                        + "r.RoomcateID =c.RoomcateID \n"
                        + "where RoomID=" + id);
                request.setAttribute("vector", vector);
                request.setAttribute("rs", rs);
                request.setAttribute("id", id);
                request.getRequestDispatcher("BillHotel.jsp").forward(request, response);
            }if (service.equalsIgnoreCase("guest")) {
                String i = request.getParameter("id");
                int id = Integer.parseInt(i);
                Vector<Service> vector = daos.getServiceList();

                ResultSet rs = db.getData("select* from Room r\n"
                        + " inner join Image i on r.RoomimgaeID=i.RoomimgaeID \n"
                        + "join CateRoom c on \n"
                        + "r.RoomcateID =c.RoomcateID \n"
                        + "where RoomID=" + id);
                request.setAttribute("vector", vector);
                request.setAttribute("rs", rs);
                request.setAttribute("id", id);
                request.getRequestDispatcher("BillHotel.jsp").forward(request, response);
            }
            if (service.equalsIgnoreCase("user")) {
                String userid = request.getParameter("user");
                System.out.println(userid);
                String i = request.getParameter("id");
                int id = Integer.parseInt(i);
                Vector<Service> vector = daos.getServiceList();
                ResultSet rs1 = db.getData(" select * from Account a  INNER JOIN [User] u \n"
                        + " on a.AccountID=u.AccountID" + userid);

                ResultSet rs = db.getData("select* from Room r\n"
                        + " inner join Image i on r.RoomimgaeID=i.RoomimgaeID \n"
                        + "join CateRoom c on \n"
                        + "r.RoomcateID =c.RoomcateID \n"
                        + "where RoomID=" + id);
                request.setAttribute("vector", vector);
                request.setAttribute("rs", rs);
                request.setAttribute("rs1", rs1);
                request.setAttribute("id", id);
                request.getRequestDispatcher("BillUser.jsp").forward(request, response);
            }
            if (service.equalsIgnoreCase("infor")) {
                Vector<Reservation> vector = new Vector<Reservation>();
                // Lấy giá trị
                String userid = request.getParameter("user");
                String key = request.getParameter("id");
                String money = request.getParameter("price").trim();
                String firstname = request.getParameter("firstname").trim();
                String email = request.getParameter("email").trim();
                String address = request.getParameter("address").trim();
                String phone = request.getParameter("phone").trim();
                String checkin = request.getParameter("checkin").trim();
                String checkout = request.getParameter("checkout").trim();
                String adult = request.getParameter("Adult").trim();
                String child = request.getParameter("Child").trim();
                // Lấy price service
                String []serviceId = request.getParameterValues("service");
                String serv="";
                double price = 0;
                // lay service price and name
                if (!(serviceId.length==0)) {
                    for (int i = 0; i < serviceId.length; i++) {
                        Integer f=Integer.parseInt(serviceId[i]);
                    ResultSet rs = db.getData("select * from Service where ServiceID=" + f);
                    while (rs.next()) {
                        price += rs.getDouble(6);
                        serv+=rs.getString(2)+";";
                    }
                    }
                }
                int a = Integer.parseInt(adult) + Integer.parseInt(child); // number of person
                int id = Integer.parseInt(key);
                // ép type date check in check out
                SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
                Date date1 = (Date) format.parse(checkin);
                java.sql.Date sDate = new java.sql.Date(date1.getTime());

                Date date2 = (Date) format.parse(checkout);
                java.sql.Date cDate = new java.sql.Date(date2.getTime());
                double total = price + Double.parseDouble(money);
                
                long millis = System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);
                Account acc=(Account)session.getAttribute("login");
                int l=acc.getAccountID();
                Reservation re = new Reservation(l, id, firstname, email, address, phone, a, sDate, cDate, total, 1, date);
                // lưu trong session
                vector.add(re);
                request.setAttribute("vector", vector);
                request.setAttribute("id", key);
                request.setAttribute("total", total);
                request.setAttribute("ser", serv);
                request.getRequestDispatcher("Confirm.jsp").forward(request, response);
            }
            if (service.equalsIgnoreCase("Bill")) {
                Vector<Reservation> vector = new Vector<Reservation>();
                // Lấy giá trị
                String userid = request.getParameter("user");
                String key = request.getParameter("id");
                String money = request.getParameter("total").trim();
                String firstname = request.getParameter("firstname").trim();
                String email = request.getParameter("email").trim();
                String address = request.getParameter("address").trim();
                String phone = request.getParameter("phone").trim();
                String checkin = request.getParameter("checkin").trim();
                String checkout = request.getParameter("checkout").trim();
                String a = request.getParameter("number").trim();
                // Lấy price service
                int id = Integer.parseInt(key);
                // ép type date check in check out
                SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
                Date date1 = (Date) format.parse(checkin);
                java.sql.Date sDate = new java.sql.Date(date1.getTime());

                Date date2 = (Date) format.parse(checkout);
                java.sql.Date cDate = new java.sql.Date(date2.getTime());
                
                long millis = System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);
                
                Account acc=(Account)session.getAttribute("login");
                int l=acc.getAccountID();
                double total=Double.parseDouble(money);
                Reservation re = new Reservation(l, id, firstname, email, address, phone, Integer.parseInt(a), sDate, cDate, total, 1, date);
                vector.add(re);
                // lưu trong session
                session.setAttribute(key, re);
                //lưu vào database
                DateOfRoom d = new DateOfRoom(id, sDate, cDate, 1);
                dao2.addReservation(d);
                int n = dao1.addReservation(re);
                response.sendRedirect("HomeController");
            }if (service.equals("yourbill")) {
                Vector<Reservation> vector = new Vector<Reservation>();
                String cid = request.getParameter("id");
                Account acc=(Account)session.getAttribute("login");
                int l=acc.getAccountID();
                vector=dao1.Reservation("select * from Reservation where UserID="+l);
                request.setAttribute("vector", vector);
                RequestDispatcher dispath = request.getRequestDispatcher("History.jsp");
                dispath.forward(request, response);

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
