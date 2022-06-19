/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.RoomDeviceDAO;
import entity.RoomDevice;
import context.DBContext;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class  RoomDeviceDAOImpl extends DBContext implements RoomDeviceDAO {

    @Override
    public Vector<RoomDevice> getRoomDeviceList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RoomDevice getRoomDevice(String cateroomid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertRoomDevice(RoomDevice RoomDevice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRoomDevice(RoomDevice RoomDevice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRoomDevice(int RDid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
