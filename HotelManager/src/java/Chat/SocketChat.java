
package Chat;

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


@ServerEndpoint(value = "/chatRoomServer")
public class SocketChat {

    static Set<Session> users = Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void handleOpen(Session session) {
        users.add(session);
    }

//    @OnMessage
//    public void handleMessage(String message, Session userSession) throws IOException {
//        MessageDAO messageDAO = new MessageDAOImpl();
//        String username = (String) userSession.getUserProperties().get("username");
//        message = message.trim();
//        if (username == null) {
//            if (message.isEmpty()) {
//                userSession.getUserProperties().put("username", "User");
//                userSession.getBasicRemote().sendText("System: you are connectd as User");
//            } else {
//                userSession.getUserProperties().put("username", message);
//                userSession.getBasicRemote().sendText("System: you are connectd as " + message);
//
//                try {
//                    String txtSender = "";
//                    String txtReciver = "";
//                    ArrayList<Message> messagesList = messageDAO.getMessageList(message);
//                    for (Message message1 : messagesList) {
//                        if (((String) userSession.getUserProperties().get("username")).equals(message1.getUserID() + "")) {
//                            txtSender += "<div class=\"outgoing_msg\"> <div class=\"sent_msg\"> "
//                                    + "<span class=\"time_date\">" + message1.getUserID() + "</span> "
//                                    + "<p>" + message1.getMessage() + "</p> "
//                                    + "<span class=\"time_date\"> 11:01 AM | Today</span> "
//                                    + "</div></div>";
//                            txtReciver += "<div class=\"incoming_msg\">\n"
//                                    + "                                <div class=\"incoming_msg_img\"> <img\n"
//                                    + "                                        src=\"https://ptetutorials.com/images/user-profile.png\
//" alt=\"sunil\"> </div>\n"
//                                    + "                                <div class=\"received_msg\">\n"
//                                    + "                                    <div class=\"received_withd_msg\">\n"
//                                    + "                                        <span class=\"time_date\">" + message1.getUserID() + "</span>\n"
//                                    + "                                        <p>" + message1.getMessage() + "</p>\n"
//                                    + "                                        <span class=\"time_date\"> 11:01 AM | Today</span>\n"
//                                    + "                                    </div>\n"
//                                    + "                                </div>\n"
//                                    + "                            </div>";
//                        } else {
//                            txtSender += "<div class=\"incoming_msg\">\n"
//                                    + "                                <div class=\"incoming_msg_img\"> <img\n"
//                                    + "                                        src=\"https://ptetutorials.com/images/user-profile.png\
//" alt=\"sunil\"> </div>\n"
//                                    + "                                <div class=\"received_msg\">\n"
//                                    + "                                    <div class=\"received_withd_msg\">\n"
//                                    + "                                        <span class=\"time_date\">" + message1.getUserID() + "</span>\n"
//                                    + "                                        <p>" + message1.getMessage() + "</p>\n"
//                                    + "                                        <span class=\"time_date\"> 11:01 AM | Today</span>\n"
//                                    + "                                    </div>\n"
//                                    + "                                </div>\n"
//                                    + "                            </div>";
//                            txtReciver += "<div class=\"outgoing_msg\"> <div class=\"sent_msg\"> "
//                                    + "<span class=\"time_date\">" + message1.getUserID() + "</span> "
//                                    + "<p>" + message1.getMessage() + "</p> "
//                                    + "<span class=\"time_date\"> 11:01 AM | Today</span> "
//                                    + "</div></div>";
//                        }
//                    }
//                    for (Session session : users) {
//                        if (((String) userSession.getUserProperties().get("username")).equals(
//                                (String) session.getUserProperties().get("username"))) {
//                            session.getBasicRemote().sendText(txtSender);
//                        } else if (((String) userSession.getUserProperties().get("username")).equals("3")) {
//                            session.getBasicRemote().sendText(txtReciver);
//                        }
//                    }
//                } catch (Exception ex) {
//                }
//            }
//        } else {
//
//            try {
//                int userID = Integer.parseInt((String) userSession.getUserProperties().get("username"));
//                System.out.println("UserID=" + userID);
//                int roomID = messageDAO.getRoomID(userID);
//                System.out.println("RoomID=" + roomID);
//                int n = messageDAO.addMessage(new Message(userID, message, roomID, "12-13-2022"));
//                System.out.println("n=" + n);
//            } catch (Exception ex) {
////                Logger.getLogger(ChatRoomServerEndpoint.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            for (Session session : users) {
//                if (((String) userSession.getUserProperties().get("username")).equals("3")) {
//                    if (((String) session.getUserProperties().get("username")).equals("3")) {
//                        session.getBasicRemote().sendText("<div class=\"outgoing_msg\"> <div class=\"sent_msg\"> "
//                                + "<span class=\"time_date\">" + username + "</span> "
//                                + "<p>" + message + "</p> "
//                                + "<span class=\"time_date\"> 11:01 AM | Today</span> "
//                                + "</div></div>");
//
////                        session.getBasicRemote().sendText(message);
////                         session.getBasicRemote().sendText(username + ": " + message);
//                    } else {
//                        session.getBasicRemote().sendText("<div class=\"incoming_msg\">\n"
//                                + "                                <div class=\"incoming_msg_img\"> <img\n"
//                                + "                                        src=\"https://ptetutorials.com/images/user-profile.png\
//" alt=\"sunil\"> </div>\n"
//                                + "                                <div class=\"received_msg\">\n"
//                                + "                                    <div class=\"received_withd_msg\">\n"
//                                + "                                        <span class=\"time_date\">" + username + "</span>\n"
//                                + "                                        <p>" + message + "</p>\n"
//                                + "                                        <span class=\"time_date\"> 11:01 AM | Today</span>\n"
//                                + "                                    </div>\n"
//                                + "                                </div>\n"
//                                + "                            </div>");
//                    }
//                } else {
//                    if (!((String) session.getUserProperties().get("username")).equals("3")
//                            && ((String) session.getUserProperties().get("username")).equals(
//                                    (String) userSession.getUserProperties().get("username"))) {
//                        session.getBasicRemote().sendText("<div class=\"outgoing_msg\"> <div class=\"sent_msg\"> "
//                                + "<span class=\"time_date\">" + username + "</span> "
//                                + "<p>" + message + "</p> "
//                                + "<span class=\"time_date\"> 11:01 AM | Today</span> "
//                                + "</div></div>");
////                         session.getBasicRemote().sendText(username + ": " + message);
//                    } else if (((String) session.getUserProperties().get("username")).equals("3")) {
//                        session.getBasicRemote().sendText("<div class=\"incoming_msg\">\n"
//                                + "                                <div class=\"incoming_msg_img\"> <img\n"
//                                + "                                        src=\"https://ptetutorials.com/images/user-profile.png\
//" alt=\"sunil\"> </div>\n"
//                                + "                                <div class=\"received_msg\">\n"
//                                + "                                    <div class=\"received_withd_msg\">\n"
//                                + "                                        <span class=\"time_date\">" + username + "</span>\n"
//                                + "                                        <p>" + message + "</p>\n"
//                                + "                                        <span class=\"time_date\"> 11:01 AM | Today</span>\n"
//                                + "                                    </div>\n"
//                                + "                                </div>\n"
//                                + "                            </div>");
//                    }
//                }
//            }
//        }
//    }

    @OnClose
    public void handleClose(Session session) {
        users.remove(session);
    }

    @OnError
    public void handleError(Throwable t) {
        t.printStackTrace();
    }

}