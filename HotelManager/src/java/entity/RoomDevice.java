
package entity;

public class RoomDevice {
    private int RoomcateID;
	private int DeviceID;
	private int Quantity ;

    public RoomDevice() {
    }

    public RoomDevice(int RoomcateID, int DeviceID, int Quantity) {
        this.RoomcateID = RoomcateID;
        this.DeviceID = DeviceID;
        this.Quantity = Quantity;
    }

    @Override
    public String toString() {
        return "RoomDevice{" + "RoomcateID=" + RoomcateID + ", DeviceID=" + DeviceID + ", Quantity=" + Quantity + '}';
    }
        
}
