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
public class DateOfRoom {
   private int RoomID;
   private Date Datein;
   private Date Dateout;
   private int status;

    public DateOfRoom() {
    }

    public DateOfRoom(int RoomID, Date Datein, Date Dateout, int status) {
        this.RoomID = RoomID;
        this.Datein = Datein;
        this.Dateout = Dateout;
        this.status = status;
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int RoomID) {
        this.RoomID = RoomID;
    }

    public Date getDatein() {
        return Datein;
    }

    public void setDatein(Date Datein) {
        this.Datein = Datein;
    }

    public Date getDateout() {
        return Dateout;
    }

    public void setDateout(Date Dateout) {
        this.Dateout = Dateout;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DateOfRoom{" + "RoomID=" + RoomID + ", Datein=" + Datein + ", Dateout=" + Dateout + ", status=" + status + '}';
    }

    
   
}
