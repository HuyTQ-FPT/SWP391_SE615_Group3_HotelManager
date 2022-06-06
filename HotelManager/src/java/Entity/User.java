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
	private String Birthday ;
	private String UserAdress;
	private String CMT ;
	private String ImgCMT;

    public User() {
    }

    public User(int UserID, int AccountID, String UserName, String UserPhone, String UserEmail, int UserGender, String Birthday, String UserAdress, String CMT, String ImgCMT) {
        this.UserID = UserID;
        this.AccountID = AccountID;
        this.UserName = UserName;
        this.UserPhone = UserPhone;
        this.UserEmail = UserEmail;
        this.UserGender = UserGender;
        this.Birthday = Birthday;
        this.UserAdress = UserAdress;
        this.CMT = CMT;
        this.ImgCMT = ImgCMT;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getAccountID() {
        return AccountID;
    }

    public void setAccountID(int AccountID) {
        this.AccountID = AccountID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String UserPhone) {
        this.UserPhone = UserPhone;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String UserEmail) {
        this.UserEmail = UserEmail;
    }

    public int getUserGender() {
        return UserGender;
    }

    public void setUserGender(int UserGender) {
        this.UserGender = UserGender;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setUserImage(String Birthday) {
        this.Birthday = Birthday;
    }

    public String getUserAdress() {
        return UserAdress;
    }

    public void setUserAdress(String UserAdress) {
        this.UserAdress = UserAdress;
    }

    public String getCMT() {
        return CMT;
    }

    public void setCMT(String CMT) {
        this.CMT = CMT;
    }

    public String getImgCMT() {
        return ImgCMT;
    }

    public void setImgCMT(String ImgCMT) {
        this.ImgCMT = ImgCMT;
    }

    @Override
    public String toString() {
        return "User{" + "UserID=" + UserID + ", AccountID=" + AccountID + ", UserName=" + UserName + ", UserPhone=" + UserPhone + ", UserEmail=" + UserEmail + ", UserGender=" + UserGender + ", UserImage=" + Birthday + ", UserAdress=" + UserAdress + ", CMT=" + CMT + ", ImgCMT=" + ImgCMT + '}';
    }
        
}
