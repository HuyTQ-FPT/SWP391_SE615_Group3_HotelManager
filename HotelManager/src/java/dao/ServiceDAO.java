package dao;

import entity.FeedBackService;
import entity.Service;
import java.util.Vector;

public interface ServiceDAO {

    public Vector<Service> getServiceList();

    public Vector<Service> getServiceListbyran();

    public Service getServicedetail(String sid);

    public void insertService(String ServiceName, String ServiceImage, String ServiceDes, String ServicePrice);

    public void updateService(String ServiceName, String ServiceImage, String ServiceDes, String ServicePrice, String ServiceID);

    public void deleteService(String sql);

    public Vector<FeedBackService> getFeedBackBySeviceID(String Sql) throws Exception;

    public void insertCommentService(String ServiceID, String AccountID, String Comment) throws Exception;
    public void BlockComnent(String CommentID) throws Exception;
    public void UnblockComment(String CommentID) throws Exception;
    public Service getLastService()  throws Exception;
}
