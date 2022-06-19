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
public class RoomDevice {
    private int RoomcateID;
	private int DeviceID;
	private int Quantity ;

    public RoomDevice() {
    }

    public RoomDevice(int RoomcateID, int DeviceID, int Quantity) {
        this.RoomcateID = RoomcateID;
        this.DeviceID = DeviceID;
        this.Quantity = Quantity;
    }

    @Override
    public String toString() {
        return "RoomDevice{" + "RoomcateID=" + RoomcateID + ", DeviceID=" + DeviceID + ", Quantity=" + Quantity + '}';
    }
        
}
