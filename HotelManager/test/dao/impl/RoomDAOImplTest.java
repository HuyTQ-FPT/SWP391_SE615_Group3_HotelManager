
package dao.impl;

import entity.Room;
import entity.RoomByDate;
import java.util.Vector;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class RoomDAOImplTest {
    
    public RoomDAOImplTest() {
    }

    /**
     * Test of getRoomList method, of class RoomDAOImpl.
     */
    @Test
    public void testGetRoomList() {
        System.out.println("getRoomList");
        String sql = "select*from Room";
        RoomDAOImpl instance = new RoomDAOImpl();
        Vector<Room> expResult = null;
        Vector<Room> result = instance.getRoomList(sql);
        assertNotEquals(expResult, result);
     
    }


    /**
     * Test of getRoomListAll method, of class RoomDAOImpl.
     */
    @Test
    public void testGetRoomListAll() throws Exception {
        System.out.println("getRoomListAll");
        String sql = "select*from Room";
        RoomDAOImpl instance = new RoomDAOImpl();
        Vector<Room> expResult = null;
        Vector<Room> result = instance.getRoomListAll(sql);
        assertNotEquals(expResult, result);
    
    }

    /**
     * Test of updateStatus method, of class RoomDAOImpl.
     */
    @Test
    public void testUpdateStatus() throws Exception {
        System.out.println("updateStatus");
        int rID = 2;
        int rStatus = 1;
        RoomDAOImpl instance = new RoomDAOImpl();
        instance.updateStatus(rID, rStatus);
  
    }

    /**
     * Test of selectRoom method, of class RoomDAOImpl.
     */
    @Test
    public void testSelectRoom() throws Exception {
        System.out.println("selectRoom");
        String rName = "";
        int status = 2;
        RoomDAOImpl instance = new RoomDAOImpl();
        Vector<Room> expResult = null;
        Vector<Room> result = instance.selectRoom(rName, status);
        assertNotEquals(expResult, result);
   
    }


    
}
