
package controller;

import dao.DeviceDAO;
import dao.MessageDAO;
import dao.ReservationDAO;
import dao.RoomDAO;
import dao.RequestMessageDAO;
import dao.RoomCategoryDAO;
import dao.UserDAO;
import dao.impl.DevicesDAOImpl;
import dao.impl.MessageDAOImpl;
import dao.impl.ReservationDAOImpl;
import dao.impl.RoomDAOImpl;
import dao.impl.RequestMessageDAOIpml;
import dao.impl.RoomCategoryDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Account;
import entity.Device;
import entity.Message;
import entity.Reservation;
import entity.Room;
import entity.RoomCategory;
import entity.User;
import entity.RequestMessage;
import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
            DeviceDAO deviceDAO = new DevicesDAOImpl();
            RoomCategoryDAO roomCategoryDAO = new RoomCategoryDAOImpl();

            RequestMessageDAO daoRequest = new RequestMessageDAOIpml();
            MessageDAO daoMessage = new MessageDAOImpl();
            ReservationDAO daoReservation = new ReservationDAOImpl();
            DecimalFormat formatter = new DecimalFormat("###,###,###");
            String service = request.getParameter("do");
            if (service == null) {
                service = "indexAdmin";

            }
            if (service.equals("indexAdmin")) { // trang chủ admin
                ArrayList<Room> listRoom = daoR.getRoomListAll(); // phòng
                ArrayList<User> listUser = daoU.getCustomerListByReceptionist(); // số khách hàng
                ArrayList<User> listReceptionist = daoU.getListByReceptionist(); //số lễ tân
                ArrayList<RequestMessage> listRequest = daoRequest.getMessage(); // số yêu cầu
                ArrayList<Message> listMessage = daoMessage.getAllComment();// số phản hồi

                int sumReservation = daoReservation.sumReservation(); // tổng tiền
                ArrayList<RoomCategory> listroomCategory = roomCategoryDAO.numberOfRoomsByCategory(); // thống kê theo loại phòng
                ArrayList<Room> listStatus = daoR.sumOfRoom();
                ArrayList<Device> listDevice = deviceDAO.numberOfDevice(); // Thống kê thiết bị
                ArrayList<Reservation> listReservationOfService = daoReservation.sumService(); // thống kê dịch vụ
                request.setAttribute("listroomCategory", listroomCategory);
                request.setAttribute("listRoom", listRoom);
                request.setAttribute("listUser", listUser);
                request.setAttribute("listReceptionis", listReceptionist);
                request.setAttribute("listRequest", listRequest);
                request.setAttribute("listReservationOfService", listReservationOfService);
                request.setAttribute("listMessage", listMessage);
                request.setAttribute("sumReservation", formatter.format(sumReservation));
                request.setAttribute("listStatus", listStatus);
                request.setAttribute("listDevice", listDevice);
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
            if (service.equals("ReportDay")) { // báo cáo tổng thu nhập trên mỗi phòng

                ArrayList<Reservation> listReservation = daoReservation.totalOfRoom();
                request.setAttribute("listReservation", listReservation);
                request.getRequestDispatcher("reportRoom.jsp").forward(request, response);
            }
            if (service.equals("ReportDay1")) { // tìm kiếm và báo cáo tổng thu nhập trên mỗi phòng
                String name = request.getParameter("name").trim();
                String checkin = request.getParameter("checkin").trim();
                String checkout = request.getParameter("checkout").trim();

                if (checkin.isEmpty() && checkout.isEmpty() && name.isEmpty()) {
                    String err1 = "Vui lòng điền thông tin.";
                    request.setAttribute("err1", err1);
                    request.getRequestDispatcher("reportRoom.jsp").forward(request, response);
                }
                if (!name.isEmpty() && !name.matches("^[0-9]+$")) {
                    String err1 = "Vui lòng nhập số dương.";
                    request.setAttribute("err1", err1);
                    request.setAttribute("name", name);
                    request.setAttribute("checkin", checkin);
                    request.setAttribute("checkout", checkout);
                    request.getRequestDispatcher("reportRoom.jsp").forward(request, response);
                }
                if (checkin.isEmpty() && checkout.isEmpty() && !name.isEmpty()) {

                    if (daoR.checkRoom(name) != null) {
                        ArrayList<Reservation> listReservation = daoReservation.totalOfRoomSearch(name, null, null);
                        request.setAttribute("listReservation", listReservation);
                        request.getRequestDispatcher("reportRoom.jsp").forward(request, response);
                    } else {
                        String err1 = "Tên phòng không tồn tại.";
                        request.setAttribute("err1", err1);
                        request.setAttribute("name", name);
                        request.getRequestDispatcher("reportRoom.jsp").forward(request, response);
                    }

                }
                if (!name.isEmpty() && !checkin.isEmpty() && checkout.isEmpty() || !name.isEmpty() && checkin.isEmpty() && !checkout.isEmpty()
                        || name.isEmpty() && !checkin.isEmpty() && checkout.isEmpty() || name.isEmpty() && checkin.isEmpty() && !checkout.isEmpty()) {
                    String errr = "Vui lòng nhập vào 2 trường Từ ngày và Đến ngày.";
                    request.setAttribute("errr", errr);
                    request.setAttribute("name", name);
                    request.setAttribute("checkin", checkin);
                    request.setAttribute("checkout", checkout);
                    request.getRequestDispatcher("reportRoom.jsp").forward(request, response);
                } else {

                    if (daoR.checkRoom(name) != null) {
                        Date to = Date.valueOf(checkin);
                        Date from = Date.valueOf(checkout);
                        ArrayList<Reservation> listReservation = daoReservation.totalOfRoomSearch(name, to, from);
                        request.setAttribute("listReservation", listReservation);
                        request.getRequestDispatcher("reportRoom.jsp").forward(request, response);
                    } else if (daoR.checkRoom(name) == null && name.isEmpty()) {
                        String err1 = "Vui lòng nhập Từ ngày < Đến ngày";
                        request.setAttribute("err1", err1);
                        request.setAttribute("checkin", checkin);
                        request.setAttribute("checkout", checkout);
                        request.getRequestDispatcher("reportRoom.jsp").forward(request, response);
                    } else {
                        String err1 = "Tên phòng không tồn tại.";
                        request.setAttribute("err1", err1);
                        request.setAttribute("name", name);
                        request.setAttribute("checkin", checkin);
                        request.setAttribute("checkout", checkout);
                        request.getRequestDispatcher("reportRoom.jsp").forward(request, response);
                    }
                }

            }

            if (service.equals("ReportMonth")) { // view số liệu theo tháng
                ArrayList<Reservation> listReservationTotalOfMotnh = daoReservation.totalOfRoomByMonth(0, 0);
                ArrayList<Integer> listReservationAllYear = daoReservation.selectAllYear();
                ArrayList<Integer> listReservationAllMonth = daoReservation.selectAllMotnh();
                request.setAttribute("listReservationTotalOfMotnh", listReservationTotalOfMotnh);
                request.setAttribute("listReservationAllYear", listReservationAllYear);
                request.setAttribute("listReservationAllMonth", listReservationAllMonth);
                request.getRequestDispatcher("reportMonth.jsp").forward(request, response);

            }

            if (service.equals("ReportMonth1")) { // Báo cáo số liệu theo tháng
                ArrayList<Integer> listReservationAllYear = daoReservation.selectAllYear();
                ArrayList<Integer> listReservationAllMonth = daoReservation.selectAllMotnh();
                request.setAttribute("listReservationAllMonth", listReservationAllMonth);
                request.setAttribute("listReservationAllYear", listReservationAllYear);
                int month = Integer.parseInt(request.getParameter("month"));
                int sum = 0;
                int year = Integer.parseInt(request.getParameter("year"));

                if (month == 0 && year == 0) {
                    response.sendRedirect("AdminController?do=ReportMonth");
                } else {

                    if (year == 0) {
                        ArrayList<Reservation> listReservationTotalOfMotnh = daoReservation.totalOfRoomByMonth(month, year);
                        request.setAttribute("listReservationTotalOfMotnh", listReservationTotalOfMotnh);
                        request.setAttribute("year", year);
                        request.getRequestDispatcher("reportMonth.jsp").forward(request, response);
                    } else if (year != 0 && month == 0) {

                        ArrayList<Reservation> listReservationTotalOfMotnh = daoReservation.totalOfRoomByMonth(month, year);
                        for (Reservation r : listReservationTotalOfMotnh) {
                            sum += r.getTotal();

                        }
                        request.setAttribute("listReservationTotalOfMotnh", listReservationTotalOfMotnh);
                        request.setAttribute("year", year);
                        request.setAttribute("month", month);
                        request.setAttribute("sum", formatter.format(sum));
                        request.getRequestDispatcher("reportMonth.jsp").forward(request, response);

                    } else {
                        ArrayList<Reservation> listReservationTotalOfMotnh = daoReservation.totalOfRoomByMonth(month, year);
                        request.setAttribute("listReservationTotalOfMotnh", listReservationTotalOfMotnh);
                        request.setAttribute("year", year);
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
