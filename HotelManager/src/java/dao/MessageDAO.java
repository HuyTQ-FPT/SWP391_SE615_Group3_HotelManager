
package dao;

import entity.Message;
import java.util.ArrayList;


public interface MessageDAO {
    public ArrayList<Message> getAllComment() throws Exception;
    public ArrayList<Integer> getAllAcccountMessage() throws Exception;
    public int insertMessageCus(Message mess) throws Exception;
    public int insertNewmessagecus(Message mess) throws Exception;
    public int insertFeedback(Message mess) throws Exception;
    public int insertMessageRe(Message mess) throws Exception;
    public int getRoleIDByUserId(int userID) throws Exception;
    public void updateMessage(int mID ,Message updateMessage) throws Exception;
    public void deleteMessage(int mID) throws Exception;
    public boolean checkNewmessage(int AccountID) throws Exception;
    public void resetNewmessage(int AccountID) throws Exception;
}
