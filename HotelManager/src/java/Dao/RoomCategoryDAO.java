/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.RoomCategory;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public interface RoomCategoryDAO {
    
    public Vector<RoomCategory> getRoomCategoryList();

    public RoomCategory getAccount(int cateid);

    public void insertRoomCategory(RoomCategory RoomCategory);

    public void updateRoomCategory(RoomCategory RoomCategory);

    public void deleteRoomCategory(int cateid);

}
