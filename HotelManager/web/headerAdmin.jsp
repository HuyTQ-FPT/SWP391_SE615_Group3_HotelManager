<%-- 
    Document   : headerAdmin
    Created on : Jun 19, 2022, 3:56:35 PM
    Author     : Minh Hieu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
                            <a class="nav-link active" href="AdminController">
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
                                <a class="dropdown-item" href="AdminController?do=incomeRoom">Báo cáo doanh số theo phòng</a>
                                <a class="dropdown-item" href="AdminController?do=ReportMonth">Báo cáo tháng</a>
                              
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
                                <a class="dropdown-item" href="BlogManagerController?do=editblog&page=1">Chỉnh sửa blog</a>
                                <a class="dropdown-item" href="addblog.jsp">Thêm Blog</a>
                            </div>
                        </li>
                           <li class="nav-item">
                            <a class="nav-link" href="ManagerAccount">
                                <i class="fas fa-address-card"></i></i> Role
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="RequestController?do=listRequest">
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
                        <li class="nav-item">
                            <a class="nav-link" href="NotificationController">
                                <i class="fas fa-bell"></i> Thông báo
                            </a>
                        </li>
                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link d-block" href="LoginController?do=logout">
                            Admin,<span>Đăng xuất</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

        </nav>
    </body>
</html>
