
package controller;

import dao.impl.BlogDAOImpl;
import entity.Blog;
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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@MultipartConfig
@WebServlet(name = "BlogManagerController", urlPatterns = {"/BlogManagerController"})
public class BlogManagerController extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            BlogDAOImpl dao = new BlogDAOImpl();
            String dos = request.getParameter("do");
           /**
             * Service insertblog: get insert blog 
             * addblog.jsp
             */
            if (dos.equals("insertblog")) {          
                String title = request.getParameter("title").trim();
                int accountID = 9;
                String description = request.getParameter("description").trim();
                String author = request.getParameter("author").trim();
                String image = request.getParameter("image");
                if(description.trim().equals("") || author.trim().equals("") ||  title.trim().equals("")){
                        response.sendRedirect("addblog.jsp");
                } else{
                    // insert blog
                dao.inSertBlog(accountID, author, description, image, title);
                String blogid = dao.getBlogID(" SELECT MAX(BlogID)\n" +
                        "FROM [SWPgroup3].[dbo].[Blog]");
              //  out.println("<h1>Servlet RoomcategoryController at " + author+ "</h1>"); 
               request.getRequestDispatcher("BlogManagerController?do=updateblog&blogid=" + blogid + " ").forward(request, response);
            }
            }
             /**
             * Service editblog: edit information blog 
             * addblog.jsp
             */
            if (dos.equals("editblog")) {
                Vector<Blog> b = null;
                int n = dao.getPage();
                request.setAttribute("n", n);         
                String page = request.getParameter("page");
                if (page == null) {
                    // get blog by page
                    b = dao.getBlogByPage(1);
                } else {
                     // get blog by page
                    b = dao.getBlogByPage(Integer.parseInt(page));
                }
                request.setAttribute("b", b);
              request.setAttribute("page",page);
                request.getRequestDispatcher("editblog.jsp").forward(request, response);
            }
              /**
             * Service deleteblog: delete information blog 
             * editblog.jsp
             */
            if (dos.equals("deleteblog")) {
                int n = dao.getPage();
                String page = request.getParameter("page");
                String id = request.getParameter("blogid");
                //delete blog
                dao.deleteBlog(id);
                response.sendRedirect("BlogManagerController?do=editblog&page=" + page + "");
            }
             /**
             * Service updateblog: take information before update information blog 
             * updateblog.jsp
             */
            if (dos.equals("updateblog")) {
                 Vector<Blog> b = null;              
                request.setAttribute("b", b);       
                String blogid = request.getParameter("blogid");
                // show information blogdetail
                b= dao.getBlog("select * from Blog where BlogID ="+blogid+"");
                request.setAttribute("b", b);

                request.getRequestDispatcher("updateblog.jsp").forward(request, response);
            }
             /**
             * Service updateblog: update information blog 
             * updateblog.jsp
             */
            if (dos.equals("updatebloggg")) {
                String author = request.getParameter("author").trim();
                String BlogID = request.getParameter("BlogID").trim();
                String blogDescription = request.getParameter("description").trim();
                String blogTitleString = request.getParameter("title").trim();
//              if(blogDescription.trim() == ""){
//                    out.println("<h1>Servlet RoomcategoryController at "+ author+"</h1>"); 
//                }else{
               dao.updateBlog(BlogID, author, blogDescription, blogTitleString);
                response.sendRedirect("BlogManagerController?do=editblog");
            
            }
             /**
             * Service EditComment: Show notification
             * BlogDetail.jsp
             */
               if (dos.equals("EditComment")) {
                   request.setAttribute("Ok", "Ok");
                 request.getRequestDispatcher("BlogDetail.jsp").forward(request, response);
               }        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
