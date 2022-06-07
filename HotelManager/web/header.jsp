<%-- 
    Document   : heade
    Created on : Jun 4, 2022, 3:47:17 PM
    Author     : Thai Quan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
    <header>
             <div class="site-navbar-wrap js-site-navbar bg-white">

                <div class="container">
                    <div class="site-navbar bg-light">
                        <div class="py-1">
                            <div class="row align-items-center">
                                <div class="col-2">
                                    <h2 class="mb-0 site-logo"><a href="index.html">Hoang Hon</a></h2>
                                </div>
                                <div class="col-10">
                                    <nav class="site-navigation text-right" role="navigation">
                                        <div class="container">

                                            <div class="d-inline-block d-lg-none  ml-md-0 mr-auto py-3"><a href="#" class="site-menu-toggle js-menu-toggle"><span class="icon-menu h3"></span></a></div>
                                            <ul class="site-menu js-clone-nav d-none d-lg-block">
                                                <li class="active"> 
                                                                               
                                                </li>
                                                <li class="active">
                                                    <a style="font-family: PlayFair Display" href="HomeController">Trang chủ</a>
                                                </li>
                                                <li class="has-children">
                                                    <a style="font-family: PlayFair Display" href="RoomController?page=1">Phòng</a>
                                                    <ul class="dropdown arrow-top">
                                                        <li><a style="font-family: PlayFair Display" href="RoomController?do=CateRoom&cate=1">Standard</a></li>
                                                        <li><a style="font-family: PlayFair Display" href="RoomController?do=CateRoom&cate=2">Superior</a></li>
                                                        <li><a style="font-family: PlayFair Display" href="RoomController?do=CateRoom&cate=3">Deluxe</a></li>
                                                        <li><a style="font-family: PlayFair Display" href="RoomController?do=CateRoom&cate=4">Suite</a></li> 
                                                        <li><a style="font-family: PlayFair Display" href="RoomController?do=CateRoom&cate=5">Connecting room</a></li> 
                                                        <li class="has-children">
                                                            <a style="font-family: PlayFair Display" href="rooms.html">Dịch vụ</a>
                                                            <ul class="dropdown">
                                                                <li><a style="font-family: PlayFair Display" href="rooms.html">Phòng cao cấp</a></li>
                                                                <li><a style="font-family: PlayFair Display" href="rooms.html">Tắm hơi</a></li>
                                                                <li><a style="font-family: PlayFair Display" href="rooms.html">Ăn uống</a></li> 

                                                            </ul>
                                                        </li>

                                                    </ul>
                                                </li>
                                                <li><a style="font-family: PlayFair Display" href="events.html">Sự kiện</a></li>
                                                <li><a style="font-family: PlayFair Display" href="BlogController?do=getBlog">Thông tin</a></li>
                                                <li><a style="font-family: PlayFair Display" href="contact.html">Liên hệ</a></li>
                                                    <%
                                                        if (session.getAttribute("login") == null) {
                                                    %>
                                                <li class="login"><a style="font-family: PlayFair Display" href="LoginController">Đăng Nhập</a></li>
                                                <li class="register"><a style="font-family: PlayFair Display" href="Register.jsp">Đăng ký</a></li>
                                                    <% } else {%>
                                                <li class="login"><a style="font-family: PlayFair Display" href="LoginController?do=logout">Đăng xuất</a></li>
                                                
                                                <li class="user"><a id="showmore" onclick="show()" style="font-family: PlayFair Display; cursor: pointer;"><span style=" font-size: 30px;" class="iconify" data-icon="bxs:user-circle"></span></a>
                                      
                                                </li>   
                                                    <%}%>
                                            </ul>
                                        </div>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </header>

