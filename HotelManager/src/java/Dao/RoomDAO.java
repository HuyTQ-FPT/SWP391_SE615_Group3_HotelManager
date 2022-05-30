/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Room;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class RoomDAO extends DBContext {
     public Vector<Room> listAllProduct(String sql) {
        Vector<Room> vector = new Vector<Room>();
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String Roomname = rs.getString(2);
                String Roomdesc = rs.getString(3);
                 int RoomcateID = rs.getInt(4);
                 int RoomimgaeID = rs.getInt(5);
                 double Roomprice = rs.getDouble(6);
                 int NumberPerson = rs.getInt(7);
                 float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);
                Room cus = new Room(RoomcateID, Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, Square, Comment, Rate, Note);
                vector.add(cus);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
     public static void main(String[] args) {
        RoomDAO dao = new RoomDAO();
        Vector<Room> vetor = dao.listAllProduct("select * from Room");
        for (Room p : vetor) {
            System.out.println(p);
        }
    }
}
