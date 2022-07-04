
package dao;

import entity.RoomCategory;
import java.util.Vector;

public interface RoomCategoryDAO {
    
    public Vector<RoomCategory> getRoomCategoryList(String sql);

    public RoomCategory getAccount(int cateid);

    public void insertRoomCategory(String roomcatename);

    public void updateRoomCategory(String RoomCategoryid, String roomcatename);

    public void deleteRoomCategory(String roomcate);

}
