<%-- 
    Document   : BillHotel
    Created on : Jun 11, 2022, 12:05:17 AM
    Author     : Trong Hieu
--%>

<%@page import="entity.Reservation"%>
<%@page import="java.util.Vector"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/hotelbill.css">
        <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>JSP Page</title>
        <style>
            body {
                font-family: Arial;
                font-size: 17px;
                padding: 8px;
                /*                    background-color: #f2f3f3;*/
            }

            * {
                box-sizing: border-box;
            }

            .row {
                display: -ms-flexbox; /* IE10 */
                display: flex;
                -ms-flex-wrap: wrap; /* IE10 */
                flex-wrap: wrap;
                margin: 0 -16px;
            }

            .col-25 {
                -ms-flex: 25%; /* IE10 */
                flex: 25%;
            }

            .col-50 {
                -ms-flex: 50%; /* IE10 */
                flex: 50%;
            }

            .col-75 {
                -ms-flex: 75%; /* IE10 */
                flex: 75%;
            }

            .col-25,
            .col-50,
            .col-75 {
                padding: 0 16px;
            }

            .container {
                background-color: #f2f2f2;
                padding: 5px 20px 15px 20px;
                border: 1px solid lightgrey;
                border-radius: 3px;
            }

            input[type=text] {
                width: 100%;
                margin-bottom: 20px;
                padding: 12px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }

            label {
                margin-bottom: 10px;
                display: block;
            }

            .icon-container {
                margin-bottom: 20px;
                padding: 7px 0;
                font-size: 24px;
            }

            .btn {
                background-color: #04AA6D;
                color: white;
                padding: 12px;
                margin: 10px 0;
                border: none;
                width: 100%;
                border-radius: 3px;
                cursor: pointer;
                font-size: 17px;
            }

            .btn:hover {
                background-color: #45a049;
            }

            a {
                color: #2196F3;
            }

            hr {
                border: 1px solid lightgrey;
            }

            span.price {
                float: right;
                color: grey;
            }

            /* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
            @media (max-width: 800px) {
                .row {
                    flex-direction: column-reverse;
                }
                .col-25 {
                    margin-bottom: 20px;
                }
            }
        </style>
    </head>
    <body>

        <h2>Đặt phòng khách sạn</h2>
        <p>Điền thông tin người liên lạc và khách bên dưới</p>
        <div class="row">
            <div class="col-75">
                <div class="container">
                    <form action="action_page.jsp">
                        <div class="row">
                            <div class="col-50">
                                <% Vector<Reservation> vector = (Vector<Reservation>) request.getAttribute("vector1");
                                    for (Reservation r : vector) {

                                %>
                                <h3>Billing Address</h3>
                                <label for="fname"><i class="fa fa-user"></i> Full Name</label>
                                <p><%=r.getName()%></p>
                                <label for="email"><i class="fa fa-envelope"></i> Email</label>
                                <p><%=r.getEmail()%></p>
                                <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
                                <p><%=r.getAddress()%></p>
                                <label for="city"><i class="fa fa-institution"></i> Phone</label>
                                <p><%=r.getPhone()%></p>

                                <div class="row">
                                    <div class="col-100">
                                        <label style="display: inline-block; padding-top: 30px;font-size: 20px;" for="state">Adults</label>
                                        <p><%=r.getNumberOfPerson()%></p>
                                    </div>
                                </div>
                            </div>

                            <div class="col-50">
                                <h3>Payment</h3>
                                <label for="fname">Accepted Cards</label>
                                <div class="icon-container">
                                    <i class="fa fa-cc-visa" style="color:navy;"></i>
                                    <i class="fa fa-cc-amex" style="color:blue;"></i>
                                    <i class="fa fa-cc-mastercard" style="color:red;"></i>
                                    <i class="fa fa-cc-discover" style="color:orange;"></i>
                                </div>
                                <label for="cname">Dịch vụ</label>
                                <label style="display:inline-block;"for="vehicle1"></label><br>
                                <p>Casino</p>
                                <label style="padding-top: 30px;"for="ccnum">Check in</label>
                                <p><%=r.getCheckin()%></p>
                                <label for="expmonth" style="padding-top: 10px">Check out</label>
                                <p><%=r.getCheckout() %></p>
                            </div>

                        </div>
                        <label>
                            <input type="checkbox" checked="checked" name="sameadr"> Do you read every Rules
                        </label>
                        <input type="submit" value="Continue to checkout" class="btn">
                    </form>
                </div>
            </div>
            <div class="col-25">
                <div style="padding-bottom: 20px;" class="container1">
                    <div>
                        <h4 style="margin-left: 20px; font-size: 30px;; font-weight: bold; color: red"><label class="price" style="color:black"><i class='fas fa-hotel'></i></s</label> Hoang Hon </h4>                       
                    </div>
                    <div style="background-color: #f7f9fa; height: 150px;padding-top: 10px;" class="nhanphong">
                        <p style="margin-left: 20px;"> Ngày nhận phòng: Sun, 12 Jun 2022, Từ 11:00 <p>                         
                        <p style="margin-left: 20px;"> Ngày trả phòng:  Mon, 13 Jun 2022, Trước 13:00</p>            
                    </div>
                    <div>
                        <p style="font-size: 20px; font-weight: bold"> </p>
                        <p style="color: #0b9af4; font-size: 20px">Thanh toán khi nhận phòng</p>
                        <p><span style="padding-left: 100px;"></span> </p>
                        <p><span style="padding-left: 100px;"></span> </p>
                    </div>
                    <div class="row">
                        <div class="col-md-5">
                            <img style="width: 80px;height: 80px; margin-left: 20px;"src="images/anhphong/" alt="">
                        </div>
                        <div class="col-md-7">
                            <i style="padding-left: 90px;color: green"class='fas fa-utensils'> Miễn phí bữa ăn sáng </i>
                            <i style="padding-left: 90px;color: green"class='fas fa-utensils'> Miễn phí wifi </i>
                        </div>
                    </div>
                    <hr>
                    <p style="color: green;">Miễn phí huỷ phòng đến trước 11 thg 6 2022 </p>

                </div>
                <div class="container">
                    <h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b>4</b></span></h4>
                    <p><a href="#"></a> <span class="price"></span></p>
                    <hr>
                    <p>Total <span class="price" style="color:black"><b>$30</b></span></p>
                </div>
            </div>
        </div>
        <%}%>
    </body>
</html>

