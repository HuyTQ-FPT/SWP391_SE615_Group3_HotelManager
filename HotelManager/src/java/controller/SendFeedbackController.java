package controller;

import dao.SendFeedbackDAO;
import dao.impl.SendFeedbackDAOIpml;
import entity.sendFeedback;
import java.io.IOException;
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
@WebServlet(name = "SendFeedbackController", urlPatterns = {"/SendFeedbackController"})
public class SendFeedbackController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            SendFeedbackDAO daoS = new SendFeedbackDAOIpml();
            HttpSession session = request.getSession();
            String service = request.getParameter("do");
            if (service == null) { // trả về trang liên lạc

                String email = request.getParameter("email").trim();
                String title = request.getParameter("title").trim();
                String message = request.getParameter("message").trim();

                daoS.insert(new sendFeedback(title, email, message, "0"));
                String mEss = "Gửi yêu cầu thành công.";
                request.setAttribute("mEss", mEss);
                request.getRequestDispatcher("contact.jsp").forward(request, response);

            }

            if (service.equalsIgnoreCase("listMessFeedBack")) { // in ra tất cả yêu cầu

                Vector<sendFeedback> vectorS = new Vector<>();
                Vector<sendFeedback> vectorS1 = new Vector<>();
                String indexPage = request.getParameter("index");

                if (indexPage == null) {
                    indexPage = "1";
                }
                int index = Integer.parseInt(indexPage);

                int count = daoS.getMessage().size();

                int endPage = count / 3;
                System.out.println(endPage);
                if (count % 3 != 0) {
                    endPage++;
                }
                vectorS = daoS.pagingMessage(index);
                vectorS1 = daoS.getMessageUnread();
                String href = "SendFeedbackController?do=listMessFeedBack&";
                request.setAttribute("endPage", endPage);
                request.setAttribute("count", count);
                request.setAttribute("href", href);
                request.setAttribute("index", index);
                request.setAttribute("vetorS", vectorS);
                request.setAttribute("vetorS1", vectorS1);
                session.setAttribute("index", index);

                request.getRequestDispatcher("requestMessage.jsp").forward(request, response);

            }
            if (service.equalsIgnoreCase("SeenMessage")) { // xem nội dung yêu cầu
                int id = Integer.parseInt(request.getParameter("mid").trim());
                sendFeedback seen = daoS.getMessageById(id);
                int n = daoS.updateRead(id, seen.getIsRead());
                request.setAttribute("seen", seen);
                request.getRequestDispatcher("viewRequest.jsp").forward(request, response);

            }
            if (service.equalsIgnoreCase("deleteMessage")) { // xoá yêu cầu

                int id = Integer.parseInt(request.getParameter("mId").trim());
                System.out.println(id);
                daoS.delete(id);
                String Mess = "Xoá thành công.";
                request.setAttribute("Mess", Mess);
                request.getRequestDispatcher("SendFeedbackController?do=listMessFeedBack").forward(request, response);

            }
            if (service.equalsIgnoreCase("updateIsRead")) { // cập nhật trạng thái đọc

                int id = Integer.parseInt(request.getParameter("mID").trim());
                String isRead = request.getParameter("isRead");
                System.out.println(isRead);
                daoS.updateRead(id, isRead);
                request.getRequestDispatcher("SendFeedbackController?do=listMessFeedBack").forward(request, response);

            }
            if (service.equalsIgnoreCase("searchName")) { // tìm kiến tên tiêu đề
                String nameTitle = request.getParameter("nameTitle").trim();
                String indexPage = request.getParameter("index");
                // index page always start at 1
                Vector<sendFeedback> vectorS = new Vector<>();
                Vector<sendFeedback> vectorS1 = new Vector<>();

                if (indexPage == null) {
                    indexPage = "1";
                }
                int index = Integer.parseInt(indexPage);

                int count = daoS.getMessageOfTitle(nameTitle).size();

                int endPage = count / 3;

                if (count % 3 != 0) {
                    endPage++;
                }
                vectorS1 = daoS.getMessageUnread();
                vectorS = daoS.searchName(index, nameTitle);
                String href = "SendFeedbackController?do=searchName&";
                request.setAttribute("endPage", endPage);
                request.setAttribute("count", count);
                request.setAttribute("href", href);
                request.setAttribute("index", index);
                request.setAttribute("vetorS", vectorS);
                request.setAttribute("vetorS1", vectorS1);
                request.setAttribute("nameTitle", nameTitle);
                session.setAttribute("index", index);
                request.getRequestDispatcher("requestMessage.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            Logger.getLogger(SendFeedbackController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SendFeedbackController.class
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
            Logger.getLogger(SendFeedbackController.class
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
