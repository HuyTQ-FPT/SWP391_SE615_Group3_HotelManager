
package dao;

import entity.Blog;
import java.util.List;
import java.util.Vector;
import entity.Comment;

public interface BlogDAO {
        public Blog getBlogList(int bID);
   
   
   public void updateBlog(String BlogID, String BlogAuthor, String BlogDescription, String BlogTitleString);
    public void deleteBlog(int bID);
    public Vector<Blog> getBlog(String sql);
    public int getPage();
    public Vector<Blog> getBlogByPage(int n);
     public Vector<Blog> getBlogByPagesortnew(int n);
     public Vector<Blog> getBlogByPagesortold(int n);
   public Vector<Blog> getBlogByPagesearch(int n,String author);
   public void inSertBlog(int AccountID, String BlogAuthor, String BlogDescription, String BlogImage,String BlogTitle);
   public void deleteBlog(String BlogID);
  public List<Comment> DisplayComment(String BlogID);
 public void InsertComment(String content, String username, String BlogID,String ParentID);
  public void crudImage(String sql);
  public Vector<Blog> selectBlog(String BlogID);
     public String getBlogID(String sql);
      public String selectUsername(String AccountID);
      public List<Comment> DisplayCommenttt(String CommentID);
      public void deleteComment(String CommentID);
       public void updateContent(String CommentID, String Content);
}
