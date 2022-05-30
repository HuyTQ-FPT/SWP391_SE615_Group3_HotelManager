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

    @Override
    public String toString() {
        return "RoomCategory{" + "RoomcateID=" + RoomcateID + ", Catename=" + Catename + ", Note=" + Note + '}';
    }
        
}
