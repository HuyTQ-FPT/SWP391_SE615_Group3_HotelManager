/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

<<<<<<< Updated upstream:HotelManager/src/java/dao/MessageDAO.java
import entity.message;
=======
import Entity.Message;
>>>>>>> Stashed changes:HotelManager/src/java/Dao/MessageDAO.java
import java.util.Vector;

/**
 *
 * @author Admin
 */
public interface MessageDAO {
    public Vector<Message> getAllImage();
    public int insertMessageCus(Message mess);
    public int insertMessageRe(Message mess);
    public void updateMessage(int mID ,Message updateMessage);
    public void deleteMessage(int mID);
}
