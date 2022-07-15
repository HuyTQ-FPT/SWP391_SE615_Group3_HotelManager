/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.DevicesDAOImpl;
import dao.impl.RoomDAOImpl;
import entity.Device;
import entity.Room;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Admin
 */
@WebServlet(name = "DeviceController", urlPatterns = {"/DeviceController"})
public class DeviceController extends HttpServlet {

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
            String dos = request.getParameter("do");
            DevicesDAOImpl devicedao = new DevicesDAOImpl();
            RoomDAOImpl roomdao = new RoomDAOImpl();
            if (dos.equals("") || dos.equals(null)) {
                out.println("<h1>Lỗi Trang.</h1>");
            }
            if (dos.equals("listdevicebyroom")) {
                String Roomid = request.getParameter("RoomID");
                String page = request.getParameter("page");
                int n;
                if (page == null) {
                    n = 1;
                } else {
                    n = Integer.parseInt(page);
                }
                Room getroom = roomdao.getRoom(Roomid);
                Vector<Device> listdevice = devicedao.getDevicebyroom(Roomid, n);
                request.setAttribute("listdevice", listdevice);
                request.setAttribute("room", getroom);
                request.getRequestDispatcher("listdeviceroom.jsp").forward(request, response);
//                out.println("<h1>Servlet DeviceController at " + listdevice + "</h1>");
            }
            if (dos.equals("RoomByDevice")) {
                String DeviceId = request.getParameter("DeviceId");
                Vector<Room> listroom = roomdao.getRoomList1("select * from room  join CateRoom  on Room.RoomcateID = CateRoom.RoomcateID join [Image] on Room.RoomimgaeID = [Image].RoomimgaeID join RoomDevice on   Room.RoomID = RoomDevice.RoomID\n"
                        + "              	where RoomDevice.DeviceID =" + DeviceId + "");
                request.setAttribute("listroom", listroom);
//                out.println("<h1>Servlet RoomcategoryController at " + cate + "</h1>");
                request.getRequestDispatcher("AdListRom.jsp").forward(request, response);
                out.println("<h1>Servlet DeviceController at " + DeviceId + " </h1>");
            }
            if (dos.equals("listalldevice")) {
                Vector<Device> listdevices = devicedao.getAllDevice("select * from Device x left join (select DeviceID,Count(*) as quantity from RoomDevice Group by DeviceID) y on x.DeviceID = y.DeviceID");
                request.setAttribute("listdevices", listdevices);
                request.getRequestDispatcher("ListDevices.jsp").forward(request, response);
//                out.println("<h1>Servlet DeviceController at " + listdevices + "</h1>");
            }
            if (dos.equals("InsertDevice")) {
                String DeviceName = request.getParameter("DeviceName");
                String Price = request.getParameter("Price");
                devicedao.insertDevice(DeviceName.replaceAll("\\s\\s+", " ").trim(), Price);
//                out.println("<h1>Servlet DeviceController at " + Price + "</h1>");
                request.getRequestDispatcher("DeviceController?do=listalldevice").forward(request, response);
            }
            if (dos.equals("DeleteDevice")) {
                String DeviceId = request.getParameter("DeviceId");
                devicedao.deleteDevice(DeviceId);
                response.sendRedirect("DeviceController?do=listalldevice");
//                out.println("<h1>Servlet DeviceController at " + DeviceId + "</h1>");
            }
            if (dos.equals("UpdateDevice")) {
                String DeviceID = request.getParameter("DeviceId");
                Device device = devicedao.Getdevices("select * from Device where DeviceID = " + DeviceID + "");
                request.setAttribute("device", device);
//                 out.println("<h1>Servlet DeviceController at " +device+ "</h1>");
                request.getRequestDispatcher("updatedevice.jsp").forward(request, response);
            }
            if (dos.equals("updatedevice")) {
                String DeviceID = request.getParameter("DeviceID");
                String DeviceName = request.getParameter("DeviceName");
                String Price = request.getParameter("Price");
                devicedao.updateDeviceQuan(DeviceName.replaceAll("\\s\\s+", " ").trim(), DeviceID, Price);
                Device device = devicedao.Getdevices("select * from Device where DeviceID = " + DeviceID + "");
                request.setAttribute("device", device);
//                out.println("<h1>Servlet DeviceController at " +DeviceID+ "</h1>");
//                request.getRequestDispatcher("updatedevice.jsp").forward(request, response);
                response.sendRedirect("DeviceController?do=listalldevice");
            }
            if (dos.equals("InsertDeviceRoom")) {
                String Roomid = request.getParameter("RoomID");
                Vector<Device> listdevices = devicedao.getAllDevicetoAdd("Select * from Device ");
                Room getroom = roomdao.getRoom(Roomid);
                request.setAttribute("listdevices", listdevices);
                request.setAttribute("Roomid", Roomid);
                request.setAttribute("getroom", getroom);
//                                out.println("<h1>Servlet DeviceController at "+listdevices+"  </h1>");
                request.getRequestDispatcher("InsertDeviceRoom.jsp").forward(request, response);
            }
            if (dos.equals("DeleteDeviceRoom")) {
                String DeviceID = request.getParameter("DeviceID");
                String Roomid = request.getParameter("RoomID");
                devicedao.deletetDevice(Roomid, DeviceID);
                request.getRequestDispatcher("DeviceController?do=listdevicebyroom&RoomID=" + Roomid + "").forward(request, response);

            }
            if (dos.equals("UpdateDeviceByRoom")) {
                String DeviceID = request.getParameter("DeviceID");
                String Roomid = request.getParameter("RoomID");
                Room getroom = roomdao.getRoom(Roomid);
                Device device = devicedao.Getdevice("select * from Roomdevice join Device "
                        + "on RoomDevice.DeviceID = Device.DeviceID \n"
                        + "where Roomdevice.DeviceID = " + DeviceID + " and Roomdevice.RoomID =" + Roomid + "");
                request.setAttribute("device", device);
                request.setAttribute("getroom", getroom);
//                out.println("<h1>Servlet DeviceController at " +device.getStatus()+ "</h1>");
                request.getRequestDispatcher("updatedeviceroom.jsp").forward(request, response);
            }
            String value = "";
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
            String filename = "";
            if (dos.equals("InsertDeviceRooms")) {
                ArrayList<String> device = new ArrayList<String>();
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    HashMap<String, String> fileds = new HashMap<>();
                    if (item.isFormField()) {
                        fileds.put(item.getFieldName(), item.getString());
                        String name = item.getFieldName();
                        value = item.getString();
                        String values = new String(value.getBytes("ISO-8859-1"), "UTF-8");
                        device.add(values);
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
                            String storePath = servletContext.getRealPath("/images/anhphong");
                            File uploadFile = new File(storePath + "/" + path.getFileName());
                            item.write(uploadFile);
                            device.add(filename);

                        }
                    }
                }
                String RoomID = device.get(0);
                String DeviceID = device.get(1);
                String status = device.get(2);
                String quantity = device.get(3);
                String note = device.get(4);
                String image = device.get(5);
                devicedao.insertDeviceRoom(RoomID, DeviceID, quantity, status, note, image);
                request.getRequestDispatcher("DeviceController?do=listdevicebyroom&RoomID=" + RoomID + "").forward(request, response);
            }

            if (dos.equals("updatedeviceroom")) {
                ArrayList<String> device = new ArrayList<String>();
                while (iter.hasNext()) {
                    FileItem item = iter.next();
                    HashMap<String, String> fileds = new HashMap<>();
                    if (item.isFormField()) {
                        fileds.put(item.getFieldName(), item.getString());
                        String name = item.getFieldName();
                        value = item.getString();
                        String values = new String(value.getBytes("ISO-8859-1"), "UTF-8");
                        device.add(values);
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
                            String storePath = servletContext.getRealPath("/images/anhphong");
                            File uploadFile = new File(storePath + "/" + path.getFileName());
                            item.write(uploadFile);
                            device.add(filename);
                        }
                    }
                }
                String DeviceID = device.get(0);
                String RoomID = device.get(1);
                String status = device.get(2);
                String quantity = device.get(3);
                String note = device.get(4);
                String image = device.get(5);
                Device devices = devicedao.Getdevice("select * from Roomdevice join Device "
                        + "on RoomDevice.DeviceID = Device.DeviceID \n"
                        + "where Roomdevice.DeviceID = " + DeviceID + " and Roomdevice.RoomID =" + RoomID + "");
                if (image.length() <= 2) {
                    image = devices.getImagedevice();
                }
                devicedao.updateDeviceinfor(RoomID, quantity, status, note, DeviceID, image);
                request.getRequestDispatcher("DeviceController?do=listdevicebyroom&RoomID=" + RoomID + "").forward(request, response);
//            out.println("<h1>RoomID " + RoomID + " DeviceID" + DeviceID + "Status" + status + " quan" + quantity + " note " + note + "</h1>");
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
            Logger.getLogger(DeviceController.class
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
            Logger.getLogger(DeviceController.class
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
