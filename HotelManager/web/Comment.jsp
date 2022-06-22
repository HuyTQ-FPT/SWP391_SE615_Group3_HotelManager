<%-- 
    Document   : Comment
    Created on : Jun 20, 2022, 2:23:14 AM
    Author     : Thai Quan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${listcomment}" var="list">
            <div class="be-comment">
                <div class="be-img-comment">	
                    <a href="blog-detail-2.html">
                        <img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="" class="be-ava-comment">
                    </a>
                </div>
                <div class="be-comment-content">

                    <span class="be-comment-name">
                        <a href="blog-detail-2.html">${list.username}</a>
                    </span>
                    <span class="be-comment-time">
                        <i class="fa fa-clock-o"></i>
                        ${list.date}
                    </span>

                    <p class="be-comment-text">
                        ${list.content}
                    </p>
                    <p>Reply</p>
                </div>
            </div>
        </c:forEach>
    </body>
</html>
