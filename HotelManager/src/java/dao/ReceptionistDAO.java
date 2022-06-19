/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.User;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public interface ReceptionistDAO {
    public Vector<User> getCustomerListByReceptionist() throws Exception;
    public Vector<User> getSearchNameCustomerListByReceptionist(String uName) throws Exception ;

    public void insertReceptionist(User User) throws Exception;

    public void updateCustomerByReceptionist(User User) throws Exception;
    
    public User getReceptionist(int uid) throws Exception;
}
