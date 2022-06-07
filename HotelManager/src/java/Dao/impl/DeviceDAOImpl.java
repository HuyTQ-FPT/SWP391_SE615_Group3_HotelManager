/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.impl;

import Dao.DeviceDAO;
import Entity.Device;
import Entity.Service;
import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class DeviceDAOImpl extends DBContext implements DeviceDAO {

    @Override
    public Vector<Device> getAllDevice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertDevice(Device newDevice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateDevice(int dID, Device updateDevice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteDevice(int dID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vector<Device> getDevicebycateroom(String cateRoom) {
        Vector<Device> vector = new Vector<Device>();
        String sql = "select * from RoomDevice INNER JOIN Device on RoomDevice.DeviceID = Device.DeviceID where RoomDevice.RoomcateID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cateRoom);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Device de = new Device(rs.getInt(1), rs.getString(5), rs.getInt(8), rs.getDouble(6), rs.getInt(3), rs.getInt(3));
                vector.add(de);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vector;
    }

    public static void main(String[] args) {
        DeviceDAOImpl dao = new DeviceDAOImpl();
        Vector<Device> de = dao.getDevicebycateroom("3");
        for (Device device : de) {
            System.out.println(device);
        }

    }

}
