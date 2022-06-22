/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.sendFeedback;
import java.util.Vector;

/**
 *
 * @author Minh hieu
 */
public interface SendFeedback {

    public Vector<sendFeedback> getMessage() throws Exception;

    public Vector<sendFeedback> getMessageUnread() throws Exception;

    public void insert(sendFeedback message) throws Exception;

    public int updateRead(int id, String isRead) throws Exception;

    public sendFeedback getMessageById(int Id) throws Exception;

    public void delete(int id) throws Exception;

    public Vector<sendFeedback> pagingMessage(int index) throws Exception;

    public Vector<sendFeedback> searchName(int index, String title) throws Exception;
      public Vector<sendFeedback> getMessageOfTitle(String title) throws Exception;

}
