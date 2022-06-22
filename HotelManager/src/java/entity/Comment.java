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
    private String content;
    private String username;
private String Date;
private String Blogid;

    public Comment() {
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
        return "Comment{" + "content=" + content + ", username=" + username + ", Date=" + Date + ", Blogid=" + Blogid + '}';
    }
     


    

    
   
    
}
