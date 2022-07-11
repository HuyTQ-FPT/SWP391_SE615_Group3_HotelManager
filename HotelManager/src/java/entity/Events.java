/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class Events {
   private int EventID;
   private String EventName;
   private String EventImage;
   private Date EventDate;
   private Date EventDateEnd;
   private String EventCode;
   private int Quantity;

    public Events() {
    }

    public Events(int EventID, String EventName, String EventImage, Date EventDate, Date EventDateEnd, String EventCode, int Quantity) {
        this.EventID = EventID;
        this.EventName = EventName;
        this.EventImage = EventImage;
        this.EventDate = EventDate;
        this.EventDateEnd = EventDateEnd;
        this.EventCode = EventCode;
        this.Quantity = Quantity;
    }

    public int getEventID() {
        return EventID;
    }

    public void setEventID(int EventID) {
        this.EventID = EventID;
    }

    public String getEventName() {
        return EventName;
    }

    public void setEventName(String EventName) {
        this.EventName = EventName;
    }

    public String getEventImage() {
        return EventImage;
    }

    public void setEventImage(String EventImage) {
        this.EventImage = EventImage;
    }

    public Date getEventDate() {
        return EventDate;
    }

    public void setEventDate(Date EventDate) {
        this.EventDate = EventDate;
    }

    public Date getEventDateEnd() {
        return EventDateEnd;
    }

    public void setEventDateEnd(Date EventDateEnd) {
        this.EventDateEnd = EventDateEnd;
    }

    public String getEventCode() {
        return EventCode;
    }

    public void setEventCode(String EventCode) {
        this.EventCode = EventCode;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    @Override
    public String toString() {
        return "Events{" + "EventID=" + EventID + ", EventName=" + EventName + ", EventImage=" + EventImage + ", EventDate=" + EventDate + ", EventDateEnd=" + EventDateEnd + ", EventCode=" + EventCode + ", Quantity=" + Quantity + '}';
    }

   
   
}
