/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.impl;

import Dao.ServiceDAO;
import Entity.Service;
import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class ServiceDAOImpl extends DBContext implements ServiceDAO{

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
                double ServicePrice= rs.getDouble(6);
                Service ser= new Service(ServiceID, ServiceName, ServiceImage, ServiceDes, ServiceNote, ServicePrice);
                vector.add(ser);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
     public static void main(String[] args) {
        ServiceDAOImpl dao = new ServiceDAOImpl();
         Service se = dao.getServicedetail("1");
//        for (Service room : vector) {
            System.out.println(se);
//        }
    }

    @Override
    public Service getServicedetail(String sid) {
        String query = "  select * from Service where ServiceID =?";
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
    public void insertService(Service Service) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateService(Service Service) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteService(int sid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
