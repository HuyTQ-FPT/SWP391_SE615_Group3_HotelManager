<%-- 
    Document   : editroomdevice
    Created on : Jun 8, 2022, 10:24:44 PM
    Author     : NTD
--%>

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
        <!--
            Product Admin CSS Template
            https://templatemo.com/tm-524-product-admin
        -->
    </head>

    <body id="reportsPage">
        <nav class="navbar navbar-expand-xl">
            <div class="container h-100">
                <a class="navbar-brand" href="index.html">
                    <h1 class="tm-site-title mb-0">Product Admin</h1>
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
                                <i class="fas fa-tachometer-alt"></i> Dashboard
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
                                <span> Reports <i class="fas fa-angle-down"></i> </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Daily Report</a>
                                <a class="dropdown-item" href="#">Weekly Report</a>
                                <a class="dropdown-item" href="#">Yearly Report</a>
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
                                <span> Room <i class="fas fa-angle-down"></i> </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="RoomsController?do=listroom">ListRoom</a>
                                <a class="dropdown-item" href="#">Weekly Report</a>
                                <a class="dropdown-item" href="#">Yearly Report</a>
                            </div>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="accounts.html">
                                <i class="far fa-user"></i> Accounts
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
                                <a class="dropdown-item" href="BlogManagerController?do=insertblog">Update Blog</a>
                                <a class="dropdown-item" href="BlogManagerController">Insert Blog</a>
                                <a class="dropdown-item" href="BlogManagerController">Delete Blog</a>
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
                                <i class="fas fa-cog"></i>
                                <span> Settings <i class="fas fa-angle-down"></i> </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Profile</a>
                                <a class="dropdown-item" href="#">Billing</a>
                                <a class="dropdown-item" href="#">Customize</a>
                            </div>
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
        <h1 style="text-align: center; color: wheat">List RoomCategori Manager </h1>
        <div class="">
            <div class="row tm-content-row">
                <!--                <div class="col-sm-12 col-md-12 col-lg-8 col-xl-8 tm-block-col">
                                    <div class="tm-bg-primary-dark tm-block tm-block-products">
                                        <div class="tm-product-table-container">
                                            <table class="table table-hover tm-table-small tm-product-table">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">&nbsp;</th>
                                                        <th scope="col">DeviceName</th>
                                                        <th scope="col">Price</th>
                                                        <th scope="col">Status</th>
                                                        <th scope="col">Quantity</th>
                                                        <th scope="col">Delete</th>
                                                        <th scope="col">Update</th>
                                                        <th scope="col">&nbsp;</th>
                                                    </tr>
                                                </thead>

                    <form action="ServiceController" method="get">
                        <tbody>

                            <tr>
                                <th scope="row"><input type="hidden" /></th>
                                <td ><input class="form-control validate" type="text" name="DeviceName" value=""></td>
                                <td ><input class="form-control validate" type="number" name="Price" value=""></td>
                                <td ><input class="form-control validate" type="number" name="Status" value=""></td>
                                <td ><input class="form-control validate" type="number" name="Quantity" value=""></td>
                        <input type="hidden" name="DeviceID" value="">
                        <input type="hidden" name="RoomcateID" value="">
                        <td>
                            <a href="ServiceController?do=deleteroom&RoomcateID=&DeviceID=" class="tm-product-delete-link">
                                <i class="far fa-trash-alt tm-product-delete-icon"></i>
                            </a>
                        </td>
                        <td>
                            <button type="submit" name="do" value="updateroomdevice" class="tm-product-delete-link">
                                <i class="fas fa-arrow-alt-circle-up tm-product-delete-icon"></i>
                            </button>
                        </td>
                        </tr>
                        </tbody>
                    </form>

                
                -->         
                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
                    <form action="ServiceController" method="get">
                        <input type="hidden" name="cateroom" value="">
                        <input type="hidden" name="do" value="getdeviceroom">
                        <input value="" class="btn btn-primary btn-block text-uppercase mb-3" type="text" placeholder="Tìm kiếm.." name="Mess">
                    </form>
                </div>
                <!--
            </table>
        </div>
        <div style="padding-left: 32%;"class="site-block-27">
            <ul>
                <li><a href="#">&lt;</a></li>
                <li class="active"><span>1</span></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">&gt;</a></li>
            </ul>
        </div>

         table container 
        <form action="ServiceController" method="get">
            <tbody>
                <tr>
                    <th scope="row"><input type="hidden" /></th>
            <h5 style="display: inline-block; margin-left: 1%; font-family: PlayFair Display; color: white">INSERT ROOM DEVICE</h5>   
            <span>
                <td ><input class="form-control validate" type="text" name="DeviceName" value="" placeholder="DeviceName"></td>
                <td ><input class="form-control validate" type="number" name="Price" value="" placeholder="Price"></td>
                <td ><input class="form-control validate" type="number" name="Status" value="" placeholder="Status"></td>
                <td ><input class="form-control validate" type="number" name="Quantity" value="" placeholder="Quantity"></td>
            </span>
            <input type="hidden" name="RoomcateID" value="">
            <td>
                <button type="submit" name="do" value="insertdeviceroom" class="tm-product-delete-link">
                    <i class="fas fa-arrow-alt-circle-up tm-product-delete-icon"></i>
                </button>
            </td>
            </tr>
            </tbody>
        </form>
    </div>
</div>-->
                <div class="col-sm-12 col-md-12 col-lg-12 col-xl-12 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-product-categories">
                        <h2 class="tm-block-title"></h2>
                        <div class="tm-product-table-container">
                            <table class="table tm-table-small tm-product-table">
                                <tbody>
                                <th scope="col">DeviceName</th>
                                <th scope="col">Price</th>
                                <th scope="col">Status</th>
                                <th scope="col">Quantity</th>
                                <th scope="col">Quantity</th>
                                    <c:forEach items="${romcate}" var="r">
                                    <tr>

                                        <td>
                                            <h3> <p><strong>${r.catename}</strong></p></h3>
                                        </td>
                                        <td>
                                            <h3> <p><strong>${r.note}</strong></p></h3>
                                        </td>
                                        <td >
                                            <a data-toggle="modal" data-target="#exampleModal" class="tm-product-delete-link">
                                                <i class="far fa-trash-alt tm-product-delete-icon"></i>
                                            </a>
                                        </td>
                                        <td style="background-color: 435C70">
                                            <a href="RoomcategoryController?do=listroombycate&cateroomid=${r.roomcateID}" style="border-radius: 10px" class="btn btn-info" role="button">
                                                Danh Sách Phòng</a></td>
                                        <td>
                                            <a href="InsertCateroom.jsp" type="submit" name="do" value="updatetRoomCategory" class="tm-product-delete-link">
                                                <i class="fas fa-arrow-alt-circle-up tm-product-delete-icon"></i>
                                            </a>
                                        </td>
                                    </tr>
                                    <!-- Modal -->
                                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">XÓA LOẠI PHÒNG</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body" style="font-size: 30px;color: red">
                                                    XÁC NHẬN MUỐN XÓA
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">HỦY</button>
                                                    <a href="RoomcategoryController?do=deleteRoomCategori&cateroomid=${r.roomcateID}" type="button" class="btn btn-primary">XÁC NHẬN</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- table container -->     
                        <a href="" class="btn btn-default btn-rounded mb-4 btn btn-primary btn-block text-uppercase mb-3" data-toggle="modal" data-target="#modalLoginForm">Launch
                            THÊM LOẠI PHÒNG MỚI</a>
                    </div>
                    <div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header text-center">
                                    <h4 class="modal-title w-100 font-weight-bold">THÊM LOẠI PHÒNG MỚI</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form action="" method="">
                                    <div class="modal-body mx-3">
                                        <div class="md-form mb-5">
                                            <i class="fas fa-envelope prefix grey-text"></i>
                                            <input type="email" id="defaultForm-email" class="form-control validate">
                                            <label data-error="wrong" data-success="right" for="defaultForm-email">Your email</label>
                                        </div>

                                        <div class="md-form mb-4">
                                            <i class="fas fa-lock prefix grey-text"></i>
                                            <input type="password" id="defaultForm-pass" class="form-control validate">
                                            <label data-error="wrong" data-success="right" for="defaultForm-pass">Your password</label>
                                        </div>
                                    </div>
                                </form>
                                <div class="modal-footer d-flex justify-content-center">
                                    <button class="btn btn-default">Login</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div style="margin: 0 auto"class="site-block-27">
                    <ul>
                        <!--<li class="active"><span>1</span></li>-->
                        <c:forEach var = "i" begin = "1" end = "${n}">
                            <li class="${i==j? "active":""}"><a href="RoomcategoryController?do=getroombycategori&i=${i}">${i}</a></li>
                            </c:forEach>
                    </ul>
                </div>
                <!--                <table class="table table-hover tm-table-small tm-product-table">
                                    <thead>
                                        <tr>
                                            <th scope="col">&nbsp;</th>
                                            <th scope="col">PRODUCT NAME</th>
                                            <th scope="col">UNIT SOLD</th>
                                            <th scope="col">IN STOCK</th>
                                            <th scope="col">EXPIRE DATE</th>
                                            <th scope="col">&nbsp;</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <th scope="row"><input type="checkbox" /></th>
                                            <td class="tm-product-name">Lorem Ipsum Product 1</td>
                                            <td>1,450</td>
                                            <td>550</td>
                                            <td>28 March 2019</td>
                                            <td>
                                                <a href="#" class="tm-product-delete-link">
                                                    <i class="far fa-trash-alt tm-product-delete-icon"></i>
                                                </a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>    -->
            </div>
        </div>
        <footer class="tm-footer row tm-mt-small">
            <div class="col-12 font-weight-light">
                <p class="text-center text-white mb-0 px-4 small">
                    Copyright &copy; <b>2018</b> All rights reserved. 
                    Design: <a rel="nofollow noopener" href="https://templatemo.com" class="tm-footer-link">Template Mo</a>
                </p>
            </div>
        </footer>

        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <script>
            $(function () {
                $(".tm-product-name").on("click", function () {
                    window.location.href = "edit-product.html";
                });
            });
            <c:if test = "${update!= null}">
            alert("Update Successfully");
            </c:if>
        </script>
    </body>
</html>
