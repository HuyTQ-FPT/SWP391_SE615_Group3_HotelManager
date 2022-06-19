/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class Device {
        private int DeviceID;
        private int RoomcateID;
	private String DeviceName;
	private int DeviceCate;
	private double Price;
	private int Status;
        private int Quantity ;

    public Device(int DeviceID, int RoomcateID, String DeviceName, int DeviceCate, double Price, int Status, int Quantity) {
        this.DeviceID = DeviceID;
        this.RoomcateID = RoomcateID;
        this.DeviceName = DeviceName;
        this.DeviceCate = DeviceCate;
        this.Price = Price;
        this.Status = Status;
        this.Quantity = Quantity;
    }

    public Device() {
    }

    public int getDeviceID() {
        return DeviceID;
    }

    public void setDeviceID(int DeviceID) {
        this.DeviceID = DeviceID;
    }

    public int getRoomcateID() {
        return RoomcateID;
    }

    public void setRoomcateID(int RoomcateID) {
        this.RoomcateID = RoomcateID;
    }

    public String getDeviceName() {
        return DeviceName;
    }

    public void setDeviceName(String DeviceName) {
        this.DeviceName = DeviceName;
    }

    public int getDeviceCate() {
        return DeviceCate;
    }

    public void setDeviceCate(int DeviceCate) {
        this.DeviceCate = DeviceCate;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    @Override
    public String toString() {
        return "Device{"+ "RoomcateID=" + RoomcateID + "DeviceID=" + DeviceID + ", DeviceName=" + DeviceName + ", DeviceCate=" + DeviceCate + ", Price=" + Price + ", Status=" + Status + "Quantity=" + Quantity + '}';
    }
        
}
