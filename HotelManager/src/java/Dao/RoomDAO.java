/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Room;
import Entity.RoomByDate;
import context.DBContext;
import java.sql.Date;
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
    
    public Room getRoom(String roomid);

    public void insertRoom(Room Room);

    public void updateRoom(Room Room);

    public void deleteRoom(int roomid);
    
    public int getPageByPrice(int p1,int p2);
    
    public Vector<Room> getRoomListbyPrice(int n,int from, int to);
    
    public Vector<Room> getRoomByPriceMax(int n);
    
    public Vector<Room> getRoomByPriceMin(int n);
    
    public Vector<Room> getRoomByRate(int n);
    
    public Vector<RoomByDate> seachRoom(int a,Date datein,Date dateout); 
}
