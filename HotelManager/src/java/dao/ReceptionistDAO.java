package dao;

import entity.Reservation;
import entity.User;
import java.util.ArrayList;

public interface ReceptionistDAO {
    public ArrayList<User> getCustomerListByReceptionist() throws Exception;
    public ArrayList<User> getListByReceptionist() throws Exception;
    public ArrayList<User> getSearchNameCustomerListByReceptionist(String uName) throws Exception ;
    public void insertReceptionist(User User) throws Exception;
    public void updateCustomerByReceptionist(User User) throws Exception;
    public User getReceptionist(int uid) throws Exception;
    public Reservation viewOrderDetails(int uID) throws Exception;
    public ArrayList<Reservation> OrderDetails(int uID) throws Exception;
}
