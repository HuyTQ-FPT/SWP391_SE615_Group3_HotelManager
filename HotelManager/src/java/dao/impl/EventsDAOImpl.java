package dao.impl;

import context.DBContext;
import dao.EventsDAO;
import entity.Events;
import entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author admin
 */
public class EventsDAOImpl extends DBContext implements EventsDAO {

    @Override
    public Vector<Events> getEventsList() throws Exception {
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
                int eID = rs.getInt(1);
                String eName = rs.getString(2);
                String eImg = rs.getString(3);
                Date eDate = rs.getDate(4);
                String eCode = rs.getString(6);
                int quan = rs.getInt(7);
                Events i = new Events(eID, eName, eImg, eDate, eCode, quan);
                vector.add(i);
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
        int n = 0;
        Connection conn = null;
        PreparedStatement pre = null;
        String sql = "update [Events] set Quantity= Quantity-1\n"
                + "where EventId= "+id;
        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    @Override
    public void deleteEvents(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
