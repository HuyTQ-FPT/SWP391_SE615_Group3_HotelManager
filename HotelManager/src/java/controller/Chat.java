package controller;

import dao.impl.MessageDAOImpl;
import entity.Account;
import entity.Message;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@WebServlet(name = "Chat", urlPatterns = {"/Chat"})
public class Chat extends HttpServlet {
    
    static Set<Session> users = Collections.synchronizedSet(new HashSet<>());

	@OnOpen
	public void handleOpen(Session session) {
		users.add(session);
	}

	@OnMessage
	public void handleMessage(String message, Session userSession) throws IOException {
		String username = (String) userSession.getUserProperties().get("username");
		if (username == null) {
//			userSession.getUserProperties().put("username", message);
//			userSession.getBasicRemote().sendText("System: you are connectd as " + message);
		} else {
			for (Session session : users) {
				session.getBasicRemote().sendText("<div class=\"outgoing_msg\">\n" +
"                                <div class=\"sent_msg\">\n" +
"                                    <p>"+message+"</p>\n" +
"                                </div>\n" +
"                            </div>");
			}
		}
	}

	@OnClose
	public void handleClose(Session session) {
		users.remove(session);
	}

	@OnError
	public void handleError(Throwable t) {
		t.printStackTrace();
	}

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        MessageDAOImpl dao = new MessageDAOImpl();
        String mess =request.getParameter("message").toString();
        int accountid = Integer.parseInt(request.getParameter("accountID"));
        LocalDateTime current = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formatted = current.format(formatter);
        if (!mess.equals("")) {
            dao.insertMessageCus(new Message(accountid,formatted, mess.trim()));
        }
        Account a =(Account) session.getAttribute("Login");
        
        out.print("<div class=\"outgoing_msg\">\n" +
"                                <div class=\"sent_msg\">\n" +
"                                    <p>"+mess+"</p>\n" +
"                                </div>\n" +
"                            </div>");
//        out.print("<div class=\"incoming_msg\">             \n"
//                + "                                <div class=\"incoming_msg_img\"> <img src=\"https://ptetutorials.com/images/user-profile.png\" alt=\"sunil\"> </div>              \n"
//                + "                                <div class=\"received_msg\">\n"
//                + "                                    <div class=\"received_withd_msg\">\n"
//                + "                                        <p>" + mess + "</p>\n"
//                + "                                    </div>                         \n"
//                + "                                </div>\n"
//                + "                            </div>");
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
