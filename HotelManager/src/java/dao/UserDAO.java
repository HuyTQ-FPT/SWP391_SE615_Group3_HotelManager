/*
 * Copyright (C) 2022, FPT University
 * SWP391 - SE1615 - Group3
 * HotelManager
 *
 * Record of change:
 * DATE          Version    Author           DESCRIPTION
 *               1.0                         First Deploy
 * 13/07/2022    1.0        HieuLBM          Comment
 */
package dao;

import entity.User;
import java.util.ArrayList;

/**
 * Lớp này chứa các interface của UserDAOImpl
 *
 * @author
 */
public interface UserDAO {

    public ArrayList<User> getUserList() throws Exception;

    public void insertUser(User User) throws Exception;

    /**
     * update a user from User table
     *
     * @param User is a <code>User</code> object
     * @throws java.lang.Exception
     */
    public void updateUserEcept(User User) throws Exception;

    public int updateUser(User User) throws Exception;

    public void deleteUser(int uid) throws Exception;

    /**
     * get a customer information from User table
     *
     * @param accountID is an int
     * @return <code>User</code> object.
     * @throws java.lang.Exception
     */
    public User getUser(int accountID) throws Exception;

    public User getUserByaID(int accountID) throws Exception;

    public boolean isNumeric(String str) throws Exception;

    /**
     * Check customer information by email from User table
     *
     * @param uGmail is an <code>User</code> object
     * @return <code>User</code> object.
     * @throws java.lang.Exception
     */
    public User checkUser(String uGmail) throws Exception;

    /**
     * get a list of all customers from the Users table
     *
     * @return <code>ArrayList<User></code> object.
     * @throws java.lang.Exception
     */
    public ArrayList<User> getCustomerListByReceptionist() throws Exception;

    /**
     * search name from the Users table
     *
     * @param uName is an String
     * @return <code>ArrayList<User></code> object.
     * @throws java.lang.Exception
     */
    public ArrayList<User> getSearchNameCustomerListByReceptionist(String uName) throws Exception;

    /**
     * get all User by roleID=2 from the Users table
     *
     * @return <code>ArrayList<User></code> object.
     * @throws java.lang.Exception
     */
    public ArrayList<User> getListByReceptionist() throws Exception;

}
