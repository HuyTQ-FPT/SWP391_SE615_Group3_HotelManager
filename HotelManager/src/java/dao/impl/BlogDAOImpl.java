/*
 * Copyright (C) 2022, FPT University
 * SWP391 - SE1615 - Group3
 * HotelManager
 *
 * Record of change:
 * DATE          Version    Author           DESCRIPTION
 *               1.0                         First Deploy
 * 13/07/2022    1.0        QuanNT            Comment
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The class has methods needed for initialize connection with database and
 * execute queries with Blog and associate tables
 *
 * @author QuanNT
 */
public class BlogDAOImpl extends DBContext implements BlogDAO {
/**
     * Get all Blog from database
     *
     * @return
     * @throws Exception
     */
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
    
    /**
     * get Comment from Blog table using BlogID
     * @param BlogID
     * @return int 
     * @throws Exception
     */
@Override
    public int getComment(String BlogID) {
        int n = 0;
        String sql = "select COUNT(*) from Comment where BlogID = "+BlogID+"";
        Vector<Blog> vector = new Vector<Blog>();
      
        try {
            int totalPage = 0;
            int countPage = 0;
          PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = getData(sql);
            
            while (rs.next()) {
                totalPage = rs.getInt(1);
                countPage = totalPage / 4;
                if (totalPage % 4 != 0) {
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
   /**
     * get count page from Blog table 
     * @return int 
     * @throws Exception
     */ 
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
/**
     * get BlogID from Blog table 
     * @param BlogID
     * @return String
     * @throws Exception
     */
    @Override
    public String getBlogID(String sql) {
        String n1="";
        int n = 0;
      
        try {
          ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);

                n = id;
                n1 = Integer.toString(n);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n1;
    }
    /**
     * get ussername from Account table using AccountID
     * @param AccountID
     * @return String 
     * @throws Exception
     */
@Override
    public String selectUsername(String AccountID) {
        String sql = "select UserName from [User] where AccountID = "+AccountID+"";
        String n1="";
        int n = 0;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
              n1 = rs.getString(1);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n1;
    }
    /**
     * get count page Comment from Blog table using BlogID
     * @param BlogID
     * @param n is int
     * @return List 
     * @throws Exception
     */
       @Override
    public List<Comment> getCommentByPage(int n,String BlogID) {
        List<Comment> list = new ArrayList<Comment>();
        int begin = 1;
        int end = 4;
        for (int i = 2; i <= n; i++) {
            begin += 4;
            end += 4;
        }
        
        String sql = " SELECT *FROM ( SELECT *, ROW_NUMBER() OVER (ORDER BY CommentID desc) AS RowNum\n" +
"                            FROM Comment where BlogID = " + BlogID + " \n" +
"                            ) AS RowNum\n" +
"                              WHERE RowNum BETWEEN "+ begin + " AND " + end;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                Comment comment = new Comment();
                String content = rs.getString("Content");
                String username = rs.getString("username");
                String date = rs.getString("Date");
                String CommentID = rs.getString("CommentId");             
                String ParentID = rs.getString("ParentID");
                              comment.setContent(content);
                comment.setUsername(username);
                comment.setDate(date);
                comment.setCommentId(CommentID);
                comment.setParentId(ParentID);
                comment.setBlogid(BlogID);
                list.add(comment);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    /**
     * get count Page Blog from Blog table 
     * @param n
     * @return Vector 
     * @throws Exception
     */
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
                + "                WHERE RowNum BETWEEN " + begin + " AND " + end;
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
/**
     * get count page Blog from Blog table base on date desc
     * @param n
     * @return Vector 
     * @throws Exception
     */
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
/**
     * delete Blog from Blog table using BlogID
     * @param BlogID
     * @throws Exception
     */
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
    /**
     * get CommentParent from Blog table using CommentID
     * @param CommentID
     * @param ParentID 
     * @throws Exception
     */
  @Override
    public void deleteCommentParent(String CommentID,String ParentID) {
        String query = "delete from Comment where CommentID = ? or ParentID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, CommentID);    
            pre.setString(2, ParentID);    
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * delete Comment from Comment table using CommentID
     * @param CommentID
     * @throws Exception
     */
    @Override
    public void deleteComment(String CommentID) {
        String query = "delete from Comment where CommentID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, CommentID);             
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * get countpage Blog from Blog table base on date asc
     * @param n
     * @return Vector 
     * @throws Exception
     */
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
/**
     * get countpage Blog from Blog table using search name author
     * @param author
     * @param n
     * @return vector 
     * @throws Exception
     */
    @Override
    public Vector<Blog> getBlogByPagesearch(int n, String author) {
        Vector<Blog> vector = new Vector<Blog>();
        int begin = 1;
        int end = 3;
        for (int i = 2; i <= n; i++) {
            begin += 3;
            end += 3;
        }

        String sql = "SELECT *FROM ( SELECT *, ROW_NUMBER() OVER (ORDER BY BlogDate asc) AS RowNum\n"
                + "                               FROM Blog where BlogAuthor like '%" + author + "%'\n"
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
/**
     * get Blog from Blog table using BlogID
     * @param BlogID
     * @return Vector 
     * @throws Exception
     */
    @Override
    public Vector<Blog> selectBlog(String BlogID) {
        Vector<Blog> vector = new Vector<Blog>();

        String sql = "select * from Blog where BlogID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, BlogID);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return vector;
    }
    /**
     * get Blog from Blog table using BlogID
     * @param BlogID
     * @return Blog 
     * @throws Exception
     */
 @Override
    public Blog selectBlog1(String sql) {

        try {
           ResultSet rs = getData(sql);
         while (rs.next()) {
                int AccountID = rs.getInt(2);
                String BlogAuthor = rs.getString(3);
                String BlogDescription = rs.getString(4);
                String Date = rs.getString(6);
                int BlogID = rs.getInt(1);
                String BlogTitle = rs.getString(7);
                String BlogImage = rs.getString(5);
                return new Blog(BlogID, AccountID, BlogAuthor, BlogDescription, BlogImage, Date, BlogTitle);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
     return null;
    }
    /**
     * insert Blog from database using data input
     * @param AccountID
     * @param BlogAuthor  
     * @param BlogDescription
     * @param BlogImage
     * @param BlogTitle
     * @return int 
     * @throws Exception
     */
    @Override
    public void inSertBlog(int AccountID, String BlogAuthor, String BlogDescription, String BlogImage, String BlogTitle) {
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
/**
     * update Blog from Blog table using BlogID
     * @param BlogID
     * @param BlogAuthor
     * @param BlogDescription
     * @param BlogTitleString
     * @throws Exception
     */
    @Override
    public void updateBlog(String BlogID, String BlogAuthor, String BlogDescription, String BlogTitleString) {
        String query = "UPDATE [dbo].[Blog]\n"
                + "   SET [BlogAuthor] = ?\n"
                + "      ,[BlogDescription] = ?\n"
                + "      ,[BlogTitle] = ?\n"
                + " WHERE BlogID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, BlogAuthor);
            pre.setString(2, BlogDescription);
            pre.setString(3, BlogTitleString);
            pre.setString(4, BlogID);

            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * get update Content from Comment table using CommentID
     * @param CommentID
     * @param Content
     * @throws Exception
     */
@Override
    public void updateContent(String CommentID, String Content) {
        String query = "UPDATE [dbo].[Comment] SET [Content] = ? WHERE CommentID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);    
            pre.setString(1, Content);
            pre.setString(2, CommentID);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * get insertComment from Comment table using data input
     * @param Content
     * @param Username
     * @param BlogID
     * @param ParentID
     * @throws Exception
     */
    @Override
    public void InsertComment(String content, String username, String BlogID,String ParentID) {
        String sql = "INSERT INTO [dbo].[Comment]([Content],[username],[Date],[ParentID],[BlogID])VALUES(?,?,GETDATE(),?,?)";
        try {
//            ResultSet rs = null;
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, content);
            pre.setString(2, username);
            pre.setString(4, BlogID);
            pre.setString(3, ParentID);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * get AllComment from Comment table using BlogID
     * @param BlogID
     * @return List 
     * @throws Exception
     */
    @Override
    public List<Comment> DisplayAllComment(String BlogID) {
        List<Comment> list = new ArrayList<Comment>();
            String sql = "select * from Comment where BlogID = " + BlogID ;
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                Comment comment = new Comment();
                String content = rs.getString("Content");
                String username = rs.getString("username");
                String date = rs.getString("Date");
                String CommentID = rs.getString("CommentId");
                 BlogID = rs.getString("BlogID");
                String ParentID = rs.getString("ParentID");
                comment.setBlogid(BlogID);
                comment.setContent(content);
                comment.setUsername(username);
                comment.setDate(date);
                comment.setCommentId(CommentID);
                comment.setParentId(ParentID);
                list.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    /**
     * get Comment BLog from Blog table using BlogID
     * @param BlogID
     * @return List 
     * @throws Exception
     */
 @Override
    public List<Comment> DisplayCommentBlog(String BlogID) {
        List<Comment> list = new ArrayList<Comment>();
            String sql = "select * from Comment where BlogID = " + BlogID + " and ParentID = 0";
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                Comment comment = new Comment();
                String content = rs.getString("Content");
                String username = rs.getString("username");
                String date = rs.getString("Date");
                String CommentID = rs.getString("CommentId");
                 BlogID = rs.getString("BlogID");
                String ParentID = rs.getString("CommentId");
                comment.setBlogid(BlogID);
                comment.setContent(content);
                comment.setUsername(username);
                comment.setDate(date);
                comment.setCommentId(CommentID);
                comment.setParentId(ParentID);
                list.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    /**
     * get Comment from Blog table using BlogID
     * @param BlogID
     * @return List 
     * @throws Exception
     */
    @Override
    public List<Comment> DisplayComment(String BlogID) {
        List<Comment> list = new ArrayList<Comment>();
            String sql = "select * from Comment where BlogID = " + BlogID + " and ParentID = 0";
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                Comment comment = new Comment();
                String content = rs.getString("Content");
                String username = rs.getString("username");
                String date = rs.getString("Date");
                String CommentID = rs.getString("CommentId");
                 BlogID = rs.getString("BlogID");
                String ParentID = rs.getString("CommentId");
                comment.setBlogid(BlogID);
                comment.setContent(content);
                comment.setUsername(username);
                comment.setDate(date);
                comment.setCommentId(CommentID);
                comment.setParentId(ParentID);
                list.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    /**
     * get CommentParent from Blog table using BlogID
     * @param BlogID
     * @return List 
     * @throws Exception
     */
 @Override
    public List<Comment> DisplayCommenttt(String CommentID) {
        List<Comment> list = new ArrayList<Comment>();
        String sql = "select * from Comment where ParentID = " + CommentID + "";
        try {
            PreparedStatement ptmt = conn.prepareStatement(sql);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                Comment comment = new Comment();
                String content = rs.getString("Content");
                String username = rs.getString("username");
                  String blogid = rs.getString("blogid");
                String date = rs.getString("Date");
                CommentID = rs.getString("CommentId");
                String ParentID = rs.getString("ParentID");
                comment.setBlogid(blogid);
                comment.setContent(content);
                comment.setUsername(username);
                comment.setDate(date);
                comment.setCommentId(CommentID);
                comment.setParentId(ParentID);
                list.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public void crudImage(String sql) {
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.executeUpdate();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BlogDAOImpl dao = new BlogDAOImpl();
//        int n = dao.getComment("8");
          List<Comment> list = new ArrayList<Comment>();
          list = dao.getCommentByPage(2,"8");
        System.out.println(list);

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
