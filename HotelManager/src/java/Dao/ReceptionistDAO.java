/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.User;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public interface ReceptionistDAO {
    public Vector<User> getCustomerListByReceptionist();
    public Vector<User> getSearchNameCustomerListByReceptionist(String uName) ;

    public void insertReceptionist(User User);

    public void updateCustomerByReceptionist(User User);
    
    public User getReceptionist(int uid);
}
