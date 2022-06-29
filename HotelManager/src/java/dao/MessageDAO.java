
package dao;

import entity.Message;
import java.util.Vector;


public interface MessageDAO {
    public Vector<Message> getAllImage() throws Exception;
    public int insertMessageCus(Message mess) throws Exception;
    public int insertFeedback(Message mess) throws Exception;
    public int insertMessageRe(Message mess) throws Exception;
    public void updateMessage(int mID ,Message updateMessage) throws Exception;
    public void deleteMessage(int mID) throws Exception;
}
