
package entity;

public class RoomCategory {
    private int RoomcateID ;
	private String Catename;
	private String Note;
        private int count;

    public RoomCategory() {
    }

    public RoomCategory(int RoomcateID, String Catename, String Note) {
        this.RoomcateID = RoomcateID;
        this.Catename = Catename;
        this.Note = Note;
    }

    public RoomCategory(int RoomcateID, String Catename, int count) {
        this.RoomcateID = RoomcateID;
        this.Catename = Catename;
        this.count = count;
    }

    public RoomCategory(int RoomcateID, String Catename) {
        this.RoomcateID = RoomcateID;
        this.Catename = Catename;
    }
        
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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
    public String toString1() {
        return "RoomCategory{" + "RoomcateID=" + RoomcateID + ", Catename=" + Catename + ", count=" + count+ '}';
    }
        
}
