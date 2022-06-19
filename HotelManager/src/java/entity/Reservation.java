/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Reservation {
    private int BillID;
	private int UserID ;
	private int RoomID ;
        private String Name;
        private String Email;
        private String Address;
        private String Phone;
	private int NumberOfPerson;
        private Date Checkin ;
        private Date Checkout ;
	private double Total;
	private int Status;
	private Date Date ; 

    public Reservation() {
    }

    public Reservation(int UserID, int RoomID, String Name, String Email, String Address, String Phone, int NumberOfPerson, Date Checkin, Date Checkout, double Total, int Status, Date Date) {
        this.UserID = UserID;
        this.RoomID = RoomID;
        this.Name = Name;
        this.Email = Email;
        this.Address = Address;
        this.Phone = Phone;
        this.NumberOfPerson = NumberOfPerson;
        this.Checkin = Checkin;
        this.Checkout = Checkout;
        this.Total = Total;
        this.Status = Status;
        this.Date = Date;
    }
    
    public Reservation(int BillID, int UserID, int RoomID, String Name, String Email, String Address, String Phone, int NumberOfPerson, Date Checkin, Date Checkout, double Total, int Status, Date Date) {
        this.BillID = BillID;
        this.UserID = UserID;
        this.RoomID = RoomID;
        this.Name = Name;
        this.Email = Email;
        this.Address = Address;
        this.Phone = Phone;
        this.NumberOfPerson = NumberOfPerson;
        this.Checkin = Checkin;
        this.Checkout = Checkout;
        this.Total = Total;
        this.Status = Status;
        this.Date = Date;
    }

    public int getBillID() {
        return BillID;
    }

    public void setBillID(int BillID) {
        this.BillID = BillID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getRoomID() {
        return RoomID;
    }

    public void setRoomID(int RoomID) {
        this.RoomID = RoomID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public int getNumberOfPerson() {
        return NumberOfPerson;
    }

    public void setNumberOfPerson(int NumberOfPerson) {
        this.NumberOfPerson = NumberOfPerson;
    }

    public Date getCheckin() {
        return Checkin;
    }

    public void setCheckin(Date Checkin) {
        this.Checkin = Checkin;
    }

    public Date getCheckout() {
        return Checkout;
    }

    public void setCheckout(Date Checkout) {
        this.Checkout = Checkout;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "Reservation{" + "BillID=" + BillID + ", UserID=" + UserID + ", RoomID=" + RoomID + ", Name=" + Name + ", Email=" + Email + ", Address=" + Address + ", Phone=" + Phone + ", NumberOfPerson=" + NumberOfPerson + ", Checkin=" + Checkin + ", Checkout=" + Checkout + ", Total=" + Total + ", Status=" + Status + ", Date=" + Date + '}';
    }

    

        

        
}
