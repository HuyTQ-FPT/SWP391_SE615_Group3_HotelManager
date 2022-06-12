/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.impl;

import Dao.AccountDAO;
import Entity.Account;
import Entity.User;
import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class AccountDAOImpl extends DBContext implements AccountDAO {

    @Override
    public Vector<Account> getAccountList(int aID) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account getAccount(String aName, String aPass) {
        String sql = "SELECT * FROM [SWPgroup3].[dbo].[Account] where [user]=? and [password]=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, aName);
            pre.setString(2, aPass);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertAccount(int aRole, String aName, String aPass) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateAccount(String aUser, String aPassword) throws Exception {
        int n = 0;
        String sql = "UPDATE [SWPgroup3].[dbo].[Account]\n"
                + "   SET [password] =?\n"
                + " WHERE [user]=?";
        try {

            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setString(1, aPassword);
            pre.setString(2, aUser);

            //run
            n = pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public void deleteAccount(String aName) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account checkAccount(String aName) {
        try {
            String xSql = "select * from [Account] where [user]=?";

            PreparedStatement ps = conn.prepareStatement(xSql);
            ps.setString(1, aName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        AccountDAOImpl ac = new AccountDAOImpl();
        try {
            int n = ac.updateAccountAndUser("2aasdasefgsdfgsdfgsdfgdascd", "lebaminhhieuyh@gmail.com");
            if(n>0){
                 System.out.println("ok");
            }
            else{
                 System.out.println("di");
            }
              
        } catch (Exception ex) {
            Logger.getLogger(AccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

    @Override
    public Vector<Account> getAccountByRole(int aRole) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int Register(Account ac, String name, String email) {
        int n = 0;
        String sql = "insert into Account(RoleID, [user],[password]) values(1,?,?)";
        String sql1 = "insert into [User](AccountID,UserName, UserEmail) values(?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            PreparedStatement pre1 = conn.prepareStatement(sql1);
            pre.setString(1, ac.getUser());
            pre.setString(2, ac.getPassword());
            n = pre.executeUpdate();
            ResultSet rs = getData("select top(1)* from Account\n"
                    + "order by AccountID desc ");
            while (rs.next()) {
                pre1.setInt(1, rs.getInt(1));
            }
            pre1.setString(2, name);
            pre1.setString(3, email);
            pre1.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int updateAccountAndUser(String aPassword, String uGmail) throws Exception {
        int n = 0;
        try {
            String sql = "UPDATE [Account] set password=? from [Account] ac, [User] u\n"
                    + " where ac.AccountID=u.AccountID and u.UserEmail=?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, aPassword);
            pre.setString(2, uGmail);

            n = pre.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
        return n;
    }
    

}
