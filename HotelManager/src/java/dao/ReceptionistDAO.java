package dao;

import entity.User;
import java.util.Vector;

/**
 *
 * @author Minh Hiếu
 */
public interface ReceptionistDAO {
    public Vector<User> getCustomerListByReceptionist() throws Exception;
    public Vector<User> getSearchNameCustomerListByReceptionist(String uName) throws Exception ;

    public void insertReceptionist(User User) throws Exception;

    public void updateCustomerByReceptionist(User User) throws Exception;
    
    public User getReceptionist(int uid) throws Exception;
}
