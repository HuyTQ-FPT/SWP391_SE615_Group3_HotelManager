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
    ServiceID int IDENTITY PRIMARY KEY, 
	ServiceName NVARCHAR(max),
	ServiceImage nvarchar(max), 
	ServiceDes NVARCHAR(max),
	ServiceNote NVARCHAR(max),
	ServicePrice money,
}
