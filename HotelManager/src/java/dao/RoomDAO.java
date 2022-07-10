package dao;

import entity.Device;
import entity.Image;
import entity.Room;
import entity.RoomByDate;
import entity.RoomCategory;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;

public interface RoomDAO {

    public Vector<Room> getRoomListAll(String sql) throws Exception;

    public void updateStatus(int rID, int rStatus) throws Exception;

    public Vector<Room> selectRoom(String roomName, int status) throws Exception;

    public Vector<Room> searchRoomNamebyAjax(String roomName, int cateID) throws Exception;

    public Image searchRoomidAndImage(int RoomID) throws Exception;

    public Room getOneRoom(int roomid) throws Exception;

    public Vector<RoomCategory> numberOfRoomsByCategory() throws Exception;
    public Vector<Device> numberOfDevice() throws Exception;
    public Vector<Room> sumOfRoom() throws Exception;

    
    
    
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
