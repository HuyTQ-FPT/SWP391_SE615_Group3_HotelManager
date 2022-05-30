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
public class Device {
    private int DeviceID;
	private String DeviceName;
	private int DeviceCate;
	private double Price;
	private int Status;

    public Device() {
    }

    public Device(int DeviceID, String DeviceName, int DeviceCate, double Price, int Status) {
        this.DeviceID = DeviceID;
        this.DeviceName = DeviceName;
        this.DeviceCate = DeviceCate;
        this.Price = Price;
        this.Status = Status;
    }

    public int getDeviceID() {
        return DeviceID;
    }

    public void setDeviceID(int DeviceID) {
        this.DeviceID = DeviceID;
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

    @Override
    public String toString() {
        return "Device{" + "DeviceID=" + DeviceID + ", DeviceName=" + DeviceName + ", DeviceCate=" + DeviceCate + ", Price=" + Price + ", Status=" + Status + '}';
    }
        
}
