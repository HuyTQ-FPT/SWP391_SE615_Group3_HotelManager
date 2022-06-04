<%-- 
    Document   : heade
    Created on : Jun 4, 2022, 3:47:17 PM
    Author     : Thai Quan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
                                                    <a href="Search.jsp">
                                                        <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB4AAAAeCAYAAAA7MK6iAAAAAXNSR0IArs4c6QAAAeRJREFUSEvllu0tRFEQht+tABWgAlSAClABOqACVIAKUMHqABXQASpABeSROTI593wuN/vDSTab7J25z8y8M3N2ojmdyZy46gFvSVqTtCjpXdKTpIdZA6+BVySdSDrIAAjgVtKZpJeeIErgI0nnHS/D/rLVPge+lrTvXnJjmd1bmSk3pd+N7PA7bIGnwD7TV3s5eubOugW1bAbHki5q8BiMps/mBJSXoiOHLHckYRMayz/jtwBfrWkeg32JNwwAlCrQZMDDAXrqdCXIR3uINLmG/DaJwZ8Zx1hzX0lf2mBHUEulcnswzXJnxnumm/dFN5qL8aGpgCyYFFSHceL3qTltm32S78G+qYg26JcL3ENCoEjx1tJkHoxe6JiSIAfHh0Ml+HCCXCyV8Hzg/5uMU8H4jFNy/fj0aFzqlfDMl99PRTFjHqIrDVMdh0wUvvuL90DrHLdk6+e4qG+qifzmYjwoV627eQ/asjzw/7Dvol9tVwOnSWq7mtkFymmSqfV2QjsWBxc/mZDhpi2M1GrkhsIne/7qPqa8BOav0iK85R8IS4AxodtTh0ZinVIJsr9yRll4DexB7HI6lzKjOfqntG+C94BbRirYVOFjgQnAwwclHxMc4HwPOnxs8Ezj1KNpt+3/y/gLRZhwH/pUPqMAAAAASUVORK5CYII="
                                                             />
                                                    </a>                           
                                                </li>
                                                <li class="active">
                                                    <a style="font-family: PlayFair Display" href="HomeController">Trang chủ</a>
                                                </li>
                                                <li class="has-children">
                                                    <a style="font-family: PlayFair Display" href="RoomController?page=1">Phòng</a>
                                                    <ul class="dropdown arrow-top">
                                                        <li><a style="font-family: PlayFair Display" href="rooms.html">Hiện có</a></li>
                                                        <li><a style="font-family: PlayFair Display" href="rooms.html">Phòng đơn</a></li>
                                                        <li><a style="font-family: PlayFair Display" href="rooms.html">Phòng đôi</a></li>
                                                        <li><a style="font-family: PlayFair Display" href="rooms.html">Phòng gia đình</a></li> 
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
                                                <li><a style="font-family: PlayFair Display" href="about.html">Thông tin</a></li>
                                                <li><a style="font-family: PlayFair Display" href="contact.html">Liên hệ</a></li>
                                                    <%
                                                        if (session.getAttribute("login") == null) {
                                                    %>
                                                <li class="login"><a style="font-family: PlayFair Display" href="LoginController">Login</a></li>
                                                <li class="register"><a style="font-family: PlayFair Display" href="Register.jsp">Register</a></li>
                                                    <% } else {%>
                                                <li class="login"><a style="font-family: PlayFair Display" href="LoginController?do=logout">Log out</a></li>
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

