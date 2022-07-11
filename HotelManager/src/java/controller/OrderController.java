package controller;

import dao.impl.DateOfRoomImpl;
import dao.impl.ReservationDAOImpl;
import dao.impl.ServiceDAOImpl;
import entity.DateOfRoom;
import entity.Reservation;
import entity.Service;
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

@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String service = request.getParameter("do");
            DBContext db = new DBContext();
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
            }
            if (service.equalsIgnoreCase("guest")) {
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
                String userid = request.getParameter("userid");
                String i = request.getParameter("id");
                int id = Integer.parseInt(i);
                Vector<Service> vector = daos.getServiceList();
                ResultSet rs1 = db.getData("select * from Account a  INNER JOIN [User] u \n"
                        + " on a.AccountID=u.AccountID where a.AccountID=" + userid);
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
                String checkin = request.getParameter("checkin");
                String checkout = request.getParameter("checkout");
                String adult = request.getParameter("Adult").trim();
                String child = request.getParameter("Child").trim();
                // Lấy price service
                String[] serviceId = request.getParameterValues("service");
                String serv = "";
                double price = 0;
                // lay service price and name
                if (serviceId != null) {
                    if (!(serviceId.length == 0)) {
                        for (int i = 0; i < serviceId.length; i++) {
                            Integer f = Integer.parseInt(serviceId[i]);
                            ResultSet rs = db.getData("select * from Service where ServiceID=" + f);
                            while (rs.next()) {
                                price += rs.getDouble(6);
                                serv += rs.getString(2) + ";";
                            }
                        }
                    }
                }
                int a = Integer.parseInt(adult) + Integer.parseInt(child); // number of person
                int id = Integer.parseInt(key);
                // ép type date check in check out
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = (Date) format.parse(checkin);
                java.sql.Date sDate = new java.sql.Date(date1.getTime());

                Date date2 = (Date) format.parse(checkout);
                java.sql.Date cDate = new java.sql.Date(date2.getTime());

                double total = price + Double.parseDouble(money);
                long millis = System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);
                int user = Integer.parseInt(userid);
                Reservation re = new Reservation(user, id, firstname, email, address, phone, a, sDate, cDate, total, 1, date);
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
                String checkin = request.getParameter("checkin");
                String checkout = request.getParameter("checkout");
                String a = request.getParameter("number").trim();
                // Lấy price service
                int id = Integer.parseInt(key);
                // ép type date check in check out
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = (Date) format.parse(checkin);
                java.sql.Date sDate = new java.sql.Date(date1.getTime());

                Date date2 = (Date) format.parse(checkout);
                java.sql.Date cDate = new java.sql.Date(date2.getTime());

                long millis = System.currentTimeMillis();
                java.sql.Date date = new java.sql.Date(millis);

                Account acc = (Account) session.getAttribute("login");
                int l = acc.getAccountID();
                double total = Double.parseDouble(money);
                Reservation re = new Reservation(l, id, firstname, email, address, phone, Integer.parseInt(a), sDate, cDate, total, 1, date);
                vector.add(re);
                // lưu trong session
                session.setAttribute(key, re);
                //lưu vào database
                DateOfRoom d = new DateOfRoom(id, sDate, cDate, 1);
                dao2.addReservation(d);
                int n = dao1.addReservation(re);
                response.sendRedirect("HomeController");
            }
            if (service.equals("yourbill")) {// Lịch sử mua hàng
                Vector<Reservation> vector = new Vector<Reservation>();
                String cid = request.getParameter("id");
                vector = dao1.Reservation("select * from Reservation where UserID=" + cid);
                request.setAttribute("vector", vector);
                request.setAttribute("aid", cid);
                RequestDispatcher dispath = request.getRequestDispatcher("History.jsp");
                dispath.forward(request, response);
            }
            if (service.equals("showCartAdmin")) {
                ResultSet rs = dao1.getData(" select r.Roomname,i.image1,re.Name,re.Email,re.[Address],re.Phone,re.NumberOfPerson,re.Checkin,re.Checkout,re.Total,re.[Status],re.[Date],re.RoomID,re.BillID,re.UserID  from Reservation re\n"
                        + " join Room r on r.RoomID=re.RoomID\n"
                        + " join [Image] i on r.RoomimgaeID=i.RoomimgaeID ");
                request.setAttribute("rs", rs);
                RequestDispatcher dispath = request.getRequestDispatcher("AdminCart.jsp");
                dispath.forward(request, response);
            }
            if (service.equals("AddCartAdmin")) {
                String rname = request.getParameter("rname");
                String rid = request.getParameter("ID");
                String cid = request.getParameter("cus");
                String cname = request.getParameter("cname");
                String email = request.getParameter("email").trim();
                String address = request.getParameter("address").trim();
                String phone = request.getParameter("phone").trim();
                String number = request.getParameter("number").trim();
                String cin = request.getParameter("cin").trim();
                String cout = request.getParameter("cout");
                String total = request.getParameter("total");
                String status = request.getParameter("status").trim();
                String date = request.getParameter("date");

                double total1 = Double.parseDouble(total);
                int roomid = Integer.parseInt(rname);
                int csid = Integer.parseInt(cid);
                int NOP = Integer.parseInt(number);
                int stt = Integer.parseInt(status);

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = (Date) format.parse(cin);
                java.sql.Date sDate = new java.sql.Date(date1.getTime());

                Date date2 = (Date) format.parse(cout);
                java.sql.Date cDate = new java.sql.Date(date2.getTime());
                Date date3 = (Date) format.parse(date);
                java.sql.Date dDate = new java.sql.Date(date3.getTime());

                ResultSet rs1 = dao1.getData("select * from [User] where UserID="+cid);
                if(rs1.next()){
                    cname= rs1.getString(3);
                }
                Reservation re = new Reservation(csid, roomid, cname, email, address, phone, NOP, sDate, cDate, total1, stt, dDate);
                int n = dao1.addReservation(re);
                ResultSet rs = dao1.getData(" select r.Roomname,i.image1,re.Name,re.Email,re.[Address],re.Phone,re.NumberOfPerson,re.Checkin,re.Checkout,re.Total,re.[Status],re.[Date],re.RoomID,re.BillID,re.UserID  from Reservation re\n"
                        + " join Room r on r.RoomID=re.RoomID\n"
                        + " join [Image] i on r.RoomimgaeID=i.RoomimgaeID ");
                request.setAttribute("rs", rs);
                RequestDispatcher dispath = request.getRequestDispatcher("AdminCart.jsp");
                dispath.forward(request, response);

            }
            if (service.equals("ShowUpdateCartAdmin")) {
                String oid = request.getParameter("id");
                int id = Integer.parseInt(oid);
                ResultSet rs = dao1.getData(" select r.Roomname,i.image1,re.Name,re.Email,re.[Address],re.Phone,re.NumberOfPerson,re.Checkin,re.Checkout,re.Total,re.[Status],re.[Date],re.RoomID,re.BillID,re.UserID from Reservation re\n"
                        + " join Room r on r.RoomID=re.RoomID\n"
                        + " join [Image] i on r.RoomimgaeID=i.RoomimgaeID where re.BillID=" + id);
                request.setAttribute("rs", rs);
                RequestDispatcher dispath = request.getRequestDispatcher("UpdateCart.jsp");
                dispath.forward(request, response);
            }
            if (service.equals("UpdateCartAdmin")) {
                String rname = request.getParameter("rname");
                String rid = request.getParameter("ID");
                String bid = request.getParameter("BID");
                String cid = request.getParameter("cid");
                String cname = request.getParameter("cname");
                String email = request.getParameter("email").trim();
                String address = request.getParameter("address").trim();
                String phone = request.getParameter("phone").trim();
                String number = request.getParameter("number").trim();
                String cin = request.getParameter("cin").trim();
                String cout = request.getParameter("cout");
                String total = request.getParameter("total");
                String status = request.getParameter("status").trim();
                String date = request.getParameter("date");

                double total1 = Double.parseDouble(total);
                int roomid = Integer.parseInt(rname);
                int csid = Integer.parseInt(cid);
                int billid = Integer.parseInt(bid);
                int NOP = Integer.parseInt(number);
                int stt = Integer.parseInt(status);

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = (Date) format.parse(cin);
                java.sql.Date sDate = new java.sql.Date(date1.getTime());

                Date date2 = (Date) format.parse(cout);
                java.sql.Date cDate = new java.sql.Date(date2.getTime());
                Date date3 = (Date) format.parse(date);
                java.sql.Date dDate = new java.sql.Date(date3.getTime());

                Reservation re = new Reservation(billid, csid, roomid, cname, email, address, phone, NOP, sDate, cDate, total1, stt, dDate);
                int n = dao1.updateReservation(re);
                ResultSet rs = dao1.getData(" select r.Roomname,i.image1,re.Name,re.Email,re.[Address],re.Phone,re.NumberOfPerson,re.Checkin,re.Checkout,re.Total,re.[Status],re.[Date],re.RoomID,re.BillID,re.UserID  from Reservation re\n"
                        + " join Room r on r.RoomID=re.RoomID\n"
                        + " join [Image] i on r.RoomimgaeID=i.RoomimgaeID ");
                request.setAttribute("rs", rs);
                RequestDispatcher dispath = request.getRequestDispatcher("AdminCart.jsp");
                dispath.forward(request, response);

            }
            if (service.equals("getUser")) {
                String name = request.getParameter("cus");
                String cid = request.getParameter("rname");
                String total = request.getParameter("number");
                System.out.println(name);
                System.out.println(total);
                System.out.println(cid);
                request.setAttribute("name", name);
                request.setAttribute("cid", cid);
                request.setAttribute("total", total);
                session.setMaxInactiveInterval(1*1);
                session.setAttribute("total",total);
                RequestDispatcher dispath = request.getRequestDispatcher("AddCart.jsp");
                dispath.forward(request, response);
            }if (service.equals("delete")) {
                String cid = request.getParameter("id");
                dao1.removeReservation(Integer.parseInt(cid));
                 ResultSet rs = dao1.getData(" select r.Roomname,i.image1,re.Name,re.Email,re.[Address],re.Phone,re.NumberOfPerson,re.Checkin,re.Checkout,re.Total,re.[Status],re.[Date],re.RoomID,re.BillID,re.UserID  from Reservation re\n"
                        + " join Room r on r.RoomID=re.RoomID\n"
                        + " join [Image] i on r.RoomimgaeID=i.RoomimgaeID ");
                request.setAttribute("rs", rs);
                RequestDispatcher dispath = request.getRequestDispatcher("AdminCart.jsp");
                dispath.forward(request, response);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
