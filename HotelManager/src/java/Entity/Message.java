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
public class Message {
    MessageID int IDENTITY PRIMARY KEY,
	AccountID int,
	MessageTo NVARCHAR(max),
	MessageFrom NVARCHAR(max),
	[Date] datetime,
}
