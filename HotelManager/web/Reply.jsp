
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <c:forEach items="${listcomment1}" var="list">
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
                        <i style="display: inline-block; padding-left: 1900px;"class="fa fa-clock-o"></i>
                        ${list.date}
                    </span>
                    <input type="hidden" value="${list.commentId}" id="blogid" name="commentid"/>  
                    <form style="width: 1500px;" id="myform3${list.commentId}" name="myform3${list.commentId}"> 
                        <input style="display: inline-block;width: 1200px;" value="${list.content}" id="content3" name="content3" class="be-comment-text">
                         <div style="display: inline-block;"class="nav-item dropdown">
                            <a href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                <i class="fab fa-blogger"></i>
                                <span>
                                    Blog <i class="fas fa-angle-down"></i>
                                </span>
                            </a>


                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">

                                
                                <input type="hidden" value="${list.commentId}" id="commentidd${list.commentId}" name="commentidd"/>
                                <input type="hidden" value="${list.blogid}" id="blogidd" name="blogidd"/>  
<!--                                     <input type="hidden" value="${list.content}" id="contentid" name="content3"/>-->
                                <a class="dropdown-item" onclick="Update1(${list.commentId})">Chỉnh sửa</a>
                                </form>
                                <form id="myform2${list.commentId}" name="myform2${list.commentId}"> 
                                    <input type="hidden" value="${list.commentId}" id="blogid" name="commentid"/>
                                    <input type="hidden" value="${list.blogid}" id="blogid1" name="blogid1"/>  
                                   
                                    <a class="dropdown-item"  onclick="Delete1(${list.commentId})"  >Xóa</a>
                                </form>
                            </div>
                        </div>

                        <div class="accordion" id="myaccordion" style="max-width: 300px">   
                            <div class="card-header btn"  data-toggle="collapse" data-target="#q${list.commentId}" aria-expanded="true"
                                 data-parent="#myaccordion">
                                Reply
                            </div>
                       <div id ="mycomment1${list.commentId}"> </div>
                                <div class="card-body collapse"  data-toggle="collapse"  aria-expanded="false" id="q${list.commentId}">                                 
                                    <form id="myform1${list.commentId}" name="myform1${list.commentId}">         
                                        <div class="form-group fl_icon">
                                            <div class="icon"><i class="fa fa-user"></i></div>
                                            <input type="text"  value="${sessionScope.user}" readonly class="form-input" id="username1" name="username1" required readonly/>

                                        </div>
                                        <div class="form-group fl_icon">

                                            <textarea style="width: 1300px;" class="form-input"  id="content1"   name="content1" required> @${list.username} </textarea>
                                        </div>
                                        <input type="hidden" value="${list.commentId}" id="commentid" name="commentid"/>  
                                        <input type="hidden" value="${list.blogid}" id="blogid1" name="blogid1"/>  

                                        <input style="margin-left: 1300px;" class="btn btn-primary pull-right" type="button" value="Gửi" onclick="Comment1(${list.commentId})"/>


                                    </form>
                                </div>
                            </div>
                        </div>
                </div>
            </c:forEach>
                        </body>
                        </html>
