
package dao;

import entity.RoomDevice;
import java.util.Vector;


public interface RoomDeviceDAO {
    
    public Vector<RoomDevice> getRoomDeviceList();

    public RoomDevice getRoomDevice(String cateroomid);

    public void insertRoomDevice(RoomDevice RoomDevice);

    public void updateRoomDevice(RoomDevice RoomDevice);

    public void deleteRoomDevice(int RDid);


}
