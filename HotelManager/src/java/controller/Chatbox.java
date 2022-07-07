package controller;

import dao.impl.AccountDAOImpl;
import dao.impl.MessageDAOImpl;
import dao.impl.UserDAOImpl;
import entity.Account;
import entity.Message;
import entity.User;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import jdk.nashorn.internal.ir.RuntimeNode;

@ServerEndpoint(value = "/ChatSocket")
public class Chatbox {

    static Set<Session> users = Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void handleOpen(Session session) {
        users.add(session);
    }

    @OnMessage
    public void handleMessage(String message, Session userSession) throws IOException, Exception {
        message = message.trim();
        AccountDAOImpl Adao = new AccountDAOImpl();
        MessageDAOImpl Mdao = new MessageDAOImpl();
        UserDAOImpl Udao = new UserDAOImpl();
        ArrayList<Integer> listAc = Mdao.getAllAcccountMessage();
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formatted = current.format(formatter);
        String date = current.format(formatter1);
        String username = (String) userSession.getUserProperties().get("username");
        if (!message.isEmpty()) {
            if (username == null) {
                userSession.getUserProperties().put("username", message);// user nào nhắn tin sẽ lấy của user đấy 
            } else {
                System.out.println(userSession.getUserProperties().get("username"));
                int aid = 0;
                int userid = 0;
                String s1 = username;
                String[] words = s1.split("\\s");//tach chuoi dua tren khoang trang
                //su dung vong lap foreach de in cac element cua mang chuoi thu duoc
                for (String w : words) {
                    userid = Integer.parseInt(w);
                    break;
                }
                for (String w : words) {
                    aid = Integer.parseInt(w);
                }
                int Roleid = Mdao.getRoleIDByUserId(userid);
                boolean exitAccount = false;
                for (Integer a : listAc) {
                    if (aid == a) {
                        exitAccount = true;
                        break;
                    }
                }
                System.out.println(exitAccount);
                User u = Udao.getUserByaID(aid);
                for (Session session : users) {
                    int SessionAid = 0;
                    int SessionUserid = 0;
                    String ValueSS = "";
                    ValueSS = (String) session.getUserProperties().get("username");
                    String[] words1 = ValueSS.split("\\s");//tach chuoi dua tren khoang trang
                    //su dung vong lap foreach de in cac element cua mang chuoi thu duoc
                    for (String w : words1) {
                        SessionUserid = Integer.parseInt(w);
                        break;
                    }
                    for (String w : words1) {
                        SessionAid = Integer.parseInt(w);
                    }
                    String sent = "";
                    String revice = "";
                    if (SessionUserid == userid) {
                        sent += "<div class=\"outgoing_msg\">\n"
                                + "                                <div class=\"sent_msg\">\n"
                                + "                                    <p>" + message + "</p>\n"
                                + "                                    <span style=\"font-size: 12px;\" class=\"time_date\">" + formatted + "</span>\n"
                                + "                                </div>\n"
                                + "                            </div>";
                        session.getBasicRemote().sendText(sent);
                    } else if (SessionAid == aid) {
                        revice += "<div class=\"incoming_msg\">             \n"
                                + "                                <div class=\"incoming_msg_img\"> <img src=\"https://ptetutorials.com/images/user-profile.png\" alt=\"sunil\"> </div>              \n"
                                + "                                <div class=\"received_msg\">\n"
                                + "                                    <div class=\"received_withd_msg\">\n"
                                + "                                        <p>" + message + "</p>\n"
                                + "                                        <span style=\"font-size: 12px;\" class=\"time_date\">" + formatted + "</span>\n"
                                + "                                    </div>                         \n"
                                + "                                </div>\n"
                                + "                            </div>";
                        session.getBasicRemote().sendText(revice);
                    }
                    if (Mdao.getRoleIDByUserId(SessionUserid) == 2 && SessionAid != aid) {
                        if (Roleid == 1) {
                            Mdao.insertNewmessagecus(new Message(aid, date, message));
                        } else {
                            Mdao.insertMessageRe(new Message(aid, date, message));
                        }
                        session.getBasicRemote().sendText(aid + " " + "<span>*</span>");
                    }else if (Mdao.getRoleIDByUserId(SessionUserid) == 2 && SessionAid == aid) {
                        if (Roleid == 1) {
                            Mdao.insertMessageCus(new Message(aid, date, message));
                        } else {
                            Mdao.insertMessageRe(new Message(aid, date, message));
                        }
                    }
                    if (Mdao.getRoleIDByUserId(SessionUserid) == 2 && SessionAid != aid && !exitAccount) {
                        if (Roleid == 1) {
                            Mdao.insertNewmessagecus(new Message(aid, date, message));
                        } else {
                            Mdao.insertMessageRe(new Message(aid, date, message));
                        }
                        session.getBasicRemote().sendText("<a href=\"MessageController?do=Chat_people&accountid=" + aid + "\">                               \n"
                                + "                                <div class=\"chat_list\">\n"
                                + "                                    <div class=\"chat_people\">\n"
                                + "                                        <div class=\"chat_img\"> <img src=\"https://ptetutorials.com/images/user-profile.png\" alt=\"sunil\"> </div>\n"
                                + "                                        <div id=\"" + aid + "\" class=\"chat_ib\">\n"
                                + "                                            <!--<h5 style=\"font-weight: bold;font-size:14px;\"></h5>-->\n"
                                + "                                            <h5>" + u.getUserName() + "</h5>\n"
                                + "                                            <span>*</span>\n"
                                + "                                        </div>\n"
                                + "                                    </div>\n"
                                + "                                </div>       \n"
                                + "                            </a>");
                    }
                }
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

}
