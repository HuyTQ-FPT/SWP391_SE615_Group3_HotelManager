package controller;

import dao.ReceptionistDAO;
import dao.RoomDAO;
import dao.UserDAO;
import dao.impl.ReceptionistDAOImpl;
import dao.impl.RoomDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Account;
import entity.Room;
import entity.User;
import java.io.IOException;
import java.sql.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "ReceptionistController", urlPatterns = {"/ReceptionistController"})
public class ReceptionistController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try {
            ReceptionistDAO dao = new ReceptionistDAOImpl();
            RoomDAO daoR = new RoomDAOImpl();
            UserDAO daoU = new UserDAOImpl();
            String service = request.getParameter("do");
            HttpSession session = request.getSession();
            if (service == null) {
                service = "Room";
            }
            if (service.equals("Room")) { //In ra tất cả các phòng
                Vector<Room> vectorR = daoR.getRoomListAll("select * from Room");
                request.setAttribute("vectorR", vectorR);
                request.getRequestDispatcher("managerRoom.jsp").forward(request, response);
            }
            if (service.equals("updateStatus")) { // cập nhật trạng thái phòng
                String rId = request.getParameter("rid");
                String status = request.getParameter("status");
                int Rid = Integer.parseInt(rId);
                int status1 = Integer.parseInt(status);
                daoR.updateStatus(Rid, status1);
                response.sendRedirect("ReceptionistController");
            }
            if (service.equalsIgnoreCase("Cus")) { // In ra tất cả các khách hàng
                Vector<User> vectorU = dao.getCustomerListByReceptionist();
                request.setAttribute("vectorU", vectorU);
                request.getRequestDispatcher("managerCustomer.jsp").forward(request, response);
            }
           
            if (service.equalsIgnoreCase("profile")) { // xem thông tin
                Account ac = (Account) session.getAttribute("login");
                User u = daoU.getUser(ac.getAccountID());
                request.setAttribute("u", u);
                request.getRequestDispatcher("profileReceptionist.jsp").forward(request, response);
            }
            if (service.equalsIgnoreCase("ViewupdateRecept")) { // chuyen toi update profile 
                Account ac = (Account) session.getAttribute("login");
                User u = daoU.getUser(ac.getAccountID());
                session.setAttribute("u", u);
                request.setAttribute("a", u);
                request.getRequestDispatcher("updateProfileReceptionist.jsp").forward(request, response);
            }
            if (service.equalsIgnoreCase("updateRecept")) { // cập nhật thông tin

                String uID = (String) request.getParameter("uid").trim();
                String username = (String) request.getParameter("Username");
                String uEmail = (String) request.getParameter("EmailAddress").trim();
                String uCMT = (String) request.getParameter("inputCMT").trim();
                String uAddress = (String) request.getParameter("inputAddress").trim();
                String uPhone = (String) request.getParameter("inputPhone").trim();
                Date birthday = Date.valueOf(request.getParameter("birthday").trim());
                System.out.println(birthday);

                //convert
                int id = Integer.parseInt(uID);
                User k = new User(id, username, uPhone, uEmail, birthday, uAddress, uCMT);
                session.setAttribute("u", k);
                if (uEmail.length() < 5 || uCMT.length() < 5 || uAddress.length() < 5 || uPhone.length() < 5) {
                    String err = "Nhập lớn hơn 5 kí tự.";
                    request.setAttribute("err", err);
                    request.getRequestDispatcher("updateProfileReceptionist.jsp").forward(request, response);

                } else if (username.trim().length() > 50) {
                    String err = "Nhập nhỏ hơn 50 kí tự.";
                    request.setAttribute("err", err);
                    request.getRequestDispatcher("updateProfileReceptionist.jsp").forward(request, response);

                } else if (!username.matches("^[a-zA-Z]+$")) {
                    String err = "Nhập tên của bạn.";
                    request.setAttribute("err", err);
                    request.getRequestDispatcher("updateProfileReceptionist.jsp").forward(request, response);

                } else if (!uEmail.trim().matches("^[a-zA-Z]\\w+@gmail.com$")) {
                    String err = "Ví dụ: hieu1@gmail.com";
                    request.setAttribute("err", err);
                    request.getRequestDispatcher("updateProfileReceptionist.jsp").forward(request, response);
                } else if (!uCMT.trim().matches("^[0-9]{12}$")) {
                    String err = "Chỉ nhập số và đúng 12 kí tự của CMT";
                    request.setAttribute("err", err);
                    request.getRequestDispatcher("updateProfileReceptionist.jsp").forward(request, response);

                } else if (uAddress.trim().length() > 100) {
                    String err = "Nhỏ hơn 100 kí tự";
                    request.setAttribute("err", err);
                    request.getRequestDispatcher("updateProfileReceptionist.jsp").forward(request, response);

                } else if (!uPhone.trim().matches("^(09|03)+[0-9]{8}$")) {

                    String err = "Điện thoại bắt đầu 09|03 và có 10 số.";
                    request.setAttribute("err", err);
                    request.getRequestDispatcher("updateProfileReceptionist.jsp").forward(request, response);
                } else {
                    daoU.updateUserEcept(new User(id, username, uPhone, uEmail, birthday, uAddress, uCMT));
                    String mess = "Cập nhật thành công.";
                    request.setAttribute("mess", mess);
                    request.getRequestDispatcher("updateProfileReceptionist.jsp").forward(request, response);
                }

            }

            if (service.equalsIgnoreCase("searchRoomAndStatus")) { // tìm tên phòng và trạng thái phòng

                String nameRoom = request.getParameter("nameRoom").trim();
                int status = Integer.parseInt(request.getParameter("status").trim());
                System.out.println(nameRoom + "+" + status);
                Vector<Room> vectorR = daoR.selectRoom(nameRoom, status);

                request.setAttribute("vectorR", vectorR);
                request.getRequestDispatcher("managerRoom.jsp").forward(request, response);

            }

            if (service.equalsIgnoreCase("searchName")) { // tìm tên khách hàng
                String name = request.getParameter("Name").trim();
                Vector<User> vectorU = dao.getSearchNameCustomerListByReceptionist(name);
                request.setAttribute("vectorU", vectorU);
                request.getRequestDispatcher("managerCustomer.jsp").forward(request, response);

            }
        } catch (Exception ex) {
            Logger.getLogger(ReceptionistController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("errorMess", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (Exception ex) {
            Logger.getLogger(ReceptionistController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (Exception ex) {
            Logger.getLogger(ReceptionistController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
