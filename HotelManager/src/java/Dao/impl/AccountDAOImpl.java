/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.impl;

import Dao.AccountDAO;
import Entity.Account;
import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class AccountDAOImpl extends DBContext implements AccountDAO {

    @Override
    public Vector<Account> getAccountList(int aID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account getAccount(String aName, String aPass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertAccount(int aRole, String aName, String aPass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateAccount(String aUser, String aPassword) {
        String sql = "UPDATE [SWPgroup3].[dbo].[Account]\n"
                + "   SET [password] =?\n"
                + " WHERE [user]=?";
        try {

            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setString(1, aPassword);
            pre.setString(2, aUser);

            //run
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(String aName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account checkAccount(String aName) {
        String xSql = "select * from [Account] where [user]=?";

        try {
            PreparedStatement ps = conn.prepareStatement(xSql);
            ps.setString(1, aName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Vector<Account> getAccountByRole(int aRole) {
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

}
