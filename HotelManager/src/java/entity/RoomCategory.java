/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class RoomCategory {
    private int RoomcateID ;
	private String Catename;
	private String Note;

    public RoomCategory() {
    }

    public RoomCategory(int RoomcateID, String Catename, String Note) {
        this.RoomcateID = RoomcateID;
        this.Catename = Catename;
        this.Note = Note;
    }

    public int getRoomcateID() {
        return RoomcateID;
    }

    public void setRoomcateID(int RoomcateID) {
        this.RoomcateID = RoomcateID;
    }

    public String getCatename() {
        return Catename;
    }

    public void setCatename(String Catename) {
        this.Catename = Catename;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }
    

    @Override
    public String toString() {
        return "RoomCategory{" + "RoomcateID=" + RoomcateID + ", Catename=" + Catename + ", Note=" + Note + '}';
    }
        
}
