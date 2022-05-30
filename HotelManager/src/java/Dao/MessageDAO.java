/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Message;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public interface MessageDAO {
    public Vector<Message> getAllImage();
    public void insertMessage(int mID ,Message insertMessage);
    public void updateMessage(int mID ,Message updateMessage);
    public void deleteMessage(int mID);
}
