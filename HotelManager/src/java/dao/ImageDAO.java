
package dao;

import entity.Image;
import java.util.Vector;

public interface ImageDAO {
    public Vector<Image> getImageByid(String Roomid);
    public void insertImage(int riID ,Image insertImage);
    public void updateImage(int riID ,Image updateImage);
    public void deleteImage(int riID);
    public Vector<Image> selectImage(String sql);
    public Image imageByID(String sql);
  
}
