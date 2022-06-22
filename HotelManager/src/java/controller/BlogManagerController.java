/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.BlogDAOImpl;
import entity.Blog;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thai Quan
 */
@MultipartConfig
@WebServlet(name = "BlogManagerController", urlPatterns = {"/BlogManagerController"})
public class BlogManagerController extends HttpServlet {

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
            throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            BlogDAOImpl dao = new BlogDAOImpl();
            String dos = request.getParameter("do");
            if (dos.equals("insertblog")) {
                request.setCharacterEncoding("UTF-8");
                String title = request.getParameter("title").trim();
                int accountID = 9;
                String description = request.getParameter("description").trim();
                String author = request.getParameter("author").trim();
                String image = request.getParameter("image");
                
                dao.inSertBlog(accountID, author, description, image, title);
                response.sendRedirect("BlogManagerController?do=editblog");
            
            }
            if (dos.equals("editblog")) {
                Vector<Blog> b = null;
                int n = dao.getPage();
                request.setAttribute("n", n);
//              request.setAttribute("vector4", vector4);
                String page = request.getParameter("page");
                if (page == null) {
                    b = dao.getBlogByPage(1);
                } else {
                    b = dao.getBlogByPage(Integer.parseInt(page));
                }
                request.setAttribute("b", b);
                request.getRequestDispatcher("editblog.jsp").forward(request, response);
            }
            if (dos.equals("deleteblog")) {
                int n = dao.getPage();
                String id = request.getParameter("blogid");
                dao.deleteBlog(id);
                response.sendRedirect("BlogManagerController?do=editblog&page=" + n + "");
            }
            if (dos.equals("updateblog")) {
                String author = request.getParameter("blogauthor");
                String blogDescription = request.getParameter("blogDescription");
                String blogImage = request.getParameter("blogImage");
                String blogTitleString = request.getParameter("blogTitleString");
                String blogDate = request.getParameter("date");
                String BlogID = request.getParameter("BlogID");
                request.setAttribute("author", author);
                request.setAttribute("blogDescription", blogDescription);
                request.setAttribute("blogImage", blogImage);
                request.setAttribute("blogTitleString", blogTitleString);
                request.setAttribute("BlogID", BlogID);
                request.setAttribute("blogDate", blogDate);
                request.getRequestDispatcher("updateblog.jsp").forward(request, response);
            }
            if (dos.equals("updatebloggg")) {
                String author = request.getParameter("author");
                String BlogID = request.getParameter("BlogID");
                String blogDescription = request.getParameter("description");
                String blogImage = request.getParameter("image");
                String blogTitleString = request.getParameter("title");
                String blogDate = request.getParameter("date");
               dao.updateBlog(BlogID, author, blogDescription, blogImage, blogDate, blogTitleString);
                
                response.sendRedirect("BlogManagerController?do=editblog");
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        processRequest(request, response);
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
        processRequest(request, response);
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
