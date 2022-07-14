
/*
 * Copyright (C) 2022, FPT University
 * SWP391 - SE1615 - Group3
 * HotelManager
 *
 * Record of change:
 * DATE          Version    Author           DESCRIPTION
 *               1.0                         First Deploy
 * 13/07/2022    1.0        HieuLBM          Comment
 */
package dao;

import entity.Device;
import entity.Room;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Lớp này chứa các interface của DeviceDAOImpl
 *
 * @author
 */
public interface DeviceDAO {

    public Vector<Device> getAllDevice(String sql);

    public Vector<Device> getDevicebyroom(String cateRoom, int n);

    /**
     * get list device and count from Device table
     *
     * @return  <code>ArrayList<Device></code> object.
     * @throws java.lang.Exception
     */
    public ArrayList<Device> numberOfDevice() throws Exception;

    public Vector<Device> getDevicebycateroom(String cateRoom, int n);

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
