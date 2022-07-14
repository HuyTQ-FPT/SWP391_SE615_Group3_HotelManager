/*
 * Copyright (C) 2022, FPT University
 * SWP391 - SE1615 - Group3
 * HotelManager
 *
 * Record of change:
 * DATE          Version    Author           DESCRIPTION
 *               1.0                         First Deploy
 * 13/07/2022    1.0        HieuLBM          Comment
 */
package dao;

import entity.Room;
import entity.RoomByDate;
import entity.RoomCategory;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Lớp này chứa các interface của RoomDAOImpl
 *
 * @author
 */
public interface RoomDAO {

    /**
     * get list Room from Room table
     *
     * @return <code>ArrayList<Room></code> object.
     * @throws java.lang.Exception
     */
    public ArrayList<Room> getRoomListAll() throws Exception;

    /**
     * update Room from Room table
     *
     * @param rID is an int.
     * @param rStatus is an int.
     * @throws java.lang.Exception
     */
    public void updateStatus(int rID, int rStatus) throws Exception;

    /**
     * get list and search Room from Room table
     *
     * @param roomName <code>Room</code> object.
     * @param status <code>Room</code> object.
     * @return <code>ArrayList<Room></code> object.
     * @throws java.lang.Exception
     */
    public ArrayList<Room> selectRoom(String roomName, int status) throws Exception;

    /**
     * get list and search Room from Room table
     *
     * @param roomName <code>Room</code> object.
     * @param cateID <code>Room</code> object.
     * @return <code>ArrayList<Room></code> object.
     * @throws java.lang.Exception
     */
    public ArrayList<Room> searchRoomNamebyAjax(String roomName, int cateID) throws Exception;

    /**
     * get a Room from Room table
     *
     * @param roomid <code>Room</code> object.
     * @return <code>Room</code> object.
     * @throws java.lang.Exception
     */
    public Room getOneRoom(int roomid) throws Exception;

    /**
     * get count Room from Room table
     *
     * @return <code>ArrayList<Room></code> object.
     * @throws java.lang.Exception
     */
    public ArrayList<Room> sumOfRoom() throws Exception;

    /**
     * check room Name from Room table
     *
     * @param roomName is an String
     * @return String
     * @throws java.lang.Exception
     */
    public String checkRoom(String roomName) throws Exception;

    public Vector<Room> getRoomList(String sql);

    public int getPage();

    public Vector<Room> getRoomByPage(int n);

    public Vector<Room> getRoomByPageStatus(int n);

    public int getPageByPageStatus();

    public Room getRoom(String roomid);

    public void crudRoom(String sql);

    public void updateRoom(Room Room);

    public void deleteRoom(int roomid);

    public int getPageByPrice(int p1, int p2);

    public Vector<Room> getRoomListbyPrice(int n, int from, int to);

    public Vector<Room> getRoomByPriceMax(int n);

    public Vector<Room> getRoomByPriceMin(int n);

    public Vector<Room> getRoomByRate(int n);

    public Vector<RoomByDate> seachRoom(String a, String datein, String dateout) throws Exception;

    public int getPage(String sql);

}
