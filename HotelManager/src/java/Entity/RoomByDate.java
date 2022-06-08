/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class RoomByDate {
    int RoomID;
    String Roomname;
    String Roomdesc;
    int RoomcateID;
    String image;
    double Roomprice;
    int NumberPerson;
    float Square;
    String Comment;
    int Rate;
    String Note;
    String cateroom;
    Date DatetIn;
    Date DatetOut;

    public RoomByDate() {
    }

    public RoomByDate(int RoomID, String Roomname, String Roomdesc, int RoomcateID, String image, double Roomprice, int NumberPerson, float Square, String Comment, int Rate, String Note, String cateroom, Date DatetIn, Date DatetOut) {
        this.RoomID = RoomID;
        this.Roomname = Roomname;
        this.Roomdesc = Roomdesc;
        this.RoomcateID = RoomcateID;
        this.image = image;
        this.Roomprice = Roomprice;
        this.NumberPerson = NumberPerson;
        this.Square = Square;
        this.Comment = Comment;
        this.Rate = Rate;
        this.Note = Note;
        this.cateroom = cateroom;
        this.DatetIn = DatetIn;
        this.DatetOut = DatetOut;
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int RoomID) {
        this.RoomID = RoomID;
    }

    public String getRoomname() {
        return Roomname;
    }

    public void setRoomname(String Roomname) {
        this.Roomname = Roomname;
    }

    public String getRoomdesc() {
        return Roomdesc;
    }

    public void setRoomdesc(String Roomdesc) {
        this.Roomdesc = Roomdesc;
    }

    public int getRoomcateID() {
        return RoomcateID;
    }

    public void setRoomcateID(int RoomcateID) {
        this.RoomcateID = RoomcateID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getRoomprice() {
        return Roomprice;
    }

    public void setRoomprice(double Roomprice) {
        this.Roomprice = Roomprice;
    }

    public int getNumberPerson() {
        return NumberPerson;
    }

    public void setNumberPerson(int NumberPerson) {
        this.NumberPerson = NumberPerson;
    }

    public float getSquare() {
        return Square;
    }

    public void setSquare(float Square) {
        this.Square = Square;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int Rate) {
        this.Rate = Rate;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public String getCateroom() {
        return cateroom;
    }

    public void setCateroom(String cateroom) {
        this.cateroom = cateroom;
    }

    public Date getDatetIn() {
        return DatetIn;
    }

    public void setDatetIn(Date DatetIn) {
        this.DatetIn = DatetIn;
    }

    public Date getDatetOut() {
        return DatetOut;
    }

    public void setDatetOut(Date DatetOut) {
        this.DatetOut = DatetOut;
    }

    @Override
    public String toString() {
        return "RoomByDate{" + "RoomID=" + RoomID + ", Roomname=" + Roomname + ", Roomdesc=" + Roomdesc + ", RoomcateID=" + RoomcateID + ", image=" + image + ", Roomprice=" + Roomprice + ", NumberPerson=" + NumberPerson + ", Square=" + Square + ", Comment=" + Comment + ", Rate=" + Rate + ", Note=" + Note + ", cateroom=" + cateroom + ", DatetIn=" + DatetIn + ", DatetOut=" + DatetOut + '}';
    }
    
}
