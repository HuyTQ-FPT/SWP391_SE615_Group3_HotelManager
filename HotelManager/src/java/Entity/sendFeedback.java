/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Admin
 */
public class sendFeedback {
   
    private int mId;
    private String title;
    private String email;
    private String content;
    private String isRead;

    public sendFeedback() {
    }

    public sendFeedback(int mId, String title, String email, String content, String isRead) {
        this.mId = mId;
        this.title = title;
        this.email = email;
        this.content = content;
        this.isRead = isRead;
    }

    public sendFeedback(String title, String email, String content) {
        this.title = title;
        this.email = email;
        this.content = content;
    }
    

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    @Override
    public String toString() {
        return "sendFeedback{" + "mId=" + mId + ", title=" + title + ", email=" + email + ", content=" + content + ", isRead=" + isRead + '}';
    }

    
      

}

