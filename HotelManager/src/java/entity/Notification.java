
package entity;

/**
 *
 * Tran Quang Huy
 */
public class Notification {
    private int NID;
    private String Title;
    private String Name;
    private String Focus;
    private String content;
    private String Date;
    private String Status;
    
    public Notification() {
    }

    public Notification(int NID, String Title, String Name, String Focus, String content, String Date) {
        this.NID = NID;
        this.Title = Title;
        this.Name = Name;
        this.Focus = Focus;
        this.content = content;
        this.Date = Date;
    }
    public Notification(String Title, String Name, String Focus, String content, String Date) {
        this.Title = Title;
        this.Name = Name;
        this.Focus = Focus;
        this.content = content;
        this.Date = Date;
    }
    public Notification(String Title, String Name, String content, String Date) {
        this.Title = Title;
        this.Name = Name;
        this.content = content;
        this.Date = Date;
    }

    public int getNID() {
        return NID;
    }

    public void setNID(int NID) {
        this.NID = NID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getFocus() {
        return Focus;
    }

    public void setFocus(String Focus) {
        this.Focus = Focus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "Notification{" + "NID=" + NID + ", Title=" + Title + ", Name=" + Name + ", Focus=" + Focus + ", content=" + content + ", Date=" + Date + '}';
    }
    
}
