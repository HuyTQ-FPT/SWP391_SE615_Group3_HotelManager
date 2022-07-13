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

import entity.Account;
import java.util.ArrayList;

/**
 * Lớp này chứa các interface của AccountDAOImpl
 *
 * @author
 */
public interface AccountDAO {

    /**
     * Get all Account from database
     *
     * @return a list of <code>Account</code> objects. It is a
     * <code>java.util.ArrayList</code> object
     * @throws java.lang.Exception
     */
    public ArrayList<Account> getAccountList() throws Exception;

    /**
     * get user from Account table Using mail and password
     *
     * @param aName is an String
     * @param aPass is an String
     * @return <code>Account</code> object.
     * @throws java.lang.Exception
     */
    public Account getAccount(String aName, String aPass) throws Exception;

    public void insertAccount(int aRole, String aName, String aPass) throws Exception;

    public int updateAccount(String aUser, String aPassword) throws Exception;

    public void deleteAccount(String aName) throws Exception;

    /**
     * checks name to get user's information
     *
     * @param aName is an String
     * @return <code>Account</code> object.
     * @throws java.lang.Exception
     */
    public Account checkAccount(String aName) throws Exception;

    public ArrayList<Account> getAccountByRole(int aRole) throws Exception;

    public int Register(Account ac, String name, String email) throws Exception;

    public int updateAccountAndUser(String aPassword, String uGmail) throws Exception;

    public void updateRole(int RoleID, String user);
}
