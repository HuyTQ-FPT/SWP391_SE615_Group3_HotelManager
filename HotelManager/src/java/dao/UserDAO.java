/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.User;
import java.util.Vector;

public interface UserDAO {

    public Vector<User> getUserList() throws Exception;

    public void insertUser(User User) throws Exception;

    public void updateUserEcept(User User) throws Exception;

    public int updateUser(User User) throws Exception;

    public void deleteUser(int uid) throws Exception;

    public User getUser(int accountID) throws Exception;

    public boolean isNumeric(String str) throws Exception;

    public User checkUser(String uGmail) throws Exception;

    public User checkPhone(String uPhone) throws Exception;

}
