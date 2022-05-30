<%-- 
    Document   : index
    Created on : May 30, 2022, 2:50:07 PM
    Author     : admin
--%>

<%@page import="Entity.Image"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Hoang Hon &mdash; Hotel</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700|Work+Sans:300,400,700" rel="stylesheet">
        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="css/bootstrap.min_1_1.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="css/animate.css">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mediaelement@4.2.7/build/mediaelementplayer.min.css">



        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

        <link rel="stylesheet" href="css/aos.css">

        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700">
        <link rel="stylesheet" href="font-awesome-4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="css/datepicker.css" />
        <link rel="stylesheet" href="css/tooplate-style.css">
    </head>
    <style>
        .login{
            position: fixed;
            right: 120px;
        }
        .register{
            position: fixed;
            right: 40px;
        }
    </style>
    <body>
        <% Vector<Image> vector = (Vector<Image>) request.getAttribute("vector");
        %>
        <div class="site-wrap">

            <div class="site-mobile-menu">
                <div class="site-mobile-menu-header">
                    <div class="site-mobile-menu-close mt-3">
                        <span class="icon-close2 js-menu-toggle"></span>
                    </div>
                </div>
                <div class="site-mobile-menu-body"></div>
            </div> <!-- .site-mobile-menu -->


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
                                                    <a href="index.html">Trang chủ</a>
                                                </li>
                                                <li class="has-children">
                                                    <a href="rooms.html">Phòng</a>
                                                    <ul class="dropdown arrow-top">
                                                        <li><a href="rooms.html">Hiện có</a></li>
                                                        <li><a href="rooms.html">Phòng đơn</a></li>
                                                        <li><a href="rooms.html">Phòng đôi</a></li>
                                                        <li><a href="rooms.html">Phòng gia đình</a></li> 
                                                        <li class="has-children">
                                                            <a href="rooms.html">Dịch vụ</a>
                                                            <ul class="dropdown">
                                                                <li><a href="rooms.html">Phòng cao cấp</a></li>
                                                                <li><a href="rooms.html">Tắm hơi</a></li>
                                                                <li><a href="rooms.html">Ăn uống</a></li> 

                                                            </ul>
                                                        </li>

                                                    </ul>
                                                </li>
                                                <li><a href="events.html">Sự kiện</a></li>
                                                <li><a href="about.html">Thông tin</a></li>
                                                <li><a href="contact.html">Liên hệ</a></li>
                                                    <%
                                                        if (session.getAttribute("login") == null) {
                                                    %>
                                                <li class="login"><a href="Login.jsp">Login</a></li>
                                                <li class="register"><a href="Register.jsp">Register</a></li>
                                                    <% } else {%>
                                                <li class="login"><a href="Login.jsp">Log out</a></li>
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


            <div class="slide-one-item home-slider owl-carousel">
                <div class="site-blocks-cover overlay" style="background-image: url(images/hero_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
                    <div class="container">
                        <div class="row align-items-center justify-content-center">
                            <div class="col-xs-12 ml-auto mr-auto ie-container-width-fix">
                                <form action="index.html" method="get" class="tm-search-form tm-section-pad-2">
                                    <div class="form-row tm-search-form-row">
                                        <div class="form-group tm-form-element tm-form-element-100">
                                            <i class="fa fa-map-marker fa-2x tm-form-element-icon"></i>
                                            <input name="city" type="text" class="form-control" id="inputCity" placeholder="Type your destination...">
                                        </div>
                                        <div class="form-group tm-form-element tm-form-element-50">
                                            <i class="fa fa-calendar fa-2x tm-form-element-icon"></i>
                                            <input name="check-in" type="text" class="form-control" id="inputCheckIn" placeholder="Check In">
                                        </div>
                                        <div class="form-group tm-form-element tm-form-element-50">
                                            <i class="fa fa-calendar fa-2x tm-form-element-icon"></i>
                                            <input name="check-out" type="text" class="form-control" id="inputCheckOut" placeholder="Check Out">
                                        </div>
                                    </div>
                                    <div class="form-row tm-search-form-row">
                                        <div class="form-group tm-form-element tm-form-element-2">
                                            <select name="adult" class="form-control tm-select" id="adult">
                                                <option value="">Adult</option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5</option>
                                                <option value="6">6</option>
                                                <option value="7">7</option>
                                                <option value="8">8</option>
                                                <option value="9">9</option>
                                                <option value="10">10</option>
                                            </select>
                                            <i class="fa fa-2x fa-user tm-form-element-icon"></i>
                                        </div>
                                        <div class="form-group tm-form-element tm-form-element-2">
                                            <select name="children" class="form-control tm-select" id="children">
                                                <option value="">Children</option>
                                                <option value="0">0</option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5</option>
                                                <option value="6">6</option>
                                                <option value="7">7</option>
                                                <option value="8">8</option>
                                                <option value="9">9</option>
                                                <option value="10">10</option>
                                            </select>
                                            <i class="fa fa-user tm-form-element-icon tm-form-element-icon-small"></i>
                                        </div>
                                        <div class="form-group tm-form-element tm-form-element-2">
                                            <select name="room" class="form-control tm-select" id="room">
                                                <option value="">Room</option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5</option>
                                                <option value="6">6</option>
                                                <option value="7">7</option>
                                                <option value="8">8</option>
                                                <option value="9">9</option>
                                                <option value="10">10</option>
                                            </select>
                                            <i class="fa fa-2x fa-bed tm-form-element-icon"></i>
                                        </div>
                                        <div class="form-group tm-form-element tm-form-element-2">
                                            <button type="submit" class="btn btn-primary tm-btn-search">Check
                                                Availability</button>
                                        </div>
                                    </div>                         
                                </form>
                            </div>
                        </div>
                    </div>
                </div>       
            </div>
            <div class="site-section bg-light">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 mx-auto text-center mb-5 section-heading">
                            <h2 class="mb-5">Danh sách phòng</h2>
                        </div>
                    </div>
                    <div class="row">
                        <%for (Image v : vector){%>
                        <div class="col-md-6 col-lg-4 mb-5">
                            <div class="hotel-room text-center">
                                <a  href="#" class="d-block mb-0 thumbnail"><img src="images/anhphong/<%= v.getImage1()%>" 
                                     alt="Image" class="img-fluid"></a>
                                <div class="hotel-room-body">
                                    <h3 class="heading mb-0"><a href="#">Phòng thường</a></h3>
                                    <strong class="price">350.000đ / một đêm</strong>
                                    <div class="add-to-cart">
                                        <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i>BOOK</a></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                                <%}%> 
                        <!--                        <div class="col-md-6 col-lg-4 mb-5">
                                                    <div class="hotel-room text-center">
                                                        <a href="#" class="d-block mb-0 thumbnail"><img src="images/img_2.jpg" alt="Image" class="img-fluid"></a>
                                                        <div class="hotel-room-body">
                                                            <h3 class="heading mb-0"><a href="#">Phòng gia đình</a></h3>
                                                            <strong class="price">500.000đ / một đêm</strong>
                                                            <div class="add-to-cart">
                                                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i>BOOK</a></button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6 col-lg-4 mb-5">
                                                    <div class="hotel-room text-center">
                                                        <a href="#" class="d-block mb-0 thumbnail"><img src="images/img_3.jpg" alt="Image" class="img-fluid"></a>
                                                        <div class="hotel-room-body">
                                                            <h3 class="heading mb-0"><a href="#">Phòng đơn</a></h3>
                                                            <strong class="price">250.000đ / một đêm</strong>
                                                            <div class="add-to-cart">
                                                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i>BOOK</a></button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                        
                                                <div class="col-md-6 col-lg-4 mb-5">
                                                    <div class="hotel-room text-center">
                                                        <a href="#" class="d-block mb-0 thumbnail"><img src="images/img_1.jpg" alt="Image" class="img-fluid"></a>
                                                        <div class="hotel-room-body">
                                                            <h3 class="heading mb-0"><a href="#">Phòng đôi</a></h3>
                                                            <strong class="price">300.000đ / Một đêm</strong>
                                                            <div class="add-to-cart">
                                                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i>BOOK</a></button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6 col-lg-4 mb-5">
                                                    <div class="hotel-room text-center">
                                                        <a href="#" class="d-block mb-0 thumbnail"><img src="images/img_2.jpg" alt="Image" class="img-fluid"></a>
                                                        <div class="hotel-room-body">
                                                            <h3 class="heading mb-0"><a href="#">Phòng cao cấp</a></h3>
                                                            <strong class="price">800.000đ / Một đêm</strong>
                                                            <div class="add-to-cart">
                                                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i>BOOK</a></button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6 col-lg-4 mb-5">
                                                    <div class="hotel-room text-center">
                                                        <a href="#" class="d-block mb-0 thumbnail"><img src="images/img_3.jpg" alt="Image" class="img-fluid"></a>
                                                        <div class="hotel-room-body">
                                                            <h3 class="heading mb-0"><a href="#">Phòng đơn</a></h3>
                                                            <strong class="price">100.000đ / Một đêm</strong>
                                                            <div class="add-to-cart">
                                                                <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i>BOOK</a></button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>-->
                    </div>
                </div>
            </div>



            <div class="site-section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 mx-auto text-center mb-5 section-heading">
                            <h2 class="mb-5">TÍNH NĂNG HIỆN CÓ</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="text-center p-4 item">
                                <span class="flaticon-pool display-3 mb-3 d-block text-primary"></span>
                                <h2 class="h5">Hồ bơi</h2>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="text-center p-4 item">
                                <span class="flaticon-desk display-3 mb-3 d-block text-primary"></span>
                                <h2 class="h5">Gọi thức ăn nhanh</h2>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="text-center p-4 item">
                                <span class="flaticon-exit display-3 mb-3 d-block text-primary"></span>
                                <h2 class="h5">Thoát hiểm an toàn</h2>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="text-center p-4 item">
                                <span class="flaticon-parking display-3 mb-3 d-block text-primary"></span>
                                <h2 class="h5">Bãi đổ xe</h2>
                            </div>
                        </div>

                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="text-center p-4 item">
                                <span class="flaticon-hair-dryer display-3 mb-3 d-block text-primary"></span>
                                <h2 class="h5">Tạo mẫu tóc</h2>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="text-center p-4 item">
                                <span class="flaticon-minibar display-3 mb-3 d-block text-primary"></span>
                                <h2 class="h5">Quầy bar</h2>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="text-center p-4 item">
                                <span class="flaticon-drink display-3 mb-3 d-block text-primary"></span>
                                <h2 class="h5">Thức uống</h2>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-4 col-lg-3">
                            <div class="text-center p-4 item">
                                <span class="flaticon-cab display-3 mb-3 d-block text-primary"></span>
                                <h2 class="h5">Thuê ô tô</h2>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <div class="site-section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 mx-auto text-center mb-5 section-heading">
                            <h2 class="mb-5">Phòng còn trống</h2>
                        </div>
                    </div>
                    <div class="row no-gutters">
                        <div class="col-md-6 col-lg-4">
                            <a href="images/img_1.jpg" class="image-popup img-opacity"><img src="images/img_1.jpg" alt="Image" class="img-fluid"></a>                        
                        </div>
                        <div class="col-md-6 col-lg-4">
                            <a href="images/img_2.jpg" class="image-popup img-opacity"><img src="images/img_2.jpg" alt="Image" class="img-fluid"></a>
                        </div>
                        <div class="col-md-6 col-lg-4">
                            <a href="images/img_3.jpg" class="image-popup img-opacity"><img src="images/img_3.jpg" alt="Image" class="img-fluid"></a>
                        </div>            
                    </div>
                    <div class="row mt-5">
                        <div class="col-md-12 text-center">
                            <div class="site-block-27">
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
                        </div>
                    </div>
                </div>
            </div>
            <div class="site-section block-15">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 mx-auto text-center mb-5 section-heading">
                            <h2>Thông tin phòng</h2>
                        </div>
                    </div>
                    <div class="nonloop-block-15 owl-carousel">
                        <div class="media-with-text p-md-5">
                            <div class="img-border-sm mb-4">
                                <a href="#" class="popup-vimeo image-play">
                                    <img src="images/img_1.jpg" alt="" class="img-fluid">
                                </a>
                            </div>
                            <h2 class="heading mb-0"><a href="#">Lorem Ipsum Dolor Sit Amet</a></h2>
                            <span class="mb-3 d-block post-date">Dec 20th, 2018 &bullet; By <a href="#">Admin</a></span>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio dolores culpa qui aliquam placeat nobis veritatis tempora natus rerum obcaecati.</p>
                        </div>         
                        <div class="media-with-text p-md-4">
                            <div class="img-border-sm mb-4">
                                <a href="#" class="popup-vimeo image-play">
                                    <img src="images/img_2.jpg" alt="" class="img-fluid">
                                </a>
                            </div>
                            <h2 class="heading mb-0"><a href="#">Lorem Ipsum Dolor Sit Amet</a></h2>
                            <span class="mb-3 d-block post-date">Dec 20th, 2018 &bullet; By <a href="#">Admin</a></span>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio dolores culpa qui aliquam placeat nobis veritatis tempora natus rerum obcaecati.</p>
                        </div>          
                        <div class="media-with-text p-md-4">
                            <div class="img-border-sm mb-4">
                                <a href="#" class="popup-vimeo image-play">
                                    <img src="images/img_3.jpg" alt="" class="img-fluid">
                                </a>
                            </div>
                            <h2 class="heading mb-0"><a href="#">Lorem Ipsum Dolor Sit Amet</a></h2>
                            <span class="mb-3 d-block post-date">Dec 20th, 2018 &bullet; By <a href="#">Admin</a></span>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio dolores culpa qui aliquam placeat nobis veritatis tempora natus rerum obcaecati.</p>
                        </div>
                        <div class="media-with-text p-md-4">
                            <div class="img-border-sm mb-4">
                                <a href="#" class="popup-vimeo image-play">
                                    <img src="images/img_1.jpg" alt="" class="img-fluid">
                                </a>
                            </div>
                            <h2 class="heading mb-0"><a href="#">Lorem Ipsum Dolor Sit Amet</a></h2>
                            <span class="mb-3 d-block post-date">Dec 20th, 2018 &bullet; By <a href="#">Admin</a></span>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio dolores culpa qui aliquam placeat nobis veritatis tempora natus rerum obcaecati.</p>
                        </div>        
                        <div class="media-with-text p-md-4">
                            <div class="img-border-sm mb-4">
                                <a href="#" class="popup-vimeo image-play">
                                    <img src="images/img_2.jpg" alt="" class="img-fluid">
                                </a>
                            </div>
                            <h2 class="heading mb-0"><a href="#">Lorem Ipsum Dolor Sit Amet</a></h2>
                            <span class="mb-3 d-block post-date">Dec 20th, 2018 &bullet; By <a href="#">Admin</a></span>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio dolores culpa qui aliquam placeat nobis veritatis tempora natus rerum obcaecati.</p>
                        </div>          
                        <div class="media-with-text p-md-4">
                            <div class="img-border-sm mb-4">
                                <a href="#" class="popup-vimeo image-play">
                                    <img src="images/img_3.jpg" alt="" class="img-fluid">
                                </a>
                            </div>
                            <h2 class="heading mb-0"><a href="#">Lorem Ipsum Dolor Sit Amet</a></h2>
                            <span class="mb-3 d-block post-date">Dec 20th, 2018 &bullet; By <a href="#">Admin</a></span>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio dolores culpa qui aliquam placeat nobis veritatis tempora natus rerum obcaecati.</p>
                        </div>           
                        <div class="media-with-text p-md-4">
                            <div class="img-border-sm mb-4">
                                <a href="#" class="popup-vimeo image-play">
                                    <img src="images/img_1.jpg" alt="" class="img-fluid">
                                </a>
                            </div>
                            <h2 class="heading mb-0"><a href="#">Lorem Ipsum Dolor Sit Amet</a></h2>
                            <span class="mb-3 d-block post-date">Dec 20th, 2018 &bullet; By <a href="#">Admin</a></span>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio dolores culpa qui aliquam placeat nobis veritatis tempora natus rerum obcaecati.</p>
                        </div>          
                        <div class="media-with-text p-md-4">
                            <div class="img-border-sm mb-4">
                                <a href="#" class="popup-vimeo image-play">
                                    <img src="images/img_2.jpg" alt="" class="img-fluid">
                                </a>
                            </div>
                            <h2 class="heading mb-0"><a href="#">Lorem Ipsum Dolor Sit Amet</a></h2>
                            <span class="mb-3 d-block post-date">Dec 20th, 2018 &bullet; By <a href="#">Admin</a></span>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio dolores culpa qui aliquam placeat nobis veritatis tempora natus rerum obcaecati.</p>
                        </div>
                        <div class="media-with-text p-md-4">
                            <div class="img-border-sm mb-4">
                                <a href="#" class="popup-vimeo image-play">
                                    <img src="images/img_3.jpg" alt="" class="img-fluid">
                                </a>
                            </div>
                            <h2 class="heading mb-0"><a href="#">Lorem Ipsum Dolor Sit Amet</a></h2>
                            <span class="mb-3 d-block post-date">Dec 20th, 2018 &bullet; By <a href="#">Admin</a></span>
                            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Optio dolores culpa qui aliquam placeat nobis veritatis tempora natus rerum obcaecati.</p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="site-section block-14 bg-light">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 mx-auto text-center mb-5 section-heading">
                            <h2>Phản hồi khách hàng</h2>
                        </div>
                    </div>
                    <div class="nonloop-block-14 owl-carousel">

                        <div class="p-4">
                            <div class="d-flex block-testimony">
                                <div class="person mr-3">
                                    <img src="images/person_1.jpg" alt="Image" class="img-fluid rounded">
                                </div>
                                <div>
                                    <h2 class="h5">Katie Johnson</h2>
                                    <blockquote>&ldquo;Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias accusantium qui optio, possimus necessitatibus voluptate aliquam velit nostrum tempora ipsam!&rdquo;</blockquote>
                                </div>
                            </div>
                        </div>
                        <div class="p-4">
                            <div class="d-flex block-testimony">
                                <div class="person mr-3">
                                    <img src="images/person_2.jpg" alt="Image" class="img-fluid rounded">
                                </div>
                                <div>
                                    <h2 class="h5">Jane Mars</h2>
                                    <blockquote>&ldquo;Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias accusantium qui optio, possimus necessitatibus voluptate aliquam velit nostrum tempora ipsam!&rdquo;</blockquote>
                                </div>
                            </div>
                        </div>
                        <div class="p-4">
                            <div class="d-flex block-testimony">
                                <div class="person mr-3">
                                    <img src="images/person_3.jpg" alt="Image" class="img-fluid rounded">
                                </div>
                                <div>
                                    <h2 class="h5">Shane Holmes</h2>
                                    <blockquote>&ldquo;Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias accusantium qui optio, possimus necessitatibus voluptate aliquam velit nostrum tempora ipsam!&rdquo;</blockquote>
                                </div>
                            </div>
                        </div>
                        <div class="p-4">
                            <div class="d-flex block-testimony">
                                <div class="person mr-3">
                                    <img src="images/person_4.jpg" alt="Image" class="img-fluid rounded">
                                </div>
                                <div>
                                    <h2 class="h5">Mark Johnson</h2>
                                    <blockquote>&ldquo;Lorem ipsum dolor sit amet, consectetur adipisicing elit. Alias accusantium qui optio, possimus necessitatibus voluptate aliquam velit nostrum tempora ipsam!&rdquo;</blockquote>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="py-5 quick-contact-info">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4 text-center">
                            <div>
                                <span class="icon-room text-white h2 d-block"></span>
                                <h2>Location</h2>
                                <p class="mb-0">New York - 2398 <br>  10 Hadson Carl Street</p>
                            </div>
                        </div>
                        <div class="col-md-4 text-center">
                            <div>
                                <span class="icon-clock-o text-white h2 d-block"></span>
                                <h2>Service Times</h2>
                                <p class="mb-0">Wednesdays at 6:30PM - 7:30PM <br>
                                    Fridays at Sunset - 7:30PM <br>
                                    Saturdays at 8:00AM - Sunset</p>
                            </div>
                        </div>
                        <div class="col-md-4 text-center">
                            <div>
                                <span class="icon-comments text-white h2 d-block"></span>
                                <h2>Get In Touch</h2>
                                <p class="mb-0">Email: info@yoursite.com <br>
                                    Phone: (123) 3240-345-9348 </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <footer class="site-footer">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4">
                            <h3 class="footer-heading mb-4 text-white">About</h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellat quos rem ullam, placeat amet.</p>
                            <p><a href="#" class="btn btn-primary pill text-white px-4">Read More</a></p>
                        </div>
                        <div class="col-md-6">
                            <div class="row">
                                <div class="col-md-6">
                                    <h3 class="footer-heading mb-4 text-white">Quick Menu</h3>
                                    <ul class="list-unstyled">
                                        <li><a href="#">About</a></li>
                                        <li><a href="#">Services</a></li>
                                        <li><a href="#">Approach</a></li>
                                        <li><a href="#">Sustainability</a></li>
                                        <li><a href="#">News</a></li>
                                        <li><a href="#">Careers</a></li>
                                    </ul>
                                </div>
                                <div class="col-md-6">
                                    <h3 class="footer-heading mb-4 text-white">Ministries</h3>
                                    <ul class="list-unstyled">
                                        <li><a href="#">Children</a></li>
                                        <li><a href="#">Women</a></li>
                                        <li><a href="#">Bible Study</a></li>
                                        <li><a href="#">Church</a></li>
                                        <li><a href="#">Missionaries</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>      
                        <div class="col-md-2">
                            <div class="col-md-12"><h3 class="footer-heading mb-4 text-white">Social Icons</h3></div>
                            <div class="col-md-12">
                                <p>
                                    <a href="#" class="pb-2 pr-2 pl-0"><span class="icon-facebook"></span></a>
                                    <a href="#" class="p-2"><span class="icon-twitter"></span></a>
                                    <a href="#" class="p-2"><span class="icon-instagram"></span></a>
                                    <a href="#" class="p-2"><span class="icon-vimeo"></span></a>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="row pt-5 mt-5 text-center">
                        <div class="col-md-12">
                            <p>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                Copyright &copy; <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script>document.write(new Date().getFullYear());</script> All Rights Reserved | This template is made with <i class="icon-heart text-primary" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>
                                <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            </p>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
        <script src="js/jquery-1.11.3.min.js"></script>    
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/jquery-migrate-3.0.1.min.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/jquery.countdown.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/bootstrap-datepicker.min.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/mediaelement-and-player.min.js"></script>
        <script src="js/main.js"></script>
        <!-- load JS files -->
        <script src="js/jquery-1.11.3.min.js"></script>
        <!-- jQuery (https://jquery.com/download/) -->
        <script src="js/popper.min.js"></script>
        <!-- https://popper.js.org/ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <script src="js/datepicker.min.js"></script>
        <!-- https://github.com/qodesmith/datepicker -->
        <script src="js/jquery.singlePageNav.min.js"></script>
        <!-- Single Page Nav (https://github.com/ChrisWojcik/single-page-nav) -->
        <script src="slick/slick.min.js"></script>
        <!-- http://kenwheeler.github.io/slick/ -->
        <script>
                                    document.addEventListener('DOMContentLoaded', function () {
                                        var mediaElements = document.querySelectorAll('video, audio'),
                                                total = mediaElements.length;

                                        for (var i = 0; i < total; i++) {
                                            new MediaElementPlayer(mediaElements[i], {
                                                pluginPath: 'https://cdn.jsdelivr.net/npm/mediaelement@4.2.7/build/',
                                                shimScriptAccess: 'always',
                                                success: function () {
                                                    var target = document.body.querySelectorAll('.player'),
                                                            targetTotal = target.length;
                                                    for (var j = 0; j < targetTotal; j++) {
                                                        target[j].style.visibility = 'visible';
                                                    }
                                                }
                                            });
                                        }
                                    });
                                    /* Google map
                                     ------------------------------------------------*/
                                    var map = '';
                                    var center;
                                    function initialize() {
                                        var mapOptions = {
                                            zoom: 16,
                                            center: new google.maps.LatLng(13.7567928, 100.5653741),
                                            scrollwheel: false
                                        };
                                        map = new google.maps.Map(document.getElementById('google-map'), mapOptions);
                                        google.maps.event.addDomListener(map, 'idle', function () {
                                            calculateCenter();
                                        });
                                        google.maps.event.addDomListener(window, 'resize', function () {
                                            map.setCenter(center);
                                        });
                                    }
                                    function calculateCenter() {
                                        center = map.getCenter();
                                    }
                                    function loadGoogleMap() {
                                        var script = document.createElement('script');
                                        script.type = 'text/javascript';
                                        script.src = 'https://maps.googleapis.com/maps/api/js?key=AIzaSyDVWt4rJfibfsEDvcuaChUaZRS5NXey1Cs&v=3.exp&sensor=false&' + 'callback=initialize';
                                        document.body.appendChild(script);
                                    }
                                    function setCarousel() {
                                        if ($('.tm-article-carousel').hasClass('slick-initialized')) {
                                            $('.tm-article-carousel').slick('destroy');
                                        }
                                        if ($(window).width() < 438) {
                                            // Slick carousel
                                            $('.tm-article-carousel').slick({
                                                infinite: false,
                                                dots: true,
                                                slidesToShow: 1,
                                                slidesToScroll: 1
                                            });
                                        } else {
                                            $('.tm-article-carousel').slick({
                                                infinite: false,
                                                dots: true,
                                                slidesToShow: 2,
                                                slidesToScroll: 1
                                            });
                                        }
                                    }
                                    function setPageNav() {
                                        if ($(window).width() > 991) {
                                            $('#tm-top-bar').singlePageNav({
                                                currentClass: 'active',
                                                offset: 79
                                            });
                                        } else {
                                            $('#tm-top-bar').singlePageNav({
                                                currentClass: 'active',
                                                offset: 65
                                            });
                                        }
                                    }
                                    function togglePlayPause() {
                                        vid = $('.tmVideo').get(0);
                                        if (vid.paused) {
                                            vid.play();
                                            $('.tm-btn-play').hide();
                                            $('.tm-btn-pause').show();
                                        } else {
                                            vid.pause();
                                            $('.tm-btn-play').show();
                                            $('.tm-btn-pause').hide();
                                        }
                                    }
                                    $(document).ready(function () {
                                        $(window).on("scroll", function () {
                                            if ($(window).scrollTop() > 100) {
                                                $(".tm-top-bar").addClass("active");
                                            } else {
                                                //remove the background property so it comes transparent again (defined in your css)
                                                $(".tm-top-bar").removeClass("active");
                                            }
                                        });
                                        // Google Map
                                        loadGoogleMap();
                                        // Date Picker
                                        const pickerCheckIn = datepicker('#inputCheckIn');
                                        const pickerCheckOut = datepicker('#inputCheckOut');
                                        // Slick carousel
                                        setCarousel();
                                        setPageNav();
                                        $(window).resize(function () {
                                            setCarousel();
                                            setPageNav();
                                        });
                                        // Close navbar after clicked
                                        $('.nav-link').click(function () {
                                            $('#mainNav').removeClass('show');
                                        });
                                        // Control video
                                        $('.tm-btn-play').click(function () {
                                            togglePlayPause();
                                        });
                                        $('.tm-btn-pause').click(function () {
                                            togglePlayPause();
                                        });
                                        // Update the current year in copyright
                                        $('.tm-current-year').text(new Date().getFullYear());
                                    });
        </script>
    </body>
</html>
