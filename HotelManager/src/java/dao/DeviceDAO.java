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

    /**
     * get list device and count from Device table
     *
     * @return  <code>ArrayList<Device></code> object.
     * @throws java.lang.Exception
     */
    public ArrayList<Device> numberOfDevice() throws Exception;

    public Vector<Device> getDevicebycateroom(String cateRoom, int n);

    public Vector<Device> getDevicebycateroom(String cateRoom);

    public void insertDevice(String name, String price, String status, String RoomcateID, String Quantity);

    public void updateDeviceQuan(String quan, String deviceid, String roomcateid);

    public Vector<Device> searchDevicebyname(String mess, String roomcateid);

    public void updateDeviceinfor(String name, String price, String status, String deviceid);

    public void deleteDevice(String Roomcateid, String DeviceID);
}
