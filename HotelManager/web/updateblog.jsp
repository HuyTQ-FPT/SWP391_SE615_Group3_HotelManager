<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Add Product - Dashboard HTML Template</title>
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
                                <h2 class="tm-block-title d-inline-block">Cập nhật thông tin</h2>             
                            </div>
                        </div>



                        <div class="row tm-edit-product-row">
                            <div class="col-xl-6 col-lg-6 col-md-12">
                                <form action="ImageController?do=changeImgae5" method="post" enctype="multipart/form-data" >

                                    <c:forEach items="${b}" var="c">
                                        <div class="form-group mb-3">
                                            <label
                                                for="name"
                                                >BlogTitle
                                            </label>
                                            <input
                                                id="name"
                                                name="title"
                                                value="${c.blogTitleString}"
                                                type="text"
                                                class="form-control validate"
                                                required
                                                />
                                        </div>



                                        <div class="form-group mb-3">
                                            <label
                                                for="name"
                                                >Date
                                            </label>
                                            <input
                                                id="name"
                                                name="date"
                                                type="text"
                                                value="${c.blogDate}"
                                                class="form-control validate"
                                                required
                                                />
                                        </div>

                                        <div class="form-group mb-3">
                                            <label
                                                for="description"
                                                >Description</label
                                            >
                                            <textarea 
                                                class="form-control validate"
                                                rows="3" name="description"

                                                required
                                                >${c.blogDescription}</textarea>
                                        </div>

                                        <div class="form-group mb-3">
                                            <label
                                                for="name"
                                                >Author
                                            </label>
                                            <input
                                                id="name"
                                                name="author"
                                                type="text"
                                                value="${c.blogAuthor}"
                                                class="form-control validate"
                                                required
                                                />

                                        </div>


                                </div>
                                <div class="tm-product-img-edit mx-auto">
                                    <img id="image" style="width: 350px;height: 250px" src="images/anhblog/${c.blogImage}" alt="" class="img-fluid d-block mx-auto">
                                    <i
                                        class="fas fa-cloud-upload-alt tm-upload-icon"
                                        onclick="document.getElementById('fileInput').click();"
                                        ></i>                                    
                                    <input
                                        id="name"
                                        name="Blogid"
                                        value="${c.blogID}"
                                        type="hidden"
                                        class="form-control validate"
                                        required
                                        >

                                    <div class="custom-file mt-1 mb-1">


                                        <input type="file" id="imageFile" onchange="chooseFile(this)" accept="image/gif,image/jpeg,image/png"
                                               class="form-control" name="photo" placeholder="Enter photo">
                                        <!--<input type="hidden" name="do" value="changeImgae" style="width: 200px; margin-top: 10px">-->

                                    </div>



                                </div>



                                <div class="col-12">
                                    <!--                            <input type="hidden" value="updatebloggg" name="do">
                                                                <input type="hidden" value="${c.blogID}" name="BlogID">-->
                                    <button type="submit" class="btn btn-primary btn-block text-uppercase" onclick="Delete()">Update</button>
                                </div>
                            </c:forEach>
                            </form>
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
