<%-- 
    Document   : updateProfileAdmin
    Created on : Jun 9, 2022, 10:48:02 PM
    Author     : Minh Hieu
--%>

<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                                <a class="nav-link " href="AdminController">
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
                                <a class="nav-link" href="SendFeedbackController?do=listMessFeedBack">
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
                                <div class="dropdown-menu active" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="AdminController?do=viewProfileAdmin">Thông tin</a>
                                    <a class="dropdown-item" href="#">Billing</a>
                                    <a class="dropdown-item" href="#">Customize</a>
                                </div>
                            </li>
                        </ul>
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link d-block" href="LoginController?do=logout">
                                    Admin,<sapn>Đăng xuất</sapn>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>

            </nav>
            <div class="container mt-5">

                <!-- row -->
                <div class="row tm-content-row">
                    <div class="tm-block-col tm-col-avatar">
                        <div class="tm-bg-primary-dark tm-block tm-block-avatar">

                            <div class="tm-avatar-container">
                                <img
                                    src="images/anhdaidien/admin.jpg"
                                    alt="Avatar"
                                    class="tm-avatar img-fluid mb-4"
                                    />
                                <!--                                <a href="#" class="tm-avatar-delete-link">
                                                                    <i class="far fa-trash-alt tm-product-delete-icon"></i>
                                                                </a>-->
                            </div>
                            <!--                            <button class="btn btn-primary btn-block text-uppercase">
                                                            Upload New Photo
                                                        </button>-->

                            <a class="btn btn-primary btn-block " href="LoginController?do=ChangePassword1">
                                Thay đổi mật khẩu
                            </a>
                        </div>
                    </div>
                    <%
                        User user = (User) session.getAttribute("u");
                    %>
                    <div class="tm-block-col tm-col-account-settings">
                        <div class="tm-bg-primary-dark tm-block tm-block-settings">

                            <h4 style="color: red;font-size: 15px;">${requestScope.err}</h4>
                            <h4 style="color: red;font-size: 15px;">${requestScope.mess}</h4>
                            <form action="AdminController?do=updateAdmin" method="POST" class="tm-signup-form row">
                                <input type="hidden" name="uid" value="<%=user.getUserID()%>">
                                <div class="form-group col-lg-6">
                                    <label for="inputYourname">Tên</label>
                                    <input style="background-color: white; color: #54657D;"
                                           id="name"
                                           name="name"
                                           type="text"
                                           maxlength="50"
                                           required
                                           value="<%=user.getUserName()%>"
                                           class="form-control validate"
                                           />
                                </div>
                                <div class="form-group col-lg-6">
                                    <label for="email">Email</label>
                                    <i class="fas fa-star style" style="color:red;"></i>   <input style="background-color: white; color: #54657D;"
                                                                                                  id="email"
                                                                                                  name="inputEmailAddress"
                                                                                                  type="email"
                                                                                                  maxlength="100" 
                                                                                                  required
                                                                                                  value="<%=user.getUserEmail()%>"
                                                                                                  class="form-control  validate"
                                                                                                  />
                                </div>
                                <div class="form-group col-lg-6">
                                    <label for="inputCMT">CMT</label>
                                    <i class="fas fa-star style" style="color:red;"></i>    <input style="background-color: white; color: #54657D;"
                                                                                                   id="email"
                                                                                                   name="inputCMT"
                                                                                                   type="text"
                                                                                                   maxlength="20" required 
                                                                                                   value="<%=user.getCMT()%>"

                                                                                                   class="form-control validate"
                                                                                                   />
                                </div>
                                <div class="form-group col-lg-6">
                                    <label for="inputAdress">Địa chỉ</label>
                                    <input style="background-color: white; color: #54657D;"
                                           id="email"
                                           name="inputAdress"
                                           type="text"
                                           required maxlength="100"
                                           value="<%=user.getUserAdress()%>"
                                           class="form-control validate"
                                           />
                                </div>


                                <div class="form-group col-lg-6">
                                    <label for="phone">Số điện thoại</label>
                                    <input style="background-color: white; color: #54657D;"
                                           id="phone"
                                           name="inputPhone"
                                           type="tel"
                                           required maxlength="15"
                                           value="<%=user.getUserPhone()%>"
                                           class="form-control validate"
                                           />
                                </div>
                                <div class="form-group col-lg-6">
                                    <label for="inputBirthday">Ngày sinh</label>
                                    <input style="background-color: white; color: #54657D;"
                                           id="phone"
                                           name="inputBirthday"
                                           type="date"

                                           value="<%=user.getBirthday()%>"
                                           class="form-control validate"
                                           />
                                </div>

                                <div class="col-12">
                                    <button
                                        type="submit"
                                        name="submit"
                                        class="btn btn-primary btn-block text-uppercase"
                                        >
                                        Lưu
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
    </body>
</html>
