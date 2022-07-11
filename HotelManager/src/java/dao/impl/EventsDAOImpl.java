package dao.impl;

import context.DBContext;
import dao.EventsDAO;
import entity.Events;
import entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author admin
 */
public class EventsDAOImpl extends DBContext implements EventsDAO{

    @Override
    public ArrayList<Events> getEventsList() throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        Vector<Events> vector = new Vector<>();
        try {
            String sql = "select * from [Events]";
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();

            while (rs.next()) {
                int uID = rs.getInt(1);
                int uAID = rs.getInt(2);
                String uName = rs.getString(3);
                String uPhone = rs.getString(4);
                String uEmail = rs.getString(5);
                int uGender = rs.getInt(6);
                Date birthday = rs.getDate(7);
                String uAdress = rs.getString(8);
                String uCMT = rs.getString(9);
                String uImgCmt = rs.getString(10);

                User u = new User(uID, uAID, uName, uPhone, uEmail, uGender, birthday, uAdress, uCMT, uImgCmt);
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
    public void insertEvents(Events event) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateEvents(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteEvents(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
