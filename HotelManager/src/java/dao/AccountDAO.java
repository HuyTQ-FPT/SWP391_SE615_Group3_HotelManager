package dao;

import entity.Account;
import entity.User;
import java.util.ArrayList;

public interface AccountDAO {

    public ArrayList<Account> getAccountList() throws Exception;

    public Account getAccount(String aName, String aPass) throws Exception;

    public void insertAccount(int aRole, String aName, String aPass) throws Exception;

    public int updateAccount(String aUser, String aPassword) throws Exception;

    public void deleteAccount(String aName) throws Exception;

    public Account checkAccount(String aName) throws Exception;

    public ArrayList<Account> getAccountByRole(int aRole) throws Exception;

    public int Register(Account ac, String name, String email) throws Exception;

    public int updateAccountAndUser(String aPassword, String uGmail) throws Exception;
    public void updateRole(int RoleID, String user);
}
