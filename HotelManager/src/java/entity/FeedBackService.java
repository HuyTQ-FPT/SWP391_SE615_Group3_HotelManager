/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author NTD
 */
public class FeedBackService {

    int CommentID;
    int ServiceId;
    int AccountId;
    Date date;
    String Comment;
    int Status;
    String Note;

    public FeedBackService(int CommentID, int ServiceId, int AccountId, Date date, String Comment, int Status, String Note) {
        this.CommentID = CommentID;
        this.ServiceId = ServiceId;
        this.AccountId = AccountId;
        this.date = date;
        this.Comment = Comment;
        this.Status = Status;
        this.Note = Note;
    }

    public FeedBackService() {
    }

    public int getCommentID() {
        return CommentID;
    }

    public void setCommentID(int CommentID) {
        this.CommentID = CommentID;
    }

    public int getServiceId() {
        return ServiceId;
    }

    public void setServiceId(int ServiceId) {
        this.ServiceId = ServiceId;
    }

    public int getAccountId() {
        return AccountId;
    }

    public void setAccountId(int AccountId) {
        this.AccountId = AccountId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    @Override
    public String toString() {
        return "FeedBackService{" + "CommentID=" + CommentID + ", ServiceId=" + ServiceId + ", AccountId=" + AccountId + ", date=" + date + ", Comment=" + Comment + ", Status=" + Status + ", Note=" + Note + '}';
    }

}
