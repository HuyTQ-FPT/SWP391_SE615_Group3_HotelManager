/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Service;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public interface ServiceDAO {
    public Vector<Service> getServiceList();
    
    public Vector<Service> getServiceListbyran();
    
    public Service getServicedetail(String sid);

    public void insertService(Service Service);

    public void updateService(Service Service);

    public void deleteService(int sid);

}
