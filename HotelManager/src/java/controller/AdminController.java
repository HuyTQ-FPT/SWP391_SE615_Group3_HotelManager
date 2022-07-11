package controller;

import dao.MessageDAO;
import dao.ReceptionistDAO;
import dao.ReservationDAO;
import dao.RoomDAO;
import dao.SendFeedbackDAO;
import dao.UserDAO;
import dao.impl.MessageDAOImpl;
import dao.impl.ReceptionistDAOImpl;
import dao.impl.ReservationDAOImpl;
import dao.impl.RoomDAOImpl;
import dao.impl.SendFeedbackDAOIpml;
import dao.impl.UserDAOImpl;
import entity.Account;
import entity.Device;
import entity.Message;
import entity.Reservation;
import entity.Room;
import entity.RoomCategory;
import entity.User;
import entity.sendFeedback;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Minh Hiếu
 */
@WebServlet(name = "AdminController", urlPatterns = {"/AdminController"})
public class AdminController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            HttpSession session = request.getSession();
            UserDAO daoU = new UserDAOImpl();
            RoomDAO daoR = new RoomDAOImpl();
            ReceptionistDAO daoReceptionist = new ReceptionistDAOImpl();
            SendFeedbackDAO daoRequest = new SendFeedbackDAOIpml();
            MessageDAO daoMessage = new MessageDAOImpl();
            ReservationDAO daoReservation = new ReservationDAOImpl();
            String service = request.getParameter("do");
            if (service == null) {
                service = "indexAdmin";

            }
            if (service.equals("indexAdmin")) { // trang chủ admin
                Vector<Room> vectorRoom = daoR.getRoomListAll("select * from Room"); // phòng
                Vector<User> vectorUser = daoReceptionist.getCustomerListByReceptionist(); // số khách hàng
                Vector<User> vectorReceptionist = daoReceptionist.getListByReceptionist(); //số lễ tân
                Vector<sendFeedback> vectorRequest = daoRequest.getMessage(); // số yêu cầu
<<<<<<< Updated upstream
                ArrayList<Message> listMessage = daoMessage.getAllComment();// số phản hồi
=======
                ArrayList<Message> vectorMessage = daoMessage.getAllComment();// số phản hồi
>>>>>>> Stashed changes
                int sumReservation = daoReservation.sumReservation(); // tổng tiền
                Vector<RoomCategory> vectorR = daoR.numberOfRoomsByCategory(); // thống kê theo loại phòng
                Vector<Room> vectorStatus = daoR.sumOfRoom();
                Vector<Device> vectorDevice = daoR.numberOfDevice(); // Thống kê thiết bị
                Vector<Reservation> daoReservationOfService =daoReservation.sumService() ; // Thống kê thiết bị
                request.setAttribute("vectorR", vectorR);
                request.setAttribute("vectorRoom", vectorRoom);
                request.setAttribute("vectorUser", vectorUser);
                request.setAttribute("vectorReceptionis", vectorReceptionist);
                request.setAttribute("vectorRequest", vectorRequest);
                request.setAttribute("daoReservationOfService", daoReservationOfService);
                request.setAttribute("listMessage", listMessage);
                request.setAttribute("sumReservation", sumReservation);
                request.setAttribute("vectorStatus", vectorStatus);
                request.setAttribute("vectorDevice", vectorDevice);
                request.getRequestDispatcher("indexadmin.jsp").forward(request, response);
            }

            if (service.equalsIgnoreCase("viewProfileAdmin")) { // xem thông tin

                Account ac = (Account) session.getAttribute("login");

                User u = daoU.getUser(ac.getAccountID());
                request.setAttribute("u", u);
                request.getRequestDispatcher("viewProfileAdmin.jsp").forward(request, response);

            }
            if (service.equalsIgnoreCase("ViewupdateAdmin")) { // chuyen toi trang cập nhật thông tin
                Account ac = (Account) session.getAttribute("login");
                User u = daoU.getUser(ac.getAccountID());
                session.setAttribute("u", u);
                request.setAttribute("a", u);
                request.getRequestDispatcher("updateProfileAdmin.jsp").forward(request, response);

            }

            if (service.equalsIgnoreCase("updateAdmin")) { // cập nhật thông tin

                String uID = (String) request.getParameter("uid").trim();
                String username = (String) request.getParameter("name").trim();
                String uEmail = (String) request.getParameter("inputEmailAddress").trim();
                String uCMT = (String) request.getParameter("inputCMT").trim();

                String uAddress = (String) request.getParameter("inputAdress").trim();

                String uPhone = (String) request.getParameter("inputPhone").trim();
                Date birthday = Date.valueOf(request.getParameter("inputBirthday").trim());
                System.out.println(birthday);

                //convert
                int id = Integer.parseInt(uID);

                User u = new User(id, username, uPhone, uEmail, birthday, uAddress, uCMT);
                session.setAttribute("u", u);
                request.setAttribute("a", u);
                if (uEmail.length() < 5 || uCMT.length() < 5 || uAddress.length() < 5 || uPhone.length() < 5) {
                    String err = "Nhập lớn hơn 5 kí tự.";
                    request.setAttribute("err", err);
                    request.getRequestDispatcher("updateProfileAdmin.jsp").forward(request, response);

                } else if (!uEmail.trim().matches("^[a-zA-Z]\\w+@gmail.com$")) {
                    String err = "Ví dụ: hieu1@gmail.com";
                    request.setAttribute("err", err);
                    request.getRequestDispatcher("updateProfileAdmin.jsp").forward(request, response);
                } else if (!uCMT.trim().matches("^[0-9]{12}$")) {
                    String err = "Chỉ nhập số và đúng 12 kí tự của CMT ";
                    request.setAttribute("err", err);
                    request.getRequestDispatcher("updateProfileAdmin.jsp").forward(request, response);

                } else if (uAddress.trim().length() > 100) {
                    String err = "Nhỏ hơn 100 kí tự";
                    request.setAttribute("err", err);
                    request.getRequestDispatcher("updateProfileAdmin.jsp").forward(request, response);

                } else if (!uPhone.trim().matches("^(09|03)+[0-9]{8}$")) {

                    String err = "Điện thoại bắt đầu 09|03 và có 10 số.";
                    request.setAttribute("err", err);
                    request.getRequestDispatcher("updateProfileAdmin.jsp").forward(request, response);
                } else {
                    daoU.updateUserEcept(new User(id, username, uPhone, uEmail, birthday, uAddress, uCMT));
                    String mess = "Cập nhật thành công.";
                    request.setAttribute("mess", mess);
                    request.getRequestDispatcher("updateProfileAdmin.jsp").forward(request, response);
                }

            }
            if (service.equals("ReportDay")) {
                SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                Vector<Reservation> vectorReservation = daoReservation.totalOfRoom();

                request.setAttribute("vectorReservation", vectorReservation);
                request.getRequestDispatcher("reportRoom.jsp").forward(request, response);
            }
            if (service.equals("ReportDay1")) {
                String name = request.getParameter("name").trim();
                String checkin = request.getParameter("checkin").trim();
                String checkout = request.getParameter("checkout").trim();
                if (checkin.isEmpty() && checkout.isEmpty() && name.isEmpty()) {
                    Vector<Reservation> vectorReservation = daoReservation.totalOfRoomSearch(name, null, null);
                    request.setAttribute("vectorReservation", vectorReservation);
                    request.getRequestDispatcher("reportRoom.jsp").forward(request, response);
                }
                if (checkin.isEmpty() && checkout.isEmpty() && name != null) {
                    Vector<Reservation> vectorReservation = daoReservation.totalOfRoomSearch(name, null, null);
                    request.setAttribute("vectorReservation", vectorReservation);
                    request.setAttribute("name", name);
                    request.getRequestDispatcher("reportRoom.jsp").forward(request, response);
                }
                if (!checkin.isEmpty() && checkout.isEmpty() || checkin.isEmpty() && !checkout.isEmpty()) {
                    String errr = "Vui lòng nhập vào 2 trường Từ ngày và Đến ngày.";
                    request.setAttribute("errr", errr);
                    request.setAttribute("name", name);
                    request.setAttribute("checkin", checkin);
                    request.setAttribute("checkout", checkout);
                    request.getRequestDispatcher("reportRoom.jsp").forward(request, response);
                } else {

                    Date to = Date.valueOf(checkin);
                    Date from = Date.valueOf(checkout);
                    Vector<Reservation> vectorReservation = daoReservation.totalOfRoomSearch(name, to, from);
                    request.setAttribute("vectorReservation", vectorReservation);
                    request.setAttribute("name", name);
                    request.setAttribute("checkin", checkin);
                    request.setAttribute("checkout", checkout);
                    request.getRequestDispatcher("reportRoom.jsp").forward(request, response);
                }

            }
            if (service.equals("ReportMonth")) {
                Vector<Reservation> vectorReservationTotalOfMotnh = daoReservation.totalOfRoomByMonth(null, null);
                Vector<Reservation> vectorReservationAllYear = daoReservation.selectAllYear();
                request.setAttribute("vectorReservationTotalOfMotnh", vectorReservationTotalOfMotnh);
                request.setAttribute("vectorReservationAllYear", vectorReservationAllYear);
                request.getRequestDispatcher("reportMonth.jsp").forward(request, response);

            }

            if (service.equals("ReportMonth1")) {
                int month = 0;
                int sum = 0;
                if (!request.getParameter("name").isEmpty()) {

                    month = Integer.parseInt(request.getParameter("name"));
                }
                int year = Integer.parseInt(request.getParameter("year"));
                Vector<Reservation> vectorReservationAllYear = daoReservation.selectAllYear();
                request.setAttribute("vectorReservationAllYear", vectorReservationAllYear);
                if (month == 0 && year == 0) {
                    response.sendRedirect("AdminController?do=ReportMonth");
                } else {

                    if (year == 0) {
                        Vector<Reservation> vectorReservationTotalOfMotnh = daoReservation.totalOfRoomByMonth(month, null);
                        request.setAttribute("vectorReservationTotalOfMotnh", vectorReservationTotalOfMotnh);
                        request.setAttribute("year", year);
                        request.setAttribute("name", "");
                        request.getRequestDispatcher("reportMonth.jsp").forward(request, response);
                    } else if (year != 0 && month == 0) {

                        Vector<Reservation> vectorReservationTotalOfMotnh = daoReservation.totalOfRoomByMonth(null, year);
                        for (Reservation r : vectorReservationTotalOfMotnh) {
                            sum += r.getTotal();
                        }
                        request.setAttribute("vectorReservationTotalOfMotnh", vectorReservationTotalOfMotnh);
                        request.setAttribute("year", year);
                        request.setAttribute("name", "");
                        request.setAttribute("sum", sum);
                        request.getRequestDispatcher("reportMonth.jsp").forward(request, response);

                    } else {
                        Vector<Reservation> vectorReservationTotalOfMotnh = daoReservation.totalOfRoomByMonth(month, year);
                        request.setAttribute("vectorReservationTotalOfMotnh", vectorReservationTotalOfMotnh);
                        request.setAttribute("year", year);
                        request.setAttribute("name", month);
                        request.getRequestDispatcher("reportMonth.jsp").forward(request, response);
                    }
                }

            }

        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("errorMess", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

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
            Logger.getLogger(AdminController.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdminController.class
                    .getName()).log(Level.SEVERE, null, ex);
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
