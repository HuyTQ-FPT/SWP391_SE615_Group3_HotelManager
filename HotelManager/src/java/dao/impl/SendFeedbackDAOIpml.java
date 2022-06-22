package dao.impl;

import dao.SendFeedback;
import entity.sendFeedback;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Minh Hiếu
 */
public class SendFeedbackDAOIpml extends DBContext implements SendFeedback {

    @Override
    public Vector<sendFeedback> getMessage() throws Exception {
        Vector<sendFeedback> v = new Vector<>();
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        String sql = "select * from [MessageRequest] order by mId asc";
        try {
            conn = getConnection();
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

    @Override
    public void insert(sendFeedback message) throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        String sql = "INSERT INTO [MessageRequest] VALUES (?,?,?,0)";
        try {
            conn = getConnection();
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
            closeConnection(conn);
        }
    }

    @Override
    public int updateRead(int id, String isread) throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        int n = 0;
        String sql = " UPDATE [SWPgroup3].[dbo].[MessageRequest] SET [isRead] = ?  WHERE [mId] = ?";
        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            pre.setString(1, "1");
            pre.setInt(2, id);
            n = pre.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }
        return n;
    }

    @Override
    public sendFeedback getMessageById(int Id) throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        sendFeedback message = new sendFeedback();
        String sql = "select * from [MessageRequest] where mId=" + Id;
        try {
            conn = getConnection();
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
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        String sql = "DELETE FROM [SWPgroup3].[dbo].[MessageRequest]\n"
                + " WHERE mId=" + id;
        try {
            conn = getConnection();
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
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        String sql = "  select * from [MessageRequest] where isRead=0";
        try {
            conn = getConnection();
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

    @Override
    public Vector<sendFeedback> pagingMessage(int index) throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        Vector<sendFeedback> vector = new Vector<>();
        String sql = "select * from \n"
                + "(select ROW_NUMBER() over (order by mId asc) as r, * from dbo.[MessageRequest]) \n"
                + "as x\n"
                + "where r between ? and ?";
        //get informations from database
        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, index * 3 - 2);
            pre.setInt(2, index * 3);
            rs = pre.executeQuery();
            while (rs.next()) {
                vector.add(new sendFeedback(rs.getInt("mId"), rs.getString("title"), rs.getString("email"), rs.getString("content"), rs.getString("isRead")));
            }
        } catch (Exception e) {
            throw e;

        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }

        return vector;
    }

    @Override
    public Vector<sendFeedback> searchName(int index, String title) throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        Vector<sendFeedback> v = new Vector<>();
        String sql = "select * from \n"
                + "(select ROW_NUMBER() over (order by mId asc) as r, * from dbo.[MessageRequest]) \n"
                + "as x\n"
                + "where r between ? and ? and x.title like '%" + title + "%'";
        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, index * 3 - 2);
            pre.setInt(2, index * 3);
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
    public static void main(String[] args) {
        SendFeedbackDAOIpml s = new SendFeedbackDAOIpml();
        try {
            Vector<sendFeedback> k = s.searchName(1, "swp");
            for (sendFeedback feedback : k) {
                System.out.println(feedback);
                
            }
        } catch (Exception e) {
        }
    }

    @Override
    public Vector<sendFeedback> getMessageOfTitle(String title) throws Exception {
        Vector<sendFeedback> v = new Vector<>();
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        String sql = "select * from [MessageRequest] where title like '%" + title + "%'  order by mId asc";
        try {
            conn = getConnection();
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
