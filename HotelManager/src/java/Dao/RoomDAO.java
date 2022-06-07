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
public interface RoomDAO {

    public Vector<Room> getRoomList(String sql);

    public int getPage();

    public Vector<Room> getRoomByPage(int n);

    public Vector<Room> getRoomByPageStatus(int n);

    public int getPageByPageStatus();
    
    public int getPageByPrice();
    
    public Vector<Room> getRoomByPrice(int n);

    public Room getRoom(String roomid);

    public void insertRoom(Room Room);

    public void updateRoom(Room Room);

    public void deleteRoom(int roomid);

    public Vector<Room> getRoomListbyPrice(int from, int to);

}
