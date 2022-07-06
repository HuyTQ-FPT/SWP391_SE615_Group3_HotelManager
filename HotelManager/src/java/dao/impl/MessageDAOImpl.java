
package dao.impl;

import entity.Message;
import context.DBContext;
import dao.MessageDAO;
import entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageDAOImpl extends DBContext implements MessageDAO{
    
    @Override
    public ArrayList<Message> getAllComment() throws Exception{
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        ArrayList<Message> vector = new ArrayList<>();
        try {
            String sql = "select * from Message where RoomID!=0";
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();

            while (rs.next()) {
                int MessageID = rs.getInt(1);
                int AccountID = rs.getInt(2);
                String Date = rs.getString(5);
                String Content = rs.getString(6);
                int RoomID = rs.getInt(8);

                Message u = new Message(MessageID,AccountID, Date, Content, RoomID);
                vector.add(u);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }
        return vector;
    }
    @Override
    public ArrayList<Integer> getAllAcccountMessage() throws Exception{
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        ArrayList<Integer> vector = new ArrayList<>();
        try {
            String sql = "select distinct AccountID from Message";
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();

            while (rs.next()) {
                int AccountID = rs.getInt(1);
                vector.add(AccountID);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }
        return vector;
    }
    
    @Override
    public int insertMessageCus(Message mess) throws Exception{
        int n = 0;
        Connection conn = null;
        PreparedStatement pre = null;
        
        String sql = "insert into Message values(?,'','',?,?,'incoming_msg',0)";
          try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            
            pre.setInt(1, mess.getAccountID());
            pre.setString(2, mess.getDate());
            pre.setString(3, mess.getContent());
                n = pre.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally {
            closePreparedStatement(pre);
            closeConnection(conn);

        }
            return n;
    }
  
    @Override
    public int insertNewmessagecus(Message mess) throws Exception{
        int n = 0;
        Connection conn = null;
        PreparedStatement pre = null;
        
        String sql = "insert into Message values(?,'1','',?,?,'incoming_msg',0)";
          try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            
            pre.setInt(1, mess.getAccountID());
            pre.setString(2, mess.getDate());
            pre.setString(3, mess.getContent());
                n = pre.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally {
            closePreparedStatement(pre);
            closeConnection(conn);

        }
            return n;
    }
  
    @Override
    public int insertFeedback(Message mess) throws Exception{
        int n = 0;
        Connection conn = null;
        PreparedStatement pre = null;
        String sql = "insert into Message values(?,'','',?,N'"+mess.getContent()+"','',?)";
          try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, mess.getAccountID());
            
            pre.setString(2, mess.getDate());
            pre.setInt(3, mess.getRoomID());
                n = pre.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally {
            closePreparedStatement(pre);
            closeConnection(conn);

        }
            return n;
    }
    @Override
    public int insertMessageRe(Message mess) throws Exception {
        int n = 0;
        Connection conn = null;
        PreparedStatement pre = null;
        String sql = "insert into Message values(?,'','',?,?,'outgoing_msg',0)";
          try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            pre = conn.prepareStatement(sql);
            pre.setInt(1, mess.getAccountID());
            pre.setString(2, mess.getDate());
            pre.setString(3, mess.getContent());
                n = pre.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally {

            closePreparedStatement(pre);
            closeConnection(conn);

        }
            return n;
    }

    @Override
    public void updateMessage(int mID, Message updateMessage) throws Exception {

    }

    @Override
    public void deleteMessage(int mID) throws Exception {
               Connection conn = null;
        PreparedStatement pre = null;
        String sql = "delete from Message where MessageID=?";
          try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, mID);

            pre.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally {

            closePreparedStatement(pre);
            closeConnection(conn);

        }
    }

    @Override
    public int getRoleIDByUserId(int userID) throws Exception {
        int roleID=0;
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        try {
            String sql = "select a.* from Account a join [User] u\n" +
"on a.AccountID=u.AccountID\n" +
"where u.UserID="+userID;
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();

            while (rs.next()) {
                roleID=rs.getInt(2);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }
        return roleID;
    }
    public static void main(String[] args) {
        MessageDAOImpl dao =new MessageDAOImpl();
        try {
            ArrayList<Integer> list=dao.getAllAcccountMessage();
            for (Integer integer : list) {
                System.out.println(integer);
            }
        } catch (Exception ex) {
            Logger.getLogger(MessageDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
