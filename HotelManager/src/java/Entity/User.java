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
public class User {
    UserID int IDENTITY PRIMARY KEY,
	AccountID int,
	UserName NVARCHAR(max),
	UserPhone NVARCHAR(max),
	UserEmail NVARCHAR(max),
	UserGender INT,
	UserImage NVARCHAR(max),
	UserAdress NVARCHAR(max),
	CMT NVARCHAR(max),
	ImgCMT nvarchar(max),
}
