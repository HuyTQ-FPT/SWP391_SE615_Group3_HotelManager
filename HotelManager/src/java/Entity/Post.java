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
public class Post {
    PostID int IDENTITY PRIMARY KEY,
	AccountID int ,
	PostAuthor varchar(50),
	PostDescription NVARCHAR(max),
	PostImage nvarchar(max),
	PostDate datetime,
	BlogTitle NVARCHAR(max),
}
