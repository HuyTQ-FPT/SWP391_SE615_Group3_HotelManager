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

    public Vector<Room> getRoomListAll(String sql) throws Exception;

    public void updateStatus(int rID, int rStatus) throws Exception;

    public Vector<Room> selectRoom(String roomName,int status) throws Exception;

  

    public int getPage() throws Exception;

    public Vector<Room> getRoomByPage(int n) throws Exception;

    public Vector<Room> getRoomByPageStatus(int n) throws Exception;

    public int getPageByPageStatus() throws Exception;

    public Room getRoom(String roomid) throws Exception;

    public void insertRoom(Room Room) throws Exception;

    public void updateRoom(Room Room) throws Exception;

    public void deleteRoom(int roomid) throws Exception;

    public int getPageByPrice(int p1, int p2) throws Exception;

    public Vector<Room> getRoomListbyPrice(int n, int from, int to) throws Exception;

    public Vector<Room> getRoomByPriceMax(int n) throws Exception;

    public Vector<Room> getRoomByPriceMin(int n) throws Exception;

    public Vector<Room> getRoomByRate(int n) throws Exception;

    public Vector<RoomByDate> seachRoom(int a, Date datein, Date dateout) throws Exception;

    public Vector<RoomByDate> seachRoom() throws Exception;
}
