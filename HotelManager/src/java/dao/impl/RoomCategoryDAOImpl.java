/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.RoomCategoryDAO;
import entity.RoomCategory;
import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class RoomCategoryDAOImpl extends DBContext implements RoomCategoryDAO {

    @Override
    public Vector<RoomCategory> getRoomCategoryList(String sql) {
        Vector<RoomCategory> vector = new Vector<RoomCategory>();
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                RoomCategory im = new RoomCategory(id, name, des);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public static void main(String[] args) {
        RoomCategoryDAOImpl dao = new RoomCategoryDAOImpl();
//        Vector<RoomCategory> vector = dao.getRoomCategoryList("select * from CateRoom");
//        for (RoomCategory roomCategory : vector) {
//        System.out.println(vector.lastElement().getRoomcateID());
//        dao.insertRoomCategory("nguyen van a");
        dao.deleteRoomCategory("15");
//        }
    }

    @Override
    public RoomCategory getAccount(int cateid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertRoomCategory(String roomcatename) {
        String query = "insert into CateRoom (Catename) \n"
                + "values (?);\n"
                + "insert into Room ([Roomname],[Roomdesc],[RoomcateID],[RoomimgaeID] ,\n"
                + "[Roomprice],[NumberPerson],[Square],[Comment],[Rate],[Note],[Status]) \n"
                + "values (null, null, @@identity, null, null, null, null, null, null, null, null);";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, roomcatename);
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRoomCategory(String RoomCategoryid, String roomcatename) {
        String query = "UPDATE [dbo].[CateRoom]\n"
                + "   SET [Catename] = ?\n"
                + "   ,[Note] = null\n"
                + "   WHERE RoomcateID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, roomcatename);
            pre.setString(2, RoomCategoryid);
            pre.executeUpdate();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRoomCategory(String roomcate) {
        String query = " DELETE FROM [dbo].[Room]\n"
                + "      WHERE RoomcateID = ?\n"
                + "	 DELETE FROM [dbo].[CateRoom]\n"
                + "      WHERE RoomcateID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, roomcate);
            pre.setString(2, roomcate);
            pre.executeUpdate();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
