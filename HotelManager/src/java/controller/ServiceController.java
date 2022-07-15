/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.DevicesDAOImpl;
import dao.impl.RoomCategoryDAOImpl;
import dao.impl.RoomDAOImpl;
import dao.impl.ServiceDAOImpl;
import entity.Device;
import entity.FeedBackService;
import entity.Room;
import entity.RoomCategory;
import entity.Service;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ServiceController", urlPatterns = {"/ServiceController"})
public class ServiceController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, FileUploadException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
            String doo = request.getParameter("do");
            RoomDAOImpl RoomDao = new RoomDAOImpl();
            ServiceDAOImpl ServiceDao = new ServiceDAOImpl();
            DevicesDAOImpl DeviceDao = new DevicesDAOImpl();
            RoomCategoryDAOImpl RoomCateDao = new RoomCategoryDAOImpl();
            if (doo.equals("") || doo == null) {
                out.println("<h1>Lỗi Trang</h1>");
            }
            if (doo.equals("CommentService")) {
                String ServiceID = request.getParameter("ServiceID");
                String AccountID = request.getParameter("AccountID");
                String comment = request.getParameter("comment");
                ServiceDao.insertCommentService(ServiceID, AccountID, comment.replaceAll("\\s\\s+", " ").trim());
                response.sendRedirect("ServiceController?do=servicedetail&ServiceID=" + ServiceID + "");
//                out.println("<h1>Lỗi Trang "+comment+"</h1>");
            }
            if (doo.equals("ListComment")) {
                String ServiceID = request.getParameter("ServiceID");
                Vector<FeedBackService> listFeedBack = ServiceDao.getFeedBackBySeviceID("select * from FeedBackService join "
                        + "[User] on FeedBackService.AccountID = [User].AccountID where ServiceID = " + ServiceID + " order by FeedBackService.Date desc");
                request.setAttribute("listFeedBack", listFeedBack);
//                   out.println("<h1>Lỗi Trang "+listFeedBack+"</h1>");
                request.getRequestDispatcher("ListComment.jsp").forward(request, response);
            }
            if (doo.equals("DeleteComment")) {
                String ServiceID = request.getParameter("ServiceId");
                String CommnetID = request.getParameter("CommentID");
                ServiceDao.DeleteComnent(CommnetID);
//                out.println("<h1>Lỗi Trang "+CommnetID+"</h1>");
                response.sendRedirect("ServiceController?do=ListComment&ServiceID="+ServiceID+"");
            }

            if (doo.equals("servicedetail")) {
                String ServiceID = request.getParameter("ServiceID");
                Vector<Room> getroomlist = RoomDao.getRoomList("select top (5) * from Room INNER JOIN Image on Image.RoomimgaeID= Room.RoomimgaeID\n"
                        + "                        JOIN CateRoom on Room.RoomcateID = CateRoom.RoomcateID\n"
                        + "                        where Room.Status =0 \n"
                        + "			   ORDER BY NEWID()");
                Vector<Room> getroomlist2 = RoomDao.getRoomList("select top (4) * from Room INNER JOIN Image on Image.RoomimgaeID= Room.RoomimgaeID\n"
                        + "                        JOIN CateRoom on Room.RoomcateID = CateRoom.RoomcateID\n"
                        + "                        where Room.Status =0 \n"
                        + "			   ORDER BY NEWID()");
                Service se = ServiceDao.getServicedetail(ServiceID);
                Vector<FeedBackService> listFeedBack = ServiceDao.getFeedBackBySeviceID("select * from FeedBackService join "
                        + "[User] on FeedBackService.AccountID = [User].AccountID where ServiceID = " + ServiceID + " and [Status] =0 order by FeedBackService.Date desc");
                request.setAttribute("se", se);
                request.setAttribute("vector", getroomlist);
                request.setAttribute("getroomlist2", getroomlist2);
                request.setAttribute("listFeedBack", listFeedBack);
//                out.println("<h1>Lỗi Trang "+listFeedBack+"</h1>");
                request.getRequestDispatcher("viewRoom.jsp").forward(request, response);
            }
            if (doo.equals("ListService")) {
                Vector<Service> ListService = ServiceDao.getServiceList();
                request.setAttribute("ListService", ListService);
                request.getRequestDispatcher("ListService.jsp").forward(request, response);
//                out.println("<h1>Lỗi Trang "+ListService+"</h1>");
            }
            if (doo.equals("DeleteService")) {
                String DeviceId = request.getParameter("ServiceId");
                ServiceDao.deleteService("delete from Service where ServiceID =" + DeviceId + "");
                response.sendRedirect("ServiceController?do=ListService");
            }
            if (doo.equals("UpDateService")) {
                String DeviceId = request.getParameter("ServiceId");
                Service Services = ServiceDao.getServicedetail(DeviceId);
                request.setAttribute("services", Services);
                request.getRequestDispatcher("UpdateService.jsp").forward(request, response);
            }
            String value = "";
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // Configure a repository (to ensure a secure temp location is used)
            ServletContext servletContext = this.getServletConfig().getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            factory.setRepository(repository);
            // Create a new file upload handler 
            ServletFileUpload upload = new ServletFileUpload(factory);
            // Parse the request
            List<FileItem> items = upload.parseRequest(request);
            // Process the uploaded items
            Iterator<FileItem> iter = items.iterator();
            String filename = "";
            if (doo.equals("UpDate")) {
                ArrayList<String> service = new ArrayList<String>();
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    HashMap<String, String> fileds = new HashMap<>();
                    if (item.isFormField()) {
                        fileds.put(item.getFieldName(), item.getString());
                        String name = item.getFieldName();
                        value = item.getString();
                        String values = new String(value.getBytes("ISO-8859-1"), "UTF-8");
                        service.add(values);
                    } else {
                        Random rand = new Random();
                        int n = rand.nextInt(99);
                        String s = String.valueOf(n);
                        filename = item.getName();
                        filename += s;
//                        String filenames = s.concat(filename);
                        if (filename == null || filename.equals("")) {
                            break;
                        } else {
                            Path path = Paths.get(filename);
                            String storePath = servletContext.getRealPath("/images/anhdevice");
                            File uploadFile = new File(storePath + "/" + path.getFileName());
                            item.write(uploadFile);
                            service.add(filename);
                        }
                    }
                }
                String ServiceID = service.get(0);
                String ServiceName = service.get(1);
                String ServiceDes = service.get(3);
                String ServicePrice = service.get(2);
                Service Services = ServiceDao.getServicedetail(ServiceID);
                String ServiceImage = service.get(4);
                if (ServiceImage.length() <= 2 || ServiceImage == null) {
                    ServiceImage = Services.getServiceImage();
                }
                ServiceDao.updateService(ServiceName.replaceAll("\\s\\s+", " ").trim(), ServiceImage, ServiceDes.replaceAll("\\s\\s+", " ").trim(), ServicePrice, ServiceID);
                response.sendRedirect("ServiceController?do=ListService");
            }
            if (doo.equals("InSert")) {
                ArrayList<String> service = new ArrayList<String>();
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    HashMap<String, String> fileds = new HashMap<>();
                    if (item.isFormField()) {
                        fileds.put(item.getFieldName(), item.getString());
                        String name = item.getFieldName();
                        value = item.getString();
                        String values = new String(value.getBytes("ISO-8859-1"), "UTF-8");
                        service.add(values);
                    } else {
                        Random rand = new Random();
                        int n = rand.nextInt(99);
                        String s = String.valueOf(n);
                        filename = item.getName();
                        filename += s;
//                        String filenames = s.concat(filename);
                        if (filename == null || filename.equals("")) {
                            break;
                        } else {
                            Path path = Paths.get(filename);
                            String storePath = servletContext.getRealPath("/images/anhdevice");
                            File uploadFile = new File(storePath + "/" + path.getFileName());
                            item.write(uploadFile);
                            service.add(filename);
                        }
                    }
                }
                String ServiceName = service.get(0);
                String ServiceDes = service.get(2);
                String ServicePrice = service.get(1);
                String ServiceImage = service.get(3);
                ServiceDao.insertService(ServiceName.replaceAll("\\s\\s+", " ").trim(), ServiceImage, ServiceDes.replaceAll("\\s\\s+", " ").trim(), ServicePrice);
//                out.println("<h1>Lỗi Trang "+service+"</h1>");
                response.sendRedirect("ServiceController?do=ListService");
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
            Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServiceController.class.getName()).log(Level.SEVERE, null, ex);
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
