/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.impl;

import Dao.ImageDAO;
import Entity.Image;
import context.DBContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public class ImageDAOImpl extends DBContext implements ImageDAO {

    @Override
    public Vector<Image> getAllImage() {
//        String sql = "select TOP(6)* from Image";
//        Vector<Image> vector = new Vector<Image>();
//        try {
//            ResultSet rs = getData(sql);
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String image1 = rs.getString(2);
//                String image2 = rs.getString(3);
//                String image3 = rs.getString(4);
//                String image4 = rs.getString(5);
//
//                Image im=new Image(id, image1, image2, image3, image4);
//                vector.add(im);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return vector;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public void insertImage(int riID, Image insertImage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateImage(int riID, Image updateImage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteImage(int riID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
