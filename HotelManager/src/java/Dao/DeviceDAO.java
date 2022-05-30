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

    public void insertDevice(Device newDevice);

    public void updateDevice(int dID, Device updateDevice);

    public void deleteDevice(int dID);
}
