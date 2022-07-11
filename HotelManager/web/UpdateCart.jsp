<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Cập nhật hóa đơn</title>
        <link
            rel="stylesheet"
            href="https://fonts.googleapis.com/css?family=Roboto:400,700"
            />
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="css/fontawesome.min.css" />
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="jquery-ui-datepicker/jquery-ui.min.css" type="text/css" />
        <!-- http://api.jqueryui.com/datepicker/ -->
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="css/templatemo-style.css">
        <!--
            Product Admin CSS Template
            https://templatemo.com/tm-524-product-admin
        -->
        <script type="text/javascript">
            function Delete() {
                alert("Update success");
            }
        </script>
    </head>

    <body>
        <%@include file="headerAdmin.jsp" %>
        <div class="container tm-mt-big tm-mb-big">
            <div class="row">
                <div class="col-xl-9 col-lg-10 col-md-12 col-sm-12 mx-auto">
                    <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
                        <div class="row">
                            <div class="col-12">
                                <h2 class="tm-block-title d-inline-block" style="color: yellowgreen;font-size: 30px">Cập nhật hóa đơn</h2>             
                            </div>
                        </div>
                        <div class="row tm-edit-product-row">
                            <div class="col-xl-6 col-lg-6 col-md-12">
                                <% ResultSet rs = (ResultSet) request.getAttribute("rs");
                                    if (rs.next()) {
                                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                        Date date1 = (Date) format.parse(rs.getString(8));
                                        Date date2 = (Date) format.parse(rs.getString(8));
                                        Date date3 = (Date) format.parse(rs.getString(12));
                                        java.sql.Date cDate = new java.sql.Date(date1.getTime());
                                        java.sql.Date sDate = new java.sql.Date(date2.getTime());
                                        java.sql.Date dDate = new java.sql.Date(date3.getTime());
                                %>
                                <form action="OrderController" method="get"  >
                                    <input type="hidden" name="do" value="UpdateCartAdmin">
                                    <input type="hidden" name="cid" value="<%=rs.getInt(15)%>">
                                    <input type="hidden" name="ID" value="<%=rs.getString(13) %>">
                                    <input type="hidden" name="BID" value="<%=rs.getInt(14) %>">
                                    <div class="form-group mb-3">
                                        <label for="name">Tên phòng </label>
                                        <input name="rname" value="<%=rs.getString(1)%>"type="text"class="form-control validate"required />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="name" style="padding-right: 10px">Hình ảnh </label>
                                        <img style="width: 150px; height: 100px" src="images/anhphong/<%=rs.getString(2)%>" class="img-thumbnail">
                                    </div>

                                    <div class="form-group mb-3">
                                        <label for="name">Tên khách hàng </label>
                                        <input name="cname" value="<%=rs.getString(3)%>"type="text"class="form-control validate"required />
                                    </div>

                                    <div class="form-group mb-3">
                                        <label for="name">Email </label>
                                        <input name="email" value="<%=rs.getString(4)%>"type="text"class="form-control validate"required />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="name">Địa chỉ </label>
                                        <input name="address" value="<%=rs.getString(5)%>"type="text"class="form-control validate"required />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="name">Số điện thoại </label>
                                        <input name="phone" value="<%=rs.getString(6)%>"type="text"class="form-control validate"required />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="name">Số người đến </label>
                                        <input name="number" value="<%=rs.getInt(7)%>"type="text"class="form-control validate"required />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="name">Ngày đến </label>
                                        <input name="cin" value="<%=cDate %>" type="date"class="form-control validate"required />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="name">Ngày đi </label>
                                        <input name="cout" value="<%=sDate %>"type="date"class="form-control validate"required />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="name">Tổng giá </label>
                                        <input name="total" value="<%=rs.getString(10)%>"type="text"class="form-control validate"required />
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="name" style="padding-right: 10px">Trạng thái </label>
                                        <select name="status" style="font-size: 18px; ">
                                            <option value="1" <%=rs.getInt(11) == 1 ? "selected" : ""%>>Đang xử lí</option>
                                            <option value="2" <%=rs.getInt(11) == 2 ? "selected" : ""%>>Hoàn thành</option>
                                        </select>
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="date">Ngày đặt hóa đơn </label>
                                        <input name="date" value="<%=dDate %>"type="text"class="form-control validate"required />
                                    </div>

                            </div>
                            <div class="col-12">
                                <!--                            <input type="hidden" value="updatebloggg" name="do">
                                                            <input type="hidden" value="" name="BlogID">-->
                                <button type="submit" class="btn btn-primary btn-block text-uppercase" onclick="Delete()">Update</button>
                            </div>
                            </form>
                            <%}%>
                        </div>
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
        <script src="jquery-ui-datepicker/jquery-ui.min.js"></script>
        <!-- https://jqueryui.com/download/ -->
        <script src="js/bootstrap.min.js"></script>
        <!-- https://getbootstrap.com/ -->
        <script>
                                    $(function () {
                                        $("#expire_date").datepicker();
                                    });
        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <script>
                                    function chooseFile(fileInput) {
                                        if (fileInput.files && fileInput.files[0]) {
                                            var reader = new FileReader();
                                            reader.onload = function (e) {
                                                $('#image').attr('src', e.target.result);
                                            }
                                            reader.readAsDataURL(fileInput.files[0]);
                                        }
                                    }
        </script>

    </body>
</html>
