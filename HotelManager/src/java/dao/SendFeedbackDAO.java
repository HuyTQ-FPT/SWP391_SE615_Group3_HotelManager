package dao;

import entity.sendFeedback;
import java.util.ArrayList;

public interface SendFeedbackDAO {

    public ArrayList<sendFeedback> getMessage() throws Exception;

    public ArrayList<sendFeedback> getMessageUnread() throws Exception;

    public void insert(sendFeedback message) throws Exception;

    public int updateRead(int id, String isRead) throws Exception;

    public sendFeedback getMessageById(int Id) throws Exception;

    public void delete(int id) throws Exception;

    public ArrayList<sendFeedback> pagingMessage(int index) throws Exception;

    public ArrayList<sendFeedback> searchName(int index, String title) throws Exception;

    public ArrayList<sendFeedback> getMessageOfTitle(String title) throws Exception;

}
