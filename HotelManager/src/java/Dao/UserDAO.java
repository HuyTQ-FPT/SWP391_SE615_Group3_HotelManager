/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.User;
import java.util.Vector;


public interface UserDAO {
    
    public Vector<User> getUserList() throws Exception;

    public void insertUser(User User) throws Exception;

<<<<<<< Updated upstream
    public void updateUser(User User);
    public void updateUserEcept(User User) throws Exception;
=======
    public void updateUser(User User) throws Exception;
>>>>>>> Stashed changes

    public void deleteUser(int uid) throws Exception;
    
<<<<<<< Updated upstream
    public User getUser(int accountID) throws Exception;
=======
    public User getUser(int uid) throws Exception;
>>>>>>> Stashed changes
}
