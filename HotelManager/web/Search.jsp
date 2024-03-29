<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colrolib Templates">
    <meta name="author" content="Colrolib">
    <meta name="keywords" content="Colrolib Templates">

    <!-- Title Page-->
    <title>Au Form Wizard</title>

    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/main.css" rel="stylesheet" media="all">
    
        <link rel="stylesheet" href="fonts/icomoon/style.css">

    <!--<link rel="stylesheet" href="css/bootstrap.min.css">-->
<!--    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/jquery-ui.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/animate.css">-->
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mediaelement@4.2.7/build/mediaelementplayer.min.css">
    
    
    
    <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
  
    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/style.css">
</head>
<style>
    .headerr{
        position: fixed;
        top: 5px;
        right: 80px;
    }
    .hoanghon{
        position: fixed;
        left: 130px;
        top: 9px;
    }
</style>

<body>
    <div class="site-navbar-wrap js-site-navbar bg-white">
      
      <div class="container">
        <div class="site-navbar bg-light">
          <div class="py-1">
            <div class="row align-items-center">
              <div class="col-2">
                <h2 class="mb-0 site-logo hoanghon"><a href="index.html">Hoang Hon</a></h2>
              </div>
              <div class="col-10">
                <nav class="site-navigation text-right" role="navigation">
                  <div class="container">
                    
                    <div class="d-inline-block d-lg-none  ml-md-0 mr-auto py-3"><a href="#" class="site-menu-toggle js-menu-toggle"><span class="icon-menu h3"></span></a></div>
                    <ul class="site-menu js-clone-nav d-none d-lg-block headerr">
                      <li class="active">
                        <a href="index.html">Trang chủ</a>
                      </li>
                      <li class="has-children">
                        <a href="rooms.html">Phòng</a>
                        <ul class="dropdown arrow-top">
                          <li><a href="rooms.html">Hiện có</a></li>
                          <li><a href="rooms.html">Phòng đơn</a></li>
                          <li><a href="rooms.html">Phòng đôi</a></li>
                          <li><a href="rooms.html">Phòng gia đình</a></li> 
                          <li class="has-children">
                            <a href="rooms.html">Dịch vụ</a>
                            <ul class="dropdown">
                              <li><a href="rooms.html">Phòng cao cấp</a></li>
                              <li><a href="rooms.html">Tắm hơi</a></li>
                              <li><a href="rooms.html">Ăn uống</a></li> 
                              
                            </ul>
                          </li>

                        </ul>
                      </li>
                      <li><a href="events.html">Sự kiện</a></li>
                      <li><a href="about.html">Thông tin</a></li>
                      <li><a href="contact.html">Liên hệ</a></li>
                      <li class="login"><a href="Login.jsp">Login</a></li>
                      <li class="register"><a href="Register.jsp">Register</a></li>
                    </ul>
                  </div>
                </nav>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="page-wrapper bg-img-1 p-t-165 p-b-100">
        <div class="wrapper wrapper--w720">
            <div class="card card-3">
                <div class="card-body">
                    <ul class="tab-list">
                        <li class="tab-list__item active">
                            <a class="tab-list__link" href="#tab1" data-toggle="tab">hotels</a>
                        </li>
                        <li class="tab-list__item">
                            <a class="tab-list__link" href="#tab2" data-toggle="tab">car</a>
                        </li>
                        <li class="tab-list__item">
                            <a class="tab-list__link" href="#tab3" data-toggle="tab">flight</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="tab1">
                            <form method="POST" action="#">
                               
                                <div class="row row-space">
                                    <div class="col-2">
                                        <div class="input-group">
                                            <label class="label">check-in</label>
                                            <input class="input--style-1" type="text" name="check-in" placeholder="mm/dd/yyyy" id="input-start">
                                            <i class="zmdi zmdi-calendar-alt input-group-symbol"></i>
                                        </div>
                                    </div>
                                    <div class="col-2">
                                        <div class="input-group">
                                            <label class="label">check-out</label>
                                            <input class="input--style-1" type="text" name="check-out" placeholder="mm/dd/yyyy" id="input-end">
                                            <i class="zmdi zmdi-calendar-alt input-group-symbol"></i>
                                        </div>
                                    </div>
                                </div>
                                <div class="input-group">
                                    <label class="label">travellers</label>
                                    <i class="zmdi zmdi-account-add input-group-symbol"></i>
                                    <div class="input-group-icon" id="js-select-special">
                                        <input class="input--style-1" type="text" name="traveller" value="1 Adult, 0 Children, 1 Room" disabled="disabled" id="info">
                                        <i class="zmdi zmdi-chevron-down input-icon"></i>
                                    </div>
                                    <div class="dropdown-select">
                                        <ul class="list-room">
                                            <li class="list-room__item">
                                                <span class="list-room__name">Room 1</span>
                                                <ul class="list-person">
                                                    <li class="list-person__item">
                                                        <span class="name">Adults</span>
                                                        <div class="quantity quantity1">
                                                            <span class="minus">-</span>
                                                            <input class="inputQty" type="number" min="0" value="1">
                                                            <span class="plus">+</span>
                                                        </div>
                                                    </li>
                                                    <li class="list-person__item">
                                                        <span class="name">Children</span>
                                                        <div class="quantity quantity2">
                                                            <span class="minus">-</span>
                                                            <input class="inputQty" type="number" min="0" value="0">
                                                            <span class="plus">+</span>
                                                        </div>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                        <div class="list-room__footer">
                                            <a href="#" id="btn-add-room">Add room</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="checkbox-row">
                                    <label class="checkbox-container m-r-45">Add a flight
                                        <input type="checkbox" checked="checked" name="add-flight">
                                        <span class="checkmark"></span>
                                    </label>
                                    <label class="checkbox-container">Add a car
                                        <input type="checkbox" name="add-car">
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
                                <button class="btn-submit" type="submit">search</button>
                            </form>
                        </div>
                        <div class="tab-pane" id="tab2">
                            <form method="POST" action="#">
                                <div class="input-group">
                                    <label class="label">location:</label>
                                    <input class="input--style-1" type="text" name="location" placeholder="Destination, hotel name" required="required">
                                    <i class="zmdi zmdi-pin input-group-symbol"></i>
                                </div>
                                <div class="row row-space">
                                    <div class="col-2">
                                        <div class="input-group">
                                            <label class="label">driver age:</label>
                                            <i class="zmdi zmdi-calendar-alt input-group-symbol"></i>
                                            <div class="rs-select2 js-select-simple select--no-search">
                                                <select name="driver-age">
                                                    <option>23</option>
                                                    <option>24</option>
                                                    <option selected="selected">25</option>
                                                    <option>26</option>
                                                </select>
                                                <div class="select-dropdown"></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-2">
                                        <div class="input-group">
                                            <label class="label">car group:</label>
                                            <i class="zmdi zmdi-calendar-alt input-group-symbol"></i>
                                            <div class="rs-select2 js-select-simple select--no-search">
                                                <select name="car-group">
                                                    <option selected="selected">Group S-car</option>
                                                    <option>Group 1</option>
                                                    <option>Group 2</option>
                                                    <option>Group 3</option>
                                                </select>
                                                <div class="select-dropdown"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row row-space">
                                    <div class="col-2">
                                        <div class="input-group">
                                            <label class="label">pick up:</label>
                                            <i class="zmdi zmdi-calendar-alt input-group-symbol"></i>
                                            <input class="input--style-1 js-single-datepicker" type="text" name="pickup" placeholder="mm/dd/yyyy" data-drop="1">
                                            <div class="dropdown-datepicker" id="dropdown-datepicker1"></div>
                                        </div>
                                    </div>
                                    <div class="col-2">
                                        <div class="input-group">
                                            <label class="label">time:</label>
                                            <i class="zmdi zmdi-time input-group-symbol"></i>
                                            <div class="rs-select2 js-select-simple select--no-search">
                                                <select name="time-pickup">
                                                    <option selected="selected">10:00 AM</option>
                                                    <option>5:00 AM</option>
                                                    <option>6:00 AM</option>
                                                    <option>7:00 AM</option>
                                                </select>
                                                <div class="select-dropdown"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row row-space">
                                    <div class="col-2">
                                        <div class="input-group">
                                            <label class="label">drop off:</label>
                                            <i class="zmdi zmdi-calendar-alt input-group-symbol"></i>
                                            <input class="input--style-1 js-single-datepicker" type="text" name="dropoff" placeholder="mm/dd/yyyy" data-drop="2">
                                            <div class="dropdown-datepicker" id="dropdown-datepicker2"></div>
                                        </div>
                                    </div>
                                    <div class="col-2">
                                        <div class="input-group">
                                            <label class="label">time:</label>
                                            <i class="zmdi zmdi-time input-group-symbol"></i>
                                            <div class="rs-select2 js-select-simple select--no-search">
                                                <select name="time-dropoff">
                                                    <option selected="selected">10:00 AM</option>
                                                    <option>5:00 AM</option>
                                                    <option>6:00 AM</option>
                                                    <option>7:00 AM</option>
                                                </select>
                                                <div class="select-dropdown"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <button class="btn-submit m-t-15" type="submit">search</button>
                            </form>
                        </div>
                        <div class="tab-pane" id="tab3">
                            <form method="POST" action="#">
                                <div class="input-group">
                                    <label class="label">origin</label>
                                    <i class="zmdi zmdi-pin input-group-symbol"></i>
                                    <input class="input--style-1" type="text" name="origin" placeholder="City or airport" required="required">
                                </div>
                                <div class="input-group">
                                    <label class="label">destination:</label>
                                    <i class="zmdi zmdi-pin input-group-symbol"></i>
                                    <input class="input--style-1" type="text" name="destination" placeholder="City or airport" required="required">
                                </div>
                                <div class="row row-space">
                                    <div class="col-2">
                                        <div class="input-group">
                                            <label class="label">Departing</label>
                                            <i class="zmdi zmdi-calendar-alt input-group-symbol"></i>
                                            <input class="input--style-1" type="text" name="check-in" placeholder="mm/dd/yyyy" id="input-start-2">
                                        </div>
                                    </div>
                                    <div class="col-2">
                                        <div class="input-group">
                                            <label class="label">returning</label>
                                            <i class="zmdi zmdi-calendar-alt input-group-symbol"></i>
                                            <input class="input--style-1" type="text" name="check-out" placeholder="mm/dd/yyyy" id="input-end-2">
                                        </div>
                                    </div>
                                </div>
                                <div class="radio-row">
                                    <label class="radio-container m-r-45">First Class
                                        <input type="radio" name="class">
                                        <span class="radio-checkmark"></span>
                                    </label>
                                    <label class="radio-container m-r-45">Business
                                        <input type="radio" name="class">
                                        <span class="radio-checkmark"></span>
                                    </label>
                                    <label class="radio-container">Economy
                                        <input type="radio" checked="checked" name="class">
                                        <span class="radio-checkmark"></span>
                                    </label>
                                </div>
                                <button class="btn-submit" type="submit">search</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/jquery-validate/jquery.validate.min.js"></script>
    <script src="vendor/bootstrap-wizard/bootstrap.min.js"></script>
    <script src="vendor/bootstrap-wizard/jquery.bootstrap.wizard.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/global.js"></script>

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->