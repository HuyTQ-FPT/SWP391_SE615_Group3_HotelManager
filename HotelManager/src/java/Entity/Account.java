/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Admin
 */
public class Account {
    private int AccountID;
	private int RoleID;
	private String user;
	private String password;

    public Account() {
    }

    public Account(int AccountID, int RoleID, String user, String password) {
        this.AccountID = AccountID;
        this.RoleID = RoleID;
        this.user = user;
        this.password = password;
    }
    public Account(int RoleID, String user, String password) {
        this.AccountID = AccountID;
        this.RoleID = RoleID;
        this.user = user;
        this.password = password;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    public int getRoleID() {
        return RoleID;
    }

    public void setRoleID(int RoleID) {
        this.RoleID = RoleID;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" + "AccountID=" + AccountID + ", RoleID=" + RoleID + ", user=" + user + ", password=" + password + '}';
    }
        
}
