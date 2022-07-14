
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
                        <input style="display: inline-block;width: 1200px;" value="${list.content}" id="content3"  name="content3" class="be-comment-text">
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
                        </div>
                </div>
            </c:forEach>
                        </body>
                      
                        </html>
