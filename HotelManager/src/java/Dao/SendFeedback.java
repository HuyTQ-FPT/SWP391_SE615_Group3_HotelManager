/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.sendFeedback;
import java.util.Vector;

/**
 *
 * @author Minh hieu
 */
public interface SendFeedback {

    public Vector<sendFeedback> getMessage() throws Exception;
    public Vector<sendFeedback> getMessageUnread() throws Exception;

    public void insert(sendFeedback message) throws Exception;

    public void updateRead(int id, String isRead) throws Exception;

    public sendFeedback getMessageById(int Id) throws Exception;

    public void delete(int id) throws Exception;

}
