/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Dao.impl.BlogDAOImpl;
import Entity.Blog;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "BlogController", urlPatterns = {"/BlogController"})
public class BlogController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            BlogDAOImpl dao = new BlogDAOImpl();          
             String dos = request.getParameter("do");
             if(dos == null){
//             Vector<Blog> b = dao.getBlog("select * from Blog ");
            int a =1;
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
                 request.setAttribute("a", a);
                request.setAttribute("b", b);
            request.getRequestDispatcher("Blog.jsp").forward(request, response);  
             }
             if(dos.equals("getBlog")){
//                  Vector<Blog> b = dao.getBlog("select * from Blog ");          
             Vector<Blog> b = null;
             int n = dao.getPage();
             int a =1;
              request.setAttribute("n", n);
//              request.setAttribute("vector4", vector4);
                String page = request.getParameter("page");
                if (page == null) {
                    b = dao.getBlogByPage(1);
                } else {
                    b = dao.getBlogByPage(Integer.parseInt(page));
                }
                request.setAttribute("a", a);
                 request.setAttribute("b", b);
            request.getRequestDispatcher("Blog.jsp").forward(request, response);              
             };
             if(dos.equals("detailBlog")){       
                String BlogID = request.getParameter("blogID");
                Vector<Blog> c = dao.getBlog("select * from Blog where [BlogID]='" + BlogID + "'");
                request.setAttribute("c", c);
                Vector<Blog> b = dao.getBlog("select * from Blog except select * from Blog where [BlogID]='" + BlogID + "'");
                request.setAttribute("b", b);
                request.getRequestDispatcher("BlogDetail.jsp").forward(request, response);      
             }
              if(dos.equals("sortnew")){       
                    Vector<Blog> b = null;
                    int n = dao.getPage();
                      request.setAttribute("n", n);
//              request.setAttribute("vector4", vector4);
                String page = request.getParameter("page");
                int a = 2;
                if (page == null) {
                    b = dao.getBlogByPagesortnew(1);
                } else {
                    b = dao.getBlogByPagesortnew(Integer.parseInt(page));
                }
                 request.setAttribute("b", b);
                 request.setAttribute("a", a);
            request.getRequestDispatcher("Blog.jsp").forward(request, response);       
              }
              if(dos.equals("sortold")){
                   Vector<Blog> b = null;
                    int n = dao.getPage();
                      request.setAttribute("n", n);
//              request.setAttribute("vector4", vector4);
                String page = request.getParameter("page");
                int a = 3;
                if (page == null) {
                    b = dao.getBlogByPagesortold(1);
                } else {
                    b = dao.getBlogByPagesortold(Integer.parseInt(page));
                }
                 request.setAttribute("b", b);
                 request.setAttribute("a", a);
            request.getRequestDispatcher("Blog.jsp").forward(request, response);       
              }
              if(dos.equals("search")){
                  String author = request.getParameter("search");
                  Vector<Blog> vector = dao.getBlog("select * from Blog where BlogAuthor like '%"+author+"%'");
                  request.setAttribute("b", vector);
                   request.getRequestDispatcher("Blog.jsp").forward(request, response);
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
