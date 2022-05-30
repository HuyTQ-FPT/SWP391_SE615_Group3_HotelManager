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
public class User {
    private int UserID;
	private int AccountID ;
	private String UserName;
	private String UserPhone;
	private String UserEmail ;
	private int UserGender;
	private String UserImage ;
	private String UserAdress;
	private String CMT ;
	private String ImgCMT;

    public User() {
    }

    public User(int UserID, int AccountID, String UserName, String UserPhone, String UserEmail, int UserGender, String UserImage, String UserAdress, String CMT, String ImgCMT) {
        this.UserID = UserID;
        this.AccountID = AccountID;
        this.UserName = UserName;
        this.UserPhone = UserPhone;
        this.UserEmail = UserEmail;
        this.UserGender = UserGender;
        this.UserImage = UserImage;
        this.UserAdress = UserAdress;
        this.CMT = CMT;
        this.ImgCMT = ImgCMT;
    }

    @Override
    public String toString() {
        return "User{" + "UserID=" + UserID + ", AccountID=" + AccountID + ", UserName=" + UserName + ", UserPhone=" + UserPhone + ", UserEmail=" + UserEmail + ", UserGender=" + UserGender + ", UserImage=" + UserImage + ", UserAdress=" + UserAdress + ", CMT=" + CMT + ", ImgCMT=" + ImgCMT + '}';
    }
        
}
