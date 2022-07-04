package controller;

import dao.impl.MessageDAOImpl;
import entity.Message;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Chat", urlPatterns = {"/Chat"})
public class Chat extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("okeeee1234");
        MessageDAOImpl dao = new MessageDAOImpl();
        String mess =request.getParameter("message").toString();
        int accountid = Integer.parseInt(request.getParameter("accountID"));
        if (!mess.equals("")) {
            dao.insertMessageCus(new Message(accountid, mess.trim()));
        }
        out.print("<div class=\"incoming_msg\">             \n"
                + "                                <div class=\"incoming_msg_img\"> <img src=\"https://ptetutorials.com/images/user-profile.png\" alt=\"sunil\"> </div>              \n"
                + "                                <div class=\"received_msg\">\n"
                + "                                    <div class=\"received_withd_msg\">\n"
                + "                                        <p>" + mess + "</p>\n"
                + "                                    </div>                         \n"
                + "                                </div>\n"
                + "                            </div>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
