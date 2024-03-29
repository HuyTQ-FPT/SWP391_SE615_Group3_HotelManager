USE master
GO
create database SWPgroup3
drop database SWPgroup3
use SWPgroup3
--drop table Customer

create table Device(
	DeviceID int IDENTITY PRIMARY KEY,
	DeviceName nvarchar(50),
	DeviceCate int,
	Price money,
	[Status] int,
);
create table CateRoom(
	RoomcateID int IDENTITY PRIMARY KEY,
	Catename NVARCHAR(max),
	Note NVARCHAR(max),
);
create table [Image](
	RoomimgaeID int IDENTITY PRIMARY KEY,
	image1 NVARCHAR(max),
	image2 NVARCHAR(max),
	image3 NVARCHAR(max),
	image4 NVARCHAR(max),
);
create table Room(
	RoomID int IDENTITY PRIMARY KEY,
	Roomname NVARCHAR(max),
	Roomdesc NVARCHAR(max),
	RoomcateID int,
	RoomimgaeID int,
	Roomprice money,
	NumberPerson int, 
	[Square] float, 
	Comment NVARCHAR(max),
	Rate int,
	Note Nvarchar(max),
	[Status] int not null,
	foreign key (RoomimgaeID) references [Image](RoomimgaeID),
	foreign key (RoomcateID) references CateRoom(RoomcateID)	
);
create table DateOfRoom(
	RoomID int,
	[DateIn] smalldatetime,
	[DateOut] smalldatetime,
	[Status] int not null ,
	foreign key (RoomID) references Room(RoomID)
);
create table RoomDevice(
	RoomID int,
	DeviceID int,
	Quantity int,
	[Status] int,
	Note NVARCHAR(max),
	ImageDevice NVARCHAR(max),
	foreign key (DeviceID) references Device(DeviceID),
	foreign key (RoomID) references Room(RoomID)
);

create table Role_Name (
	RoleID int IDENTITY PRIMARY KEY, 
	RoleName NVARCHAR(max),
);
create table Account (
	AccountID int IDENTITY PRIMARY KEY, 
	[RoleID] int,
	[user] VARCHAR(50)NOT NULL,
	[password] VARCHAR(50)NOT NULL,
	foreign key (RoleID) references Role_Name(RoleID)
);
create table [User] (
	UserID int IDENTITY PRIMARY KEY,
	AccountID int,
	UserName NVARCHAR(max),
	UserPhone NVARCHAR(max),
	UserEmail NVARCHAR(max),
	UserGender INT,
	Birthday date NULL,
	UserAdress NVARCHAR(max),
	CMT NVARCHAR(max),
	ImgCMT nvarchar(max),
	foreign key (AccountID) references Account(AccountID)
);
create table [Service](
	ServiceID int IDENTITY PRIMARY KEY, 
	ServiceName NVARCHAR(max),
	ServiceImage nvarchar(max), 
	ServiceDes NVARCHAR(max),
	ServiceNote NVARCHAR(max),
	ServicePrice money,
);
create table Reservation(
	BillID int IDENTITY PRIMARY KEY,
	UserID int,
	RoomID int,
   ServiceID int,
  	Name varchar(50),
	Email varchar(50),
	[Address] varchar(50),
	Phone varchar(50),
	NumberOfPerson int,
	ServiceName NVARCHAR(max),
  	ServicePrice money,
	Checkin smalldatetime,
	Checkout smalldatetime, 
	Total money,
	[Status] int, 
	[Date] smalldatetime, 
	foreign key (UserID) references [User](UserID),
	foreign key (ServiceID) references [Service](ServiceID),
	foreign key (RoomID) references Room(RoomID)
);


create table Blog(
	BlogID int IDENTITY PRIMARY KEY,
	AccountID int ,
	BlogAuthor varchar(50),
	BlogDescription NVARCHAR(max),
	BlogImage nvarchar(max),
	BlogDate datetime,
	BlogTitle NVARCHAR(max), 
	foreign key (AccountID) references Account(AccountID)
);
create table Post(
	PostID int IDENTITY PRIMARY KEY,
	AccountID int ,
	PostAuthor varchar(50),
	PostDescription NVARCHAR(max),
	PostImage nvarchar(max),
	PostDate datetime,
	BlogTitle NVARCHAR(max), 
	foreign key (AccountID) references Account(AccountID)
);
create table [Message](
	MessageID int IDENTITY PRIMARY KEY,
	AccountID int,
	MessageTo NVARCHAR(max),
	MessageFrom NVARCHAR(max),
	[Date] datetime,
	Content nvarchar(max),
	StatusMess nvarchar(50),
	RoomID int
	foreign key (AccountID) references Account(AccountID)
);
CREATE table dbo.[MessageRequest] (
[mId] int not null identity(1,1),
title nvarchar(255) not null,
email nvarchar(255) not null,
content nvarchar(255) not null,
isRead bit not null,
);
CREATE table dbo.[Notification] (
NID int not null identity(1,1),
Title nvarchar(50),
Name nvarchar(50),
Focus nvarchar(50),
Content nvarchar(255),
[Date] varchar(50),
[Status] int,
);create table [Events](
	EventID int IDENTITY PRIMARY KEY,
	EventName NVARCHAR(max),
	EventImage nvarchar(max),     
	EventDate smalldatetime,                                                             
	EventDateEnd smalldatetime, 
	EventCode nvarchar(max),
	Quantity int, 
	EventValue int,  
);create table [EventsDetails](
	EventID int ,
	UserID int,
	foreign key (UserID) references [User](UserID),
	foreign key (EventID) references [Events](EventID)
);
CREATE table dbo.[View] (
[date] date PRIMARY KEY NOT NULL,
 [view] int
);
CREATE TABLE [dbo].[Comment](
	[CommentID] [int] IDENTITY(1,1) NOT NULL,
	[Content] [nvarchar](50) NULL,
	[username] [nvarchar](max) NULL,
	[Date] [datetime] NULL,
	[ParentID] [int] NULL,
	[BlogID] [int] NULL,
);
create table FeedBackService(
	ServiceID int, 
	AccountID int,
	[Date] datetime,
	Comment NVARCHAR(max),
	[Status] int,
	Note NVARCHAR(max),
	CommentID int IDENTITY PRIMARY KEY,
	foreign key (AccountID) references Account(AccountID),
	foreign key (ServiceID) references [Service](ServiceID)
);
insert into Device (DeviceName, DeviceCate, Price, [Status]) values (N'Giường Đôi', 1, 6501, null);
insert into Device (DeviceName, DeviceCate, Price, [Status]) values (N'Giường Đơn', 2, 5759, null);
insert into Device (DeviceName, DeviceCate, Price, [Status]) values (N'Điều Hòa Lớn', 3, 4654, null);
insert into Device (DeviceName, DeviceCate, Price, [Status]) values (N'Điều Hòa Nhỏ', 4, 6571, null);
insert into Device (DeviceName, DeviceCate, Price, [Status]) values (N'Sofa', 5, 4661, null);
insert into Device (DeviceName, DeviceCate, Price, [Status]) values (N'Tivi', 6, 5946, null);
insert into Device (DeviceName, DeviceCate, Price, [Status]) values (N'Bàn Làm Việc', 7, 2625, null);
insert into Device (DeviceName, DeviceCate, Price, [Status]) values (N'Tủ', 8, 6127, null);

insert into CateRoom (Catename, Note) values (N'Phòng Tiêu Chuẩn', null);
insert into CateRoom (Catename, Note) values (N'Phòng Cao Cấp', null);
insert into CateRoom (Catename, Note) values (N'Phòng Sơ Cấp', null);
insert into CateRoom (Catename, Note) values (N'Phòng Thượng Hạng', null);
insert into CateRoom (Catename, Note) values (N'Phòng Gia Đình', null);
insert into CateRoom (Catename, Note) values (N'Phòng Bảo Trì', null);


insert into [Image] (image1, image2, image3, image4) values ('img1.0.jpg', 'img1.1.jpg', 'img1.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img2.0.jpg', 'img2.1.jpg', 'img2.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img3.0.jpg', 'img3.1.jpg', 'img3.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img4.0.jpg', 'img4.1.jpg', 'img4.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img5.0.jpg', 'img5.1.jpg', 'img5.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img6.0.jpg', 'img6.1.jpg', 'img6.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img7.0.jpg', 'img7.1.jpg', 'img7.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img8.0.jpg', 'img8.1.jpg', 'img8.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img9.0.jpg', 'img9.1.jpg', 'img9.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img10.0.jpg', 'img10.1.jpg', 'img10.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img11.0.jpg', 'img11.1.jpg', 'img11.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img12.0.jpg', 'img12.1.jpg', 'img12.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img13.0.jpg', 'img13.1.jpg', 'img13.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img14.0.jpg', 'img14.1.jpg', 'img14.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img15.0.jpg', 'img15.1.jpg', 'img15.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img16.0.jpg', 'img16.1.jpg', 'img16.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img17.0.jpg', 'img17.1.jpg', 'img17.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img18.0.jpg', 'img18.1.jpg', 'img18.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img19.0.jpg', 'img19.1.jpg', 'img19.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img20.0.jpg', 'img20.1.jpg', 'img20.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img21.0.jpg', 'img21.1.jpg', 'img21.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img22.0.jpg', 'img22.1.jpg', 'img22.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img23.0.jpg', 'img23.1.jpg', 'img23.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img24.0.jpg', 'img24.1.jpg', 'img24.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img25.0.jpg', 'img25.1.jpg', 'img25.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img26.0.jpg', 'img26.1.jpg', 'img26.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img27.0.jpg', 'img27.1.jpg', 'img27.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img28.0.jpg', 'img28.1.jpg', 'img28.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img29.0.jpg', 'img29.1.jpg', 'img29.2.jpg', null);
insert into [Image] (image1, image2, image3, image4) values ('img30.0.jpg', 'img30.1.jpg', 'img30.2.jpg', null);


insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (1, N'Tại đây, quý khách còn có thể thả mình thư giãn trong bể bơi bốn mùa hay khám phá nét ẩm thực Á - Âu tại nhà hàng 5 sao, thư giãn ở Vincharm Spa hay sử dụng các dịch vụ hội họp, sự kiện chuyên nghiệp. Dù bạn lựa chọn bất kỳ hạng phòng nào của khách sạn Vinpearl Tây Ninh đều sẽ sở hữu những tầm nhìn đẹp để hướng ra các danh lam thắng cảnh nổi tiếng Tây Ninh qua các khung cửa sổ yên bình. Khách sạn Vinpearl Tây Ninh là một trong những khách sạn được du khách yêu thích nhất khi tới Tây Ninh du lịch, công tác.', 3, 1, 8999, 1, 54, 'Meir', 4, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (2, N'Được xây dựng theo tiêu chuẩn 4 sao, Khách sạn Mường Thanh Grand Đà Nẵng có 2 nhà hàng, 1 hồ bơi trong nhà và 1 spa hiện đại cung cấp mọi nhu cầu của khách hàng. Tất cả 370 phòng nghỉ của khách sạn đều trang bị đầy đủ tiện nghi cao cấp như TV truyền thình vệ tinh, máy lạnh, mini bar, dụng cụ đun nước và trà… Nội thất trang trí tinh tế, tao nhã tạo cảm giác thanh lịch, ấm cúng cho khách hàng.', 5, 2, 6860, 8, 38, 'Ursulina', 5, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (3, N'Được thiết kế với lối kiến trúc Pháp cổ điển và sở hữu hồ bơi ngoài trời với hướng nhìn thẳng ra ngã ba sông Hậu, nơi diễn ra các hoạt động hàng ngày của người dân vùng Mê Kông. Chỗ nghỉ còn trang bị đầy đủ các dịch vụ dành cho du khách như: Spa, bể bơi trong nhà, phòng massage, khu vui chơi trẻ em, phòng tắm hơi hoặc bể bơi ngoài trời thiết kế độc đáo... Nội thất tinh tế từ sàn gạch đến đồ gỗ đồng gam màu đỏ ấm, đan xen với bảng màu của thiên nhiên như nâu của đất, xanh của cỏ cây và sắc vàng tươi của nắng tạo nên một bức tranh tươi tắn, dịu ngọt.', 1, 3, 7744, 4, 46, null, 4, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (4, N'Thiết kế tinh tế đầy đủ tiện nghi. View phòng hướng ra biển thoáng mát và rất gần gũi với thiên nhiên. Các phòng trang bị tiện nghi chuẩn 4 sao đầy đủ vừa sang trọng thanh lịch nhưng cũng không kém phần thoải mái và gần gũi. Đây cũng là lý do vì sao Mường Thanh là khách sạn tại Bình Thuận được ưa chuộng bậc nhất.', 4, 4, 7330, 4, 44, 'Aubert', 2, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (5, N'Ngoài các tiện ích cơ bản như máy điều hòa, TV, phòng tắm rộng, internet miễn phí, két bảo mật, tủ quần áo, máy sấy tóc, dụng cụ vệ sinh cá nhân,… Mường Thanh Holiday Mũi Né còn mang đến cho quý khách các dịch vụ nổi bật như bãi biển riêng, sân golf, khu vực hội thảo, công tác, spa massage thư giãn, trị liệu, dịch vụ đưa đón sân bay, giặt ủi, sắp xếp tour du lịch,…
', 1, 5, 7260, 4, 57, null, 2, null,1);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (6, N'Được thiết kế với lối kiến trúc Pháp cổ điển và sở hữu hồ bơi ngoài trời với hướng nhìn thẳng ra ngã ba sông Hậu, nơi diễn ra các hoạt động hàng ngày của người dân vùng Mê Kông. Chỗ nghỉ còn trang bị đầy đủ các dịch vụ dành cho du khách như: Spa, bể bơi trong nhà, phòng massage, khu vui chơi trẻ em, phòng tắm hơi hoặc bể bơi ngoài trời thiết kế độc đáo... Nội thất tinh tế từ sàn gạch đến đồ gỗ đồng gam màu đỏ ấm, đan xen với bảng màu của thiên nhiên như nâu của đất, xanh của cỏ cây và sắc vàng tươi của nắng tạo nên một bức tranh tươi tắn, dịu ngọt.', 4, 6, 8865, 6, 53, 'Horatio', 5, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (7, N'Một số tiện ích đáng chú ý khác tại khách sạn 3 sao này là nhà hàng Star Restaurant, quầy bar, cửa hàng đồ lưu niệm và các tiện nghi chăm sóc sức khỏe. Nơi đây sẽ là điểm dừng chân tuyệt vời cho một chuyến du lịch Hạ Long trọn vẹn và hoàn mỹ.', 3, 7, 5548, 4, 41, null, 2, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (8, N'Phòng nghỉ sang trọng, sạch sẽ. Khách sạn đạt chuẩn 4 sao với các phòng nghỉ bố trí hài hòa, đầy đủ các tiện nghi: tivi LCD truyền hình cáp, tủ lạnh, điều hòa, két an toàn, máy pha trà/ cà phê, bàn ghế làm việc và phòng tắm, đồ dùng cá nhân miễn phí. Bên cạnh đó, khách sạn này còn có phòng hội nghị, hội thảo - nơi lý tưởng để tổ chức các sự kiện, bữa tiệc với sức chưa đến 160 người; bãi đỗ xe miễn phí, phòng cho người hút thuốc…', 4, 8, 8211, 8, 45, 'Leesa', 4, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (9, N'Nơi đây không chỉ là khách sạn mà còn là một căn hộ tiêu chuẩn bao gồm phòng khách, phòng ngủ, phòng ăn… tất cả đem lại một dịch vụ cực kì cao cấp và chuyên nghiệp. Bên cạnh đó, Vinpearl Condotel Phủ Lý còn xây dựng những tiện ích phục vụ tối ưu nhu cầu giải trí, nghỉ dưỡng: bể bơi, khu trung tâm mua sắm, khu tập thể hình, tập yoga rèn luyện sức khỏe, nhà hàng,...', 5, 9, 7506, 8, 56, null, 5, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (10, N'Các phòng ngủ của resort được trang bị đầy đủ tiện nghi trong phòng: điều hòa, điện thoại, phòng tắm lớn, TV truyền hình cáp, tủ quần áo…', 4, 10, 7446, 6, 58, null, 4, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (11, N'phòng chuẩn 3 sao quốc tế, được bố trí đầy đủ tiện nghi: TV, Wifi free, điều hòa, nhà tắm – WC, tủ quần áo, bàn làm việc, minibar…Một số phòng có view nhìn ra quang cảnh thiên nhiên thoáng đãng.', 3, 11, 4794, 1, 51, null, 3, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (12, N'Nơi đây không chỉ là khách sạn mà còn là một căn hộ tiêu chuẩn bao gồm phòng khách, phòng ngủ, phòng ăn… tất cả đem lại một dịch vụ cực kì cao cấp và chuyên nghiệp. Bên cạnh đó, Vinpearl Condotel Phủ Lý còn xây dựng những tiện ích phục vụ tối ưu nhu cầu giải trí, nghỉ dưỡng: bể bơi, khu trung tâm mua sắm, khu tập thể hình, tập yoga rèn luyện sức khỏe, nhà hàng,...', 2, 12, 1749, 2, 59, 'Corena', 4, null,1);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (13, N'Các phòng ngủ của resort được trang bị đầy đủ tiện nghi trong phòng: điều hòa, điện thoại, phòng tắm lớn, TV truyền hình cáp, tủ quần áo…', 2, 13, 1544, 4, 49, null, 5, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (14, N'Tại Khách sạn Mường Thanh Lý Sơn, du khách sẽ cảm thấy hài lòng với hồ bơi ngoài trời rất rộng sẽ vô cùng lý tưởng cho chuyến du lịch cùng gia đình. Tiện ích nổi bật tại khách sạn Mường Thanh bao gồm nhà hàng, quán bar bên cạnh hồ bơi, quán cafe, phòng hội nghị.', 3, 14, 4509, 4, 46, null, 2, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (15, N'Phòng nghỉ sang trọng, sạch sẽ. Khách sạn đạt chuẩn 4 sao với các phòng nghỉ bố trí hài hòa, đầy đủ các tiện nghi: tivi LCD truyền hình cáp, tủ lạnh, điều hòa, két an toàn, máy pha trà/ cà phê, bàn ghế làm việc và phòng tắm, đồ dùng cá nhân miễn phí. Bên cạnh đó, khách sạn này còn có phòng hội nghị, hội thảo - nơi lý tưởng để tổ chức các sự kiện, bữa tiệc với sức chưa đến 160 người; bãi đỗ xe miễn phí, phòng cho người hút thuốc…', 4, 15, 3837, 5, 46, null, 5, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (16, N'Phong cách hiện đại, trang nhã và thanh lịch. Tất cả phòng ngủ tại khách sạn đều có cửa kính lớn và có tầm nhìn ra bao quát thành phố xinh đẹp, rộng lớn. Các phòng được trang bị đầy đủ nội thất như TV, máy lạnh, tủ quần áo, bàn làm việc, phòng tắm riêng,... ', 5, 16, 2219, 6, 37, null, 4, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (17, N'Tại đây, quý khách còn có thể thả mình thư giãn trong bể bơi bốn mùa hay khám phá nét ẩm thực Á - Âu tại nhà hàng 5 sao, thư giãn ở Vincharm Spa hay sử dụng các dịch vụ hội họp, sự kiện chuyên nghiệp. Dù bạn lựa chọn bất kỳ hạng phòng nào của khách sạn Vinpearl Tây Ninh đều sẽ sở hữu những tầm nhìn đẹp để hướng ra các danh lam thắng cảnh nổi tiếng Tây Ninh qua các khung cửa sổ yên bình. Khách sạn Vinpearl Tây Ninh là một trong những khách sạn được du khách yêu thích nhất khi tới Tây Ninh du lịch, công tác.', 2, 17, 9561, 6, 54, null, 5, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (18, N'Được xây dựng theo tiêu chuẩn 4 sao, Khách sạn Mường Thanh Grand Đà Nẵng có 2 nhà hàng, 1 hồ bơi trong nhà và 1 spa hiện đại cung cấp mọi nhu cầu của khách hàng. Tất cả 370 phòng nghỉ của khách sạn đều trang bị đầy đủ tiện nghi cao cấp như TV truyền thình vệ tinh, máy lạnh, mini bar, dụng cụ đun nước và trà… Nội thất trang trí tinh tế, tao nhã tạo cảm giác thanh lịch, ấm cúng cho khách hàng.', 5, 18, 7825, 8, 37, null, 3, null,1);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (19, N'Thiết kế tinh tế đầy đủ tiện nghi. View phòng hướng ra biển thoáng mát và rất gần gũi với thiên nhiên. Các phòng trang bị tiện nghi chuẩn 4 sao đầy đủ vừa sang trọng thanh lịch nhưng cũng không kém phần thoải mái và gần gũi. Đây cũng là lý do vì sao Mường Thanh là khách sạn tại Bình Thuận được ưa chuộng bậc nhất.', 4, 19, 1203, 4, 43, null, 4, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (20, N'Được thiết kế với lối kiến trúc Pháp cổ điển và sở hữu hồ bơi ngoài trời với hướng nhìn thẳng ra ngã ba sông Hậu, nơi diễn ra các hoạt động hàng ngày của người dân vùng Mê Kông. Chỗ nghỉ còn trang bị đầy đủ các dịch vụ dành cho du khách như: Spa, bể bơi trong nhà, phòng massage, khu vui chơi trẻ em, phòng tắm hơi hoặc bể bơi ngoài trời thiết kế độc đáo... Nội thất tinh tế từ sàn gạch đến đồ gỗ đồng gam màu đỏ ấm, đan xen với bảng màu của thiên nhiên như nâu của đất, xanh của cỏ cây và sắc vàng tươi của nắng tạo nên một bức tranh tươi tắn, dịu ngọt.', 3, 20, 6141, 4, 47, 'Judah', 4, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (21, N'Một số tiện ích đáng chú ý khác tại khách sạn 3 sao này là nhà hàng Star Restaurant, quầy bar, cửa hàng đồ lưu niệm và các tiện nghi chăm sóc sức khỏe. Nơi đây sẽ là điểm dừng chân tuyệt vời cho một chuyến du lịch Hạ Long trọn vẹn và hoàn mỹ.', 5, 21, 7256, 2, 43, 'Jimmie', 4, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (22, N'Phòng nghỉ sang trọng, sạch sẽ. Khách sạn đạt chuẩn 4 sao với các phòng nghỉ bố trí hài hòa, đầy đủ các tiện nghi: tivi LCD truyền hình cáp, tủ lạnh, điều hòa, két an toàn, máy pha trà/ cà phê, bàn ghế làm việc và phòng tắm, đồ dùng cá nhân miễn phí. Bên cạnh đó, khách sạn này còn có phòng hội nghị, hội thảo - nơi lý tưởng để tổ chức các sự kiện, bữa tiệc với sức chưa đến 160 người; bãi đỗ xe miễn phí, phòng cho người hút thuốc…', 1, 22, 3922, 8, 30, 'Peggi', 4, null,1);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (23, N'Phòng sang trọng, thiết kế tinh tế đầy đủ tiện nghi. View phòng hướng ra biển thoáng mát và rất gần gũi với thiên nhiên. Các phòng trang bị tiện nghi chuẩn 4 sao đầy đủ vừa sang trọng thanh lịch nhưng cũng không kém phần thoải mái và gần gũi. Đây cũng là lý do vì sao Mường Thanh là khách sạn tại Bình Thuận được ưa chuộng bậc nhất.', 5, 23, 2119, 4, 58, null, 1, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (24, N'Một số tiện ích đáng chú ý khác tại khách sạn 3 sao này là nhà hàng Star Restaurant, quầy bar, cửa hàng đồ lưu niệm và các tiện nghi chăm sóc sức khỏe. Nơi đây sẽ là điểm dừng chân tuyệt vời cho một chuyến du lịch Hạ Long trọn vẹn và hoàn mỹ.', 2, 24, 3589, 8, 59, 'Celestina', 3, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (25, N'Tại Khách sạn Mường Thanh Lý Sơn, du khách sẽ cảm thấy hài lòng với hồ bơi ngoài trời rất rộng sẽ vô cùng lý tưởng cho chuyến du lịch cùng gia đình. Tiện ích nổi bật tại khách sạn Mường Thanh bao gồm nhà hàng, quán bar bên cạnh hồ bơi, quán cafe, phòng hội nghị.', 2, 25, 3633, 4, 58, 'Wilbur', 4, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (26, N'Phòng nghỉ sang trọng, sạch sẽ. Khách sạn đạt chuẩn 4 sao với các phòng nghỉ bố trí hài hòa, đầy đủ các tiện nghi: tivi LCD truyền hình cáp, tủ lạnh, điều hòa, két an toàn, máy pha trà/ cà phê, bàn ghế làm việc và phòng tắm, đồ dùng cá nhân miễn phí. Bên cạnh đó, khách sạn này còn có phòng hội nghị, hội thảo - nơi lý tưởng để tổ chức các sự kiện, bữa tiệc với sức chưa đến 160 người; bãi đỗ xe miễn phí, phòng cho người hút thuốc…', 5, 26, 6580, 6, 31, null, 3, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (27, N'Được xây dựng theo tiêu chuẩn 4 sao, Khách sạn Mường Thanh Grand Đà Nẵng có 2 nhà hàng, 1 hồ bơi trong nhà và 1 spa hiện đại cung cấp mọi nhu cầu của khách hàng. Tất cả 370 phòng nghỉ của khách sạn đều trang bị đầy đủ tiện nghi cao cấp như TV truyền thình vệ tinh, máy lạnh, mini bar, dụng cụ đun nước và trà… Nội thất trang trí tinh tế, tao nhã tạo cảm giác thanh lịch, ấm cúng cho khách hàng.', 2, 27, 8426, 4, 55, 'Lora', 5, null,1);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (28, N'Được thiết kế với lối kiến trúc Pháp cổ điển và sở hữu hồ bơi ngoài trời với hướng nhìn thẳng ra ngã ba sông Hậu, nơi diễn ra các hoạt động hàng ngày của người dân vùng Mê Kông. Chỗ nghỉ còn trang bị đầy đủ các dịch vụ dành cho du khách như: Spa, bể bơi trong nhà, phòng massage, khu vui chơi trẻ em, phòng tắm hơi hoặc bể bơi ngoài trời thiết kế độc đáo... Nội thất tinh tế từ sàn gạch đến đồ gỗ đồng gam màu đỏ ấm, đan xen với bảng màu của thiên nhiên như nâu của đất, xanh của cỏ cây và sắc vàng tươi của nắng tạo nên một bức tranh tươi tắn, dịu ngọt.', 2, 28, 6124, 4, 60, null, null, null,0);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (29, N'Được xây dựng theo tiêu chuẩn 4 sao, Khách sạn Mường Thanh Grand Đà Nẵng có 2 nhà hàng, 1 hồ bơi trong nhà và 1 spa hiện đại cung cấp mọi nhu cầu của khách hàng. Tất cả 370 phòng nghỉ của khách sạn đều trang bị đầy đủ tiện nghi cao cấp như TV truyền thình vệ tinh, máy lạnh, mini bar, dụng cụ đun nước và trà… Nội thất trang trí tinh tế, tao nhã tạo cảm giác thanh lịch, ấm cúng cho khách hàng.', 3, 29, 9943, 8, 58, 'Sheila', 2, null,1);
insert into Room (Roomname, Roomdesc, RoomcateID, RoomimgaeID, Roomprice, NumberPerson, [Square], Comment, Rate, Note,[Status]) values (30, N'Tại đây, quý khách còn có thể thả mình thư giãn trong bể bơi bốn mùa hay khám phá nét ẩm thực Á - Âu tại nhà hàng 5 sao, thư giãn ở Vincharm Spa hay sử dụng các dịch vụ hội họp, sự kiện chuyên nghiệp. Dù bạn lựa chọn bất kỳ hạng phòng nào của khách sạn Vinpearl Tây Ninh đều sẽ sở hữu những tầm nhìn đẹp để hướng ra các danh lam thắng cảnh nổi tiếng Tây Ninh qua các khung cửa sổ yên bình. Khách sạn Vinpearl Tây Ninh là một trong những khách sạn được du khách yêu thích nhất khi tới Tây Ninh du lịch, công tác.', 1, 30, 8084, 4, 46, null, 5, null,1);


insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (1, 2, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (1, 4, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (1, 5, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (1, 6, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (1, 7, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (1, 8, 1,0,N'Hoạt Động','anhthietbi.jpg');


insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (2, 2, 2,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (2, 4, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (2, 5, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (2, 6, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (2, 7, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (2, 8, 1,0,N'Hoạt Động','anhthietbi.jpg');

insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (3, 1, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (3, 4, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (3, 5, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (3, 6, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (3, 7, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (3, 8, 1,0,N'Hoạt Động','anhthietbi.jpg');

insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (4, 1, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (4, 2, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (4, 3, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (4, 5, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (4, 6, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (4, 7, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (4, 8, 1,0,N'Hoạt Động','anhthietbi.jpg');

insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (5, 2, 3,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (5, 3, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (5, 5, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (5, 6, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (5, 7, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (5, 8, 1,0,N'Hoạt Động','anhthietbi.jpg');

insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (6, 2, 3,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (6, 3, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (6, 5, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (6, 6, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (6, 7, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (6, 8, 1,0,N'Hoạt Động','anhthietbi.jpg');

insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (7, 2, 3,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (7, 3, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (7, 5, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (7, 6, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (7, 7, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (7, 8, 1,0,N'Hoạt Động','anhthietbi.jpg');

insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (8, 2, 3,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (8, 3, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (8, 5, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (8, 6, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (8, 7, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (8, 8, 1,0,N'Hoạt Động','anhthietbi.jpg');

insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (9, 2, 3,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (9, 3, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (9, 5, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (9, 6, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (9, 7, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (9, 8, 1,0,N'Hoạt Động','anhthietbi.jpg');

insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (10, 2, 3,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (10, 3, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (10, 5, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (10, 6, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (10, 7, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (10, 8, 1,0,N'Hoạt Động','anhthietbi.jpg');

insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (11, 2, 3,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (11, 3, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (11, 5, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (11, 6, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (11, 7, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (11, 8, 1,0,N'Hoạt Động','anhthietbi.jpg');

insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (12, 2, 3,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (12, 3, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (12, 5, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (12, 6, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (12, 7, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (12, 8, 1,0,N'Hoạt Động','anhthietbi.jpg');

insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (13, 2, 3,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (13, 3, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (12, 5, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (13, 6, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (13, 7, 1,0,N'Hoạt Động','anhthietbi.jpg');
insert into RoomDevice (RoomID, DeviceID, Quantity, [Status], Note, ImageDevice) values (13, 8, 1,0,N'Hoạt Động','anhthietbi.jpg');




INSERT INTO [SWPgroup3].[dbo].[DateOfRoom]
           ([RoomID],[DateIn],[DateOut],[Status])VALUES(1,'02-12-2020','02-15-2020',1)
INSERT INTO [SWPgroup3].[dbo].[DateOfRoom]
           ([RoomID],[DateIn],[DateOut],[Status])VALUES(1,'02-16-2020','02-19-2020',1)
INSERT INTO [SWPgroup3].[dbo].[DateOfRoom]
           ([RoomID],[DateIn],[DateOut],[Status])VALUES(2,'02-16-2020','02-19-2020',1)
INSERT INTO [SWPgroup3].[dbo].[DateOfRoom]
           ([RoomID],[DateIn],[DateOut],[Status])VALUES(3,'02-16-2020','02-19-2020',1)
INSERT INTO [SWPgroup3].[dbo].[DateOfRoom]
           ([RoomID],[DateIn],[DateOut],[Status])VALUES(4,'02-16-2020','02-19-2020',1)
INSERT INTO [SWPgroup3].[dbo].[DateOfRoom]
           ([RoomID],[DateIn],[DateOut],[Status])VALUES(5,'02-16-2020','02-20-2020',1)
INSERT INTO [SWPgroup3].[dbo].[DateOfRoom]
           ([RoomID],[DateIn],[DateOut],[Status])VALUES(6,'02-17-2020','02-19-2020',1)
           
insert into Role_Name (RoleName) values ('Customer');
insert into Role_Name (RoleName) values ('Reception');
insert into Role_Name (RoleName) values ('Admin');

insert into Account ([RoleID], [user], [password]) values (1, 'user1', '12345678');
insert into Account ([RoleID], [user], [password]) values (1, 'user2', '12345678');
insert into Account ([RoleID], [user], [password]) values (1, 'user3', '12345678');
insert into Account ([RoleID], [user], [password]) values (1, 'user4', '12345678');
insert into Account ([RoleID], [user], [password]) values (1, 'user5', '12345678');
insert into Account ([RoleID], [user], [password]) values (2, 'Recept','12345678');
insert into Account ([RoleID], [user], [password]) values (2, 'user6', '12345678');
insert into Account ([RoleID], [user], [password]) values (2, 'user7', '12345678');
insert into Account ([RoleID], [user], [password]) values (3, 'Admin', 'Admin');


insert into [User] (AccountID, UserName, UserPhone, UserEmail, UserGender, Birthday, UserAdress, CMT, ImgCMT) values (1, 'Sadella', '5384149656', 'lhutson0@gmail.com', 1, '06-12-2001', '5609 Reindahl Terrace', '534 420 0297', 'user1.jpg');
insert into [User] (AccountID, UserName, UserPhone, UserEmail, UserGender, Birthday, UserAdress, CMT, ImgCMT) values (2, 'Katee', '7949006481', 'mschindler1@gmail.com', 2, '06-12-2001', '67585 Pond Plaza', '844 768 4148', 'user2.jpg');
insert into [User] (AccountID, UserName, UserPhone, UserEmail, UserGender, Birthday, UserAdress, CMT, ImgCMT) values (3, 'Nikolaos', '9272864652', 'aalbany2@gmail.com', 2, '06-12-2001', '7 Montana Pass', '707 628 1896', 'user3.jpg');
insert into [User] (AccountID, UserName, UserPhone, UserEmail, UserGender, Birthday, UserAdress, CMT, ImgCMT) values (4, 'Kirsti', '3063919748', 'nridgewell3@gmail.com', 1, '06-12-2001', '23261 Laurel Point', '775 198 0470', 'user4.jpg');
insert into [User] (AccountID, UserName, UserPhone, UserEmail, UserGender, Birthday, UserAdress, CMT, ImgCMT) values (5, 'Whitaker', '1586925043', 'emarner4@gmail.com', 1, '06-12-2001', '822 Ridgeway Terrace', '407 198 0639', 'user5.jpg');
insert into [User] (AccountID, UserName, UserPhone, UserEmail, UserGender,Birthday, UserAdress, CMT, ImgCMT) values (6, 'Tobiah', '4847095745', 'jizzatt5@gmail.com', 2, '06-12-2001', '4 Bunting Point', '407 980 1396', 'user6.jpg');
insert into [User] (AccountID, UserName, UserPhone, UserEmail, UserGender, Birthday, UserAdress, CMT, ImgCMT) values (7, 'Martynne', '4482170929', 'tplacido6@gmail.com', 1, '06-12-2001', '7 Chive Park', '658 322 9770', 'user7.jpg');
insert into [User] (AccountID, UserName, UserPhone, UserEmail, UserGender, Birthday, UserAdress, CMT, ImgCMT) values (8, 'Ealasaid', '7644339446', 'hlambertson7@gmail.com', 2, '06-12-2001', '41 Victoria Road', '476 261 1389', 'user8.jpg');
insert into [User] (AccountID, UserName, UserPhone, UserEmail, UserGender, Birthday, UserAdress, CMT, ImgCMT) values (9, 'Veronica', '2026706190', 'dburchett8@gmail.com', 1, '06-12-2001', '1 Atwood Terrace', '216 245 0987', 'user9.jpg');

insert into [Service] (ServiceName, ServiceImage, ServiceDes, ServiceNote, ServicePrice) values (N'Casino', 'img1.jpg', N'Ở khách sạn cao cấp chúng tôi có khu phức hợp vui chơi giải trí, trong đó bao gồm dịch vụ casino. Tại đây du khách sẽ được tham gia nhiều trò chơi mang tính giải trí cao, đủ các thể loại trò chơi từ trong nước đến quốc tế.', null, 200000);

insert into [Service] (ServiceName, ServiceImage, ServiceDes, ServiceNote, ServicePrice) values (N'Phục vụ bữa ăn', 'img2.jpg', N'Bữa ăn là một phần tuyệt vời trong kỳ nghỉ của bạn. Và đơn giản là chúng ta có thể làm cho nó trở nên hoàn hảo. Mặc dù các biệt thự được trang bị đầy đủ bếp nhỏ nhưng chúng tôi có thể giúp bạn dễ dàng hơn. Dịch vụ phục vụ đẹp của chúng tôi dành cho các bữa ăn, bữa trưa hoặc bữa nửa buổi, bên hồ bơi hoặc trong vườn, cho bữa tối và bữa trưa, cho các sự kiện đặc biệt.

Bạn sẽ có một thực đơn với các món ăn mà bạn có thể chọn. Chúng được chế biến bởi các đầu bếp chuyên nghiệp của chúng tôi và sẽ được chuyển trực tiếp đến biệt thự vào thời gian đã xác định. Các món ăn có thể được thỏa thuận trực tiếp với dịch vụ ăn uống.

Giá bạn phải trả hiện bao gồm việc đặt hàng trước trong một khoảng thời gian dành cho đầu bếp. Bạn sẽ có thể chọn các món ăn và thảo luận về tất cả các thực đơn sau đó.', null, 62000);
insert into [Service] (ServiceName, ServiceImage, ServiceDes, ServiceNote, ServicePrice) values (N'Dịch vụ trông trẻ', 'img3.jpg', N'Đưa trẻ em đi cùng? Hãy để họ có một kỳ nghỉ tuyệt vời nhất và hãy để chính bạn! Hãy dành thời gian rảnh rỗi trong khi người trông trẻ chăm sóc con bạn - chúng tôi có rất nhiều điều thú vị để làm - chơi, bơi lội, nấu ăn, v.v.

Tại các biệt thự của chúng tôi, bạn có thể yêu cầu dịch vụ của một người trông trẻ có trình độ chuyên môn, người có thể trông con bạn trong những chuyến du lịch, dã ngoại không phù hợp với chúng, hoặc đơn giản là cho một buổi tối lãng mạn.

Dịch vụ được thỏa thuận theo nhu cầu của bạn, liên hệ với chúng tôi để có sẵn hàng. Giá được liệt kê là khoản đặt cọc mà chúng tôi sẽ thêm vào giá dịch vụ cuối cùng.', null, 47000);
insert into [Service] (ServiceName, ServiceImage, ServiceDes, ServiceNote, ServicePrice) values (N'Lễ cưới và lễ sinh nhật', 'img4.jpg', N'Một dịch vụ đặc biệt cho những người muốn dành những ngày đặc biệt ở những nơi đặc biệt. Hãy để chúng tôi sắp xếp sinh nhật hoặc sum họp gia đình, đám cưới của bạn hoặc bất kỳ địa điểm đặc biệt nào khác với tư vấn trực tiếp về tài sản, khu vực và hoạt động phù hợp cho một nhóm lớn trong biệt thự của chúng tôi. Mỗi biệt thự đều có không gian mở đặc biệt để tổ chức lễ kỷ niệm.

Tổ chức đám cưới của bạn ở một nơi tuyệt đẹp gần đại dương, khung cảnh hoàn hảo để tận hưởng gia đình và bạn bè. Bạn cũng có thể có một lời chúc thân mật trong nhà nguyện riêng của Biệt thự - đây có phải là điều bạn hằng mơ ước? Uống một ly rượu vang Ý quanh hồ bơi và thưởng thức bữa tối đặc trưng của vùng Tuscany dưới những tán cây tráng lệ.

Chúng tôi tổ chức tất cả các loại tiệc cưới sang trọng và nhỏ - chỉ bao gồm từ thứ Hai đến thứ Năm và cho tối đa 40 khách. Wedding planner và các dịch vụ ăn uống theo yêu cầu. Giá niêm yết bao gồm việc chuẩn bị trước một kế hoạch đám cưới hoặc kế hoạch sinh nhật.', null, 89000);
insert into [Service] (ServiceName, ServiceImage, ServiceDes, ServiceNote, ServicePrice) values (N'Dịch vụ vệ sinh', 'img5.jpg', N'Tất cả các biệt thự của chúng tôi được làm sạch thường xuyên. Nhưng chúng tôi cũng cung cấp thêm dịch vụ dọn dẹp theo yêu cầu - nếu bạn cần khi việc dọn dẹp không có kế hoạch. Bất kể đây là dịch vụ đã lên kế hoạch hay đặt thêm, chúng tôi cung cấp mức độ sạch sẽ phi thường và dịch vụ cao cấp, vì vậy bạn không bao giờ làm hỏng phần còn lại của mình vì phòng không sạch sẽ.

Dọn dẹp biệt thự của chúng tôi bao gồm dọn phòng cho khách, sàn nhà, nhà bếp, phòng tắm, nhà hàng, quán bar, spa và hơn thế nữa tùy thuộc vào một biệt thự đã chọn. Bạn cũng có thể đặt trước qua điện thoại trong thời gian lưu trú.

Chúng tôi luôn đáp ứng nhu cầu cao của hoạt động kinh doanh dịch vụ khách sạn về sự rõ ràng, vì vậy, chúng tôi sẽ cử một số nhân viên đến biệt thự của bạn để thực hiện dọn dẹp toàn bộ hoặc một phần.', null, 428000);
insert into [Service] (ServiceName, ServiceImage, ServiceDes, ServiceNote, ServicePrice) values (N'Thuê ô tô', 'img6.jpg', N'Dịch vụ cho thuê xe hơi của chúng tôi giúp bạn đi lại thuận tiện quanh vùng nông thôn và đến các thành phố lân cận.

Ngoài nhiều loại xe cho bạn lựa chọn, chúng tôi còn cung cấp các ưu đãi cho thuê xe toàn diện phù hợp với nhu cầu và túi tiền của bạn trong suốt thời gian lưu trú, bất kể bạn ở bao nhiêu ngày.

Vì có rất nhiều hoạt động thể thao thú vị trong các khu vực khác nhau, hãy thuê một chiếc xe hơi và lái xe để thưởng thức các môn thể thao ở khu vực xung quanh như trượt tuyết, đi bộ đường dài và câu cá.', null, 227000);
insert into [Service] (ServiceName, ServiceImage, ServiceDes, ServiceNote, ServicePrice) values (N'Dịch vụ Spa', 'img7.jpg', N'Dịch vụ spa chỉ có ở một số khách sạn cao cấp. Để đáp ứng nhu cầu làm đẹp của các chị em phụ nữ, các dịch vụ Spa được mở ra nhiều hơn trong những năm gần đây. Bao gồm: xông hơi, lột mụn, gội đầu ...Nhu cầu chăm sóc, làm đẹp của chị em không hề giảm khi đi du lịch hay công tác, do đó các dịch vụ Spa đang ngày càng được du khách phản hồi nồng nhiệt.', null, 300000);


INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(1,2,1,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Casino',200000,'01-21-2022','01-24-2022',1800000,1,'07-20-2021')
INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(1,1,1,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Casino',200000,'01-21-2022','01-24-2022',2800000,1,'07-21-2021')

INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(2,2,1,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Casino',200000,'02-21-2022','02-24-2022',1100000,1,'07-19-2021')

INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(1,2,1,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Casino',200000,'03-21-2022','03-24-2022',1200000,1,'06-15-2021')

INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(3,3,1,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Casino',200000,'03-21-2022','03-24-2022',1300000,1,'06-21-2021')

INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(4,4,1,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Casino',200000,'04-21-2022','04-24-2022',1400000,1,'06-18-2021')

INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(5,5,1,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Casino',200000,'05-21-2022','05-24-2022',1500000,1,'06-22-2021')

INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(1,6,2,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Phục vụ bữa ăn',62000,'06-21-2022','06-24-2022',1300000,1,'07-22-2021')

INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(2,7,2,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Phục vụ bữa ăn',62000,'01-11-2022','01-14-2022',1300000,1,'08-22-2021')
INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(3,8,2,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Phục vụ bữa ăn',62000,'01-15-2022','01-18-2022',1300000,1,'06-22-2021')
INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(4,9,2,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Phục vụ bữa ăn',62000,'02-01-2022','02-04-2022',1300000,1,'06-26-2021')
INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(5,10,2,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Phục vụ bữa ăn',62000,'02-05-2022','02-08-2022',1300000,1,'07-03-2021')
INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(1,11,3,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Dịch vụ trông trẻ',47000,'02-11-2022','02-14-2022',1300000,1,'07-03-2021')

INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(2,12,3,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Dịch vụ trông trẻ',47000,'02-15-2022','02-18-2022',2300000,1,'07-03-2021')

INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(3,13,3,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Dịch vụ trông trẻ',47000,'02-19-2022','02-22-2022',1100000,1,'07-04-2021')

INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(4,14,3,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Dịch vụ trông trẻ',47000,'02-23-2022','02-26-2022',1300000,1,'07-05-2021')
INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(5,15,3,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Dịch vụ trông trẻ',47000,'03-11-2022','03-14-2022',1300000,1,'07-03-2021')
INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(1,16,4,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Lễ cưới và lễ sinh nhật',89000,'03-15-2022','03-18-2022',2300000,1,'07-06-2021')

INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(2,17,4,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Lễ cưới và lễ sinh nhật',89000,'03-19-2022','03-22-2022',2300000,1,'07-03-2021')
INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(3,18,4,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Lễ cưới và lễ sinh nhật',89000,'03-23-2022','03-25-2022',2200000,1,'07-07-2021')
INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(4,19,4,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Lễ cưới và lễ sinh nhật',89000,'12-26-2021','12-29-2021',2800000,1,'07-10-2021')
INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(5,20,4,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Lễ cưới và lễ sinh nhật',89000,'11-01-2021','11-04-2021',2700000,1,'07-11-2021')

INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(1,21,5,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Dịch vụ vệ sinh',62000,'01-01-2021','01-04-2021',2600000,1,'07-03-2021')
INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(2,22,5,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Dịch vụ vệ sinh',62000,'02-05-2021','02-08-2021',2500000,1,'07-09-2021')
INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(3,23,5,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Dịch vụ vệ sinh',62000,'03-09-2022','04-12-2022',2400000,1,'07-08-2021')
INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(4,24,5,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Dịch vụ vệ sinh',62000,'04-13-2022','04-13-2022',2300000,1,'07-15-2021')
INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(5,25,5,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Dịch vụ vệ sinh',62000,'05-01-2021','05-04-2021',2200000,1,'05-12-2021')
INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(1,26,6,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Thuê ô tô',227000,'06-01-2021','06-04-2021',2100000,1,'09-16-2021')

INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(2,27,6,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Thuê ô tô',227000,'07-01-2022','07-04-2022',2000000,1,'07-03-2021')

INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(3,28,6,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Thuê ô tô',227000,'08-01-2021','08-01-2021',3300000,1,'05-02-2021')

INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(4,29,6,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Thuê ô tô',227000,'09-01-2021','09-01-2021',3200000,1,'05-03-2021')

INSERT INTO [SWPgroup3].[dbo].[Reservation]
([UserID],[RoomID],[ServiceID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[ServiceName],ServicePrice,[Checkin],[Checkout],[Total],[Status],[Date])
VALUES(5,30,7,'Messi','asd123@gmail.com','Argentina','01231231',5,N'Dịch vụ Spa',300000,'10-01-2021','10-01-2021',3500000,1,'05-05-2021')

insert into Blog (AccountID, BlogAuthor, BlogDescription, BlogImage, BlogDate, BlogTitle) values (1, 'Tuck Naris', N'Biệt thự của chúng tôi ở Lazio là một nơi tuyệt vời để khám phá và tận hưởng cuộc sống dưới nước - bãi biển, núi non và nhiều không khí trong lành. Tuy nhiên, nếu bạn cũng muốn đến một số nơi tuyệt đẹp của khu vườn, bạn sẽ thích chuyến tham quan khu vườn gần biệt thự Lazio của chúng tôi.

Một chuyến đi nửa ngày bổ ích từ Bolsena, mê cung của những hàng rào hộp được cắt một cách hoàn hảo này đã chống lại sự mơ hồ của thời trang vườn đến với chúng ta không thay đổi so với đầu thế kỷ 17. Nghe có vẻ khá hấp dẫn đối với bạn, phải không?

Ẩn trong 12 parterres là tên viết tắt của người sáng lập khu vườn, Ottavia Orsini và các con trai của bà. Chủ nhân hiện tại là công chúa simpatica Claudia Ruspoli, đích thân hướng dẫn du khách tham quan khu vườn mà cô đã trùng tu và gửi gắm vào đó rất nhiều tâm huyết của mình. Các chuyến tham quan, cũng diễn ra tại ngôi nhà lâu đài của cô, Castello Ruspoli, diễn ra vào Chủ nhật từ tháng 4 đến cuối tháng 10.', 'img1.jpg', '2021-09-26 17:54:32', N'Chuyến tham quan vườn Vignanello khó quên ở Lazio');
insert into Blog (AccountID, BlogAuthor, BlogDescription, BlogImage, BlogDate, BlogTitle) values (2, 'Delly Braga', N'John Smith ngày 14 tháng 6 năm 2017 2 Bình luận Giảm giá đặc biệt cho chuyến tham quan các lâu đài ở Ý! Tags: tour du lịch ăn uống, hướng dẫn du lịch

Các địa điểm tham quan gần Biệt thự mùa hè Emilia
Biệt thự mùa hè Emilia của chúng tôi nằm ở vùng Emilia-Romagna ở Ý - và đây là một nơi tuyệt đẹp để khám phá! Ngoài đường bờ biển và thiên nhiên tuyệt vời, có rất nhiều địa điểm lịch sử mà bạn có thể ghé thăm.

Mọi thứ phụ thuộc vào sở thích của bạn - ví dụ: nếu bạn quan tâm đến trải nghiệm ẩm thực Bologna, bạn có thể quan tâm đến việc tham quan nhà máy với Bữa trưa dành cho người sành ăn và Nếm rượu: tại đây bạn sẽ theo dõi các giác quan của mình trong chuyến tham quan ẩm thực cả ngày về món ăn nổi tiếng của Bologna vùng đất!
Nếu bạn là người yêu thích các nhà máy địa phương và các nhà sản xuất do gia đình tự quản, bạn có cơ hội xem hậu trường về việc tạo ra các sản phẩm được yêu thích trên khắp thế giới, bao gồm pho mát Parmigiano-Reggiano, giấm balsamic Modena, rượu prosciutto và rượu vang.', 'img3.jpg', '2021-09-26 17:54:32', N'Tất cả những lâu đài này đều gần với bạn nếu bạn ở trong biệt thự của chúng tôi và đặt tour du lịch với chúng tôi.');
insert into Blog (AccountID, BlogAuthor, BlogDescription, BlogImage, BlogDate, BlogTitle) values (3, 'Halette Sans', N'Ba tháng âm nhạc chất lượng cao đang mong đợi dành cho người hâm mộ âm nhạc! Năm nay, những cái tên xác nhận tham gia đã khiến tất cả những người yêu nhạc phải phát cuồng, không biết mình yêu thích dòng nhạc nào, từ nhạc cổ điển, R&B đến pop.

Dưới đây là một số cái tên trong đội hình: Mary J. Blige, Ennio Morricone, Imagine Dragons, Ms Lauryn Hill, và drum roll… The Rolling Stones! Hãy truy cập trang web để xem các nghệ sĩ yêu thích của bạn sẽ biểu diễn vào những ngày nào, và nhanh tay thuê biệt thự của chúng tôi và chuẩn bị sẵn sàng để nhận vé nhé!', 'img4.jpg', '2021-09-26 17:54:32', N'Lễ hội sẽ kéo dài trong 3 tháng tại Thị trấn Tuscan!');
insert into Blog (AccountID, BlogAuthor, BlogDescription, BlogImage, BlogDate, BlogTitle) values (4, 'Tiffy Chewter', N'Lazio hoặc Campania: địa điểm nào là tốt nhất cho kỳ nghỉ của bạn?
Mơ về một kỳ nghỉ tuyệt đẹp ở một trong những điểm đến của Ý? Bạn muốn tìm một biệt thự hoàn hảo cho mình? Chúng tôi cho phép bạn đặt một biệt thự ở bất kỳ nơi nào trong số những nơi này và thậm chí hơn thế nữa. Còn việc ở đâu thì tùy thuộc vào sở thích và túi tiền của bạn. Nếu bạn không gắn bó với bất kỳ sự kiện cụ thể nào và chỉ muốn tìm một nơi tốt nhất để nghỉ ngơi,', 'img5.jpg', '2021-09-26 17:54:32', N'John Smith ngày 14 tháng 6 năm 2017 1 Bình luận Ăn mừng Lễ hội Mùa hè Lucca với chúng tôi Lễ hội Tags Lễ hội, Âm nhạc');
insert into Blog (AccountID, BlogAuthor, BlogDescription, BlogImage, BlogDate, BlogTitle) values (5, 'Captain', N'Tân Sơn Nhất Pavillon hiện đang là một trong những trung tâm tiệc cưới hàng đầu Hồ Chí Minh với 10 sảnh tiệc và bãi đậu xe rộng lớn lên tới 5000 phương tiện. Toàn bộ sảnh được thiết kế theo kiến trúc Châu Âu hiện đại, sang trọng.', '4406a970306a452300f94532410dab2c.jpg13', '2021-09-26 17:54:32', N'CHƯƠNG TRÌNH KHUYẾN MÃI');
insert into Blog (AccountID, BlogAuthor, BlogDescription, BlogImage, BlogDate, BlogTitle) values (6, 'Hulk', N'Lấy cảm hứng từ sự tinh tế và sang trọng của những loại đá quý, Trung tâm hội nghị tiệc cưới Tân Sơn Nhất Pavillon sở hữu 10 sảnh tiệc lớn với sức chứa lên đến 7000 khách cùng 1 thời điểm, được thiết kế với trần cao thoáng đãng, mang tông màu nền nã đan xen là chất liệu gỗ ấm áp kết hợp các chuỗi hạt ánh sáng lấp lánh. Hệ thống trang thiết bị hiện đại có khả năng thay đổi thiết kế linh hoạt phù hợp với các loại yến tiệc, hội nghị trọng đại cho quý doanh nghiệp và đáp ứng được nhu cầu đa dạng theo sở thích và phong cách riêng của các cặp đôi.', 'img-img.jpg13', '2021-09-26 17:54:32', N'KHÁM PHÁ SẢNH TIỆCC');
insert into Blog (AccountID, BlogAuthor, BlogDescription, BlogImage, BlogDate, BlogTitle) values (7, 'Captain Marvel', N'Với nhiều năm kinh nghiệm trong dịch vụ cưới, Trung tâm hội nghị tiệc cưới Tân Sơn Nhất Pavillon sẽ biến bức tranh tình yêu của bạn thành hiện thực với các gói dịch vụ cưới đa dạng, chuyên nghiệp từ khâu thiết kế ý tưởng đến tổ chức thực hiện. Tân Sơn Nhất Pavillon hân hạnh đảm nhận sứ mệnh lưu lại từng khoảnh khắc trọn vẹn nhất trong ngày vui của các cặp đôi.', 'PVL6327-1.jpg6', '2021-09-26 17:54:32', N'SỰ KIỆN CƯỚI – SANG TRỌNG CHO NGÀY VUI');
INSERT INTO [SWPgroup3].[dbo].[Events]
           ([EventName],[EventImage],[EventDate],[EventDateEnd],[EventCode],[Quantity],[EventValue])
VALUES(N'Giảm giá 10%','img1.jpg','2022-07-07','2022-08-01','qweqwe',5,10 )
INSERT INTO [SWPgroup3].[dbo].[Events]
           ([EventName],[EventImage],[EventDate],[EventDateEnd],[EventCode],[Quantity],[EventValue])
VALUES(N'Giảm giá 50%','img2.jpg','2022-07-07','2022-08-01','qcxs',4,50 )
INSERT INTO [SWPgroup3].[dbo].[Events]
           ([EventName],[EventImage],[EventDate],[EventDateEnd],[EventCode],[Quantity],[EventValue])
VALUES(N'Giảm giá 30%','img3.jpg','2022-07-07','2022-08-02','qweqwe',6,30 )
INSERT INTO [SWPgroup3].[dbo].[Events]
           ([EventName],[EventImage],[EventDate],[EventDateEnd],[EventCode],[Quantity],[EventValue])
VALUES(N'Giảm giá 40%','img4.jpg','2022-07-07','2022-08-02','qweqwe',6,40 )
INSERT INTO [SWPgroup3].[dbo].[Events]
           ([EventName],[EventImage],[EventDate],[EventDateEnd],[EventCode],[Quantity],[EventValue])
VALUES(N'Giảm giá 20%','img5.jpg','2022-07-07','2022-08-02','qweqwe',6,20 )

INSERT INTO [dbo].[FeedBackService]
                      ([ServiceID]
                     ,[AccountID]
                     ,[Date]
                     ,[Comment]
                     ,[Status]
                     ,[Note])
                     VALUES
                    (1,1,GETDATE(),N'Dịch vụ rất tốt',0,'')
INSERT INTO [dbo].[FeedBackService]
                      ([ServiceID]
                     ,[AccountID]
                     ,[Date]
                     ,[Comment]
                     ,[Status]
                     ,[Note])
                     VALUES
                    (1,1,GETDATE(),N'Phục vụ nhiệt tình',0,'')
 INSERT INTO [dbo].[Comment]([Content],[username],[Date],[ParentID],[BlogID])VALUES (N'@Katee Thank u','Sadella','2022-07-19 00:56:58.800',43,8)
INSERT INTO [dbo].[Comment]([Content],[username],[Date],[ParentID],[BlogID])VALUES (N'Bài viết hay lắm.Thank youuu','Sadella','2022-07-19 11:22:43.490',0,8)
INSERT INTO [dbo].[Comment]([Content],[username],[Date],[ParentID],[BlogID])VALUES (N'Cảm ơn các bạn đã đóng góp','Katee','2022-07-24 15:54:54.400',0,8)
INSERT INTO [dbo].[Comment]([Content],[username],[Date],[ParentID],[BlogID])VALUES (N'Cần nhiều dẫn chứng hơn','Katee','2022-07-17 02:17:48.973',0,9)
INSERT INTO [dbo].[Comment]([Content],[username],[Date],[ParentID],[BlogID])VALUES (N'@Katee Thank u','Katee','2022-07-17 02:18:33.077',44,9)
INSERT INTO [dbo].[Comment]([Content],[username],[Date],[ParentID],[BlogID])VALUES (N'@Sadella Thank u','Sadella','2022-07-17 02:18:33.077',72,8)
INSERT INTO [dbo].[Comment]([Content],[username],[Date],[ParentID],[BlogID])VALUES (N'Cảm ơn mọi người','Sadella','2022-07-24 19:18:11.947',0,9)
INSERT INTO [dbo].[Comment]([Content],[username],[Date],[ParentID],[BlogID])VALUES (N'Bài viết ok','Sadella','2022-07-24 19:18:11.947',0,9)
INSERT INTO [dbo].[Comment]([Content],[username],[Date],[ParentID],[BlogID])VALUES (N'@Katee Mình sẽ rút kinh nghiệm','Katee','2022-07-24 19:18:11.947',45,9)
 