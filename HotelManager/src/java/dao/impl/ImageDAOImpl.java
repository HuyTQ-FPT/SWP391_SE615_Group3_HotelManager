package dao.impl;

import dao.ImageDAO;
import entity.Image;
import entity.Room;
import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


public class ImageDAOImpl extends DBContext implements ImageDAO {

    @Override
    public Vector<Image> getImageByid(String Roomid) {
        String sql = "select i.RoomimgaeID, i.image1 , i.image2 ,i.image3 ,i.image4  from Image i join Room r on r.RoomimgaeID = i.RoomimgaeID where r.RoomimgaeID = ?";
        Vector<Image> vector = new Vector<Image>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Roomid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String image1 = rs.getString(2);
                String image2 = rs.getString(3);
                String image3 = rs.getString(4);
                String image4 = rs.getString(5);

                Image im = new Image(id, image1, image2, image3, image4);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;

    }

    public static void main(String[] args) {
        ImageDAOImpl dao = new ImageDAOImpl();
//        Vector<Image> vector = dao.getImageByid("1");
        Image img = dao.imageByID("select * from [image] join Room on [Image].RoomimgaeID = Room.RoomcateID where RoomID = 1");
//        dao.crudImage("UPDATE [dbo].[Image]\n"
//                + " SET [image1] = 'abc'\n"
//                + "      ,[image2] = 'abc'\n"
//                + "      ,[image3] = 'abc'\n"
//                + "      ,[image4] = 'abc'\n"
//                + " WHERE RoomimgaeID= 33");
//        for (Image image : vector) {
        System.out.println(img);
//        }
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

    @Override
    public Vector<Image> selectImage(String sql) {
        Vector<Image> vector = new Vector<Image>();
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int roomid = rs.getInt(1);
                String image1 = rs.getString(2);
                String image2 = rs.getString(2);
                String image3 = rs.getString(2);
                String image4 = rs.getString(2);
                Image im = new Image(roomid, image1, image2, image3, image4);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    @Override
    public Image imageByID(String sql) {
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int roomid = rs.getInt(1);
                String image1 = rs.getString(2);
                String image2 = rs.getString(3);
                String image3 = rs.getString(4);
                String image4 = rs.getString(5);
                return new Image(roomid, image1, image2, image3, image4);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void crudRoom(String sql , String des, String Notes) {
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
             pre.setString(1, des);
             pre.setString(2, Notes);
            pre.execute();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public void crudImage1(String sql,String title , String BlogDescription, String BlogAuthor) {
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
             pre.setString(1, title);
             pre.setString(2, BlogDescription);
             pre.setString(3, BlogAuthor);
            pre.executeUpdate();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
