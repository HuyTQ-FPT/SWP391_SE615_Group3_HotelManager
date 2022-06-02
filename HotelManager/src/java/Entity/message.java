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
public class message {
    private int MessageID;
	private int AccountID ;
	private String MessageTo;
	private String MessageFrom ;
	private String Date;

    public message() {
    }

    public message(int MessageID, int AccountID, String MessageTo, String MessageFrom, String Date) {
        this.MessageID = MessageID;
        this.AccountID = AccountID;
        this.MessageTo = MessageTo;
        this.MessageFrom = MessageFrom;
        this.Date = Date;
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

    @Override
    public String toString() {
        return "Message{" + "MessageID=" + MessageID + ", AccountID=" + AccountID + ", MessageTo=" + MessageTo + ", MessageFrom=" + MessageFrom + ", Date=" + Date + '}';
    }
        
}
