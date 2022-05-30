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
public class Service {
    private int ServiceID;
	private String ServiceName ;
	private String ServiceImage ;
	private String ServiceDes;
	private String ServiceNote;
	private double ServicePrice;

    public Service() {
    }

    public Service(int ServiceID, String ServiceName, String ServiceImage, String ServiceDes, String ServiceNote, double ServicePrice) {
        this.ServiceID = ServiceID;
        this.ServiceName = ServiceName;
        this.ServiceImage = ServiceImage;
        this.ServiceDes = ServiceDes;
        this.ServiceNote = ServiceNote;
        this.ServicePrice = ServicePrice;
    }

    @Override
    public String toString() {
        return "Service{" + "ServiceID=" + ServiceID + ", ServiceName=" + ServiceName + ", ServiceImage=" + ServiceImage + ", ServiceDes=" + ServiceDes + ", ServiceNote=" + ServiceNote + ", ServicePrice=" + ServicePrice + '}';
    }
        
}
