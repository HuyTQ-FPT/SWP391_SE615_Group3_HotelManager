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
public class Blog {
    BlogID int IDENTITY PRIMARY KEY,
	AccountID int ,
	BlogAuthor varchar(50),
	BlogDescription NVARCHAR(max),
	BlogImage nvarchar(max),
	BlogDate datetime,
	BlogTitle NVARCHAR(max),
}
