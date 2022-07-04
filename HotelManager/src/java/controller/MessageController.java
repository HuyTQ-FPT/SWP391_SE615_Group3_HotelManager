
package controller;

import entity.Message;
import dao.impl.MessageDAOImpl;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "MessageController", urlPatterns = {"/MessageController"})
public class MessageController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            HttpSession session =request.getSession();
            MessageDAOImpl dao = new MessageDAOImpl();
            String service = request.getParameter("do");
            if (service == null) {
                service="Viewchatbox";
            }
            if(service.equals("Viewchatbox")){
                Account a = (Account)session.getAttribute("login");
                if(a.getRoleID()==1){
                    request.setAttribute("accountid", a.getAccountID());
                    request.getRequestDispatcher("ViewChatbot.jsp").forward(request, response);
                }                  
                else {
                    ResultSet rs =dao.getData("select distinct top(1) AccountID from Message");                   
                    while (rs.next()) {                         
                        request.setAttribute("accountid", rs.getInt(1));
                    }                                                           
                    request.getRequestDispatcher("ViewChatbot.jsp").forward(request, response);
                }                     
            }
             if(service.equals("SearchChatCustomer")){
                 String name =request.getParameter("name");
                 System.out.println(name+"naemansmd");
                 if(!name.isEmpty()){                
                 ResultSet rs =dao.getData("select u.* from Account a join [User] u\n" +
"on a.AccountID=u.AccountID\n" +
"where u.UserName like '%"+name+"%' and a.RoleID=1");                 
                     request.setAttribute("accountid", 1);
                    request.setAttribute("found", "");                 
                    request.setAttribute("rs", rs);                 
                    request.getRequestDispatcher("ViewChatbot.jsp").forward(request, response);
             } else{
                     response.sendRedirect("MessageController");
                 }}
            
            if(service.equals("messCus")){
                request.setAttribute("mess", request.getParameter("message"));
                int accountid = Integer.parseInt(request.getParameter("accountID"));
                if(!request.getParameter("message").equals("")){
                    dao.insertMessageCus(new Message(accountid , request.getParameter("message").trim()));
                    ResultSet rs =dao.getData("select distinct AccountID from Message");                                        
                }
                request.getRequestDispatcher("ViewChatbot.jsp").forward(request, response);
            }
            if(service.equals("messRe")){                
                int accountid = Integer.parseInt(request.getParameter("accountID"));
                request.setAttribute("accountid", accountid);
                if(!request.getParameter("message").equals("")){
                     dao.insertMessageRe(new Message(accountid , request.getParameter("message").trim())); 
                    ResultSet rs =dao.getData("select distinct AccountID from Message");                   
                }
                response.sendRedirect("MessageController?do=Chat_people&accountid="+accountid);
            }
            if(service.equals("OnlymessRe")){                
                int accountid = Integer.parseInt(request.getParameter("accountID"));
                if(!request.getParameter("mssage").equals("")){
                     dao.insertMessageRe(new Message(accountid , request.getParameter("message").trim())); 
                    ResultSet rs =dao.getData("select distinct AccountID from Message");                   
                }
                response.sendRedirect("MessageController?do=Search_Chat_people&accountid="+accountid);
            }
            if(service.equals("Search_Chat_people")){
                request.setAttribute("accountid", Integer.parseInt(request.getParameter("accountid")));
                System.out.println(request.getParameter("accountid"));
                ResultSet rs =dao.getData("select u.* from Account a join [User] u\n" +
"on a.AccountID=u.AccountID\n" +
"where u.AccountID="+Integer.parseInt(request.getParameter("accountid")));                 
                request.setAttribute("accountid", Integer.parseInt(request.getParameter("accountid")));
                request.setAttribute("found", "");                 
                request.setAttribute("rs",rs);
                request.getRequestDispatcher("ViewChatbot.jsp").forward(request, response);
            }
            if(service.equals("Chat_people")){
                request.setAttribute("accountid", Integer.parseInt(request.getParameter("accountid")));
                request.setAttribute("showmess", "");
                request.getRequestDispatcher("ViewChatbot.jsp").forward(request, response);
            }
        }catch(Exception e){
            request.getRequestDispatcher("Filter.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(MessageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(MessageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
