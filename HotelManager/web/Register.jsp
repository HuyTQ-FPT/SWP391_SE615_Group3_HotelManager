<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html lang="en">
    
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form by Colorlib</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style_2_1.css">
</head>
<style>
    
</style>
<body>

    <div class="main">

        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <form action="LoginController?do=CheckRegister" method="post" id="signup-form" class="signup-form">
                        <h2 class="form-title">Create account</h2>
                        <div class="form-group">
                            <input type="text" class="form-input" name="name" id="name" placeholder="NameID"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input" name="username" placeholder="Username"/>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-input" name="email" placeholder="Email"/>
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-input" name="password" id="password" placeholder="Password"/>
                            <span toggle="#password" class="zmdi zmdi-eye field-icon toggle-password"></span>
                        </div>
                        <div class="form-group lastt">
                            <input type="password" class="form-input" name="re_password" id="re_password" placeholder="Repeat your password"/>
                            <div>
                                <h4 id="er" class="er" style="color: red;font-size: 13px;">${requestScope.errorpass}</h4>
                                <h4 id="er" class="er" style="color: red;font-size: 13px;">${requestScope.error}</h4>
                            </div>        
                        </div>
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Sign up"/>
                        </div>                       
                    </form>
                    <p class="loginhere">
                        Have already an account ? <a href="LoginController?do=ForgetPassword" class="loginhere-link">Quên mật khẩu</a>
                    </p>
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>