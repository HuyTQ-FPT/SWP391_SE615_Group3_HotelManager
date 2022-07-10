
package dao;

import entity.Device;
import entity.Room;
import java.util.Vector;

public interface DeviceDAO {

    public Vector<Device> getDeviceByCateId(int cateRoom) throws Exception;
    public Vector<Device> getAllDevice();

    public Vector<Device> getDevicebycateroom(String cateRoom, int n);
    public Vector<Device> getDevicebycateroom(String cateRoom);

    public void insertDevice(String name, String price, String status, String RoomcateID, String Quantity);

    public void updateDeviceQuan(String quan, String deviceid, String roomcateid);
    
    public Vector<Device> searchDevicebyname(String mess, String roomcateid);

    public void updateDeviceinfor(String name, String price, String status, String deviceid);

    public void deleteDevice(String Roomcateid, String DeviceID);
}
