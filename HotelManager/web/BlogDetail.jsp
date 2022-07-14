

<%@page import="entity.Account"%>
<%@page import="entity.Blog"%>
<%@page import="java.util.Vector"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Suite &mdash; Colorlib Website Template</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
                                <span class="caption mb-3">Khách sạn &amp; Khu nghỉ dưỡng</span>
                                <h1 class="mb-4">Tin tức</h1>
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
                                        <h4 >Thể loại</h4>
                                        <ul>

                                            <li><a href="#">Phòng đơn</a></li>
                                            <li><a href="#">Phòng đôi</a></li>
                                            <li><a href="#">Gia đình</a></li>
                                            <li><a href="#">Dịch vụ</a></li>

                                        </ul>
                                    </div>
                                    <div class="blog__sidebar__item">
                                        <h4>Tin tức nổi bật</h4>
                                    <c:forEach items="${b1}" var="c">
                                        <div class="blog__sidebar__recent">
                                            <a href="#" class="blog__sidebar__recent__item">
                                                <div class="blog__sidebar__recent__item__pic">
                                                    <img style="width: 50px; height: 50px;"src="images/anhblog/${c.blogImage}" alt="">
                                                </div>
                                                <div class="blog__sidebar__recent__item__text">
                                                    <h6>${c.blogTitleString}</h6>
                                                    <span>${c.blogDate}</span>
                                                </div>
                                            </a>
                                        </div>
                                    </c:forEach>
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
                                                    <h6 onclick="reload()">${c.blogAuthor}</h6>
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

            <input style="margin:5px;" type="button" id="btn1" value="Bình luận"/> 

        </div>
        <div id ="mycomment"> </div>  
        <div style="padding-top:20px;" class="be-comment-block">


            <div style="display: none"id="commentblog">
                <h1 class="comments-title">Comments</h1>
                <form name="myform">
                    <div class="row">
                        <div class="col-xs-12 col-sm-12">
                            <div class="form-group fl_icon">
                                <div class="icon"><i style="padding-top: 20px;" class="fa fa-user"></i></div>
                                <input type="text"  value="${sessionScope.user}" readonly class="form-input" id="username" name="username" required readonly/>

                            </div>
                        </div>

                        <div class="col-sm-12">		
                            <div class="form-group fl_icon">
                                <div class="icon"><i style="padding-top: 20px;" class="fa fa-user"></i></div>
                                <textarea class="form-input" id="content" placeholder="Bình luận" maxlength="70" name="content" required></textarea>
                            </div>
                            <!--                            <div class="form-group">
                                                            <textarea class="form-input" required="" placeholder="Your text"  name="content">
                                                            </textarea>
                                                        </div>-->
                        </div>
                        <c:forEach items="${c}" var="c">
                            <input type="hidden" value="${c.blogID}" id="blogid" name="blogid"/>
                        </c:forEach>
                        <input style="margin-left: 1300px;float: right;" class="btn btn-primary pull-right" type="button" value="Gửi" onclick="Comment()"/> 

                    </div>
                </form>
            </div>
            <div style="padding-top: 20px;" id="displaycomment">
                <c:forEach items="${listcomment}" var="list">
                    <div class="be-comment">
                        <div class="be-img-comment">	
                            <a href="blog-detail-2.html">
                                <img  src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="" class="be-ava-comment">
                            </a>
                        </div>
                        <div class="be-comment-content">

                            <span class="be-comment-name">
                                <a href="blog-detail-2.html">${list.username}</a><input id="myButton" style="display: inline-block;margin-left: 20px;" type="button" value="sửa" onclick="Readonly(${list.commentId})">
                            </span>
                            <span class="be-comment-time">
                                <i style="padding-left: 40px;"class="fa fa-clock-o"></i>
                                ${list.date}
                            </span>
                            <input type="hidden" value="${list.commentId}" id="blogid" name="commentid"/>  
                            <form id="myform3${list.commentId}" name="myform3${list.commentId}"> 
                                <input id="myInput${list.commentId}" value="${list.content}"style="width:1300px; display: inline-block;background-color: #DCDCDC;"id="content3" maxlength="50" readonly="" name="content3" class="be-comment-text">

                                <div style="display: inline-block;"class="nav-item dropdown">

                                    <a href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                                       aria-haspopup="true" aria-expanded="false">
                                        <i class="fab fa-blogger"></i>

                                        <c:if test="${list.username eq sessionScope.user}">  
                                            <span>   
                                                <i class="fa fa-bars"></i>
                                            </span> 
                                        </c:if> 
                                    </a>


                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">

                                        <input style="margin-left: 1300px;float: right;" class="btn btn-primary pull-right" type="button" value="Gửi"/>
                                        <input type="hidden" value="${list.commentId}" id="commentidd${list.commentId}" name="commentidd"/>
                                        <input type="hidden" value="${list.blogid}" id="blogidd" name="blogidd"/>  
     <!--                                     <input type="hidden" value="${list.content}" id="contentid" name="content3"/>-->
                                        <a class="dropdown-item" onclick="Update1(${list.commentId})">Chỉnh sửa</a>
                                        </form>
                                        <form id="myform2${list.commentId}" name="myform2${list.commentId}"> 
                                            <input type="hidden" value="${list.commentId}" id="blogid" name="commentid"/>
                                            <input type="hidden" value="${list.blogid}" id="blogid1" name="blogid1"/>  
                                            <input style="margin-left: 1300px;float: right;" class="btn btn-primary pull-right" type="button" value="Gửi"/>
                                            <a class="dropdown-item"  onclick="Delete1(${list.commentId})"  >Xóa</a>
                                        </form>
                                    </div>
                                </div>
                                <div class="accordion" id="myaccordion" style="max-width: 320px">   
                                    <form>
                                        <div id="btn3">
                                            <input type="hidden" value="${list.commentId}" id="commentid" name="commentid"/>  
                                            <input type="hidden" value="${list.blogid}" id="blogid1" name="blogid1"/>  
                                            <input style="margin-right:180px; float: right; border-style: none; background-color: white;font-family: inherit;font-weight: bold;" class="" type="button" value="Hiển thị phản hồi" onclick="Comment2(${list.commentId})"/>
                                        </div>
                                    </form>
                                    <div class="card-header btn"  data-toggle="collapse" data-target="#q${list.commentId}" aria-expanded="true"
                                         data-parent="#myaccordion">
                                        Phản hồi    
                                    </div>

                                    <div style="padding-top: 20px;" id ="mycomment1${list.commentId}"> </div>
                                    <div class="card-body collapse"  data-toggle="collapse"  aria-expanded="false" id="q${list.commentId}">                                 
                                        <form id="myform1${list.commentId}" name="myform1${list.commentId}">         
                                            <div class="form-group fl_icon">
                                                <div class="icon"><i class="fa fa-user"></i></div>
                                                <input type="text"  value="${sessionScope.user}" readonly class="form-input" id="username2" name="username2" required readonly/>

                                            </div>
                                            <div class="form-group fl_icon">

                                                <textarea style="width: 1300px;" class="form-input"  id="content1"   name="content1" required> @${list.username} </textarea>
                                            </div>
                                            <input type="hidden" value="${list.commentId}" id="commentid" name="commentid"/>  
                                            <input type="hidden" value="${list.blogid}" id="blogid1" name="blogid1"/>  

                                            <input style="margin-right:230px; float: right;" class="btn btn-primary pull-right" type="button" value="Gửi" onclick="Comment1(${list.commentId})"/>
                                        </form>
                                    </div>
                                </div>
                        </div>
                    </div>

                </c:forEach>
            </div>
        </div>
        <input style="margin:50px; margin-bottom:0px;display: none;" type="button" id="btn2" value="Quay lại"/> 
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

                            Copyright &copy; <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script>document.write(new Date().getFullYear());</script> All Rights Reserved | This template is made with <i class="icon-heart text-primary" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank" >Colorlib</a>

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

    <script language="javascript">
                                                document.getElementById("btn1").onclick = function () {
                                                    document.getElementById("displaycomment").style.display = 'none';
                                                    document.getElementById("commentblog").style.display = 'block';
                                                    document.getElementById("btn2").style.display = 'block';
                                                    document.getElementById("btn1").style.display = 'none';
                                                };
    </script>
    <script language="javascript">
        document.getElementById("btn3").onclick = function () {
            document.getElementById("btn3").style.display = 'none';
        };
    </script>
    <script language="javascript">
        document.getElementById("btn2").onclick = function () {
            document.getElementById("displaycomment").style.display = 'block';
            document.getElementById("btn2").style.display = 'none';
            document.getElementById("commentblog").style.display = 'none';
            document.getElementById("btn1").style.display = 'block';
        };
    </script>
    <script>
        function Readonly(commentId) {
            document.getElementById('myInput' + commentId).removeAttribute('readonly');
           document.getElementById('myInput' + commentId).style.background = "white";
        }
    </script>
    <script type="text/javascript">
        function Comment() {
            var arr1 = document.getElementsByTagName('textarea');
            var content1 = arr1[0].value;
            if (content1.trim() == "") {

            } else {
                document.getElementById("btn2").style.display = 'none';
                document.getElementById("btn1").style.display = 'none';
                var xhttp;
                var username = document.myform.username.value;
                var content = document.myform.content.value;
                var blogid = document.myform.blogid.value;
                var url = "CommentController?do=displaycomment&content=" + content + "&username=" + username + "&blogid=" + blogid;
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

            }

            var content = arr1[0].value;
            if (content.trim() == "") {
                alert("Vui lòng điền nội dung");
                document.getElementById("btn2").style.display = 'block';
                return false;
            }
            console.log();
        }

    </script>

    <script type="text/javascript">
        function Delete1(commentId) {

            var xhttp;

            var blogid = document.getElementById("myform2" + commentId).blogid1.value;
            var url = "CommentController?do=RemoveComment&commentid=" + commentId + "&blogid=" + blogid;
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
            location.reload();
        }
    </script>
    <script type="text/javascript">
        function Update1(commentId) {
            var xhttp;
            var content = document.getElementById("myform3" + commentId).content3.value;
            var blogid = document.getElementById("myform3" + commentId).blogidd.value;
            var url = "CommentController?do=UpdateComment&commentid=" + commentId + "&content=" + content + "&blogid=" + blogid;
            if (window.XMLHttpRequest) {
                xhttp = new XMLHttpRequest();
            } else {
                xhttp = new ActiveObject("Microsoft.XMLHTTP");
            }
            xhttp.onreadystatechange = function () {
                if (xhttp.readyState == 4) {
                    var data = xhttp.responseText;
                    document.getElementById("mycomment3").innerHTML = data;
                }
            }
            xhttp.open("POST", url, true);
            xhttp.send();
        }

    </script>


    <script type="text/javascript">
        function Comment1(commentId) {
            var arr1 = document.getElementsByTagName('textarea');
            var content1 = arr1[1].value;
            if (content1.trim() == "") {

            } else {
                var xhttp;
                var content = document.getElementById("myform1" + commentId).content1.value;
                var username = document.getElementById("myform1" + commentId).username2.value;
                var blogid = document.getElementById("myform1" + commentId).blogid1.value;

                var url = "ReplyController?do=insertreply&content1=" + content + "&username=" + username + "&commentid=" + commentId + "&blogid=" + blogid;
                if (window.XMLHttpRequest) {
                    xhttp = new XMLHttpRequest();
                } else {
                    xhttp = new ActiveObject("Microsoft.XMLHTTP");
                }
                xhttp.onreadystatechange = function () {
                    if (xhttp.readyState == 4) {
                        var data = xhttp.responseText;
                        document.getElementById("mycomment1" + commentId).innerHTML = data;
                    }

                }
                xhttp.open("POST", url, true);
                xhttp.send();
            }
            var content = arr1[1].value;
            if (content.trim() == "") {
                alert("Vui lòng điền nội dung");
                document.getElementById("btn2").style.display = 'block';
                return false;
            }
            console.log();
        }

    </script>
    <script type="text/javascript">
        function Comment2(commentId) {
            var xhttp;
            var content = document.getElementById("myform1" + commentId).content1.value;
            var username = document.getElementById("myform1" + commentId).username2.value;
            var blogid = document.getElementById("myform1" + commentId).blogid1.value;

            var url = "ReplyController?do=displayreply&content1=" + content + "&username=" + username + "&commentid=" + commentId + "&blogid=" + blogid;
            if (window.XMLHttpRequest) {
                xhttp = new XMLHttpRequest();
            } else {
                xhttp = new ActiveObject("Microsoft.XMLHTTP");
            }
            xhttp.onreadystatechange = function () {
                if (xhttp.readyState == 4) {
                    var data = xhttp.responseText;
                    document.getElementById("mycomment1" + commentId).innerHTML = data;
                }

            }
            xhttp.open("POST", url, true);
            xhttp.send();
        }
    </script>

    <script>
        function Readonly1(commentId) {
            document.getElementById('myInput1' + commentId).removeAttribute('readonly');
        }
    </script>
</body>
</html>
