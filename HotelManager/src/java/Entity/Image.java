/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Admin
 */
public class Image {
    private int RoomimageID;
	private String image1 ;
	private String image2;
	private String image3 ;
	private String image4;

    public Image() {
    }

    public Image(int RoomimageID, String image1, String image2, String image3, String image4) {
        this.RoomimageID = RoomimageID;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
    }

    public int getRoomimgaeID() {
        return RoomimageID;
    }

    public void setRoomimgaeID(int RoomimgaeID) {
        this.RoomimageID = RoomimgaeID;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    @Override
    public String toString() {
        return "Image{" + "RoomimgaeID=" + RoomimgaeID + ", image1=" + image1 + ", image2=" + image2 + ", image3=" + image3 + ", image4=" + image4 + '}';
    }
        
   
}
