/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;


import entity.Message;
import context.DBContext;
import dao.MessageDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;

public class MessageDAOImpl extends DBContext implements MessageDAO{

    @Override
    public Vector<Message> getAllImage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertMessageCus(Message mess) {
        int n = 0;
        String sql = "insert into Message values(?,'','',12/6/2022,?,'incoming_msg')";
          try {
            //System.out.println(sql);
//        create statement: execute sql
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, mess.getAccountID());
            pre.setString(2, mess.getContent());
                //run
                n = pre.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return n;
    }
    @Override
    public int insertMessageRe(Message mess) {
        int n = 0;
        String sql = "insert into Message values(?,'','',12/6/2022,?,'outgoing_msg')";
          try {
            //System.out.println(sql);
//        create statement: execute sql
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, mess.getAccountID());
            pre.setString(2, mess.getContent());
                //run
                n = pre.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return n;
    }

    @Override
    public void updateMessage(int mID, Message updateMessage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteMessage(int mID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        MessageDAOImpl dao =new MessageDAOImpl();
        dao.insertMessageCus(new Message(2,"chi tu van giup e duoc khong a?"));
    }
}
