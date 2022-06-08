/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.impl;

import Dao.RoomDAO;
import Entity.Image;
import Entity.Room;
import Entity.RoomByDate;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class RoomDAOImpl extends DBContext implements RoomDAO {

    @Override
    public Vector<Room> getRoomList(String sql) {
        Vector<Room> vector = new Vector<Room>();
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                int cateid = rs.getInt(4);
                String image = rs.getString(14);
                double Roomprice = rs.getDouble(6);
                int NumberPerson = rs.getInt(7);
                float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);
                String cateroom = rs.getString(19);
                Room im = new Room(id, name, des, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note, cateroom);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    @Override
    public Room getRoom(String roomid) {
        String query = "select * from Room INNER JOIN Image on Image.RoomimgaeID= Room.RoomimgaeID \n"
                + "                     JOIN CateRoom on Room.RoomcateID = CateRoom.RoomcateID\n"
                + "                   where RoomID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, roomid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Room(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(14), rs.getDouble(6), rs.getInt(7), rs.getFloat(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(19));
            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    public void insertRoom(Room Room) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateRoom(Room Room) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRoom(int roomid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPage() {
        int n = 0;
        String sql = "select COUNT(*) from Room where Status=0";
        Vector<Room> vector = new Vector<Room>();
        try {
            int totalPage = 0;
            int countPage = 0;
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = getData(sql);
            while (rs.next()) {
                totalPage = rs.getInt(1);
                countPage = totalPage / 6;
                if (totalPage % 6 != 0) {
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
    public Vector<Room> getRoomByPage(int n) {
        Vector<Room> vector = new Vector<Room>();
        int begin = 1;
        int end = 6;
        for (int i = 2; i <= n; i++) {
            begin += 6;
            end += 6;
        }
        String sql = "with t as(SELECT r.RoomID,r.Roomname,r.Roomdesc, r.RoomcateID,i.image1,r.Roomprice,r.NumberPerson,r.[Square],r.Comment,r.Rate,r.Note,c.Catename,ROW_NUMBER() OVER (order by r.RoomID) \n"
                + "AS RowNum FROM Room r INNER JOIN [Image] i on i.RoomimgaeID= r.RoomimgaeID \n"
                + "          JOIN CateRoom c on r.RoomcateID = c.RoomcateID\n"
                + "where r.Status=0"
                + ")\n"
                + "select * from t Where RowNum between " + begin + " AND " + end;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                int cateid = rs.getInt(4);
                String image = rs.getString(5);
                double Roomprice = rs.getDouble(6);
                int NumberPerson = rs.getInt(7);
                float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);
                String cateroom = rs.getString(12);
                Room im = new Room(id, name, des, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note, cateroom);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public static void main(String[] args) {
        RoomDAOImpl dao = new RoomDAOImpl();
//        Vector<Room> vector= dao.getRoomList("select * from Room");
        Room rooom = dao.getRoom("1");
//        for (Room room : vector) {
        System.out.println(rooom);
//        }      
    }

    @Override
    public int getPageByPageStatus() {
        int n = 0;
        String sql = "select COUNT(*) from Room where status=0";
        Vector<Room> vector = new Vector<Room>();
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
    public Vector<Room> getRoomByPageStatus(int n) {
        Vector<Room> vector = new Vector<Room>();
        int begin = 1;
        int end = 3;
        for (int i = 2; i <= n; i++) {
            begin += 3;
            end += 3;
        }
        String sql = "with t as(SELECT r.RoomID,r.Roomname,r.Roomdesc, r.RoomcateID,i.image1,r.Roomprice,r.NumberPerson,r.[Square],r.Comment,r.Rate,r.Note,c.Catename,ROW_NUMBER() OVER (order by r.RoomID) \n"
                + "AS RowNum FROM Room r INNER JOIN [Image] i on i.RoomimgaeID= r.RoomimgaeID \n"
                + "          JOIN CateRoom c on r.RoomcateID = c.RoomcateID\n"
                + "where r.Status=0"
                + ")\n"
                + "select * from t Where RowNum between " + begin + " AND " + end;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                int cateid = rs.getInt(4);
                String image = rs.getString(5);
                double Roomprice = rs.getDouble(6);
                int NumberPerson = rs.getInt(7);
                float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);
                String cateroom = rs.getString(12);
                Room im = new Room(id, name, des, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note, cateroom);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    @Override
    public Vector<Room> getRoomListbyPrice(int n, int from, int to) {
        Vector<Room> vector = new Vector<Room>();
        int begin = 1;
        int end = 6;
        for (int i = 2; i <= n; i++) {
            begin += 3;
            end += 6;
        }
        String sql = "with t as(SELECT r.RoomID,r.Roomname,r.Roomdesc, r.RoomcateID,i.image1,r.Roomprice,r.NumberPerson,r.[Square],r.Comment,r.Rate,r.Note,c.Catename,ROW_NUMBER() OVER (order by r.RoomID) \n"
                + "AS RowNum FROM Room r INNER JOIN [Image] i on i.RoomimgaeID= r.RoomimgaeID \n"
                + "          JOIN CateRoom c on r.RoomcateID = c.RoomcateID\n"
                + "where r.Status=0\n"
                + " and r.Roomprice between "+from+" and "+to+"\n"
                + ")\n"
                + "select * from t Where RowNum between " + begin + " AND " + end;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                int cateid = rs.getInt(4);
                String image = rs.getString(5);
                double Roomprice = rs.getDouble(6);
                int NumberPerson = rs.getInt(7);
                float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);
                String cateroom = rs.getString(12);
                Room im = new Room(id, name, des, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note, cateroom);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    @Override
    public int getPageByPrice(int p1,int p2) {
        int n=0;
        String sql = "select COUNT(*) from Room Where Roomprice between " + p1 + " and " + p2 + "";
        Vector<Room> vector = new Vector<Room>();
        try {
            int totalPage = 0;
            int countPage = 0;
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = getData(sql);
            while (rs.next()) {
                totalPage = rs.getInt(1);
                countPage = totalPage / 6;
                if (totalPage % 6 != 0) {
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
    public Vector<Room> getRoomByPriceMax(int n) {
        Vector<Room> vector = new Vector<Room>();
        int begin = 1;
        int end = 6;
        for (int i = 2; i <= n; i++) {
            begin += 6;
            end += 6;
        }
        String sql = "with t as(SELECT r.RoomID,r.Roomname,r.Roomdesc, r.RoomcateID,i.image1,r.Roomprice,r.NumberPerson,r.[Square],r.Comment,r.Rate,r.Note,c.Catename,ROW_NUMBER() OVER (order by r.RoomPrice DESC) \n"
                + "AS RowNum FROM Room r INNER JOIN [Image] i on i.RoomimgaeID= r.RoomimgaeID \n"
                + "          JOIN CateRoom c on r.RoomcateID = c.RoomcateID\n"
                + "where r.Status=0"
                + ")\n"
                + "select * from t Where RowNum between " + begin + " AND " + end;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                int cateid = rs.getInt(4);
                String image = rs.getString(5);
                double Roomprice = rs.getDouble(6);
                int NumberPerson = rs.getInt(7);
                float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);
                String cateroom = rs.getString(12);
                Room im = new Room(id, name, des, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note, cateroom);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    @Override
    public Vector<Room> getRoomByPriceMin(int n) {
        Vector<Room> vector = new Vector<Room>();
        int begin = 1;
        int end = 6;
        for (int i = 2; i <= n; i++) {
            begin += 6;
            end += 6;
        }
        String sql = "with t as(SELECT r.RoomID,r.Roomname,r.Roomdesc, r.RoomcateID,i.image1,r.Roomprice,r.NumberPerson,r.[Square],r.Comment,r.Rate,r.Note,c.Catename,ROW_NUMBER() OVER (order by r.RoomPrice ASC) \n"
                + "AS RowNum FROM Room r INNER JOIN [Image] i on i.RoomimgaeID= r.RoomimgaeID \n"
                + "          JOIN CateRoom c on r.RoomcateID = c.RoomcateID\n"
                + "where r.Status=0"
                + ")\n"
                + "select * from t Where RowNum between " + begin + " AND " + end;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                int cateid = rs.getInt(4);
                String image = rs.getString(5);
                double Roomprice = rs.getDouble(6);
                int NumberPerson = rs.getInt(7);
                float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);
                String cateroom = rs.getString(12);
                Room im = new Room(id, name, des, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note, cateroom);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    @Override
    public Vector<Room> getRoomByRate(int n) {
        Vector<Room> vector = new Vector<Room>();
        int begin = 1;
        int end = 6;
        for (int i = 2; i <= n; i++) {
            begin += 6;
            end += 6;
        }
        String sql = "with t as(SELECT r.RoomID,r.Roomname,r.Roomdesc, r.RoomcateID,i.image1,r.Roomprice,r.NumberPerson,r.[Square],r.Comment,r.Rate,r.Note,c.Catename,ROW_NUMBER() OVER (order by r.Rate DESC) \n"
                + "AS RowNum FROM Room r INNER JOIN [Image] i on i.RoomimgaeID= r.RoomimgaeID \n"
                + "          JOIN CateRoom c on r.RoomcateID = c.RoomcateID\n"
                + "where r.Status=0"
                + ")\n"
                + "select * from t Where RowNum between " + begin + " AND " + end;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                int cateid = rs.getInt(4);
                String image = rs.getString(5);
                double Roomprice = rs.getDouble(6);
                int NumberPerson = rs.getInt(7);
                float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);
                String cateroom = rs.getString(12);
                Room im = new Room(id, name, des, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note, cateroom);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    @Override
    public Vector<RoomByDate> seachRoom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
