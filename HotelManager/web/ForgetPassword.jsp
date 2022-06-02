<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Forget Password</title>

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
                        <form action="LoginController?do=ForgetPassword" method="post" id="signup-form" class="signup-form">
                            <h2 class="form-title">Forget Password</h2>
                               <h4 id="er" style="color: red;font-size: 15px;">${requestScope.error}</h4>
                               <h4 id="er" style="color: red;font-size: 15px;">${requestScope.mess}</h4>
                            <div class="form-group">
                                <input type="text" class="form-input" name="name" id="name" placeholder="Username" required/>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-input" name="email" placeholder="Email" required/>
                            </div>
                            <div class="form-group">
                                <input type="submit" name="submit" id="submit" class="form-submit" value="Submit"/>
                            </div>                       
                        </form>
                        <p class="loginhere">
                            Have already an account ? <a href="LoginController" class="loginhere-link">Login here</a>
                        </p>
                    </div>
                </div>
            </section>

        </div>

        <!-- JS -->
    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>