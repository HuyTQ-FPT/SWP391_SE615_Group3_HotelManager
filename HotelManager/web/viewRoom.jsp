<%-- 
    Document   : viewRoom.jsp
    Created on : Jun 5, 2022, 12:56:50 AM
    Author     : NTD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Hoang Hon &mdash; Hotel</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700|Work+Sans:300,400,700" rel="stylesheet">
        <link rel="stylesheet" href="fonts/icomoon/style.css">
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
        <link rel="stylesheet" href="css/tooplate-style.css">

        <!--fontawesome css-->
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <!--bootstrap css-->
        <link rel="stylesheet" href="css/bootstrap.min_1.css">
        <!--animate css-->
        <link rel="stylesheet" href="css/animate-wow.css">
        <!--main css-->
        <link rel="stylesheet" href="css/style_1.css">
        <link rel="stylesheet" href="css/bootstrap-select.min.css">
        <link rel="stylesheet" href="css/slick.min.css">
        <link rel="stylesheet" href="css/select2.min.css">
        <!--responsive css-->
        <link rel="stylesheet" href="css/responsive.css">

    </head>
    <body>
        <div class="site-navbar-wrap js-site-navbar bg-white">

            <div class="container">
                <div class="site-navbar bg-light">
                    <div class="py-1">
                        <div class="row align-items-center">
                            <div class="col-2">
                                <h2 class="mb-0 site-logo"><a href="HomeController">Hoang hon</a></h2>
                            </div>
                            <div class="col-10">
                                <nav class="site-navigation text-right" role="navigation">
                                    <div class="container">

                                        <div class="d-inline-block d-lg-none  ml-md-0 mr-auto py-3"><a href="#" class="site-menu-toggle js-menu-toggle"><span class="icon-menu h3"></span></a></div>
                                        <ul class="site-menu js-clone-nav d-none d-lg-block">
                                            <li>
                                                <a style="font-family: PlayFair Display" href="HomeController">Trang chủ</a>
                                            </li>
                                            <li class="has-children">
                                                <a style="font-family: PlayFair Display" href="rooms.html">Phòng</a>
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
                                            <li class="active"><a style="font-family: PlayFair Display" href="contact.html">Liên hệ</a></li>
                                            <li class="login"><a style="font-family: PlayFair Display" href="contact.html">Login</a></li>
                                            <li class="register"><a style="font-family: PlayFair Display" href="contact.html">Register</a></li>
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
                        <div class="col-md-7 text-center" data-aos="fade">

                            <h1 class="mb-2">Welcome To Suites</h1>
                            <h2 class="caption">Hotel &amp; Resort</h2>
                        </div>
                    </div>
                </div>
            </div>  

            <div class="site-blocks-cover overlay" style="background-image: url(images/hero_2.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
                <div class="container">
                    <div class="row align-items-center justify-content-center">
                        <div class="col-md-7 text-center" data-aos="fade">
                            <h1 class="mb-2">Unique Experience</h1>
                            <h2 class="caption">Enjoy With Us</h2>
                        </div>
                    </div>
                </div>
            </div> 

            <div class="site-blocks-cover overlay" style="background-image: url(images/hero_3.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
                <div class="container">
                    <div class="row align-items-center justify-content-center">
                        <div class="col-md-7 text-center" data-aos="fade">
                            <h1 class="mb-2">Relaxing Room</h1>
                            <h2 class="caption">Your Room, Your Stay</h2>
                        </div>
                    </div>
                </div>
            </div> 

        </div>
        <div class="product-page-main">
            <div class="container">

                <div class="row">

                    <div class="col-md-2 col-sm-4">
                        <c:if test="${sessionScope.isroomde!=null}">
                            <c:forEach items="${vector3}" var="c">
                                <form>
                                    <div class="left-profile-box-m prod-page">
                                        <!--<div class="pro-img">-->
                                        <img src="images/lag-61.png" alt="#" style="height: 80px;width: 150px" />
                                        <!--</div>-->
                                        <div class="pof-text">
                                            <h4>${c.serviceName}</h4>
                                            <!--                                <div class="check-box"></div>-->
                                        </div>
                                        <a href="#">Visit store</a>
                                    </div>
                                </form>
                            </c:forEach>
                        </c:if>
                        <c:if test="${sessionScope.isroomde==null}">
                            <c:forEach items="${vector}" var="c">
                                <form>
                                    <div class="left-profile-box-m prod-page">
                                        <!--<div class="pro-img">-->
                                        <!--<img src="images/lag-61.png" alt="#" />-->
                                        <!--</div>-->
                                        <div class="pof-text">
                                            <h4>${c.cateroom}</h4>
                                            <!--                                <div class="check-box"></div>-->
                                        </div>
                                        <a href="#">Visit store</a>
                                    </div>
                                </form>
                            </c:forEach>
                        </c:if>
                    </div>

                    <div class="col-md-7 col-sm-8">
                        <div class="md-prod-page">
                            <div class="md-prod-page-in">
                                <div class="display-container">
                                    <c:if test="${sessionScope.isroomde!=null}">
                                        <c:forEach items="${img}" var="c">
                                            <img class="mySlides" src="images/anhphong/${c.image1}" style="height: 440px;width: 630px">
                                            <img class="mySlides" src="images/anhphong/${c.image2}" style="height: 440px;width: 630px">
                                            <img class="mySlides" src="images/anhphong/${c.image3}" style="height: 440px;width: 630px">
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${sessionScope.isroomde==null}">
                                        <img class="mySlides" src="images/anhdevice/${se.serviceImage}">
                                    </c:if>

                                    <button class="image-button button-left" onclick="plusDivs(-1)">&#10094;</button>
                                    <button class="image-button button-right" onclick="plusDivs(1)">&#10095;</button>
                                </div>
                                <div class="btn-dit-list clearfix">
                                    <div class="left-dit-p">
                                        <div class="prod-btn">
                                            <c:if test="${sessionScope.isroomde!=null}">
                                                <p>${Room.cateroom}</p>
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="right-dit-p">
                                        <div class="like-list">
                                            <ul>
                                                <li>
                                                    <div class="im-b"><img class="" src="images/list-img-01.png" alt=""></div>
                                                </li>
                                                <li>
                                                    <div class="im-b"><img src="images/list-img-02.png" alt=""></div>
                                                </li>
                                                <li>
                                                    <div class="im-b"><img src="images/list-img-03.png" alt=""></div>
                                                </li>
                                                <li>
                                                    <div class="im-b"><img src="images/list-img-04.png" alt=""></div>
                                                </li>
                                                <li>
                                                    <div class="im-b"><img src="images/list-img-05.png" alt=""></div>
                                                </li>
                                                <li>
                                                    <div class="im-b"><img src="images/list-img-06.png" alt=""></div>
                                                </li>
                                                <li>
                                                    <div class="im-b"><i class="fa fa-ellipsis-h" aria-hidden="true"></i></div>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="description-box">
                                <div class="dex-a">
                                    <h4>Description</h4>
                                    <c:if test="${sessionScope.isroomde!=null}">
                                        <p>${Room.roomdesc}</p>
                                    </c:if>
                                    <c:if test="${sessionScope.isroomde==null}">
                                        <p>${se.serviceDes}</p>
                                    </c:if>
                                    <br>
                                    <p>Small: H 25 cm / &Oslash; 12 cm</p>
                                    <p>Large H 24 cm / &Oslash; 25 cm</p>
                                </div>
                                <div class="spe-a">
                                    <h4>Specifications</h4>
                                    <ul>
                                        <li class="clearfix">
                                            <div class="col-md-4">
                                                <h5>Measurments</h5>
                                            </div>
                                            <div class="col-md-8">
                                                <p>H25 cm / 0 12 cm and H 24 cm / 0 25 cm</p>
                                            </div>
                                        </li>
                                        <li class="clearfix">
                                            <div class="col-md-4">
                                                <h5>Material</h5>
                                            </div>
                                            <div class="col-md-8">
                                                <p>Material Name</p>
                                            </div>
                                        </li>
                                        <li class="clearfix">
                                            <div class="col-md-4">
                                                <h5>Wire</h5>
                                            </div>
                                            <div class="col-md-8">
                                                <p>Wire Name</p>
                                            </div>
                                        </li>
                                        <li class="clearfix">
                                            <div class="col-md-4">
                                                <h5>Comdition</h5>
                                            </div>
                                            <div class="col-md-8">
                                                <p>Brand new</p>
                                            </div>
                                        </li>
                                        <li class="clearfix">
                                            <div class="col-md-4">
                                                <h5>SKU number</h5>
                                            </div>
                                            <div class="col-md-8">
                                                <p>SKU number</p>
                                            </div>
                                        </li>
                                        <li class="clearfix">
                                            <div class="col-md-4">
                                                <h5>Shipping</h5>
                                            </div>
                                            <div class="col-md-8">
                                                <p>Shipping worldwide</p>
                                            </div>
                                        </li>
                                        <li class="clearfix">
                                            <div class="col-md-4">
                                                <h5>Warranty</h5>
                                            </div>
                                            <div class="col-md-8">
                                                <p>1 years</p>
                                            </div>
                                        </li>
                                        <li class="clearfix">
                                            <div class="col-md-4">
                                                <h5>Delivery</h5>
                                            </div>
                                            <div class="col-md-8">
                                                <p>Choose country</p>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="similar-box">
                            <h2>Similiar products from Morgan Mobilya</h2>
                            <div class="row cat-pd">
                                <div class="col-md-6">
                                    <div class="small-box-c">
                                        <div class="small-img-b">
                                            <img class="img-responsive" src="images/tr1.png" alt="#" />
                                        </div>
                                        <div class="dit-t clearfix">
                                            <div class="left-ti">
                                                <h4>Product</h4>
                                                <p>By <span>Beko</span> under <span>Lights</span></p>
                                            </div>
                                            <a href="#" tabindex="0">$1220</a>
                                        </div>
                                        <div class="prod-btn">
                                            <a href="#"><i class="fa fa-star" aria-hidden="true"></i> Save to wishlist</a>
                                            <a href="#"><i class="fa fa-thumbs-up" aria-hidden="true"></i> Like this</a>
                                            <p>23 likes</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="small-box-c">
                                        <div class="small-img-b">
                                            <img class="img-responsive" src="images/tr2.png" alt="#" />
                                        </div>
                                        <div class="dit-t clearfix">
                                            <div class="left-ti">
                                                <h4>Product</h4>
                                                <p>By <span>Beko</span> under <span>Chairs</span></p>
                                            </div>
                                            <a href="#" tabindex="0">$1220</a>
                                        </div>
                                        <div class="prod-btn">
                                            <a href="#"><i class="fa fa-star" aria-hidden="true"></i> Save to wishlist</a>
                                            <a href="#"><i class="fa fa-thumbs-up" aria-hidden="true"></i> Like this</a>
                                            <p>23 likes</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row cat-pd">
                                <div class="col-md-6">
                                    <div class="small-box-c">
                                        <div class="small-img-b">
                                            <img class="img-responsive" src="images/tr3.png" alt="#" />
                                        </div>
                                        <div class="dit-t clearfix">
                                            <div class="left-ti">
                                                <h4>Product</h4>
                                                <p>By <span>Beko</span> under <span>Lights</span></p>
                                            </div>
                                            <a href="#" tabindex="0">$1220</a>
                                        </div>
                                        <div class="prod-btn">
                                            <a href="#"><i class="fa fa-star" aria-hidden="true"></i> Save to wishlist</a>
                                            <a href="#"><i class="fa fa-thumbs-up" aria-hidden="true"></i> Like this</a>
                                            <p>23 likes</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="small-box-c">
                                        <div class="small-img-b">
                                            <img class="img-responsive" src="images/tr4.png" alt="#" />
                                        </div>
                                        <div class="dit-t clearfix">
                                            <div class="left-ti">
                                                <h4>Product</h4>
                                                <p>By <span>Beko</span> under <span>Chairs</span></p>
                                            </div>
                                            <a href="#" tabindex="0">$1220</a>
                                        </div>
                                        <div class="prod-btn">
                                            <a href="#"><i class="fa fa-star" aria-hidden="true"></i> Save to wishlist</a>
                                            <a href="#"><i class="fa fa-thumbs-up" aria-hidden="true"></i> Like this</a>
                                            <p>23 likes</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-12">
                        <div class="price-box-right">
                            <h4>Price</h4>
                            <h3>$1.320 <span>pr.peice</span></h3>
                            <p>Option</p>
                            <select class="form-control select2">
                                <option>Flying Carpet Green rug</option>
                                <option value="AK">Alaska</option>
                                <option value="HI">Hawaii</option>
                                <option value="CA">California</option>
                                <option value="NV">Nevada</option>
                                <option value="OR">Oregon</option>
                                <option value="WA">Washington</option>
                                <option value="AZ">Arizona</option>
                                <option value="CO">Colorado</option>
                                <option value="ID">Idaho</option>
                                <option value="MT">Montana</option>
                                <option value="NE">Nebraska</option>
                                <option value="NM">New Mexico</option>
                                <option value="ND">North Dakota</option>
                                <option value="UT">Utah</option>
                                <option value="WY">Wyoming</option>
                                <option value="AL">Alabama</option>
                                <option value="AR">Arkansas</option>
                                <option value="IL">Illinois</option>
                                <option value="IA">Iowa</option>
                                <option value="KS">Kansas</option>
                                <option value="KY">Kentucky</option>
                            </select>
                            <a href="#">Contact company</a>
                            <h5><i class="fa fa-clock-o" aria-hidden="true"></i> <strong>16 hours</strong> avg. responsive time</h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>



        <!--main js--> 
        <script src="js/jquery-1.12.4.min.js"></script> 
        <!--bootstrap js--> 
        <script src="js/bootstrap.min_1.js"></script> 
        <script src="js/bootstrap-select.min.js"></script>
        <script src="js/slick.min_1.js"></script> 
        <script src="js/select2.full.min.js"></script> 
        <script src="js/wow.min.js"></script> 
        <!--custom js--> 
        <script src="js/custom.js"></script>
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/jquery-migrate-3.0.1.min.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="js/popper.min.js"></script>

        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/jquery.countdown.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/bootstrap-datepicker.min.js"></script>
        <script src="js/aos.js"></script>


        <script src="js/mediaelement-and-player.min.js"></script>

        <script src="js/main.js"></script>
        <script>
                                        var slideIndex = 1;
                                        showDivs(slideIndex);

                                        function plusDivs(n) {
                                            showDivs(slideIndex += n);
                                        }

                                        function showDivs(n) {
                                            var i;
                                            var x = document.getElementsByClassName("mySlides");
                                            if (n > x.length) {
                                                slideIndex = 1
                                            }
                                            if (n < 1) {
                                                slideIndex = x.length
                                            }
                                            for (i = 0; i < x.length; i++) {
                                                x[i].style.display = "none";
                                            }
                                            x[slideIndex - 1].style.display = "block";
                                        }
        </script>

    </body>
</html>
