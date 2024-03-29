<%-- 
    Document   : ManageComment
    Created on : Jul 11, 2022, 4:20:28 PM
    Author     : Thai Quan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:400,700"
            />
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="css/fontawesome.min.css" />
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <!-- https://getbootstrap.com/ -->

        <link rel="stylesheet" href="css/style.css">
         <link href="css/navdropdown.css" rel="stylesheet">   
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
        <script type="text/javascript" 
        src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <style>
        html {
            font-size: 16px;
            overflow-x: hidden;
        }
        body {
            font-family: Roboto, Helvetica, Arial, sans-serif;
            background-color: #4e657a;
            overflow-x: hidden;
        }
        a {
            transition: all 0.3s ease;
        }
        a:focus,
        a:hover {
            text-decoration: none;
        }
        button:focus {
            outline: 0;
        }
        .navbar-brand {
            display: flex;
            align-items: center;
        }
        .tm-site-icon {
            color: #656565;
        }
        .tm-site-title {
            display: inline-block;
            text-transform: uppercase;
            font-size: 1.3rem;
            font-weight: 700;
            color: #fff;
        }
        .navbar {
            height: 100px;
            background-color: #567086;
            padding: 0;
        }
        .navbar .container {
            position: relative;
        }
        .tm-logout-icon {
            font-size: 1.5em;
        }
        .tm-mt-big {
            margin-top: 57px;
        }
        .tm-mb-big {
            margin-bottom: 60px;
        }
        .tm-mt-small {
            margin-top: 20px;
        }
        .tm-block-col {
            margin-bottom: 30px;
        }
        .tm-block {
            padding: 40px;
            -webkit-box-shadow: 1px 1px 5px 0 #455c71;
            -moz-box-shadow: 1px 1px 5px 0 #455c71;
            box-shadow: 1px 1px 5px 0 #455c71;
            min-height: 350px;
            height: 100%;
            max-height: 450px;
        }
        .tm-block-avatar,
        .tm-block-settings {
            max-height: none;
        }
        .tm-block-avatar {
            height: auto;
        }
        .tm-block-h-auto {
            min-height: 1px;
            max-height: none;
            height: auto;
        }
        .tm-block-scroll {
            overflow-y: scroll;
        }
        .tm-block-overflow {
            overflow: hidden;
        }
        .tm-block-title {
            font-size: 1.1rem;
            font-weight: 700;
            color: #fff;
            margin-bottom: 30px;
        }
        .nav-link {
            color: #fff;
            height: 100%;
            display: flex;
            align-items: center;
            justify-content: center;
            flex-direction: column;
            font-size: 90%;
        }
        .nav-link > i {
            margin-bottom: 10px;
            margin-right: 0;
            font-size: 1.5rem;
        }
        .dropdown-item,
        .nav-link {
            padding: 15px 20px;
        }
        .dropdown-menu {
            font-size: 90%;
            color: #fff;
            background-color: #567086;
            border-radius: 0;
            padding-top: 10px;
            padding-bottom: 10px;
            min-width: auto;
        }
        .dropdown-item {
            color: #fff;
            padding: 15px 30px;
        }
        .navbar-nav .active > .nav-link,
        .navbar-nav .nav-link.active {
            background-color: #f5a623;
            color: #fff;
        }
        .navbar-nav .nav-link.active i {
            color: #fff;
        }
        .dropdown-item:focus,
        .dropdown-item:hover {
            background-color: #567086;
        }
        .navbar-nav a:hover,
        .navbar-nav a:hover i {
            color: #f5a623;
        }
        .nav-item {
            text-align: center;
        }
        .nav-item:last-child {
            margin-right: 0;
        }
        .dropdown-toggle::after {
            display: none;
        }
        .dropdown-menu {
            margin-top: 0;
            border: 0;
        }
        .tm-content-row {
            justify-content: space-between;
            margin-left: -20px;
            margin-right: -20px;
        }
        .tm-col {
            padding-left: 20px;
            padding-right: 20px;
            margin-bottom: 50px;
        }
        .tm-col-big {
            width: 39%;
        }
        .tm-col-small {
            width: 21.95%;
        }
        .tm-gray-circle {
            width: 80px;
            height: 80px;
            background-color: #aaa;
            border-radius: 50%;
            margin-right: 15px;
        }
        .tm-notification-items {
            overflow-y: scroll;
            height: 90%;
        }
        .tm-notification-item {
            padding: 15px;
            background-color: #4e657a;
            color: #fff;
            font-size: 95%;
            margin-bottom: 15px;
        }
        .tm-notification-item:last-child {
            margin-bottom: 0;
        }
        .tm-notification-link {
            color: #f5a623;
        }
        .tm-text-color-secondary {
            color: #bdcbd8;
        }
        .tm-small {
            font-size: 90%;
        }
        .table {
            background-color: #50697f;
            color: #fff;
            font-size: 85%;
            margin-bottom: 0;
        }
        thead {
            background-color: #486177;
            color: #fff;
        }
        .table thead th {
            border-bottom: 0;
        }
        .tm-status-circle {
            display: inline-block;
            margin-right: 5px;
            vertical-align: middle;
            width: 5px;
            height: 5px;
            border-radius: 50%;
            margin-top: -3px;
        }
        .moving {
            background-color: #9be64d;
            box-shadow: 0 0 8px #9be64d, inset 0 0 8px #9be64d;
        }
        .pending {
            background-color: #efc54b;
            box-shadow: 0 0 8px #efc54b, inset 0 0 8px #efc54b;
        }
        .cancelled {
            background-color: #da534f;
            box-shadow: 0 0 8px #da534f, inset 0 0 8px #da534f;
        }
        .tm-avatar {
            width: 345px;
        }
        .tm-avatar-container {
            position: relative;
            cursor: pointer;
            display: flex;
            align-items: center;
            flex-direction: column;
        }
        .tm-avatar-delete-link {
            position: absolute;
            left: 50%;
            top: 50%;
            margin-left: -25px;
            margin-top: -25px;
            z-index: 1000;
            padding: 14px;
            border-radius: 50%;
            background-color: rgba(57, 78, 100, 0.7);
            display: inline-block;
            width: 50px;
            height: 50px;
            text-align: center;
            display: none;
            transition: all 0.2s ease;
        }
        .tm-avatar-container:hover .tm-avatar-delete-link {
            display: block;
        }
        .tm-col-avatar {
            max-width: 425px;
            width: 37%;
            padding-left: 15px;
            padding-right: 15px;
        }
        .tm-col-account-settings {
            max-width: 822px;
            width: 63%;
            padding-left: 15px;
            padding-right: 15px;
        }
        .form-control {
            background-color: #54657d;
            color: #fff;
            border: 0;
        }
        .form-control:focus {
            background-color: #60738e;
            color: #fff;
            border-color: transparent;
            box-shadow: 0 0 0 0.1rem rgb(180, 206, 233, 0.5);
        }
        .form-group label {
            color: #fff;
            margin-bottom: 10px;
        }
        .tm-hide-sm {
            display: block;
        }
        .tm-list-group {
            counter-reset: myOrderedListItemsCounter;
            padding-left: 0;
        }
        .tm-list-group > li {
            list-style-type: none;
            position: relative;
            cursor: pointer;
            transition: all 0.3s ease;
            padding: 8px;
        }
        .tm-list-group > li:hover {
            color: #0266c4;
        }
        .tm-list-group > li:before {
            counter-increment: myOrderedListItemsCounter;
            content: counter(myOrderedListItemsCounter) ".";
            margin-right: 0.5em;
        }
        .tm-list {
            padding-left: 30px;
        }
        .tm-list > li {
            margin-bottom: 20px;
        }
        .form-control {
            padding: 19px 18px;
            border-radius: 0;
            height: 50px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .btn {
            border-radius: 0;
            padding: 13px 28px;
            transition: all 0.2s ease;
            max-width: 100%;
        }
        .btn-small {
            padding: 10px 24px;
        }
        .btn-primary {
            color: #fff;
            background-color: #f5a623;
            border: 2px solid #f5a623;
            font-size: 90%;
            font-weight: 600;
        }
        .btn-primary:active,
        .btn-primary:hover {
            color: #f5a623;
            background-color: transparent;
            border: 2px solid #f5a623;
        }
        .custom-file-input {
            cursor: pointer;
        }
        .custom-file-label {
            border-radius: 0;
        }
        .table td,
        .table th {
            border-top: 1px solid #415a70;
            padding: 15px 25px;
            vertical-align: middle;
        }
        .tm-table-small td,
        .tm-table-small th {
            padding-left: 12px;
            padding-right: 12px;
        }
        .table-hover tbody tr {
            transition: all 0.2s ease;
        }
        .table-hover tbody tr:hover {
            color: #a0c0de;
        }
        .tm-bg-primary-dark {
            background-color: #435c70;
        }
        .tm-bg-gray {
            background-color: rgba(0, 0, 0, 0.05);
        }
        .tm-table-mt {
            margin-top: 66px;
        }
        .page-item:first-child .page-link {
            border-top-left-radius: 0;
            border-bottom-left-radius: 0;
        }
        .page-item:last-child .page-link {
            border-top-right-radius: 0;
            border-bottom-right-radius: 0;
        }
        .page-link {
            padding: 12px 18px;
        }
        .page-link,
        .page-link:hover {
            color: #000;
        }
        .page-item {
            margin-right: 18px;
        }
        .page-item:last-child {
            margin-right: 0;
        }
        .page-item.active .page-link {
            background-color: #e9ecef;
            border-color: #dee2e6;
            color: #000;
        }

        .tm-block-products {
            min-height: 725px;
        }
        .tm-block-product-categories {
            min-height: 650px;
        }
        .tm-product-table-container {
            max-height: 465px;
            margin-bottom: 15px;
            overflow-y: scroll;
        }
        .tm-product-table tr {
            font-weight: 600;
        }
        .tm-product-name {
            font-size: 0.95rem;
            font-weight: 600;
        }
        .tm-product-delete-icon {
            font-size: 1.1rem;
            color: #fff;
        }
        .tm-product-delete-link {
            padding: 10px;
            border-radius: 50%;
            background-color: #394e64;
            display: inline-block;
            width: 40px;
            height: 40px;
            text-align: center;
        }
        .tm-product-delete-link:hover .tm-product-delete-icon {
            color: #6d8ca6;
        }
        .custom-select {
            width: 100%;
            border: none;
            color: #acc6de;
            height: 50px;
            -webkit-appearance: none;
            -moz-appearance: none;
            -ms-appearance: none;
            -o-appearance: none;
            appearance: none;
            -webkit-border-radius: 0;
            -moz-border-radius: 0;
            -ms-border-radius: 0;
            -o-border-radius: 0;
            border-radius: 0;
            padding: 15px;
            background: url(../img/arrow-down.png) 98% no-repeat #50657b;
        }
        .custom-select:focus {
            outline: 0;
        }
        .tm-trash-icon {
            color: #6e6c6c;
            cursor: pointer;
        }
        .tm-trash-icon:hover {
            color: #9f1321;
        }
        .tm-footer {
            background-color: #567086;
            padding-top: 30px;
            padding-bottom: 30px;
            -webkit-box-shadow: 0 -3px 5px 0 rgba(69, 92, 113, 0.59);
            -moz-box-shadow: 0 -3px 5px 0 rgba(69, 92, 113, 0.59);
            box-shadow: 0 -3px 5px 0 rgba(69, 92, 113, 0.59);
        }
        .custom-select {
            height: 50px;
            border-radius: 0;
        }


        @media (min-width: 1200px) {
            .navbar-expand-xl .navbar-nav .nav-link {
                padding-left: 28px;
                padding-right: 28px;
            }
            .navbar-collapse {
                height: 100%;
            }
        }
        @media (min-width: 992px) {
            .navbar-expand-lg .navbar-nav .nav-link {
                padding: 15px 20px;
            }
        }
        @media (max-width: 1275px) and (min-width: 1200px) {
            .nav-item {
                margin-right: 15px;
            }
        }
        @media (max-width: 1350px) {
            .nav-item {
                margin-right: 1px;
            }
        }
        @media (max-width: 1199px) {
            .tm-col-big,
            .tm-col-small {
                width: 49.65%;
            }
            .navbar-collapse {
                padding: 0;
                box-shadow: rgba(255, 255, 255, 0.1) 0 1px 1px 1px;
                position: absolute;
                top: 72px;
                right: 20px;
                width: 200px;
                z-index: 1000;
            }
            .dropdown-menu {
                text-align: center;
            }
            .nav-link {
                color: #fff;
                background-color: #567086;
                padding: 15px;
                flex-direction: row;
            }
            .nav-link > i {
                font-size: 1rem;
                margin-right: 10px;
                margin-bottom: 0;
            }
            .nav-item {
                margin-right: 0;
            }
            .tm-block-taller {
                max-height: 520px;
            }
        }
        @media (max-width: 1199.98px) {
            .navbar-expand-xl > .container,
            .navbar-expand-xl > .container-fluid {
                padding-left: 15px;
                padding-right: 15px;
            }
            .navbar-collapse {
                right: 15px;
            }
        }
        @media (max-width: 991px) {
            .tm-col-big,
            .tm-col-small {
                width: 100%;
                min-height: 383px;
                height: auto;
            }
            .tm-block {
                padding: 30px;
            }
        }
        @media (max-width: 767px) {
            .tm-col-account-settings,
            .tm-col-avatar {
                width: 100%;
                max-width: 100%;
            }
            .tm-block-avatar {
                display: flex;
                flex-direction: column;
            }
            .tm-avatar {
                align-self: center;
            }
            .tm-hide-sm {
                display: none;
            }
        }
        @media (max-width: 633px) {
            .page-item {
                margin-top: 10px;
            }
            .custom-select {
                background-position: 96%;
            }
        }
        @media (max-width: 574px) {
            .navbar-collapse {
                top: 47px;
            }
            .navbar {
                height: 50px;
            }
            .tm-site-title {
                font-size: 1.4rem;
                margin-left: 7px;
            }
            .tm-site-icon {
                font-size: 2em;
            }
        }
        @media (max-width: 480px) {
            .tm-mt-big {
                margin-top: 45px;
            }
            .tm-mb-big {
                margin-bottom: 45px;
            }
            #barChart,
            #lineChart {
                max-height: 350px;
            }
        }
    </style>
    <body>

        <%@include file="headerAdmin.jsp" %>

        <div class="wrapper">
            <table class="table table-bordered cart_summary">
                <thead>
                    <tr>
                        <th class="cart_product" style="text-align: center">ID bình luận</th>
                        <th class="cart_product" style="text-align: center">Người dùng</th>
                        <th style="text-align: center">Nội dung</th>     
                        <th class="cart_product" style="text-align: center">Bình luận trà lời id</th>
                        <th class="cart_product" style="text-align: center">BlogID</th>
                        <th style="text-align: center">Xóa</th>                      
                        </th>
                    </tr>
                </thead>
                <c:forEach items="${listcomment}" var="c">
                    <tbody>       
                    <form action="CommentController?do=remove" method="get">
                        <tr>
                            <td class="cart_product" style="text-align: center">
                                ${c.commentId} 
                                <br>                             
                            </td>
                            <td class="cart_product" style="text-align: center">
                                ${c.username} 
                                <br>                             
                            </td>
                        <input type="hidden" value="${c.commentId}" name="commentid">
                        <input type="hidden" value="${c.blogid}" name="blogid">
                        <td class="cart_product" style="text-align: center">
                            ${c.content}
                            <br>                             
                        </td>
                        <td class="cart_product" style="text-align: center">
                            ${c.parentId} 
                            <br>                             
                        </td>
                        <td class="cart_product" style="text-align: center">
                            ${c.blogid} 
                            <br>                             
                        </td>
                        <td class="price" style="text-align: center">
                            <span><a href="CommentController?do=remove&commentid=${c.commentId}&blogid=${c.blogid}" type="button" onclick="Remove()"> Xóa </a></span>
                        </td>                        
                        </tr>
                    </form>                    
                    </tbody>
                </c:forEach>
            </table>	
            <div style="text-align: center;padding-top: 30px;" class="site-block-27">
                <ul>
                    <c:forEach begin="1" end="${n}" var="c">
                        <li><a href="CommentController?do=display&blogid=${blogid}&page=${c}">${c}</a></li>
                        </c:forEach>
                </ul>
            </div>    

    </body>
    <script>
        function Remove() {
            alert("Thành công");
            location.upload();
        }
    </script>
</html>
