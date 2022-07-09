
package dao;

import entity.Notification;
import java.util.ArrayList;

/**
 *
 * Tran Quang Huy
 */
public interface NotificationDAO {
    public void insertNotification(Notification n) throws Exception;
    public void insertMessageadmin(Notification n) throws Exception;
    public void deleteNotification(int nID) throws Exception;
    public ArrayList<Notification> getAllNotification() throws Exception;
    public ArrayList<Notification> getMessagedmin(String nameAccount) throws Exception;
    
}
