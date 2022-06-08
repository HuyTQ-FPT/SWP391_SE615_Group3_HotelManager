/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.RoomDevice;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public interface RoomDeviceDAO {
    
    public Vector<RoomDevice> getRoomDeviceList();

    public RoomDevice getRoomDevice(String cateroomid);

    public void insertRoomDevice(RoomDevice RoomDevice);

    public void updateRoomDevice(RoomDevice RoomDevice);

    public void deleteRoomDevice(int RDid);


}
