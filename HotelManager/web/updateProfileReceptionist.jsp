<%-- 
    Document   : updateProfileReceptionis
    Created on : Jun 8, 2022, 9:54:03 PM
    Author     : Minh Hieu
--%>

<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UpdateReceptionist</title>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
        <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>

        <!-- Font Icon -->
        <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <style>
            body{margin-top:20px;
                 background-color:#f2f6fc;
                 color:#69707a;
            }
            .img-account-profile {
                height: 10rem;
            }
            .rounded-circle {
                border-radius: 50% !important;
            }
            .card {
                box-shadow: 0 0.15rem 1.75rem 0 rgb(33 40 50 / 15%);
            }
            .card .card-header {
                font-weight: 500;
            }
            .card-header:first-child {
                border-radius: 0.35rem 0.35rem 0 0;
            }
            .card-header {
                padding: 1rem 1.35rem;
                margin-bottom: 0;
                background-color: rgba(33, 40, 50, 0.03);
                border-bottom: 1px solid rgba(33, 40, 50, 0.125);
            }
            .form-control, .dataTable-input {
                display: block;
                width: 100%;
                padding: 0.875rem 1.125rem;
                font-size: 0.875rem;
                font-weight: 400;
                line-height: 1;
                color: #69707a;
                background-color: #fff;
                background-clip: padding-box;
                border: 1px solid #c5ccd6;
                -webkit-appearance: none;
                -moz-appearance: none;
                appearance: none;
                border-radius: 0.35rem;
                transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
            }

            .nav-borders .nav-link.active {
                color: #0061f2;
                border-bottom-color: #0061f2;
            }
            .nav-borders .nav-link {
                color: #69707a;
                border-bottom-width: 0.125rem;
                border-bottom-style: solid;
                border-bottom-color: transparent;
                padding-top: 0.5rem;
                padding-bottom: 0.5rem;
                padding-left: 0;
                padding-right: 0;
                margin-left: 1rem;
                margin-right: 1rem;
            }
            .form-group{
                position: relative;
            }
            .style{
<<<<<<< Updated upstream
                position: absolute;
                left: 20px;
                top:220px;
                font-size: 10px;
            }
            .style1{
                position: absolute;
                left: 20px;
                top:320px;
                font-size: 10px;
            }
=======
        position: absolute;
        left: 10px;
        top:30px;
        font-size: 10px;
    }
>>>>>>> Stashed changes
        </style>
    </head>
    <body>

        <div class="container-xl px-4 mt-4">
            <!-- Account page navigation-->
            <nav class="nav nav-borders">
                <a class="nav-link active ms-0" href="ReceptionistController?do=profile" target="__blank">Profile</a>
                <a class="nav-link" href="ReceptionistController"  target="__blank">HomeReceptionist</a>
            </nav>
            <hr class="mt-0 mb-4">
            <div class="row">
                <div class="col-xl-4">
                    <!-- Profile picture card-->
                    <div class="card mb-4 mb-xl-0">
                        <div class="card-header">Profile Picture</div>
                        <div class="card-body text-center">
                            <!-- Profile picture image-->
                            <img class="img-account-profile rounded-circle mb-2" src="http://bootdey.com/img/Content/avatar/avatar1.png" alt="">
                            <!-- Profile picture help block-->
                            <!--<div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>-->
                            <!-- Profile picture upload button-->
                            <!--<button class="btn btn-primary" type="button">Cập nhật ảnh.</button>-->
 
                        </div>
                         <a  href="LoginController?do=ChangePassword1"class="btn btn-primary" style="width: 50%;margin-left: 95px" type="button">Thay đổi mật khẩu</a>
                    </div>
                </div>
                <div class="col-xl-8">
                    <!-- Account details card-->
                    <div class="card mb-4">
                        <div class="card-header">Account Details</div>
                        <div class="card-body">
                            <form action="ReceptionistController?do=updateRecept" method="post">
                                <%
                                    User user = (User) session.getAttribute("u");


                                %>
                                <input type="hidden" name="uid" value="<%=user.getUserID()%>">
                                <h4 style="color: red;font-size: 15px;">${requestScope.err}</h4>
                                <h4 style="color: red;font-size: 15px;">${requestScope.errr}</h4>
                                <h4 style="color: red;font-size: 15px;">${requestScope.mess}</h4>

                                <!-- Form Group (username)-->
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputYourname">Your Name</label>
                                    <input class="form-control" id="Username" name="Username" type="text" maxlength="50"  value="<%=user.getUserName()%>">
                                </div>
                                <!-- Form Row-->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (CMT)-->
                                    <div class="small mb-1 form-group">
                                        <label class="small mb-1" for="inputEmailAddress">Email</label>
                                        <i class='bx bxs-star style' style="color:red;"></i> <input class="form-control" id="EmailAddress" name="EmailAddress" required type="email" value="<%=user.getUserEmail()%>" maxlength="100" placeholder="Enter your email address">
                                    </div>

                                </div>
                                <!-- Form Group (email address)-->
                                <div class="row gx-3 mb-3">
                                    <div class="col-md-6 form-group">
                                        <label class="small mb-1" for="inputCMT">CMT</label>
                                        <i class='bx bxs-star style' style="color:red;"></i>   <input class="form-control" id="inputCMT" name="inputCMT" type="text" value="<%=user.getCMT()%>" maxlength="20" required placeholder="Enter your CMT" >
                                    </div>
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputAddress">Location</label>
                                        <input class="form-control" id="inputAddress" name="inputAddress" value="<%=user.getUserAdress()%>" required maxlength="100" type="tel" placeholder="Enter your Address" >
                                    </div>
                                </div>
                                <!-- Form Row-->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (phone number)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputPhone">Phone number</label>
                                        <input class="form-control" id="inputPhone" name="inputPhone" required type="tel" value="<%=user.getUserPhone()%>" maxlength="15" placeholder="Enter your phone number" >
                                    </div>
                                    <!-- Form Group (birthday)-->
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputBirthday">Birthday</label>
                                        <input class="form-control" id="inputBirthday" type="date"  name="birthday"  value="<%=user.getBirthday()%>">
                                    </div>
                                </div>
                                <!-- Save changes button-->
                                <button class="btn btn-primary" type="submit" name="submit" value="submit">Save changes</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
