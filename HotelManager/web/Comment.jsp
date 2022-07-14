
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/datatables.css">
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
        <script src="https://code.iconify.design/2/2.2.1/iconify.min.js"></script>



        <title>JSP Page</title>

    </head>
    <body>


        <c:forEach items="${listcomment}" var="list">
            <div class="be-comment">
                <div class="be-img-comment">	
                    <a href="blog-detail-2.html">
                        <img  src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="" class="be-ava-comment">
                    </a>
                </div>

                <div class="be-comment-content">

                    <span class="be-comment-name">
                        <a href="blog-detail-2.html">${list.username}</a>
                    </span>
                    <span class="be-comment-time">
                        <i style="padding-left: 40px;"class="fa fa-clock-o"></i>
                        ${list.date}
                    </span>
                    <input type="hidden" value="${list.commentId}" id="blogid" name="commentid"/>  
                    <form id="myform3${list.commentId}" name="myform3${list.commentId}"> 
                        <input value="${list.content}"style="width:1400px; display: inline-block;" id="content3" name="content3"  class="be-comment-text">
                        <!--                        <input id="myButton" type="button" value="update"   />-->
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
                                <a class="dropdown-item" onclick="Update1(${list.commentId})">Chỉnh sửa</a>
                                </form>
                                <form id="myform2${list.commentId}" name="myform2${list.commentId}"> 
                                    <input type="hidden" value="${list.commentId}" id="blogid" name="commentid"/>
                                    <input type="hidden" value="${list.blogid}" id="blogid1" name="blogid1"/>  
                                    <input style="margin-left: 1300px;" class="btn btn-primary pull-right" type="button" value="Gửi"/>
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
    </body>
     
    
</html>
