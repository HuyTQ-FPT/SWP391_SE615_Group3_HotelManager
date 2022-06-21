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
                                
        <jsp:include page="header.jsp"></jsp:include>

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
                                        <img src="images/anhdevice/${c.serviceImage}" alt="#" style="height: 80px;width: 150px; margin-top: 10px" />
                                        <!--</div>-->
                                        <div class="pof-text">
                                            <h4 style="text-align: center">${c.serviceName}</h4>
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
                                        <img src="images/anhphong/${c.image}" alt="#"style="height: 80px;width: 150px;margin-top: 10px" />
                                        <!--</div>-->
                                        <div class="pof-text">
                                            <h4 style="text-align: center">${c.cateroom}</h4>
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
                                        <button class="image-button button-left" onclick="plusDivs(-1)">&#10094;</button>
                                        <button class="image-button button-right" onclick="plusDivs(1)">&#10095;</button>
                                        <c:forEach items="${img}" var="c">
                                            <img class="mySlides" src="images/anhphong/${c.image1}" style="height: 440px;width: 630px">
                                            <img class="mySlides" src="images/anhphong/${c.image2}" style="height: 440px;width: 630px">
                                            <img class="mySlides" src="images/anhphong/${c.image3}" style="height: 440px;width: 630px">
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${sessionScope.isroomde==null}">
                                        <img class="mySlides" src="images/anhdevice/${se.serviceImage}"style="height: 440px;width: 630px">
                                    </c:if>
                                </div>
                                <div class="btn-dit-list clearfix">
                                    <div class="left-dit-p" style="text-align: center">
                                        <!--<div class="dex-a">-->
                                        <c:if test="${sessionScope.isroomde!=null}">
                                            <h4 style="text-align: center">Loại Phòng: ${Room.cateroom}</h4>
                                        </c:if>
                                        <c:if test="${sessionScope.isroomde==null}">
                                            <h4>Dịch Vụ Đi Kèm: ${se.serviceName}</h4>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                            <div class="description-box">
                                <div class="dex-a">
                                    <h4 style="text-align: center">Mô TẢ</h4>
                                    <c:if test="${sessionScope.isroomde==null}">
                                        <p>${se.serviceDes}</p>
                                    </c:if>
                                    <c:if test="${sessionScope.isroomde!=null}">
                                        <p>${Room.roomdesc}</p>
                                        <br>
                                        <p>DIỆN TÍCH: ${Room.square}m2</p>

                                        <div class="spe-a">
                                            <h4>Tiện Ích Phòng</h4>
                                            <ul>
                                                <li class="clearfix">
                                                    <div class="col-md-4">
                                                        <h5 style="color: red">Đồ dùng</h5>
                                                    </div>
                                                    <div class="col-md-8">
                                                        <h5 style="color: red">Số Lượng</h5>
                                                    </div>
                                                </li>
                                                <c:forEach items="${de}" var="de">
                                                    <li class="clearfix">
                                                        <div class="col-md-4">
                                                            <h5><p>${de.deviceName}</p></h5>
                                                        </div>
                                                        <div class="col-md-8">
                                                            <p>${de.quantity}</p>
                                                        </div>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                        <div class="similar-box">
                            <c:if test="${sessionScope.isroomde!=null}">
                                <h2 style="text-align: center">Các Phòng Tương Tự</h2>
                                <div class="row cat-pd">
                                    <c:forEach items="${getroomlist}" var="c">
                                    <div class="col-md-6" style="margin-top: 30px">
                                        <div class="small-box-c">
                                            <div class="small-img-b">
                                                <a href="#"><img class="img-responsive" src="images/anhphong/${c.image}" alt="#" style="height: 160px; width: 280px"/></a>
                                            </div>
                                            <div class="dit-t clearfix">
                                                <div class="left-ti">
                                                    <h4>${c.cateroom}</h4>
                                                    <p>Diện Tích Phòng: <span>${c.square}m2</span></p>
                                                </div>
                                                <a href="#" tabindex="0">${c.roomprice}</a>
                                            </div>
                                            <div class="prod-btn">
                                                <a href="#"><i aria-hidden="true"></i>Book</a>
                                                <p>23 likes</p>
                                            </div>
                                            
                                        </div>
                                    </div>
                                    </c:forEach>
                                </div>
                            </c:if>
                            <c:if test="${sessionScope.isroomde==null}">
                                <h2 style="text-align: center">Phòng Dành Cho Bạn</h2>
                                <div class="row cat-pd">
                                    <c:forEach items="${getroomlist2}" var="c">
                                    <div class="col-md-6" style="margin-top: 30px">
                                        <div class="small-box-c">
                                            <div class="small-img-b">
                                                <a href="#"><img class="img-responsive" src="images/anhphong/${c.image}" alt="#" style="height: 160px; width: 280px"/></a>
                                            </div>
                                            <div class="dit-t clearfix">
                                                <div class="left-ti">
                                                    <h4>${c.cateroom}</h4>
                                                    <p>Diện Tích Phòng: <span>${c.square}m2</span></p>
                                                </div>
                                                <a href="#" tabindex="0">${c.roomprice}</a>
                                            </div>
                                            <div class="prod-btn">
                                                <a href="#"><i aria-hidden="true"></i>Book</a>
                                                <p>23 likes</p>
                                            </div>
                                            
                                        </div>
                                    </div>
                                    </c:forEach>
                                </div>
                            </c:if>
                            <!--                            <div class="row cat-pd">
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
                                                        </div>-->
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-12">
                        <div class="price-box-right">
                            <h4>Price</h4>
                            <h3>${Room.roomprice}<span style="font-weight: bold"> /1 đêm</span></h3>
                            <p>Option</p>
                            <c:if test="${sessionScope.login!=null}" >
                            <a href="OrderController?do=user&id=${Room.roomID}&user=${sessionScope.account.getAccountID()}">Booking</a>
                            </c:if>
                            <c:if test="${sessionScope.login==null}" >
                            <a href="LoginController">Booking</a>
                            </c:if>
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
