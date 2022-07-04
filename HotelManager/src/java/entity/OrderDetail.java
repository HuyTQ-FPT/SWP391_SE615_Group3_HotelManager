
package entity;

public class OrderDetail {
    private int BillID;
	private int RoomID ;
	private String Checkin;
	private String Checkout;
	private double RoomPrice;
	private int ServiceID ;
	private double DetailServicePrice ;
	private String Note ;

    public OrderDetail() {
    }

    public OrderDetail(int BillID, int RoomID, String Checkin, String Checkout, double RoomPrice, int ServiceID, double DetailServicePrice, String Note) {
        this.BillID = BillID;
        this.RoomID = RoomID;
        this.Checkin = Checkin;
        this.Checkout = Checkout;
        this.RoomPrice = RoomPrice;
        this.ServiceID = ServiceID;
        this.DetailServicePrice = DetailServicePrice;
        this.Note = Note;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "BillID=" + BillID + ", RoomID=" + RoomID + ", Checkin=" + Checkin + ", Checkout=" + Checkout + ", RoomPrice=" + RoomPrice + ", ServiceID=" + ServiceID + ", DetailServicePrice=" + DetailServicePrice + ", Note=" + Note + '}';
    }
        
}
