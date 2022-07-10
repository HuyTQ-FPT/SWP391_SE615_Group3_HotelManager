
package dao.impl;

import context.DBContext;
import dao.NotificationDAO;
import entity.Notification;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NotificationDAOImpl extends DBContext implements NotificationDAO{

    @Override
    public void insertNotification(Notification n) throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        
        String sql = "insert into Notification values(?,?,?,?,?,0)";
          try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            
            pre.setString(1, n.getTitle());
            pre.setString(2, n.getName());
            pre.setString(3, n.getFocus());
            pre.setString(4, n.getContent());
            pre.setString(5, n.getDate());
            pre.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally {
            closePreparedStatement(pre);
            closeConnection(conn);
        }
    }
    @Override
    public void insertMessageadmin(Notification n) throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;       
        String sql = "insert into Notification values(?,?,'0',?,?,1)";
          try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            
            pre.setString(1, n.getTitle());
            pre.setString(2, n.getName());
            pre.setString(3, n.getContent());
            pre.setString(4, n.getDate());
            pre.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally {
            closePreparedStatement(pre);
            closeConnection(conn);
        }
    }
    @Override
    public ArrayList<Notification> getAllNotification() throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        ArrayList<Notification> vector = new ArrayList<>();
        try {
            String sql = "select * from Notification where Status=0 order by NID desc";
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();

            while (rs.next()) {
                int Nid =rs.getInt(1);
                String title = rs.getString(2);
                String name = rs.getString(3);
                String focus = rs.getString(4);
                String content = rs.getString(5);
                String date = rs.getString(6);
                Notification n=new Notification(Nid,title, name, focus, content, date);
                vector.add(n);
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
    public ArrayList<Notification> getMessagedmin(String nameAccount) throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        ArrayList<Notification> vector = new ArrayList<>();
        try {
            String sql = "select * from Notification where Status=1 and Name='"+nameAccount+"' order by NID desc";
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();

            while (rs.next()) {
                int Nid =rs.getInt(1);
                String title = rs.getString(2);
                String name = rs.getString(3);
                String focus = rs.getString(4);
                String content = rs.getString(5);
                String date = rs.getString(6);
                Notification n=new Notification(Nid,title, name, focus, content, date);
                vector.add(n);
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
    public void deleteNotification(int nID) throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        
        String sql = "delete from Notification where NID="+nID;
          try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            pre.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally {
            closePreparedStatement(pre);
            closeConnection(conn);
        }    }
    
}
