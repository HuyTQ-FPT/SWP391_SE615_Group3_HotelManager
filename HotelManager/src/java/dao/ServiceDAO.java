
package dao;

import entity.Service;
import java.util.Vector;

public interface ServiceDAO {
    public Vector<Service> getServiceList();
    
    public Vector<Service> getServiceListbyran();
    
    public Service getServicedetail(String sid);

    public void insertService(Service Service);

    public void updateService(Service Service);

    public void deleteService(int sid);

}
