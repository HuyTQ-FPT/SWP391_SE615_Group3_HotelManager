<%-- 
    Document   : reportMonth
    Created on : Jul 8, 2022, 9:57:51 PM
    Author     : Minh Hieu
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
        <!--
            Product Admin CSS Template
            https://templatemo.com/tm-524-product-admin
        
        -->
    </head>
    <body id="reportsPage">
        <div class="" id="home">
            <%@include file="headerAdmin.jsp" %>

        </div>
        <h4 style="font-size: 20px ; color: red">${errr}</h4>
        <form action="AdminController?do=ReportMonth1" method="post" >
            <div class="form-group col-lg-6">
                <label>Tìm kiếm tháng....</label>
                <input style="background-color: white; color: #54657D;" type="text" name="name" pattern="[0-9]+" maxlength="2" title="Không được nhập số âm và chữ"  class="form-control" value="${name}">
                <select name="year" style="order-radius:8px"  >
                    <option value="0"  >---------</option>
                    <c:forEach items="${vectorReservationAllYear}" var="vY">
                        <option value="${vY.year}">${vY.year}</option>
                    </c:forEach>
                </select>  
            </div> 

            <input type="submit"  value="Báo cáo" class="btn btn-success">
        </form>
        <c:if test="${!empty vectorReservationTotalOfMotnh}">
            <c:if test="${year!=0 && year!=null}">

                <div style="position: relative">
                    <div class="col-sm-12 col-md-12 col-lg-6 col-xl-10 tm-block-col ok" style="   position: absolute;
                         top:-180px;
                         left: 1080px;">
                        <div class="col-md-4">
                            <div class="card card-tale">
                                <div class="card-body">
                                    <a href="" style="; text-decoration: none"><p class="mb-4" style="color: black">Tổng tiền trong năm ${year} </p>
                                        <p class="fs-30 mb-2">${sum}</p>
                                    </a> 
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </c:if>

            <div class="container" >


                <canvas  id="MonthAllTotal"></canvas>
            </div>

        </c:if>
        <c:if test="${empty vectorReservationTotalOfMotnh}">



            <h2 class="tm-block-title text-center" style="font-size: 30px">Không có dữ liệu, vui lòng thử lại.</h2>

        </c:if>







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

        let month = [], totalMotnh = []
        <c:forEach items="${vectorReservationTotalOfMotnh}" var="v">

        month.push('${v.status}/${v.numberOfPerson}')
            totalMotnh.push(${v.total})


        </c:forEach>
            Chart.defaults.global.defaultFontColor = 'white';
            window.onload = function () {
                MonthAllTotal1("MonthAllTotal", month, totalMotnh);
            }
            function MonthAllTotal1(id, month, totalMotnh) {

                const data = {
                    labels: month,
                    datasets: [{
                            label: 'Thống kê doanh thu theo tháng',
                            data: totalMotnh,
                            backgroundColor: [
                                'rgb(255, 99, 132)',
                                'rgb(54, 162, 235)',
                                'rgb(255, 205, 86)',
                                'rgb(201, 203, 207)',
                                'rgb(60, 100, 25)',
                                'rgb(119 136 153)',
                                'rgb(198 226 255)',
                                'rgb(47 79 79)',
                                'rgb(151 255 255)',
                                'rgb(82 139 139)',
                                'rgb(139 69 19)',
                                'rgb(255 228 181)',
                                'rgb(205 133 63)',
                                'rgb(139 137 137)',
                                'rgb(240 255 255)',
                                'rgb(205 183 181)',
                                'rgb(65 105 225)',
                                'rgb(0 0 255)',
                                'rgb(70 130 180)',
                                'rgb(84 255 159)'
                            ],
                            borderColor: 'rgb(84 255 159)',
                            hoverOffset: 4
                        }]
                };
                const config = {
                    type: 'bar',
                    data: data,
                };
                let c = document.getElementById(id).getContext("2d")
                new Chart(c, config)
            }




    </script>


</body>
</html>
