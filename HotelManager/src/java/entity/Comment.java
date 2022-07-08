/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Thai Quan
 */
public class Comment {
    private String CommentId;
    private String content;
    private String username;
private String Date;
private String Blogid;
private String ParentId;

    public Comment() {
    }

    public Comment(String CommentId, String content, String username, String Date, String Blogid, String ParentId) {
        this.CommentId = CommentId;
        this.content = content;
        this.username = username;
        this.Date = Date;
        this.Blogid = Blogid;
        this.ParentId = ParentId;
    }

    public String getCommentId() {
        return CommentId;
    }

    public void setCommentId(String CommentId) {
        this.CommentId = CommentId;
    }

    public String getContent() {
        return content;
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

    public String getParentId() {
        return ParentId;
    }

    public void setParentId(String ParentId) {
        this.ParentId = ParentId;
    }

    @Override
    public String toString() {
        return "Comment{" + "CommentId=" + CommentId + ", content=" + content + ", username=" + username + ", Date=" + Date + ", Blogid=" + Blogid + ", ParentId=" + ParentId + '}';
    }

   

    
   
     


    

    
   
    
}
