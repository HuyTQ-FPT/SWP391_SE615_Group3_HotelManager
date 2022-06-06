
<%@page import="Entity.User"%>
<%@page import="java.util.Vector"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Admin</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/style_3.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
            body {
                color: #566787;
                background: #f5f5f5;
                font-family: 'Roboto', sans-serif;
                position: relative;
            }
            .table-responsive {
                margin: 30px 0;
            }
            .table-wrapper {
                min-width: 1000px;
                background: #fff;
                padding: 20px;
                box-shadow: 0 1px 1px rgba(0,0,0,.05);
            }
            .table-title {
                padding-bottom: 10px;
                margin: 0 0 10px;
                min-width: 100%;
            }
            .table-title h2 {
                margin: 8px 0 0;
                font-size: 22px;
            }
            .search-box {
                position: relative;        
                float: right;
            }
            .search-box input {
                height: 34px;
                border-radius: 20px;
                padding-left: 35px;
                border-color: #ddd;
                box-shadow: none;
            }
            .search-box input:focus {
                border-color: #3FBAE4;
            }
            .search-box i {
                color: #a0a5b1;
                position: absolute;
                font-size: 19px;
                top: 8px;
                left: 10px;
            }
            table.table tr th, table.table tr td {
                border-color: #e9e9e9;
            }
            table.table-striped tbody tr:nth-of-type(odd) {
                background-color: #fcfcfc;
            }
            table.table-striped.table-hover tbody tr:hover {
                background: #f5f5f5;
            }
            table.table th i {
                font-size: 13px;
                margin: 0 5px;
                cursor: pointer;
            }
            table.table td:last-child {
                width: 130px;
            }
            table.table td a {
                color: #a0a5b1;
                display: inline-block;
                margin: 0 5px;
            }
            table.table td a.view {
                color: #03A9F4;
            }
            table.table td a.edit {
                color: #FFC107;
            }
            table.table td a.delete {
                color: #E34724;
            }
            table.table td i {
                font-size: 19px;
            }    
            .pagination {
                float: right;
                margin: 0 0 5px;
            }
            .pagination li a {
                border: none;
                font-size: 95%;
                width: 30px;
                height: 30px;
                color: #999;
                margin: 0 2px;
                line-height: 30px;
                border-radius: 30px !important;
                text-align: center;
                padding: 0;
            }
            .pagination li a:hover {
                color: #666;
            }	
            .pagination li.active a {
                background: #03A9F4;
            }
            .pagination li.active a:hover {        
                background: #0397d6;
            }
            .pagination li.disabled i {
                color: #ccc;
            }
            .pagination li i {
                font-size: 16px;
                padding-top: 6px
            }
            .hint-text {
                float: left;
                margin-top: 6px;
                font-size: 95%;
            }
            .selectStatus{
                position: absolute;
                top:20px;
                right: 20px;
            }
            .managerPro{
                position: absolute;
                top:10px;
                left:10px;
                color: black;
                text-decoration: underline;
                list-style: circle inside;
            }
            .managerCus{
                position: absolute;
                top:45px;
                left:10px;
                color: black;
                text-decoration: underline;
                list-style: circle inside;
            }
            .title{
                font-size: 13px;
            }
            .name{
                font-size: 13px;
            }
            /*            .table-wrapper{
                            margin-left: 50px;
                        }*/
            .log-out{
                border-radius: 5px;
                background-color: #F1BC31;
                margin-right: 20px;
            }
            .log-out:hover{
                transform: scale(0.98);
            }
        </style>
    </head>
    <body>
        <%
            Vector<User> vector = (Vector<User>) request.getAttribute("vectorU");
        %>
        <!--        <div class="col-sm-8"><a class="managerPro" href="ControllerOrder"><h5>OrderList Manager</h5></a></div>
                <div class="col-sm-8"><a class="managerCus" href="ControllerProduct"><h5>Products Manager</h5></a></div>-->
        <section class="ftco-section">
            <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
                <div class="container">
                    <span class="admin"></i>Admin</span>
                    <form action="ControllerLogin_Admin?do=logout" method="post">
                        <button type="submit" name="log-out" class="log-out">Log Out</button>
                    </form>
                    <form action="ControllerCustomer?do=listAllCustomer" class="searchform order-lg-last" method="post">
                        <div class="form-group d-flex">
                            <input name="cusid" type="text" class="form-control pl-3" placeholder="SearchCustomerID">
                            <button type="submit" placeholder="" class="form-control search"><span class="fa fa-search"></span></button>
                        </div>
                    </form>
                    <div class="collapse navbar-collapse" id="ftco-nav">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item "><a href="ControllerProduct" class="nav-link">Manager<br>Products</a></li>
                            <li class="nav-item"><a href="ControllerOrder" class="nav-link">Manager<br>ListOrders</a></li>
                            <li class="nav-item active"><a href="ControllerCustomer" class="nav-link">Manager<br>Customers</a></li>
                        </ul>
                    </div>
                </div>
            </nav>

        </section>
        <div class="table-wrapper">
            <table class="table table-striped table-hover table-bordered" style="Margin-left:10px;"> 
                <thead>
                    <tr class="title" >
                        <th>UserID</th>
                        <th>AccountID</th>
                        <th>UserName</th>
                        <th>UserPhone</th>
                        <th>UserEmail</th>
                        <th>UserGender</th>
                    
                        <th>CMT</th>
                   

                    </tr>
                </thead>
                <tbody>      
                    <%for (User u : vector) {%>



                    <tr class="name">
                        <td><%= u.getUserID()%></td>
                        <td><%=u.getAccountID()%></td>
                        <td><%=u.getUserName()%></td>
                        <td><%=u.getUserPhone()%></td>
                        <td><%=u.getUserEmail()%></td>
                        <td><%=u.getUserGender()%></td>
                      
                        <td><%=u.getCMT()%></td>
                  

                        <td style="width:100px;">
                            <!--<a href="ControllerOrder?do=Orderdetail&oid=&status=" class="view" title="insert" data-toggle="tooltip"><i class="material-icons">add_circle</i></a>-->
                            <a href="ControllerCustomer?do=updateCustomer&UserID=<%=u.getUserID()%>" class="edit" title="Update" data-toggle="tooltip"><i class="material-icons">&#xE254;</i></a>
                            <!--<a href="ControllerCustomer?do=deleteCustomer&idcus=" class="delete" title="Delete" data-toggle="tooltip"><i class="material-icons">&#xE872;</i></a>-->
                        </td>                        
                    </tr> 

                    <%}%>
                </tbody>
            </table>
        </div> 
    </body>
</html>