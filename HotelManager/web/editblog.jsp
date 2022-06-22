<%-- 
    Document   : editroomdevice
    Created on : Jun 8, 2022, 10:24:44 PM
    Author     : NTD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Product Page - Admin HTML Template</title>
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:400,700"
            />
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="css/fontawesome.min.css" />
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="css/templatemo-style.css">
        <link rel="stylesheet" href="css/style.css">
        <!--
            Product Admin CSS Template
            https://templatemo.com/tm-524-product-admin
        -->
    </head>
    <script type="text/javascript">
        function Delete(){
            alert("Delete success");
        }
    </script>
    <body id="reportsPage">
        <nav class="navbar navbar-expand-xl">
            <div class="container h-100">
                <a class="navbar-brand" href="index.html">
                    <h1 class="tm-site-title mb-0">Product Admin</h1>
                </a>
                <button
                    class="navbar-toggler ml-auto mr-0"
                    type="button"
                    data-toggle="collapse"
                    data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false"
                    aria-label="Toggle navigation"
                    >
                    <i class="fas fa-bars tm-nav-icon"></i>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mx-auto h-100">
                        <li class="nav-item">
                            <a class="nav-link" href="index.html">
                                <i class="fas fa-tachometer-alt"></i> Dashboard
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a
                                class="nav-link dropdown-toggle"
                                href="#"
                                id="navbarDropdown"
                                role="button"
                                data-toggle="dropdown"
                                aria-haspopup="true"
                                aria-expanded="false">
                                <i class="far fa-file-alt"></i>
                                <span> Reports <i class="fas fa-angle-down"></i> </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Daily Report</a>
                                <a class="dropdown-item" href="#">Weekly Report</a>
                                <a class="dropdown-item" href="#">Yearly Report</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a
                                class="nav-link dropdown-toggle"
                                href="#"
                                id="navbarDropdown"
                                role="button"
                                data-toggle="dropdown"
                                aria-haspopup="true"
                                aria-expanded="false">
                                <i class="fas fa-door-open"></i>
                                <span> Room <i class="fas fa-angle-down"></i> </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Update Device</a>
                                <a class="dropdown-item" href="#">Weekly Report</a>
                                <a class="dropdown-item" href="#">Yearly Report</a>
                            </div>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="accounts.html">
                                <i class="far fa-user"></i> Accounts
                            </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                <i class="fab fa-blogger"></i>
                                <span>
                                    Blog <i class="fas fa-angle-down"></i>
                                </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                 <a class="dropdown-item" href="BlogManagerController?do=editblog">Edit Blog</a>
                                    <a class="dropdown-item" href="addblog.jsp">Insert Blog</a>
                            </div>
                        </li>
                        <li class="nav-item dropdown">
                            <a
                                class="nav-link dropdown-toggle"
                                href="#"
                                id="navbarDropdown"
                                role="button"
                                data-toggle="dropdown"
                                aria-haspopup="true"
                                aria-expanded="false">
                                <i class="fas fa-cog"></i>
                                <span> Settings <i class="fas fa-angle-down"></i> </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Profile</a>
                                <a class="dropdown-item" href="#">Billing</a>
                                <a class="dropdown-item" href="#">Customize</a>
                            </div>
                        </li>
                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link d-block" href="login.html">
                                Admin, <b>Logout</b>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="">
            <div class="row tm-content-row">
                <div class="col-sm-12 col-md-12 col-lg-8 col-xl-12 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-products">
                        <div class="tm-product-table-container">
                            <table class="table table-hover tm-table-small tm-product-table">
                                <thead>      
                                    <tr>

                                        <th scope="col">BlogAuthor</th>
                                        <th scope="col">BlogDescription</th>
                                        <th scope="col">BlogImage</th>
                                        <th scope="col">BlogTitleString</th>                                      
                                        <th scope="col">Delete</th>
                                        <th scope="col">Update</th>
                                    </tr>
                                </thead>
                                <c:forEach items="${b}" var="c">
                                    <form action="BlogManagerController?do=updateblog"method="get">
                                        <tr>

                                            <td>${c.blogAuthor}</td>
                                            <td>${c.blogDescription}</td>
                                            <td><img style="width: 350px; height: 250px;" src="images/anhblog/${c.blogImage}" alt=""></td>
                                            <td>${c.blogTitleString}</td>
                                        <input name="blogauthor" value="${c.blogAuthor}" type="hidden">
                                        <input name="blogDescription" value="${c.blogDescription}" type="hidden">
                                        <input name="blogImage" value="${c.blogImage}" type="hidden">
                                        <input name="blogTitleString" value="${c.blogTitleString}" type="hidden">
                                         <input name="date" value="${c.blogDate}" type="hidden">
                                        <td>
                                            <a href="BlogManagerController?do=deleteblog&blogid=${c.blogID}" class="tm-product-delete-link" onclick="Delete()"/>
                                                <i class="far fa-trash-alt tm-product-delete-icon" onclick="delete()"></i>
                                            </a>
                                        </td>

                                        <td>
                                             <input name="BlogID" value="${c.blogID}" type="hidden">
                                            <button type="submit" name="do" value="updateblog" class="tm-product-delete-link">
                                                <i class="fas fa-arrow-alt-circle-up tm-product-delete-icon"></i>
                                            </button>
                                        </td>
                                        </tr>
                                    </form>   
                                </c:forEach>
                            </table>
                        </div>
                        <div style="padding-left: 40%;"class="site-block-27">

                            <ul>
                                <c:forEach begin="1" end="${n}" var="c">
                                    <li><a href="BlogManagerController?do=editblog&page=${c}">${c}</a></li>
                                    </c:forEach>
                            </ul>

                        </div>

                        <!-- table container -->

                    </div>
                </div>

            </div>
        </div>
        <footer class="tm-footer row tm-mt-small">
            <div class="col-12 font-weight-light">
                <p class="text-center text-white mb-0 px-4 small">
                    Copyright &copy; <b>2018</b> All rights reserved. 

                    Design: <a rel="nofollow noopener" href="https://templatemo.com" class="tm-footer-link">Template Mo</a>
                </p>
            </div>
        </footer>

        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <script>
            $(function () {
                $(".tm-product-name").on("click", function () {
                    window.location.href = "edit-product.html";
                });
            });
        </script>
    </body>
</html>
