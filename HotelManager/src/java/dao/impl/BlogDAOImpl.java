/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.BlogDAO;
import entity.Blog;
import entity.Room;
import entity.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import context.DBContext;
import entity.Comment;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class BlogDAOImpl extends DBContext implements BlogDAO {

   @Override
    public Vector<Blog> getBlog(String sql) {
        Vector<Blog> vector = new Vector<Blog>();
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                int AccountID = rs.getInt(2);
                String BlogAuthor = rs.getString(3);
                String BlogDescription = rs.getString(4);
                String BlogImage = rs.getString(5);
                String BlogDate = rs.getString(6);
                String BlogTitleString = rs.getString(7);
                Blog im = new Blog(id, AccountID, BlogAuthor, BlogDescription, BlogImage, BlogDate, BlogTitleString);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    @Override
    public int getPage() {
        int n = 0;
        String sql = "select COUNT(*) from Blog";
        Vector<Blog> vector = new Vector<Blog>();
        try {
            int totalPage = 0;
            int countPage = 0;
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = getData(sql);
            while (rs.next()) {
                totalPage = rs.getInt(1);
                countPage = totalPage / 3;
                if (totalPage % 3 != 0) {
                    countPage++;
                }
                return countPage;
            }
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    @Override
    public Vector<Blog> getBlogByPage(int n) {
        Vector<Blog> vector = new Vector<Blog>();
        int begin = 1;
        int end = 3;
        for (int i = 2; i <= n; i++) {
            begin += 3;
            end += 3;
        }
        String sql = "SELECT *FROM ( SELECT *, ROW_NUMBER() OVER (ORDER BY BlogDate desc) AS RowNum\n"
                + "               FROM Blog\n"
                + "               ) AS RowNum\n"
                + "                WHERE RowNum BETWEEN " + begin + " AND " + end ;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                int AccountID = rs.getInt(2);
                String BlogAuthor = rs.getString(3);
                String BlogDescription = rs.getString(4);
                String BlogImage = rs.getString(5);
                String BlogDate = rs.getString(6);
                String BlogTitleString = rs.getString(7);
                Blog im = new Blog(id, AccountID, BlogAuthor, BlogDescription, BlogImage, BlogDate, BlogTitleString);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    @Override
    public Vector<Blog> getBlogByPagesortnew(int n) {
        Vector<Blog> vector = new Vector<Blog>();
        int begin = 1;
        int end = 3;
        for (int i = 2; i <= n; i++) {
            begin += 3;
            end += 3;
        }
        String sql = "SELECT *FROM ( SELECT *, ROW_NUMBER() OVER (ORDER BY BlogDate desc) AS RowNum\n"
                + "                               FROM Blog\n"
                + "                              ) AS RowNum\n"
                + "                              WHERE RowNum BETWEEN " + begin + " AND " + end;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                int AccountID = rs.getInt(2);
                String BlogAuthor = rs.getString(3);
                String BlogDescription = rs.getString(4);
                String BlogImage = rs.getString(5);
                String BlogDate = rs.getString(6);
                String BlogTitleString = rs.getString(7);
                Blog im = new Blog(id, AccountID, BlogAuthor, BlogDescription, BlogImage, BlogDate, BlogTitleString);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    @Override
    public void deleteBlog(String BlogID) {
        String query = "DELETE FROM [dbo].[Blog]\n"
                + "      WHERE BlogID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, BlogID);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Vector<Blog> getBlogByPagesortold(int n) {
        Vector<Blog> vector = new Vector<Blog>();
        int begin = 1;
        int end = 3;
        for (int i = 2; i <= n; i++) {
            begin += 3;
            end += 3;
        }
        String sql = "SELECT *FROM ( SELECT *, ROW_NUMBER() OVER (ORDER BY BlogDate asc) AS RowNum\n"
                + "                               FROM Blog\n"
                + "                              ) AS RowNum\n"
                + "                              WHERE RowNum BETWEEN " + begin + " AND " + end;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                int AccountID = rs.getInt(2);
                String BlogAuthor = rs.getString(3);
                String BlogDescription = rs.getString(4);
                String BlogImage = rs.getString(5);
                String BlogDate = rs.getString(6);
                String BlogTitleString = rs.getString(7);
                Blog im = new Blog(id, AccountID, BlogAuthor, BlogDescription, BlogImage, BlogDate, BlogTitleString);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
     @Override
    public Vector<Blog> getBlogByPagesearch(int n,String author){
         Vector<Blog> vector = new Vector<Blog>();
        int begin = 1;
        int end = 3;
        for (int i = 2; i <= n; i++) {
            begin += 3;
            end += 3;
        }
      
        String sql = "SELECT *FROM ( SELECT *, ROW_NUMBER() OVER (ORDER BY BlogDate asc) AS RowNum\n"
                + "                               FROM Blog where BlogAuthor like '%"+author+"%'\n"
                + "                              ) AS RowNum\n"
                + "                              WHERE RowNum BETWEEN " + begin + " AND " + end;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                int AccountID = rs.getInt(2);
                String BlogAuthor = rs.getString(3);
                String BlogDescription = rs.getString(4);
                String BlogImage = rs.getString(5);
                String BlogDate = rs.getString(6);
                String BlogTitleString = rs.getString(7);
                Blog im = new Blog(id, AccountID, BlogAuthor, BlogDescription, BlogImage, BlogDate, BlogTitleString);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    @Override
    public void inSertBlog(int AccountID, String BlogAuthor, String BlogDescription, String BlogImage,String BlogTitle) {
        String query = "INSERT INTO [dbo].[Blog]\n"
                + "           ([AccountID]\n"
                + "           ,[BlogAuthor]\n"
                + "           ,[BlogDescription]\n"
                + "           ,[BlogImage]\n"
                + "           ,[BlogDate]\n"
                + "           ,[BlogTitle])\n"
                + "     VALUES \n"
                + "           (?,?,?,?,GETDATE(),?)";
        try {
//            ResultSet rs = null;
             PreparedStatement pre = conn.prepareStatement(query);
            pre.setInt(1, AccountID);
            pre.setString(2, BlogAuthor);
            pre.setString(3, BlogDescription);
            pre.setString(4, BlogImage);        
            pre.setString(5, BlogTitle);
           pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    @Override
    public void updateBlog(String BlogID,String BlogAuthor, String BlogDescription, String BlogImage, String BlogDate, String BlogTitleString) {
        String query = "UPDATE [dbo].[Blog]\n"
                + "   SET [BlogAuthor] = ?\n"
                + "      ,[BlogDescription] = ?\n"
                + "      ,[BlogImage] = ?\n"
                + "      ,[BlogDate] = ?\n"
                + "      ,[BlogTitle] = ?\n"
                + " WHERE BlogID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, BlogAuthor);
            pre.setString(2, BlogDescription);
            pre.setString(3, BlogImage);
            pre.setString(4, BlogDate);
            pre.setString(5, BlogTitleString);
            pre.setString(6, BlogID);
           
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
      public void InsertComment(String content,String username,String BlogID) {
         String sql = "INSERT INTO [dbo].[Comment]([Content],[username],[Date],[BlogID])VALUES(?,?,GETDATE(),?)";
        try {
//            ResultSet rs = null;
             PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, content);
            pre.setString(2, username);
            pre.setString(3, BlogID);
           pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      @Override
    public List<Comment> DisplayComment(String BlogID) {
        List<Comment> list = new ArrayList<Comment>();
        String sql = "select * from Comment where BlogID = "+BlogID+"";
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                Comment comment = new Comment();
                String content = rs.getString("Content");  
                String username = rs.getString("username");
                String date = rs.getString("Date");
                comment.setContent(content);
                comment. setUsername(username);
               comment. setDate(date);
                list.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        BlogDAOImpl dao = new BlogDAOImpl();
//        List<Comment> list = dao.DisplayComment("1");
        dao.InsertComment("The nice content", "Thai Quan", "3");
        
        
        
      

    }

   
    @Override
    public void deleteBlog(int bID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Blog getBlogList(int bID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
