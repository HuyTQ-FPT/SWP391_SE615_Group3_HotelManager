<%-- 
    Document   : updateProfileAdmin
    Created on : Jun 9, 2022, 10:48:02 PM
    Author     : Minh Hieu
--%>

<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
    <style>
        .form-group{
            position: relative;
        }
        .style{
            position: absolute;
            left: 20px;
            top:40px;
            font-size: 10px;
        }
        .style1{
            position: absolute;
            left: 20px;
            top:310px;
            font-size: 10px;
        }
    </style>
    <body id="reportsPage">
        <div class="" id="home">
            <%@include file="headerAdmin.jsp" %>
            <div class="container mt-5">

                <!-- row -->
                <div class="row tm-content-row">
                    <div class="tm-block-col tm-col-avatar">
                        <div class="tm-bg-primary-dark tm-block tm-block-avatar">
                            <h2 class="tm-block-title">Change Avatar</h2>
                            <div class="tm-avatar-container">
                                <img
                                    src="images/anhdaidien/admin.jpg"
                                    alt="Avatar"
                                    class="tm-avatar img-fluid mb-4"
                                    />
<!--                                <a href="#" class="tm-avatar-delete-link">
                                    <i class="far fa-trash-alt tm-product-delete-icon"></i>
                                </a>-->
                            </div>
<!--                            <button class="btn btn-primary btn-block text-uppercase">
                                Upload New Photo
                            </button>-->
                         
                            <a class="btn btn-primary btn-block text-uppercase" href="LoginController?do=ChangePassword1">
                                Thay đổi mật khẩu
                            </a>
                        </div>
                    </div>
                    <%
                        User user = (User) session.getAttribute("u");
                    %>
                    <div class="tm-block-col tm-col-account-settings">
                        <div class="tm-bg-primary-dark tm-block tm-block-settings">
                            <h2 class="tm-block-title">Account Settings</h2>
                            <h4 style="color: red;font-size: 15px;">${requestScope.err}</h4>
                            <h4 style="color: red;font-size: 15px;">${requestScope.mess}</h4>
                            <form action="AdminController?do=updateAdmin" method="POST" class="tm-signup-form row">
                                <input type="hidden" name="uid" value="<%=user.getUserID()%>">
                                <div class="form-group col-lg-6">
                                    <label for="inputYourname">Your Name</label>
                                    <input style="background-color: white; color: #54657D;"
                                           id="name"
                                           name="name"
                                           type="text"
                                           maxlength="50"
                                           required
                                           value="<%=user.getUserName()%>"
                                           class="form-control validate"
                                           />
                                </div>
                                <div class="form-group col-lg-6">
                                    <label for="email">Email</label>
                                    <i class="fas fa-star style" style="color:red;"></i>   <input style="background-color: white; color: #54657D;"
                                                                                                  id="email"
                                                                                                  name="inputEmailAddress"
                                                                                                  type="email"
                                                                                                  maxlength="100" 
                                                                                                  required
                                                                                                  value="<%=user.getUserEmail()%>"
                                                                                                  class="form-control  validate"
                                                                                                  />
                                </div>
                                <div class="form-group col-lg-6">
                                    <label for="inputCMT">CMT</label>
                                    <i class="fas fa-star style" style="color:red;"></i>    <input style="background-color: white; color: #54657D;"
                                                                                                   id="email"
                                                                                                   name="inputCMT"
                                                                                                   type="text"
                                                                                                   maxlength="20" required 
                                                                                                   value="<%=user.getCMT()%>"

                                                                                                   class="form-control validate"
                                                                                                   />
                                </div>
                                <div class="form-group col-lg-6">
                                    <label for="inputAdress">Address</label>
                                    <input style="background-color: white; color: #54657D;"
                                           id="email"
                                           name="inputAdress"
                                           type="text"
                                           required maxlength="100"
                                           value="<%=user.getUserAdress()%>"
                                           class="form-control validate"
                                           />
                                </div>


                                <div class="form-group col-lg-6">
                                    <label for="phone">Phone</label>
                                    <input style="background-color: white; color: #54657D;"
                                           id="phone"
                                           name="inputPhone"
                                           type="tel"
                                           required maxlength="15"
                                           value="<%=user.getUserPhone()%>"
                                           class="form-control validate"
                                           />
                                </div>
                                <div class="form-group col-lg-6">
                                    <label for="inputBirthday">Birthday</label>
                                    <input style="background-color: white; color: #54657D;"
                                           id="phone"
                                           name="inputBirthday"
                                           type="date"

                                           value="<%=user.getBirthday()%>"
                                           class="form-control validate"
                                           />
                                </div>

                                <div class="col-12">
                                    <button
                                       type="submit"
                                       name="submit"
                                       class="btn btn-primary btn-block text-uppercase"
                                       >
                                        Update Account
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <script src="js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
    </body>
</html>
