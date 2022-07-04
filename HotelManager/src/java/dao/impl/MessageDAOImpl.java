
package dao.impl;

import entity.Message;
import context.DBContext;
import dao.MessageDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MessageDAOImpl extends DBContext implements MessageDAO{
    
    @Override
    public Vector<Message> getAllImage() throws Exception{
        return new Vector<>();
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
       
    }
}
