<%-- 
    Document   : BillHotel
    Created on : Jun 11, 2022, 12:05:17 AM
    Author     : Thai Quan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/hotelbill.css">
        <title>JSP Page</title>
    </head>
    <body>
        <!DOCTYPE html>
    <html>
        <head>
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel="stylesheet" href="css/fontawesome.min.css" />
            <!-- https://fontawesome.com/ -->

            <!-- https://getbootstrap.com/ -->

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

            <h2>Responsive Checkout Form</h2>
            <p>Resize the browser window to see the effect. When the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other.</p>
            <div class="row">
                <div class="col-75">
                    <div class="container">
                        <form action="/action_page.php">

                            <div class="row">
                                <div class="col-50">
                                    <h3>Billing Address</h3>
                                    <label for="fname"><i class="fa fa-user"></i> Full Name</label>
                                    <input type="text" id="fname" name="firstname" placeholder="John M. Doe">
                                    <label for="email"><i class="fa fa-envelope"></i> Email</label>
                                    <input type="text" id="email" name="email" placeholder="john@example.com">
                                    <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
                                    <input type="text" id="adr" name="address" placeholder="542 W. 15th Street">
                                    <label for="city"><i class="fa fa-institution"></i> Phone</label>
                                    <input type="text" id="city" name="city" placeholder="+84">

                                    <div class="row">
                                        <div class="col-50">
                                            <label style="display: inline-block; padding-top: 30px;font-size: 20px;" for="state">Adults</label>
                                            <select style="font-size: 20px;width: 180px;">
                                                <option value> -Select -</option>
                                                <option value="1"> 1 </option>
                                                <option value="1"> 2 </option>
                                                <option value="1"> 3 </option>
                                                <option value="1"> 4 </option>
                                            </select>
                                        </div>
                                        <div class="col-50">
                                            <label style="display: inline-block; padding-top: 30px;font-size: 18px;margin-left: 0px;" for="state">Children</label>
                                            <select style="font-size: 20px;width: 170px;">
                                                <option value> -Select -</option>
                                                <option value="1"> 1 </option>
                                                <option value="1"> 2 </option>
                                                <option value="1"> 3 </option>
                                                <option value="1"> 4 </option>
                                            </select>
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
                                    <label for="cname">Yêu cầu đặc biệt</label>
                                    <input  type="checkbox" name="vehicle1" value="Bike">
                                    <label style="display:inline-block;"for="vehicle1"> Phòng không hút thuốc</label><br>
                                    <input type="checkbox" name="vehicle2" value="Car">
                                    <label style="display:inline-block;" for="vehicle2"> Tầng lầu</label><br>
                                    <input type="checkbox" name="vehicle3" value="Boat" checked>
                                    <label style="display:inline-block;" for="vehicle3"> Loại phòng</label><br><br>
                                    <label style="padding-top: 30px;"for="ccnum">Check in</label>
                                    <input name="check-in" type="text"  class="form-control" id="inputCheckIn" placeholder="Check In">
                                    <label for="expmonth">Check out</label>
                                    <input name="check-out" type="text" class="form-control" id="inputCheckOut" placeholder="Check Out">

                                </div>

                            </div>
                            <label>
                                <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
                            </label>
                            <input type="submit" value="Continue to checkout" class="btn">
                        </form>
                    </div>
                </div>
                <div class="col-25">
                    <div style="padding-bottom: 30px;" class="container1">
                        <div>
                            <h4 style="margin-left: 20px;"><label class="price" style="color:black"><i class='fas fa-hotel'></i></s</label> Hoang Hon </h4>                       
                        </div>
                        <div style="background-color: #f7f9fa; height: 150px;padding-top: 10px;" class="nhanphong">
                            <p style="margin-left: 20px;"> Ngày nhận phòng: Sun, 12 Jun 2022, Từ 14:00 <p>                         
                            <p style="margin-left: 20px;"> Ngày trả phòng:  Mon, 13 Jun 2022, Trước 12:00</p>            
                        </div>
                        <div>
                            <p>(1x) Superior Twin Room  </p>
                            <p style="color: #0b9af4;">   (Thanh toán khi nhận phòng)</p>
                            <p>khách/phòng <span style="padding-left: 100px;">2 khách </span> </p>
                            <p>Kiểu giường <span style="padding-left: 100px;">2 giường đơn</span> </p>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                            <img style="width: 80px;height: 80px; margin-left: 20px;"src="https://bootdey.com/img/Content/avatar/avatar3.png" alt="">
                            </div>
                             <div class="col-md-6">
                                 <i style="padding-left: 90px;color: green"class='fas fa-utensils'> Miễn phí bữa ăn sáng</i>
                                 
                            </div>
                        </div>
                        <hr>
                        <p style="color: green;">Miễn phí huỷ phòng đến trước 11 thg 6 2022 </p>

                    </div>
                    <div class="container">
                        <h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b>4</b></span></h4>
                        <p><a href="#">Product 1</a> <span class="price">$15</span></p>
                        <p><a href="#">Product 2</a> <span class="price">$5</span></p>
                        <p><a href="#">Product 3</a> <span class="price">$8</span></p>
                        <p><a href="#">Product 4</a> <span class="price">$2</span></p>
                        <hr>
                        <p>Total <span class="price" style="color:black"><b>$30</b></span></p>
                    </div>
                </div>
            </div>

        </body>
    </html>

</body>
</html>
