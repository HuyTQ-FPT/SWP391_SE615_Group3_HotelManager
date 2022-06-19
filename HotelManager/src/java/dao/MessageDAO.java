/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.message;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public interface MessageDAO {
    public Vector<message> getAllImage();
    public void insertMessage(int mID ,message insertMessage);
    public void updateMessage(int mID ,message updateMessage);
    public void deleteMessage(int mID);
}
