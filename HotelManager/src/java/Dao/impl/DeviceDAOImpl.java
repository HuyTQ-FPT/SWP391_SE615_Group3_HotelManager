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
    public void insertDevice(String name, String price, String status, String RoomcateID, String Quantity) {
        String query = "insert into Device (DeviceName, DeviceCate, Price, [Status]) \n"
                + "values (?, null, ?, ?);\n"
                + "insert into RoomDevice (RoomcateID, DeviceID, Quantity) \n"
                + "values (?, @@identity, ?);";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, name);
            pre.setString(2, price);
            pre.setString(3, status);
            pre.setString(4, RoomcateID);
            pre.setString(5, Quantity);
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDeviceQuan(String quan, String deviceid, String roomcateid) {
        String query = "UPDATE RoomDevice\n"
                + "SET Quantity = ?\n"
                + "WHERE DeviceID = ? and RoomcateID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, quan);
            pre.setString(2, deviceid);
            pre.setString(3, roomcateid);
            pre.executeUpdate();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDeviceinfor(String name, String price, String status, String deviceid) {
        String query = "UPDATE Device\n"
                + "SET DeviceName = ?,\n"
                + "Price = ?, Status = ?\n"
                + "WHERE DeviceID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, name);
            pre.setString(2, price);
            pre.setString(3, status);
            pre.setString(4, deviceid);
            pre.executeUpdate();
            System.out.println(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDevice(String Roomcateid, String DeviceID) {
        String query = "DELETE FROM [dbo].[RoomDevice]\n"
                + "      WHERE RoomcateID = ? and DeviceID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, Roomcateid);
            pre.setString(2, DeviceID);
            pre.executeUpdate();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                Device de = new Device(rs.getInt(2), rs.getInt(1), rs.getString(5), rs.getInt(1), rs.getDouble(7), rs.getInt(8), rs.getInt(3));
                vector.add(de);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vector;
    }

    @Override
    public Vector<Device> searchDevicebyname(String mess, String roomcateid) {
        Vector<Device> vector = new Vector<Device>();
        String sql = "select * from RoomDevice INNER JOIN Device on RoomDevice.DeviceID = Device.DeviceID\n" +
"where (RoomDevice.RoomcateID = ?)\n" +
"and (DeviceName like ? or Price like ? or Quantity like ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, roomcateid);
            ps.setString(2, "%" + mess + "%");
            ps.setString(3, "%" + mess + "%");
            ps.setString(4, "%" + mess + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Device de = new Device(rs.getInt(2), rs.getInt(1), rs.getString(5), rs.getInt(1), rs.getDouble(7), rs.getInt(8), rs.getInt(3));
                vector.add(de);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vector;
    }

    public static void main(String[] args) {
        DeviceDAOImpl dao = new DeviceDAOImpl();
//        dao.updateDeviceinfor("Điều Hòa Nhỏ", "11212", "1", "12");
//        dao.updateDeviceQuan("2", "12", "1");
//        dao.insertDevice("test", "9999", "1", "1", "2");
        Vector<Device> de = dao.searchDevicebyname("22", "1");
        for (Device device : de) {
            System.out.println(device);
        }

    }

}
