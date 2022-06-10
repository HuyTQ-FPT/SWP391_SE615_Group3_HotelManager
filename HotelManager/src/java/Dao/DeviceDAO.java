/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Device;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public interface DeviceDAO {

    public Vector<Device> getAllDevice();

    public Vector<Device> getDevicebycateroom(String cateRoom);

    public void insertDevice(Device newDevice);

    public void updateDeviceQuan(String quan, String deviceid, String roomcateid);

    public void updateDeviceinfor(String name, String price, String status, String deviceid);

    public void deleteDevice(String Roomcateid, String DeviceID);
}
