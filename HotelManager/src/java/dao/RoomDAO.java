package dao;

import entity.Device;
import entity.Image;
import entity.Room;
import entity.RoomByDate;
import entity.RoomCategory;
import java.util.ArrayList;
import java.util.Vector;

public interface RoomDAO {

    public ArrayList<Room> getRoomListAll(String sql) throws Exception;

    public void updateStatus(int rID, int rStatus) throws Exception;

    public ArrayList<Room> selectRoom(String roomName, int status) throws Exception;

    public ArrayList<Room> searchRoomNamebyAjax(String roomName, int cateID) throws Exception;

    public Image searchRoomidAndImage(int RoomID) throws Exception;

    public Room getOneRoom(int roomid) throws Exception;

    public ArrayList<RoomCategory> numberOfRoomsByCategory() throws Exception;
    public ArrayList<Device> numberOfDevice() throws Exception;
    public ArrayList<Room> sumOfRoom() throws Exception;
    public RoomCategory getRoomCate(int cateID) throws Exception;
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
