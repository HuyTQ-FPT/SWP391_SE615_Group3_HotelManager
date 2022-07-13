<%-- 
    Document   : viewFeedBack
    Created on : Jun 15, 2022, 9:53:41 AM
    Author     : MInh Hiếu
--%>

<%@page import="entity.RequestMessage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
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
                                  <a class="dropdown-item" href="AdminController?do=ReportDay">Báo cáo doanh số theo phòng</a>
                                <a class="dropdown-item" href="AdminController?do=ReportMonth">Báo cáo tháng</a>
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
        <%
            RequestMessage s = (RequestMessage) request.getAttribute("seen");
        %>
        <div class="container">
            <div class="row">
                <div class="col">
                    <p class="text-white mt-5 mb-5"></p>
                </div>
            </div>
            <div class="row tm-content-row">




                <div class="col-12 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-taller tm-block-scroll">
                        <h2 class="tm-block-title">Nội dung</h2>


                        <table class="table">

                            <thead>
                                <tr>
                                    <th scope="col"> Email</th>
                                    <th scope="col">Tiêu đề</th>
                                    <th  scope="col">Nội dung</th>
                                    <th  scope="col"></th>


                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <td>  <%=s.getEmail()%> </td>
                                    <td><p style="width: 150px; word-break: break-all"><%=s.getTitle()%></p></td>
                                    <td ><p style="width: 200px; word-break: break-all"><%=s.getContent()%></p></td>
                                    <td >   <a href="RequestController?do=viewReply&mID=<%=s.getmId()%>&email=<%=s.getEmail()%> "> <button  style=""  class="btn btn-primary">  Trả lời </button></a></td>


                                </tr>

                            </tbody>

                        </table>
                        <button  style="margin-top: 20px" onclick="deleteId('<%=s.getmId()%>')" class="btn btn-primary">  Xoá </a></button>
                        <a style="float: right; margin-top: 20px" class="btn btn-danger" href="RequestController?do=listMessFeedBack&index=${index}">Trang trước</a>

                    </div>
                </div>
            </div>
        </div>
        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="js/moment.min.js"></script>
        <!-- https://momentjs.com/ -->
        <script src="js/Chart.min.js"></script>
        <!-- http://www.chartjs.org/docs/latest/ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <script src="js/tooplate-scripts.js"></script>
        <script>
                            function deleteId(id) {
                                if (confirm("Bạn có muốn xoá yêu cầu này không?")) {
                                    window.location = "RequestController?do=deleteMessage&mId=" + id;
                                }

                            }

        </script>
    </body>
</html>
