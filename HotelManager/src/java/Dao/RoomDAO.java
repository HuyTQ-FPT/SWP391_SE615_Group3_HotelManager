/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Room;
import context.DBContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public interface RoomDAO{
    
    public Vector<Room> getRoomList();
    public Vector<Room> getRoomList2();

    public Room getRoom(int roomid);

    public void insertRoom(Room Room);

    public void updateRoom(Room Room);

    public void deleteRoom(int roomid);

    public Vector<Room> getRoomListbyPrice(int from, int to);
    
}
