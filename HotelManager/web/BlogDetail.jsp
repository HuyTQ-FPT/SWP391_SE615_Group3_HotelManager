<%-- 
    Document   : BlogDetail.jsp
    Created on : Jun 6, 2022, 1:57:30 AM
    Author     : Thai Quan
--%>

<%@page import="entity.Account"%>
<%@page import="entity.Blog"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Suite &mdash; Colorlib Website Template</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="css/datatables.css">
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


        <link rel="stylesheet" href="css/style_2.css" type="text/css">
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
    <script type="text/javascript">
        function  Comment() {
            var xhttp;
            var username = document.myform.username.value;
            var content = document.myform.content.value;
            var blogid = document.myform.blogid.value;
            var url = "CommentController?content=" + content + "&username=" + username + "&blogid=" +blogid;
            if (window.XMLHttpRequest) {
                xhttp = new XMLHttpRequest();
            } else {
                xhttp = new ActiveObject("Microsoft.XMLHTTP");
            }
            xhttp.onreadystatechange = function () {
                if (xhttp.readyState == 4) {
                    var data = xhttp.responseText;
                    document.getElementById("mycomment").innerHTML = data;
                }

            }
            xhttp.open("POST", url, true);
            xhttp.send();
            
            var arr = document.getElementsByTagName('input');
            var name = arr[0].value;
            var arr1 = document.getElementsByTagName('textarea');
            var content = arr1[0].value;
            if (name.trim() == "" && content.trim() == "") {
                alert("please fill all fields");
                return false;
            }
        
        }

    </script>
    <body>

        <div class="site-wrap">

            <div class="site-mobile-menu">
                <div class="site-mobile-menu-header">
                    <div class="site-mobile-menu-close mt-3">
                        <span class="icon-close2 js-menu-toggle"></span>
                    </div>
                </div>
                <div class="site-mobile-menu-body"></div>
            </div> <!-- .site-mobile-menu -->


            <jsp:include page="header.jsp"></jsp:include>


                <div class="site-blocks-cover overlay" style="background-image: url(images/hero_1.jpg);" data-aos="fade" data-stellar-background-ratio="0.5">
                    <div class="container">
                        <div class="row align-items-center justify-content-center">
                            <div class="col-md-7 text-center" data-aos="fade">
                                <span class="caption mb-3">Suites Hotel &amp; Resort</span>
                                <h1 class="mb-4">About Us</h1>
                            </div>
                        </div>
                    </div>
                </div>  
                <section class="blog-details spad">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-4 col-md-5 order-md-1 order-2">
                                <div class="blog__sidebar">

                                    <div class="blog__sidebar__item">
                                        <h4>Categories</h4>
                                        <ul>
                                            <li><a href="#">Phòng đơn</a></li>
                                            <li><a href="#">Phòng đôi</a></li>
                                            <li><a href="#">Gia đình</a></li>
                                            <li><a href="#">Dịch vụ</a></li>

                                        </ul>
                                    </div>
                                    <div class="blog__sidebar__item">
                                        <h4>Recent News</h4>
                                        <div class="blog__sidebar__recent">
                                            <a href="#" class="blog__sidebar__recent__item">
                                                <div class="blog__sidebar__recent__item__pic">
                                                    <img src="img/blog/sidebar/sr-1.jpg" alt="">
                                                </div>
                                                <div class="blog__sidebar__recent__item__text">
                                                    <h6>09 Kinds Of Vegetables<br /> Protect The Liver</h6>
                                                    <span>MAR 05, 2019</span>
                                                </div>
                                            </a>
                                            <a href="#" class="blog__sidebar__recent__item">
                                                <div class="blog__sidebar__recent__item__pic">
                                                    <img src="img/blog/sidebar/sr-2.jpg" alt="">
                                                </div>
                                                <div class="blog__sidebar__recent__item__text">
                                                    <h6>Tips You To Balance<br /> Nutrition Meal Day</h6>
                                                    <span>MAR 05, 2019</span>
                                                </div>
                                            </a>
                                            <a href="#" class="blog__sidebar__recent__item">
                                                <div class="blog__sidebar__recent__item__pic">
                                                    <img src="img/blog/sidebar/sr-3.jpg" alt="">
                                                </div>
                                                <div class="blog__sidebar__recent__item__text">
                                                    <h6>4 Principles Help You Lose <br />Weight With Vegetables</h6>
                                                    <span>MAR 05, 2019</span>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="blog__sidebar__item">
                                        <h4>Search By</h4>
                                        <div class="blog__sidebar__item__tags">
                                            <a href="#">Apple</a>
                                            <a href="#">Beauty</a>
                                            <a href="#">Vegetables</a>
                                            <a href="#">Fruit</a>
                                            <a href="#">Healthy Food</a>
                                            <a href="#">Lifestyle</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        <c:forEach items="${c}" var="c">
                            <div class="col-lg-8 col-md-7 order-md-1 order-1">
                                <div class="blog__details__text">
                                    <img src="images/anhblog/${c.blogImage}" alt="">
                                    <h5><p style="font-weight: bold; color: #00bbf3; font-size: 28px;">${c.blogTitleString}</p></h5>
                                    <p>${c.blogDescription}</p>
                                </div>
                                <div class="blog__details__content">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="blog__details__author">
                                                <div class="blog__details__author__pic">
                                                    <img src="images/img_1.jpg" alt="">
                                                </div>
                                                <div class="blog__details__author__text">
                                                    <h6>${c.blogAuthor}</h6>
                                                    <span>Admin</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6">
                                            <div class="blog__details__widget">
                                                <ul>
                                                    <li><span>Categories:</span> Food</li>
                                                    <li><span>Tags:</span> All, Trending, Cooking, Healthy Food, Life Style</li>
                                                </ul>
                                                <div class="blog__details__social">
                                                    <a href="#"><i class="fa fa-facebook"></i></a>
                                                    <a href="#"><i class="fa fa-twitter"></i></a>
                                                    <a href="#"><i class="fa fa-google-plus"></i></a>
                                                    <a href="#"><i class="fa fa-linkedin"></i></a>
                                                    <a href="#"><i class="fa fa-envelope"></i></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>                   
                    </div>
                </div>
            </section>
            <!-- Blog Details Section End -->

            <div id ="mycomment"> </div>
            <div class="be-comment-block">
                <h1 class="comments-title">Comments</h1>

   
                <form name="myform">
                    <div class="row">
                        <div class="col-xs-12 col-sm-12">
                            <div class="form-group fl_icon">
                                <div class="icon"><i class="fa fa-user"></i></div>
                                <input type="text" placeholder="Your name" class="form-input" id="username" name="username" required/>

                            </div>
                        </div>

                        <div class="col-sm-12">		
                            <div class="form-group fl_icon">
                                <div class="icon"><i class="fa fa-user"></i></div>
                                <textarea class="form-input" id="content" placeholder="Comment"  name="content" required></textarea>
                            </div>
                            <!--                            <div class="form-group">
                                                            <textarea class="form-input" required="" placeholder="Your text"  name="content">
                                                            </textarea>
                                                        </div>-->
                        </div>
                         <c:forEach items="${c}" var="c">
                        <input type="hidden" value="${c.blogID}" id="blogid" name="blogid"/>
                       </c:forEach>
                        <input style="margin-left: 1300px;" class="btn btn-primary pull-right" type="button" value="Post" onclick="Comment()"/>
                    </div>
                </form>
    





            </div>
            <!-- Related Blog Section Begin -->
            <section class="related-blog spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="section-title related-blog-title">
                                <h2>Post You May Like</h2>
                            </div>
                        </div>
                    </div>                 
                    <div class="row">
                        <c:forEach items="${b}" var="c">
                            <div class="col-lg-4 col-md-4 col-sm-6">
                                <div class="blog__item">
                                    <div class="blog__item__pic">
                                        <img style="width: 350px; height: 250px;"src="images/anhblog/${c.blogImage}" alt="">
                                    </div>
                                    <div class="blog__item__text">
                                        <ul>
                                            <li><i class="fa fa-calendar-o"></i>${c.blogDate} by <label style="color: red">${c.blogAuthor}</label></li>                                               
                                        </ul>

                                        <h5><a href="BlogController?do=detailBlog&blogID=${c.blogID}">${c.blogTitleString}</a></h5>
<!--                                        <p>${c.blogDescription}</p>-->
                                    </div>
                                </div>
                            </div>                       
                        </c:forEach>
                    </div>
                </div>
            </section>



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



    </body>
</html>
