/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.impl.BlogDAOImpl;
import entity.Comment;
import context.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author Thai Quan
 */
@WebServlet(name = "CommentController", urlPatterns = {"/CommentController"})
public class CommentController extends HttpServlet {

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
       BlogDAOImpl dao = new BlogDAOImpl();
        if(request.getCharacterEncoding()!=null){
            request.setCharacterEncoding("UTF-8");
        }
          try (PrintWriter out = response.getWriter()) {
        String content = request.getParameter("content");
        String username = request.getParameter("username");
        String BlogID = request.getParameter("blogid");

        if(content.trim() == "" || username.trim() == ""){
            
        }else{
        Comment cmt = new Comment();
        cmt.setContent(content);
        cmt.setUsername(username);
        
        dao.InsertComment(content, username, BlogID);
        List<Comment> list = dao.DisplayComment(BlogID);
          request.setAttribute("listcomment", list);
              RequestDispatcher rd = request.getRequestDispatcher("Comment.jsp");
             rd.forward(request, response);
       
        }
//         out.println("<h1>Servlet RoomcategoryController at " + BlogID+ "</h1>"); 
    }catch(Exception e){
        e.printStackTrace();
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
