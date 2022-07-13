package dao;

import entity.RequestMessage;
import java.util.ArrayList;

public interface RequestMessageDAO {

    public ArrayList<RequestMessage> getMessage() throws Exception;

    public ArrayList<RequestMessage> getMessageUnread() throws Exception;

    public void insert(RequestMessage message) throws Exception;

    public int updateRead(int id, String isRead) throws Exception;

    public RequestMessage getMessageById(int Id) throws Exception;

    public void delete(int id) throws Exception;

    public ArrayList<RequestMessage> pagingMessage(int index) throws Exception;

    public ArrayList<RequestMessage> searchName(int index, String title) throws Exception;

    public ArrayList<RequestMessage> getMessageOfTitle(String title) throws Exception;

}
