
package dao.impl;

import entity.Message;
import context.DBContext;
import dao.MessageDAO;
import java.sql.PreparedStatement;
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
        String sql = "insert into Message values(?,'','',?,?,'incoming_msg',0)";
          try {
//        create statement: execute sql
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, mess.getAccountID());
            pre.setString(2, mess.getDate());
            pre.setString(3, mess.getContent());
                //run
                n = pre.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return n;
    }
    @Override
    public int insertFeedback(Message mess) throws Exception{
        int n = 0;
        String sql = "insert into Message values(?,'','',?,N'"+mess.getContent()+"','',?)";
          try {
//        create statement: execute sql
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, mess.getAccountID());
            pre.setString(2, mess.getDate());
            pre.setInt(3, mess.getRoomID());
                //run
                n = pre.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return n;
    }
    @Override
    public int insertMessageRe(Message mess) throws Exception {
        int n = 0;
        String sql = "insert into Message values(?,'','',?,?,'outgoing_msg',0)";
          try {
//        create statement: execute sql
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, mess.getAccountID());
            pre.setString(2, mess.getDate());
            pre.setString(3, mess.getContent());
                //run
                n = pre.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return n;
    }

    @Override
    public void updateMessage(int mID, Message updateMessage) throws Exception {
      
    }

    @Override
    public void deleteMessage(int mID) throws Exception {
       
    }
    public static void main(String[] args) {
        MessageDAOImpl dao =new MessageDAOImpl();
        try {
            dao.insertFeedback(new Message(1, "2022/06/29", "Phòng đẹp", 2));
        } catch (Exception ex) {
            Logger.getLogger(MessageDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
