package dao;

import entity.User;
import java.util.ArrayList;

public interface UserDAO {

    public ArrayList<User> getUserList() throws Exception;

    public void insertUser(User User) throws Exception;

    public void updateUserEcept(User User) throws Exception;

    public int updateUser(User User) throws Exception;

    public void deleteUser(int uid) throws Exception;

    public User getUser(int accountID) throws Exception;
    
    public User getUserByaID(int accountID) throws Exception;

    public boolean isNumeric(String str) throws Exception;

    public User checkUser(String uGmail) throws Exception;

  
}
