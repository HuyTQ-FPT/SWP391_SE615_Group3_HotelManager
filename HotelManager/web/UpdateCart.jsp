
<%@page import="java.sql.ResultSet"%>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet" 
href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
<script type="text/javascript" 
src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" 
src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
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
    </head>

    <body id="reportsPage">
        <jsp:include page="headerAdmin.jsp"></jsp:include>
            <section id="topic-header">
                <div class="container">
                    <div class="row">
                        <div class="col-md-4">
                            <h1 style="color: yellow">Cập nhật hóa đơn</h1>
                            <p></p>
                        </div>
                        <!-- End of /.col-md-4 -->
                        <!-- End of /.col-md-8 -->
                    </div>
                    <!-- End of /.row -->
                </div>
                <!-- End of /.container -->
            </section>
            <!-- End of /#Topic-header -->

            <!--================================================== -->

            <!-- cart -->
            <div class="cart-section mt-150 mb-150">
                <div class="container">
                    <div class="row">
                        <div> <!--class="col-lg-12 col-md-12"-->
                            <div class="cart-table-wrap" >
                            <% ResultSet rs= (ResultSet)request.getAttribute("rs");
                            while(rs.next()){
                            %>
                            <form action="ControllerAdmin" method="get" style="padding-bottom: 100px; padding-top: 50px;padding-left: 80px;font-size: 30px" >
                                <input type="hidden" name="do" value="updateO">
                                <table class="table">                                    
                                    <tr>
                                        <th style="padding-top: 16px;">Tên</th>
                                        <td>
                                            <input value="" type="text" name="id" readonly>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="padding-top: 16px;">Hình ảnh</th>
                                        <td>
                                            <input value="" type="text" name="cid" readonly>
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="padding-top: 16px;">Tên khách hàng</th>
                                        <td>
                                            <input value="" type="text" name="cname" >
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="padding-top: 16px;">Email</th>
                                        <td>
                                            <input value="" type="text" name="phone">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="padding-top: 16px;">Địa chỉ</th>
                                        <td>
                                            <input value="" type="text" name="gmail">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="padding-top: 16px;">Số điện thoại</th>
                                        <td>
                                            <input value="" type="text" name="add">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="padding-top: 16px;">Số người đến</th>
                                        <td>
                                            <input value="" type="text" name="total">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="padding-top: 16px;">Ngày đến</th>
                                        <td>
                                            <input value="" type="text" name="total">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="padding-top: 16px;">Ngày đi</th>
                                        <td>
                                            <input value="" type="text" name="total">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="padding-top: 16px;">Tổng giá</th>
                                        <td>
                                            <input value="" type="text" name="total">
                                        </td>
                                    </tr>
                                    <tr>
                                        <th style="padding-top: 16px;">Trạng thái</th>
                                    <td style="padding-top: 12px;"> 
                                    <select name="status" style="font-size: 18px;">
                                        <option value="1" >New</option>
                                        <option value="2">Process</option>
                                        <option value="3">Done</option>
                                    </select>
                                     </td>
                                    </tr>
                                    <tr>
                                        <th style="padding-top: 16px;">Ngày đặt hóa đơn</th>
                                        <td>
                                            <input value="" type="text" name="total">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td style="padding-left: 400px; color: red">
                                            <button type="submit" onclick="showMess()">Update</button>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                            <%}%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end cart -->
        <script>
            function showMess() {
                window.alert("Update successfully!!");
            }
        </script>
        <!-- FOOTER Start
        ================================================== -->
    </body>
</html>

