package dao;

import entity.Device;
import entity.Room;
import java.util.Vector;

public interface DeviceDAO {

    public Vector<Device> getAllDevice(String sql);

    public Vector<Device> getDevicebyroom(String cateRoom, int n);

    public Vector<Device> getDevicebycateroom(String cateRoom);

    public void insertDevice(String DeviceName, String Price);

    public void deletetDevice(String RoomID, String DeviceID);

    public void insertDeviceRoom(String RoomID, String DeviceID, String Quantity, String Status, String Note, String ImageDevice);

    public void updateDeviceinfor(String roomid, String quantity, String status, String note, String deviceid, String image);

    public Vector<Device> searchDevicebyname(String mess, String roomcateid);

    public void updateDeviceQuan(String quan, String deviceid, String roomcateid);

    public void deleteDevice(String Roomcateid);

    public Device Getdevice(String sql);

    public Device Getdevices(String sql);
    public Vector<Device> getAllDevicetoAdd(String sql);
}
