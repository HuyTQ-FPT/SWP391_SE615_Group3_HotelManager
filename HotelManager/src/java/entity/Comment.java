
package entity;

public class Comment {
    private String CommentId;
    private String content;
    private String username;
private String Date;
private String Blogid;

    public Comment() {
    }

    public Comment(String CommentId, String content, String username, String Date, String Blogid) {
        this.CommentId = CommentId;
        this.content = content;
        this.username = username;
        this.Date = Date;
        this.Blogid = Blogid;
    }

    public Comment(String content, String username, String Date, String Blogid) {
        this.content = content;
        this.username = username;
        this.Date = Date;
        this.Blogid = Blogid;
    }

    public String getContent() {
        return content;
    }

    public String getCommentId() {
        return CommentId;
    }

    public void setCommentId(String CommentId) {
        this.CommentId = CommentId;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getBlogid() {
        return Blogid;
    }

    public void setBlogid(String Blogid) {
        this.Blogid = Blogid;
    }

    @Override
    public String toString() {
        return "Comment{" + "CommentId=" + CommentId + ", content=" + content + ", username=" + username + ", Date=" + Date + ", Blogid=" + Blogid + '}';
    }

    
   
     


    

    
   
    
}
