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
    DeviceID int IDENTITY PRIMARY KEY,
	DeviceName nvarchar(50),
	DeviceCate int,
	Price money,
	[Status] int,
}
