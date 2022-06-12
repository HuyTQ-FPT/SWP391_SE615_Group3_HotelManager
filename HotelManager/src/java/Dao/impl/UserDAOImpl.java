/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.impl;

import Dao.UserDAO;
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
public class UserDAOImpl extends DBContext implements UserDAO {

    @Override
    public Vector<User> getUserList() throws Exception {
        return null;

    }

    @Override
    public void insertUser(User User) throws Exception {

    }

    @Override
    public int updateUser(User User) throws Exception {
        int n = 0;
        String sqlPre = "update [User] set UserName =?, UserAdress=?, CMT=?,UserEmail =?, UserPhone=?, UserGender=?, Birthday=? where UserID=?";

        try {
            //System.out.println(sql);
//        create statement: execute sql
            PreparedStatement pre = conn.prepareStatement(sqlPre);
            pre.setString(1, User.getUserName());
            pre.setString(2, User.getUserAdress());
            pre.setString(3, User.getCMT());
            pre.setString(4, User.getUserEmail());
            pre.setString(5, User.getUserPhone());
            pre.setInt(6, User.getUserGender());
            pre.setString(7, User.getBirthday());
            pre.setInt(8, User.getUserID());

            //run
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    @Override
    public void deleteUser(int uid) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override

    public User getUser(int accountID) throws Exception {
        String sql = "select * from [User] where AccountID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, accountID);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
            }

        } catch (Exception e) {
            throw e;
        }
        return null;
    }
    public static void main(String[] args) {
        UserDAOImpl u = new UserDAOImpl();
        try {
            User k = u.getUser(9);
            System.out.println(k);
        } catch (Exception ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateUserEcept(User User) throws Exception {
        String sqlPre = "update [User] set UserName =?, UserAdress=?, CMT=?,UserEmail =?, UserPhone=?,Birthday=? where UserID=?";

        try {
            //System.out.println(sql);
//        create statement: execute sql
            PreparedStatement pre = conn.prepareStatement(sqlPre);
            pre.setString(1, User.getUserName());
            pre.setString(2, User.getUserAdress());
            pre.setString(3, User.getCMT());
            pre.setString(4, User.getUserEmail());
            pre.setString(5, User.getUserPhone());
            pre.setInt(6, User.getUserGender());
            pre.setInt(7, User.getUserID());
            //run
            pre.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public boolean isNumeric(String str) throws Exception {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public User checkUser(String uGmail) throws Exception {
        String sql = "select * from [User] \n"
                + " where UserEmail=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setString(1, uGmail);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {

                return new User(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
            }

        } catch (Exception e) {
            throw e;
        }
        return null;
    }

//    public static void main(String[] args) {
//        UserDAOImpl u = new UserDAOImpl();
//        try {
//            User k = u.checkUser("lebaminhhieuyh@gmail.com");
//            System.out.println(k);
//        } catch (Exception ex) {
//
//            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

    @Override
    public User checkPhone(String uPhone) throws Exception {
         String sql = "select * from [User] \n"
                + " where UserPhone=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setString(1, uPhone);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {

                return new User(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10));
            }

        } catch (Exception e) {
            throw e;
        }
        return null;
    }
}
