/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Image;
import java.util.Vector;

/**
 *
 * @author Admin
 */
public interface ImageDAO {
    public Vector<Image> getImageByid(String Roomid);
    public void insertImage(int riID ,Image insertImage);
    public void updateImage(int riID ,Image updateImage);
    public void deleteImage(int riID);
    public Vector<Image> selectImage(String sql);
}