package dao;

import entity.Room;
import entity.RoomByDate;
import java.sql.Date;
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

    public Vector<Room> selectRoom(String roomName, int status) throws Exception;

    public int getPage();

    public Vector<Room> getRoomByPage(int n);

    public Vector<Room> getRoomByPageStatus(int n);

    public int getPageByPageStatus();

    public Room getRoom(String roomid);

    public void insertRoom(Room Room);

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
