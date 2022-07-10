<%-- 
    Document   : Notification
    Created on : Jul 8, 2022, 2:40:36 PM
    Author     : TranQuangHuy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông báo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
        <link rel="stylesheet" href="css/fontawesome.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/templatemo-style.css">
        <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <style>
        .notifather{
            position: relative;
        }
        .notifi{
            position: absolute;
            right: 10px;
            top: 20px;
        }
        .notifi1{
            position: absolute;
            right: 10px;
            top: 40px;
        }
        .Main{
            color: white;
        }
        .texxt{
            position: fixed;
            bottom: 50px;
            left: 280px;
            width: 100px;
            height: 40px;
            background-color: white;
            color: black;
            border-radius: 5px;
        }
        .texxt1{
            position: fixed;
            bottom: 20px;
            left: 640px;
            border-radius: 5px;
            background-color: white;
            color: black;
            margin: 0px 30px;
        }
        .button{
            position: fixed;
            bottom: 40px;
            left: 1200px;
            width: 80px;
            height: 40px;
            border-radius: 5px;
            background-color: #F5A623;
            color: white;
        }
        .button:hover{
            cursor: pointer;
            transform: scale(0.98);
        }
        .text{position: fixed;
            bottom: 45px;
            left: 430px;
            width: 200px;
            height:50px;
            border-radius: 5px;
            background-color: white;
            color: black;
        }
        .recep{
            position: fixed;
            bottom: 30px;
            left: 30px;
            width: 220px;
            height: 60px;
            border-radius: 5px;
            background-color: #F5A623;
            color: white;
            margin-right: 30px;
        }
    </style>
    <body id="reportsPage">
        <div class="" id="home">
            <nav class="navbar navbar-expand-xl" style="margin-bottom: 15px">
                <div class="container h-100">
                    <a class="navbar-brand" href="AdminController">
                        <h1 class="tm-site-title mb-0">Admin</h1>
                    </a>
                    <button class="navbar-toggler ml-auto mr-0" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fas fa-bars tm-nav-icon"></i>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav mx-auto h-100">
                            <li class="nav-item">
                                <a class="nav-link" href="AdminController">
                                    <i class="fas fa-tachometer-alt"></i>
                                    Bảng điều khiển
                                    <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li class="nav-item dropdown">

                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                                   aria-haspopup="true" aria-expanded="false">
                                    <i class="far fa-file-alt"></i>
                                    <span>
                                        Báo cáo <i class="fas fa-angle-down"></i>
                                    </span>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="#">Báo cáo ngày</a>
                                    <a class="dropdown-item" href="#">Báo cáo tuần</a>
                                    <a class="dropdown-item" href="#">Báo cáo năm</a>
                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="RoomcategoryController?do=getroombycategori&i=1">
                                    <i class="fas fa-shopping-cart"></i>
                                    Phòng
                                </a>
                            </li>

                            <li class="nav-item dropdown nav-item">
                                <a class="nav-link dropdown-toggle" href="accountAdmin.jsp" id="navbarDropdown" role="button" data-toggle="dropdown"
                                   aria-haspopup="true" aria-expanded="false">
                                    <i class="far fa-user"></i>
                                    <span>
                                        Quản lí tài khoản <i class="fas fa-angle-down"></i>
                                    </span>
                                </a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                                   aria-haspopup="true" aria-expanded="false">
                                    <i class="fab fa-blogger"></i>
                                    <span>
                                        Blog <i class="fas fa-angle-down"></i>
                                    </span>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="BlogManagerController?do=editblog">Chỉnh sửa blog</a>
                                    <a class="dropdown-item" href="addblog.jsp">Thêm Blog</a>

                                </div>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="RequestController?do=listMessFeedBack">
                                    <i class="fas fa-newspaper"></i></i> Yêu cầu
                                </a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                                   aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-cog"></i>
                                    <span>
                                        Cài đặt <i class="fas fa-angle-down"></i>
                                    </span>
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="AdminController?do=viewProfileAdmin">Thông tin</a>
                                    <a class="dropdown-item" href="OrderController?do=showCartAdmin">Hóa đơn</a>
                                    <a class="dropdown-item" href="#">Customize</a>
                                </div>
                            </li>
                            <li class="nav-item active">
                                <a class="nav-link" href="NotificationController">
                                    <i class="fas fa-bell"></i></i> Thông báo
                                </a>
                            </li>
                        </ul>
                        <ul class="navbar-nav ">
                            <li class="nav-item">
                                <a class="nav-link d-block" href="LoginController?do=logout">
                                    Admin, <span>Đăng xuất</span>                                   
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>

            </nav>
            <div class="container" >
                <div class="row col-md-14 grid-margin">
                    <div class="col-sm-12 col-md-12  tm-block-col">
                        <div class="tm-bg-primary-dark tm-block">
                            <div class="tm-notification-items">
                                <c:forEach items="${list}" var="n">
                                    <div class="media tm-notification-item notifather">
                                    <div class="tm-gray-circle"><img src="images/notification-03.jpg" alt="Avatar Image" class="rounded-circle"></div>
                                    <div class="media-body">
                                        <p class="mb-2"><b>${n.name}</b> ${n.title} <b>${n.focus}</b> Noi dung: 
                                            <a href="#" class="tm-notification-link">${n.content}</a>.</p>
                                        <span class="tm-small tm-text-color-secondary">${n.date}.</span>
                                        <a href="NotificationController?do=Delete&nID=${n.getNID()}"><i class='bx bxs-message-square-x notifi' style="color:window" onclick="deleteN()"></i></a>
                                    </div>
                                </div> 
                                </c:forEach> 
                            </div>
                        </div>
                    </div>   
                    <div>
                        <button class="recep">Gửi thông báo tới lễ tân</button>
                    </div>
                    <br>
                    <form action="NotificationController?do=SentMessage" method="post">
                    <div class="BoxSentMess">                  
                        <div class="Main">
                            <select class="texxt" name="NameRe" id="user">
                                <c:forEach items="${listA}" var="a">
                                    <c:if test="${a.getRoleID()==2}">
                                        <option value="${a.getUser()}">${a.getUser()}</option>
                                    </c:if>                                   
                                </c:forEach>                                
                            </select>
                            <input required="" id="title" name="title" type="text" maxlength="100" placeholder="Tiêu đề" class="text">
                            <textarea required="" id="content" name="content" type="text" rows="3" cols="60" placeholder="Nội dung tin nhắn" class="texxt1"></textarea>
                            <button onclick="Showmess()" class="button" type="submit">Sent</button>
                        </div>
                    </div>
                     </form>
                </div>
            </div>
        </div>


        <div class="container" >
            <div class="row tm-content-row">

                <!--notification-->


            </div>
        </div>
                                    <script>
                                        function Showmess(){
                                            var user =document.getElementById("user").value;
                                        var title =document.getElementById("title").value;
                                        var content =document.getElementById("content").value;
                                        if(title!="" && content!=""){
                                            alert("Tin nhắn đã được gửi thành công đến lễ tân "+user);
                                        }
                                    }
                                        function deleteN(){
                 
                                            alert("Xóa thông báo thành công");
                                    }
                                    </script>



        <script src="js/jquery-3.3.1.min.js"></script>

        <script src="js/moment.min.js"></script>

        <script src="js/Chart.min.js"></script>

        <script src="js/bootstrap.min.js"></script>

        <script src="js/tooplate-scripts.js"></script>
        <script src="https://code.iconify.design/2/2.2.1/iconify.min.js"></script>
    </body>
</html>
