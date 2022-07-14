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
//        Vector<RoomCategory> vector = dao.getRoomCategoryList("with t as(select *, ROW_NUMBER() OVER (order by CateRoom.RoomCateID)\n"
//                + "                AS RowNum from CateRoom )\n"
//                + "				select * from t \n"
//                + "				Where RowNum between 1 AND 3");
//int n = dao.getPage("select count (*) from CateRoom");
//        System.out.println(n);
//        for (RoomCategory roomCategory : vector) {
////        System.out.println(vector.lastElement().getRoomcateID());
////        dao.insertRoomCategory("nguyen van a");
//            System.out.println(roomCategory);
////        dao.deleteRoomCategory("15");
//        }
    }

    @Override
    public RoomCategory getRoomCategori(String cateid) {
        try {
            ResultSet rs = getData(cateid);
            while (rs.next()) {
                int RoomcateID = rs.getInt(1);
                String Catename = rs.getString(2);
                String Note = rs.getString(3);
                return new RoomCategory(RoomcateID, Catename, Note);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertRoomCategory(String roomcatename, String roomcatedes) {
        String query = "insert into CateRoom (Catename, [note]) \n"
                + "                values (?,?);";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, roomcatename);
            pre.setString(2, roomcatedes);
            pre.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getPage(String sql) {
        int n = 0;
        try {
            int totalPage = 0;
            int countPage = 0;
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = getData(sql);
            while (rs.next()) {
                totalPage = rs.getInt(1);
                countPage = totalPage / 3;
                if (totalPage % 3 != 0) {
                    countPage++;
                }
                return countPage;
            }
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    @Override
    public void updateRoomCategory(String RoomCategoryid, String roomcatename, String roomcatedes) {
        String query = "UPDATE [dbo].[CateRoom]\n"
                + "   SET [Catename] = ?\n"
                + "   ,[Note] = ?\n"
                + "   WHERE RoomcateID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, roomcatename);
            pre.setString(2, roomcatedes);
            pre.setString(3, RoomCategoryid);
            pre.executeUpdate();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteRoomCategory(String roomcate) {
        String query = "update Room set RoomcateID = replace(RoomcateID,?,6); delete from CateRoom where RoomcateID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, roomcate);
            pre.setString(2, roomcate);
            pre.executeUpdate();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

}
