
package entity;

public class Message{
    
    private int MessageID;
    private int AccountID;
    private String MessageTo;
    private String MessageFrom;
    private String Date;
    private String content;
    private String StatusMess;
    private int RoomID;
    
    public Message() {
    }

    public Message(int MessageID, int AccountID, String MessageTo, String MessageFrom, String Date, String content, String StatusMess, int RoomID) {
        this.MessageID = MessageID;
        this.AccountID = AccountID;
        this.MessageTo = MessageTo;
        this.MessageFrom = MessageFrom;
        this.Date = Date;
        this.content = content;
        this.StatusMess = StatusMess;
        this.RoomID = RoomID;
    }
    

    public Message(int MessageID, int AccountID, String MessageTo, String MessageFrom, String Date, String content) {
        this.MessageID = MessageID;
        this.AccountID = AccountID;
        this.MessageTo = MessageTo;
        this.MessageFrom = MessageFrom;
        this.Date = Date;
        this.content = content;
    }
    public Message(int MessageID, int AccountID, String Date, String content, int RoomID) {
        this.MessageID = MessageID;
        this.AccountID = AccountID;
        this.Date = Date;
        this.content = content;
        this.RoomID = RoomID;
    }

    public Message(int MessageID, int AccountID, String MessageTo, String MessageFrom, String Date) {
        this.MessageID = MessageID;
        this.AccountID = AccountID;
        this.MessageTo = MessageTo;
        this.MessageFrom = MessageFrom;
        this.Date = Date;
    }

    public Message(int AccountID, String Date, String content, int RoomID) {
        this.AccountID = AccountID;
        this.Date = Date;
        this.content = content;
        this.RoomID= RoomID;
    }
    public Message(int AccountID, String Date, String content) {
        this.AccountID = AccountID;
        this.Date = Date;
        this.content = content;
    }
    public Message(int AccountID, String content) {
        this.AccountID = AccountID;
        this.content = content;
    }
    public Message(int AccountID) {
        this.AccountID = AccountID;
    }

    public int getMessageID() {
        return MessageID;
    }

    public void setMessageID(int MessageID) {
        this.MessageID = MessageID;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    public String getMessageTo() {
        return MessageTo;
    }

    public void setMessageTo(String MessageTo) {
        this.MessageTo = MessageTo;
    }

    public String getMessageFrom() {
        return MessageFrom;
    }

    public void setMessageFrom(String MessageFrom) {
        this.MessageFrom = MessageFrom;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatusMess() {
        return StatusMess;
    }

    public void setStatusMess(String StatusMess) {
        this.StatusMess = StatusMess;
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int RoomID) {
        this.RoomID = RoomID;
    }

    @Override
    public String toString() {
        return "Message{" + "MessageID=" + MessageID + ", AccountID=" + AccountID + ", MessageTo=" + MessageTo + ", MessageFrom=" + MessageFrom + ", Date=" + Date + '}';
    }

}
