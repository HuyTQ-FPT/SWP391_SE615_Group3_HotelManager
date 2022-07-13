package entity;

import java.sql.Date;

public class Reservation {

    private int BillID;
    private int UserID;
    private int RoomID;
    private String Roomname;
    private double Roomprice;
    private String Name;
    private String ServiceName;
    private String Email;
    private String Address;
    private String Phone;
    private int NumberOfPerson;
    private Date Checkin;
    private Date Checkout;
    private double Total;
    private int Status;
    private int Year;
    private int Month;
    private Date Date;

    public Reservation() {
    }

    public Reservation(int BillID, int UserID, String Name, String Roomname, String Address, String Email, String Phone, Date Checkin, Date Checkout, double Roomprice, double Total, int Status) {
        this.BillID = BillID;
        this.UserID = UserID;
        this.Name = Name;
        this.Roomname = Roomname;
        this.Address = Address;
        this.Email = Email;
        this.Phone = Phone;
        this.Checkin = Checkin;
        this.Checkout = Checkout;
        this.Roomprice = Roomprice;
        this.Total = Total;
        this.Status = Status;
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

    public Reservation(int RoomID, String Roomname, double Total) {
        this.RoomID = RoomID;
        this.Roomname = Roomname;
        this.Total = Total;
    }

    public Reservation(int Status, int NumberOfPerson, double Total) {
        this.Status = Status;
        this.NumberOfPerson = NumberOfPerson;
        this.Total = Total;
    }

    public Reservation(String ServiceName, double Total) {
        this.ServiceName = ServiceName;
        this.Total = Total;
    }

    public void setMonth(int Month) {
        this.Month = Month;
    }

    public int getMonth() {
        return Month;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String ServiceName) {
        this.ServiceName = ServiceName;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public String getRoomname() {
        return Roomname;
    }

    public void setRoomname(String Roomname) {
        this.Roomname = Roomname;
    }

    public double getRoomprice() {
        return Roomprice;
    }

    public void setRoomprice(double Roomprice) {
        this.Roomprice = Roomprice;
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

    public String toString1() {
        return "1" + Month;
    }

    public String toString2() {
        return "1" + Month;
    }
}
