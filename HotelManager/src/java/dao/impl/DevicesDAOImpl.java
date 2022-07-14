/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import entity.Device;
import entity.Service;
import context.DBContext;
import dao.DeviceDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class DevicesDAOImpl extends DBContext implements DeviceDAO {

    @Override
    public Vector<Device> getAllDevice(String sql) {
        Vector<Device> vector = new Vector<Device>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Device de = new Device(rs.getInt(1), 0, rs.getString(2), rs.getInt(7), rs.getDouble(4), 0, 0, "", "");
                vector.add(de);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vector;
    }

    @Override
    public Vector<Device> getAllDevicetoAdd(String sql) {
        Vector<Device> vector = new Vector<Device>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Device de = new Device(rs.getInt(1), 0, rs.getString(2), 0, 0, 0, 0, "", "");
                vector.add(de);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vector;
    }

    @Override
    public void insertDevice(String DeviceName, String Price) {
        Vector<Device> vector = getAllDevice("select * from Device");
        String query = "INSERT INTO [dbo].[Device]\n"
                + "           ([DeviceName]\n"
                + "           ,[DeviceCate]\n"
                + "           ,[Price]\n"
                + "           ,[Status])\n"
                + "     VALUES\n"
                + "           (?, null, ?, null)";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, DeviceName);
            pre.setString(2, Price);
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletetDevice(String RoomID, String DeviceID) {
        String query = "DELETE FROM [dbo].[RoomDevice]\n"
                + "      WHERE RoomID = ? and DeviceID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, RoomID);
            pre.setString(2, DeviceID);
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertDeviceRoom(String RoomID, String DeviceID, String Quantity, String Status, String Note, String ImageDevice) {
        String query = "INSERT INTO [dbo].[RoomDevice]\n"
                + "           ([RoomID]\n"
                + "           ,[DeviceID]\n"
                + "           ,[Quantity]\n"
                + "           ,[Status]\n"
                + "           ,[Note]\n"
                + "           ,[ImageDevice])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, RoomID);
            pre.setString(2, DeviceID);
            pre.setString(3, Quantity);
            pre.setString(4, Status);
            pre.setString(5, Note);
            pre.setString(6, ImageDevice);
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDeviceQuan(String name, String deviceid, String price) {
        String query = "UPDATE [dbo].[Device]\n"
                + "   SET [DeviceName] = ?\n"
                + "     \n"
                + "      ,[Price] = ?\n"
                + "      \n"
                + " WHERE DeviceID =?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, name);
            pre.setString(2, price);
            pre.setString(3, deviceid);
            pre.executeUpdate();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDeviceinfor(String roomid, String quantity, String status, String note, String deviceid, String image) {
        String query = "UPDATE [dbo].[RoomDevice]\n"
                + "   SET [Quantity] = ?\n"
                + "      ,[Status] = ?\n"
                + "      ,[Note] = ?\n"
                + "      ,[ImageDevice] = ?\n"
                + " WHERE RoomID = ? and DeviceID = ? ";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, quantity);
            pre.setString(2, status);
            pre.setString(3, note);
            pre.setString(4, image);
            pre.setString(5, roomid);
            pre.setString(6, deviceid);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDevice(String Roomcateid) {
        String query = "delete from RoomDevice where DeviceID = "+Roomcateid+"\n"
                + "delete from Device where DeviceID = "+Roomcateid+"";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.executeUpdate();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getPage() {
        int n = 0;
        String sql = "select COUNT(*) from RoomDevice INNER JOIN "
                + "Device on RoomDevice.DeviceID = Device.DeviceID "
                + "where RoomDevice.RoomcateID = 3";
        Vector<Device> vector = new Vector<Device>();
        try {
            int totalPage = 0;
            int countPage = 0;
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = getData(sql);
            while (rs.next()) {
                totalPage = rs.getInt(1);
                countPage = totalPage / 4;
                if (totalPage % 4 != 0) {
                    countPage++;
                }
                return countPage;
            }
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    @Override
    public Vector<Device> getDevicebycateroom(String cateRoom) {
        Vector<Device> vector = new Vector<Device>();
        String sql = "select * from RoomDevice INNER JOIN Device on "
                + "RoomDevice.DeviceID = Device.DeviceID "
                + "where RoomDevice.RoomcateID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cateRoom);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                Device de = new Device(rs.getInt(2), rs.getInt(6), rs.getString(3), rs.getInt(1), rs.getDouble(4), rs.getInt(8), rs.getInt(5),rs.getString(9));
//                vector.add(de);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vector;
    }

    @Override
    public Vector<Device> getDevicebyroom(String cateRoom, int n) {
        Vector<Device> vector = new Vector<Device>();
        int begin = 1;
        int end = 6;
        for (int i = 2; i <= n; i++) {
            begin += 6;
            end += 6;
        }
        String sql = "	           with t as(SELECT r.DeviceCate,r.DeviceID,r.DeviceName, r.Price,i.Quantity,\n"
                + "	           i.RoomID,i.Note,i.[Status],i.ImageDevice,ROW_NUMBER() OVER (order by r.DeviceID)\n"
                + "                AS RowNum FROM Device r JOIN RoomDevice i on i.DeviceID= r.DeviceID\n"
                + "                where i.RoomID=?)\n"
                + "                select * from t";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cateRoom);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Device de = new Device(rs.getInt(2), rs.getInt(6), rs.getString(3), rs.getInt(1), rs.getDouble(4), rs.getInt(8), rs.getInt(5), rs.getString(7), rs.getString(9));
                vector.add(de);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vector;
    }

    @Override
    public Device Getdevice(String sql) {
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int DeviceID = rs.getInt(2);
                int RoomID = rs.getInt(1);
                String DeviceName = rs.getString(8);
                int DeviceCate = 0;
                double Price = 0;
                int Status = rs.getInt(4);
                int Quantity = rs.getInt(3);
                String Note = rs.getString(5);
                String Imagedevice = rs.getString(6);
                return new Device(DeviceID, RoomID, DeviceName, DeviceCate, Price, Status, Quantity, Note, Imagedevice);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Device Getdevices(String sql) {
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int DeviceID = rs.getInt(1);
                String DeviceName = rs.getString(2);
                int DeviceCate = rs.getInt(3);;
                double Price = rs.getDouble(4);;
                return new Device(DeviceID, 0, DeviceName, DeviceCate, Price, 0, 0, "", "");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Vector<Device> searchDevicebyname(String mess, String roomcateid) {
        Vector<Device> vector = new Vector<Device>();
        String sql = "select * from RoomDevice INNER JOIN Device on RoomDevice.DeviceID = Device.DeviceID\n"
                + "where (RoomDevice.RoomcateID = ?)\n"
                + "and (DeviceName like ? or Price like ? or Quantity like ?)"
                + "order by Device.DeviceID desc";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, roomcateid);
            ps.setString(2, "%" + mess + "%");
            ps.setString(3, "%" + mess + "%");
            ps.setString(4, "%" + mess + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                Device de = new Device(rs.getInt(2), rs.getInt(1), rs.getString(5), rs.getInt(1), rs.getDouble(7), rs.getInt(8), rs.getInt(3));
//                vector.add(de);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vector;
    }
//String roomid, String quantity, String status, String note, String deviceid

    public static void main(String[] args) {
        DevicesDAOImpl dao = new DevicesDAOImpl();
//                dao.updateDeviceinfor("1", "3", "1", "hiện đang bảo trì","2");
        //        dao.updateDeviceQuan("2", "12", "1");
        //        dao.insertDevice("test", "9999", "1", "1", "2");
//        dao.insertDevice("Thiết Bị Mới", "9999");
//                for (Device device : de) {
//        System.out.println(de);
//        }
        //        int n = dao.getPage();
        Vector<Device> de = dao.getAllDevicetoAdd("select * from\n"
                + " ( select RoomDevice.DeviceID,Device.DeviceName from RoomDevice join Device on RoomDevice.DeviceID = Device.DeviceID) as b\n"
                + " except\n"
                + " select * from\n"
                + " (select RoomDevice.DeviceID,Device.DeviceName from RoomDevice join Device on RoomDevice.DeviceID = Device.DeviceID\n"
                + "		where RoomDevice.RoomID=4) as a");
        for (Device device : de) {
            System.out.println(device);
        }
//        Device de = dao.Getdevice("select * from Roomdevice join Device on RoomDevice.DeviceID = Device.DeviceID \n"
//                + "				where Roomdevice.DeviceID = 2 and Roomdevice.RoomID =1 ");
    }

}
