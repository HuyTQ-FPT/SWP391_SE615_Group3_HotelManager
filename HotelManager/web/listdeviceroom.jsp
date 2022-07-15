<%-- 
    Document   : editroomdevice
    Created on : Jun 8, 2022, 10:24:44 PM
    Author     : NTD
--%>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" 
href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
<script type="text/javascript" 
src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" 
src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Product Page - Admin HTML Template</title>
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:400,700"
            />
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="css/fontawesome.min.css" />
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="css/templatemo-style.css">
        <link rel="stylesheet" href="css/style.css">
    </head>

    <body id="reportsPage">
        <nav class="navbar navbar-expand-xl">
            <div class="container h-100">
                <a class="navbar-brand" href="index.html">
                    <h1 class="tm-site-title mb-0">Admin</h1>
                </a>
                <button
                    class="navbar-toggler ml-auto mr-0"
                    type="button"
                    data-toggle="collapse"
                    data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
                    >
                    <i class="fas fa-bars tm-nav-icon"></i>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mx-auto h-100">
                        <li class="nav-item">
                            <a class="nav-link" href="index.html">
                                <i class="fas fa-tachometer-alt"></i> Biểu Đồ
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a
                                class="nav-link dropdown-toggle"
                                href="#"
                                id="navbarDropdown"
                                role="button"
                                data-toggle="dropdown"
                                aria-haspopup="true"
                                aria-expanded="false">
                                <i class="far fa-file-alt"></i>
                                <span> Báo Cáo <i class="fas fa-angle-down"></i> </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Báo Cáo Hàng Ngày</a>
                                <a class="dropdown-item" href="#">Báo Cáo Hàng Ngày</a>
                                <a class="dropdown-item" href="#">Báo Cáo Hàng Ngày</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a
                                class="nav-link dropdown-toggle"
                                href="#"
                                id="navbarDropdown"
                                role="button"
                                data-toggle="dropdown"
                                aria-haspopup="true"
                                aria-expanded="false">
                                <i class="fas fa-door-open"></i>
                                <span> Phòng <i class="fas fa-angle-down"></i> </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="RoomsController?do=listroom">Dann Sách Phòng</a>
                                <a class="dropdown-item" href="DeviceController?do=listalldevice">Danh Sách Thiết Bị</a>
                                <a class="dropdown-item" href="RoomcategoryController?do=getroombycategori">Loại Phòng</a>
                            </div>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="ServiceController?do=ListService">
                                <i class="fa fa-bars"></i> Dịch Vụ
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="accounts.html">
                                <i class="far fa-user"></i> Tài Khoản
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="accounts.html">
                                <i class="far fa-user"></i> Dịch Vụ Đi Kèm
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
                        </li>
                        <li class="nav-item dropdown">
                            <a
                                class="nav-link dropdown-toggle"
                                href="#"
                                id="navbarDropdown"
                                role="button"
                                data-toggle="dropdown"
                                aria-haspopup="true"
                                aria-expanded="false">
                                <i class="fas fa-cog"></i>
                                <span> Cài Đặt <i class="fas fa-angle-down"></i> </span>
                            </a>
                        </li>
                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link d-block" href="login.html">
                                Admin, <b>Logout</b>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <h1 style="text-align: center; color: wheat">Danh Sách Thiết BỊ</h1>
        <h3 style="text-align: center; color: wheat">Phòng:${room.roomname}</h3>
        <a style="border-radius: 10px; float: right; margin-bottom: 10px" href="DeviceController?do=InsertDeviceRoom&RoomID=${room.roomID}" class="btn btn-danger">Thêm Thiết Bị</a>
        <table id="myTable" class="display table" width="90%">  
            <thead>  
                <tr>  
                    <th style="text-align: center">ID</th> 
                    <th style="text-align: center">Ảnh</th> 
                    <th style="text-align: center">Tên</th>  
                    <th style="text-align: center">Giá</th>  
                    <th style="text-align: center">Trạng Thái</th>  
                    <th style="text-align: center">Ghi Chú</th>  
                    <th style="text-align: center">Số Lượng</th>  
                    <th style="text-align: center">Chỉnh Sửa</th>  
                    <th style="text-align: center">Xóa</th>  
                </tr>  
            </thead>  

            <tbody>  
                <c:forEach items="${listdevice}" var="r">
                    <tr style="background-color: 435C70" >  
                        <td style="background-color: 435C70 ; width: 3%"><span class="badge badge-primary badge-pill">${r.deviceID}</span></td>  
                        <td style="background-color: 435C70 ; width: 10%" ><img style="width: 150px; height: 100px" src="images/anhphong/${r.imagedevice}" class="img-thumbnail"></td>
                        <td style="background-color: 435C70 ; width: 20%; text-align: center "><span class="d-inline-block text-truncate" style="max-width: 300px;">${r.deviceName}</span></td>  
                        <td style="background-color: 435C70 ; width: 10%; color: orangered; font-style: inherit;text-align: center">${r.price} $</td>  
                        <c:if test="${r.status==0}"> 
                            <td style="background-color: 435C70 ; width: 10%;text-align: center">Hoạt Động</td>  
                        </c:if>
                        <c:if test="${r.status==1}">
                            <td style="background-color: 435C70 ; width: 10% ;text-align: center">Không Hoạt Động</td>  
                        </c:if>
                        <c:if test="${r.status==2}">
                            <td style="background-color: 435C70 ; width: 10%;text-align: center">Khác</td>  
                        </c:if>
                        <td style="background-color: 435C70 ; color: beige ; width: 10%; font-family: fantasy;text-align: center">${r.note}</td> 
                        <td style="background-color: 435C70 ; color: beige ; width: 10%; font-family: fantasy;text-align: center">${r.quantity}</td> 
                        <td style="background-color: 435C70 ;width: 20%" >
                            <a style="border-radius: 10px; margin-left: 29%" href="DeviceController?do=UpdateDeviceByRoom&DeviceID=${r.deviceID}&RoomID=${r.roomID}" class="btn btn-info" role="button">
                                Cập Nhật</a></td>  
                        <td style="background-color: 435C70">
                            <a style="margin-left: 43%" href="DeviceController?do=DeleteDeviceRoom&RoomID=${r.roomID}&DeviceID=${r.deviceID}" class="tm-product-delete-link">
                                <i class="far fa-trash-alt tm-product-delete-icon">
                                </i></a></td>  
                    </tr>  
                </c:forEach>
            </tbody>  
        </table>  
        <footer class="tm-footer row tm-mt-small">
            <div class="col-12 font-weight-light">
                <p class="text-center text-white mb-0 px-4 small">
                    Copyright &copy; <b>2018</b> All rights reserved. 

                    Design: <a rel="nofollow noopener" href="https://templatemo.com" class="tm-footer-link">Template Mo</a>
                </p>
            </div>
        </footer>
        <script>
            $(function () {
                $(".tm-product-name").on("click", function () {
                    window.location.href = "edit-product.html";
                });
            });
            $(document).ready(function () {
                $('#myTable').DataTable(
                        {
                            "aLengthMenu": [[3, 6, 15, 30, -1], [3, 6, 15, 30, "All"]],
                            "iDisplayLength": 3,
                            "language": {
                                "lengthMenu": "Hiển Thị _MENU_ Trên Trang",
                                "search": "Tìm Kiếm",
                                "zeroRecords": "Không Có Bản Ghi Nào Phù Hợp",
                                "info": "Hiển Thị Trang _PAGE_ Trên _PAGES_",
                                "infoEmpty": "Danh Sách Trống",
                                "infoFiltered": "(Không Tìm Thấy Thiết Bị/_MAX_ Dịch Vụ)"
                            }
                        });
            });
        </script>
    </body>
</html>
