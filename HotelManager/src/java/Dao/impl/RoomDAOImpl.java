/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.impl;

import Dao.RoomDAO;
import Entity.Image;
import Entity.Room;
import context.DBContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class RoomDAOImpl extends DBContext implements RoomDAO {

    @Override
    public Vector<Room> getRoomList() {
        String sql = "select top (6) * from Room INNER JOIN Image on Image.RoomimgaeID= Room.RoomimgaeID \n" +
"JOIN CateRoom on Room.RoomcateID = CateRoom.RoomcateID\n" +
"where Room.Status =0 \n" +
"ORDER BY RAND()";
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
                String cateroom = rs.getString(24);
                Room im = new Room(id, name, des, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note,cateroom);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
    public static void main(String[] args) {
        RoomDAOImpl dao = new RoomDAOImpl();
        Vector<Room> vector = dao.getRoomList();
        for (Room room : vector) {
            System.out.println(room);
        }
    }
    @Override
    public Room getRoom(int roomid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Vector<Room> getRoomListbyPrice(int from, int to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
