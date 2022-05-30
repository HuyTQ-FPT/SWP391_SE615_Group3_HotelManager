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
public class Order {
    private int BillID;
	private int UserID ;
	private int Quantity;
	private int Child ;
	private int Adult;
	private double Total;
	private String Note ;
	private int Status;
	private String Date ; 
	private String StatusDate;

    public Order() {
    }

    public Order(int BillID, int UserID, int Quantity, int Child, int Adult, double Total, String Note, int Status, String Date, String StatusDate) {
        this.BillID = BillID;
        this.UserID = UserID;
        this.Quantity = Quantity;
        this.Child = Child;
        this.Adult = Adult;
        this.Total = Total;
        this.Note = Note;
        this.Status = Status;
        this.Date = Date;
        this.StatusDate = StatusDate;
    }

    @Override
    public String toString() {
        return "Order{" + "BillID=" + BillID + ", UserID=" + UserID + ", Quantity=" + Quantity + ", Child=" + Child + ", Adult=" + Adult + ", Total=" + Total + ", Note=" + Note + ", Status=" + Status + ", Date=" + Date + ", StatusDate=" + StatusDate + '}';
    }
        
}
