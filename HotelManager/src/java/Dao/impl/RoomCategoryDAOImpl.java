/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.impl;

import Dao.RoomCategoryDAO;
import Entity.RoomCategory;
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
        Vector<RoomCategory> vector = dao.getRoomCategoryList("select * from CateRoom");
//        for (RoomCategory roomCategory : vector) {
            System.out.println(vector.lastElement().getRoomcateID());
//        }
    }

    @Override
    public RoomCategory getAccount(int cateid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertRoomCategory(String roomcatename) {
        String query = "INSERT INTO [dbo].[CateRoom]\n"
                + "           ([Catename]\n"
                + "           ,[Note])\n"
                + "     VALUES\n"
                + "           (?, null)";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, roomcatename);
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateRoomCategory(RoomCategory RoomCategory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRoomCategory(int cateid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
