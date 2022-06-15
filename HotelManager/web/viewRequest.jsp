<%-- 
    Document   : viewFeedBack
    Created on : Jun 15, 2022, 9:53:41 AM
    Author     : Admin
--%>

<%@page import="Entity.sendFeedback"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Request</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="css/fontawesome.min.css">
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="css/templatemo-style.css">

        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
    </head>

    <body id="reportsPage">
        <nav class="navbar navbar-expand-xl">
            <div class="container h-100">
                <a class="navbar-brand" href="#">
                    <h1 class="tm-site-title mb-0">Admin</h1>
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
                            <a class="nav-link" href="#">
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
                                aria-expanded="false"
                                >
                                <i class="far fa-file-alt"></i>
                                <span> Reports <i class="fas fa-angle-down"></i> </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Daily Report</a>
                                <a class="dropdown-item" href="#">Weekly Report</a>
                                <a class="dropdown-item" href="#">Yearly Report</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <i class="fas fa-shopping-cart"></i> Product
                            </a>
                        </li>

                        <!--              <li class="nav-item">
                                        <a class="nav-link active" href="accounts.html">
                                          <i class="far fa-user"></i> Accounts
                                        </a>
                                      </li>-->
                        <li class="nav-item dropdown nav-item">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                <i class="far fa-user"></i>
                                <span>
                                    Accounts <i class="fas fa-angle-down"></i>
                                </span>
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
                                <a class="dropdown-item" href="BlogManagerController?do=updateblog">Update Blog</a>
                                <a class="dropdown-item" href="BlogManagerController?do=insertblog">Insert Blog</a>
                                <a class="dropdown-item" href="BlogManagerController">Delete Blog</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <i class="fas fa-newspaper"></i></i> Request Message
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
                                aria-expanded="false"
                                >
                                <i class="fas fa-cog"></i>
                                <span> Settings <i class="fas fa-angle-down"></i> </span>
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="AdminController?do=viewProfileAdmin">Profile</a>
                                <a class="dropdown-item" href="#">Billing</a>
                                <a class="dropdown-item" href="#">Customize</a>
                            </div>
                        </li>
                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link d-block" href="LoginController?do=logout">
                                Admin, <b>Logout</b>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <%
            sendFeedback s = (sendFeedback) request.getAttribute("s");
        %>
        <div class="container">
            <div class="row">
                <div class="col">
                    <p class="text-white mt-5 mb-5"></p>
                </div>
            </div>
            <div class="row tm-content-row">
                <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block" >
                        <div class="card-people mt-auto" style="padding: 0">
                            <img style="width: 100%; min-height:300px" src="images/Message.png">

                            <div class="weather-info">
                            </div>
                        </div>
                    </div>
                </div>




                <div class="col-12 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-taller tm-block-scroll">
                        <h2 class="tm-block-title">List Message</h2>


                        <table class="table">

                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col"> Email</th>
                                    <th scope="col">Tiêu đề</th>
                                    <th style=" width:10px;
                                        height:100px;
                                        word-wrap:break-word;" >Nội dung</th>


                                </tr>
                            </thead>

                            <tbody>
                                <tr>
                                    <th scope="row"><b><%=s.getmId()%></b></th>
                                    <td>
                                        <div class="tm-status-circle ">
                                        </div><%=s.getEmail()%>
                                    </td>
                                    <td><b><%=s.getTitle()%></b></td>
                                    <td ><%=s.getContent()%></td>


                                </tr>

                            </tbody>

                        </table>
                        <button  style="margin-top: 20px" onclick="deleteId('<%=s.getmId()%>')" class="btn btn-primary">  Xoá </a></button>
                        <a style="float: right; margin-top: 20px" class="btn btn-danger" href="SendFeedbackController?do=listMessFeedBack">Back</a>

                    </div>
                </div>
            </div>
        </div>
        <script>
            function deleteId(id) {
                if (confirm("Bạn có muốn xoá yêu cầu này không?")) {
                    window.location = "SendFeedbackController?do=deleteMessage&mId=" + id;
                }

            }

        </script>
    </body>
</html>
