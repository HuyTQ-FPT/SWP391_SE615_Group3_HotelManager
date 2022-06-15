/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.impl;

import Dao.SendFeedback;
import Entity.sendFeedback;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class SendFeedbackDAOIpml extends DBContext implements SendFeedback {

    @Override
    public Vector<sendFeedback> getMessage() throws Exception {
        Vector<sendFeedback> v = new Vector<>();
        PreparedStatement pre = null;
        ResultSet rs = null;
        String sql = "select * from [MessageFeedBack] order by mId asc";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                v.add(new sendFeedback(rs.getInt("mId"), rs.getString("title"), rs.getString("email"), rs.getString("content"), rs.getString("isRead")));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);

        }
        return v;
    }

    public static void main(String[] args) {
        Vector<sendFeedback> v = new Vector<>();
        SendFeedbackDAOIpml s = new SendFeedbackDAOIpml();
        try {

            sendFeedback k = s.getMessageById(14);
            System.out.println(k);

        } catch (Exception ex) {
            Logger.getLogger(SendFeedbackDAOIpml.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void insert(sendFeedback message) throws Exception {

        PreparedStatement pre = null;
        ResultSet rs = null;
        String sql = "INSERT INTO [MessageFeedBack] VALUES (?,?,?,0)";
        try {

            pre = conn.prepareStatement(sql);
            pre.setString(1, message.getTitle());
            pre.setString(2, message.getEmail());
            pre.setString(3, message.getContent());
            pre.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);

        }
    }

    @Override
    public void updateRead(int id, String isread) throws Exception {
        PreparedStatement pre = null;
        ResultSet rs = null;
        Connection conn = null;
        String sql = " UPDATE [SWPgroup3].[dbo].[MessageFeedBack] SET [isRead] = ?  WHERE [mId] = ?";
        try {
            pre = conn.prepareStatement(sql);
            pre.setString(1, "1");
            pre.setInt(2, id);
            pre.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }
    }

    @Override
    public sendFeedback getMessageById(int Id) throws Exception {

        PreparedStatement pre = null;
        ResultSet rs = null;
        Connection conn = null;
        sendFeedback message = new sendFeedback();
        String sql = "select * from [MessageFeedBack] where mId=" + Id;
        try {

            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                message.setmId(rs.getInt("mId"));
                message.setTitle(rs.getString("title"));
                message.setEmail(rs.getString("email"));
                message.setContent(rs.getString("content"));
                message.setIsRead("1");
            }

        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }
        return message;
    }

    @Override
    public void delete(int id) throws Exception {
        PreparedStatement pre = null;
        ResultSet rs = null;
        Connection conn = null;
        String sql = "DELETE FROM [SWPgroup3].[dbo].[MessageFeedBack]\n"
                + " WHERE mId=" + id;
        try {
            pre = conn.prepareStatement(sql);

            pre.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);
        }
    }

    @Override
    public Vector<sendFeedback> getMessageUnread() throws Exception {
        Vector<sendFeedback> v = new Vector<>();
        PreparedStatement pre = null;
        ResultSet rs = null;
        Connection conn = null;
        String sql = "  select * from [MessageFeedBack] where isRead=0";
        try {
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                v.add(new sendFeedback(rs.getInt("mId"), rs.getString("title"), rs.getString("email"), rs.getString("content"), rs.getString("isRead")));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);
        }
        return v;
    }

}
