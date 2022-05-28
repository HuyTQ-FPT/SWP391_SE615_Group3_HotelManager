<%-- 
    Document   : Login
    Created on : Feb 26, 2022, 1:34:33 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        *{
            padding: 0px;
            margin: 0px;
            box-sizing: border-box;
        }
        body{
            background-image: url(images/hero_1.jpg);
            background-repeat: no-repeat;
            background-size: cover;
            
        }

        .card{
            border-radius: 10px;
            padding: 30px;
            background: rgba(255,255,255,0.86);
            position: fixed;
            top: -60px;
            left: 650px;
            transform: scale(1.8);
            margin-top: 300px;
            color: #286D6B;
            height: fit-content;
            width: fit-content;
            cursor: pointer;
        }
        .logo p{
            width: fit-content;
            font-size: 30px;
            box-shadow: 0px 0px 1px 1px rgb(31, 30, 8);
            padding-bottom: 4px;
            margin-bottom: 30px;
        }
        .logo p:hover{
            font-weight: bold;
        }
        .username{
            display: flex;
            border-bottom: 1px solid green;
            padding: 5px;
        }
        .password{
            display: flex;
            padding: 5px;
            border-bottom: 1px solid green;
        }
        .username input{
            margin-left: 10px;
            border: none;
            background: none;
            outline: none;
            color: #1C566A;
        }
        input :-ms-input-placeholder{
            color: rgb(224, 20, 20);
        }
        .password input{
            margin-left: 10px;
            border: none;
            background: none;
            outline: none;
            color: #1C566A;
        }
        .sign_in button{
            margin-top: 30px;
            width: 100%;
            border: 1px solid rgb(7, 139, 247);
            outline: none;
            background: none;
            color: white;
            height: 30px;
            font-size: 18px;
            background-color: #0B1218;
            cursor: pointer;
            transition: 0.2s;
            opacity: 0.8;
        }
        .sign_in button:hover{
            opacity: 0.6;
            box-shadow: 0px 0px 1px 2px white;
            font-size: 17px;
        }

    </style>
    <body>
        
        
        
        <form action="ControllerLogin?do=CheckLogin" method="post">
            <div class="card">
                <div class="logo">
                    <p>Login</p>
                </div>
                <div class="username">
                    <i class='bx bxs-user'></i>
                    <input name="username" type="text" placeholder="username" value="">
                </div>
                <div class="password">
                    <i class='bx bxs-lock-alt'></i>
                    <input name="password" type="password" placeholder="password" value="">
                </div>
                <br>
                <h4 id="er" style="color: white;font-size: 10px; position: fixed;">${requestScope.error}</h4>
                <div class="sign_in">
                    <button type="submit" name="sign_in">Sign in</button>
                </div>
            </div>
        </form>       
    </body>
    
    
</html>
