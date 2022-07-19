package dao.impl;

import dao.ServiceDAO;
import entity.Service;
import context.DBContext;
import entity.FeedBackService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceDAOImpl extends DBContext implements ServiceDAO {

    @Override
    public Vector<Service> getServiceList() {
        String sql = "Select * from Service";
        Vector<Service> vector = new Vector<Service>();
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int ServiceID = rs.getInt(1);
                String ServiceName = rs.getString(2);
                String ServiceImage = rs.getString(3);
                String ServiceDes = rs.getString(4);
                String ServiceNote = rs.getString(5);
                double ServicePrice = rs.getDouble(6);
                Service ser = new Service(ServiceID, ServiceName, ServiceImage, ServiceDes, ServiceNote, ServicePrice);
                vector.add(ser);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    /**
     * get list feedback by sql FeedbackService table
     *
     * @param getFeedBackBySeviceID
     * @return
     * @throws Exception
     */
    @Override
    public Vector<FeedBackService> getFeedBackBySeviceID(String Sql) throws Exception {

        Vector<FeedBackService> vector = new Vector<FeedBackService>();
        try {
            ResultSet rs = getData(Sql);
            while (rs.next()) {
                int ServiceID = rs.getInt(1);
                int AccountID = rs.getInt(2);
                Date Dates = rs.getDate(3);
                String Comment = rs.getString(4);
                int Status = rs.getInt(5);
                int CommentID = rs.getInt(7);
                String Note = rs.getString(10);
                FeedBackService ser = new FeedBackService(CommentID, ServiceID, AccountID, Dates, Comment, Status, Note);
                vector.add(ser);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    /**
     * insertCommentService from FeedbackService table
     *
     * @param insertCommentService
     * @return
     * @throws Exception
     */
    @Override
    public void insertCommentService(String ServiceID, String AccountID, String Comment) throws Exception {

        String query = "INSERT INTO [dbo].[FeedBackService]\n"
                + "           ([ServiceID]\n"
                + "           ,[AccountID]\n"
                + "           ,[Date]\n"
                + "           ,[Comment]\n"
                + "           ,[Status]\n"
                + "           ,[Note])\n"
                + "     VALUES\n"
                + "           (?,?,GETDATE(),?,0,'')";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, ServiceID);
            pre.setString(2, AccountID);
            pre.setString(3, Comment);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Block Comnent from FeedbackService table
     *
     * @param DeleteComnent
     * @return
     * @throws Exception
     */
    @Override
    public void BlockComnent(String CommentID) throws Exception {
        /* Prepared statement for executing sql queries */
        PreparedStatement pre = null;
        String query = "UPDATE [dbo].[FeedBackService]\n"
                + "   SET [Status] = 1 \n"
                + " WHERE CommentID = ? ";
        try {
            pre = conn.prepareStatement(query);
            pre.setString(1, CommentID);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closePreparedStatement(pre);
            closeConnection(conn);
        }
    }

    /**
     * Unblock Comnent from FeedbackService table
     *
     * @param DeleteComnent
     * @return
     * @throws Exception
     */
    @Override
    public void UnblockComment(String CommentID) throws Exception {

        String query = "UPDATE [dbo].[FeedBackService]\n"
                + "   SET [Status] = 0 \n"
                + " WHERE CommentID = ? ";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, CommentID);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get rand Service
     *
     * @param getServiceListbyran
     * @return
     * @throws Exception
     */
    @Override
    public Vector<Service> getServiceListbyran() {
        String sql = "select top(5) * from Service\n"
                + "ORDER BY NEWID()";
        Vector<Service> vector = new Vector<Service>();
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int ServiceID = rs.getInt(1);
                String ServiceName = rs.getString(2);
                String ServiceImage = rs.getString(3);
                String ServiceDes = rs.getString(4);
                String ServiceNote = rs.getString(5);
                double ServicePrice = rs.getDouble(6);
                Service ser = new Service(ServiceID, ServiceName, ServiceImage, ServiceDes, ServiceNote, ServicePrice);
                vector.add(ser);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public static void main(String[] args) {
        try {
            ServiceDAOImpl dao = new ServiceDAOImpl();

            Service se = dao.getLastService();
//        dao.insertCommentService("1", "1", "dịch vụ raasst tốt");
            Vector<Service> fe = dao.getServiceListbyran();
            for (Service feedBackService : fe) {
                System.out.println(feedBackService);
//            System.out.println(se);
            }
        } catch (Exception ex) {
            Logger.getLogger(ServiceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Service getServicedetail(String sid) {
        String query = "select * from Service where ServiceID =?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, sid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Service(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * Insert Service in Service Table
     *
     * @param updateService
     * @return
     * @throws Exception
     */
    @Override
    public void insertService(String ServiceName, String ServiceImage, String ServiceDes, String ServicePrice) throws Exception {

        String query = "INSERT INTO [dbo].[Service]\n"
                + "           ([ServiceName]\n"
                + "           ,[ServiceImage]\n"
                + "           ,[ServiceDes]\n"
                + "           ,[ServiceNote]\n"
                + "           ,[ServicePrice])\n"
                + "     VALUES\n"
                + "           (?,?,?,'',?)";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, ServiceName);
            pre.setString(2, ServiceImage);
            pre.setString(3, ServiceDes);
            pre.setString(4, ServicePrice);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Update Service in Service Table
     *
     * @param updateService
     * @return
     * @throws Exception
     */
    @Override
    public void updateService(String ServiceName, String ServiceImage, String ServiceDes, String ServicePrice, String ServiceID) throws Exception {

        String query = "UPDATE [dbo].[Service]\n"
                + "   SET [ServiceName] = ?\n"
                + "      ,[ServiceImage] = ?\n"
                + "      ,[ServiceDes] = ?\n"
                + "      ,[ServiceNote] = ''\n"
                + "      ,[ServicePrice] = ?\n"
                + " WHERE ServiceID =  ?";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, ServiceName);
            pre.setString(2, ServiceImage);
            pre.setString(3, ServiceDes);
            pre.setString(4, ServicePrice);
            pre.setString(5, ServiceID);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * get Last Service from Service table
     *
     * @param getLastService
     * @return
     * @throws Exception
     */
    @Override
    public Service getLastService() throws Exception {

        String sql = "select top(1)* from Service order by ServiceID desc";
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int ServiceID = rs.getInt(1);
                String ServiceName = rs.getString(2);
                String ServiceImage = rs.getString(3);
                String ServiceDes = rs.getString(4);
                String ServiceNote = rs.getString(5);
                double ServicePrice = rs.getDouble(6);
                return new Service(ServiceID, ServiceName, ServiceImage, ServiceDes, ServiceNote, ServicePrice);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteService(String sql) {
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.executeUpdate();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
