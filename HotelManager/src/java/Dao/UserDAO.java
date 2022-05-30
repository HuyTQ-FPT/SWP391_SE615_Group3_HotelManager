/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.User;
import java.util.Vector;


public interface UserDAO {
    
    public Vector<User> getUserList();

    public void insertUser(User User);

    public void updateUser(User User);

    public void deleteUser(int uid);
    
    public User getUser(int uid);
}
