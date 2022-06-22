<%-- 
    Document   : viewFeedBack
    Created on : Jun 15, 2022, 9:53:41 AM
    Author     : MInh Hiếu
--%>

<%@page import="entity.sendFeedback"%>
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
        <%@include file="headerAdmin.jsp" %>
        <%
            sendFeedback s = (sendFeedback) request.getAttribute("seen");
        %>
        <div class="container">
            <div class="row">
                <div class="col">
                    <p class="text-white mt-5 mb-5"></p>
                </div>
            </div>
            <div class="row tm-content-row">
        



                <div class="col-12 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-taller tm-block-scroll">
                        <h2 class="tm-block-title">Danh sách yêu cầu</h2>


                        <table class="table">

                            <thead>
                                <tr>
                                    <th scope="col">STT</th>
                                    <th scope="col"> Email</th>
                                    <th scope="col">Tiêu đề</th>
                                    <th  scope="col">Nội dung</th>


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
                         <script src="js/jquery-3.3.1.min.js"></script>
        <!-- https://jquery.com/download/ -->
        <script src="js/moment.min.js"></script>
        <!-- https://momentjs.com/ -->
        <script src="js/Chart.min.js"></script>
        <!-- http://www.chartjs.org/docs/latest/ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <script src="js/tooplate-scripts.js"></script>
        <script>
            function deleteId(id) {
                if (confirm("Bạn có muốn xoá yêu cầu này không?")) {
                    window.location = "SendFeedbackController?do=deleteMessage&mId=" + id;
                }

            }

        </script>
    </body>
</html>
