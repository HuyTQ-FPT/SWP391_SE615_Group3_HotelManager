<%-- 
    Document   : replyRequest
    Created on : Jul 5, 2022, 4:21:09 PM
    Author     : Minh Hiếu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Request</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="css/fontawesome.min.css">
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="css/templatemo-style.css">

        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
    </head>
       <style>
        .form-group{
            position: relative;
        }
        .style{
            position: absolute;
            left: 20px;
            top:40px;
            font-size: 10px;
        }
        .style1{
            position: absolute;
            left: 20px;
            top:310px;
            font-size: 10px;
        }
    </style>
</head>
<body id="reportsPage">
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
                            <a class="nav-link" href="ServiceController?do=getdeviceroom">
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
                                <a class="dropdown-item" href="BlogManagerController?do=editblog">Edit Blog</a>
                                <a class="dropdown-item" href="addblog.jsp">Insert Blog</a>

                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="RequestController?do=listMessFeedBack">
                                <i class="fas fa-newspaper "></i></i> Yêu cầu
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
                                <a class="dropdown-item" href="#">Billing</a>
                                <a class="dropdown-item" href="#">Customize</a>
                            </div>
                        </li>
                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link d-block" href="LoginController?do=logout">
                                Admin, <b>Đăng xuất</b>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

        </nav>
    <div class="tm-block-col tm-col-account-settings" style="margin-left: auto; margin-right: auto ">
        <div class="tm-bg-primary-dark tm-block tm-block-settings" >

            <h4 style="color: red;font-size: 15px;">${requestScope.err}</h4>
            <h4 style="color: red;font-size: 15px;">${requestScope.mess1}</h4>
            <form action="RequestController?do=sendReply" method="POST" class="tm-signup-form row">

                <div class="form-group col-lg-12">
                    <i class="fas fa-star style" style="color:red;"></i>         <label for="email">Email nhận</label>
                    <input style="background-color: white; color: #54657D;"
                           id="email"
                           name="inputEmail"
                           type="email"
                           maxlength="100" 
                           required
                           value="${email}"
                           readonly
                           class="form-control  validate"
                           />
                </div>
                <div class="form-group col-lg-12">
                    <i class="fas fa-star style" style="color:red;"></i> <label for="inputYourname">Tên người gửi</label>
                    <input pattern=".*\S" title="Không được để khoảng trắng"  style="background-color: white; color: #54657D;"
                           id="name"
                           name="name"
                           type="text"
                           maxlength="50"
                           required
                           value=""
                           class="form-control validate"
                           />
                </div>
                <div class="form-group col-lg-12">
                    <label for="inputCMT">Tiêu đề</label>
                    <i class="fas fa-star style" style="color:red;"></i>     <input pattern=".*\S" title="Không được để khoảng trắng" t style="background-color: white; color: #54657D;"
                                                                                   id=""
                                                                                   name="inputTitle"
                                                                                   type="text"
                                                                                   maxlength="40" required 
                                                                                   value=""

                                                                                   class="form-control validate"
                                                                                   />
                </div>
                <div class="form-group col-lg-12">
                    <label for="inputAdress">Nội dung</label>
                    <i class="fas fa-star style" style="color:red;"></i>     <input style="background-color: white; color: #54657D;"
                                                                                    id="email"
                                                                                    name="inputContent"
                                                                                    type="text"
                                                                                    pattern=".*\S" title="Không được để khoảng trắng" 
                                                                                    required maxlength="100"
                                                                                    value=""
                                                                                    class="form-control validate"
                                                                                    />
                </div>


                <div class="col-12">
                    <button
                        type="submit"
                        name="submit"
                        class="btn btn-primary btn-block text-uppercase"
                        >
                        GỬI
                    </button>
                </div>
            </form>
        </div>
    </div>
              <script src="js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
</body>
</html>
