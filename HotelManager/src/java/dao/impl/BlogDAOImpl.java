
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
    public int getComment() {
        int n = 0;
        String sql = "select COUNT(*) from Comment";
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
       @Override
    public List<Comment> getCommentByPage(int n) {
        List<Comment> list = new ArrayList<Comment>();
        int begin = 1;
        int end = 4;
        for (int i = 2; i <= n; i++) {
            begin += 4;
            end += 4;
        }
        
        String sql = " SELECT *FROM ( SELECT *, ROW_NUMBER() OVER (ORDER BY CommentID desc) AS RowNum\n" +
"                            FROM Comment\n" +
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
                  String Blogid = rs.getString("Blogid");     
                comment.setContent(content);
                comment.setUsername(username);
                comment.setDate(date);
                comment.setCommentId(CommentID);
                comment.setParentId(ParentID);
                 comment.setBlogid(Blogid);
                list.add(comment);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
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
        
          List<Comment> list = new ArrayList<Comment>();
          list = dao.getCommentByPage(1);
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
