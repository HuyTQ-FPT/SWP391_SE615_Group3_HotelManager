<%-- 
    Document   : indexadmin
    Created on : Jun 8, 2022, 11:36:23 PM
    Author     : NTD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title> Admin - Dashboard</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
        <!-- https://fonts.google.com/specimen/Roboto -->
        <link rel="stylesheet" href="css/fontawesome.min.css">
        <!-- https://fontawesome.com/ -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- https://getbootstrap.com/ -->
        <link rel="stylesheet" href="css/templatemo-style.css">
        <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
        <!--
            Product Admin CSS Template
            https://templatemo.com/tm-524-product-admin
        -->
    </head>
    
    <body id="reportsPage">
        <div class="" id="home">
            <%@include file="headerAdmin.jsp" %>
            <div class="container" >
                <div class="row col-md-14 grid-margin ">
                    <div class="col-sm-12 col-md-12  tm-block-col">
                        <div class="tm-bg-primary-dark tm-block ">
                            <div class="row ">
                                <div class="col-md-3 ">
                                    <div class="card card-tale  media tm-notification-item">
                                        <div class="card-body">
                                            <p class="mb-4 tm-block-title">Phòng: <b class="tm-notification-link ">${vectorRoom.size()}</b> </p>


                                        </div>
                                    </div>
                                </div>  
                                <div class="col-md-3 ">
                                    <div class="card card-tale  media tm-notification-item">
                                        <div class="card-body">
                                            <p class="mb-4 tm-block-title"> Khách hàng: <b class="tm-notification-link ">${vectorUser.size()}</b> </p>


                                        </div>
                                    </div>
                                </div>  
                                <div class="col-md-3 ">
                                    <div class="card card-tale  media tm-notification-item">
                                        <div class="card-body">
                                            <p class="mb-4 tm-block-title">Nhân viên: <b class="tm-notification-link ">${vectorReceptionis.size()} </b></p>


                                        </div>
                                    </div>
                                </div>   
                                <div class="col-md-3 ">
                                    <div class="card card-tale  media tm-notification-item">
                                        <div class="card-body">
                                            <p class="mb-4 tm-block-title">Đánh giá: <b class="tm-notification-link ">${vectorMessage.size()}</b> </p>


                                        </div>
                                    </div>
                                </div>  
                                <div class="col-md-3 ">
                                    <div class="card card-tale  media tm-notification-item">
                                        <div class="card-body">
                                            <p class="mb-4 tm-block-title">Yêu cầu: <b class="tm-notification-link ">${vectorRequest.size()}</b> </p>


                                        </div>
                                    </div>
                                </div>  
                                <div class="col-md-3 ">
                                    <div class="card card-tale  media tm-notification-item">
                                        <div class="card-body">
                                            <p class="mb-4 tm-block-title">Tiền: <b class="tm-notification-link ">${sumReservation} VND</b> </p>


                                        </div>
                                    </div>
                                </div>  



                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="container" >
            <div class="row tm-content-row">
                <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block">
                        <h2 class="tm-block-title">Thống kê loại phòng</h2>
                        <canvas id="myOk"></canvas>
                    </div>
                </div>
                <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block">
                        <h2 class="tm-block-title">Thống kê phòng</h2>
                        <canvas id="RoomChart"></canvas>
                    </div>
                </div>
                <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
<<<<<<< Updated upstream
                    <div class="tm-bg-primary-dark tm-block">
                        <h2 class="tm-block-title">Thống kê thiết bị</h2>
                        <canvas id="barChart"></canvas>
=======
                    <div class="tm-bg-primary-dark tm-block tm-block-taller">
                        <h2 class="tm-block-title">Storage Information</h2>
                        <div id="pieChartContainer">
                            <canvas id="pieChart" class="chartjs-render-monitor" width="200" height="200"></canvas>
                        </div>                        
                    </div>
                </div>
                
                <!--notification-->
                <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-taller tm-block-overflow">
                        <h2 class="tm-block-title">Notification List</h2>
                        <div class="tm-notification-items">                           
                            <div class="media tm-notification-item notifather">
                                <div class="tm-gray-circle"><img src="images/notification-03.jpg" alt="Avatar Image" class="rounded-circle"></div>
                                <div class="media-body">
                                    <p class="mb-2"><b>Cinthela</b> and <b>6 others</b> sent you 
                                        <a href="#" class="tm-notification-link">product updates</a>.</p>
                                    <span class="tm-small tm-text-color-secondary">6h ago.</span>
                                    <a href="#"><i class='bx bxs-message-square-x notifi' style="color:window"></i></a>
                                </div>
                            </div>                   
                        </div>
>>>>>>> Stashed changes
                    </div>
                </div>
                <!--                <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
                                    <div class="tm-bg-primary-dark tm-block tm-block-taller tm-block-overflow">
                                        <h2 class="tm-block-title">Notification List</h2>
                                        <div class="tm-notification-items">
                                            <div class="media tm-notification-item">
                                                <div class="tm-gray-circle"><img src="images/notification-01.jpg" alt="Avatar Image" class="rounded-circle"></div>
                                                <div class="media-body">
                                                    <p class="mb-2"><b>Jessica</b> and <b>6 others</b> sent you new <a href="#"
                                                                                                                       class="tm-notification-link">product updates</a>. Check new orders.</p>
                                                    <span class="tm-small tm-text-color-secondary">6h ago.</span>
                                                </div>
                                            </div>
                                            <div class="media tm-notification-item">
                                                <div class="tm-gray-circle"><img src="images/notification-02.jpg" alt="Avatar Image" class="rounded-circle"></div>
                                                <div class="media-body">
                                                    <p class="mb-2"><b>Oliver Too</b> and <b>6 others</b> sent you existing <a href="#"
                                                                                                                               class="tm-notification-link">product updates</a>. Read more reports.</p>
                                                    <span class="tm-small tm-text-color-secondary">6h ago.</span>
                                                </div>
                                            </div>
                                            <div class="media tm-notification-item">
                                                <div class="tm-gray-circle"><img src="images/notification-03.jpg" alt="Avatar Image" class="rounded-circle"></div>
                                                <div class="media-body">
                                                    <p class="mb-2"><b>Victoria</b> and <b>6 others</b> sent you <a href="#"
                                                                                                                    class="tm-notification-link">order updates</a>. Read order information.</p>
                                                    <span class="tm-small tm-text-color-secondary">6h ago.</span>
                                                </div>
                                            </div>
                                            <div class="media tm-notification-item">
                                                <div class="tm-gray-circle"><img src="images/notification-01.jpg" alt="Avatar Image" class="rounded-circle"></div>
                                                <div class="media-body">
                                                    <p class="mb-2"><b>Laura Cute</b> and <b>6 others</b> sent you <a href="#"
                                                                                                                      class="tm-notification-link">product records</a>.</p>
                                                    <span class="tm-small tm-text-color-secondary">6h ago.</span>
                                                </div>
                                            </div>
                                            <div class="media tm-notification-item">
                                                <div class="tm-gray-circle"><img src="images/notification-02.jpg" alt="Avatar Image" class="rounded-circle"></div>
                                                <div class="media-body">
                                                    <p class="mb-2"><b>Samantha</b> and <b>6 others</b> sent you <a href="#"
                                                                                                                    class="tm-notification-link">order stuffs</a>.</p>
                                                    <span class="tm-small tm-text-color-secondary">6h ago.</span>
                                                </div>
                                            </div>
                                            <div class="media tm-notification-item">
                                                <div class="tm-gray-circle"><img src="images/notification-03.jpg" alt="Avatar Image" class="rounded-circle"></div>
                                                <div class="media-body">
                                                    <p class="mb-2"><b>Sophie</b> and <b>6 others</b> sent you <a href="#"
                                                                                                                  class="tm-notification-link">product updates</a>.</p>
                                                    <span class="tm-small tm-text-color-secondary">6h ago.</span>
                                                </div>
                                            </div>
                                            <div class="media tm-notification-item">
                                                <div class="tm-gray-circle"><img src="images/notification-01.jpg" alt="Avatar Image" class="rounded-circle"></div>
                                                <div class="media-body">
                                                    <p class="mb-2"><b>Lily A</b> and <b>6 others</b> sent you <a href="#"
                                                                                                                  class="tm-notification-link">product updates</a>.</p>
                                                    <span class="tm-small tm-text-color-secondary">6h ago.</span>
                                                </div>
                                            </div>
                                            <div class="media tm-notification-item">
                                                <div class="tm-gray-circle"><img src="images/notification-02.jpg" alt="Avatar Image" class="rounded-circle"></div>
                                                <div class="media-body">
                                                    <p class="mb-2"><b>Amara</b> and <b>6 others</b> sent you <a href="#"
                                                                                                                 class="tm-notification-link">product updates</a>.</p>
                                                    <span class="tm-small tm-text-color-secondary">6h ago.</span>
                                                </div>
                                            </div>
                                            <div class="media tm-notification-item">
                                                <div class="tm-gray-circle"><img src="images/notification-03.jpg" alt="Avatar Image" class="rounded-circle"></div>
                                                <div class="media-body">
                                                    <p class="mb-2"><b>Cinthela</b> and <b>6 others</b> sent you <a href="#"
                                                                                                                    class="tm-notification-link">product updates</a>.</p>
                                                    <span class="tm-small tm-text-color-secondary">6h ago.</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>-->




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
    <script src="https://code.iconify.design/2/2.2.1/iconify.min.js"></script>
    <script>

        let cateName = [], cateCOunt = []
        <c:forEach items="${vectorR}" var="v">

        cateName.push('${v.catename}')
        cateCOunt.push(${v.count})


        </c:forEach>
        window.onload = function () {
            cateChart("myOk", cateName, cateCOunt, );
        }
        function cateChart(id, cateName, cateCOunt) {
              let color1 = []
            const data = {
                labels: cateName,
                datasets: [{
                        label: 'My First Dataset',
                        data: cateCOunt,
                        backgroundColor: [
                            'rgb(255, 99, 132)',
                            'rgb(54, 162, 235)',
                            'rgb(255, 205, 86)',
                            'rgb(201, 203, 207)',
                            'rgb(60, 100, 25)'
                        ],
                        hoverOffset: 4
                    }]
            };
            const config = {
                type: 'doughnut',
                data: data,
            };
            let c = document.getElementById(id).getContext("2d")
            new Chart(c, config)
        }



    </script>

    <script>
        let status = [], nameStatus = [], device = [], nameDevice = []
        <c:forEach items="${vectorStatus}" var="sr">

        if (${sr.status} == 0) {
            status.push('Phòng trống')

            nameStatus.push(${sr.sumstatus})
        } else {
            status.push('Phòng đã thuê')

            nameStatus.push(${sr.sumstatus})
        }



        </c:forEach>
        <c:forEach items="${vectorDevice}" var="vd">


        device.push(${vd.quantity})

        nameDevice.push('${vd.deviceName}')




        </c:forEach>
        Chart.defaults.global.defaultFontColor = 'white';
        let ctxLine,
                ctxBar,
                ctxPie,
                optionsLine,
                optionsBar,
                optionsPie,
                configLine,
                configBar,
                configPie,
                RoomChart,
                DeviceChart,
                Hieu,
                barChart,
                lineChart;
//            barChart, pieChart;
        // DOM is ready
        $(function () {
            RoomChart1(status, nameStatus); // Line Chart
            drawBarChart(device, nameDevice); // Bar Chart
//            drawPieChart(); // Pie Chart
           
            $(window).resize(function () {
                updateLineChart();
                updateBarChart();
            });
        })
    </script>
   
</body>
</html>
