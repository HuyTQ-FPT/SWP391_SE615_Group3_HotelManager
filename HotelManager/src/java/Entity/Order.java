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
    BillID int IDENTITY PRIMARY KEY,
	UserID int, 
	Quantity int,
	Child int,
	Adult int,
	Total money,
	Note NVARCHAR(max),
	[Status] int, 
	[Date] datetime, 
	StatusDate datetime,
}
