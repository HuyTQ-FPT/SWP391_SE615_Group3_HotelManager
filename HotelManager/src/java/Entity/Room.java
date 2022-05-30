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
public class Room {

    int RoomID;
    String Roomname;
    String Roomdesc;
    int RoomcateID;
    int RoomimgaeID;
    double Roomprice;
    int NumberPerson;
    float Square;
    String Comment;
    int  Rate;
    String Note;

    public Room() {
    }

    public Room(int RoomID, String Roomname, String Roomdesc, int RoomcateID, int RoomimgaeID, double Roomprice, int NumberPerson, float Square, String Comment, int Rate, String Note) {
        this.RoomID = RoomID;
        this.Roomname = Roomname;
        this.Roomdesc = Roomdesc;
        this.RoomcateID = RoomcateID;
        this.RoomimgaeID = RoomimgaeID;
        this.Roomprice = Roomprice;
        this.NumberPerson = NumberPerson;
        this.Square = Square;
        this.Comment = Comment;
        this.Rate = Rate;
        this.Note = Note;
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

    public int getRoomimgaeID() {
        return RoomimgaeID;
    }

    public void setRoomimgaeID(int RoomimgaeID) {
        this.RoomimgaeID = RoomimgaeID;
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

    

    @Override
    public String toString() {
        return "Room{" + "RoomID=" + RoomID + ", Roomname=" + Roomname + ", Roomdesc=" + Roomdesc + ", RoomcateID=" + RoomcateID + ", RoomimgaeID=" + RoomimgaeID + ", Roomprice=" + Roomprice +", NumberPerson=" + NumberPerson +", Square=" + Square +", Comment=" + Comment +", Rate=" + Rate +", Note=" + Note +'}';//To change body of generated methods, choose Tools | Templates.
    }
      
}
