/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.DevicesDAOImpl;
import dao.impl.ImageDAOImpl;
import dao.impl.RoomCategoryDAOImpl;
import dao.impl.RoomDAOImpl;
import entity.Device;
import entity.Room;
import entity.RoomCategory;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
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
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Admin
 */
@WebServlet(name = "RoomNameController", urlPatterns = {"/RoomsController"})
public class RoomDeviceController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            String dos = request.getParameter("do");
            RoomDAOImpl dao = new RoomDAOImpl();
            ImageDAOImpl daos = new ImageDAOImpl();
            RoomCategoryDAOImpl roomcate = new RoomCategoryDAOImpl();
            String cateroom = request.getParameter("cateroom");
            String cate;
            if (cateroom == null) {
                cateroom = "1";
                cate = "";
            } else {
                cate = "(Room.RoomcateID=" + cateroom + ") and";
            }
            if (dos.equals("listroom")) {
                String RoomId = request.getParameter("roomID");
                int n = dao.getPage();
                Vector<Room> listroom
                        = dao.getRoomList1("select * from room  join CateRoom  on Room.RoomcateID = CateRoom.RoomcateID join [Image] on Room.RoomimgaeID = [Image].RoomimgaeID\n"
                                + "                             	where " + cate + " (Roomdesc like'%" + "" + "%' or Roomprice like'%" + "" + "%') \n"
                                + "                               	order by Room.RoomID asc");
//                int page = dao.getPage("select Count(*) from Room");
//                request.setAttribute("devicesss", "devicesss");
                request.setAttribute("listroom", listroom);
//                request.setAttribute("page", page);
//                Room rooom = dao.getRooms(cateroom);
//                Vector<RoomCategory> romcate = roomcate.getRoomCategoryList("select * from CateRoom");
//                request.setAttribute("romcate", romcate);
//                request.setAttribute("rooom", rooom);
//              out.println("<h1>Servlet RoomcategoryController at " + listroom + ""
//              + "va" + page + "</h1>");
//              out.println("<h1>Servlet RoomcategoryController at " + listroom +"</h1>");
                request.getRequestDispatcher("AdListRom.jsp").forward(request, response);
//              request.getRequestDispatcher("editroom.jsp").forward(request, response);
            }
            if (dos.equals("insertRoomCategory")) {
                String Roomcatename = request.getParameter("Roomcatename");
                roomcate.insertRoomCategory(Roomcatename, "");
                Vector<RoomCategory> romcate = roomcate.getRoomCategoryList("select * from CateRoom");
                request.setAttribute("romcate", romcate);
//                out.println("<h1>Servlet RoomcategoryController at " + romcate.lastElement().getRoomcateID()+ "</h1>");
                response.sendRedirect("RoomsController?do=listroom&cateroom=" + romcate.lastElement().getRoomcateID() + "");
            }
            if (dos.equals("deletetRoomCategory")) {
                roomcate.deleteRoomCategory(cateroom);
                response.sendRedirect("RoomsController?do=listroom");
            }
            if (dos.equals("updatetRoomCategory")) {
                String Roomcatename = request.getParameter("Roomcatename");
                roomcate.updateRoomCategory(cateroom, Roomcatename, "");
                response.sendRedirect("RoomsController?do=listroom&cateroom=" + cateroom + "");
            }
            if (dos.equals("insertRoom")) {
                Vector<RoomCategory> romcate = roomcate.getRoomCategoryList("select * from CateRoom");
                request.setAttribute("romcate", romcate);
                request.getRequestDispatcher("InsertRoom.jsp").forward(request, response);
//            out.println("<h1>Servlet RoomcategoryController at " + dos + "</h1>");
            }
            if (dos.equals("updateroom")) {
                String RoomID = request.getParameter("RoomID");
                String Description = request.getParameter("Description");
                String RoomCategory = request.getParameter("RoomCategory");
                String Price = request.getParameter("Price");
                String Note = request.getParameter("Note");
                String Status = request.getParameter("Status");
                String RoomNumber = request.getParameter("RoomNumber");
                String Comment = request.getParameter("Comment");
                String Square = request.getParameter("Square");
                String Rate = request.getParameter("Rate");
                String imgae = request.getParameter("image");
                dao.crudRoom("UPDATE [dbo].[Room]\n"
                        + "   SET [Roomname] = '" + RoomNumber + "'\n"
                        + "      ,[Roomdesc] = '" + Description + "'\n"
                        + "      ,[RoomcateID] = " + RoomCategory + "\n"
                        + "      ,[RoomimgaeID] = " + imgae + " \n"
                        + "      ,[Roomprice] = " + Price + "\n"
                        + "      ,[NumberPerson] = null\n"
                        + "      ,[Square] = " + Square + "\n"
                        + "      ,[Comment] = '" + Comment + "'\n"
                        + "      ,[Rate] = " + Rate + "\n"
                        + "      ,[Note] = '" + Note + "'\n"
                        + "      ,[Status] = " + Status + "\n"
                        + " WHERE RoomID = " + RoomID + "");
                request.setAttribute("update", "update");
                request.getRequestDispatcher("ImageController?do=listImage&RoomID=" + RoomID + "").forward(request, response);
            }
            if (dos.equals("deleteroom")) {
                String RoomID = request.getParameter("RoomID");
                dao.crudRoom("delete from DateOfRoom where RoomID =" + RoomID + "\n"
                        + "				delete from RoomDevice where RoomID =" + RoomID + "\n"
                        + "				delete from Room where RoomID =" + RoomID + "");
                request.setAttribute("delete", "delete");
                request.setAttribute("RoomID", RoomID);
                request.getRequestDispatcher("RoomsController?do=listroom").forward(request, response);
            }
            String value = "";
            String filename = "";
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
            ArrayList<String> room = new ArrayList<String>();
            if (dos.equals("insertrooms")) {
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    HashMap<String, String> fileds = new HashMap<>();
                    if (item.isFormField()) {
                        fileds.put(item.getFieldName(), item.getString());
                        String name = item.getFieldName();
                        value = item.getString();
                        String values = new String(value.getBytes("ISO-8859-1"), "UTF-8");
                        room.add(values);
                    } else {
                        Random rand = new Random();
                        int n = rand.nextInt(99);
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
                            room.add(filename);
                        }
                    }
                }
                String des = room.get(1);
//                String RoomID = room.get(0);
                String RoomNumber = room.get(0);
                String RoomCategory = room.get(2);
                String Price = room.get(3);
                String Note = room.get(4);
                String Status = room.get(5);
                String Square = room.get(6);
                String NumberPerson = room.get(7);
                String image1 = room.get(8);
                String image2 = room.get(9);
                String image3 = room.get(10);
                String image4 = room.get(11);
                if (image1.length() <= 2) {
                    image1 = "";
                }
                if (image2.length() <= 2) {
                    image2 = "";
                }
                if (image3.length() <= 2) {
                    image3 = "";
                }
                if (image4.length() <= 2) {
                    image4 = "";
                }
                daos.crudRoom("insert into [Image] (image1, image2, image3, image4)\n"
                        + "                values ('" + image1 + "','" + image2 + "','" + image3 + "','" + image4 + "');\n"
                        + "                insert into Room(Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status])\n"
                        + "                values ('" + RoomNumber + "',?," + RoomCategory + ",@@identity," + Price + "," + NumberPerson + "," + Square + ",'','',?," + Status + ");", des, Note);
//                out.println("<h1>insert into [Image] (image1, image2, image3, image4)\n"
//                        + "                values ('" + image1 + "','" + image2 + "','" + image3 + "','" + image4 + "');\n"
//                        + "                insert into Room(Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status])\n"
//                        + "                values (" + RoomNumber + ",?," + RoomCategory + ",@@identity," + Price + "," + NumberPerson + "," + Square + ",'',null,?," + Status + ");</h1>");

//                out.println("<h1>UPDATE [dbo].[Image]\n"
//                        + "   SET [image1] = '" + image1 + "'\n"
//                        + "      ,[image2] = '" + image3 + "'\n"
//                        + "      ,[image3] = '" + image2 + "'\n"
//                        + "      ,[image4] = '" + image4 + "'\n"
//                        + " WHERE RoomimgaeID = " + RoomID + "\n"
//                        + "\n"
//                        + " UPDATE [dbo].[Room]\n"
//                        + "   SET [Roomname] ='" + RoomNumber + "'\n"
//                        + "      ,[Roomdesc] = '" + des + "'\n"
//                        + "      ,[RoomcateID] = " + RoomCategory + "\n"
//                        //                        + "      ,[RoomimgaeID] = " + img.getRoomimgaeID() + "\n"
//                        + "      ,[Roomprice] = " + Price + "\n"
//                        + "      ,[NumberPerson] = 1\n"
//                        + "      ,[Square] = " + Square + "\n"
//                        + "      ,[Comment] = '" + Comment + "'\n"
//                        + "      ,[Rate] = " + Rate + "\n"
//                        + "      ,[Note] = '" + Note + "'\n"
//                        + "      ,[Status] = " + Status + "\n"
//                        + " WHERE RoomID = " + RoomID + "</h1>");
                request.setAttribute("update", "update");
                request.getRequestDispatcher("RoomsController?do=listroom").forward(request, response);
            }

        }
    }
//                out.println("<h1>Servlet RoomcategoryController at " + request.getContextPath() + "</h1>");

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
            Logger.getLogger(RoomDeviceController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (Exception ex) {
            Logger.getLogger(RoomDeviceController.class
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

        } catch (FileUploadException ex) {
            Logger.getLogger(RoomDeviceController.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (Exception ex) {
            Logger.getLogger(RoomDeviceController.class
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
