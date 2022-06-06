/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.impl;

import Dao.UserDAO;
import Entity.User;
import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class UserDAOImpl extends DBContext implements UserDAO{

    @Override
    public Vector<User> getUserList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertUser(User User) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateUser(User User) {
        String sqlPre = "update [User] set UserName =?, UserAdress=?, ImgCMT=?,UserEmail =?, UserPhone=?, UserGender=?, Birthday=? where UserID=?";

        try {
            //System.out.println(sql);
//        create statement: execute sql
            PreparedStatement pre = conn.prepareStatement(sqlPre);
            pre.setString(1, User.getUserName());
            pre.setString(2, User.getUserAdress());
            pre.setString(3, User.getImgCMT());
            pre.setString(4, User.getUserEmail());
            pre.setString(5, User.getUserPhone());
            pre.setInt(6, User.getUserGender());
            pre.setString(7, User.getBirthday());
            pre.setInt(8, User.getUserID());

            //run
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int uid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUser(int uid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
