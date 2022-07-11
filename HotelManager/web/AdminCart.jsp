<%-- 
    Document   : editroomdevice
    Created on : Jun 8, 2022, 10:24:44 PM
    Author     : NTD
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="entity.Reservation"%>
<%@page import="java.util.Vector"%>
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
        <h1 style="text-align: center; color: wheat">Quản lí đặt phòng </h1>
        <a style="border-radius: 10px; float: right; margin-bottom: 10px" href="AddCart.jsp" class="btn btn-danger">Thêm mới đặt phòng </a>
         <form action="ControllerAdmin" method="get" style="margin-left: 20px">
                        <input type="hidden" name="do" value="sortByDate">
                        <input type="date" name="date1"> 
                        <span style="color: yellow; font-size: 20px"> To</span>
                    <input type="date" name="date2" > 
                    <input type="submit" name="Search" style="color: blue;" value="Search">
                    
                    </form>
        <table id="myTable" class="display table" width="90%">  
            <thead>  
                <tr>  
                    <th style="text-align: center">Tên</th>  
                    <th style="text-align: center">Hình ảnh</th>  
                    <th style="text-align: center">Tên khách hàng</th>  
                    <th style="text-align: center">Email</th>  
                    <th style="text-align: center">Địa chỉ</th>  
                    <th style="text-align: center">Số điện thoại</th>  
                    <th style="text-align: center">Số người đến</th>  
                    <th style="text-align: center">Ngày đến </th>  
                    <th style="text-align: center">Ngày đi</th>  
                    <th style="text-align: center">Tổng giá</th>  
                    <th style="text-align: center">Trạng thái</th>  
                    <th style="text-align: center">Ngày đặt hóa đơn</th>  
                    <th style="text-align: center">Update</th>  
                    <th style="text-align: center">Delete</th>  
                </tr>  
            </thead>  

            <tbody>  
                <% 
                    ResultSet rs =(ResultSet)request.getAttribute("rs");
                    while(rs.next()){
                %>
                    <tr style="background-color: 435C70" >  
                        <td style="background-color: 435C70 ;"><span class="badge badge-primary badge-pill"><%=rs.getString(1) %></span></td>  
                        <td style="background-color: 435C70 ; " ><img style="width: 150px; height: 100px" src="images/anhphong/<%=rs.getString(2)%>" class="img-thumbnail"></td>  
                        <td style="background-color: 435C70 ; padding-left: 20px;"><span class="d-inline-block text-truncate" style="max-width: 300px;"><%=rs.getString(3) %> </span></td>  
                        <td style="background-color: 435C70 ; font-style: inherit;text-align: center"><%=rs.getString(4) %></td>  
                        <td style="background-color: 435C70 ; text-align: center"><%=rs.getString(5) %></td> 
                        <td style="background-color: 435C70 ;text-align: center"><%=rs.getString(6) %></td>  
                        <td style="background-color: 435C70 ; text-align: center"><%=rs.getInt(7) %></td>  
                        <td style="background-color: 435C70 ; text-align: center"><%=rs.getString(8) %></td>  
                        <td style="background-color: 435C70 ; text-align: center"><%=rs.getString(9) %></td>  
                        <td style="background-color: 435C70 ; text-align: center"><%=rs.getString(10) %></td>  
                        <%if(rs.getInt(11)==1){%>
                        <td style="background-color: 435C70 ; text-align: center">Đang xử lí</td>  
                        <%} else if(rs.getInt(11)==2){%>
                        <td style="background-color: 435C70 ; text-align: center">Hoàn thành</td>  
                        <%}%>
                        <td style="background-color: 435C70 ; text-align: center"><%=rs.getString(12)%></td> 
                        <td style="background-color: 435C70 " ><a style="border-radius: 10px;" href="OrderController?do=ShowUpdateCartAdmin&id=<%=rs.getInt(14)%>" class="btn btn-info" role="button">Cập nhật hoá đơn</a></td>  
                        <td style="background-color: 435C70">
                            <a style="margin-left: 20px" href="OrderController?do=delete&id=<%=rs.getInt(14) %>" onclick="Delete()" class="tm-product-delete-link">
                                <i class="far fa-trash-alt tm-product-delete-icon">
                                </i></a></td>  
                    </tr>  

                <%}%>
            </tbody>  
        </table>  
            
        <footer class="tm-footer row tm-mt-small">
            <div class="col-12 font-weight-light">
              
            </div>
        </footer>
        <script>
            function Delete(){
            alert("Delete Succesfully!");      
        }
        </script>
    </body>
</html>

