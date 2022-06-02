/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Account;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public interface AccountDAO {

    public Vector<Account> getAccountList(int aID);

    public Account getAccount(String aName, String aPass);

    public void insertAccount(int aRole, String aName, String aPass);

    public void updateAccount(String aUser, String aPassword);

    public void deleteAccount(String aName);

    public Account checkAccount(String aName);

    public Vector<Account> getAccountByRole(int aRole);
    
    public int Register(Account ac, String name,String email );

}
