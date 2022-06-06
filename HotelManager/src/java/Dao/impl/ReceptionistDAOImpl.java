/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.impl;

import Dao.ReceptionistDAO;
import Entity.User;
import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author Minh Hiếu
 */
public class ReceptionistDAOImpl extends DBContext implements ReceptionistDAO {

    @Override
    public Vector<User> getCustomerListByReceptionist() {
        Vector<User> vector = new Vector<>();
        try {
            String sql = "select u.*  from Account c inner join [User] u on c.AccountID = u.AccountID\n"
                    + "where c.RoleID=1";

            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();

            while (rs.next()) {
                int uID = rs.getInt(1);
                int uAID = rs.getInt(2);
                String uName = rs.getString(3);
                String uPhone = rs.getString(4);
                String uEmail = rs.getString(5);
                int uGender = rs.getInt(6);
                String uImage = rs.getString(7);
                String uAdress = rs.getString(8);
                String uCMT = rs.getString(9);
                String uImgCmt = rs.getString(10);

                User u = new User(uID, uAID, uName, uPhone, uEmail, uGender, uImage, uAdress, uCMT, uImgCmt);
                vector.add(u);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return vector;

    }

    public static void main(String[] args) {
        ReceptionistDAOImpl r = new ReceptionistDAOImpl();
        Vector<User> u = r.getCustomerListByReceptionist();
        r.updateCustomerByReceptionist(new User(1, 1, "HieuMinh", "0376505417", "Lebaminheiuyh@gmail.com", 1, "user1.jpg", "Hieulbm", "0123456778", "user1.jpg"));
//        for (User user : u) {
//            System.out.println(user);
//
//        }
    }

    @Override
    public void insertReceptionist(User User) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateCustomerByReceptionist(User User) {
        int n = 0;
        String sql = "UPDATE [SWPgroup3].[dbo].[User]\n"
                + "   SET \n"
                + "      [AccountID] = ?\n"
                + "      ,[UserName] = ?\n"
                + "      ,[UserPhone] = ?\n"
                + "      ,[UserEmail] = ?\n"
                + "      ,[UserGender] = ?\n"
                + "      ,[UserImage] = ?\n"
                + "      ,[UserAdress] = ?\n"
                + "      ,[CMT] = ?\n"
                + "      ,[ImgCMT] = ?\n"
                + " WHERE [User].UserID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);

            pre.setInt(1, User.getAccountID());
            pre.setString(2, User.getUserName());
            pre.setString(3, User.getUserPhone());
            pre.setString(4, User.getUserEmail());
            pre.setInt(5, User.getUserGender());
            pre.setString(6, User.getUserImage());
            pre.setString(7, User.getUserAdress());
            pre.setString(8, User.getCMT());
            pre.setString(9, User.getImgCMT());
            pre.setInt(10, User.getUserID());

             pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }

    @Override
    public User getReceptionist(int uid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
