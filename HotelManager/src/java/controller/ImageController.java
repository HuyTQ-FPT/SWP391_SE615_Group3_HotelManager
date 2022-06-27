/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ImageDAO;
import dao.impl.ImageDAOImpl;
import dao.impl.RoomCategoryDAOImpl;
import dao.impl.RoomDAOImpl;
import entity.Image;
import entity.Room;
import entity.RoomCategory;
import static java.awt.SystemColor.text;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.beans.binding.Bindings.length;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ImageController", urlPatterns = {"/ImageController"})
public class ImageController extends HttpServlet {

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
            throws ServletException, IOException, FileUploadException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ImageDAOImpl dao = new ImageDAOImpl();
            RoomDAOImpl daor = new RoomDAOImpl();
            RoomCategoryDAOImpl roomcate = new RoomCategoryDAOImpl();
            String service = request.getParameter("do");
            String roomid = request.getParameter("RoomID");
            String filename = null;
            if (service == null) {
                Vector<Image> vector = dao.getImageByid("1");
                request.setAttribute("vector", vector);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            if (service.equals("listImage")) {
                Vector<RoomCategory> romcate = roomcate.getRoomCategoryList("select * from CateRoom");
                Room listroom = daor.getRoom1("select * from Room join CateRoom on Room.RoomcateID = CateRoom.RoomcateID where RoomID = " + roomid + "");
                Image img = dao.imageByID("select * from [image] join Room on [Image].RoomimgaeID = Room.RoomimgaeID where RoomID = " + roomid + "");
                request.setAttribute("img", img);
                request.setAttribute("listroom", listroom);
                request.setAttribute("romcate", romcate);
//                out.println("<h1>Servlet RoomcategoryController at " + listroom + "</h1>");
//                request.getRequestDispatcher("importimg.jsp").forward(request, response);
                request.getRequestDispatcher("EditRoomAdmin.jsp").forward(request, response);
            }
            String value = null;
            String id = request.getParameter("roomIDs");
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
            if (service.equals("changeImgae1")) {
                //                out.println("<h1>Servlet RoomcategoryController at</h1>");
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    HashMap<String, String> fileds = new HashMap<>();
                    if (item.isFormField()) {
                        fileds.put(item.getFieldName(), item.getString());
                        String name = item.getFieldName();
                        value = item.getString();
                    } else {
                        Random rand = new Random();
                        int n = rand.nextInt(50);
                        String s = String.valueOf(n);
                        filename = item.getName();
                        filename += s;
                        if (filename == null || filename.equals("")) {
                            break;
                        } else {
                            Path path = Paths.get(filename);
                            String storePath = servletContext.getRealPath("/images/anhphong");
                            File uploadFile = new File(storePath + "/" + path.getFileName());
                            item.write(uploadFile);
                            dao.crudImage("UPDATE [dbo].[Image]\n"
                                    + "   SET [image1] = '" + filename + "'\n"
                                    + " WHERE RoomimgaeID = " + value + "");
//                            out.println("<h1>Servlet RoomcategoryController at " + filename + "</h1>");
//                            out.println("<h1>Servlet RoomcategoryController at " + storePath + "/" + path.getFileName() + "</h1>");
                            request.setAttribute("update", "update");
                            request.getRequestDispatcher("ImageController?do=listImage&RoomID=" + value + "").forward(request, response);
                        }
                    }
                }
            }
            if (service.equals("changeImgae2")) {
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    HashMap<String, String> fileds = new HashMap<>();
                    if (item.isFormField()) {
                        fileds.put(item.getFieldName(), item.getString());
                        String name = item.getFieldName();
                        value = item.getString();
//                        out.println("<h1>Servlet RoomcategoryController at " + name + value + "</h1>");
                    } else {
                        Random rand = new Random();
                        int n = rand.nextInt(50);
                        String s = String.valueOf(n);
                        filename = item.getName();
                        filename += s;
                        if (filename == null || filename.equals("")) {
                            break;
                        } else {
                            Path path = Paths.get(filename);
                            String storePath = servletContext.getRealPath("/images/anhphong");
                            File uploadFile = new File(storePath + "/" + path.getFileName());
                            item.write(uploadFile);
                            out.println("<h1>Servlet RoomcategoryController at " + filename + "</h1>");
                            dao.crudImage("UPDATE [dbo].[Image]\n"
                                    + "   SET [image2] = '" + filename + "'\n"
                                    + " WHERE RoomimgaeID = " + value + "");
//                            out.println("<h1>Servlet RoomcategoryController at " + storePath + "/" + path.getFileName() + "</h1>");
                            request.setAttribute("update", "update");
                            request.getRequestDispatcher("ImageController?do=listImage&RoomID=" + value + "").forward(request, response);

                        }
                    }
                }
            }
            if (service.equals("changeImgae3")) {
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    HashMap<String, String> fileds = new HashMap<>();
                    if (item.isFormField()) {
                        fileds.put(item.getFieldName(), item.getString());
                        String name = item.getFieldName();
                        value = item.getString();
//                        out.println("<h1>Servlet RoomcategoryController at " + name + value + "</h1>");
                    } else {
                        filename = item.getName();
                        Random rand = new Random();
                        int n = rand.nextInt(50);
                        String s = String.valueOf(n);
                        filename = item.getName();
                        filename += s;
                        if (filename == null || filename.equals("")) {
                            break;
                        } else {
                            Path path = Paths.get(filename);
                            String storePath = servletContext.getRealPath("/images/anhphong");
                            File uploadFile = new File(storePath + "/" + path.getFileName());
                            item.write(uploadFile);
//                            out.println("<h1>Servlet RoomcategoryController at " + filename + "</h1>");
                            dao.crudImage("UPDATE [dbo].[Image]\n"
                                    + "   SET [image3] = '" + filename + "'\n"
                                    + " WHERE RoomimgaeID = " + value + "");
                            request.setAttribute("update", "update");
//                            out.println("<h1>Servlet RoomcategoryController at " + storePath + "/" + path.getFileName() + "</h1>");
                            request.getRequestDispatcher("ImageController?do=listImage&RoomID=" + value + "").forward(request, response);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
        } catch (FileUploadException ex) {
            Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (FileUploadException ex) {
            Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
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
