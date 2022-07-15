package dao.impl;

import dao.ServiceDAO;
import entity.Service;
import context.DBContext;
import entity.FeedBackService;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

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

    @Override
    public Vector<FeedBackService> getFeedBackBySeviceID(String Sql) {
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

    @Override
    public void insertCommentService(String ServiceID, String AccountID, String Comment) {
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

    @Override
    public void DeleteComnent(String CommentID) {
        String query = "UPDATE [dbo].[FeedBackService]\n"
                + "   SET [Status] = 1 \n"
                + " WHERE CommentID = ? ";
        try {
            PreparedStatement pre = conn.prepareStatement(query);
            pre.setString(1, CommentID);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        ServiceDAOImpl dao = new ServiceDAOImpl();
//        dao.insertCommentService("1", "1", "dịch vụ raasst tốt");
        Vector<FeedBackService> fe = dao.getFeedBackBySeviceID("select * from FeedBackService join [User] on FeedBackService.AccountID = [User].AccountID where ServiceID = 1 ");
        for (FeedBackService feedBackService : fe) {
            System.out.println(feedBackService);
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

    @Override
    public void insertService(String ServiceName, String ServiceImage, String ServiceDes, String ServicePrice) {
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

    @Override
    public void updateService(String ServiceName, String ServiceImage, String ServiceDes, String ServicePrice, String ServiceID) {
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
